package com.urlshortener.urlshortener.services.utils;

import java.security.SecureRandom;
import java.util.Random;

public class ShortCodeGenerator {
    private static final Random RANDOM = new SecureRandom();

    private static final String ALPHANUM = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    private static final int LENGTH = 7;

    public static String generate() {
        StringBuilder sb = new StringBuilder(LENGTH);
        for (int i = 0; i < LENGTH; i++) {
            int randomIndex = RANDOM.nextInt(ALPHANUM.length());
            sb.append(ALPHANUM.charAt(randomIndex));
        }
        return sb.toString();
    }
}