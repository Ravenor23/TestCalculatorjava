package com.company;

public class CharacterCheck {

    //check if the character is digit or not
    public boolean isDigit (char ch)
    {
        boolean chDigit = false;

        switch (ch)
        {
            case '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' -> chDigit = true;
        }
        return chDigit;
    }

    //check if the character is roman or not
    public boolean isRoman (char ch) {
        boolean chRoman = false;

        switch (ch) {
            case 'i', 'I', 'V', 'v', 'X', 'x', 'C', 'c', 'L', 'l' -> chRoman = true;
        }
        return chRoman;
    }
}
