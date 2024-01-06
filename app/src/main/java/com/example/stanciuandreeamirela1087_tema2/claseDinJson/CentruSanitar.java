package com.example.stanciuandreeamirela1087_tema2.claseDinJson;

import java.io.Serializable;

public class CentruSanitar implements Serializable {
    private String denumire;
    private int capacitate;
    private int personal;
    private String manager;

    public CentruSanitar(String denumire, int capacitate, int personal, String manager) {
        this.denumire = denumire;
        this.capacitate = capacitate;
        this.personal = personal;
        this.manager = manager;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public int getCapacitate() {
        return capacitate;
    }

    public void setCapacitate(int capacitate) {
        this.capacitate = capacitate;
    }

    public int getPersonal() {
        return personal;
    }

    public void setPersonal(int personal) {
        this.personal = personal;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    @Override
    public String toString() {
        return "Centrul sanitar " + denumire +
                " cu capacitatea de " + capacitate +
                " pacienti si " + personal +
                " cadre medicale, avand managerul " + manager ;
    }
}
