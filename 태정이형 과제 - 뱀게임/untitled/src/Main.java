import java.awt.*;
import java.awt.event.*;

/**
 * Created by dl579 on 2017-05-15.
 */
class XY
{
    int[] x  = new int[5];
    int [] y = new int [5];
    XY()
    {
        y[0] = 500;
        x[0] = 500;
        for(int i=1;i<5;i++)
        {
            x[i] =  500;
            y[i] = y[i-1]+50;
        }
    }
}
public class Main
{
    int Circlenum=3;
    int Right=0,Left=0;
    private Frame fr;
    private Canvas cv;
    int on_x=0,on_y=0;
   XY Circle_Info = new XY();
   public Main(String str)
    {

      Initalize(str);
    }
    public static void delay(int temp)
    {
        try { Thread.sleep(temp); } catch (Exception e) { System.out.println("딜레이 함수 오류\n원인:"+e); }
    }
    public static void main(String[] args)
    {
        Main FirstFrame = new Main("god King SangHoon");

    }
    public void Initalize(String str)
    {
        fr = new Frame("str");

        cv = new Canvas()
        {
            private final static long serialVersionUID = 1L;
            public void paint(Graphics g)
            {
                g.setColor(Color.RED);
                for(int i=0;i<Circlenum;i++) {

                    g.drawOval(Circle_Info.x[i], Circle_Info.y[i], 50, 50);

                }
                if(Circle_Info.x[0]<Circle_Info.x[Circlenum-1])
                {
                    for(int i=0;i<Circlenum;i++)
                        Circle_Info.x[i]+=10;
                }
                   else if(Circle_Info.y[0]<Circle_Info.y[Circlenum-1])
                {
                    for(int i=0;i<Circlenum;i++)
                        Circle_Info.y[i] -=10;
                }
            }

        };
        fr.addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        fr.add(cv,BorderLayout.CENTER);
        fr.setSize(1000,1000);
        while(true)
        {
            fr.addKeyListener(new KeyListener() {
                public void keyTyped(KeyEvent e) {
                }
                public void keyPressed(KeyEvent e) {
                    if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
                        if(Right==0) {
                            for (int i = Circlenum - 1; i >= 0; i--)
                                Circle_Info.x[i] = Circle_Info.y[i];
                            for (int i = 0; i < Circlenum; i++)
                                Circle_Info.y[i + 1] = Circle_Info.y[i];
                            cv.repaint();
                            Right++;
                        }
                    }
                    else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                        if(Left==0) {
                            Left++;
                            Right--;
                        }
                    }
                }

                public void keyReleased(KeyEvent e) {
                }
            });
        cv.repaint();
        delay(300);
            fr.setVisible(true);}
    }
}
//자동 움직임 발생 아무런 조건없이 움직임을 주고 싶다면  paint를 만들어주는 메소드 안에서
// 끝에 while(1)만들어 주고 setvisible(true)와 repaint를 적어줄것