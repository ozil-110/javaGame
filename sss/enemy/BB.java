package com.sss.enemy;

import com.sss.control.FlyObject;

import javax.swing.*;
import java.awt.*;

public class BB extends FlyObject{
    static final int LEFT_UP=2;
    static final int LEFT_DOWN=0;
    static final int RIGHT_UP=3;
    static final int RIGHT_DOWN=1;

    public BB(int x, int y, int direction,int speed) {
        super();
        setX(x);
        setY(y);
        setDirextion(direction);
        setImage(new ImageIcon("res/enemy/bullet3.png").getImage());
        setHeight();
        setWidth();
        setSpeed(speed);
    }



    public void move(){
        switch(getDirextion()){
            case LEFT_UP: setX(getX()-getSpeed());
                setY(getY()-getSpeed());
                if(getX()<=0)setDirextion(RIGHT_UP);
                if(getY()<=250)setDirextion(LEFT_DOWN);
                break;
            case LEFT_DOWN: setX(getX()-getSpeed());
                setY(getY()+getSpeed());
                if(getY()>=700)setDirextion(LEFT_UP);
                if(getX()<=0)setDirextion(RIGHT_DOWN);
                break;
            case RIGHT_UP: setX(getX()+getSpeed());
                setY(getY()-getSpeed());
                if(getX()>=500)setDirextion(LEFT_UP);
                if(getY()<=250)setDirextion(RIGHT_DOWN);
                break;
            case RIGHT_DOWN: setX(getX()+getSpeed());
                setY(getY()+getSpeed());
                if(getY()>=700)setDirextion(RIGHT_UP);
                if(getX()>=500)setDirextion(LEFT_DOWN);
                break;
        }
    }

}
