package com.example.lyb.sharedpreferencesa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import es.dmoral.toasty.Toasty;

import static com.example.lyb.sharedpreferencesa.R.mipmap.ic_launcher;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toasty.error(MainActivity.this,"你是谁？", Toast.LENGTH_SHORT,true).show();
        Toasty.success(MainActivity.this, "Success!", Toast.LENGTH_SHORT, true).show();
        Toasty.info(MainActivity.this, "Here is some info for you.", Toast.LENGTH_SHORT, true).show();
        Toasty.warning(MainActivity.this, "Beware of the dog.", Toast.LENGTH_SHORT, true).show();
        Toasty.normal(MainActivity.this, "Normal toast w/o icon").show();

        //Toasty.normal(MainActivity.this, "Normal toast w/ icon", ic_launcher).show();


    }
}
