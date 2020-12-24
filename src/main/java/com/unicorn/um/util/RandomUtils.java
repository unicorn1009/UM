package com.unicorn.um.util;

import java.text.DecimalFormat;
import java.util.Random;

public class RandomUtils {

    private static final DecimalFormat fd = new DecimalFormat("0000");
    private static final DecimalFormat sd = new DecimalFormat("000000");
    private static final Random random = new Random();

    public static String getFourBitCode() {
        return fd.format(random.nextInt(10000));
    }

    public static String getSixBitCode() {
        return fd.format(random.nextInt(1000000));
    }
}
