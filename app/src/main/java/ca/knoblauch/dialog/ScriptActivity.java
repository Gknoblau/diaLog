package ca.knoblauch.dialog;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by gknoblau on 2016-01-30.
 */
public class ScriptActivity extends Activity {
    private String speechText;
    private TextView speechTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.script);
        speechTextView = (TextView) findViewById(R.id.speechText);
        speechModel sm = speechModel.getInstance();
        speechText = sm.getVoiceText();
        speechTextView.setText(speechText);
    }

}
