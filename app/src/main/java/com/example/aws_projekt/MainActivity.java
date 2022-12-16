package com.example.aws_projekt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText ed0 = findViewById(R.id.ed0);
        Button bt1 = findViewById(R.id.button);
        EditText ed1 = findViewById(R.id.textView2);
        EditText ed2 = findViewById(R.id.txt3);
        TextView reg = findViewById(R.id.reg);

        Intent in1 = new Intent(this, MainActivity2.class);
        Intent in2 = new Intent(this, MainActivity3.class);
        Intent in3 = new Intent(this, MainActivity6.class);


        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    FileInputStream input = openFileInput("dane");
                    int c;
                    String temp = "";

                    while ((c = input.read()) != -1) {
                        temp = temp + Character.toString((char) c);
                    }

                    String[] temp_split = temp.split(" ");



                    if(ed0.getText().toString().equals(temp_split[0])  && ed1.getText().toString().equals(temp_split[1]) && ed2.getText().toString().equals(temp_split[2]))
                    {
                        if(ed0.getText().toString().contains("s"))
                        {
                            startActivity(in1);


                        }
                        if(ed0.getText().toString().contains("n"))
                        {
                            startActivity(in3);
                        }
                        if(ed0.getText().toString().contains("a"))
                        {
                            in2.putExtra("klucz", temp_split);
                            startActivity(in2);
                        }






                    }else
                    {
                        Toast.makeText(getApplicationContext(), "coś poszło nie tak", Toast.LENGTH_LONG).show();

                    }

                } catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        });
    }

    public void new_ac (View view)
    {
        Intent intent = new Intent (this, MainActivity4.class);
        startActivity(intent);
    }

}