package com.example.administrator.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = (Button)findViewById(R.id.main_button);
        Button btn1 = (Button)findViewById(R.id.main_btn);
        assert btn1 != null;

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText edit = (EditText)findViewById(R.id.main_edit);
                String st = edit.getText().toString();

                Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto :"));
                intent.putExtra(intent.EXTRA_EMAIL, new String[] {st});
                intent.putExtra(intent.EXTRA_SUBJECT, "메일 송신 : ");
                intent.putExtra(intent.EXTRA_TEXT, "안녕하세요. 첨부확인 바랍니다.");
                Log.d("123",intent.EXTRA_EMAIL);
                Log.d("123",intent.EXTRA_SUBJECT);
                Log.d("123",intent.EXTRA_TEXT);
                startActivity(intent);
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editText = (EditText)findViewById(R.id.main_editText);
                String str = editText.getText().toString();

                Intent intent = new Intent(MainActivity.this, OtherActivity.class);
                intent.putExtra("message", str);
                intent.putExtra("content", "MainActivity에서 화면 가져옴");
                startActivity(intent);
            }
        });
    }
}
