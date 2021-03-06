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
        sm.importVoiceText("I am the best. Fuck, whore I mean documents. shit fuck fucked fuc um");
        Map results = sm.getActualWordDicCount();
        // 13
        Integer count = (Integer) results.get("fuck");

        assertEquals(4, results.get("fuck"));
        assertEquals(1, results.get("shit"));
        assertEquals(1, results.get("um"));


        sm.setActualTime(550);
        assertEquals(16, sm.getActualSyllabeCount());

        sm.importVoiceText("actor");
        results = sm.getActualWordDicCount();

        assertEquals("actor", sm.getVoiceText());

        assertEquals(2, sm.getActualSyllabeCount());

        sm.importVoiceText("documents");
        results = sm.getActualWordDicCount();

        assertEquals("documents", sm.getVoiceText());

        assertEquals(3, sm.getActualSyllabeCount());
        sm.importVoiceText("Plain English recommends short sentences. Robert Gunning faults marathon sentences in his book How To Take The Fog Out Of Writing. Though he admits to the possibility of long sentences being balanced and readable, he notes that only highly skilled writers such as Charles Dickens and Thomas Wolfe can write a marathon sentence with ClarityActivity. He adds: “But even these accomplished writers produced marathon sentences only occasionally. On the average, they wrote fewer than 20 words per sentence.”");
        sm = speechModel.getInstance();
        results = sm.getActualWordDicCount();

        int readingLevel = sm.getActualReadingLevel();
        int wordCount = sm.getActualWordCount();
        int syllableCount = sm.getActualSyllabeCount();

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

        sm.setTargetText("meow goes the cat");

        sm.importVoiceText("moo goes the cat");
        int editDist = sm.getLevnshteinDistance();

        assertEquals(2,editDist);
//        Log.d("result", Integer.toString(count));

    }

//    @test
//    public void word_analysis_works() throws Exception {
//          Map ResultsActivity = sm.importText("I am the best. Fuck I mean second");
//          String count = (String) ResultsActivity.get("fuck");
//          assertEquals(2, ResultsActivity.get("fuck"));
//          Log.d("result", count);
//    }

}