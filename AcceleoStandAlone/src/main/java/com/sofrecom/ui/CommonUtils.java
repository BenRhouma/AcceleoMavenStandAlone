/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sofrecom.ui;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
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

    public static List<String> scanClasses(String path, String[] filters) {
        final List<String> list = new ArrayList<>();
        String filter = "";
        for (String str : filters) {
            filter += str + ".class" + "|";
        }
        if (filters.length > 0) {
            filter = filter.substring(0, filter.length() - 1);
        }

        final String patternString = String.format("(.*)(%s)$", filter);
        final Pattern pattern = Pattern.compile(patternString);

        final File file = new File(path);
        for (final File fl : file.listFiles()) {
            if (fl.isFile()) {
                if (fl.getName().endsWith(".class")) {
                    if (!fl.getName().contains("$")) {
                        final Matcher matcher = pattern.matcher(fl.getName());
                        if (!matcher.find()) {
                            list.add(fl.getName());
                        }
                    }
                }
            }
        }
        return list;
    }

}
