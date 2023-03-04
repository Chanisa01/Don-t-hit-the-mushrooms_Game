import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
public class page1 extends JPanel {
    private ImageIcon feild = new ImageIcon(this.getClass().getResource("image/bgstart.png"));
    private ImageIcon exit = new ImageIcon(this.getClass().getResource("image/exit.jpg"));
    private ImageIcon starts = new ImageIcon(this.getClass().getResource("image/Start.jpg"));
    public JButton BStart = new JButton(starts);
    public JButton BExit1  = new JButton(exit);
    page1(){
        setLayout(null);
        add(BExit1);
        add(BStart);
        BStart.setBounds(750,450,150,90);
        BExit1.setBounds(1050, 450, 150,90);
        add(BStart);
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(feild.getImage(),0,0,this.getWidth(),this.getHeight(),this);
        g.setFont(new Font("Storm Gust",Font.CENTER_BASELINE,149));

        g.setColor(new Color(0,0,54));
        g.drawString("Don't hit",650,250);
        g.drawString("the mushrooms",500,400);

        g.setColor(new Color(73,103,215));
        g.drawString("Don't hit",660,250);
        g.drawString("the mushrooms",510,400);
    }
}
