package com.example.aws_projekt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Arrays;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Button bt2 = findViewById(R.id.back);
        Button bt1 = findViewById(R.id.wyswietl);
        TextView uczniowie = findViewById(R.id.uczniowie);

        Intent in3 = new Intent(this, MainActivity.class);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = getIntent();
                String[] text = intent.getStringArrayExtra("klucz");
                uczniowie.setText(Arrays.toString(text));
            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(in3);
            }
        });
    }
}