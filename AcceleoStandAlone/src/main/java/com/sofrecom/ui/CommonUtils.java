/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sofrecom.ui;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author z.benrhouma
 */
public class CommonUtils {

    public static String upperFirstLetterAfterUnderscore(String str) {

        final Pattern pattern = Pattern.compile("([^_.]*)[_]*");
        Matcher matcher = pattern.matcher(str);
        String ret = "";
        while (matcher.find()) {
            if (!matcher.group(1).equals("")) {
                ret += upperFirstCharacter(matcher.group(1));
            }
        }
        return ret;
    }

    private static String upperFirstCharacter(String pattern) {
        return pattern.replaceFirst(String.valueOf(pattern.charAt(0)), String.valueOf((char) (((int) pattern.charAt(0)) - 32)));
    }

}
