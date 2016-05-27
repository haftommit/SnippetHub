/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.snippethub.model.util;

import java.text.Normalizer;
import java.util.Locale;
import java.util.regex.Pattern;

/**
*
* @author Haftom Alemayehu <Haftom Alemayehu>
*/
public class Util {
        private static final Pattern NONLATIN = Pattern.compile("[^\\w-]");
        private static final Pattern WHITESPACE = Pattern.compile("[\\s]");
        public static String getSlug(String input) {
        String nowhitespace = WHITESPACE.matcher(input).replaceAll("-");
        String normalized = Normalizer.normalize(nowhitespace, Normalizer.Form.NFD);
        String slug = NONLATIN.matcher(normalized).replaceAll("");
        return slug.toLowerCase(Locale.ENGLISH);
    }
}
