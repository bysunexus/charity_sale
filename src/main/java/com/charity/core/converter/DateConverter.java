package com.charity.core.converter;

import org.apache.commons.lang3.StringUtils;
import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * spring 日期-字符串 转换类
 */
public class DateConverter implements Converter<String, Date> {
    public static final String HH_BATCH_PATTERN = "yyyy-MM-dd HH:mm:ss";
    public static final String BATCH_PATTERN = "yyyy-MM-dd";
    private final static SimpleDateFormat datetime = new SimpleDateFormat(HH_BATCH_PATTERN);
    private final static SimpleDateFormat date = new SimpleDateFormat(BATCH_PATTERN);

    @Override
    public Date convert(String text) {

        if (StringUtils.isBlank(text)) {
            return null;
        }

        text = text.trim();

        if (text.matches("^\\d+$")) {
            long time = Long.valueOf(text);
            return new Date(time);
        } else if (text.matches("^\\d{4}\\-\\d{2}\\-\\d{2} \\d{2}\\:\\d{2}\\:\\d{2}$")) {
            try {
                return new Date(this.datetime.parse(text).getTime());
            } catch (ParseException e) {
                throw new IllegalArgumentException("Could not parse date: " + e.getMessage(), e);
            }
        } else if (text.matches("^\\d{4}\\-\\d{2}\\-\\d{2}$")) {
            try {
                return new Date(this.date.parse(text).getTime());
            } catch (ParseException e) {
                throw new IllegalArgumentException("Could not parse date: " + e.getMessage(), e);
            }
        } else {
            throw new IllegalArgumentException("Could not parse date: " + text);
        }
    }
}
