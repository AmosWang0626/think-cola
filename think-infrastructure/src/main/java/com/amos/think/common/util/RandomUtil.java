package com.amos.think.common.util;

import java.util.Random;

/**
 * 随机码生成util
 *
 * @author Amos
 */
public class RandomUtil {

    private static final String ALL_CHAR = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LETTER_CHAR = "abcdefghijkllmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String NUMBER_CHAR = "0123456789";

    /**
     * 返回一个定长的随机字符串(只包含大小写字母、数字)
     *
     * @param length 随机串长度
     * @return 随机字符串
     */
    public static String generateString(int length) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            sb.append(ALL_CHAR.charAt(random.nextInt(ALL_CHAR.length())));
        }
        return sb.toString();
    }

    /**
     * 返回一个定长的随机纯字母字符串(只包含大小写字母)
     *
     * @param length 随机串长度
     * @return 随机字符串
     */
    public static String generateLetterString(int length) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            sb.append(LETTER_CHAR.charAt(random.nextInt(LETTER_CHAR.length())));
        }
        return sb.toString();
    }

    /**
     * 返回一个定长的随机數字字符串(只包含数字)
     *
     * @param length 随机串长度
     * @return 随机字符串
     */
    public static String generateNumberString(int length) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            sb.append(NUMBER_CHAR.charAt(random.nextInt(NUMBER_CHAR.length())));
        }
        return sb.toString();
    }

    /**
     * 返回一个定长的随机纯大写字母字符串(只包含小写字母)
     *
     * @param length 随机串长度
     * @return 随机字符串
     */
    public static String generateLowerString(int length) {
        return generateLetterString(length).toLowerCase();
    }

    /**
     * 返回一个定长的随机纯小写字母字符串(只包含大写字母)
     *
     * @param length 随机串长度
     * @return 随机字符串
     */
    public static String generateUpperString(int length) {
        return generateLetterString(length).toUpperCase();
    }

    /**
     * 生成一个定长的纯0字符串
     *
     * @param length 随机串长度
     * @return 纯0字符串
     */
    public static String generateZeroString(int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append('0');
        }
        return sb.toString();
    }

    /**
     * 根据数字生成一个定长的字符串，长度不够前面补0
     *
     * @param number      数字
     * @param fixedLength 字符串长度
     * @return 定长的字符串
     */
    public static String toFixedLengthString(long number, int fixedLength) {
        StringBuilder sb = new StringBuilder();
        String strNum = String.valueOf(number);
        if (fixedLength - strNum.length() >= 0) {
            sb.append(generateZeroString(fixedLength - strNum.length()));
        } else {
            throw new RuntimeException("将数字" + number + "转化为长度为" + fixedLength + "的字符串发生异常!");
        }
        sb.append(strNum);
        return sb.toString();
    }
}