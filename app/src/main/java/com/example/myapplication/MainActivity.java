package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText pdf1, pdf2, pdf3, pdf4, pdf5;

    private String TAGNAME = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pdf1 = (EditText) findViewById(R.id.editText1);
        pdf2 = (EditText) findViewById(R.id.editText2);
        pdf3 = (EditText) findViewById(R.id.editText3);
        pdf4 = (EditText) findViewById(R.id.editText4);
        pdf5 = (EditText) findViewById(R.id.editText5);
    }

    public void startDownload(View v){
        Log.e(TAGNAME, "startDownload");
        ArrayList<String> fileLocations = getFiles();
        Intent serviceIntent =  new Intent(this, BackGroundService.class);
        Bundle b = new Bundle();
        b.putStringArrayList("fileLocations", fileLocations);
        serviceIntent.putExtras(b);
        startService(serviceIntent);
    }
    private ArrayList<String> getFiles(){
        ArrayList<String> fileLocations = new ArrayList<String>();
        String s = pdf1.getText().toString();
        fileLocations.add(s);
        s = pdf2.getText().toString();
        fileLocations.add(s);
        s = pdf3.getText().toString();
        fileLocations.add(s);
        s = pdf4.getText().toString();
        fileLocations.add(s);
        s = pdf5.getText().toString();
        fileLocations.add(s);
        Log.e(TAGNAME, "get Files" + fileLocations);
        return fileLocations;
    }


}