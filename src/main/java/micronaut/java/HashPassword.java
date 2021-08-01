/*
 *
 * Copyright (c) 2021 Dipesh Shrestha aka JustaDreamer
 * Github: https://github.com/JustaNormalDreamer
 *
 */

package micronaut.java;

import javax.inject.Singleton;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

@Singleton
public class HashPassword {

    public String makeHash(String password) {
        return hashPassword(password);
    }

    public boolean matchPassword(String password, String hashedPassword) {
        return Objects.equals(hashPassword(password), hashedPassword);
    }

    private String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            //salt
            md.update("password".getBytes());

            byte[] hashedPassword = md.digest(password.getBytes(StandardCharsets.UTF_8));

            return hexaToString(hashedPassword);
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    private static String hexaToString(byte[] digest ){
        // Convert digest to a string
        StringBuilder hexString = new StringBuilder();
        for (byte b : digest) {
            if ((0xff & b) < 0x10) {
                hexString.append("0").append(Integer.toHexString((0xFF & b)));
            } else {
                hexString.append(Integer.toHexString(0xFF & b));
            }
        }
        return hexString.toString();
    }
}
