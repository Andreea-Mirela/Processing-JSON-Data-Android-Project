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

public class CentruSanitarAdapter extends ArrayAdapter<CentruSanitar> {
    private Context context;
    private int resource;
    private List<CentruSanitar> centreSanitare;
    private LayoutInflater inflater;

    public CentruSanitarAdapter(@NonNull Context context,
                                int resource,
                                @NonNull List<CentruSanitar> objects,
                                LayoutInflater inflater) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.centreSanitare = objects;
        this.inflater = inflater;
    }

    @NonNull
    @Override
    public View getView(int position,
                        @Nullable View convertView,
                        @NonNull ViewGroup parent) {
        View view = inflater.inflate(resource, parent, false);
        CentruSanitar centruSanitar = centreSanitare.get(position);
        if(centruSanitar != null) {
            adaugaDenumireCentruSanitar(view, centruSanitar.getDenumire());
            adaugaCapacitateCentruSanitar(view, centruSanitar.getCapacitate());
            adaugaPersonalCentruSanitar(view, centruSanitar.getPersonal());
            adaugaManagerCentruSanitar(view, centruSanitar.getManager());
        }
        return view;
    }

    private void adaugaDenumireCentruSanitar(View view, String denumire) {
        TextView textView = view.findViewById(R.id.stanciu_andreea_tv_denumire);
        populareContinutTextView(denumire, textView);
    }

    private void populareContinutTextView(String value, TextView textView) {
        if(value!=null && !value.isEmpty()) {
            textView.setText(value);
        } else {
            textView.setText(R.string.nepreluat);
        }
    }

    @SuppressLint("SetTextI18n")
    private void adaugaCapacitateCentruSanitar(View view, int capacitate) {
        TextView textView = view.findViewById(R.id.stanciu_andreea_tv_capacitate);
        //populareContinutTextView(String.valueOf(capacitate), textView);
        if(!String.valueOf(capacitate).isEmpty()) {
            textView.setText(context.getString(R.string.cap) + capacitate);
        } else {
            textView.setText(R.string.nepreluat);
        }
    }

    @SuppressLint("SetTextI18n")
    private void adaugaPersonalCentruSanitar(View view, int personal) {
        TextView textView = view.findViewById(R.id.stanciu_andreea_tv_personal);
        //populareContinutTextView(String.valueOf(personal), textView);
        if(!String.valueOf(personal).isEmpty()) {
            textView.setText(context.getString(R.string.pers) + personal);
        } else {
            textView.setText(R.string.nepreluat);
        }
    }

    @SuppressLint("SetTextI18n")
    private void adaugaManagerCentruSanitar(View view, String manager) {
        TextView textView = view.findViewById(R.id.stanciu_andreea_tv_manager);
        if(manager!=null && !manager.isEmpty()) {
            textView.setText(context.getString(R.string.man) + manager);
        } else {
            textView.setText(R.string.nepreluat);
        }
    }
}
