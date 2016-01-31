package ca.knoblauch.dialog;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Dev on 2016-01-31.
 */
public class pacingController extends Activity {

    private TextView pacingVal;
    private TextView tTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pacingview);
        speechModel sm = speechModel.getInstance();


        pacingVal = (TextView) findViewById(R.id.spmVal);
        tTime = (TextView) findViewById((R.id.totalTime));

        int wpm = sm.getActualPacing();
        pacingVal.setText(""+wpm);
    }
}
