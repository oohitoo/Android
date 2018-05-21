package com.example.administrator.myapplication;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    private int height = 0;
    private int weight = 0;
    private int bim = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);

        TextView bimValue = (TextView)findViewById(R.id.label_bmivalue);
        TextView status = (TextView)findViewById(R.id.label_status);

        Bundle extras = getIntent().getExtras();

        if(extras != null){
            height = extras.getInt("HEIGHT");
            weight = extras.getInt("WEIGHT");

            bim = 10000 * weight / height / height ;
            bimValue.setText(String.valueOf(bim));

            if(bim >= 40){
                status.setText(R.string.label_bim_fat4);
            }else if(bim >=35){
                status.setText(R.string.label_bim_fat3);
            }else if(bim >= 30){
                status.setText(R.string.label_bim_fat2);
            }else if(bim >= 25){
                status.setText(R.string.label_bim_fat1);
            }else if(bim >= 18.5){
                status.setText(R.string.label_bim_normal);
            }else{
                status.setText(R.string.label_bim_under);
            }
        }
        Button saveResult = (Button)findViewById(R.id.button_save_result);
        Button notsave = (Button)findViewById(R.id.buton_not_save_return);
        saveResult.setOnClickListener(saveResultListener);
        notsave.setOnClickListener(notResultListener);
    }

    private View.OnClickListener saveResultListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            SharedPreferences preferences = getSharedPreferences("PREFERENCES_RESULT", MODE_PRIVATE);
            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt("PREVIOUS_HEIGHT", height);
            editor.putInt("PREVIOUS_WEIGHT", weight);

            editor.commit();
            setResult(RESULT_OK);
            finish();
        }
    };

    private View.OnClickListener notResultListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            setResult(RESULT_CANCELED);
            finish();
        }
    };
}
