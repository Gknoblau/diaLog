package ca.knoblauch.dialog;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by Dev on 2016-01-31.
 */
public class clarity extends Activity {

    private TextView actualReadLevel;
    private TextView targetReadLevel;
    private TextView actualWordsMinute;
    private TextView targetWordsMinute;
    private TextView hammingDistance;

    private TextView SPW;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pacingview);
        speechModel sm = speechModel.getInstance();

        actualReadLevel = (TextView) findViewById(R.id.actualReadLevel);
        targetReadLevel = (TextView) findViewById(R.id.targetReadLevel);
        actualWordsMinute = (TextView) findViewById(R.id.actualWordsMinute);
        targetWordsMinute = (TextView) findViewById(R.id.targetWordsMinute);
        hammingDistance = (TextView) findViewById(R.id.hammingDistance);

        int actualReadingLevel = sm.getActualReadingLevel();
        int targetReadingLevel = sm.getTargetReadingLevel();
        int actualWordsPerMinute = sm.getActualPacing();
        int targetWordsPerMinute = sm.getTargetPacing();
        //int hammingDistance =

        actualReadLevel.setText(actualReadingLevel);
        targetReadLevel.setText(targetReadingLevel);
        actualWordsMinute.setText(actualWordsPerMinute);
        targetWordsMinute.setText(targetWordsPerMinute);
        //hammingDistance.setText();

        actualReadLevel.setText("");
        targetReadLevel.setText("");
        actualWordsMinute.setText("");
        targetWordsMinute.setText("");
        hammingDistance.setText("");




    }
}
