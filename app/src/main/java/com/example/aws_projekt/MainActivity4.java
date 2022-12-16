package com.example.aws_projekt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.widget.*;

public class MainActivity4 extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        TextView wroc = findViewById(R.id.wroc);
        EditText ed1 = findViewById(R.id.ed1);
        EditText ed2 = findViewById(R.id.ed2);
        EditText ed3 = findViewById(R.id.ed3);
        Button bt1 = findViewById(R.id.bt1);
        TextView txt2 = findViewById(R.id.txt2);




        Spinner spinner = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.spin, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);






        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String text = spinner.getSelectedItem().toString();

                String pomoc = "";

                if (text.equals("Nauczyciel")) {
                    pomoc = "n/";
                }
                if (text.equals("Student")) {
                    pomoc = "s/";
                }
                if (text.equals("Administrator")) {
                    pomoc = "a/";
                }


                Pattern p4 = Pattern.compile(".{4,}");
                Matcher m4 = p4.matcher(ed1.getText().toString());

                if(ed1.getText().toString().isEmpty() == false && m4.find()  && ed2.getText().toString().equals(ed3.getText().toString()) && ed2.getText().toString().isEmpty() == false && ed3.getText().toString().isEmpty() == false )
                {


                    String file = "dane";


                    Pattern p = Pattern.compile("[0-9]+");
                    Matcher m = p.matcher(ed2.getText().toString());

                    Pattern p2 = Pattern.compile("[0-9]+");
                    Matcher m2 = p2.matcher((ed3.getText().toString()));

                    Pattern p3 = Pattern.compile("[A-Z][a-zA-Z]*");
                    Matcher m3 = p3.matcher(ed2.getText().toString());

                    if(m3.find() && m.find() && m2.find())
                    {

                        String superstring = pomoc + " " + ed1.getText().toString() + " " + ed2.getText().toString() + " " + ed3.getText().toString() + "\n";

                        try {
                            FileOutputStream fout = openFileOutput(file, MODE_PRIVATE);
                            fout.write(superstring.getBytes());
                            fout.close();
                            File filedir = new File(getFilesDir(), file);
                            Toast.makeText(getBaseContext(), "Plik zapisano: " + filedir, Toast.LENGTH_LONG).show();

                        } catch (Exception e) {
                            e.printStackTrace();
                        }


                    }
                    else{
                        txt2.setText("spróbuj dodać dużą literę i cyfre");
                    }

                } else
                {
                    txt2.setText("Pole jest puste albo hasło się nie zgadza LUB login ma mniej niż 4 znaki");
                }


            }
        });



}



    public void powrot(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}