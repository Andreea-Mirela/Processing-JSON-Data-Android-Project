package com.example.stanciuandreeamirela1087_tema2.activitati;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.stanciuandreeamirela1087_tema2.claseDinJson.CentruSanitar;
import com.example.stanciuandreeamirela1087_tema2.R;
import com.google.android.material.textfield.TextInputEditText;

public class FormActivity extends AppCompatActivity {

    public static final String CENTRU_KEY = "centru_key";

    private TextInputEditText tietDenumire;
    private TextInputEditText tietCapacitate;
    private TextInputEditText tietPersonal;
    private TextInputEditText tietManager;
    private Button btnAdauga;

    private Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        initializareComponente();

        btnAdauga.setOnClickListener(adaugaClickEvent());

        intent = getIntent();
    }

    private void initializareComponente() {
        tietDenumire = findViewById(R.id.stanciu_andreea_tied_denumire);
        tietCapacitate = findViewById(R.id.stanciu_andreea_tied_capacitate);
        tietPersonal = findViewById(R.id.stanciu_andreea_tied_personal);
        tietManager = findViewById(R.id.stanciu_andreea_tied_manager);
        btnAdauga = findViewById(R.id.stanciu_andreea_btn_adauga);
    }

    private View.OnClickListener adaugaClickEvent() {
        return new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(validare()) {
                    CentruSanitar centruSanitar = construiesteCentruSanitar();
                    intent.putExtra(CENTRU_KEY, centruSanitar);
                    setResult(RESULT_OK, intent);
                    finish();
                }
            }
        };
    }

    private boolean validare() {
        if(tietDenumire.getText() == null || tietDenumire.getText().toString().trim().length() < 4)
        {
            Toast.makeText(getApplicationContext(), R.string.descriere_invalida, Toast.LENGTH_LONG).show();
            return false;
        }
        if(tietCapacitate.getText() == null || Integer.parseInt(tietCapacitate.getText().toString().trim()) < 20)
        {
            Toast.makeText(getApplicationContext(), R.string.capacitate_invalida, Toast.LENGTH_LONG).show();
            return false;
        }
        if(tietPersonal.getText() == null || Integer.parseInt(tietPersonal.getText().toString().trim()) < 10)
        {
            Toast.makeText(getApplicationContext(), R.string.personal_invalid, Toast.LENGTH_LONG).show();
            return false;
        }
        if(tietManager.getText() == null || tietManager.getText().toString().trim().length() < 5)
        {
            Toast.makeText(getApplicationContext(), R.string.manager_invalid, Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }

    private CentruSanitar construiesteCentruSanitar() {
        String denumire = tietDenumire.getText().toString();
        int capacitate = Integer.parseInt(tietCapacitate.getText().toString().trim());
        int personal = Integer.parseInt(tietPersonal.getText().toString().trim());
        String manager = tietManager.getText().toString();

        return new CentruSanitar(denumire,capacitate,personal,manager);
    }
}