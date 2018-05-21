package com.example.administrator.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class OtherActivity extends AppCompatActivity {

    private EditText latitude;
    private EditText longitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);

        final Intent intent = getIntent();

//        if(intent.getAction().equals(Intent.ACTION_SENDTO)){
//            String[] message = intent.getStringArrayExtra(intent.EXTRA_EMAIL);
//            EditText editText = (EditText)findViewById(R.id.main_editText);
//            editText.setText("Mail to : "+ message[0]);
//
//            String str1 = intent.getStringExtra(intent.EXTRA_SUBJECT);
//            String str2 = intent.getStringExtra(intent.EXTRA_TEXT);
//
//            Toast toast = Toast.makeText(OtherActivity.this, str1 + str2, Toast.LENGTH_LONG);
//            toast.show();
//        }
//        Button button = (Button)findViewById(R.id.Other_button);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(OtherActivity.this, MainActivity.class);
//                startActivity(intent);
//            }
//        });
        String message = intent.getStringExtra("message");
        String content = intent.getStringExtra("content");

        EditText edit = (EditText)findViewById(R.id.main_editText);
        edit.setText(message);
        Toast toast = Toast.makeText(OtherActivity.this, content, Toast.LENGTH_LONG);
        toast.show();

        Button btn2 = (Button)findViewById(R.id.Other_button);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OtherActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        latitude = (EditText)findViewById(R.id.editText);
        longitude = (EditText)findViewById(R.id.editText2);
        Button but = (Button)findViewById(R.id.button);

        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("geo:"+ latitude.getText().toString()+ "," + longitude.getText().toString());
                Log.d("eeeee", uri+"");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        Button next = (Button)findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(OtherActivity.this, bemane.class);
                startActivity(intent1);
            }
        });
    }
}
