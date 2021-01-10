package com.amos.think.common.util;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.security.SecureRandom;

/**
 * DES加密，对称加密算法，知道秘钥可以解密密文；
 * 密钥至少为8位字符，56位的密钥以及附加的 8位奇偶校验位，每组的第8位作为奇偶校验位；
 *
 * @author Daoyuan
 */
public class DesSecretUtil {

    private static final String[] HEX = new String[]{"0", "1", "2", "3", "4",
            "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};

    public static String encrypt(String sourceText, String keyString) {
        if (sourceText == null || sourceText.length() == 0) {
            return null;
        }
        try {
            // DES算法要求有一个可信任的随机数源
            Cipher cipher = getCipher(keyString, Cipher.ENCRYPT_MODE);
            byte[] data = sourceText.getBytes();
            // 加密
            byte[] encryptedData = cipher.doFinal(data);
            // 转成16进制串
            return bytes2HexStr(encryptedData);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String decrypt(String cipherText, String keyString) {
        if (cipherText == null || cipherText.length() == 0) {
            return null;
        }
        try {
            Cipher cipher = getCipher(keyString, Cipher.DECRYPT_MODE);
            // 将十六进制串转成字节数组
            byte[] data = hex2Byte(cipherText);
            // 解密
            byte[] decryptedData = cipher.doFinal(data);

            return new String(decryptedData);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static Cipher getCipher(String keyString, int decryptMode) throws Exception {
        // DES算法要求有一个可信任的随机数源
        SecureRandom sr = new SecureRandom();
        // 从原始密钥数据创建一个DESKeySpec对象
        DESKeySpec dks = new DESKeySpec(keyString.getBytes());
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        SecretKey key = keyFactory.generateSecret(dks);
        // Cipher对象实际完成解密操作
        Cipher cipher = Cipher.getInstance("DES");
        // 使用密钥初始化Cipher对象
        cipher.init(decryptMode, key, sr);
        return cipher;
    }

    /**
     * 十六进制字符串转换为字节数组
     */
    private static byte[] hex2Byte(String paramString) {
        int i = paramString.length() / 2;
        byte[] arrayOfByte = new byte[i];
        for (int j = 0; j < i; ++j) {
            int k = getHexValue(paramString.charAt(j * 2));
            int l = getHexValue(paramString.charAt(j * 2 + 1));
            arrayOfByte[j] = (byte) (k << 4 | l);
        }
        return arrayOfByte;
    }

    private static int getHexValue(char paramChar) {
        if ((paramChar >= MagicValueConstant.CHAT_ONE) && (paramChar <= MagicValueConstant.CHAT_NINE)) {
            return (paramChar - MagicValueConstant.CHAT_ONE);
        }
        if ((paramChar >= MagicValueConstant.CHAT_LOWER_A) && (paramChar <= MagicValueConstant.CHAT_LOWER_F)) {
            return (paramChar - MagicValueConstant.CHAT_LOWER_A + 10);
        }
        if ((paramChar >= MagicValueConstant.CHAT_UPPER_A) && (paramChar <= MagicValueConstant.CHAT_UPPER_F)) {
            return (paramChar - MagicValueConstant.CHAT_UPPER_A + 10);
        }
        throw new RuntimeException("invalid_char");
    }

    /**
     * 字节数组转换为十六进制字符串，效果与byte2Hex一样，随便选哪一个方法
     */
    private static String bytes2HexStr(byte[] bytes) {
        StringBuilder buffer = new StringBuilder(bytes.length * 2);
        for (byte b : bytes) {
            buffer.append(byte2HexStr(b));
        }
        return buffer.toString();
    }

    private static String byte2HexStr(byte b) {
        return HEX[(b & 0xf0) >> 4] + HEX[b & 0x0f];
    }

}