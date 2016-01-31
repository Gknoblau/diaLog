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
    private Boolean isTargetSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.clarityview);
        speechModel sm = speechModel.getInstance();

        actualReadLevel = (TextView) findViewById(R.id.actualReadLevel);
        targetReadLevel = (TextView) findViewById(R.id.targetReadLevel);
        actualWordsMinute = (TextView) findViewById(R.id.actualWordsMinute);
        targetWordsMinute = (TextView) findViewById(R.id.targetWordsMinute);
        hammingDistance = (TextView) findViewById(R.id.hammingDistance);

        isTargetSet = sm.isTargetIsSet();
        if (isTargetSet == true){
            targetReadLevel.setText(""+sm.getTargetReadingLevel());
            targetWordsMinute.setText(""+sm.getTargetPacing());
            hammingDistance.setText(""+sm.getLevnshteinDistance());
        } else {
            targetReadLevel.setText("N/A");
            targetWordsMinute.setText("N/A");
            hammingDistance.setText("N/A");
        }
        actualReadLevel.setText(""+sm.getActualReadingLevel());
        actualWordsMinute.setText(""+sm.getActualPacing());







    }
}
