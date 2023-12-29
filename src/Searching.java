public class Searching {
    public static int binarySearch(String[] array, String target) {
        int low = 0;  // 1
        int high = array.length - 1; // 1

        while (low <= high) { // log n
            int mid = (low + high) / 2; // log n

            int comparison = array[mid].compareTo(target); // log n

            if (comparison == 0) { // log n
                return mid; // 1
                // String ditemukan, kembalikan indeksnya
            } else if (comparison < 0) { // log n
                low = mid + 1; // log n
                // Cari di setengah kanan
            } else { // log n
                high = mid - 1; // log n
                // Cari di setengah kiri
            }
        }

        return -1; // String tidak ditemukan // 1
    }
}


/*
 *  Persamaan waktu pada basis adalah T0(n) = O(1)
 *
 *  Tpartition(n) = 1 + 1 + log n + log n + log n + log n + 1 + 1 + + log n + log n + log n + 1
 *  Tpartition(n) = 7(log n) + 5 -> Linear
 *  dikarenakan f(n) = O(n)
 *  maka T(n) = ϴ (log n)
 *
 * */
