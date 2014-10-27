package com.rynkowsw.main;

import com.rynkowsw.model.Punkt3d;
import com.rynkowsw.model.Vector3d;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.logging.Logger;

public class Utils {

    public static final int TRANSLATION_STEP = 50;
    public static final double ROTATE_STEP = 0.2;
    public static final double ZOOM_STEP = 200;

    public static final int WIDTH = 500;
    public static final int HEIGHT = 500;

    public static ArrayList<Vector3d> getVectorsFromFile() {
        ArrayList<Vector3d> vectors = new ArrayList<Vector3d>();
        BufferedReader br;
        DataInputStream dis;
        String nazwaPliku = "dane.txt";

        try {
            FileInputStream fileStream = new FileInputStream(nazwaPliku);
            dis = new DataInputStream(fileStream);
            br = new BufferedReader(new InputStreamReader(dis));

            String line;
            String tab[];

            while ((line = br.readLine()) != null) {
                if (line.length() == 0 || line.charAt(0) == '/') {
                    continue;
                }

                tab = line.split(";");

                Punkt3d a = new Punkt3d(Double.valueOf(tab[0]), Double.valueOf(tab[1]), Double.valueOf(tab[2]));
                Punkt3d b = new Punkt3d(Double.valueOf(tab[3]), Double.valueOf(tab[4]), Double.valueOf(tab[5]));

                vectors.add(new Vector3d(a, b));

            }
            dis.close();

            return vectors;

        } catch (Exception e) {
            System.err.println("Nie udana proba odczytu z pliku ," + e);
            return null;
        }

    }

    public static void printVectors(ArrayList<Vector3d> vectors) {
        for (Vector3d it : vectors) {
            System.out.println(it.getA() + "  ;  " + it.getB());
        }
    }

}
