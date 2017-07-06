package com.sss.frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;


/**
 * Created by sss on 2017/7/1.
 */
public class Menu extends JFrame{

    int hero;

    public Menu(){
        Panel panel=new Panel();
        this.add(panel);
        setTitle("飞机大战");
        this.setBounds(400,1,512,768);
        this.setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public static void main(String args[]){
        Menu menu=new Menu();
    }
}
