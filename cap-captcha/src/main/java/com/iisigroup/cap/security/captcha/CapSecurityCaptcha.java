package com.iisigroup.cap.security.captcha;

import java.awt.image.BufferedImage;
import java.util.EnumSet;
import java.util.List;

import com.iisigroup.cap.utils.CapString;

import nl.captcha.Captcha;
import nl.captcha.Captcha.Builder;
import nl.captcha.backgrounds.BackgroundProducer;
import nl.captcha.gimpy.GimpyRenderer;
import nl.captcha.noise.NoiseProducer;
import nl.captcha.text.producer.TextProducer;
import nl.captcha.text.renderer.WordRenderer;

/**
 * <pre>
 * Cap Security captcha image generate
 * </pre>
 * 
 * @since 2012/10/19
 * @author rodeschen
 * @version <ul>
 *          <li>2013/3/13,rodeschen,new
 *          </ul>
 */
public class CapSecurityCaptcha {

    private int height;
    private int width;
    private boolean border;
    private Captcha captcha;
    private WordRenderer wordRenderer;
    private List<Object> producers;
    private TextProducer textProducer;
    private long timeout;
    private String errorMessage;

    /**
     * @param height
     *            the height to set
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * @param width
     *            the width to set
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * @param textProducer
     *            the textProducer to set
     */
    public void setTextProducer(TextProducer textProducer) {
        this.textProducer = textProducer;
    }

    /**
     * @param wordRenderer
     *            the wordRenderer to set
     */
    public void setWordRenderer(WordRenderer wordRenderer) {
        this.wordRenderer = wordRenderer;
    }

    /**
     * @return the addBorder
     */
    public boolean isBorder() {
        return border;
    }

    /**
     * @param addBorder
     *            the addBorder to set
     */
    public void setBorder(boolean border) {
        this.border = border;
    }

    /**
     * @param producers
     *            the producers to set
     */
    public void setProducers(List<Object> producers) {
        this.producers = producers;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    /**
     * @param timeout
     *            the timeout to set
     */
    public void setTimeout(long timeout) {
        this.timeout = timeout;
    }

    public BufferedImage crateImage() {
        Builder captcha = new Captcha.Builder(width, height);
        if (this.wordRenderer == null) {
            captcha.addText(textProducer);
        } else {
            captcha.addText(textProducer, this.wordRenderer);
        }

        if (producers != null && !producers.isEmpty()) {
            for (Object producer : producers) {
                if (producer instanceof BackgroundProducer) {
                    captcha.addBackground((BackgroundProducer) producer);
                } else if (producer instanceof GimpyRenderer) {
                    captcha.gimp((GimpyRenderer) producer);
                } else if (producer instanceof NoiseProducer) {
                    captcha.addNoise((NoiseProducer) producer);
                }

            }
        }
        if (isBorder()) {
            captcha.addBorder();
        }
        this.captcha = captcha.build();

        return captcha.build().getImage();
    }

    public CaptchaStatus valid(String answer) {
        CaptchaStatus status = CaptchaStatus.FAIL;
        if (this.captcha != null && !CapString.isEmpty(answer)) {
            if ((System.currentTimeMillis() - this.captcha.getTimeStamp().getTime()) > timeout) {
                status = CaptchaStatus.TIMEOUT;
            } else {
                status = this.captcha.getAnswer().toLowerCase().equals(answer.toLowerCase()) ? CaptchaStatus.SUCCESS : CaptchaStatus.FAIL;
            }
        }
        this.captcha = null;
        return status;
    }

    public static enum CaptchaStatus {
        // 成功
        SUCCESS("01"),
        // 失敗
        FAIL("02"),
        // 超時
        TIMEOUT("03");

        private String code;

        CaptchaStatus(String code) {
            this.code = code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }

        public static CaptchaStatus getByCode(String code) {
            CaptchaStatus returnValue = null;
            for (final CaptchaStatus element : EnumSet.allOf(CaptchaStatus.class)) {
                if (element.getCode().equals(code)) {
                    returnValue = element;
                    break;
                }
            }
            return returnValue;
        }
    }

}