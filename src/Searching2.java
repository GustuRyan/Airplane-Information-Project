import java.util.ArrayList;
import java.util.Arrays;

public class Searching2{
        public static Integer[] binarySearch(String[] array, String target) {
            int temp = 999;
            int low ;
            int temp2;
            int high = temp2 = array.length - 1;
            int i = low = 0;
            ArrayList<Integer> index = new ArrayList<>();

            while (low <= high) {
                int mid = (low + high) / 2;

                int comparison = array[mid].compareTo(target);

                if (comparison == 0) {
                    index.add(mid);
                    array[mid] = "ab";
                    low = mid+1;
                    high = temp2;
                    if(temp > mid){
                        temp = mid;
                    }
                    i++;
                } else if (comparison < 0) {
                    low = mid + 1; // Cari di setengah kanan
                } else {
                    if (i > 0 && low == mid) {
                        low = 0;
                        high = temp2 = temp;
                        i = 0;
                    } else {
                        high = mid - 1; // Cari di setengah kiri
                    }
                }
            }
            Integer[] numbers = index.toArray(new Integer[0]);
            if (numbers.length != 0){
                return numbers;
            }
            return null; // String tidak ditemukan
        }
}
