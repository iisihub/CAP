package com.iisigroup.cap.linebot.service.impl;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.iisigroup.cap.db.dao.SearchSetting;
import com.iisigroup.cap.db.model.Page;
import com.iisigroup.cap.linebot.client.LineResource;
import com.iisigroup.cap.linebot.dao.LineContactDao;
import com.iisigroup.cap.linebot.model.LineContact;
import com.iisigroup.cap.linebot.service.LineMessageService;
import com.iisigroup.cap.utils.CapDate;
import com.linecorp.bot.client.exception.LineBotAPIException;
import com.linecorp.bot.model.callback.CallbackRequest;
import com.linecorp.bot.model.callback.Event;
import com.linecorp.bot.model.content.AbstractContent;
import com.linecorp.bot.model.content.AbstractOperation;
import com.linecorp.bot.model.content.AddedAsFriendOperation;
import com.linecorp.bot.model.content.AudioContent;
import com.linecorp.bot.model.content.BlockedOperation;
import com.linecorp.bot.model.content.ContactContent;
import com.linecorp.bot.model.content.ContentType;
import com.linecorp.bot.model.content.ImageContent;
import com.linecorp.bot.model.content.LocationContent;
import com.linecorp.bot.model.content.LocationContentLocation;
import com.linecorp.bot.model.content.OpType;
import com.linecorp.bot.model.content.RecipientType;
import com.linecorp.bot.model.content.RichMessageContent;
import com.linecorp.bot.model.content.StickerContent;
import com.linecorp.bot.model.content.TextContent;
import com.linecorp.bot.model.content.VideoContent;
import com.linecorp.bot.model.content.metadata.AudioContentMetadata;
import com.linecorp.bot.model.content.metadata.ContactContentMetadata;
import com.linecorp.bot.model.content.metadata.StickerContentMetadata;
import com.linecorp.bot.model.profile.UserProfileResponse;
import com.linecorp.bot.model.profile.UserProfileResponseContact;

@Service
public class LineMessageServiceImpl implements LineMessageService {

    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Resource
    private LineContactDao lineContactDao;

    @Override
    public void processRequest(byte[] req) {
        try {
            CallbackRequest request = LineResource.getLineBotClient().readCallbackRequest(req);
            List<Event> events = request.getResult();
            for (Event event : events) {
                switch (event.getEventType()) {
                case Message:
                    AbstractContent content = (AbstractContent) event.getContent();
                    if (content instanceof AudioContent) {
                        processContent((AudioContent) content);
                    } else if (content instanceof ContactContent) {
                        processContent((ContactContent) content);
                    } else if (content instanceof ImageContent) {
                        processContent((ImageContent) content);
                    } else if (content instanceof LocationContent) {
                        processContent((LocationContent) content);
                    } else if (content instanceof RichMessageContent) {
                        processContent((RichMessageContent) content);
                    } else if (content instanceof StickerContent) {
                        processContent((StickerContent) content);
                    } else if (content instanceof TextContent) {
                        processContent((TextContent) content);
                    } else if (content instanceof VideoContent) {
                        processContent((VideoContent) content);
                    }
                    break;
                case Operation:
                    AbstractOperation operation = (AbstractOperation) event.getContent();
                    if (operation instanceof AddedAsFriendOperation) {
                        processOperation((AddedAsFriendOperation) operation);
                    } else if (operation instanceof BlockedOperation) {
                        processOperation((BlockedOperation) operation);
                    }
                    break;
                }
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }

    /**
     * 音訊內容處理
     * 
     * @param content
     * @throws Exception
     */
    private void processContent(AudioContent content) throws Exception {
        ContentType contentType = content.getContentType();
        String from = content.getFrom();
        String id = content.getId();
        RecipientType recipientType = content.getToType();
        AudioContentMetadata metadata = content.getContentMetadata();
        String url = content.getOriginalContentUrl();
        String logMsg = url + ", " + metadata.getAudlen() + "," + contentType.name() + ", " + from + ", " + id + ", " + recipientType.name();
        logger.debug("==== AudioContent: " + logMsg);
        // TODO
        sendMessage(from, logMsg);
    }

    /**
     * 聯絡人資訊訊息處理
     * 
     * @param content
     * @throws Exception
     */
    private void processContent(ContactContent content) throws Exception {
        ContentType contentType = content.getContentType();
        String from = content.getFrom();
        String id = content.getId();
        RecipientType recipientType = content.getToType();
        ContactContentMetadata metadata = content.getContentMetadata();
        String logMsg = metadata.getMid() + "," + contentType.name() + ", " + from + ", " + id + ", " + recipientType.name();
        logger.debug("==== ContactContent: " + logMsg);
        // TODO
        sendMessage(from, logMsg);
    }

    /**
     * 圖片訊息處理
     * 
     * @param content
     * @throws Exception
     */
    private void processContent(ImageContent content) throws Exception {
        ContentType contentType = content.getContentType();
        String from = content.getFrom();
        String id = content.getId();
        RecipientType recipientType = content.getToType();
        String preview = content.getPreviewImageUrl();
        String url = content.getOriginalContentUrl();
        String logMsg = url + ", " + preview + "," + contentType.name() + ", " + from + ", " + id + ", " + recipientType.name();
        logger.debug("==== ImageContent: " + logMsg);
        // TODO
        sendMessage(from, logMsg);
    }

    /**
     * 位置訊息處理
     * 
     * @param content
     * @throws Exception
     */
    private void processContent(LocationContent content) throws Exception {
        ContentType contentType = content.getContentType();
        String from = content.getFrom();
        String id = content.getId();
        RecipientType recipientType = content.getToType();
        LocationContentLocation location = content.getLocation();
        String text = content.getText();
        String logMsg = text + ", " + location.getTitle() + "," + location.getAddress() + ", " + location.getLatitude() + ", " + location.getLongitude() + ", " + contentType.name() + ", " + from
                + ", " + id + ", " + recipientType.name();
        logger.debug("==== LocationContent: " + logMsg);
        // TODO
        sendMessage(from, logMsg);
    }

    /**
     * API 規格中沒有提到
     * 
     * @param content
     * @throws Exception
     */
    private void processContent(RichMessageContent content) throws Exception {
        // TODO
    }

    /**
     * 貼圖？訊息處理
     * 
     * @param content
     * @throws Exception
     */
    private void processContent(StickerContent content) throws Exception {
        ContentType contentType = content.getContentType();
        String from = content.getFrom();
        String id = content.getId();
        RecipientType recipientType = content.getToType();
        StickerContentMetadata meta = content.getContentMetadata();
        String logMsg = meta.getStkid() + ", " + meta.getStkpkgid() + ", " + meta.getStktxt() + ", " + meta.getStkver() + "," + contentType.name() + ", " + from + ", " + id + ", "
                + recipientType.name();
        logger.debug("==== StickerContent: " + logMsg);
        // TODO
        sendMessage(from, logMsg);
    }

    private void processContent(TextContent content) throws Exception {
        ContentType contentType = content.getContentType();
        String from = content.getFrom();
        String id = content.getId();
        RecipientType recipientType = content.getToType();
        String text = content.getText();
        String logMsg = text + ", " + contentType.name() + ", " + from + ", " + id + ", " + recipientType.name();
        logger.debug("==== TextContent: " + logMsg);

        sendMessage(from, getTextResponse(text));
    }

    /**
     * 影片訊息處理
     * 
     * @param content
     * @throws Exception
     */
    private void processContent(VideoContent content) throws Exception {
        ContentType contentType = content.getContentType();
        String from = content.getFrom();
        String id = content.getId();
        RecipientType recipientType = content.getToType();
        String preview = content.getPreviewImageUrl();
        String url = content.getOriginalContentUrl();
        String logMsg = url + ", " + preview + "," + contentType.name() + ", " + from + ", " + id + ", " + recipientType.name();
        logger.debug("==== VideoContent: " + logMsg);
        // TODO
        sendMessage(from, logMsg);
    }

    private void processOperation(AddedAsFriendOperation operation) throws Exception {
        // 更新聯絡人加入好友的時間
        String mid = operation.getMid();
        OpType opType = operation.getOpType();
        long revision = operation.getRevision();
        logger.debug("==== AddedAsFriendOperation: " + mid + ", " + opType.name() + ", " + revision);
        // 回傳 Welcome 或服務訊息 (ex. 花旗傳送兩個連結，綁定 LINE 和申辦信用卡)
        String displayName = getDisplayNameByMid(operation.getMid(), true);
        String response = "歡迎您的加入" + (StringUtils.isBlank(displayName) ? "" : "，" + displayName) + "！";
        LineResource.getLineBotClient().sendText(operation.getMid(), response);
    }

    private void processOperation(BlockedOperation operation) throws Exception {
        // 更新聯絡人 Block 狀態
        String mid = operation.getMid();
        OpType opType = operation.getOpType();
        long revision = operation.getRevision();
        logger.debug("==== BlockedOperation: " + mid + ", " + opType.name() + ", " + revision);
        LineContact c = lineContactDao.findByMid(mid);
        c.setBlocked("1");
        c.setBlockedTime(CapDate.getCurrentTimestamp());
        lineContactDao.save(c);
    }

    /**
     * <pre>
     * 根據帶入的 mid 取得聯絡人資訊。
     * 推測當訊息傳入的 mid 是聊天室時，就會有多個聯絡人資訊。但是 BOT Trial 目前不支援群聊，所以原則上只會取到一個。
     * </pre>
     * 
     * @param mid
     *            訊息來源的 mid
     * @return
     */
    private List<UserProfileResponseContact> getUserProfileByMid(String mid, boolean add) {
        List<UserProfileResponseContact> contacts = new ArrayList<UserProfileResponseContact>();
        try {
            List<String> mids = new ArrayList<String>();
            mids.add(mid);
            UserProfileResponse upr = LineResource.getLineBotClient().getUserProfile(mids);
            contacts = upr.getContacts();
            Long count = upr.getCount();
            Long display = upr.getDisplay();
            Long start = upr.getStart();
            Long total = upr.getTotal();
            // TODO 紀錄訊息接收 log
            for (UserProfileResponseContact contact : contacts) {
                String diaplayName = contact.getDisplayName();
                String cmid = contact.getMid();
                String pictureUrl = contact.getPictureUrl();
                String statusMessage = contact.getStatusMessage();
                // 新增或更新聯絡人資訊
                LineContact c = lineContactDao.findByMid(cmid);
                if (c == null) {
                    c = new LineContact();
                    c.setMid(cmid);
                }
                // 判斷是否要更新頭像
                if (!StringUtils.isBlank(pictureUrl)) {
                    if (c.getPictureUrl() == null || !pictureUrl.equalsIgnoreCase(c.getPictureUrl()) || add) {
                        // update picture
                        String picture = getBase64ImageFromUrl(pictureUrl);
                        c.setPicture(picture);
                    }
                }
                c.setDiaplayName(diaplayName);
                c.setPictureUrl(pictureUrl);
                c.setStatusMessage(statusMessage);
                // 再次收到訊息
                c.setBlocked("0");
                c.setBlockedTime(null);
                if (add) {
                    c.setAddTime(CapDate.getCurrentTimestamp());
                }
                lineContactDao.save(c);
            }
        } catch (LineBotAPIException e) {
            logger.error(e.getMessage(), e);
        }
        return contacts;
    }

    /**
     * 根據傳入的 mid 取得 display name，如果取到多個聯絡人資訊(推測是聊天室)，回傳空值。
     * 
     * @param mid
     * @return
     */
    private String getDisplayNameByMid(String mid, boolean add) {
        String displayName = "";
        List<UserProfileResponseContact> contacts = getUserProfileByMid(mid, add);
        if (contacts.size() == 1) {
            displayName = contacts.get(0).getDisplayName();
        }
        return displayName;
    }

    /**
     * 根據傳入的訊息，回傳訊息。(目前只會 ECHO)
     * 
     * @param msg
     * @return
     */
    private String getTextResponse(String msg) {
        // TODO 還有發展的空間
        return msg;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.iisigroup.cap.linebot.service.LineMessageService#sendMessage(java.lang.String, java.lang.String)
     */
    @Override
    public void sendMessage(String from, String msg) throws Exception {
        String displayName = getDisplayNameByMid(from, false);
        String response = (StringUtils.isBlank(displayName) ? "" : "@" + displayName + "，") + msg;
        LineResource.getLineBotClient().sendText(from, response);
        logger.debug("send text to " + from + ": " + response);
    }

    private String getBase64ImageFromUrl(String imageUrl) {
        InputStream is = null;
        ByteArrayOutputStream baos = null;
        String result = null;
        try {
            URL url = new URL(imageUrl);
            is = url.openStream();
            baos = new ByteArrayOutputStream(5000);
            byte[] buf = new byte[2048];
            while (is.read(buf) != -1) {
                baos.write(buf);
            }
            byte[] data = baos.toByteArray();
            result = Base64.encodeBase64String(data);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(baos);
            IOUtils.closeQuietly(is);
        }
        return result;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.iisigroup.cap.linebot.service.LineMessageService#findLineContactForPage(com.iisigroup.cap.db.dao.SearchSetting)
     */
    @Override
    public Page<LineContact> findLineContactForPage(SearchSetting search) {
        return lineContactDao.findPage(search);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.iisigroup.cap.linebot.service.LineMessageService#retrive(java.lang.String)
     */
    @Override
    public void retrive(String mid) throws Exception {
        getUserProfileByMid(mid, true);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.iisigroup.cap.linebot.service.LineMessageService#broadcast(java.lang.String)
     */
    @Override
    public void broadcast(String msg) throws Exception {
        List<LineContact> list = lineContactDao.find(lineContactDao.createSearchTemplete());
        for (LineContact c : list) {
            try {
                logger.debug("will broadcast send text to " + c.getMid() + ": " + msg);
                LineResource.getLineBotClient().sendText(c.getMid(), "廣播訊息：" + msg);
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
            }
        }
    }

}
