package com.sss.frame;

import com.sss.control.Collision;
import com.sss.control.FlyObject;
import com.sss.enemy.*;
import com.sss.hero.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

/**
 * Created by sss on 2017/6/29.
 */
public class MyPanel extends JPanel implements MouseListener {
    Hero hero;
    int hero_width;
    int hero_hight;
    int enemy_w;
    int enemy_h;
    int BGy1=768-3122;
    int BGy2=768-3122;
    int BGy3=768-3122;
    int BGy4=768-3122;

    int boss_status=0;
    //??????? ??????????1  ?????????0  ????????2  ?????3  ?????????4
    int status=1;
    int score=0;//????
    int scene=1;//???????

    FlyObject boss1=new FlyObject();
    int bullet_status=1;//????????  1 ??????? 2 ??????? 3???????

    int score_status=1;//????????? 1 ????? 2 ????

    ArrayList<FlyObject> enemys=new ArrayList<FlyObject>();//?��??????

    ArrayList<FlyObject> bullets=new ArrayList<FlyObject>();//???????????

    ArrayList<FlyObject> rewards=new ArrayList<FlyObject>();//?????????

    ArrayList<FlyObject> boss_bullets=new ArrayList<FlyObject>();//boss????????



    Image scene1=new ImageIcon("res/scene/scene1.jpg").getImage();
    Image scene2=new ImageIcon("res/scene/scene2.jpg").getImage();
    Image scene3=new ImageIcon("res/scene/scene3.jpg").getImage();
    Image scene4=new ImageIcon("res/scene/scene4.jpg").getImage();


    public MyPanel(int hero_image){

        switch (hero_image){
            case 1:
                hero=new Hero(200,200,new ImageIcon("res/hero/hero1.png").getImage());
                break;
            case 2:
                hero=new Hero(200,200,new ImageIcon("res/hero/hero2.png").getImage());
                break;
        }

        boss1=new Boss1(40,0);
     
            boss_bullets.add(new BB(250,300,0,3));
            boss_bullets.add(new BB(250,300,2,3));

            boss_bullets.add(new BB(250,300,1,2));

            boss_bullets.add(new BB(250,300,3,4));

            


        hero_width=hero.getImage().getWidth(this);
        hero_hight=hero.getImage().getHeight(this);
        class MyMouseAdapter extends MouseAdapter{
            @Override
            public void mouseMoved(MouseEvent e) {
                hero.setX(e.getX()-hero_width/2);
                hero.setY(e.getY()-hero_hight/2);
            }
        }

        MyMouseAdapter myMouseAdapter=new MyMouseAdapter();
        addMouseListener(this);
        addMouseMotionListener(myMouseAdapter);

    }

    public void addEnemy(){
        int flag;//???????????��?

        flag=(int) (Math.random()*3+1);
        switch (flag){
            case 1:
                enemys.add(new Enemy1((int) (Math.random()*500),0));
                break;
            case 2:
                enemys.add(new Enemy2((int) (Math.random()*500),0));
                break;
            case 3:
                enemys.add(new Enemy3((int) (Math.random()*500),0));

        }
    }


    public void addBullet(int speed){//????????????????
        bullets.add(new Bullet(hero.getX()+hero_width/2,hero.getY(),speed));
    }

    public void addBullet2(){//????????????????
        bullets.add(new Bullet2(hero.getX()+hero_width/2,hero.getY(),1));
        bullets.add(new Bullet2(hero.getX()+hero_width/2,hero.getY(),2));
        bullets.add(new Bullet2(hero.getX()+hero_width/2,hero.getY(),3));
    }

    public void addReward(int x,int y){
        int flag;//??????????????

        flag=(int) (Math.random()*3+1);
        switch (flag){
            case 1:
                rewards.add(new Reward1(x,y));
                break;
            case 2:
                rewards.add(new Reward2(x,y));
                break;
            case 3:
                rewards.add(new Reward3(x,y));

        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        switch(scene){
            case 1:
                g.drawImage(scene1,0,BGy1,null);//??????
                break;
            case 2:
                g.drawImage(scene2,0,BGy2,null);//??????
                break;
            case 3:
                g.drawImage(scene3,0,BGy3,null);//??????
                break;
            case 4:
                g.drawImage(scene4,0,BGy4,null);//??????
        }

        for(int i=0;i<enemys.size();i++){

            //??????
            if(enemys.get(i).getY()>=800){

                enemys.remove(i);
            }
            else if(enemys.get(i).getHp()<=0){

                //??????????????????
                if(enemys.get(i).getID()==3&&rewards.size()<=10){
                    addReward(enemys.get(i).getX(),enemys.get(i).getY());

                }
                switch (score_status){//?????????????
                    case 1:
                        score+=10;
                        break;
                    case 2:
                        score+=20;
                        break;
                }
                //????????��?????
                if(score>=0&&score<500){
                    scene=1;
                }
                else if(score>=500&&score<1000){
                    scene=2;
                }else if(score>=1000&&score<=1500){
                    scene=3;
                }else if(score>2500){
                    scene=4;
                    boss_status=1;

                }
                enemys.remove(i);

            }
            else{

                enemys.get(i).move();
                enemys.get(i).draw(g);
            }

        }
        //??????
        for (int i=0;i<bullets.size();i++){

            if(bullets.get(i).getY()<=0) {
                bullets.remove(i);

            }
            else{
                bullets.get(i).move();
                bullets.get(i).draw(g);
            }

        }
        //??????
        for (int i=0;i<rewards.size();i++){
            rewards.get(i).draw(g);
        }

        //??boss
        if(boss_status!=0){
            boss1.draw(g);
            g.setColor(Color.ORANGE);
            for (int i1=0;i1<bullets.size();++i1){//??boss???????????
                if(Collision.detect(boss1,bullets.get(i1))){

                    bullets.remove(i1);
                    boss1.setHp(boss1.getHp()-1);
                    if(boss1.getHp()<=0){
                        status=2;
                    }

                }
            }

            //????????boss????????????

            for (int i=0;i<boss_bullets.size();i++){
                boss_bullets.get(i).move();
                boss_bullets.get(i).draw(g);
            }

            g.fillRect(1,1,boss1.getHp(),20);//??????

        }

        hero.draw(g);//?????
        Font font=new Font("Arial Rounded MT Bold",Font.BOLD,23);
        g.setFont(font);
        g.setColor(Color.RED);
        g.drawString("Score: "+score,1,20);//??????

        g.drawString("HP ",1,717);
        g.setColor(Color.GREEN);
        g.fillRect(40,700,hero.getHp()*15,20);//??????

        switch (status){
            case 1:
                break;
            case 0:
                g.drawImage(new ImageIcon("res/scene/gameover.png").getImage(),140,350,null);
                break;
            case 2:
                g.drawImage(new ImageIcon("res/scene/win2.png").getImage(),70,290,null);
                g.drawImage(new ImageIcon("res/scene/win1.png").getImage(),140,350,null);
        }

    }

    public void start(){
        new Thread(){
            @Override
            public void run() {
                int num=1;
                while(true){
                    num++;
                    if(num%30==0){
                        if(boss_status==0){
                            addEnemy();
                        }

                        switch (bullet_status){
                            case 1:
                                addBullet(3);
                                break;
                            case 2:
                                addBullet(8);
                                break;
                            case 3:
                                addBullet2();
                        }
                        num=1;

                    }

                    //???????��???????????????
                    for(int i=0;i<enemys.size();++i){

                        int flag=0;
                        for (int i1=0;i1<bullets.size();++i1){
                            if(Collision.detect(enemys.get(i),bullets.get(i1))){

                                ++flag;
                                bullets.remove(i1);
                                break;

                            }
                        }
                        enemys.get(i).setHp(enemys.get(i).getHp()-flag);

                    }

                    //?????????��??????????
                    for(int i=0;i<enemys.size();i++){
                        if (Collision.detect(hero,enemys.get(i))){
                            //status=0;
                            enemys.remove(i);
                            hero.setHp(hero.getHp()-1);

                            if(hero.getHp()<=0){
                                status=0;
                            }
                        }
                    }

                    //????????????????????
                    for(int i=0;i<rewards.size();i++){
                        if(Collision.detect(hero,rewards.get(i))){
                            switch (rewards.get(i).getID()){
                                case 1:
                                    bullet_status=2;//???????????
                                    rewards.get(i).setX(340);
                                    rewards.get(i).setY(675);
                                    break;
                                case 2:
                                    bullet_status=3;//??????
                                    rewards.get(i).setX(260);
                                    rewards.get(i).setY(675);
                                    break;
                                case 3:
                                    score_status=2;
                                    rewards.get(i).setX(420);//???????????
                                    rewards.get(i).setY(675);

                            }
                        }
                    }


                    //?????????????
                    switch (scene){
                        case 1:
                            if(BGy1==0){
                                BGy1=768-3122;
                            }else {
                                BGy1++;
                            }
                            break;
                        case 2:
                            if(BGy2==0){
                                BGy2=768-3122;
                            }else {
                                BGy2++;
                            }
                            break;
                        case 3:
                            if(BGy3==0){
                                BGy3=768-3122;
                            }else {
                                BGy3++;
                            }
                            break;
                        case 4:
                            if(BGy4==0){
                                BGy4=768-3122;
                            }else {
                                BGy4++;
                            }
                            break;
                    }

                    repaint();

                    //?????????????
                    if(status==0){
                        stop();
                    }
                    else if(status==3){
                        stop();
                    }
                    else if(status==2){
                        stop();
                    }
                    try{
                        Thread.sleep(10);
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                }

            }
        }.start();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(status==1) {
            status = 3;
        }
        else if(status==3){
            status=1;
            start();
        }else if(status==0){
            //restart();
            status=3;
        }
        else if(status==2){
            //restart();
            status=3;
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if(status==3){
            status=1;
            start();
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(status==1){
            status=3;
        }
    }
}