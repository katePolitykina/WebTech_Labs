package com.epam.rd.autotasks.words;

import java.util.Arrays;

public class StringUtil {
    public static int countEqualIgnoreCaseAndSpaces(String[] words, String sample) {
        if (words == null || sample == null || sample.isEmpty())
            return 0;
        int res = 0;
        sample = sample.strip();
        for(String word : words){
            if (word.strip().equalsIgnoreCase(sample))
                res++;
        }
    return res;
    }

    public static String[] splitWords(String text) {
        if (text == null || text.isEmpty()) return null;
        text = text.replaceAll("^[,.;: ?!]+|[,.;: ?!]+$", "");
        String [] res = text.split("[,.;: ?!]+");
        if (res[0].length()==0)
            return null;
        return res;
    }

    public static String convertPath(String path, boolean toWin) {
        if (path == null || path.isEmpty() || !isValidPath(path))
            return null;
        if (toWin){
            path =path.replace("~", "C:\\User");
            if (path.charAt(0)=='/')
                path =path.replaceFirst("/", "C:\\\\");
            path =path.replace("/", "\\");
        }else{
            path =path.replace("C:\\User", "~" );
            path =path.replace("C:\\", "/");
            path =path.replace("\\", "/");
        }
        return path;
    }
    private static boolean isValidPath(String path) {
        if ((path.contains("/") || path.contains("~") )&& (path.contains("\\") || path.contains("C:"))) {
            return false;
        }
        if (path.lastIndexOf("~")>0) {
            return false;
        }
        if (path.lastIndexOf("C:")>0) {
            return false;
        }
        return true;
    }

    public static String joinWords(String[] words) {
        if (words == null)
            return null;
        String res = "[";
        for (String word: words
             ) {
            if (word.length()!=0){
                res += word + ", ";
            }
        }
        if (res.length() == 1)
            return null;
        else return res.substring(0,res.length()-2) + "]";
    }

    public static void main(String[] args) {
        System.out.println("Test 1: countEqualIgnoreCaseAndSpaces");
        String[] words = new String[]{" WordS    \t", "words", "w0rds", "WOR  DS", };
        String sample = "words   ";
        int countResult = countEqualIgnoreCaseAndSpaces(words, sample);
        System.out.println("Result: " + countResult);
        int expectedCount = 2;
        System.out.println("Must be: " + expectedCount);

        System.out.println("Test 2: splitWords");
        String text = "   ,, first, second!!!! third";
        String[] splitResult = splitWords(text);
        System.out.println("Result : " + Arrays.toString(splitResult));
        String[] expectedSplit = new String[]{"first", "second", "third"};
        System.out.println("Must be: " + Arrays.toString(expectedSplit));

        System.out.println("Test 3: convertPath");
        String unixPath = "/some/unix/path";
        String convertResult = convertPath(unixPath, true);
        System.out.println("Result: " + convertResult);
        String expectedWinPath = "C:\\some\\unix\\path";
        System.out.println("Must be: " + expectedWinPath);

        System.out.println("Test 4: joinWords");
        String[] toJoin = new String[]{"go", "with", "the", "", "FLOW"};
        String joinResult = joinWords(toJoin);
        System.out.println("Result: " + joinResult);
        String expectedJoin = "[go, with, the, FLOW]";
        System.out.println("Must be: " + expectedJoin);
    }
}