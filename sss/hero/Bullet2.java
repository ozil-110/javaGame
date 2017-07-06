package com.sss.hero;

import com.sss.control.FlyObject;

import javax.swing.*;

/**
 * Created by sss on 2017/7/1.
 */
public class Bullet2 extends FlyObject{
    public Bullet2(int x,int y,int d){
        setX(x-10);
        setY(y);
        setImage(new ImageIcon("res/bullet/bullet5.png").getImage());
        setHeight();
        setWidth();
        setSpeed(3);
        setDirextion(d);
    }

    public void move(){
        switch (getDirextion()){
            case 1:
                setX(getX()-1);
                setY(getY()-getSpeed());
                break;
            case 2:
                setY(getY()-getSpeed());
                break;

            case 3:
                setX(getX()+1);
                setY(getY()-getSpeed());
                break;
        }
    }
}
