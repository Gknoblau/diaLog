package ca.knoblauch.dialog;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Dev on 2016-01-31.
 */
public class pacing extends Activity {

    private TextView pacingVal;
    private TextView tTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.results);
        speechModel sm = speechModel.getInstance();


        pacingVal = (TextView) findViewById(R.id.pacingValue);
        tTime = (TextView) findViewById((R.id.totalTime));


        pacingVal.setText(""+sm.getActualPacing());
        tTime.setText(""+sm.getActualTime());
    }
}
