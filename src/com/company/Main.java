package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int result = 0;
        int numIndex = 0;
        int[] num = new int[2];
        String[] roman = new String[2];
        String temp = "";
        StringBuilder stringBuilder = new StringBuilder(temp);
        char op = 0;
        boolean isRoman = false;
        CharacterCheck chCheck = new CharacterCheck();
        toRomanConverter toRoman = new toRomanConverter();

        //input
        Scanner sc = new Scanner(System.in);
        System.out.println("Input: ");
        String in = sc.next();


        //digit/roman character check
        for (int i = 0; i < in.length(); i++)
        {
            char ch = in.charAt(i);
            if (chCheck.isDigit(ch)) {
                isRoman = false;
            } else if (chCheck.isRoman(ch)) {
                isRoman = true;
            }
        }

        try {
            if (!isRoman) {
            /*for loop to cycle through each character in the string;
        if the character is an operation symbol, it is stored in op;
        temp stores a string of digits then the string is converted to an integer and stored in the num;
        numIndex serves as a counter to mark the first and the second number in the calculations.
         */
                for(int i = 0; i < in.length(); i++)
                {
                    char ch = in.charAt(i);
                    if (chCheck.isDigit(ch)){
                        stringBuilder.append(ch);
                    } else {
                        op = ch;
                        num[numIndex] = Integer.parseInt(stringBuilder.toString());
                        numIndex++;
                        stringBuilder.setLength(0);
                    }
                }

                //second number value
                num[numIndex] = Integer.parseInt(stringBuilder.toString());
                if (num[0] > 11 || num[1] > 10) {
                    System.out.println("Invalid input. Input numbers >11 are not allowed.");
                    System.exit(0);
                }
            }
        } catch (Exception e) {
            System.out.println("Unexpected character(s). Confirm the input.");
            System.exit(0);
        }


        numIndex = 0;

        try {
            if (isRoman) {
                //for loop to cycle through roman characters string
                for(int i = 0; i < in.length(); i++)
                {
                    char ch = in.charAt(i);
                    if (chCheck.isRoman(ch)){
                        stringBuilder.append(ch);
                    } else {
                        op = ch;
                        roman[numIndex] = stringBuilder.toString();
                        numIndex++;
                        stringBuilder.setLength(0);
                    }
                }

                //second number value
                roman[numIndex] = stringBuilder.toString();
                num[0] = toIntConverter.romanToInt(roman[0]);
                num[1] = toIntConverter.romanToInt(roman[1]);
                if (num[0] > 11 || num[1] > 10) {
                    System.out.println("Invalid input. Input numbers >X are not allowed.");
                    System.exit(0);
                }
            }
        } catch (Exception e) {
            System.out.println("Unexpected character(s). Confirm the input.");
            System.exit(0);
        }




        //calculation logic
        switch(op) {
            case '*' -> result = num[0] * num[1];
            case '/' -> result = num[0] / num[1];
            case '-' -> result = num[0] - num[1];
            case '+' -> result = num[0] + num[1];
            default -> {
                System.out.println("Invalid operator!");
                System.exit(0);
            }
        }

        //output
        if (isRoman) {
            System.out.println("\nOutput: \n" + toRoman.RomanToNum(result));
        } else {
            System.out.println("\nOutput: \n" + result);
        }
    }
}

