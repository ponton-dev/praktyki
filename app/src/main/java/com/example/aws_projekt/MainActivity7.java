package com.example.aws_projekt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.FileInputStream;

public class MainActivity7 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);

        Button bt1 = findViewById(R.id.wyswietl);
        TextView txt1 = findViewById(R.id.text);

        Button powrot = findViewById(R.id.powrot);
        Intent in1 = new Intent(this, MainActivity5.class);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    FileInputStream input = openFileInput("dane2");
                    int c;
                    String temp = "";

                    while ((c = input.read()) != -1) {
                        temp = temp + Character.toString((char) c);
                    }

                    String[] temp_split = temp.split(" ");
                    txt1.setText(temp);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        });

        powrot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(in1);
            }
        });
    }
}