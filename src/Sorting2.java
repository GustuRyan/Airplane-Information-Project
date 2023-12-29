import java.util.Arrays;

public class Sorting2 {
    public static void quickSort(String[][] arr, int low, int high, int columnIndex) { // O(1) -> konstan (bergantung pada if (low < high)
        if (low < high) {
            int partitionIndex = partition(arr, low, high, columnIndex); // Tpartition(n)

            // Rekursif untuk mengurutkan bagian kiri dan kanan dari pivot
            quickSort(arr, low, partitionIndex - 1, columnIndex); // Tquicksort(n/2)
            quickSort(arr, partitionIndex + 1, high, columnIndex); // Tquicksort (n/2)
        }
    }

    private static int partition(String[][] arr, int low, int high, int columnIndex) {
        String pivot = arr[high][columnIndex]; // 1
        int i = low - 1; // 1 + 1

        for (int j = low; j < high; j++) { // n + n
            // Membandingkan string, menggunakan compareTo
            if (arr[j][columnIndex].compareTo(pivot) <= 0) {
                i++; // n

                // Tukar arr[i] dan arr[j]
                String[] temp = arr[i]; // n
                arr[i] = arr[j]; // n
                arr[j] = temp; // n
            }
        }

        // Tukar arr[i + 1] dan arr[high] (pivot)
        String[] temp = arr[i + 1]; // 1 + 1
        arr[i + 1] = arr[high]; // 1 + 1
        arr[high] = temp; // 1

        return i + 1; // 1
    }

    /*
     *  Persamaan waktu pada basis adalah T0(n) = O(1)
     *  Persamaan waktu pada rekursif pertama adalah T1(n) = Tpartition(n) + Tquicksort(n/2)
     *  Persamaan waktu pada rekursif kedua adalah T2(n) = Tpartition(n) + Tquicksort(n/2)
     *
     *  Tpartition(n) = 1 + 1 + 1 + n + n + n + n + n + n + 1 + 1 + 1 + 1 + 1 + 1
     *  Tpartition(n) = 9 + 6n -> Linear
     *  Sehingga
     *  Tpartition(n) ∈ O(n)
     *
     * Persamaan Waktu total -> Master Theorem
     *
     * Bentuk umum T(n) = aT(n/2) + f(n)
     * Maka :
     *   T(n) = O(1) + Tpartition(n) + Tquicksort(n/2) + Tquicksort(n/2)
     *   T(n) = O(1) + O(n) + 2Tquicksort(n/2)
     *   T(n) = O(n) + 2Tquicksort(n/2)
     *
     * Sehingga
     * a = 2
     * b = 2
     * f(n) = O(n)
     *
     * Maka :
     *   (f(n)/n a^log^b) = O(n)/ n 2^log^2 = O(n)/1 = O(n)
     *
     * dikarenakan f(n) = O(n)
     * maka T(n) = ϴ (n log^n)
     *
     * */

    static void printArray(String[][] arr) {
        for (String[] row : arr) {
            System.out.println(Arrays.toString(row));
        }
    }
}