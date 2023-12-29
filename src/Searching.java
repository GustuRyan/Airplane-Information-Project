public class Searching {
    public static int binarySearch(String[] array, String target) {
        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            int comparison = array[mid].compareTo(target);

            if (comparison == 0) {
                return mid; // String ditemukan, kembalikan indeksnya
            } else if (comparison < 0) {
                low = mid + 1; // Cari di setengah kanan
            } else {
                high = mid - 1; // Cari di setengah kiri
            }
        }

        return -1; // String tidak ditemukan
    }
}
