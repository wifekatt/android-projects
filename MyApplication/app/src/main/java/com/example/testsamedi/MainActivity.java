package com.example.testsamedi;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText entryNumber;
    RadioButton euroToDinar,dinarToEuro;
    Intent i;
    private static final int REQUEST_CODE = 0;
    private EditText entryNumber1;
    private Button start;



    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        if (requestCode == REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                Toast.makeText(this, "Resultat =" + intent.getDoubleExtra("resultat", 0), Toast.LENGTH_LONG).show();

            }
        }
    }
    public void convert(View view) {
        Double value = Double.parseDouble((entryNumber1.getText()).toString());
        if (euroToDinar.isChecked() && value != 0) {
            i = new Intent(this, MainActivity.class);
            i.putExtra("val", value * 3.25);
        }

        if (dinarToEuro.isChecked() && value != 0) {
            i = new Intent(this, MainActivity.class);
            i.putExtra("val", value / 3.25);
        }
        startActivityForResult(i,REQUEST_CODE);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        euroToDinar=findViewById(R.id.euroToDinar);
        dinarToEuro=findViewById(R.id.dinarToEuro);
        this.entryNumber1=findViewById(R.id.entryNumber);
        this.start=findViewById(R.id.butStart);}}