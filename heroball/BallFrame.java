package heroball;

import com.sun.awt.AWTUtilities;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class BallFrame extends JFrame {


	static int restart=0;
	public BallFrame(){
		this.setTitle("球球大作战");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 900, 750);
		//this.setUndecorated(true);
		//AWTUtilities.setWindowOpaque(this,false);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);



	}
	public static void main(String[] args) {
		BallFrame bf= new BallFrame();

		BallPanel bj=new BallPanel();

		bf.add(bj);
	}

		
}



