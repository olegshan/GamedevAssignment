package counter;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by olegshan on 14.10.2016.
 */
public class WordCounter {

    private Map<String, Integer> map = new HashMap<>();

    public synchronized void addWord(String word) {
        word = word.toLowerCase();
        map.put(word, map.getOrDefault(word, 0) + 1);
    }

    public synchronized int getWordCount(String word) {
        try {
            return map.get(word.toLowerCase());
        } catch (NullPointerException e) {
            throw new IllegalArgumentException("No such word in the list");
        }
    }
}
