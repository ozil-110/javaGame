package com.sss.hero;

import com.sss.control.FlyObject;

import javax.swing.*;

/**
 * Created by sss on 2017/7/1.
 */
public class Reward3 extends FlyObject{

    private int ID=3;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
    public Reward3(int x,int y){
        setX(x);
        setY(y);
        setImage(new ImageIcon("res/hero/reward3.png").getImage());
        setHeight();
        setWidth();
    }
}
