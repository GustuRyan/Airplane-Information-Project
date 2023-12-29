import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class addDataIF extends JFrame {
    private JPanel panelTambah;
    private JTextField rutetujuan;
    private JButton tambahButton;
    private JButton kembaliButton;
    private JTextField estimasiwaktu;
    private JTextField statuspenerbangan;
    private JTextField ruteawal;
    private JTextField nopenerbangan;
    private JTextField keberangkatan;
    private JTextField kedatangan;
    private JTextField idpesawat;
    private JTextField maskapai;
    private JTextField jumlahpenumpang;
    private JTextField jenispesaawat;

    public addDataIF(){

        tambahButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                importSQL.Insert insert = new importSQL().new Insert();
                insert.adding(nopenerbangan.getText(), ruteawal.getText(), rutetujuan.getText(), idpesawat.getText(), maskapai.getText(), jenispesaawat.getText(), jumlahpenumpang.getText(), estimasiwaktu.getText(), statuspenerbangan.getText(), keberangkatan.getText(), kedatangan.getText());
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
    public static void adddata(){
        addDataIF frame = new addDataIF();
        frame.setContentPane(frame.panelTambah);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
