package ca.knoblauch.dialog;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by Dev on 2016-01-31.
 */
public class PacingActivity extends Activity {

    private TextView actualSPMVal;
    private TextView ActualTimeTV;
    private TextView TargetTimeTV;


    private String convertSecondsFormat(double secs){
        int mins = (int) secs/60;
        int seconds = (int) secs %60;
        if (seconds <10 ){
            return "" +mins + ": 0" + seconds;

        } else {
            return "" +mins + ": " + seconds;

        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pacingview);
        speechModel sm = speechModel.getInstance();


        actualSPMVal = (TextView) findViewById(R.id.spmVal);


        TargetTimeTV = (TextView) findViewById((R.id.targTimeVal));
        ActualTimeTV = (TextView) findViewById((R.id.actTimeVal));


        int wpm = sm.getActualPacing();
        actualSPMVal.setText(""+wpm);

        double targSeconds = sm.getTargetTime();
        int actualSeconds = sm.getActualTime();
       if(sm.isTargetIsSet()) {
           TargetTimeTV.setText(convertSecondsFormat(targSeconds));
       } else {
           TargetTimeTV.setText("N/A");
       }
        ActualTimeTV.setText(convertSecondsFormat(actualSeconds));
    }
}
