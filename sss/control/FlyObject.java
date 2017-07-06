package com.sss.control;

import java.awt.*;
import javax.swing.*;

/**
 * Created by sss on 2017/6/29.
 */
public class FlyObject {

    private int x;//坐标值
    private int y;
    private int speed;//速度
    private int a;//图像的长宽
    private int b;
    private Image image;//图像文件

    private int hp;

    private int width;
    private int height;
    private int ID=1;//作为各种奖励以及敌机的标识

    private int dirextion;//作为子弹的方向 1左 2中 3右

    public int getDirextion() {
        return dirextion;
    }

    public void setDirextion(int dirextion) {
        this.dirextion = dirextion;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public FlyObject(){

    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth() {
        this.width =this.getImage().getWidth(null);
    }

    public int getHeight() {
        return height;
    }

    public void setHeight() {
        this.height =this.getImage().getHeight(null);
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
    public void move(){}
    public void draw(Graphics g){
        g.drawImage(this.getImage(),this.getX(),this.getY(),null);
    }
}
