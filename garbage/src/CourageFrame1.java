import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.*;
import java.net.*;
import java.io.*;
import java.awt.event.*;
public class CourageFrame1 extends JFrame implements KeyListener{
    private Container cp;
    private JLabel jlbs[][]=new JLabel[15][15];
    private byte map[][]=
                    {{5,5,5,5,5,5,5,5,5,5,5,5,5,3,5},
                    {5,5,5,5,5,5,5,5,5,5,5,5,5,0,5},
                    {5,5,5,5,5,5,5,5,5,5,5,5,0,0,0},
                    {5,5,5,5,5,5,5,5,5,5,5,5,0,0,0},
                    {5,5,5,5,5,5,5,5,5,5,5,5,0,0,0},
                    {5,5,5,5,5,5,5,5,5,5,5,5,5,0,5},
                    {5,5,5,5,5,5,5,5,5,5,5,5,5,0,5},
                    {5,5,5,5,5,5,5,5,5,5,5,5,5,0,5},
                    {5,5,5,5,5,5,5,5,5,5,5,5,5,0,5},
                    {5,5,5,5,5,5,5,5,5,5,5,5,5,0,5},
                    {5,5,5,5,5,5,5,5,5,5,5,5,5,0,5},
                    {5,5,5,5,5,5,5,5,5,5,5,5,5,0,5},
                    {5,5,5,5,5,5,5,5,5,5,5,5,5,0,5},
                    {5,5,5,5,5,5,5,5,5,5,5,5,5,0,5},
                    {5,5,5,5,5,5,5,5,5,5,5,5,5,0,5}};
    private ImageIcon icon[]=new ImageIcon[6];
    int x=12,y=14,count=0;


    public CourageFrame1(){
        init();
    }


    public void init(){
        cp=this.getContentPane();
        cp.setLayout(new GridLayout(15,15,0,0));

        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(true);

        this.setTitle("勇氣神殿");
        this.setBounds(0,0,1200,700);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        icon[0]=new ImageIcon("road2.jpg");
        icon[1]=new ImageIcon("sroad.jpg");
        icon[2]=new ImageIcon("tt2.png");
        icon[3]=new ImageIcon("boss2.png");
        icon[4]=new ImageIcon("boss2.png");
        icon[5]=new ImageIcon("sroad.png");

        Image img=icon[0].getImage();
        Image newimg=img.getScaledInstance(107,107,java.awt.Image.SCALE_SMOOTH);
        icon[0]=new ImageIcon(newimg);

        img=icon[1].getImage();
        Image newimg0=img.getScaledInstance(107,107,java.awt.Image.SCALE_SMOOTH);
        icon[1]=new ImageIcon(newimg0);

        img=icon[2].getImage();
        Image newimg1=img.getScaledInstance(107,107,java.awt.Image.SCALE_SMOOTH);
        icon[2]=new ImageIcon(newimg1);

        Image img7 = icon[3].getImage();
        Image img8=img7.getScaledInstance(85,50,Image.SCALE_SMOOTH);
        icon[3].setImage(img8);




        // int i=0,j=0;

        // ¥[¹Ï¤ù GRASS STONE MICE
        for(int i=0;i<15;i++){
            for(int j=0;j<15;j++){
                jlbs[i][j]=new JLabel();
                if (map[i][j]==0){
                    jlbs[i][j].setIcon(icon[0]);
                }else if (map[i][j]==3){
                    jlbs[i][j].setIcon(icon[3]);
                }
                else {
                    jlbs[i][j].setIcon(icon[1]);
                }

                cp.add(jlbs[i][j]);
            }
        }
        jlbs[14][12].setIcon(icon[2]);




    }
    // ¤W¤U¥ª¥k
    // ÅÜ¼Æ¬°x,y,count
    public void keyPressed(KeyEvent ke){
        System.out.println(ke.getKeyCode());
        switch (ke.getKeyCode()) {
            //Left
            case 37:
                if (x-1>=0){
                    if(map[y][x-1]==0){
                        jlbs[y][x].setIcon(icon[0]);
                        x--;
                        jlbs[y][x].setIcon(icon[2]);


                    }
                }
                break;
            //Up
            case 38:
                if (y-1>=0){
                    if(map[y-1][x]==0){
                        jlbs[y][x].setIcon(icon[0]);
                        y--;
                        jlbs[y][x].setIcon(icon[2]);

                    }
                }
                break;
            //Right
            case 39:
                if (x+1<=15){
                    if(map[y][x+1]==0){
                        jlbs[y][x].setIcon(icon[0]);
                        x++;
                        jlbs[y][x].setIcon(icon[2]);

                    }
                }
                break;
            //Down
            case 40:
                if (y+1<15){
                    if(map[y+1][x]==0){
                        jlbs[y][x].setIcon(icon[0]);
                        y++;
                        jlbs[y][x].setIcon(icon[2]);

                    }
                }
                break;
        }

        if (x==13&&y==1){
            JOptionPane.showMessageDialog(CourageFrame1.this,"憑你也想挑戰我邪惡暴君!!!","邪惡暴君",JOptionPane.DEFAULT_OPTION);
            JOptionPane.showMessageDialog(CourageFrame1.this,"在限時內得到10分!!!","邪惡暴君",JOptionPane.DEFAULT_OPTION);
            BossFrame1 bs = new BossFrame1();
            bs.setVisible(true);
            CourageFrame1.this.setVisible(false);
            CourageFrame1.this.dispose();
        }


    }
    public void keyReleased(KeyEvent ke){
        System.out.println(ke.getKeyCode());
    }
    public void keyTyped(KeyEvent ke){
        System.out.println(ke.getKeyCode());
    }
}