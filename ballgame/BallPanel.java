package cn.ballgame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.LayoutManager;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class BallPanel extends JPanel implements MouseMotionListener,MouseListener{

	List<Block> blos = new ArrayList<Block>();
	 //星星坐标
        int []a= new int[1000];
        int []b=new int[1000];
        //小球方向和分数
        int f=0;
        int score=0;
        //关卡
        int mission=1;
        //状态
        int status=1;
        //星星个数
        int starflag=0;
        //鼠标状态
        int mouseflag=0;
        //初始化挡板
        int x1=200;int w1=200;
	int y1=500;int h1=20;
	Baffle baf = new Baffle(x1,y1,w1,h1);
	//初始化小球
	int x=200;
        int y=300;
	int d=50;int speed=2;
	Ball ba = new Ball(x,y,d,speed);
	

	
	public BallPanel() {
		//添加事件监听和砖块
		addMouseMotionListener(this);
		addMouseListener(this);
		addBlock();
		}
	//添加砖块
	public void addBlock(){
		//根据关卡生成砖块
		if(mission==1){
		for(int i=0;i<3;i++){
			for(int j=0;j<6;j++){
			int bx=25;int by=25;
			int bw=80;int bh=30;
			int hp=1;
		    Block blo = new Block(bx+j*90,by+i*40,bw,bh,hp);
			blos.add(blo);
			}
		}
		}
		if(mission==2){
			for(int i=0;i<3;i++){
				for(int j=0;j<6;j++){
				int bx=25;int by=25;
				int bw=80;int bh=30;
				int hp=1;
				if(i==0){
				    hp=3;
				}else if(i==1){
					hp=2;
				}
			    Block blo = new Block(bx+j*90,by+i*40,bw,bh,hp);
				blos.add(blo);
				}
			}
			}
}
	
		

    //重置游戏
	private void reStart() {
		for(int i=blos.size()-1;i>=0;i--){
			blos.remove(i);
		}
		for(int i=0;i<starflag;i++){
			a[i]=1000;
			
		}
		score=0;
		mission=1;
		ba.speed=2;
		baf.w=200;
		addBlock();
		
	}
	//下一关
	public void nextMission(){
		for(int i=0;i<starflag;i++){
			a[i]=1000;
			
		}
		ba.speed+=2;
		baf.w-=100;
		addBlock();
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
    
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
        
        //判断鼠标在挡板上
    	if(e.getX()>=baf.x&&e.getX()<=baf.x+baf.w&&e.getY()>=baf.y&&e.getY()<=baf.y+baf.h){
        	mouseflag=0;
        }
    	//
		if(status==3&&mouseflag==0){
			startBall();
			status=1;
		}
		

		if(mouseflag==0){
		baf.x=e.getX()-baf.w/2;
                baf.y=e.getY();
		}
	
	}
	

	@Override
	public void mouseClicked(MouseEvent e) {
		//判断进入下一关还是重置
		 if(status==2&&mission!=2){
			mission++;
			startBall();
			status=1;
			nextMission();
			baf.x=x1;
			baf.y=y1;
			ba.x=x;
			ba.y=y;
		}else{
			    reStart();
			    startBall();
			    status=1;
			    baf.x=x1;
			    baf.y=y1;
			    ba.x=x;
			    ba.y=y;
				
		}
	}

	
	@Override
	public void mouseEntered(MouseEvent e) {
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		status=3;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void startBall(){
		new Thread(){
			public void run() {
				while(true){
			    //小球方向
		            if(f==0){
		                ba.x+=ba.speed;
		                ba.y+=ba.speed;
		            }
		            if(f==1){
		                ba.x-=ba.speed;
		               ba.y+=ba.speed;
		            }
		            if(f==2){
		                ba.x-=ba.speed;
		                ba.y-=ba.speed;}
		            if(f==3){
		                ba.x+=ba.speed;
		                ba.y-=ba.speed;
		            }
                    
		            if(ba.x>=600-50-20){
		                if(f==0){
		                    f=1;
		                }
		                if(f==3){
		                    f=2;
		                }
		               
		            }
		            if(ba.y>=600-50-40){
		                status=0;
		                }
		            //碰板得分，增加星星
		            if ((baf.y-ba.y-50<=0&&baf.y-ba.y-50>=-15)&&ba.x+25>=baf.x&&ba.x+25<=baf.x+200){
		                if(f==1){
		                    f=2;
		                }
		                if(f==0){
		                    f=3;
		                }
		                a[starflag]=ba.x-100;
		                b[starflag]=ba.y;
		               starflag+=1;
		               score+=10;
		                

		            }
		            if(ba.x<=0){
		                if(f==2){
		                    f=3;
		                }
		                if(f==1){
		                    f=0;
		                }
		                
		            }
		            if(ba.y<=0){
		                if(f==3){
		                    f=0;
		                }
		                if(f==2){
		                    f=1;
		                }
		                
		            }
		            //碰砖块得分
		            for(int i=0;i<blos.size();i++){
		            	
		            	
		            	Block blo=blos.get(i);
		            	if(ba.x+25<=blo.bx+blo.bw
		            			&&ba.x+25>=blo.bx
		            			&&ba.y-25<=blo.by){
		            		if(f==3){
		                        f=0;
		                    }
		                    if(f==2){
		                        f=1;
		                    }
		                    blos.get(i).hp--;
		                    if(blos.get(i).hp==0){
		                    score+=100;
		            		blos.remove(i);
		                    }
		            		
		            	}
		            }
		           
		            //星星移动
		            for(int i=0;i<starflag;i++){
		            	b[i]++;
		            }
		            if(blos.size()==0){
		            	status=2; }
		            if(baf.x<=0){
		            	baf.x=0;
		            }
		            if(baf.x+baf.w>=600-30){
		            	baf.x=600-baf.w;
		            }
		            repaint();
		            if(status!=1){
		            	this.stop();
		            }
		            try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
		}.start();
	}
	@Override
	public void paint(Graphics g) {
	    super.paint(g);
	    paintScore(g);
	    baf.drawBaffle(g);
	    ba.drawBall(g);
	    paintBlock(g);
	    paintStatus(g);
	    if(starflag>=1){
	    	paintStar(g);
	    }
	}
	
	public void paintScore(Graphics g){
        Font font=new Font("consolas",3,20);
        g.setFont(font);
        g.setColor(Color.black);
        g.drawString("SCORE: "+score,20,20);
        g.drawString("Mission: "+mission,460,20);
        
    }
	public void paintBlock(Graphics g){
	    
	    	for(int i=0;i<blos.size();i++){
	    		Block bloc= blos.get(i);
	    		if(blos.get(i).hp==3){
	    			Color co3= new Color(188,143,143);
	    			g.setColor(co3);
	    		}else if(blos.get(i).hp==2){
	    			Color co2= new Color(210,105,30);
	    			g.setColor(co2);
	    		}else{
	    			Color co1= new Color(105,105,105);
	    			g.setColor(co1);
	    			
	    		}
	    		g.fillRect(bloc.bx, bloc.by, bloc.bw, bloc.bh);
	    	}
	    	
	}
	 public void paintStar(Graphics g){
	        if(starflag>=1){
	        for(int i=0;i<starflag+1;i++){
	            Font font1=new Font("华云彩云",3,100);
	            int r1=(int) (Math.random()*256);
	            int g1=(int) (Math.random()*256);
	            int b1=(int) (Math.random()*256);
	            Color co1= new Color(r1,g1,b1);
	            g.setColor(co1);
	            g.setFont(font1);
	            g.drawString("*",a[i],b[i]);
	        	}         
	        }
	    }
    public void paintStatus(Graphics g){
        if(status==0){
            Font font1=new Font("consolas",3,50);
            g.setFont(font1);
            g.drawString("Game Over",190,250);
            Font font2=new Font("华云彩云",3,30);
            g.setFont(font2);
            g.drawString("游戏失败",160,350);
        }
        if(status==2&&mission!=2){
             Font font1=new Font("consolas",3,50);
             g.setFont(font1);
             g.setColor(Color.red);
             g.drawString("You win!!!",180,250);
             Font font2=new Font("华云彩云",3,30);
             g.setFont(font2);
             g.drawString("单击开始",160,350);
            }
        if(status==2&&mission==2){
             Font font1=new Font("consolas",3,50);
             g.setFont(font1);
             g.setColor(Color.red);
             g.drawString("You win!!!",180,250);
             Font font2=new Font("华云彩云",3,30);
             g.setFont(font2);
             g.drawString("游戏胜利",160,350);
            }
        if(status==3){
             mouseflag=1;
             Font font1=new Font("consolas",3,50);
             g.setFont(font1);
             g.setColor(Color.blue);
             g.drawString("Pause",180,250);
        }

    }

}
