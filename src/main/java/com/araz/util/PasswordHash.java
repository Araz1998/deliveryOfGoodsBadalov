package com.araz.util;

import org.apache.log4j.Logger;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class PasswordHash {

    Logger log = Logger.getLogger(PasswordHash.class);

    private static final PasswordHash instance = new PasswordHash();

    private PasswordHash(){}

    public static PasswordHash getInstance(){
        return instance;
    }

    public  String hash(String password)  {
        StringBuilder sb = new StringBuilder();
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
            byte[] hashInByte = md.digest(password.getBytes(StandardCharsets.UTF_8));
            for (byte b : hashInByte){
                sb.append(String.format("%02X", b));
            }
        } catch (NoSuchAlgorithmException e) {
            log.error(e.getMessage());
        }
        return sb.toString();
    }
}
