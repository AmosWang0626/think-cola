package com.amos.think.common.util;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

/**
 * 日期工具类
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2020/11/28
 */
public class DateUtils {

    private static final ZoneOffset ZONE_OFFSET = ZoneOffset.of("+8");
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final DateTimeFormatter SIMPLE_DATE_FORMAT = DateTimeFormatter.ofPattern("yyyyMMdd");
    private static final DateTimeFormatter DATE_TIME_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private static final DateTimeFormatter SIMPLE_DATE_TIME_FORMAT = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");


    public static Long toTimeMillis(LocalDateTime localDateTime) {

        return localDateTime.toInstant(ZONE_OFFSET).toEpochMilli();
    }

    public static String getDate(LocalDate localDate) {

        return localDate.format(SIMPLE_DATE_FORMAT);
    }

    public static String toString(LocalDate localDate) {

        return localDate.format(DATE_FORMAT);
    }

    public static String toString(LocalDateTime localDateTime) {

        return localDateTime.format(DATE_TIME_FORMAT);
    }

    public static String toStringSimple(LocalDateTime localDateTime) {

        return localDateTime.format(SIMPLE_DATE_TIME_FORMAT);
    }

    public static String toString(Long timeMillis) {

        return toString(Instant.ofEpochMilli(timeMillis).atOffset(ZONE_OFFSET).toLocalDateTime());
    }

    public static long getTimeSecond() {
        return Instant.now().getEpochSecond();
    }

}
