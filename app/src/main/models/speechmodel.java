import java.lang.String;
import java.util.ArrayList;

public class speechModel {
    private ArrayList watchWords = new ArrayList<String>();

    watchWords.add('fuck');
    watchWords.add('shit');
    watchWords.add('umm');
    watchWords.add('like');
    watchWords.add('damn');
    watchWords.add('darn');


    private void countWords(inputString){
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