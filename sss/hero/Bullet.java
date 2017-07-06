package com.sss.hero;

import com.sss.control.FlyObject;

import javax.swing.*;

/**
 * Created by sss on 2017/6/30.
 */
public class Bullet extends FlyObject{
    public Bullet(int x,int y,int speed){
        setX(x-10);
        setY(y);
        setImage(new ImageIcon("res/bullet/bullet2.png").getImage());
        setHeight();
        setWidth();
        setSpeed(speed);
    }

    public void move(){

        setY(getY()-getSpeed());


    }
}
