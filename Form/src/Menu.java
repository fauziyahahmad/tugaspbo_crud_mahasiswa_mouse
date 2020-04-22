import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Menu extends JFrame{
    JButton input,tampil,hapus,edit,exit;
    JLabel judul;
    
    public Menu(){
        
        setTitle("GUI MAHASISWA");
        
        judul = new JLabel("MENU");
        
        input = new JButton("1. Input Data Mahasiswa");
        tampil = new JButton("2. Tampilkan Seluruh Data");
        hapus = new JButton("3. Hapus Data Mahasiswa");
        edit = new JButton("4. Edit Data Mahasiswa");
        exit = new JButton("0. Exit");
        
        setLayout(null);
        add(judul);
        add(input);
        add(edit);
        add(hapus);
        add(tampil);
        add(exit);
        
        judul.setBounds(150,10,100,25);
        input.setBounds(60, 40, 200, 25);
        edit.setBounds(60, 130, 200, 25);
        tampil.setBounds(60, 70, 200, 25);
        hapus.setBounds(60, 100, 200, 25);
        exit.setBounds(60, 160, 200, 25);
        
        setSize(350,250);
        
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        input.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                new InputData();
            }
        });
        
        edit.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                new EditData();
            }
        });
        
        hapus.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                new HapusData();
            }
        });
        
        tampil.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
              new LihatData();
                
            }
        });
        
        exit.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}

