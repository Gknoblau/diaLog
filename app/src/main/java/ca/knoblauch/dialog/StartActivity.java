
package ca.knoblauch.dialog;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.speech.RecognizerIntent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.security.AccessControlContext;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created by gknoblau on 2016-01-30.
 */



public class StartActivity extends Activity{


    //private Chronometer speechtimer;
    private TextView txtSpeechOutput;
    private ImageButton btnSpeak;
    private speechModel sm = speechModel.getInstance();
    private String voiceString;
    private Boolean startAnalysis = false;
    private final int REQ_CODE_SPEECH_INPUT = 100;
    public static final String  timeTillStop = "500";
    //public String targetText;
    public EditText scriptInput;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        //speechtimer = (Chronometer) findViewById(R.id.speechTimer);
        //txtSpeechOutput = (TextView) findViewById(R.id.txtSpeechOutput);
        scriptInput = (EditText) findViewById(R.id.scriptInput);
        btnSpeak = (ImageButton) findViewById(R.id.btnSpeak);


        btnSpeak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scriptInput.getText();
                promptSpeechInput();
            }
        });
    }

    private void analysis() {
        long stopTime = System.currentTimeMillis() / 1000L;
        sm.setActualTime((int) (stopTime-startTime));
        sm.importText(voiceString);
        sm.setTargetText(""+scriptInput);
        Intent intent = new Intent(this, results.class);
        startActivity(intent);

    }

    /**
     * Showing google speech input dialog
     * */
    long startTime;
    private void promptSpeechInput() {
        startTime = System.currentTimeMillis() / 1000L;
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_SPEECH_INPUT_COMPLETE_SILENCE_LENGTH_MILLIS, 20000);
        intent.putExtra(RecognizerIntent.EXTRA_SPEECH_INPUT_POSSIBLY_COMPLETE_SILENCE_LENGTH_MILLIS, 20000);
        intent.putExtra(RecognizerIntent.EXTRA_SPEECH_INPUT_MINIMUM_LENGTH_MILLIS, 20000);


        intent.putExtra(RecognizerIntent.EXTRA_PROMPT,
                getString(R.string.speech_prompt));
        try {
            startActivityForResult(intent, REQ_CODE_SPEECH_INPUT);
        } catch (ActivityNotFoundException a) {
            Toast.makeText(getApplicationContext(),
                    getString(R.string.speech_not_supported),
                    Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Receiving speech input
     * */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case REQ_CODE_SPEECH_INPUT: {
                if (resultCode == RESULT_OK && null != data) {

                    ArrayList<String> result = data
                            .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    voiceString = (result.get(0));
                    startAnalysis = true;
                    analysis();
                    //txtSpeechOutput.setText(result.get(0));
                }
                break;
            }

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //getMenuInflater().inflate((R.me));
        return false;
    }
}
