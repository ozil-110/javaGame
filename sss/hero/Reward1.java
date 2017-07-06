package com.sss.hero;

import com.sss.control.FlyObject;

import javax.swing.*;

/**
 * Created by sss on 2017/7/1.
 */
public class Reward1 extends FlyObject{



    public Reward1(int x, int y){
            setX(x);
            setY(y);
            setImage(new ImageIcon("res/hero/reward1.png").getImage());
            setHeight();
            setWidth();
        }
}
