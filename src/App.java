import controllers.Benchmarking;
import controllers.SortPersonaMethods;
import models.GeneradorPersonas;
import models.Persona;
import models.Resultado;

public class App {

    public static void main(String[] args) {

        int[] muestras = {10000, 50000, 100000};

        SortPersonaMethods sort = new SortPersonaMethods();

        System.out.println("========== ESCENARIO 1: DESORDENADO ==========");

        for (int n : muestras) {

            Persona[] base = GeneradorPersonas.generarPersonas(n);

            Persona[] a1 = base.clone();
            Persona[] a2 = base.clone();

            Resultado r1 = Benchmarking.medir(
                    () -> sort.insertionSort(a1),
                    "InsertionSort",
                    n,
                    "Desordenado"
            );

            Resultado r2 = Benchmarking.medir(
                    () -> sort.quickSort(a2, 0, a2.length - 1),
                    "QuickSort",
                    n,
                    "Desordenado"
            );

            System.out.println(r1);
            System.out.println(r2);
        }

        System.out.println("\n========== ESCENARIO 2: CASI ORDENADO ==========");

        for (int n : muestras) {

            Persona[] base = GeneradorPersonas.generarPersonas(n);

            SortPersonaMethods sort2 = new SortPersonaMethods();
            sort2.quickSort(base, 0, base.length - 1);

            Persona[] casiOrdenado = new Persona[base.length + 1];
            System.arraycopy(base, 0, casiOrdenado, 0, base.length);
            casiOrdenado[casiOrdenado.length - 1] = new Persona("Zzz", 0);

            Persona[] b1 = casiOrdenado.clone();
            Persona[] b2 = casiOrdenado.clone();

            Resultado r1 = Benchmarking.medir(
                    () -> sort.insertionSort(b1),
                    "InsertionSort",
                    n + 1,
                    "Casi ordenado"
            );

            Resultado r2 = Benchmarking.medir(
                    () -> sort.quickSort(b2, 0, b2.length - 1),
                    "QuickSort",
                    n + 1,
                    "Casi ordenado"
            );

            System.out.println(r1);
            System.out.println(r2);
        }
    }
}