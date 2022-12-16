package com.example.aws_projekt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;

public class MainActivity6 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        Button wyslij_wiadomosc = findViewById(R.id.bt1);
        Button cofnij = findViewById(R.id.cofnij);
        EditText wiadomosc = findViewById(R.id.wiadomosc);
        Intent in1 = new Intent(this, MainActivity.class);
        Intent in2 = new Intent(this, MainActivity7.class);

        String file = "dane2";

        cofnij.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(in1);
            }
        });

        wyslij_wiadomosc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    FileOutputStream fout = openFileOutput(file, MODE_PRIVATE);
                    fout.write(wiadomosc.getText().toString().getBytes());
                    fout.close();
                    Toast.makeText(getBaseContext(), "Wysłano wiadomość ", Toast.LENGTH_LONG).show();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}