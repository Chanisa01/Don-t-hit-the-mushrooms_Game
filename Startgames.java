import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URL;



public class Startgames extends JFrame {
    Startgames(){
        add(new GameArea());
    }
    public static class GameArea extends JPanel{
        URL imageURL = this.getClass().getResource("image/car.png");
        Image image = new ImageIcon(imageURL).getImage();

        //==================================================mushroom====================================================
        URL imageURL2 = this.getClass().getResource("image/mushroom.png");
        Image image2 = new ImageIcon(imageURL2).getImage();

        URL imageURL3 = this.getClass().getResource("image/mushroom.png");
        Image image3 = new ImageIcon(imageURL3).getImage();

        URL imageURL4 = this.getClass().getResource("image/mushroom.png");
        Image image4 = new ImageIcon(imageURL4).getImage();

        URL imageURL5 = this.getClass().getResource("image/mushroom.png");
        Image image5 = new ImageIcon(imageURL5).getImage();

        URL imageURL6 = this.getClass().getResource("image/mushroom.png");
        Image image6 = new ImageIcon(imageURL6).getImage();

        URL imageURL7 = this.getClass().getResource("image/mushroom.png");
        Image image7 = new ImageIcon(imageURL7).getImage();

        URL imageURL8 = this.getClass().getResource("image/mushroom.png");
        Image image8 = new ImageIcon(imageURL8).getImage();

        URL imageURL9 = this.getClass().getResource("image/mushroom.png");
        Image image9 = new ImageIcon(imageURL9).getImage();
        //==============================================================================================================

        URL BackgroundURL = this.getClass().getResource("image/bg1.jpg");
        Image bg = new ImageIcon(BackgroundURL).getImage();

        URL BackgroundURL1 = this.getClass().getResource("image/bgstart.png"); //over or finished
        Image bg1 = new ImageIcon(BackgroundURL1).getImage();

        //ตำแหน่งเริ่มต้นของรถ
        int x1 = 100; //x of a car
        int y1 = 250; //y of a car

        int x[] = {200,200,500,800,800,1000,1300,1300}; //mushroom
        int y[] = {400,100,250,400,100,250,400,100}; //mushroom

        public int times = 20 ;
        boolean timestart = false;

        int score = 200;
        int distanceP;

        char KeyChar = 'A';

        Thread time = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    try{
                        Thread.sleep(10);
                    }catch(Exception e){ }

                    if(timestart == false){
                        repaint(); //clear
                    }
                }
            }
        });
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    if(timestart == false){
                        times = (times-1);
                    }
                    try{
                        Thread.sleep(1000);
                    }catch(InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                }
            }
        });

        GameArea(){
            setFocusable(true);
            addKeyListener(new KeyListener() {
                @Override
                public void keyTyped(KeyEvent e) {

                }

                @Override
                public void keyPressed(KeyEvent e) {
                    switch (e.getKeyCode())
                    {
                        case KeyEvent.VK_DOWN: y1+=20; break;
                        case KeyEvent.VK_UP: y1-=20; break;
                        case KeyEvent.VK_LEFT: x1-=20; break;
                        case KeyEvent.VK_RIGHT: x1+=20; break;
                        default: KeyChar = e.getKeyChar();
                    }
                    for(int i=0;i<8;i++){
                        distanceP = (int)Math.sqrt((Math.pow(Math.abs(x1-x[i]),2))+(Math.pow(Math.abs(y1-y[i]),2)));
                        if(distanceP<100){
                            score-=50;
                        }
                    }
                    repaint();
                }

                @Override
                public void keyReleased(KeyEvent e) {

                }
            });
            //=================
            time.start();
            t.start();
            //=================
        }
        class Listener implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e) {
                repaint();
            }
        }

        public void paintComponent(Graphics g){
            super.paintComponents(g);
            if((x1>=0 && x1<=1500)&&(y1>=0 && y1<=600)){
                //state 1
                g.drawImage(bg, 0, 0, 1500, 600, this);
                g.drawImage(image, x1, y1, 100, 100, this); //car

                g.drawImage(image2, x[0], y[0], 50, 50, this);
                g.drawImage(image3, x[1], y[1], 50, 50, this);
                g.drawImage(image4, x[2], y[2], 50, 50, this);
                g.drawImage(image5, x[3], y[3], 50, 50, this);
                g.drawImage(image6, x[4], y[4], 50, 50, this);
                g.drawImage(image7, x[5], y[5], 50, 50, this);
                g.drawImage(image8, x[6], y[6], 50, 50, this);
                g.drawImage(image9, x[7], y[7], 50, 50, this);

                g.setColor(Color.white);
                g.setFont(new Font("2005_iannnnnTKO", Font.CENTER_BASELINE, 45));
                g.drawString("HP : " + score, 50, 50);
                g.drawString("Time " + times, 400, 50);
                if(times!=0 && score!=0){
                    if(x1>=1300 &&x1<=1500){
                        g.drawImage(bg1, 0, 0, 1500, 600, this);
                        g.setFont(new Font("Storm Gust", Font.CENTER_BASELINE, 149));
                        g.setColor(new Color(0, 0, 54));
                        g.drawString("You Win !!", 650, 350);
                        g.setColor(new Color(73, 103, 215));
                        g.drawString("You Win !!", 660, 350);

                    }else{
                        repaint();
                    }
                } else {
                    g.drawImage(bg1, 0, 0, 1500, 600, this);
                    g.setFont(new Font("Storm Gust", Font.CENTER_BASELINE, 149));
                    g.setColor(Color.red);
                    g.drawString("YOU LOSE !!", 640, 300);
                    g.setColor(Color.black);
                    g.drawString("YOU LOSE !!", 650, 300);
                    timestart =true;
                }
            } else{
                this.setLayout(null);
                g.drawImage(bg1,0,0,1500,600,this);
                g.setFont(new Font("Storm Gust",Font.CENTER_BASELINE,149));
                g.setColor(Color.red);
                g.drawString("GAME OVER",640,300);
                g.setColor(Color.black);
                g.drawString("GAME OVER",650,300);
                g.setFont(new Font("TH Sarabun New",Font.BOLD,90));
                g.setColor(Color.red);
                g.drawString("โปรดระวังตกถนน",750,400);
            }
        }
    }
}