package ca.knoblauch.dialog;

import android.util.Log;
import android.util.Log.*;
import org.junit.Test;
import ca.knoblauch.dialog.speechModel;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
import org.junit.runner.RunWith;

import java.util.Map;

//import android.support.test.runner.AndroidJUnit4;
//
//@RunWith(AndroidJUnit4.class)
public class modelTest {
    speechModel sm = speechModel.getInstance();
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
        sm.importText("I am the best. Fuck, whore I mean documents. shit fuck fucked fuc um");
        Map results = sm.getWordDictionary();
        // 13
        Integer count = (Integer) results.get("fuck");

        assertEquals(4, results.get("fuck"));
        assertEquals(1, results.get("shit"));
        assertEquals(1, results.get("um"));


        sm.setTargetTime(560);
        sm.setActualTime(550);
        assertEquals(560, sm.getTargetTime());
        assertEquals(10, sm.getTimeDifference());
        assertEquals(16, sm.getSyllabeCount());

        sm.importText("actor");
        results = sm.getWordDictionary();

        assertEquals("actor", sm.getText());

        assertEquals(2, sm.getSyllabeCount());

        sm.importText("documents");
        results = sm.getWordDictionary();

        assertEquals("documents", sm.getText());

        assertEquals(3, sm.getSyllabeCount());
        sm.importText("Plain English recommends short sentences. Robert Gunning faults marathon sentences in his book How To Take The Fog Out Of Writing. Though he admits to the possibility of long sentences being balanced and readable, he notes that only highly skilled writers such as Charles Dickens and Thomas Wolfe can write a marathon sentence with clarity. He adds: “But even these accomplished writers produced marathon sentences only occasionally. On the average, they wrote fewer than 20 words per sentence.”");
        sm = speechModel.getInstance();
        results = sm.getWordDictionary();

        int readingLevel = sm.getReadingLevel();
        int wordCount = sm.getWordCount();
        int syllableCount = sm.getSyllabeCount();

        assertEquals(77,wordCount);
        assertEquals(120,syllableCount);

//        assertEquals(9,readingLevel);
        double wordsPerSentance = (77.0/5.0);
        double syllablesPerWord = (120.0/77.0);

        double firstPart = 0.39 * wordsPerSentance;
        double secondPart = 11.8*syllablesPerWord;
        double summation = firstPart + secondPart - 15.59;
        assertEquals(6.006, firstPart,.1);
        assertEquals(18.39, secondPart,.1);
        assertEquals(9, summation,.5);



        int readlevel = (int) Math.round(summation);
        assertEquals(9, readlevel);

//        Log.d("result", Integer.toString(count));

    }

//    @test
//    public void word_analysis_works() throws Exception {
//          Map results = sm.importText("I am the best. Fuck I mean second");
//          String count = (String) results.get("fuck");
//          assertEquals(2, results.get("fuck"));
//          Log.d("result", count);
//    }

}