package com.example.kartkowka;

public class Zakupy {
    private String nazwa;
    int Zaz=0;

    public Zakupy(String nazwa) {
        this.nazwa = nazwa;
    }

    @Override
    public String toString() {
        return nazwa;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public int getZaz() {
        return Zaz;
    }

    public void setZaz(int zaz) {
        Zaz = zaz;
    }

}
