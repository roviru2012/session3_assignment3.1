package com.varunkumar.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;


public class MainActivity extends AppCompatActivity {

    EditText text;
    Button search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text= (EditText) findViewById(R.id.editText);
        search= (Button) findViewById(R.id.button);


        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "search start", Toast.LENGTH_SHORT).show();
                String dataSearch = text.getText().toString();
                Intent intent =new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                try {
                    dataSearch= URLEncoder.encode(dataSearch,"UTF-8");

                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();

                }
                intent. setData(Uri.parse("https://www.google.co.in/#q="+dataSearch));
                startActivity(intent);
            }
        });


    }
}
