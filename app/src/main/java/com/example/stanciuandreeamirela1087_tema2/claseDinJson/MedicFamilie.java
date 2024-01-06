package com.example.stanciuandreeamirela1087_tema2.claseDinJson;

import java.io.Serializable;

public class MedicFamilie implements Serializable {
    private String nume;
    private String specializare;
    private int aniExperienta;
    private CentruSanitar centruSanitar;

    public MedicFamilie(String nume, String specializare, int aniExperienta, CentruSanitar centruSanitar) {
        this.nume = nume;
        this.specializare = specializare;
        this.aniExperienta = aniExperienta;
        this.centruSanitar = centruSanitar;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getSpecializare() {
        return specializare;
    }

    public void setSpecializare(String specializare) {
        this.specializare = specializare;
    }

    public int getAniExperienta() {
        return aniExperienta;
    }

    public void setAniExperienta(int aniExperienta) {
        this.aniExperienta = aniExperienta;
    }

    public CentruSanitar getCentruSanitar() {
        return centruSanitar;
    }

    public void setCentruSanitar(CentruSanitar centruSanitar) {
        this.centruSanitar = centruSanitar;
    }

    @Override
    public String toString() {
        return "MedicFamilie{" +
                "nume='" + nume + '\'' +
                ", specializare='" + specializare + '\'' +
                ", aniExperienta=" + aniExperienta +
                ", centruSanitar=" + centruSanitar +
                '}';
    }
}
