package com.quyeying.framework.spring.converter;

import org.apache.commons.lang3.StringUtils;
import org.springframework.core.convert.converter.Converter;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * User: bysun
 * Date: 2014/5/28 0028
 * Time: 13:20
 * Timestamp 类型转换器
 */
public class TimestampConverter implements Converter<String, Timestamp> {

    public static final String HH_BATCH_PATTERN = "yyyy-MM-dd HH:mm:ss";
    public static final String BATCH_PATTERN = "yyyy-MM-dd";
    private final static SimpleDateFormat datetime = new SimpleDateFormat(HH_BATCH_PATTERN);
    private final static SimpleDateFormat date = new SimpleDateFormat(BATCH_PATTERN);

    @Override
    public Timestamp convert(String text) {

        if (StringUtils.isBlank(text)) {
            return null;
        }

        text = text.trim();

        if (text.matches("^\\d+$")) {
            long time = Long.valueOf(text);
            return new Timestamp(time);
        } else if (text.matches("^\\d{4}\\-\\d{2}\\-\\d{2} \\d{2}\\:\\d{2}\\:\\d{2}$")) {
            try {
                return new Timestamp(this.datetime.parse(text).getTime());
            } catch (ParseException e) {
                throw new IllegalArgumentException("Could not parse date: " + e.getMessage(), e);
            }
        } else if (text.matches("^\\d{4}\\-\\d{2}\\-\\d{2}$")) {
            try {
                return new Timestamp(this.date.parse(text).getTime());
            } catch (ParseException e) {
                throw new IllegalArgumentException("Could not parse date: " + e.getMessage(), e);
            }
        } else {
            throw new IllegalArgumentException("Could not parse date: " + text);
        }
    }
}
