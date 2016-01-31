package ca.knoblauch.dialog;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.FileOutputStream;

/**
 * Created by gknoblau on 2016-01-30.
 */
public class results extends Activity{
    private Button pacing;
    private Button flaggedWords;
    private Button readingLevel;
    private Button script;
    private Button home;

    private TextView readVal;

    private TextView fv;
    private TextView pacingVal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.results);
        speechModel sm = speechModel.getInstance();

        pacing = (Button) findViewById(R.id.pacingView);
        flaggedWords = (Button) findViewById(R.id.flaggedWordsView);
        fv = (TextView) findViewById(R.id.flaggedWordsValue);

        readVal = (TextView) findViewById(R.id.readingLevelValue);
        pacingVal = (TextView) findViewById(R.id.pacingValue);

        readingLevel = (Button) findViewById(R.id.readingLevelView);

        script = (Button)findViewById(R.id.script);
        home = (Button) findViewById(R.id.home);
        fv.setText("" + sm.getTotalFlaggedWords());
        readVal.setText(""+sm.getReadingLevel());
//        pacingVal.setText(""+sm.getActualPacing());
        pacing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), FilterWordActivity.class);
                startActivity(intent);
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
                Intent intent2 = new Intent(view.getContext(), FilterWordActivity.class);
                startActivity(intent2);
            }
        });
        script.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(view.getContext(), Script.class);
                startActivity(intent3);
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
