package touhou;

import bases.Utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

import static java.awt.event.KeyEvent.VK_X;

/**
 * Created by duyanh on 10/14/17.
 */
public class Player {
    BufferedImage image;
    Utils utils = new Utils();

    public int x =  182;
    public int y = 500;

    boolean rightPressed;
    boolean leftPressed;
    boolean upPressed;
    boolean downPressed;
    boolean xPressed;

    final int SPEED = 5;

    final int LEFT = 0;
    final int RIGHT = 384;
    final int TOP = 0;
    final int BOTTOM = 530;

    public Player(){
        image = Utils.loadImage("assets/images/players/straight/0.png");

    }

    public void render(Graphics graphics){
        graphics.drawImage(image, x,y,null);

    }

    public void keyPressed(KeyEvent e) {

        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            rightPressed = true;

        }

        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            leftPressed = true;


        }

        if(e.getKeyCode() == KeyEvent.VK_UP){
            upPressed = true;

        }

        if(e.getKeyCode() == KeyEvent.VK_DOWN){
            downPressed = true;
        }

        if(e.getKeyCode() == VK_X){ //KeyEvent.VK_X
            xPressed = true;
        }

    }


    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            rightPressed = false;

        }

        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            leftPressed = false;


        }

        if(e.getKeyCode() == KeyEvent.VK_UP){
            upPressed = false;

        }

        if(e.getKeyCode() == KeyEvent.VK_DOWN){
            downPressed = false;
        }

        if(e.getKeyCode() == VK_X){
            xPressed = false;
        }
    }


    public void run(){

        /**
         * A' = A + v
         * (x',y') = (x,y) + (vx,vy)
         * x' = x+vx
         * y' = y+vy
         */
        int vx = 0;
        int vy = 0;



        if(rightPressed){
            vx += SPEED;
        }





        if(leftPressed){
            vx -= SPEED;
        }






        if(upPressed){
            vy -= SPEED;
        }



        if(downPressed){
            vy += SPEED;
        }


        x += vx;
        y += vy;


        x = (int) Utils.clamp(x,LEFT,RIGHT);
        y = (int) Utils.clamp(y,TOP,BOTTOM);
    }

    public void shoot(ArrayList<PlayerSpell> spells){
        if(xPressed){
            PlayerSpell newSpell = new PlayerSpell();
            newSpell.x = x;
            newSpell.y = y;
            spells.add(newSpell);
        }
    }




}
