package com.example.os_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Second extends AppCompatActivity {

    TextView diskMove, timeMove;
    Button again;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        diskMove = (TextView) findViewById(R.id.move_id);
        timeMove = (TextView) findViewById(R.id.time_id);
        again = (Button) findViewById(R.id.again_btn);
        diskMove.setText("");
        timeMove.setText("");

        Intent receive_data = getIntent();
        String received_data_str = receive_data.getStringExtra("Data");
        Todo todo = new Todo(0);
        todo.main(received_data_str);
        String disk_movement = todo.getPrinted_res();
        String time = String.valueOf(todo.getTime());

        diskMove.setText(disk_movement);
        timeMove.setText(time);

        again.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent toSecond = new Intent(Second.this, First.class);
                        startActivity(toSecond);
                        finish();
                    }
                },0);
            }
        });




    }
}