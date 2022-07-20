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
import javax.swing.Timer;

import org.w3c.dom.DOMImplementationSource;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.imageio.*;
import java.awt.image.*;
import java.io.*;

public class Board extends JPanel implements Runnable, MouseListener
{
    boolean ingame = true;
    private Dimension d;
    int BOARD_WIDTH=500;
    int BOARD_HEIGHT=500;
    int x = 0;
    BufferedImage img;
    String message = "Click Board to Start";
    private Thread animator;
    Charater p;

    public Board()
    {
        addKeyListener(new TAdapter());
        addMouseListener(this);
        setFocusable(true);
        d = new Dimension(BOARD_WIDTH, BOARD_HEIGHT);
        p = new Player( BOARD_WIDTH/2, BOARD_HEIGHT-60, 5 );

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

        if(p.moveLeft == true)
            p.x -= p.speed;

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
    int animationDelay = 500;
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


