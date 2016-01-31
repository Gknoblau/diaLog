package ca.knoblauch.dialog;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.results);
        speechModel sm = speechModel.getInstance();

        pacing = (Button) findViewById(R.id.pacingView);
        flaggedWords = (Button) findViewById(R.id.flaggedWordsView);
        readingLevel = (Button) findViewById(R.id.readingLevelView);
        script = (Button)findViewById(R.id.script);
        home = (Button) findViewById(R.id.home);

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
