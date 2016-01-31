package ca.knoblauch.dialog;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
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
        flaggedWordListView = (ListView) findViewById(R.id.flaggedWordListView);
        speechModel sm = speechModel.getInstance();
        Map flaggedWords = sm.getActualWordDicCount();


        List<String> flaggedWordList = new ArrayList<String>();
        List<String> swears= Arrays.asList("fuck", "shit", "um","uh","damn","darn");
        int Count =0;

        for (int i = 0; i < swears.size(); i++) {
            if (flaggedWords.get(swears.get(i))!=null){
                flaggedWordList.add(swears.get(i)+": " + (flaggedWords.get("fuck") ));
                Count++;
            }
        }
        if(Count==0) {
            flaggedWordList.add("No flagged words detected");

        }
//        flaggedWordList.add("fuck: " + (flaggedWords.get("fuck") );
//        flaggedWordList.add("shit: ");
//        flaggedWordList.add("um: ");
//        flaggedWordList.add("like: ");
//        flaggedWordList.add("damn: ");
//        flaggedWordList.add("darn: ");
//        ListAdapter la  = new ArrayAdapter<String>(this, );
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                flaggedWordList );
        flaggedWordListView.setAdapter(arrayAdapter);
//        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
//                this,
//                android.R.layout.simple_list_item_1,
//                your_array_list );
//        myList.add("test1");
//        myList.add("test2");
//        myList.add("test3");
//        myList.add("test4");

        //speechtimer = (Chronometer) findViewById(R.id.speechTimer);
        //txtSpeechOutput = (TextView) findViewById(R.id.txtSpeechOutput);



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //getMenuInflater().inflate((R.me));
        return true;
    }
}
