package com.example.stanciuandreeamirela1087_tema2.activitati;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.stanciuandreeamirela1087_tema2.claseDinJson.CentruSanitar;
import com.example.stanciuandreeamirela1087_tema2.claseDinJson.CentruSanitarAdapter;
import com.example.stanciuandreeamirela1087_tema2.R;

import java.util.ArrayList;
import java.util.List;

public class ListaCentreActivity extends AppCompatActivity {

    private static final int ADAUGA_CENTRU_REQUEST_CODE = 111;

    private Button buttonAdaugaCentru;
    private ListView lvCentreSanitare;
    private List<CentruSanitar> listaCentreSanitare = new ArrayList<>();

    CentruSanitar centruSanitar1 = new CentruSanitar("Policlinica Hipocrat", 50, 25, "Dobrila Ana");
    CentruSanitar centruSanitar2 = new CentruSanitar("Clinica Privata Medic Line", 30, 22, "Tanase Radu");
    CentruSanitar centruSanitar3 = new CentruSanitar("Sala Sportiva Centru", 100, 40, "Vancea Ciprian");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_centre);
        initializareComponente();

        listaCentreSanitare.add(centruSanitar1);
        listaCentreSanitare.add(centruSanitar2);
        listaCentreSanitare.add(centruSanitar3);

        listaCentreSnitareAdapter();

        buttonAdaugaCentru.setOnClickListener( butonAdaugaCentruEvenimentClick());
    }

    private void initializareComponente() {
        buttonAdaugaCentru = findViewById(R.id.stanciu_andreea_btn_adauga_centre);
        lvCentreSanitare = findViewById(R.id.stanciu_andreea_lv_centre);
    }

    private View.OnClickListener butonAdaugaCentruEvenimentClick() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), FormActivity.class);
                startActivityForResult(intent, ADAUGA_CENTRU_REQUEST_CODE);
            }
        };
    }

    private void listaCentreSnitareAdapter() {
//        ArrayAdapter<CentruSanitar> adapter = new ArrayAdapter<>(getApplicationContext(),
//                android.R.layout.simple_list_item_1,
//                listaCentreSanitare);
        CentruSanitarAdapter adapter = new CentruSanitarAdapter(getApplicationContext(), R.layout.lv_centre_sanitare,listaCentreSanitare,getLayoutInflater());
        lvCentreSanitare.setAdapter(adapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == ADAUGA_CENTRU_REQUEST_CODE && resultCode == RESULT_OK && data != null) {
            CentruSanitar centruSanitar = (CentruSanitar) data.getSerializableExtra(FormActivity.CENTRU_KEY);
            if(centruSanitar != null) {
                Toast.makeText(getApplicationContext(), "Centru medical adaugat", Toast.LENGTH_LONG).show();
                listaCentreSanitare.add(centruSanitar);
            }
            ArrayAdapter adapter = (ArrayAdapter) lvCentreSanitare.getAdapter();
            adapter.notifyDataSetChanged();
        }
    }
}