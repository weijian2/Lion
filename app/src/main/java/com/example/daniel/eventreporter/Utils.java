package com.example.daniel.eventreporter;

/**
 * Created by daniel on 9/7/17.
 */

import org.apache.commons.codec.binary.Hex;

import java.nio.charset.Charset;
import java.security.MessageDigest;

/**
 * this class's function is to to encrypt password
 */
public class Utils {
    /**
     *
     * @param input string representation of password
     * @return hashcode of this password
     */
    public static String md5Encryption(final String input){
        String result = "";
        try{
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(input.getBytes(Charset.forName("UTF8")));
            byte[] resultByte = messageDigest.digest();
            result = new String(Hex.encodeHex(resultByte));
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return result;
    }
}
