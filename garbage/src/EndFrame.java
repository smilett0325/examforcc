import javax.swing.*;
import java.awt.*;

public class EndFrame extends JFrame {
    private Container cp ;
    private JPanel jpn = new JPanel();
    private Image img = Toolkit.getDefaultToolkit().getImage("end.jpg");

    public EndFrame(){
        init();
    }

    private void init(){
        cp=this.getContentPane();
        cp.setLayout(new BorderLayout(1,1));
        jpn=new JPanel(){
            public void paintComponent(Graphics g){
                super.paintComponent(g);
                g.drawImage(img,0,0,null);
                this.repaint();
            }
        };

        jpn.setLayout(null);
        cp.add(jpn,BorderLayout.CENTER);
        pack();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setBounds(0,0,1200,700);
        this.setResizable(false);

    }
}
