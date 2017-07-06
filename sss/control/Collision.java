package com.sss.control;

import com.sss.hero.Hero;

/**
 * Created by sss on 2017/6/29.
 */
public  class Collision {
    //用于检测是否碰撞
    //用于检查碰撞 传入英雄宽高 敌机宽高


    public static Boolean detect(FlyObject hero,FlyObject enemy){
        //可能与四个方向的敌机碰撞
        //敌机在左方 右方 上方 下方



        int hero_w,hero_h,enemy_w,enemy_h;
        hero_h=hero.getHeight();
        hero_w=hero.getWidth();
        enemy_w=enemy.getWidth();
        enemy_h=enemy.getHeight();
        Boolean flag=false;
        int x=(int) (Math.abs(hero.getX()-enemy.getX()));//英雄机与敌机的横坐标之差
        int y=(int) (Math.abs(hero.getY()-enemy.getY()));//             纵坐标
        int h=(int) (Math.min(hero_h,enemy_h));          //图像之宽的最小值
        int w=(int) (Math.min(hero_w,enemy_w));          //      高
        int x1=hero.getX()+hero_w/2;                     //图像的中心点
        int y1=hero.getY()+hero_h/2;
        int x2=enemy.getX()+enemy_w/2;
        int y2=enemy.getY()+enemy_h/2;

        if(Math.abs(y1-y2)<=hero_h/2+enemy_h/2
                &&Math.abs(x1-x2)<=hero_w/2+enemy_w/2){
            flag=true;
        }
        return flag;


        /*int hero_w,hero_h,enemy_w,enemy_h;
        hero_h=hero.getHeight();
        hero_w=hero.getWidth();
        enemy_w=enemy.getWidth();
        enemy_h=enemy.getHeight();
        Boolean flag=false;
        int x=(int) (Math.abs(hero.getX()-enemy.getX()));//英雄机与敌机的横坐标之差
        int y=(int) (Math.abs(hero.getY()-enemy.getY()));//             纵坐标
        int h=(int) (Math.min(hero_h,enemy_h));          //图像之宽的最小值
        int w=(int) (Math.min(hero_w,enemy_w));          //      高
        int x1=hero.getX()+hero_w/2;                     //图像的中心点
        int y1=hero.getY()+hero_h/2;
        int x2=enemy.getX()+enemy_w/2;
        int y2=enemy.getY()+enemy_h/2;

        if(Math.abs(x1-x2)<=hero_w/2+enemy_w/2
                &&y<=h){
            flag=true;
        }
        return flag;*/

    }
}
