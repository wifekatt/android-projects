package com.example.concat;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button demarrer;
    private EditText name ;
    private EditText pass ;
    final int  LAUNCH_SECOND = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        demarrer =(Button) findViewById(R.id.DemarrerBtn) ;
        name =(EditText)  findViewById(R.id.NameId)  ;
        pass =(EditText)  findViewById(R.id.PasswordId)  ;

        demarrer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(name.getText().toString().equals(pass.getText().toString())){
                    Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                    intent.putExtra("user",name.getText().toString());
                    startActivityForResult(intent,LAUNCH_SECOND);
                }else {
                    Toast.makeText(MainActivity.this,
                            "Erreur d'authentification", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}