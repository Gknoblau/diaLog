package ca.knoblauch.dialog;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by gknoblau on 2016-01-30.
 */
public class ResultsActivity extends Activity{
    private Button pacing;
    private Button flaggedWords;
    private Button readingLevel;
    private Button script;
    private Button importScript;
    private Button home;
    private TextView timeView;
    private int time;
    private int mins;
    private int seconds;

    private TextView readVal;

    private TextView fv;
    private TextView pacingVal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.results);
        speechModel sm = speechModel.getInstance();

        timeView = (TextView) findViewById(R.id.time);
        pacing = (Button) findViewById(R.id.pacingView);
        flaggedWords = (Button) findViewById(R.id.flaggedWordsView);
        fv = (TextView) findViewById(R.id.flaggedWordsValue);

        readVal = (TextView) findViewById(R.id.readingLevelValue);
        pacingVal = (TextView) findViewById(R.id.pacingValue);

        readingLevel = (Button) findViewById(R.id.readingLevelView);

        script = (Button)findViewById(R.id.script);
        home = (Button) findViewById(R.id.home);
        importScript = (Button) findViewById(R.id.importText);

        time = sm.getActualTime();
        mins = time/60;
        seconds = time%60;
        if (seconds < 10 ){
            timeView.setText("" +mins + ": 0" + seconds);

        } else {
            timeView.setText("" +mins + ": " + seconds);

        }

        pacingVal.setText(""+sm.getActualPacing());
        fv.setText("" + sm.getTotalFlaggedWords());
        readVal.setText("" + sm.getActualReadingLevel());
//        pacingVal.setText(""+sm.getActualPacing());

        pacing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent7 = new Intent(view.getContext(), PacingActivity.class);
                startActivity(intent7);
            }
        });
        flaggedWords.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(view.getContext(), FilterWordActivity.class);
                startActivity(intent1);
            }
        });
        readingLevel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(view.getContext(), ClarityActivity.class);
                startActivity(intent2);
            }
        });
        script.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(view.getContext(), ScriptActivity.class);
                startActivity(intent3);
            }
        });
        importScript.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent27 = new Intent(view.getContext(), ImportScriptActivity.class);
                startActivity(intent27);
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent4 = new Intent(view.getContext(), StartActivity.class);
                startActivity(intent4);
            }
        });
    }
}
