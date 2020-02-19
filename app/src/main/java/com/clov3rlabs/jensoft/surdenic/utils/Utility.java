package com.clov3rlabs.jensoft.surdenic.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;

/**
 * Created by rsaavedra on 6/8/2018.
 */

public class Utility {

    public static final String md5(final String s) {
        final String MD5 = "MD5";
        try {
            // Create MD5 Hash
            MessageDigest digest = java.security.MessageDigest
                    .getInstance(MD5);
            digest.update(s.getBytes());
            byte messageDigest[] = digest.digest();

            // Create Hex String
            StringBuilder hexString = new StringBuilder();
            for (byte aMessageDigest : messageDigest) {
                String h = Integer.toHexString(0xFF & aMessageDigest);
                while (h.length() < 2)
                    h = "0" + h;
                hexString.append(h);
            }
            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }


    public static final String formatMonyNotCoin(double number){
        DecimalFormat df = new DecimalFormat("##,###,###.00");
        if(number == 0){
            return "0.00";
        }else{
            return df.format(Double.parseDouble(String.valueOf(number)));
        }
    }

}
