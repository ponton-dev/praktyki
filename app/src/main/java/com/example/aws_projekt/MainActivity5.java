package com.example.aws_projekt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        EditText mail_text = findViewById(R.id.not1);
        EditText mail_nazwa = findViewById(R.id.mail1);
        Button back = findViewById(R.id.back);
        Button wyslij = findViewById(R.id.wyslij);
        Button next = findViewById(R.id.nextac);

        Intent ostatni = new Intent(this, MainActivity7.class);


        Intent cofnij = new Intent(this, MainActivity2.class);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(cofnij);
            }
        });

        wyslij.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!mail_nazwa.getText().toString().isEmpty() && !mail_text.getText().toString().isEmpty())
                {
                    Intent intent1 = new Intent(Intent.ACTION_SEND);
                    intent1.putExtra(Intent.EXTRA_EMAIL, new String[]{mail_nazwa.getText().toString()});
                    intent1.putExtra(Intent.EXTRA_TEXT, new String[]{mail_text.getText().toString()});
                    intent1.setType("message/rfc822");
                    startActivity(intent1);
                } else
                {
                    Toast.makeText(getApplicationContext(),"POLA SĄ PUSTE", Toast.LENGTH_LONG).show();
                }

            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(ostatni);
            }
        });
    }
}