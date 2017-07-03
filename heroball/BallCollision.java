package heroball;

import smileball.*;

/**
 * Created by sss on 2017/6/27.
 */
public class BallCollision {

    public int getE(HeroBall b1, Ball b2){
        int x1,y1,x2,y2,d1,d2,e=0;
        x1=b1.getX()+b1.getD()/2;
        y1=b1.getY()+b1.getD()/2;
        x2=b2.getX()+b2.getD()/2;
        y2=b2.getY()+b2.getD()/2;
        d1=b1.getD()/2;
        d2=b2.getD()/2;

        //圆心距
        Double z=(Math.sqrt((double) (x1-x2)*(x1-x2)+(y1-y2)*(y1-y2)));

        if(z-d1-d2>=-1&&z-d1-d2<=1){
            e=1;
        }
        return e;
    }

}
