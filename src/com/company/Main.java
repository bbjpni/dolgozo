package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void menu(ArrayList<Dolgozok> lista)
    {
        String input = "";
        do {
            System.out.println("Menu:");
            System.out.println("[1] Dolgozók kilistázása");
            System.out.println("[2] **");
            System.out.println("[3] Dolgozó keresése");
            System.out.println();
            Scanner sc = new Scanner(System.in);
            input = sc.next();
        }while (!(input.equals("1") || input.equals("2") || input.equals("3")));
        if (input.equals("1"))
        {
            for (Dolgozok d : lista)
            {
                System.out.println(d.toString()+"\n");
            }
        }


    }

    public static void main(String[] args) {

        Adatbazis ab = new Adatbazis();
        menu(ab.getDolgozok());

    }
}
