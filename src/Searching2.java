import java.util.ArrayList;
import java.util.Arrays;

public class Searching2{
        public static Integer[] binarySearch(String[] array, String target) {
            int temp = 999; // 1
            int low ;
            int temp2;
            int high = temp2 = array.length - 1; // 2
            int i = low = 0; // 2
            ArrayList<Integer> index = new ArrayList<>();

            while (low <= high) { // log n
                int mid = (low + high) / 2; // log n

                int comparison = array[mid].compareTo(target); // log n

                if (comparison == 0) { // log n
                    index.add(mid); // log n
                    array[mid] = "ab"; // log n
                    low = mid+1; // log n
                    high = temp2; // log n
                    if(temp > mid){ // log n
                        temp = mid; // log n
                    }
                    i++; // log n
                } else if (comparison < 0) { // log n
                    low = mid + 1; // log n
                    // Cari di setengah kanan
                } else { // log n
                    if (i > 0 && low == mid) { // log n
                        low = 0; // log n
                        high = temp2 = temp; // log n
                        i = 0; // log n
                    } else { // log n
                        high = mid - 1; // log n
                        // Cari di setengah kiri
                    }
                }
            }
            Integer[] numbers = index.toArray(new Integer[0]); // log n
            if (numbers.length != 0){ // 1
                return numbers; // 1
            }
            return null; // 1
            // String tidak ditemukan
        }
}

/*
 *  Persamaan waktu pada basis adalah T0(n) = O(1)
 *
 *  Tpartition(n) = 1 + 2 + 2 + 21(log n) + 1 + 1 + 1
 *  Tpartition(n) = 21(log n) + 8 -> Linear
 *  dikarenakan f(n) = O(n)
 *  maka T(n) = ϴ (log n)
 *
 * */