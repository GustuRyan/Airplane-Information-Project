import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    static String[] printData(int[] arr) {
        ArrayList<String> resultList = new ArrayList<>();
        importSQL.Importan importan = new importSQL().new Importan();
        importan.importData();
        List<List<String>> dataPesawat = importan.getDataPesawat();

        for (int i : arr) {
            String result = "[<><><>()<>()<><><><<{{}}>><><><>()<>()<><><>]]\n" + "Nomor Penerbangan : " + dataPesawat.get(i).get(0)
                    + "\nRute Awal : " + dataPesawat.get(i).get(1)
                    + "\nRute Tujuan : " + dataPesawat.get(i).get(2)
                    + "\nID Pesawat : " + dataPesawat.get(i).get(3)
                    + "\nMaskapai Penerbangan : " + dataPesawat.get(i).get(4)
                    + "\nTipe Pesawat : " + dataPesawat.get(i).get(5)
                    + "\nJumlah Penumpang : " + dataPesawat.get(i).get(6)
                    + "\nEstimasi Waktu Perjalanan : " + dataPesawat.get(i).get(7)
                    + "\nStatus Penerbangan : " + dataPesawat.get(i).get(8)
                    + "\nWaktu Keberangkatan : " + dataPesawat.get(i).get(9)
                    + "\nWaktu Kedatangan : " + dataPesawat.get(i).get(10)
                    + "\n(Dapat Berupa Asumsi)" + "\n[[<><><>()<>()<><><><<{{}}>><><><>()<>()<><><>]]\n\n";
            resultList.add(result);
        }

        // Mengonversi ArrayList menjadi array
        String[] arrayResult = resultList.toArray(new String[0]);

        return arrayResult;
    }

    static String[] printSortData(String[][] data) {
        ArrayList<String> resultList = new ArrayList<>();
        for (int i = 0 ; i<data.length ; i++) {
            String result = "[<><><>()<>()<><><><<{{}}>><><><>()<>()<><><>]]\n"
                    + "Nomor Penerbangan : " + data[i][0]
                    + "\nRute Awal : " + data[i][1]
                    + "\nRute Tujuan : " + data[i][2]
                    + "\nID Pesawat : " + data[i][3]
                    + "\nMaskapai Penerbangan : " + data[i][4]
                    + "\nTipe Pesawat : " + data[i][5]
                    + "\nJumlah Penumpang : " + data[i][6]
                    + "\nEstimasi Waktu Perjalanan : " + data[i][7]
                    + "\nStatus Penerbangan : " + data[i][8]
                    + "\nWaktu Keberangkatan : " + data[i][9]
                    + "\nWaktu Kedatangan : " + data[i][10]
                    + "\n(Dapat Berupa Asumsi)" + "\n[[<><><>()<>()<><><><<{{}}>><><><>()<>()<><><>]]\n\n";
            resultList.add(result);
        }

        // Mengonversi ArrayList menjadi array
        String[] arrayResult = resultList.toArray(new String[0]);

        return arrayResult;
    }
    static String[] getDropbox(String value){
        importSQL.Importan importan = new importSQL().new Importan();
        importan.importData();
        if (value.equals("noPenerbangan")) {
            String[] filled = importan.getNoPenerbangan().toArray(new String[0]);
            return filled;
        }
        else if (value.equals("ruteAwal")) {
            String[] filled = importan.getRuteAwal().toArray(new String[0]);
            return filled;
        }
        else if (value.equals("ruteTujuan")) {
            String[] filled = importan.getRuteTujuan().toArray(new String[0]);
            return filled;
        }
        else if (value.equals("IDpesawat")) {
            String[] filled = importan.getIDpesawat().toArray(new String[0]);
            return filled;
        }
        else if (value.equals("maskapai")) {
            String[] filled = importan.getMaskapai().toArray(new String[0]);
            return filled;
        }
        else if (value.equals("jenisPesawat")) {
            String[] filled = importan.getJenisPesawat().toArray(new String[0]);
            return filled;
        }
        else if (value.equals("jumlahPenumpang")) {
            String[] filled = importan.getJumlahPenumpang().toArray(new String[0]);
            return filled;
        }
        else if (value.equals("estimasiWaktu")) {
            String[] filled = importan.getEstimasiWaktu().toArray(new String[0]);
            return filled;
        }
        else if (value.equals("statusPenerbangan")) {
            String[] filled = importan.getStatusPenerbangan().toArray(new String[0]);
            return filled;
        }
        else if (value.equals("keberangkatan")) {
            String[] filled = importan.getKeberangkatan().toArray(new String[0]);
            return filled;
        }
        else {
            String[] filled = importan.getKedatangan().toArray(new String[0]);
            return filled;
        }
    }

    static int getNumDrop(String value){
        importSQL.Importan importan = new importSQL().new Importan();
        importan.importData();
        if (value.equals("noPenerbangan")) {
            int filled = 0;
            return filled;
        }
        else if (value.equals("ruteAwal")) {
            int filled = 1;
            return filled;
        }
        else if (value.equals("ruteTujuan")) {
            int filled = 2;
            return filled;
        }
        else if (value.equals("IDpesawat")) {
            int filled = 3;
            return filled;
        }
        else if (value.equals("maskapai")) {
            int filled = 4;
            return filled;
        }
        else if (value.equals("jenisPesawat")) {
            int filled = 5;
            return filled;
        }
        else if (value.equals("jumlahPenumpang")) {
            int filled = 6;
            return filled;
        }
        else if (value.equals("estimasiWaktu")) {
            int filled = 7;
            return filled;
        }
        else if (value.equals("statusPenerbangan")) {
            int filled = 8;
            return filled;
        }
        else if (value.equals("keberangkatan")) {
            int filled = 9;
            return filled;
        }
        else {
            int filled = 10;
            return filled;
        }
    }
}