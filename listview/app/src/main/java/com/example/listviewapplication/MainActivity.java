package com.example.listviewapplication;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import android.os.Bundle;

import java.util.List;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView listview;
    Button Button;
    EditText GetValue;
    String[] ListElements = new String[] {

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listview = (ListView) findViewById(R.id.listView1);
        Button = (Button) findViewById(R.id.button1);
        GetValue = (EditText)findViewById(R.id.editText1);

        final List<String> ListElementsArrayList = new ArrayList<String>(Arrays.asList(ListElements));


        final ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (MainActivity.this, android.R.layout.simple_list_item_1, ListElementsArrayList);

        listview.setAdapter(adapter);

        Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ListElementsArrayList.add(GetValue.getText().toString());

                adapter.notifyDataSetChanged();
            }
        });
    }
}