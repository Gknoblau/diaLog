package ca.knoblauch.dialog;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * Created by Dev on 2016-01-30.
 */
public class FilterWordActivity extends Activity  {
    //private Chronometer speechtimer;
    private ListView flaggedWordListView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.filterwords);

//        List<String> myList = new ArrayList<String>();
//        myList.add("test1");
//        myList.add("test2");
//        myList.add("test3");
//        myList.add("test4");

        //speechtimer = (Chronometer) findViewById(R.id.speechTimer);
        //txtSpeechOutput = (TextView) findViewById(R.id.txtSpeechOutput);
        flaggedWordListView = (ListView) findViewById(R.id.flaggedWord);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //getMenuInflater().inflate((R.me));
        return true;
    }
}
