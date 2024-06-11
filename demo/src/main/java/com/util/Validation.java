package com.util;

import java.util.regex.Pattern;

public class Validation {

    private static Pattern userPattern = Pattern.compile("^\\w{4,16}$");

    private static Pattern passwordPattern =
            Pattern.compile("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*\\W)(?!.*\\s).{8,16}$");

    private static Pattern emailPattenr = Pattern.compile("^[a-zA-Z\\d-_]+@[a-zA-Z0-9.]+.[a-z]+$");

    public static boolean username(String user){
        return userPattern.matcher(user).matches();
    }
    public static boolean password(String password){
        return passwordPattern.matcher(password).matches();
    }
    public static boolean email(String password){
        return emailPattenr.matcher(password).matches();
    }
}
