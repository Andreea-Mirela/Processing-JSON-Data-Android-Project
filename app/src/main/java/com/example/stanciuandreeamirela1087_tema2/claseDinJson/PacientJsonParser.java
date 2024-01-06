package com.example.stanciuandreeamirela1087_tema2.claseDinJson;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class PacientJsonParser {

    public static final String NUME = "nume";
    public static final String VARSTA = "varsta";
    public static final String REZULTAT = "rezultat";
    public static final String MEDIC_FAMILIE = "medicFamilie";
    public static final String NUME_MEDIC = "numeMedic";
    public static final String SPECIALIZARE = "specializare";
    public static final String ANI_EXPERIENTA = "aniExperienta";
    public static final String CENTRU_SANITAR = "centruSanitar";
    public static final String DENUMIRE = "denumire";
    public static final String CAPACITATE_PACIENTI = "capacitatePacienti";
    public static final String NR_PERSONAL_MEDICAL = "nrPersonalMedical";
    public static final String MANAGER = "manager";

    public static List<Pacient> fromJson(String json) {
        if(json == null || json.isEmpty()) {
            Log.i("tag1" ,"Am ajuns in for");
            return new ArrayList<>();
        }
        try {
            JSONArray array = new JSONArray(json);
            return preiaPacientiDinJson(array);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    private static List<Pacient> preiaPacientiDinJson(JSONArray array) throws JSONException {
        List<Pacient> listaPacienti = new ArrayList<>();
//        List<MedicFamilie> listaMedici = new ArrayList<>();
//        List<CentruSanitar> listaCentreSanitare = new ArrayList<>();
        for(int i = 0; i < array.length(); i++) {

            JSONObject objectPacient = array.getJSONObject(i);

            String numePacient = objectPacient.getString(NUME);
            int varstaPacient = objectPacient.getInt(VARSTA);
            String rezultatPacient = objectPacient.getString(REZULTAT);

            JSONObject objectMedic = objectPacient.getJSONObject(MEDIC_FAMILIE);
            String numeMedic = objectMedic.getString(NUME_MEDIC);
            String specializare = objectMedic.getString(SPECIALIZARE);
            int aniExperienta = objectMedic.getInt(ANI_EXPERIENTA);

            JSONObject objectCentruSanitar = objectMedic.getJSONObject(CENTRU_SANITAR);
            String denumireCentru = objectCentruSanitar.getString(DENUMIRE);
            int capacitatePacienti = objectCentruSanitar.getInt(CAPACITATE_PACIENTI);
            int nrPersonalMedical = objectCentruSanitar.getInt(NR_PERSONAL_MEDICAL);
            String manager = objectCentruSanitar.getString(MANAGER);
            CentruSanitar centruSanitar = new CentruSanitar(denumireCentru,capacitatePacienti,nrPersonalMedical,manager);
            MedicFamilie medicFamilie = new MedicFamilie(numeMedic,specializare,aniExperienta,centruSanitar);
            Pacient pacient = new Pacient(numePacient, varstaPacient, rezultatPacient, medicFamilie);
//            listaMedici.add(medicFamilie);
//            listaCentreSanitare.add(centruSanitar);

            listaPacienti.add(pacient);
        }
        return listaPacienti;
    }
}
