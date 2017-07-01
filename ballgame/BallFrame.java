package cn.ballgame;

import javax.swing.JFrame;




public class BallFrame extends JFrame{
	BallFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(600,100,600,600);
        this.setResizable(true);
        this.setTitle("´ò×©¿é");
        this.setLocationRelativeTo(null);
        BallPanel panel=new BallPanel();
        panel.startBall();
        this.add(panel);
        this.setVisible(true);
        
    }
    public static void main(String args[]){
        BallFrame ball=new BallFrame();
    }

}
