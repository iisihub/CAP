package com.iisigroup.cap.base.service.impl;

import java.lang.management.MemoryUsage;
import java.lang.ref.SoftReference;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.iisigroup.cap.base.dao.ErrorCodeDao;
import com.iisigroup.cap.base.model.ErrorCode;
import com.iisigroup.cap.base.service.ErrorCodeService;
import com.iisigroup.cap.exception.CapException;
import com.iisigroup.cap.utils.CapBeanUtil;
import com.iisigroup.cap.utils.CapString;
import com.iisigroup.cap.utils.ManagementUtil;

/**
 * <pre>
 * 訊息代碼表
 * </pre>
 *
 * @since 2012/03/29
 * @author UFOJ
 * @version
 *          <ul>
 *          <li>2012/03/29,UFO,new
 *          </ul>
 */
@Service("errorCodeService")
public class ErrorCodeServiceImpl implements ErrorCodeService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ErrorCodeServiceImpl.class);

    @Resource
    ErrorCodeDao errorCodeDao;

    private SoftReferenceCache<String, ErrorCode> errorCodeCache = new SoftReferenceCache<String, ErrorCode>();

    private boolean cacheMode = true;

    /*
     * (non-Javadoc)
     *
     * @see com.mega.sso.service.BranchService#reload()
     */
    @PostConstruct
    @Override
    public synchronized void reload() {
        long t1 = System.currentTimeMillis();
        MemoryUsage heap1 = ManagementUtil.getCurrentMemUsage();

        errorCodeCache.clear();
        List<ErrorCode> list = errorCodeDao.findByAll();
        for (ErrorCode origin : list) {
            ErrorCode targe = new ErrorCode();
            try {
                CapBeanUtil.copyBean(origin, targe);
                errorCodeCache.put(getCacheKey(origin.getCode(), origin.getLocale()), targe);
            } catch (CapException ex) {
                LOGGER.info("[reload] EXCEPTION!", ex);
            }
        }
        LOGGER.info("[reload] ErrorCodeCache size={} ", errorCodeCache.size());
        LOGGER.info("[reload] {}", ManagementUtil.formatHeapMemoryUsage(heap1, ManagementUtil.getCurrentMemUsage()));
        LOGGER.info("[reload] TOTAL COST= {} ms ", (System.currentTimeMillis() - t1));

    }

    /**
     * get the cache key name
     *
     * @param code
     *            the error code
     * @param locale
     *            the locale value
     * @return key
     */
    private String getCacheKey(String code, String locale) {
        return CapString.concat(StringUtils.trimToEmpty(code), ".", StringUtils.trimToEmpty(locale));
    }

    @Override
    public void save(ErrorCode model) {
        errorCodeDao.save(model);
    }

    /**
     * get the errorcode by code and locale
     *
     * @param code
     *            代碼類型
     * @param locale
     *            語言別
     * @return Map
     *
     */
    @Override
    public ErrorCode getErrorCode(String code, String locale) {
        ErrorCode errorCode = errorCodeCache.get(this.getCacheKey(code, locale));

        if (errorCode == null) {
            LOGGER.warn("[getErrorCode]!!! GET_ERRORCODE_FROM_DB !!!");
            errorCode = errorCodeDao.findByCode(code, locale);

            if (cacheMode) {
                errorCodeCache.put(this.getCacheKey(code, locale), errorCode);
            }
        }

        return errorCode;
    }

    @Override
    public List<ErrorCode> getErrorCodeListBySysId(String sysId, String locale) {
        return errorCodeDao.findListBySysId(sysId, locale);
    }

    /**
     * @param codeDao
     *            the codeDao to set
     */
    public void setErrorCodeDao(ErrorCodeDao codeDao) {
        this.errorCodeDao = codeDao;
    }

    private class SoftReferenceCache<K extends Comparable<K>, V> {
        protected Map<K, SoftReference<V>> map = new ConcurrentHashMap<K, SoftReference<V>>();

        public V get(K key) {
            V result = null;
            SoftReference<V> softRef = map.get(key);
            if (softRef != null) {
                result = softRef.get();
                if (result == null) {
                    map.remove(key);
                }
            }
            return result;
        }

        public void put(K key, V value) {
            map.put(key, new SoftReference<V>(value));
        }

        public int size() {
            return map.size();
        }

        public synchronized void clear() {
            this.map.clear();
        }
    }

}
