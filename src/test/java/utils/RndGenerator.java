package utils;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RndGenerator {

    public static String getRndString(int length) {

        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder result = new StringBuilder();
        Random rnd = new Random();
        while (result.length() < length) {
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            result.append(SALTCHARS.charAt(index));
        }
        return result.toString();
    }

    public static String getRndEmail(){
        return getRndString(8) + "@" + getRndString(4) + ".ru";
    }

    public static Long getRndLong(Long min, Long max) {
        return ThreadLocalRandom.current().nextLong(min, max);
    }

}
