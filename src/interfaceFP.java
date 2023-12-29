import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import java.util.List;

public class interfaceFP extends JFrame {
    private JTextArea textArea1;
    private JButton lihatDetailPesawatButton;
    private JButton masukanDataPesawatButton;
    private JPanel panelPertama;
    private JComboBox comboBox1;

    public interfaceFP(){

        textArea1.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
                importSQL.Importan importan = new importSQL().new Importan();
                importan.importData();

                String[] statusPenerbangan = importan.getStatusPenerbangan().toArray(new String[0]);
                List<List<String>> dataPesawatList = importan.getDataPesawat();
                String[][] dataPesawat = new String[dataPesawatList.size()][];
                for (int i = 0; i < dataPesawatList.size(); i++) {
                    List<String> rowList = dataPesawatList.get(i);
                    dataPesawat[i] = rowList.toArray(new String[0]);
                }
                Sorting.quickSort(statusPenerbangan, 0, statusPenerbangan.length-1);
                Sorting2.quickSort(dataPesawat, 0, dataPesawat.length-1, 8);
                String selectedValue = (String) comboBox1.getSelectedItem();

                Integer[] result = Searching2.binarySearch(statusPenerbangan, selectedValue);
                int[] intArray = Arrays.stream(result)
                        .mapToInt(Integer::intValue)
                        .toArray();
                if (result != null) {
                    textArea1.setText(Arrays.toString(Main.printData(intArray)));
                    System.out.println("String ditemukan pada indeks " + Arrays.toString(result));
                } else {
                    System.out.println("String tidak ditemukan dalam array.");
                }
            }
        });

        comboBox1.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    // Mendapatkan nilai yang dipilih dari JComboBox
                    String selectedValue = (String) comboBox1.getSelectedItem();

                    importSQL.Importan importan = new importSQL().new Importan();
                    importan.importData();

                    String[] statusPenerbangan = importan.getStatusPenerbangan().toArray(new String[0]);
                    List<List<String>> dataPesawatList = importan.getDataPesawat();
                    String[][] dataPesawat = new String[dataPesawatList.size()][];
                    for (int i = 0; i < dataPesawatList.size(); i++) {
                        List<String> rowList = dataPesawatList.get(i);
                        dataPesawat[i] = rowList.toArray(new String[0]);
                    }
                    Sorting.quickSort(statusPenerbangan, 0, statusPenerbangan.length-1);
                    Sorting2.quickSort(dataPesawat, 0, dataPesawat.length-1, 8);

                    Integer[] result = Searching2.binarySearch(statusPenerbangan, selectedValue);
                    int[] intArray = Arrays.stream(result)
                            .mapToInt(Integer::intValue)
                            .toArray();
                    if (result != null) {
                        textArea1.setText(Arrays.toString(Main.printData(intArray)));
                        System.out.println("String ditemukan pada indeks " + Arrays.toString(result));
                    } else {
                        System.out.println("String tidak ditemukan dalam array.");
                    }
                }
            }
        });
        lihatDetailPesawatButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                interfaceDetail.interfaceDetailin();
                setVisible(false);
            }
        });
        masukanDataPesawatButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addDataIF.adddata();
                setVisible(false);
            }
        });
    }
    public static void interfaceAwal(){
        interfaceFP frame = new interfaceFP();
        frame.setContentPane(frame.panelPertama);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        interfaceAwal();
    }
}


