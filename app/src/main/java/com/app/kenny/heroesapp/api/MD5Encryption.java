package com.app.kenny.heroesapp.api;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Encryption {

    public static String publicKey = "3cdb76d09c660c9c2aa319061f866e76";
    public static String privateKey = "34fa95cdb7440e9ec698d262ec55080022447e4c";

    public String generateHash(){
        String passwordToHash = 1+privateKey+publicKey;
        String generatedPassword = null;
        try {
            // Create MessageDigest instance for MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
            //Add password bytes to digest
            md.update(passwordToHash.getBytes());
            //Get the hash's bytes
            byte[] bytes = md.digest();
            //This bytes[] has bytes in decimal format;
            //Convert it to hexadecimal format
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            //Get complete hashed password in hex format
            generatedPassword = sb.toString();
        }
        catch (NoSuchAlgorithmException e)
        {
             e.printStackTrace();
        }
        return generatedPassword;
    }
}
