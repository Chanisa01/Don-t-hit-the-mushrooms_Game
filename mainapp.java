import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class mainapp extends JFrame implements ActionListener {
    page1 homegame = new page1();
    public mainapp(){
        this.setSize(1500,635);
        this.add(homegame);
        homegame.BExit1.addActionListener(this);
        homegame.BStart.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== homegame.BStart){
            this.setLocationRelativeTo(null);
            this.remove(homegame);
            JFrame frame = new Startgames();
            frame.setSize(1500, 635);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        }else if(e.getSource() == homegame.BExit1){
            System.exit(0);
        }
    }

    public static void main(String[] args)
    {
        JFrame frame = new mainapp();
        frame.setSize(1500,635);
        frame.setTitle("Don't hit the mushrooms");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}
