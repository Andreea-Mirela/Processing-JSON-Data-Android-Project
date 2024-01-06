package com.example.stanciuandreeamirela1087_tema2.activitati;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.stanciuandreeamirela1087_tema2.R;
import com.example.stanciuandreeamirela1087_tema2.claseDinJson.CentruSanitar;

import java.io.Serializable;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private Button buttonCentre;
    private Button buttonRezultate;

    private List<CentruSanitar> listaCentreSanitare ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonCentre = findViewById(R.id.stanciu_andreea_btn_adauga_centre);
        buttonCentre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_centre = new Intent(getApplicationContext(), ListaCentreActivity.class);
                startActivity(intent_centre);
            }
        });

        buttonRezultate = findViewById(R.id.stanciu_andreea_btn_rezultate);
        buttonRezultate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_rezultate = new Intent(getApplicationContext(), ListaRezultateActivity.class);
                startActivity(intent_rezultate);
            }
        });
    }
}