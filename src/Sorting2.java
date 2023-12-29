import java.util.Arrays;

public class Sorting2 {
    public static void quickSort(String[][] arr, int low, int high, int columnIndex) {
        if (low < high) {
            int partitionIndex = partition(arr, low, high, columnIndex);

            // Rekursif untuk mengurutkan bagian kiri dan kanan dari pivot
            quickSort(arr, low, partitionIndex - 1, columnIndex);
            quickSort(arr, partitionIndex + 1, high, columnIndex);
        }
    }

    private static int partition(String[][] arr, int low, int high, int columnIndex) {
        String pivot = arr[high][columnIndex];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            // Membandingkan string, menggunakan compareTo
            if (arr[j][columnIndex].compareTo(pivot) <= 0) {
                i++;

                // Tukar arr[i] dan arr[j]
                String[] temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Tukar arr[i + 1] dan arr[high] (pivot)
        String[] temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    static void printArray(String[][] arr) {
        for (String[] row : arr) {
            System.out.println(Arrays.toString(row));
        }
    }
}