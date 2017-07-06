package com.sss.enemy;

import com.sss.control.FlyObject;

import javax.swing.*;

/**
 * Created by sss on 2017/6/29.
 */
public class Enemy1 extends FlyObject {

    public Enemy1(int x,int y){
        setX(x);
        setY(y);
        setImage(new ImageIcon("res/enemy/enemy_1.png").getImage());
        setHeight();
        setWidth();
        setSpeed(2);
        setHp(1);
        setID(1);
    }

    public void move(){

            setY(getY()+getSpeed());


    }

}
