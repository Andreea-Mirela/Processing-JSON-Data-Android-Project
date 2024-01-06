package com.example.stanciuandreeamirela1087_tema2.claseDinJson;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.stanciuandreeamirela1087_tema2.R;

import java.util.List;

public class PacientAdapter extends ArrayAdapter<Pacient> {
    private Context context;
    private List<Pacient> listaPacienti;
    private LayoutInflater inflater;
    private int resource;
    public PacientAdapter(@NonNull Context context, int resource, @NonNull List<Pacient> objects, LayoutInflater inflater) {
        super(context, resource, objects);
        this.context = context;
        this.listaPacienti = objects;
        this.inflater = inflater;
        this.resource = resource;
    }

    @SuppressLint("SetTextI18n")
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = inflater.inflate(resource, parent, false);
        Pacient pacient = listaPacienti.get(position);
        if(pacient != null) {
            adaugaNumePacient(view, pacient.getNume());
            adaugaVarstaPacient(view, pacient.getVarsta());
            adaugaRezultatPacient(view, pacient.getRezultat());

            TextView textViewMedicNume = view.findViewById(R.id.stanciu_andreea_tv_medic_nume);
            textViewMedicNume.setText(context.getString(R.string.medic) + pacient.getMedicFamilie().getNume());

            TextView textViewMedicSpecializare = view.findViewById(R.id.stanciu_andreea_tv_medic_specializare);
            textViewMedicSpecializare.setText(pacient.getMedicFamilie().getSpecializare());

            TextView textViewMedicAniExperienta = view.findViewById(R.id.stanciu_andreea_tv_medic_ani_experienta);
            textViewMedicAniExperienta.setText(context.getString(R.string.ani) + String.valueOf(pacient.getMedicFamilie().getAniExperienta()));

            TextView textViewCentruDenumire = view.findViewById(R.id.stanciu_andreea_tv_centru_denumire);
            textViewCentruDenumire.setText(pacient.getMedicFamilie().getCentruSanitar().getDenumire());

            TextView textViewCentruCapacitate = view.findViewById(R.id.stanciu_andreea_tv_centru_capacitate);
            textViewCentruCapacitate.setText(context.getString(R.string.cap_pac) +  String.valueOf(pacient.getMedicFamilie().getCentruSanitar().getCapacitate()));

            TextView textViewCentruPersonal = view.findViewById(R.id.stanciu_andreea_tv_centru_personal);
            textViewCentruPersonal.setText(context.getString(R.string.nr_pers) + String.valueOf(pacient.getMedicFamilie().getCentruSanitar().getPersonal()));

            TextView textViewCentruManager = view.findViewById(R.id.stanciu_andreea_tv_centru_manager);
            textViewCentruManager.setText(context.getString(R.string.manager) + pacient.getMedicFamilie().getCentruSanitar().getManager());

        }
        return view;
    }

    @SuppressLint("SetTextI18n")
    private void adaugaNumePacient(View view, String nume) {
        TextView textView = view.findViewById(R.id.stanciu_andreea_tv_pacient_nume);
        //populareContinutTextView(nume, textView);
        if(nume!=null && !nume.isEmpty()) {
            textView.setText(context.getString(R.string.pacient) + nume);
        } else {
            textView.setText(R.string.nepreluat);
        }
    }

    private void populareContinutTextView(String value, TextView textView) {
        if(value!=null && !value.isEmpty()) {
            textView.setText(value);
        } else {
            textView.setText(R.string.nepreluat);
        }
    }
    @SuppressLint("SetTextI18n")
    private void adaugaVarstaPacient(View view, int varsta) {
        TextView textView = view.findViewById(R.id.stanciu_andreea_tv_pacient_varsta);
        if(!String.valueOf(varsta).isEmpty()) {
            textView.setText(context.getString(R.string.varsta) + varsta);
        } else {
            textView.setText(R.string.nepreluat);
        }
    }
    private void adaugaRezultatPacient(View view, String rezultat) {
        TextView textView = view.findViewById(R.id.stanciu_andreea_tv_pacient_rezultat);
        populareContinutTextView(rezultat, textView);
    }
}
