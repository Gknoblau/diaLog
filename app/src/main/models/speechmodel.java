package ca.knoblauch.dialog;

import java.lang.String;
import java.util.ArrayList;

public class SpeechModel {
    private ArrayList watchWords = new ArrayList<String>();

    watchWords.add('fuck');
    watchWords.add('shit');
    watchWords.add('umm');
    watchWords.add('like');
    watchWords.add('damn');
    watchWords.add('darn');
    public Map importText(String inputString){
        inputString.toLowerCase();
        Map results = coutWords(inputString);
        return results;
    }

    private Map countWords(String inputString){
        Map dictionary = new HashMap();
        String[] words = inputString.split("\\s+");
        if(inputString.equals(""))
            continue;

        for(String word: words) {
            boolean isWatchWord = watchWords.contains(word);
            if(isWatchWord ) {
                if (dictionary.containsKey(word)) {
                    Integer val = dictionary.get(word);
                    dictionary.put(word, val + 1);
                } else {
                    dictionary.put(word, 1);
                }
            }
        }

    }
}