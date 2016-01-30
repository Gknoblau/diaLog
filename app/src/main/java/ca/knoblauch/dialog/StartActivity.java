package ca.knoblauch.dialog;

import android.app.Activity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;

import java.security.AccessControlContext;
import java.util.concurrent.TimeUnit;

/**
 * Created by gknoblau on 2016-01-30.
 */

public class StartActivity extends Activity{

    Button btnStart, btnStop;
    TextView textViewTime;
    Chronometer chronometer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        btnStart = (Button) findViewById(R.id.btnStart);
        btnStop = (Button) findViewById(R.id.btnStop);
        chronometer = (Chronometer) findViewById(R.id.chronometer);
        //textViewTime = (TextView) findViewById(R.id.textViewTime);
        //textViewTime.setText("00:03:00");
        //final CounterClass timer = new CounterClass(180000, 1000);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chronometer.start();
                //timer.start();
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chronometer.stop();
                //Change to differnet view
                //timer.cancel();
            }
        });

    }

    /**public class CounterClass extends CountDownTimer {
        public CounterClass(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinshed) {
            long millis = millisUntilFinshed;
            String hms = String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(millis),
                    TimeUnit.MILLISECONDS.toMinutes(millis) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis)),
                    TimeUnit.MILLISECONDS.toSeconds((millis) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis))));
            System.out.println(hms);
            textViewTime.setText(hms);


        }

        @Override
        public void onFinish() {
            textViewTime.setText("Completed");
        }
    } **/

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //getMenuInflater().inflate((R.me));
        return true;
    }
}
