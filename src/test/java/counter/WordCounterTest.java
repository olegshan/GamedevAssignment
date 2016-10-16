package counter;

import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

/**
 * Created by olegshan on 14.10.2016.
 */
public class WordCounterTest {
    WordCounter wc = new WordCounter();

    @Before
    public void setUp() throws Exception {
        ExecutorService exec = Executors.newFixedThreadPool(100);
        for (int i = 0; i < 100000; i++) {
            exec.execute(() -> wc.addWord("wolf"));
            exec.execute(() -> wc.addWord("rabbit"));
            exec.execute(() -> wc.addWord("fox"));
        }
        exec.shutdown();
        try {
            exec.awaitTermination(50, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getWordCount() throws Exception {
        assertTrue(wc.getWordCount("Wolf") == 100000);
        assertTrue(wc.getWordCount("rabbit") == 100000);
        assertTrue(wc.getWordCount("FOX") == 100000);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getWordCountWhenWordIsNotFound() throws Exception {
        wc.getWordCount("Cat");
    }
}