package ca.knoblauch.dialog;

import java.util.ArrayList;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Dev on 2016-01-30.
 */
public class speechModel {
    ArrayList<String> watchWords = new ArrayList<String>();

    private int targetTime;
    private int actualTime;
    private int wordCount;
    private int syllableCount;
    private String voiceInputString;
    public Map importText(String inputString){
        voiceInputString = inputString.toLowerCase();
        wordCount =0;
        syllableCount=0;

        Map results = countWords(voiceInputString);

        return results;
    }
    public void setTargetTime(int inputTime){
        targetTime=inputTime;
    }
    public int getTargetTime(){
        return targetTime;
    }

    public void setActualTime(int inputTime){
        actualTime = inputTime;
    }
    public int getActualTime(){
        return actualTime;
    }

    public int getTimeDifference(){
        return targetTime - actualTime;
    }

    private Map countWords(String inputString){
        watchWords.add("fuck");
        watchWords.add("shit");
        watchWords.add("um");
        watchWords.add("like");
        watchWords.add("damn");
        watchWords.add("darn");
        Map <String, Integer> dictionary = new HashMap<String, Integer>();
        String[] words = inputString.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");
        wordCount = words.length;
        for(String word: words) {
            syllableCount+= countSyllables(word);
            boolean isWatchWord = watchWords.contains(word);
            if(isWatchWord ) {
                if (dictionary.containsKey(word)) {
                    int val = (int) dictionary.get(word);

                    dictionary.put(word, val + 1);
                } else {
                    dictionary.put(word, 1);
                }
            }
        }

        return dictionary;
    }
    // http://stackoverflow.com/questions/9154027/java-writing-a-syllable-counter-based-on-specifications
    private int countSyllables(String word) {
        int count = 0;
        word = word.toLowerCase();
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == '\"' || word.charAt(i) == '\'' || word.charAt(i) == '-' || word.charAt(i) == ',' || word.charAt(i) == ')' || word.charAt(i) == '(') {
                word = word.substring(0,i)+word.substring(i+1, word.length());
            }
        }
        boolean isPrevVowel = false;
        for (int j = 0; j < word.length(); j++) {
            if (word.contains("a") || word.contains("e") || word.contains("i") || word.contains("o") || word.contains("u")) {
                if (isVowel(word.charAt(j)) && !((word.charAt(j) == 'e') && (j == word.length()-1))) {
                    if (isPrevVowel == false) {
                        count++;
                        isPrevVowel = true;
                    }
                } else {
                    isPrevVowel = false;
                }
            } else {
                count++;
                break;
            }
        }
        return count;
    }
    public boolean isVowel(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
            return true;
        } else {
            return false;
        }
    }
    public int getSyllabeCount(){
        return syllableCount;
    }
    public String getText(){
        return voiceInputString;
    }

    public int getActualPacing(){
        int wordsPerMinute = wordCount / (actualTime / 60);
        return wordsPerMinute;
    }
    public int getTargetPacing(){
        int wordsPerMinute = wordCount / (targetTime / 60);
        return wordsPerMinute;
    }




}
