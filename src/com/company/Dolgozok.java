package com.company;


import java.util.ArrayList;
import java.util.Arrays;

public class Dolgozok {
    private int id;
    private boolean nem;
    private String[] nev;
    private int kor;
    private int fizetes;

    public Dolgozok(int id, boolean nem, String nev, int kor, int fizetes) {
        this.id = id;
        this.nem = nem;
        this.nev = nev.split(" ");
        this.kor = kor;
        this.fizetes = fizetes;
    }

    public boolean isNem() {
        return nem;
    }

    public int getId() {
        return id;
    }

    public ArrayList<String> getNev() {
        ArrayList<String> back = new ArrayList<>();
        for (String s : this.nev){back.add(s);}
        return back;
    }

    public int getKor() {
        return kor;
    }

    public int getFizetes() {
        return fizetes;
    }

    private String Nev()
    {
        String back = "";
        for (int i = 0; i < this.nev.length; i++) {
            back+= i == 0 ? nev[i] : " "+nev[i];
        }
        return back;
    }

    @Override
    public String toString() {
        return String.format("%s (%d)\nid: %d\nnem: %s\nfizetes: %d forint",
                Nev(), kor, id, nem ? "férfi" : "nő", fizetes);
    }
}
