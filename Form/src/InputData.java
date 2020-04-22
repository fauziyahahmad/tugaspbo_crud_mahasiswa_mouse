import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class InputData extends JFrame{
    JLabel lnim,lnama,lalamat,judul;
    JTextField txnim,txnama,txalamat;
    JButton cetak,btnKembali;
    Statement statement;
    
    public InputData(){
        
        setTitle("INPUT DATA MAHASISWA");
        
        judul = new JLabel("INPUT DATA MAHASISWA");
        lnim = new JLabel("NIM");
        lnama = new JLabel("Nama");  
        lalamat = new JLabel("Alamat");
        
        txnim = new JTextField("");
        txnama = new JTextField("");
        txalamat = new JTextField("");
        
        btnKembali = new JButton("Kembali");
        cetak = new JButton("Simpan");
        
        setLayout(null);
        add(judul);
        add(lnim);
        add(lnama);
        add(lalamat);
        add(txnim);
        add(txnama);
        add(txalamat);
        add(cetak);
        add(btnKembali);
        
        judul.setBounds(120,10,300,25);
        lnama.setBounds(75, 50, 50, 20);
        lnim.setBounds(75, 75, 50, 20);
        lalamat.setBounds(75, 100, 50, 20);
        txnama.setBounds(150, 50, 150, 20);
        txnim.setBounds(150, 75, 150, 20);
        txalamat.setBounds(150, 100, 150, 20);
        cetak.setBounds(75, 150, 100, 25);
        btnKembali.setBounds(200,150, 100, 25);
        
        setSize(400,250); 
        
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        btnKembali.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new Menu();
            }
        });
        
        cetak.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                int a1 =  Integer.parseInt(txnim.getText());
                String a2 = txnama.getText();
                String a3 = txalamat.getText();
                        
                KoneksiDB koneksi = new KoneksiDB();
                    try {
                        statement = koneksi.getKoneksi().createStatement();
                        statement.executeUpdate("INSERT INTO data_mhs VALUES ('" 
                        + a2 + "','" + a1 + "','" + a3 + "')");
                        JOptionPane.showMessageDialog(rootPane, "Data tersimpan");
                        
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(InputData.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(InputData.class.getName()).log(Level.SEVERE, null, ex);
                    }
                
                    
                } catch (NumberFormatException ex) {
                 JOptionPane.showMessageDialog(rootPane,"TIPE DATA SALAH");
                } catch (Error ext){
                 JOptionPane.showMessageDialog(rootPane,"SALAH");
                 
                }
                
            }

        });
        
        
        
        
        
        
    }
}
