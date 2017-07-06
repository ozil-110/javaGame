package com.sss.hero;

import com.sss.control.FlyObject;

import javax.swing.*;
import java.awt.*;

/**
 * Created by sss on 2017/6/29.
 */
public class Hero extends FlyObject {


    public Hero(int x, int y,Image image){
        setX(x);
        setY(y);
        setImage(image);
        setHeight();
        setWidth();
        setHp(10);
    }
}
