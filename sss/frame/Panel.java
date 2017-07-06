package com.sss.frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.sun.javafx.geom.BaseBounds.BoundsType.BOX;

/**
 * Created by sss on 2017/7/1.
 */
public class Panel extends JPanel {

    int flag=0;
    public Panel(){
        Icon icon1=new ImageIcon("res/hero/hero1.png");//瀹炰緥鍖朓con瀵硅薄
        JButton jb=new JButton(icon1);
        Icon icon2=new ImageIcon("res/hero/hero2.png");//瀹炰緥鍖朓con瀵硅薄
        jb.setIcon(icon1);//涓烘寜閽缃浘鏍�
        //jb.setBorderPainted(false);//璁剧疆鎸夐挳杈圭晫涓嶆樉绀�
        jb.setFocusPainted(false);
        jb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                flag=1;
                MyFrame myFrame=new MyFrame(flag);
            }
        });

        JButton jb1=new JButton(icon2);
        //jb.setMaximumSize(new Dimension(90,30));//璁剧疆鎸夐挳鍜屽浘鐗囩殑澶у皬鐩稿悓
        jb1.setIcon(icon2);//涓烘寜閽缃浘鏍�
        //jb1.setBorderPainted(false);//璁剧疆鎸夐挳杈圭晫涓嶆樉绀�
        jb1.setFocusPainted(false);
        jb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                flag=2;
                MyFrame myFrame=new MyFrame(flag);


            }
        });
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        JPanel jPanel=new JPanel();

       jPanel.setLayout(new BoxLayout(jPanel,BoxLayout.X_AXIS));
        jPanel.add(jb);

        jPanel.add(Box.createHorizontalGlue ());
        jPanel.add(jb1);
        this.add(Box.createVerticalStrut(320));
        this.add(jPanel);




    }

    @Override
    public void paint(Graphics g) {

        g.drawImage(new ImageIcon("res/scene/start.jpg").getImage(),1,1,null);
        g.drawImage(new ImageIcon("res/scene/select.png").getImage(),137,363,null);
        g.drawImage(new ImageIcon("res/scene/LOGO.png").getImage(),17,500,null);

    }
}
