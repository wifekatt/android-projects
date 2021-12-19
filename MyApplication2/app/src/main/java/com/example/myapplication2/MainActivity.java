package com.example.testsamedi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication2.R;

import java.text.DecimalFormat;

public class MainActivity2 extends AppCompatActivity {

    public double result;
    TextView textView;
    private EditText entryNumber2;

    private ImageButton ImageButArrowBack;
    private ImageButton ImageButCall;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        getSupportActionBar().hide();
        textView=findViewById(R.id.textView2);
        ImageButArrowBack=findViewById(R.id.imageButArrowBack);
        ImageButCall=findViewById(R.id.imageButCall);
        result= getIntent().getDoubleExtra("val",0);
        textView.setText("res :"+result);

    }
    public void retour(View v)
    {
        Intent returnIntent = new Intent();
        returnIntent.putExtra("resultat",result);
        setResult(RESULT_OK,returnIntent);

        finish();
    }
    public void call(View view)
    {
        String phone = "+21650681055";
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null));
        startActivity(intent);
    }
}