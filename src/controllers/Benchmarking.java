package controllers;

import models.Resultado;

public class Benchmarking {

    public static Resultado medir(Runnable algoritmo,String nombreAlgoritmo,int muestra,String escenario) {

        long start = System.nanoTime();

        algoritmo.run();

        long end = System.nanoTime();

        return new Resultado(nombreAlgoritmo, escenario, muestra, end - start);
    }
}
