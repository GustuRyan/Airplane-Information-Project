import javax.swing.*;
import java.awt.event.*;
import java.util.Arrays;
import java.util.List;

public class interfaceDetail extends JFrame {
    private JPanel panelDetail;
    private JButton kembaliButton;
    private JTextArea textArea2;
    private JTextField textField1;
    private JComboBox comboBox1;
    private JButton cariButton;

    public interfaceDetail(){
                importSQL.Importan importan = new importSQL().new Importan();
                importan.importData();

                String[] statusPenerbangan = importan.getStatusPenerbangan().toArray(new String[0]);
                List<List<String>> dataPesawatList = importan.getDataPesawat();
                String[][] dataPesawat = new String[dataPesawatList.size()][];
                for (int i = 0; i < dataPesawatList.size(); i++) {
                    List<String> rowList = dataPesawatList.get(i);
                    dataPesawat[i] = rowList.toArray(new String[0]);
                }
                Sorting.quickSort(statusPenerbangan, 0, statusPenerbangan.length - 1);
                Sorting2.quickSort(dataPesawat, 0, dataPesawat.length - 1, 1);

                int panjang = dataPesawat.length;
                int[] intArray = new int[panjang];
                for (int i = 0; i < panjang; i++) {
                    intArray[i] = i;
                }
                textArea2.setText(Arrays.toString(Main.printData(intArray)));

        kembaliButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                interfaceFP frame = new interfaceFP();
                setVisible(false);
            }
        });
        comboBox1.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    if (textField1.getText().equals("")){
                        String selectedValue = (String) comboBox1.getSelectedItem();

                        importSQL.Importan importan = new importSQL().new Importan();
                        importan.importData();

                        List<List<String>> dataPesawatList = importan.getDataPesawat();
                        String[][] dataPesawat = new String[dataPesawatList.size()][];
                        for (int i = 0; i < dataPesawatList.size(); i++) {
                            List<String> rowList = dataPesawatList.get(i);
                            dataPesawat[i] = rowList.toArray(new String[0]);
                        }
                        Sorting.quickSort(Main.getDropbox(selectedValue), 0, Main.getDropbox(selectedValue).length - 1);
                        Sorting2.quickSort(dataPesawat, 0, dataPesawat.length - 1, Main.getNumDrop(selectedValue));

                        textArea2.setText(Arrays.toString(Main.printSortData(dataPesawat)));
                        System.out.println("sorting " + selectedValue + " suksessss");
                    }
                    else {
                        System.out.println("ada inputan pada textfieldnya");
                    }
                }
            }
        });
        cariButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedValue = (String) comboBox1.getSelectedItem();
                importSQL.Importan importan = new importSQL().new Importan();
                importan.importData();

                List<List<String>> dataPesawatList = importan.getDataPesawat();
                String[][] dataPesawat = new String[dataPesawatList.size()][];
                for (int i = 0; i < dataPesawatList.size(); i++) {
                    List<String> rowList = dataPesawatList.get(i);
                    dataPesawat[i] = rowList.toArray(new String[0]);
                }
                Sorting.quickSort(Main.getDropbox(selectedValue), 0, Main.getDropbox(selectedValue).length - 1);
                Sorting2.quickSort(dataPesawat, 0, dataPesawat.length - 1, Main.getNumDrop(selectedValue));

                Integer[] result = Searching2.binarySearch(Main.getDropbox(selectedValue), textField1.getText());
                int[] intArray = Arrays.stream(result)
                        .mapToInt(Integer::intValue)
                        .toArray();
                if (result != null) {
                    textArea2.setText(Arrays.toString(Main.printData(intArray)));
                    System.out.println("String ditemukan pada indeks " + Arrays.toString(result));
                } else {
                    System.out.println("String tidak ditemukan dalam array.");
                }
            }
        });
        kembaliButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                interfaceFP.interfaceAwal();
                setVisible(false);
            }
        });
    }

    public static void interfaceDetailin(){
        interfaceDetail frame = new interfaceDetail();
        frame.setContentPane(frame.panelDetail);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
