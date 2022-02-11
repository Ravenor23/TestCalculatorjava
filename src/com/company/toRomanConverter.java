package com.company;
import java.util.*;

public class toRomanConverter {
    //method takes as an argument an integer and converts it into a roman number
    public String RomanToNum(int num) {
        LinkedHashMap<String, Integer> romanNumbers = new LinkedHashMap<>();
        String result = "";
        StringBuilder stringBuilder = new StringBuilder(result);


        //Roman to arabic map
        romanNumbers.put("C", 100);
        romanNumbers.put("XC", 90);
        romanNumbers.put("L", 50);
        romanNumbers.put("XL", 40);
        romanNumbers.put("X", 10);
        romanNumbers.put("IX", 9);
        romanNumbers.put("V", 5);
        romanNumbers.put("IV", 4);
        romanNumbers.put("I", 1);

        for (Map.Entry<String, Integer> entry: romanNumbers.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();

            while (num >= value) {
                stringBuilder.append(key);

                num -= value;
            }
        }

        return stringBuilder.toString();
    }
}
