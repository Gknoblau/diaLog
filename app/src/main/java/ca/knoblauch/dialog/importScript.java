package ca.knoblauch.dialog;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by gknoblau on 2016-01-31.
 */
public class importScript extends Activity {
    public Button btnImportScript;
    public EditText scriptInput;
    public speechModel sm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.importscript);
        sm = speechModel.getInstance();

        btnImportScript = (Button) findViewById(R.id.scriptInputBtn);
        scriptInput = (EditText) findViewById(R.id.scriptInput);

        btnImportScript.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sm.setTargetText("" + scriptInput.getText());
                Intent intent12 = new Intent(view.getContext(), results.class);
                startActivity(intent12);
        }
        });
    }
}
