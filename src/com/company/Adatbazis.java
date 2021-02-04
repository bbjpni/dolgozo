package com.company;

import java.sql.*;
import java.util.ArrayList;
import java.util.Locale;

public class Adatbazis
{
    private ArrayList<Dolgozok> dolgozok;
    public Adatbazis()
    {
        this.dolgozok = Beolvas();
    }

    public ArrayList<Dolgozok> getDolgozok() {
        return dolgozok;
    }

    private ArrayList<Dolgozok> Beolvas() {
        ArrayList<Dolgozok> back = new ArrayList<>();
        try {
            String url = "jdbc:mysql://localhost:3306/dolgozok";
            String user = "root";
            String password = "";
            String sql = "SELECT * FROM dolgozok";
            Connection kapcsolat = DriverManager.getConnection(url, user, password);
            Statement allapot = kapcsolat.createStatement();
            ResultSet rs = allapot.executeQuery(sql);
            System.out.println("Sikeres kapcsolodás az adatbázishoz");
            while (rs.next()) {
                int id = rs.getInt(1);
                String nev = rs.getString(2);
                boolean nem = rs.getString(3).toLowerCase().equals("férfi");
                int kor = rs.getInt(4);
                int fizetes = rs.getInt(5);
                back.add(new Dolgozok(id, nem, nev, kor, fizetes));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.getMessage();
        }
        return back;
    }

        public boolean Beszuras(Dolgozok d)
        {
            try
            {
                String url = "jdbc:mysql://localhost:3306/dolgozok";
                String user = "root";
                String password = "";
                String sql = "INSERT INTO dolgozok(`id`, `nev`, `nem`, `kor`, `fizetes`) VALUES (?,?,?,?,?)";
                Connection kapcsolat = DriverManager.getConnection(url, user, password);
                PreparedStatement st = kapcsolat.prepareStatement(sql);
                st.setInt(1, d.getId());
                st.setString(2,d.Nev());
                st.setString(3, d.isNem() ? "férfi" : "nő");
                st.setInt(4, d.getKor());
                st.setInt(5, d.getFizetes());
                st.execute();
                return true;
            }
            catch (SQLException ex){ex.printStackTrace(); return false;}
            catch (Exception ex){ex.getMessage(); return false;}
    }
}