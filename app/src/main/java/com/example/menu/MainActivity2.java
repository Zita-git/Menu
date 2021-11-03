package com.example.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    private EditText editTextNev;
    private Button buttonMentes;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        init();
        buttonMentes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(editTextNev.getText().toString().equals("")){
                    Toast.makeText(MainActivity2.this, "Nem lehet üres név", Toast.LENGTH_SHORT).show();
                    editTextNev.setError("Nem lehet üres név");
                }else{
                    editor.putString("nev", editTextNev.getText().toString());
                    boolean seged=editor.commit();
                    Log.d("Sikeres feltöltés", ""+seged);

                    Intent intent =new Intent(MainActivity2.this, MainActivity.class);
                    startActivity(intent);

                    finish();
                }

            }
        });
    }
    private void init(){
        buttonMentes=  findViewById(R.id.buttonMentes);
        editTextNev= findViewById(R.id.editTextNev);
        sharedPreferences=getSharedPreferences("Data", Context.MODE_PRIVATE);
        editor= sharedPreferences.edit();
    }
}