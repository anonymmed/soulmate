/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysoulmates.entities;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author salah
 */
public class Validator {

    private static Pattern pattern;
    private static Matcher matcher;

    public static enum regexType {
        QUESTION, ANSWER
    }
    
    private static final String stringRegex     = "^[a-zA-Z\\s]+";

    /*
    * Initialize the class with the wanted type to validate
     */
    public static boolean validate(regexType rt, final String hex) {
        switch (rt) {
            case QUESTION:
                pattern = Pattern.compile(stringRegex);
                break;
            case ANSWER:
                pattern = Pattern.compile(stringRegex);
                break;
        }
        matcher = pattern.matcher(hex);
        return matcher.matches();
    }
}
