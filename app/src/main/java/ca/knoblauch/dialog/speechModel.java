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
    private String actualText;
    private String targetText;

    private int actualWordCount;
    private int targetWordCount;

    private Map actualWordDicCount;
    private Map targetWordDicCount;

    private int actualSyllableCount;
    private int targetSyllableCount;

    private int totalFlaggedWords =0;

    private String voiceInputString;

    private int AVERAGEWORDPERSENTANCES =17;
    private double TARGETSPM = 150.0;

    private int hammingDistance;
    private static speechModel firstInstance = null;
    private speechModel() {};



    public static speechModel getInstance(){
        if(firstInstance == null){
            synchronized(speechModel.class){
                if(firstInstance == null){
                    firstInstance = new speechModel();
                }
            }
        }
        return firstInstance;
    }
    public void importVoiceText(String inputString){
        voiceInputString = inputString.toLowerCase();
        actualWordCount =0;
        actualSyllableCount=0;

        actualWordDicCount= countActualWords(voiceInputString);

    }
    public void setTargetText (String targText){
        targetWordCount =0;
        targetSyllableCount=0;
        targetText=targText;
        targetWordDicCount= countTargetWords(targetText);

        targetTime = (int) (1.0/TARGETSPM)/targetSyllableCount ;

    }
    public int getTargetTime(){
        return targetTime;
    }
    public Map getActualWordDicCount(){
        return actualWordDicCount;
    }
    public void setActualTime(int inputTime){
        actualTime = inputTime;
    }
    public int getActualTime(){
        return actualTime;
    }

    public Integer getTimeDifference(){
        return targetTime - actualTime;
    }

    private Map countTargetWords(String inputString){

        Map <String, Integer> dictionary = new HashMap<String, Integer>();
        String[] words = inputString.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");
        targetSyllableCount= words.length;
        for(String word: words) {
            targetSyllableCount+= countSyllables(word);
        }

        return dictionary;
    }
    private Map countActualWords(String inputString){
        watchWords.add("fuck");
        watchWords.add("fucked");
        watchWords.add("fucking");
        watchWords.add("shit");
        watchWords.add("um");
        watchWords.add("uh");
        watchWords.add("like");
        watchWords.add("damn");
        watchWords.add("darn");

        Map <String, Integer> dictionary = new HashMap<String, Integer>();
        String[] words = inputString.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");
        actualWordCount= words.length;
        for(String word: words) {
            actualSyllableCount+= countSyllables(word);

            word = word.replace("ing","");
            word = word.replace("ed","");
            word = word.replace("ter","");
            word = word.replace("ing","");
            if(word.equals( "fuc")){
                word="fuck";
            }
            boolean isWatchWord = watchWords.contains(word);
            if(isWatchWord ) {
                if (dictionary.containsKey(word)) {
                    int val = (int) dictionary.get(word);

                    dictionary.put(word, val + 1);
                } else {

                    dictionary.put(word, 1);
                }
                totalFlaggedWords++;
            }
        }

        return dictionary;
    }
    public int getTotalFlaggedWords(){
        return totalFlaggedWords;
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
    public int getActualSyllabeCount(){

        return actualSyllableCount;
    }
    public int getTargetSyllableCount(){
        return targetSyllableCount;
    }
    public String getVoiceText(){
        return voiceInputString;

    }


    public int getActualPacing(){
        int wordsPerMinute = (int) (actualWordCount/ (actualTime / 60.0));
        return wordsPerMinute;
    }
    public int getTargetPacing(){
        int wordsPerMinute = (int) (targetWordCount / (targetTime / 60.0));
        return wordsPerMinute;
    }
    public int getActualWordCount(){

        return actualWordCount;
    }

    private int spwActual = (int)((double)actualSyllableCount/(double) actualWordCount);
    public int getSPWActual(){
        return spwActual;
    }
    public int getActualReadingLevel(){
        double totalSentences = (double) actualWordCount/17.0;

        double wordsPerSentance = ((double) actualWordCount/totalSentences);

        double syllablesPerWord = ((double)actualSyllableCount/(double) actualWordCount);

        double firstPart = 0.39 * wordsPerSentance;
        double secondPart = 11.8*syllablesPerWord;
        double summation = firstPart + secondPart - 15.59;
        return (int) Math.round(summation);
    }

    public int getTargetReadingLevel(){
        double totalSentences = (double) targetWordCount/17.0;

        double wordsPerSentance = ((double) targetWordCount/totalSentences);

        double syllablesPerWord = ((double)targetSyllableCount/(double) targetWordCount);

        double firstPart = 0.39 * wordsPerSentance;
        double secondPart = 11.8*syllablesPerWord;
        double summation = firstPart + secondPart - 15.59;
        return (int) Math.round(summation);
    }

}
