package com.soft1851.springboot.jwt.util;


import java.security.MessageDigest;

/**
 * @author Zeng
 * @ClassName SaltUtil
 * @Description TOOD
 * @Date 2020/4/15
 * @Version 1.0
 **/
public class SaltUtil {
    /**
     * 获取十六进制字符串形式的MD5摘要
     */
    public static String md5Hex(String src) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] bs = md5.digest(src.getBytes());
            return byteToHex(bs);
        } catch (Exception e) {
            return null;
        }
    }


    /**
     * byte数组转hex
     * @param bytes
     * @return
     */
    public static String byteToHex(byte[] bytes){
        String strHex = "";
        StringBuilder sb = new StringBuilder("");
        for (int n = 0; n < bytes.length; n++) {
            strHex = Integer.toHexString(bytes[n] & 0xFF);
            // 每个字节由两个字符表示，位数不够，高位补0
            sb.append((strHex.length() == 1) ? "0" + strHex : strHex);
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println(SaltUtil.md5Hex("mySecret"));
    }
}
