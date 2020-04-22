
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class HapusData extends JFrame{
    
   String[] [] data = new String [500] [3]; 
    String[] kolom = {"NIM", "NAMA", "ALAMAT"}; 
    JLabel judul;
    JTable tabel;
    JButton btnBack,btnDel;
    JScrollPane scrollPane;
    Statement statement;
    ResultSet resultSet;
    public static String dataterpilih;
    
    public HapusData(){
        
        setTitle("TAMPILKAN DATA MAHASISWA");
        
        judul = new JLabel("SELURUH DATA MAHASISWA");
        btnBack = new JButton("Kembali");
        btnDel = new JButton("Hapus");   
        tabel = new JTable(data,kolom);
        scrollPane = new JScrollPane(tabel);
        
        //setLayout(new FlowLayout());
        
        pack();
        setLayout(null);
       
        add(btnBack);
        add(btnDel);
        add(judul);
        add(scrollPane);
        //add(tabel);
        
        judul.setHorizontalAlignment(SwingConstants.CENTER);
        setSize(500,500);
        
        judul.setBounds(150,20,200,25);
        btnBack.setBounds(250,50,100,20);
        btnDel.setBounds(120,50,100,20);
        scrollPane.setBounds(20,100,450,350);
        //tabel.setBounds(10,100,450,500);
        
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        
        btnBack.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new Menu();
            }
        });
        
        
        tabel.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
        int baris = tabel.getSelectedRow();
        int kolom = tabel.getSelectedColumn();
        dataterpilih = tabel.getValueAt(baris, 0).toString();
        
        System.out.println(dataterpilih);
        btnDel.addActionListener((java.awt.event.ActionEvent f) -> {
            btnBuatactionListener();
        });
            }
            
             private void btnBuatactionListener(){
        
        KoneksiDB koneksi = new KoneksiDB();
                    try {
                        statement = koneksi.getKoneksi().createStatement();
                        statement.executeUpdate("DELETE FROM data_mhs WHERE nim='" + dataterpilih + "'");
                        JOptionPane.showMessageDialog(null, "Data berhasil di Hapus!","Hasil", JOptionPane.INFORMATION_MESSAGE);
                        statement.close();
                    } catch (ClassNotFoundException ex) {
                        JOptionPane.showMessageDialog(null, "Driver tidak ditemukan!", "Hasil", JOptionPane.ERROR_MESSAGE);
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, "Data gagal di Hapus!", "Hasil", JOptionPane.ERROR_MESSAGE);
                    }
        
    }
        });
        
         KoneksiDB koneksi = new KoneksiDB();        
        try{
            
            statement = koneksi.getKoneksi().createStatement();
            
            String sql = "SELECT * FROM data_mhs";
            resultSet = statement.executeQuery(sql);
            
            int p=0;
            while(resultSet.next()){
                data[p][0] = resultSet.getString("nim"); //disesuaikan dg nama di database
                data[p][1] = resultSet.getString("nama");
                data[p][2] = resultSet.getString("alamat");
                p++;
            }
            statement.close();
        }
        
        catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Data gagal ditampilkan","hasil", JOptionPane.ERROR_MESSAGE);
        }
        catch (ClassNotFoundException ex){
            JOptionPane.showMessageDialog(null, "Driver tidak ditemukan","hasil", JOptionPane.ERROR_MESSAGE);
        }
        
        
        
    }
    
    
    
    
   
    
}
