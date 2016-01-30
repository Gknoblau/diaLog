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



    public Map importText(String inputString){
        inputString.toLowerCase();
        Map results = countWords(inputString);
        return results;
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

        for(String word: words) {
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
}
