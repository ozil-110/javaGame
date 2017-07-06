package com.sss.enemy;

import com.sss.control.FlyObject;

import javax.swing.*;

/**
 * Created by sss on 2017/6/29.
 */
public class Enemy2 extends FlyObject {

    public Enemy2(int x,int y){
        setX(x);
        setY(y);
        setImage(new ImageIcon("res/enemy/enemy_2.png").getImage());
        setHeight();
        setWidth();
        setSpeed(3);
        setHp(2);
        setID(2);
    }

    public void move(){

        setY(getY()+getSpeed());


    }
}
