package ca.knoblauch.dialog;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by Dev on 2016-01-31.
 */
public class clarity extends Activity {

    private TextView RLevelVal;
    private TextView SPW;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pacingview);
        speechModel sm = speechModel.getInstance();


        RLevelVal = (TextView) findViewById(R.id.readingLevelValDisp);
        SPW = (TextView) findViewById(R.id.avgspw);
        int rl = sm.getActualReadingLevel();
        int spwActual = sm.getSPWActual();
        RLevelVal.setText(""+rl);
        SPW.setText(""+ spwActual);



    }
}
