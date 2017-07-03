package heroball;

import java.awt.*;

public class Ball {
	int x,y,direction,d,speed,flag=1;
	Color ballColor;
	static final int LEFT_UP=2;
	static final int LEFT_DOWN=0;
	static final int RIGHT_UP=3;
	static final int RIGHT_DOWN=1;
	/**
	 * @param x
	 * @param y
	 * @param direction
	 * @param d
	 * @param speed
	 * @param
	 */
	Ball(int x, int y, int direction, int d, int speed, Color ballColor) {
		super();
		this.x = x;
		this.y = y;
		this.direction = direction;
		this.d = d;
		this.speed = speed;
		this.ballColor = ballColor;
	}


	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public int getD() {
		return d;
	}

	public void setD(int d) {
		this.d = d;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public void drawBall(Graphics g){
		g.setColor(ballColor);
		g.fillOval(x, y, d, d);
	}
	public void drawSmile(Graphics g){
		int size=d/2-8;
		Font font =new Font("华文琥珀",2,size);
		g.setFont(font);
		g.setColor(Color.BLACK);

		switch(flag){
			case 1:
				g.drawString("TnT",x+d/4,y+d/5*3);
				break;
			case 2:
				g.drawString("^_^",x+d/4,y+d/5*3);
			case 3:
				g.drawString("强者",x+d/4,y+d/5*3);
				break;
			case 4:
				int size1=d/2-15;
				Font font1 =new Font("华文琥珀",2,size);
				g.setColor(Color.RED);
				g.setFont(font);
				g.drawString("最强王者",x+d/4,y+d/5*3);
				break;


		}

	}

	public void moveBall(){
		switch(direction){
		case LEFT_UP: x-=speed;
		              y-=speed;
		              if(x<=0)direction=RIGHT_UP;
		              if(y<=0)direction=LEFT_DOWN;
		              break;
		case LEFT_DOWN: x-=speed;
		                y+=speed;
		                if(y>=800-d/2-110)direction=LEFT_UP;
		                if(x<=0)direction=RIGHT_DOWN;
		                break;
		case RIGHT_UP: x+=speed;
		               y-=speed;
		               if(x>=900-d/2-38)direction=LEFT_UP;
		               if(y<=0)direction=RIGHT_DOWN;
		               break;
		case RIGHT_DOWN: x+=speed;
		                 y+=speed;
		                 if(y>=800-d/2-110)direction=RIGHT_UP;
		                 if(x>=900-d/2-38)direction=LEFT_DOWN;
		                 break;
		}
	}

}
