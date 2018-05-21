package com.example.administrator.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class bemane extends AppCompatActivity {

    private EditText textHeight;
    private EditText textWeight;

    private TextView labelBeforeHeight;
    private TextView labelBeforeWeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bemane);

        textHeight = (EditText)findViewById(R.id.editText_height);
        textWeight = (EditText)findViewById(R.id.editText_weight);

        Button button = (Button)findViewById(R.id.button);
        Button nextActive = (Button)findViewById(R.id.button_dispaly_next);

        labelBeforeHeight = (TextView)findViewById(R.id.label_before_height);
        labelBeforeWeight = (TextView)findViewById(R.id.label_before_weight);

        nextActive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(bemane.this, ResultActivity.class);
                intent.putExtra("HEIGHT", Integer.parseInt(textHeight.getText().toString()));
                intent.putExtra("WEIGHT", Integer.parseInt(textWeight.getText().toString()));
                startActivity(intent);
            }
        });

        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.label_bim_description);
        builder.setPositiveButton(R.string.button_close_dialog, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                setResult(RESULT_OK);
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int height = Integer.parseInt(textHeight.getText().toString());
                int weight = Integer.parseInt(textWeight.getText().toString());

                int bmi = 10000 * weight / height / height;
                builder.setMessage(String.valueOf(bmi));
                builder.create();
                builder.show();
            }
        });
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK){
            SharedPreferences preferences = getSharedPreferences("PREFERENCES_RESULT", MODE_PRIVATE);
            labelBeforeHeight.setText(String.valueOf(preferences.getInt("PREFERENCES_HEIGHT", 0)));
            labelBeforeWeight.setText(String.valueOf(preferences.getInt("PREFERENCES_WEIGHT", 0)));
        }
    }
}
