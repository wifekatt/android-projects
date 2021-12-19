package com.example.sqliteyoutube1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText editTextName;
    EditText editTextAge;
    Button btnAdd;
    Button btnViewAll;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextName=findViewById(R.id.editTextName);
        editTextAge=findViewById(R.id.editTextAge);
        btnAdd=findViewById(R.id.btnAdd);
        btnViewAll=findViewById(R.id.btnViewAll);
        listView=findViewById(R.id.listView);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Customer customerModel = new Customer(-1, editTextName.getText().toString(), Integer.parseInt(editTextAge.getText().toString()));
                Toast.makeText(MainActivity.this, customerModel.toString(), Toast.LENGTH_SHORT).show();
                DataBaseHandler dataBaseHelper = new DataBaseHandler(MainActivity.this,null);
                boolean b = dataBaseHelper.addOne(customerModel);
                Toast.makeText(MainActivity.this, "Succes" + b, Toast.LENGTH_SHORT).show();
            }
        });

        btnViewAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataBaseHandler dataBaseHelper = new DataBaseHandler(MainActivity.this,null);
                List<Customer> everyone = dataBaseHelper.getEveryone();
                Toast.makeText(MainActivity.this, everyone.toString(), Toast.LENGTH_SHORT).show();
                ArrayAdapter customerArrayAdapter = new ArrayAdapter<Customer>(MainActivity.this, android.R.layout.simple_list_item_1, everyone);
                listView.setAdapter(customerArrayAdapter);
            }
        });
    }
}