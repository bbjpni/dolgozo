package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
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
            System.out.print("Válasz: ");
            Scanner sc = new Scanner(System.in);
            input = sc.next();
            System.out.println();
        }while (!(input.equals("1") || input.equals("2") || input.equals("3")));
        if (input.equals("1"))
        {
            for (Dolgozok d : lista)
            {
                System.out.println(d.toString()+"\n");
            }
        }
        if(input.equals("3"))
        {
            do {
                System.out.println("Menu > Keresés:");
                System.out.println("[1] Dogozó idja szerint");
                System.out.println("[2] Dolgozó neme szerint");
                System.out.println("[3] Dolgozó neve szerint");
                System.out.println("[4] Dolgozó kora szerint");
                System.out.println("[5] Dolgozó fizetése szerint");
                System.out.print("Válasz: ");
                Scanner sc = new Scanner(System.in);
                input = sc.next();
                System.out.println();
            }while (!(input.equals("1") || input.equals("2") || input.equals("3") || input.equals("4") || input.equals("5")));
            if (input.equals("1")) { idKeres(lista); }
            if (input.equals("2")) { nemKeres(lista); }
            if (input.equals("3")) { nevKeres(lista); }
            if (input.equals("4")) { korKeres(lista); }
            if (input.equals("5")) { fizetesKeres(lista); }
        }
    }

    public static void fizetesKeres(ArrayList<Dolgozok> lista)
    {
        int min = lista.get(0).getFizetes();
        int max = lista.get(0).getFizetes();
        for (Dolgozok d : lista)
        {
            min = d.getFizetes() < min ? d.getFizetes() : min;
            max = d.getFizetes() > max ? d.getFizetes() : max;
        }
        int keres = min-1;
        do
        {
            System.out.print("Adjon meg az összeget ["+min+"-"+max+"]: ");
            Scanner sc = new Scanner(System.in);
            String in = sc.next();
            try {
                keres = Integer.parseInt(in);
            }catch (Exception ex)
            {
                keres = min-1;
            }
        }while (keres<min || keres>max);
        int step = 0;
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getFizetes() == keres)
            {
                System.out.println(lista.get(i).toString()+"\n");
                step++;
            }
        }
        System.out.println((step == 0 ? "Nincs" : ""+step+" darab") + " találat");
    }

    public static void korKeres(ArrayList<Dolgozok> lista)
    {
        int min = lista.get(0).getKor();
        int max = lista.get(0).getKor();
        for (Dolgozok d : lista)
        {
            min = d.getKor() < min ? d.getKor() : min;
            max = d.getKor() > max ? d.getKor() : max;;
        }
        int keres = min-1;
        do
        {
            System.out.print("Adjon meg az életkort ["+min+"-"+max+"]: ");
            Scanner sc = new Scanner(System.in);
            String in = sc.next();
            try {
                keres = Integer.parseInt(in);
            }catch (Exception ex)
            {
                keres = min-1;
            }
        }while (keres<min || keres>max);
        int step = 0;
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getKor() == keres)
            {
                System.out.println(lista.get(i).toString()+"\n");
                step++;
            }
        }
        System.out.println((step == 0 ? "Nincs" : ""+step+" darab") + " találat");
    }

    private static void nevKeres(ArrayList<Dolgozok> lista)
    {
        System.out.print("Adjon meg egy kereszt vagy verezeték nevet: ");
        Scanner sc = new Scanner(System.in);
        String nev = sc.next();
        int step = 0;
        for (Dolgozok d : lista)
        {
            if (d.getNev().contains(nev))
            {
                System.out.println(d.toString()+"\n");
                step++;
            }
        }
        System.out.println((step == 0 ? "Nincs" : ""+step+" darab") + " találat");
    }

    private static void nemKeres(ArrayList<Dolgozok> lista)
    {
        String keres = "";
        do
        {
            System.out.print("Adjon meg az nemet [férfi/nő]: ");
            Scanner sc = new Scanner(System.in);
            keres = sc.next();
            keres = keres.toLowerCase();
        }while (!(keres.equals("férfi") || keres.equals("nő")));
        boolean nem = keres.equals("ferfi");
        int step =  0;
        for (Dolgozok d : lista)
        {
            if (d.isNem() == nem)
            {
                System.out.println(d.toString()+"\n");
                step++;
            }
        }
        System.out.println(step+" találat");
    }

    public static void idKeres(ArrayList<Dolgozok> lista)
    {
        int min = lista.get(0).getId();
        int max = lista.get(0).getId();
        for (Dolgozok d : lista)
        {
            min = d.getId() < min ? d.getId() : min;
            max = d.getId() > max ? d.getId() : max;;
        }
        int keres = min-1;
        do
        {
            System.out.print("Adjon meg az idt ["+min+"-"+max+"]: ");
            Scanner sc = new Scanner(System.in);
            String in = sc.next();
            try {
                keres = Integer.parseInt(in);
            }catch (Exception ex)
            {
                keres = min-1;
            }
        }while (keres<min || keres>max);
        boolean eredmeny = false;
        for (int i = 0; i < lista.size() && !eredmeny; i++) {
            eredmeny = keres == lista.get(i).getId();
            keres = eredmeny ? i : keres;
        }
        System.out.println();
        System.out.println(eredmeny ? lista.get(keres).toString() : "Nincs "+keres+" idval dolgozó.");
    }

    public static void main(String[] args) {

        Adatbazis ab = new Adatbazis();
        menu(ab.getDolgozok());

    }
}
