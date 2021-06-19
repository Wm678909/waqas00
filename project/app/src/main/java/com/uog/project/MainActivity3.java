package com.uog.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity3 extends AppCompatActivity {
Button r1,c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
    r1 =findViewById(R.id.button);
    c = findViewById(R.id.c1);
    r1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent1 = new Intent(MainActivity3.this,MainActivity.class);
            startActivity(intent1);
        }
    });
    c.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent2 = new Intent(MainActivity3.this,MainActivity2.class);
            startActivity(intent2);
        }
    });
    }
}