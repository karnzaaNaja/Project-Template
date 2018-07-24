package com.example.msi_gl62.simpelapp.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class AppUtil  {

    private String txtpassword;

    public static void test(String password){

        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());

            byte byteData[] = md.digest();

            //convert the byte to hex format method 1
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < byteData.length; i++) {
                sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
            }

            System.out.println("Digest(in hex format):: " + sb.toString());

            //convert the byte to hex format method 2
            StringBuilder hexString = new StringBuilder();
            for (int i=0;i<byteData.length;i++) {
                String hex=Integer.toHexString(0xff & byteData[i]);
                if(hex.length()==1) hexString.append('0');
                hexString.append(hex);
            }
            System.out.println("Digest(in hex format):: " + hexString.toString());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

    }

    public String getTxtpassword() {
        return txtpassword;
    }

    public void setTxtpassword(String txtpassword) {
        this.txtpassword = txtpassword;
    }

}
