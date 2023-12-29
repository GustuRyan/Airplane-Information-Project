import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class importSQL {

    private static Connection connection;

    class Importan {
        private List<String> noPenerbangan = new ArrayList<>();
        private List<String> ruteAwal = new ArrayList<>();
        private List<String> ruteTujuan = new ArrayList<>();
        private List<String> IDpesawat = new ArrayList<>();
        private List<String> maskapai = new ArrayList<>();
        private List<String> jenisPesawat = new ArrayList<>();
        private List<String> jumlahPenumpang = new ArrayList<>();
        private List<String> estimasiWaktu = new ArrayList<>();
        private List<String> statusPenerbangan = new ArrayList<>();
        private List<String> keberangkatan = new ArrayList<>();
        private List<String> kedatangan = new ArrayList<>();
        private List<List<String>> dataPesawat = new ArrayList<>();

        public void importData() {
            String jdbcURL = "jdbc:mysql://localhost:3306/manajemenpesawat?useSSL=false&serverTimezone=UTC";
            String username = "root";
            String password = "";

            try {
                // Memastikan driver terdaftar
                Class.forName("com.mysql.cj.jdbc.Driver");

                // Menghubungkan ke database
                connection = DriverManager.getConnection(jdbcURL, username, password);

                if (connection != null) {
                    System.out.println("Koneksi ke database berhasil!");

                    // Pernyataan SQL untuk memeriksa keberadaan username
                    String sql = "SELECT * FROM datapesawat";
                    try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                        ResultSet resultSet = preparedStatement.executeQuery();
                        while (resultSet.next()) {
                            noPenerbangan.add(resultSet.getString("noPenerbangan"));
                            ruteAwal.add(resultSet.getString("ruteAwal"));
                            ruteTujuan.add(resultSet.getString("ruteTujuan"));
                            IDpesawat.add(resultSet.getString("IDpesawat"));
                            maskapai.add(resultSet.getString("maskapai"));
                            jenisPesawat.add(resultSet.getString("jenisPesawat"));
                            jumlahPenumpang.add(resultSet.getString("jumlahPenumpang"));
                            estimasiWaktu.add(resultSet.getString("estimasiWaktu"));
                            statusPenerbangan.add(resultSet.getString("statusPenerbangan"));
                            keberangkatan.add(resultSet.getString("keberangkatan"));
                            kedatangan.add(resultSet.getString("kedatangan"));

                            // Menyimpan dataPesawat sebagai List<String>
                            List<String> rowData = Arrays.asList(
                                    resultSet.getString("noPenerbangan"),
                                    resultSet.getString("ruteAwal"),
                                    resultSet.getString("ruteTujuan"),
                                    resultSet.getString("IDpesawat"),
                                    resultSet.getString("maskapai"),
                                    resultSet.getString("jenisPesawat"),
                                    resultSet.getString("jumlahPenumpang"),
                                    resultSet.getString("estimasiWaktu"),
                                    resultSet.getString("statusPenerbangan"),
                                    resultSet.getString("keberangkatan"),
                                    resultSet.getString("kedatangan")
                            );
                            dataPesawat.add(rowData);
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }

            } catch (ClassNotFoundException | SQLException e) {
                System.out.println("Koneksi ke database gagal!");
                e.printStackTrace();
            }
        }

        // ... Metode lainnya

        public List<String> getNoPenerbangan() {
            return noPenerbangan;
        }

        public List<String> getRuteAwal() {
            return ruteAwal;
        }

        public List<String> getRuteTujuan() {
            return ruteTujuan;
        }

        public List<String> getEstimasiWaktu() {
            return estimasiWaktu;
        }

        public List<String> getIDpesawat() {
            return IDpesawat;
        }

        public List<String> getJenisPesawat() {
            return jenisPesawat;
        }

        public List<String> getJumlahPenumpang() {
            return jumlahPenumpang;
        }

        public List<String> getKeberangkatan() {
            return keberangkatan;
        }

        public List<String> getKedatangan() {
            return kedatangan;
        }

        public List<String> getMaskapai() {
            return maskapai;
        }

        public List<String> getStatusPenerbangan() {
            return statusPenerbangan;
        }

        public List<List<String>> getDataPesawat() {
            return dataPesawat;
        }
    }

    class Update {
        public void updatePass(String kedatangan, String noPenerbangan){
            String sql = "UPDATE dataPesawat SET kedatangan = ? WHERE noPenerbangan = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, kedatangan);
                preparedStatement.setString(2, noPenerbangan);

                int rowsUpdated = preparedStatement.executeUpdate();

                if (rowsUpdated > 0) {
                    System.out.println("Data berhasil diperbarui.");
                } else {
                    System.out.println("Data tidak ditemukan untuk diperbarui.");
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    class Insert {
        public void adding(String a, String b, String c, String d, String q, String f, String g, String h, String i, String j, String k){
            String sql = "INSERT INTO dataPesawat (noPenerbangan, ruteAwal, ruteTujuan, IDpesawat, " +
                    "maskapai, jenisPesawat, jumlahPenumpang, estimasiWaktu, statusPenerbangan, " +
                    "keberangkatan, kedatangan) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, a);
                preparedStatement.setString(2, b);
                preparedStatement.setString(3, c);
                preparedStatement.setString(4, d);
                preparedStatement.setString(5, q);
                preparedStatement.setString(6, f);
                preparedStatement.setString(7, g);
                preparedStatement.setString(8, h);
                preparedStatement.setString(9, i);
                preparedStatement.setString(10, j);
                preparedStatement.setString(11, k);

                int rowsInserted = preparedStatement.executeUpdate();

                if (rowsInserted > 0) {
                    System.out.println("Data berhasil ditambahkan.");
                } else {
                    System.out.println("Gagal menambahkan data.");
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }
    }

    public static void main(String[] args) {
        Importan importan = new importSQL().new Importan();
        importan.importData();
        String[] noPenerbangan = importan.noPenerbangan.toArray(new String[0]);
        String[] ruteAwal = importan.ruteAwal.toArray(new String[0]);
        List<List<String>> dataPesawatList = importan.getDataPesawat();
        String[][] dataPesawat = new String[dataPesawatList.size()][];
        for (int i = 0; i < dataPesawatList.size(); i++) {
            List<String> rowList = dataPesawatList.get(i);
            dataPesawat[i] = rowList.toArray(new String[0]);
        }
//        for (String[] row : dataPesawat) {
//            System.out.println(Arrays.toString(row));
//        }
        Sorting.quickSort(ruteAwal, 0, noPenerbangan.length-1);
//      Sorting.printArray(noPenerbangan);
        Sorting2.quickSort(dataPesawat, 0, dataPesawat.length-1, 1);
        Sorting2.printArray(dataPesawat);

        Integer[] result = Searching2.binarySearch(ruteAwal, "Yogyakarta");
        if (result != null) {
            System.out.println("String ditemukan pada indeks " + Arrays.toString(result));
        } else {
            System.out.println("String tidak ditemukan dalam array.");
        }
    }
}
