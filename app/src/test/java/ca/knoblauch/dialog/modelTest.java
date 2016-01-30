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
    speechModel sm = new speechModel();
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
        Map results = sm.importText("I am the best. Fuck, whore I mean second. shit fuck um");
        Integer count = (Integer) results.get("fuck");

        assertEquals(2, results.get("fuck"));
        assertEquals(1, results.get("shit"));
        assertEquals(1, results.get("um"));

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