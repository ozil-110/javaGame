package com.sss.enemy;

import com.sss.control.FlyObject;

import javax.swing.*;

/**
 * Created by sss on 2017/6/29.
 */
public class Enemy3 extends FlyObject {

    public Enemy3(int x,int y){
        setX(x);
        setY(y);
        setImage(new ImageIcon("res/enemy/enemy_3.png").getImage());
        setHeight();
        setWidth();
        setSpeed(3);
        setHp(3);
        setID(3);
    }

    public void move(){

        setY(getY()+getSpeed());


    }
}
