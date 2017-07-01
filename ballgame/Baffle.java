package cn.ballgame;

import java.awt.Color;
import java.awt.Graphics;

public class Baffle {
	int x,y,w,h;

	
	Baffle(int x, int y, int w, int h) {
		super();
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}
	public void drawBaffle(Graphics g){
		g.setColor(Color.black);
		g.fillRect(x, y, w, h);
	}

}
