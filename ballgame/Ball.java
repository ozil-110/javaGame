package cn.ballgame;

import java.awt.Color;
import java.awt.Graphics;

public class Ball {

	int x,y,d,speed,f;

	
	Ball(int x, int y, int d, int speed) {
		this.x = x;
		this.y = y;
		this.d = d;
		this.speed = speed;
	}
	public void drawBall(Graphics g){
		g.setColor(Color.black);
		g.fillOval(x, y, d, d);
	}
	

}
