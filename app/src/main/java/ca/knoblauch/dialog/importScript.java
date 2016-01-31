package ca.knoblauch.dialog;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by gknoblau on 2016-01-31.
 */
public class importScript extends Activity {
    public Button btnImportScript;
    public EditText

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.importscript);

        btnImportScript = (Button) findViewById(R.id.)

        btnImportScript.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scriptInput.getText();
            }
        });
    }
}
