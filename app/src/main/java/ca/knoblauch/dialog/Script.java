package ca.knoblauch.dialog;

import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.text.Spannable;
import android.text.style.BackgroundColorSpan;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by gknoblau on 2016-01-30.
 */
public class Script extends Activity {
    private String speechText;
    private TextView speechTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.script);
        speechTextView = (TextView) findViewById(R.id.speechText);
        speechModel sm = speechModel.getInstance();
        speechText = sm.getText();
        // Thanks to http://stackoverflow.com/questions/6843596/android-highlight-a-word-in-a-textview and http://stackoverflow.com/questions/2120035/highlight-text-in-textview-or-webview
        //Spannable spanText = Spannable.Factory.getInstance().newSpannable(speechText);
        //spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), 1, 10, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        //speechText = speechText.replaceAll(textToHighlight,"<font color='red'>"+textToHighlight+"</font>");
        speechTextView.setText(speechText);
    }

}
