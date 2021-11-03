package com.example.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SharedElementCallback;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private Button buttonNev, buttonInformacio;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        buttonNev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);

                finish();
            }
        });
        buttonInformacio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences=getSharedPreferences("Data", Context.MODE_PRIVATE);
                String seged= sharedPreferences.getString("nev", "Nincs ilyen név");
                Toast.makeText(MainActivity.this, seged, Toast.LENGTH_SHORT).show();
            }
        });
    }



    public void init(){
        buttonNev= findViewById(R.id.buttonNev);
        buttonInformacio= findViewById(R.id.buttonInformacio);
    }
}