import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

public class BossFrame1 extends JFrame {
    private Container cp ;
    private JPanel jpn1 =new JPanel(new GridLayout());
    private JButton jbtstart = new JButton("開始挑戰");
    private JPanel jpn2 =new JPanel(new BorderLayout());
    private ImageIcon icon1 = new ImageIcon("boss2.png");
    private ImageIcon icon2 = new ImageIcon("boom.png");
    private JLabel jlb1 = new JLabel();
    private Random rand =new Random();
    private Timer t1,t2,t3 ;
    private int labX ,labY ;
    private JPanel jpn4 =new JPanel(new BorderLayout());
    private JPanel jpn3 = new JPanel(new GridLayout(1,5,3,3));
    private JLabel jlbt1 = new JLabel("0");
    private JLabel jlbt2 = new JLabel("1");
    private JLabel jlbt3 = new JLabel(":");
    private JLabel jlbt4 = new JLabel("0");
    private JLabel jlbt5 = new JLabel("0");
    private JLabel jlbs =new JLabel("0");

    private int z=0,x=60 ,c =0 ;

    public BossFrame1(){
        init();
    }

    private void init(){
        CustomCursor();
        cp=this.getContentPane();
        cp.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setBounds(0,0,1000,600);

        labX = rand.nextInt(BossFrame1.this.getWidth());
        labY = rand.nextInt(BossFrame1.this.getHeight());
        jlb1.setBounds(labX,labY,120,120);

        Image img1 = icon1.getImage();
        Image img2 =img1.getScaledInstance(120,120,Image.SCALE_SMOOTH);
        icon1 = new ImageIcon(img2);

        Image img3 = icon2.getImage();
        Image img4 =img3.getScaledInstance(120,120,Image.SCALE_SMOOTH);
        icon2 = new ImageIcon(img4);

        jlb1.setIcon(icon1);





        cp.add(jlb1);

        cp.add(jpn4,BorderLayout.NORTH);
        cp.add(jpn2,BorderLayout.CENTER);
        cp.add(jpn1,BorderLayout.SOUTH);

        jpn3.add(jlbt1);
        jpn3.add(jlbt2);
        jpn3.add(jlbt3);
        jpn3.add(jlbt4);
        jpn3.add(jlbt5);

        jpn4.add(jpn3,BorderLayout.WEST);
        jpn4.add(jlbs,BorderLayout.EAST);
        jpn1.add(jbtstart);

        t1=new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                x--;
                jlbt1.setText(Integer.toString(0));
                jlbt2.setText(Integer.toString(0));
                jlbt4.setText(Integer.toString(x / 10));
                jlbt5.setText(Integer.toString(x % 10));
            }
        });

        t2 =new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                labX =rand.nextInt(BossFrame1.this.getWidth()-120);
                labY =rand.nextInt(BossFrame1.this.getHeight()-120);
                jlb1.setLocation(labX,labY);
            }
        });

        t3 =new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jlb1.setIcon(icon1);

                t3.stop();
            }
        });





        jbtstart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                t1.start();
                t2.start();


                jlb1.addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        jlb1.setIcon(icon2);
                        c++;
                        t2.start();

                        t3.start();

                        jlbs.setText(Integer.toString(c));
                        if (c==10&&x>0){
                            JOptionPane.showMessageDialog(BossFrame1.this,"成功打敗邪惡暴君","勇氣精靈",JOptionPane.DEFAULT_OPTION);
                            EndFrame cf = new EndFrame();
                            cf.setVisible(true);
                            BossFrame1.this.setVisible(false);
                            BossFrame1.this.dispose();

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

                    }

                    @Override
                    public void mouseExited(MouseEvent e) {

                    }
                });
            }
        });








    }

    public void CustomCursor(){
        Toolkit tookit = Toolkit.getDefaultToolkit();
        Image img =tookit.getImage("weapon2.png");
        Point point = new Point(0,0);
        Cursor cursor = tookit.createCustomCursor(img,point,"Cursor");

        setCursor(cursor);
    }


}