package com.company;

import java.util.LinkedHashMap;

public class toIntConverter {
    //method converts a string with roman numbers into arabic numbers
    public static int romanToInt (String s) {
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        map.put('I', 1);
        map.put('i', 1);
        map.put('V', 5);
        map.put('v', 5);
        map.put('X', 10);
        map.put('x', 10);
        map.put('L', 50);
        map.put('l', 50);
        map.put('C', 100);
        map.put('c', 100);

        int result = 0;
        for (int i = 0; i < s.length(); i++)
        {
            if (i > 0 && map.get(s.charAt(i)) > map.get(s.charAt(i - 1))) {
                result += map.get(s.charAt(i)) - (2 * map.get(s.charAt(i - 1)));
            } else {
                result += map.get(s.charAt(i));
            }
        }
        return result;
    }
}
