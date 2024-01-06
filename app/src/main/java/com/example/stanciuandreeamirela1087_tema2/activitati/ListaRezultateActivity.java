package com.example.stanciuandreeamirela1087_tema2.activitati;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.stanciuandreeamirela1087_tema2.R;
import com.example.stanciuandreeamirela1087_tema2.asyncTask.AsyncTaskRunner;
import com.example.stanciuandreeamirela1087_tema2.asyncTask.Callback;
import com.example.stanciuandreeamirela1087_tema2.claseDinJson.CentruSanitar;
import com.example.stanciuandreeamirela1087_tema2.claseDinJson.MedicFamilie;
import com.example.stanciuandreeamirela1087_tema2.claseDinJson.Pacient;
import com.example.stanciuandreeamirela1087_tema2.claseDinJson.PacientAdapter;
import com.example.stanciuandreeamirela1087_tema2.claseDinJson.PacientJsonParser;
import com.example.stanciuandreeamirela1087_tema2.network.HttpManager;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class ListaRezultateActivity extends AppCompatActivity {
    private static final String URL_REZULTATE_TESTE_COVID = "https://jsonkeeper.com/b/0M2L";

    Intent intent;

    private Button buttonMeniuPrincipal;
    private ListView lvRezultate;
    private List<Pacient> listaPacienti = new ArrayList<>();

    CentruSanitar centruSanitar = new CentruSanitar("Regina Maria", 30, 50, "Popescu Mihai");
    MedicFamilie medicFamilie = new MedicFamilie("Anghel Ion", "Cardiologie", 10, centruSanitar);
    Pacient pacient = new Pacient("Ilie Razvan", 23, "testat pozitiv", medicFamilie);

    private AsyncTaskRunner asyncTaskRunner = new AsyncTaskRunner();

    private List<CentruSanitar> listaCentreSanitare=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_rezultate);

        listaPacienti.add(pacient);

        initializareComponente();

        listaPacientiAdapter();

        buttonMeniuPrincipal.setOnClickListener( buttonMeniuPrincipalEvenimentClick());

        preiaPacientiDinHttp();

        intent = getIntent();


    }

    private void initializareComponente() {
        buttonMeniuPrincipal = findViewById(R.id.stanciu_andreea_btn_meniu_principal);
        lvRezultate = findViewById(R.id.stanciu_andreea_lv_rezultate);
    }


    private void listaPacientiAdapter() {
        PacientAdapter adapter = new PacientAdapter(getApplicationContext(), R.layout.lv_rezultate,listaPacienti,getLayoutInflater());
        lvRezultate.setAdapter(adapter);
        notifyAdapter();
    }


    private View.OnClickListener buttonMeniuPrincipalEvenimentClick() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
//                startActivity(intent);
                finish();
            }
        };
    }

    private void notifyAdapter() {
        ArrayAdapter adapter = (ArrayAdapter) lvRezultate.getAdapter();
        adapter.notifyDataSetChanged();
    }

    private void preiaPacientiDinHttp() {
        Callable<String> asyncOperation = new HttpManager(URL_REZULTATE_TESTE_COVID);
        Callback<String> mainThreadOperation = getMainThreadOperationForPatients();
        asyncTaskRunner.executeAsync(asyncOperation,mainThreadOperation);
    }

    private Callback<String> getMainThreadOperationForPatients() {
        return new Callback<String>() {
            @Override
            public void runResultOnUiThread(String result) {
                Toast.makeText(getApplicationContext(), R.string.json , Toast.LENGTH_SHORT).show();
                listaPacienti.addAll(PacientJsonParser.fromJson(result));
                notifyAdapter();
            }
        };
    }

    private List<CentruSanitar> preiaListaCentreSanitare()
    {
        List<CentruSanitar> listaCentreSanitare = new ArrayList<>();

        for (Pacient pacient: listaPacienti) {
            String denumireCentru = pacient.getMedicFamilie().getCentruSanitar().getDenumire();
            int capacitateCentru = pacient.getMedicFamilie().getCentruSanitar().getCapacitate();
            int personalCentru = pacient.getMedicFamilie().getCentruSanitar().getPersonal();
            String manager = pacient.getMedicFamilie().getCentruSanitar().getManager();

            CentruSanitar centruSanitar = new CentruSanitar(denumireCentru,capacitateCentru,personalCentru,manager);
            Log.i("tag",centruSanitar.toString());
            listaCentreSanitare.add(centruSanitar);
        }

        return listaCentreSanitare;
    }

}