package com.company.core.strings;

@SuppressWarnings("StringConcatenationInLoop")
public class StringHelpers {
    //Eli

    public static String abbreviate(String source, int maxLength) {
        return null;
    }

    public static String capitalize(String source) {
        return null;
    }

    public static String concat(String string1, String string2) {
        return null;
    }

    //  Description - the method checks if a string contains a characters.
    //  Parameters -text - the string that is checked if it contains the char.
    //             -symbol - the sequence of characters that is checked if it's contained in the provided string
    //  Returns - returns "true" if the characters exist and "false" if not.
    //  Author - Krasen Kochev
    public static boolean contains(String string, char symbol) {
        boolean isContained=false;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i)==symbol){
                isContained=true;
            }
        }return isContained;
    }
    //  Description - the method checks if a string ends with the given character.
    //  Parameters -source - the string that is checked if it ends with the given character.
    //             -target - the given characters that is checked if the provided string end with it.
    //  Returns - returns "true" if the string ends with the given character and returns "false" if the
    //  string does not end with the provided character.
    //  Author - Krasen Kochev
    public static boolean endsWith(String source, char target) {
        boolean itEndWithChar =false;

        if (source.length()==0){
            itEndWithChar=false;
        } else if (source.charAt(source.length()-1)==target) {
            itEndWithChar=true;
        }
        return itEndWithChar;
    }

    //  Description - the method finds the index of the first occurrence of a  given char in a given string.
    //  Parameters -source - the string that is checked for the first occurrence of a given char.
    //             -target - the given characters that is checked for the first occurrence of it in a provided string.
    //  Returns - returns "int" index of the first occurrence of the character, from the index of the provided string.
    //  If the character is not found, returns "-1".
    //  Author - Krasen Kochev
    public static int firstIndexOf(String source, char target) {
        int returnValue=-1;
        for (int i = 0; i < source.length(); i++) {
            if (source.charAt(i)==target){
                returnValue=i;
            }
        }
        return returnValue;
    }
    //  Description - the method finds the index of the last occurrence of a given char in a given string.
    //  Parameters -source - the string that is checked for the last occurrence of a given char.
    //             -symbol - the given characters that is checked for the last occurrence of it, in a provided string.
    //  Returns - returns "int" index of the last occurrence of the character, from the index of the provided string.
    //  If the character is not found, returns "-1".
    //  Author - Krasen Kochev

    public static int lastIndexOf(String source, char symbol) {
        int returnValue=-1;
        for (int i = 0; i < source.length(); i++) {
            if (source.charAt(source.length()-1-i)==symbol){
                returnValue=source.length()-1-i;
            }
        }
        return returnValue;
    }
    //  Description - the method pads a string on the left and right side with a provided char enough times to reach the provided length.
    //  Parameters -source - the string that will be padded and checked against the provided length.
    //             -length - the length that will be checked against the length of the string.
    //             -paddingSymbol - the given characters that will be used for padding.
    //  Returns - returns the padded string, padded on the left and right side, to a length that is provided.
    //  If the provided length is smaller than the length of the string, it returns the string.
    //  if the difference of the provided length and the length of the string is an odd sum,
    //  the method pads one time on the left and right side the provided string.
    //  Author - Krasen Kochev
    public static String pad(String source, int length, char paddingSymbol) {
        int difference =0;
        int padStart=0;
        int padEnd=0;
        StringBuilder result = new StringBuilder();
        String finalResult="";

        if (source.length()<length) {
            difference = length - source.length();
            if (difference%2!=0){
                padStart=1;
                padEnd =1;
            }else {
                padStart = difference / 2;
                padEnd = difference / 2;
            }
            for (int i = 0; i < padStart; i++) {
                result.append(paddingSymbol);
            }
            result.append(source);
            for (int i = 0; i < padEnd; i++) {
                result.append(paddingSymbol);
            }finalResult=result.toString();
            return finalResult;
        }
        if (source.length()>length){
            finalResult=source;
            return source;
        }
        return finalResult;
    }

    //  Description - the method pads a string on the right side with a provided char enough times to reach the provided length.
    //  Parameters -source - the string that will be padded and checked against the provided length.
    //             -length - the length that will be checked against the length of the string.
    //             -paddingSymbol - the given characters that will be used for padding.
    //  Returns - returns the padded string, padded on the right side, to a length that is provided.
    //  If the provided length is smaller than the length of the string, it returns the string.
    //  Author - Krasen Kochev
    public static String padEnd(String source, int length, char paddingSymbol) {
        int difference =0;
        StringBuilder result = new StringBuilder();
        String finalResult="";
        if (source.length()<length){
            difference=length-source.length();
            result.append(source);
            for (int i = 0; i < difference; i++) {
                result.append(paddingSymbol);
            }
            finalResult=result.toString();

        }
        if (source.length()>length){
            finalResult=source;
        }
        return finalResult;
    }
    //  Description - the method pads a string on the left side with a provided char enough times to reach the provided length.
    //  Parameters -source - the string that will be padded and checked against the provided length.
    //             -length - the length that will be checked against the length of the string.
    //             -paddingSymbol - the given characters that will be used for padding.
    //  Returns - returns the padded string, padded on the left side, to a length that is provided.
    //  If the provided length is smaller than the length of the string, it returns the string.
    //  Author - Krasen Kochev

    public static String padStart(String source, int length, char paddingSymbol) {
        int difference =0;
        StringBuilder result = new StringBuilder();
        String finalResult="";
        if (source.length()<length){
            difference=length-source.length();
            for (int i = 0; i < difference; i++) {
                result.append(paddingSymbol);
            }
            result.append(source);
            finalResult=result.toString();
        }
        if (source.length()>length){
            finalResult=source;
        }
        return finalResult;
    }

    public static String repeat(String source, int times) {
        return null;
    }

    public static String reverse(String source) {
        return null;
    }

    public static String section(String source, int start, int end) {
        return null;
    }

    public static boolean startsWith(String source, char target) {
        return false;
    }

}
