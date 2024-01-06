package com.example.stanciuandreeamirela1087_tema2.claseDinJson;

import java.io.Serializable;

public class Pacient implements Serializable {
    private String nume;
    private int varsta;
    private String rezultat;
    private MedicFamilie medicFamilie;

    public Pacient(String nume, int varsta, String rezultat) {
        this.nume = nume;
        this.varsta = varsta;
        this.rezultat = rezultat;
    }

    public Pacient(String nume, int varsta, String rezultat, MedicFamilie medicFamilie) {
        this.nume = nume;
        this.varsta = varsta;
        this.rezultat = rezultat;
        this.medicFamilie = medicFamilie;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public int getVarsta() {
        return varsta;
    }

    public void setVarsta(int varsta) {
        this.varsta = varsta;
    }

    public String getRezultat() {
        return rezultat;
    }

    public void setRezultat(String rezultat) {
        this.rezultat = rezultat;
    }

    public MedicFamilie getMedicFamilie() {
        return medicFamilie;
    }

    public void setMedicFamilie(MedicFamilie medicFamilie) {
        this.medicFamilie = medicFamilie;
    }

    @Override
    public String toString() {
        return "Pacient{" +
                "nume='" + nume + '\'' +
                ", varsta=" + varsta +
                ", rezultat='" + rezultat + '\'' +
                ", medicFamilie=" + medicFamilie +
                '}';
    }
}
