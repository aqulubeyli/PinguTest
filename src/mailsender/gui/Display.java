/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mailsender.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.TextField;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.*;
/**
 *
 * @author Aydin
 * 
 */
public class Display {
    
    private JFrame wframe;
    private JPanel wpanel;
    
    private int width = 800;
    private int height = 600;
    
    public Display(){
        create_window();
    }
    
    private void create_window(){
        wframe = new JFrame();
        wpanel = new JPanel();
        wframe.setSize(width,height);
        wframe.getContentPane().add(wpanel);
        wpanel.setBackground(Color.BLACK);
        // wpanele elavelerin edilmesi
        //wpanel.add(new JButton("Test"), BorderLayout.CENTER);
        wpanel.setLayout(new BoxLayout(wpanel, BoxLayout.Y_AXIS));
        JButton b1 = new JButton("test1");
        JButton b2 = new JButton("test2");
        JTextField tf = new JTextField(10);
        
        wpanel.add(b1);
        wpanel.add(b2);
        wpanel.add(tf);
        wframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        wframe.setVisible(true);
    }
}
