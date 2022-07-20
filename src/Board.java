import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
// import javax.swing.Timer;

// import org.w3c.dom.DOMImplementationSource;

// import java.util.ArrayList;
// import java.util.Iterator;
// import java.util.Random;

// import javax.swing.ImageIcon;
import javax.swing.JPanel;
// import javax.imageio.*;
import java.awt.image.*;
// import java.io.*;

public class Board extends JPanel implements Runnable, MouseListener
{
    boolean ingame = true;
    private Dimension d;
    int BOARD_WIDTH=550;
    int BOARD_HEIGHT=500;
    int x = 0;
    BufferedImage img;
    String message = "Click Board to Start";
    private Thread animator;
    Player p;
    Alien[] a = new Alien [10];

    public Board()
    {
        addKeyListener(new TAdapter());
        addMouseListener(this);
        setFocusable(true);
        d = new Dimension(BOARD_WIDTH, BOARD_HEIGHT);
        p = new Player( BOARD_WIDTH/2, BOARD_HEIGHT-60, 5 );

        int ax = 10;
        int ay = 10;
        
        for(int i=0; i<a.length; i++){
            a[i] = new Alien(ax,ay,10);
            //shifting the alien
            ax += 40; 
            if(i==4){
                ax=10;
                ay += 40;//down to the next row

            }
        }

        setBackground(Color.black);

        if (animator == null || !ingame) {
            animator = new Thread(this);
            animator.start();
        }

        setDoubleBuffered(true);
    }

    public void paint(Graphics g)
    {
        super.paint(g);

        g.setColor(Color.white);
        g.fillRect(0, 0, d.width, d.height);

        g.setColor(Color.red);
        g.fillRect(p.x, p.y, 20, 20);
        if(p.moveRight==true)
            p.x += p.speed;
        moveAlien();
        if(p.moveLeft == true)
            p.x -= p.speed;

        for(int i=0; i<a.length; i++){
            g.fillRect(a[i].x, a[i].y, 30, 30);

        }

        Font small = new Font("Helvetica", Font.BOLD, 14);
        FontMetrics metr = this.getFontMetrics(small);
        g.setColor(Color.black);
        g.setFont(small);
        g.drawString(message, 10, d.height-60);

        if (ingame) {

    }

    Toolkit.getDefaultToolkit().sync();
    g.dispose();
}

public void moveAlien(){
    for(int i=0; i<a.length; i++){
        if(a[i].moveLeft==true){
            a[i].x -= 1;
        }

        if(a[i].moveRight==true){
            a[i].x += 1;
        }
        
    for(int i=0; i<a.length; i++){
    if(a[i].x > BOARD_WIDTH){
        for(int j=0; j<a.length; j++){
            a[j].moveLeft=true;
            a[j].moveRight=false;
            a[j].y += 5;
        }
    }

    }

    if(a[i].x < 0){
        for(int j=0; j<a.length; j++){
            a[j].moveRight=true;
            a[j].moveLeft=false;
            a[j].y += 5;
        }

    } 
    //a[i].y += 2;

    }
}

private class TAdapter extends KeyAdapter {

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        p.moveRight = false;
        p.moveLeft = false;

    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if(key==39){
            p.moveRight=true;

        }   
        if(key==37){
            p.moveLeft=true;
        }

    }        

}



public void mousePressed(MouseEvent e) {
    int x = e.getX();
    int y = e.getY();

}

public void mouseRelease(MouseEvent e) {

}

public void mouseEntered(MouseEvent e) {

}

public void mouseExited(MouseEvent e) {

}

public void mouseClicked(MouseEvent e) {

}

public void run() {

    long beforeTime, timeDiff, sleep;

    beforeTime = System.currentTimeMillis();
    int animationDelay = 10;
    long time =
            System.currentTimeMillis();
    while (true) {
            repaint();
            try {
                time += animationDelay;
                Thread.sleep(Math.max(0,time - 
                    System.currentTimeMillis()));
            }catch (InterruptedException e) {
                System.out.println(e);
            }
        }
}


@Override
public void mouseReleased(MouseEvent e) {
    // TODO Auto-generated method stub
    
}
}


