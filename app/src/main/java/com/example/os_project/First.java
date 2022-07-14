package com.example.os_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class First extends AppCompatActivity {
    public static int SPLASH_TO = 0;
    EditText input;
    Button paste;
    Button submit;
    ClipboardManager clipboardManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        input = (EditText) findViewById(R.id.input_text);
        paste = (Button) findViewById(R.id.paste_button);
        submit = (Button) findViewById(R.id.submit_button);

        clipboardManager = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);

        if (!clipboardManager.hasPrimaryClip()){
            paste.setEnabled(false);
        }
        paste.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClipData clipData = clipboardManager.getPrimaryClip();
                ClipData.Item item = clipData.getItemAt(0);

                input.setText(item.getText().toString());
                Toast.makeText(First.this, "pasted", Toast.LENGTH_SHORT).show();
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data_input = input.getText().toString();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent toSecond = new Intent(First.this, Second.class);
                        toSecond.putExtra("Data", data_input);
                        startActivity(toSecond);
                        finish();
                    }
                },SPLASH_TO);
            }
        });
    }
}