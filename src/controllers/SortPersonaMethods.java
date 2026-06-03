package controllers;

import models.Persona;

public class SortPersonaMethods {

    public void insertionSort(Persona[] a) {
        for (int i = 1; i < a.length; i++) {
            Persona key = a[i];
            int j = i - 1;

            while (j >= 0 && a[j].getCriterioOrdenamiento() > key.getCriterioOrdenamiento()) {
                a[j + 1] = a[j];
                j--;
            }

            a[j + 1] = key;
        }
    }

    public void quickSort(Persona[] a, int low, int high) {
        if (low < high) {
            int p = partition(a, low, high);
            quickSort(a, low, p - 1);
            quickSort(a, p + 1, high);
        }
    }

    private int partition(Persona[] a, int low, int high) {
        Persona pivot = a[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (a[j].getCriterioOrdenamiento() <= pivot.getCriterioOrdenamiento()) {
                i++;
                Persona tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
            }
        }

        Persona tmp = a[i + 1];
        a[i + 1] = a[high];
        a[high] = tmp;

        return i + 1;
    }
}