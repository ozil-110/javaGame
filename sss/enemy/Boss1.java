package com.sss.enemy;

import com.sss.control.FlyObject;

import javax.swing.*;

/**
 * Created by sss on 2017/7/1.
 */
public class Boss1 extends FlyObject{
    public Boss1(int x,int y){
        setX(x);
        setY(y);
        setImage(new ImageIcon("res/enemy/boss2.png").getImage());
        setHeight();
        setWidth();
        setHp(500);
    }
}
