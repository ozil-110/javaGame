package heroball;

import java.awt.*;

/**
 * Created by sss on 2017/6/28.
 */
public class HeroBall {
    private int x;
    private int y;
    private int d;
    private Event e;


    public HeroBall(int x, int y, int d) {
        this.x = x;
        this.y = y;
        this.d = d;
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

    public int getD() {
        return d;
    }

    public void setD(int d) {
        this.d = d;
    }


    public void paintBall(Graphics g){
        g.setColor(Color.BLACK);
        g.fillOval(x,y,d,d);
        int size=(int)d*3/2;
        Font font =new Font("华文彩云",2,size);
        g.setFont(font);
        g.setColor(Color.WHITE);
        g.drawString("*",x+d/10-5,y+d*4/3-5);
    }
    public void move(){

    }

}
