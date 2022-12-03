package com.javarush.hibernate_project.components;


import com.javarush.hibernate_project.exceptions.PasswordHashingException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordHashing {

    private static final String ERROR_WHILE_HASHING_PASSWORD = "Error while hashing password";
    private static final String ALGORITHM = "MD5";
    private final Logger logger = LogManager.getLogger(PasswordHashing.class);

    public String hashPassword(String password) throws PasswordHashingException {
        try {
            MessageDigest md = MessageDigest.getInstance(ALGORITHM);
            md.update(password.getBytes());
            byte[] bytes = md.digest();
            StringBuilder sb = new StringBuilder();
            for (byte aByte : bytes) {
                sb.append(Integer.toString((aByte & 0xff) + 0x100, 16).substring(1));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            logger.error(ERROR_WHILE_HASHING_PASSWORD, e);
            throw new PasswordHashingException(ERROR_WHILE_HASHING_PASSWORD);
        }
    }

    public boolean checkPassword(String password, String hashedPassword) {
        return password.equals(hashedPassword);
    }
}
