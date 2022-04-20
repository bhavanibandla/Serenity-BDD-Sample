package com.enginegroup.accelarators.utils;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

public class EncryptionUtils {

    private static SecretKeySpec h;

    public static void setKey(String myKey) {
        try {
            byte[] i = myKey.getBytes(StandardCharsets.UTF_8);
            i = Arrays.copyOf(MessageDigest.getInstance("SHA-1").digest(i), 16);
            h = new SecretKeySpec(i, "AES");
        } catch (NoSuchAlgorithmException var1) {
            var1.printStackTrace();
        }
    }

    public static String encrypt(String strToEncrypt, String mySecretKey) {
        try {
            setKey(mySecretKey);
            Cipher mySecretKey1;
            (mySecretKey1 = Cipher.getInstance("AES/ECB/PKCS5Padding")).init(1, h);
            return Base64.getEncoder().encodeToString(mySecretKey1.doFinal(strToEncrypt.getBytes(StandardCharsets.UTF_8)));
        } catch (Exception var2) {
            System.err.println("[INFO]: Error while encrypting: " + var2);
            return null;
        }
    }

    public static String decrypt(String strToDecrypt, String mySecretKey) {
        try {
            setKey(mySecretKey);
            Cipher mySecretKey1;
            (mySecretKey1 = Cipher.getInstance("AES/ECB/PKCS5PADDING")).init(2, h);
            return new String(mySecretKey1.doFinal(Base64.getDecoder().decode(strToDecrypt)));
        } catch (Exception var2) {
            System.out.println("Error while decrypting: " + var2);
            return null;
        }
    }
}
