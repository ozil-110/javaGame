package heroball;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class BallPanel extends JPanel implements MouseListener{

	ArrayList<Ball> balls = new ArrayList<Ball>();
	HeroBall heroBall = new HeroBall(600, 600, 60);
	Thread thread;

	//游戏状态 运行状态：1  游戏结束：0  游戏胜利：2  暂停：3  重新开始：4
	int status=1;

	int count = 0;

	public BallPanel() {
		//this.setOpaque(false);
		this.control();
		class MyMouseAdapter extends MouseAdapter {

			public void mouseMoved(MouseEvent event) {
				heroBall.setX(event.getX() - heroBall.getD() / 2);//获取横坐标值
				heroBall.setY(event.getY() - heroBall.getD() / 2);//获取纵坐标值


			}

		}

		MouseAdapter adapter = new MyMouseAdapter();
		addMouseListener(this);
		addMouseMotionListener(adapter);
		addBall();


	}


	public void addBall() {
		for (int i = 0; i < 20; i++) {
			int x = (int) (Math.random() * 650);
			int y = (int) (Math.random() * 400);
			int d = (int) (Math.random() * 70 + 30);
			int direction = (int) (Math.random() * 4);
			int speed = 1;//(int)(Math.random()*3+1);
			int r = (int) (Math.random() * 256);
			int g = (int) (Math.random() * 256);
			int b = (int) (Math.random() * 256);
			Color ballColor = new Color(r, g, b);
			Ball ball = new Ball(x, y, direction, d, speed, ballColor);
			balls.add(ball);
		}
	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		heroBall.paintBall(g);
		for (int i = 0; i < balls.size(); i++) {
			Ball ball = balls.get(i);

			ball.drawBall(g);
			ball.drawSmile(g);
		}
		g.setColor(Color.BLACK);
		Font font =new Font("华文彩云",2,85);
		switch (status){
			case 0:
				g.setFont(font);
				g.drawString("GAME OVER",250,400);
				g.drawString("双击鼠标 重新开始游戏",1,80);
				break;

			case 2:
				g.setFont(font);
				g.drawString("You Win!",250,400);
				g.drawString("双击鼠标 重新开始游戏",1,80);
				break;

			case 3:
				g.setFont(font);
				g.drawString("Pause",300,400);
				break;
		}
	}

	public void restart(){
		for(int i=0;i<balls.size();i++){
			balls.remove(i);
		}
		addBall();
		heroBall.setX(600);
		heroBall.setY(600);
		heroBall.setD(60);
	}

	public void control() {

		thread=new Thread() {
			public void run() {

				while (true) {

					for (int i = 0; i < balls.size(); i++) {

						Ball ball2 = balls.get(i);
						ball2.moveBall();
						BallCollision ballCollision = new BallCollision();
						int e=ballCollision.getE(heroBall, ball2);

						if(e==1){
							int heroBallSmall = 1;
							if (heroBall.getD() >= ball2.getD()) {
								balls.remove(i);
								if(balls.size()==0){
									status=2;

								}
								heroBall.setD(heroBall.getD() + 2);

							}
							else if(heroBall.getD() < ball2.getD()){
								status=0;

							}

						}

					}
					repaint();

					if(status==0){
						stop();
					}
					else if(status==3){
						stop();
					}
					else if(status==2){
						stop();
					}

					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

				}


			}

		};
		thread.start();

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(status==1) {
			status = 3;
			//thread.stop();
		}
		else if(status==3){
			status=1;
			control();
		}else if(status==0){
			restart();
			status=3;
		}
		else if(status==2){
			restart();
			status=3;
		}

		//System.exit(0);

	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if(status==3){
			status=1;
			control();
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if(status==1){
			status=3;
		}
	}
}

	


