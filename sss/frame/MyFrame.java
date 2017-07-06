package com.sss.frame;

import javax.swing.*;

/**
 * Created by sss on 2017/6/29.
 */
public class MyFrame extends JFrame {

    public MyFrame(int hero_image){
        this.setTitle("飞机大战");
        this.setIconImage(new ImageIcon("res/icon/LOGO.png").getImage());
        //this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setBounds(400,1,512,768);
        this.setLocationRelativeTo(null);
        MyPanel myPanel=new MyPanel(hero_image);
        myPanel.start();
        this.add(myPanel);
        this.setVisible(true);
    }
}

