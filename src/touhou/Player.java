package touhou;

import bases.GameObject;
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
public class Player extends GameObject{
//    BufferedImage image;
    Utils utils = new Utils();
    Enemies enemies = new Enemies();

//    public int x =  182;
//    public int y = 500;

    boolean rightPressed;
    boolean leftPressed;
    boolean upPressed;
    boolean downPressed;
    boolean xPressed;

    final int SPEED = 5;

    final int LEFT = 0;
    final int RIGHT = 360;
    final int TOP = 0;
    final int BOTTOM = 530;

    boolean spellDisabled;
    final int COOL_DOWN_TIME = 10;
    int coolDownCount;

    public Player(){
        x = 182;
        y = 500;
        image = Utils.loadImage("assets/images/players/straight/0.png");

        spellDisabled = false;
    }

//    public void render(Graphics graphics){
//        graphics.drawImage(image, x,y,null);
//
//    }

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

        move();
        shoot();



    }

    private void move() {

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


    public void shoot(){
        if(spellDisabled){
            coolDownCount++;
            if(coolDownCount >= COOL_DOWN_TIME){
                spellDisabled = false;
                coolDownCount = 0;
            }
            return;
        }
        if(xPressed){


            PlayerSpell newSpell = new PlayerSpell();
                newSpell.x = x;
                newSpell.y = y;
                GameObject.add(newSpell);

                spellDisabled = true;

//            try {
//                Thread.sleep(17);
//
//                PlayerSpell newSpell = new PlayerSpell();
//                newSpell.x = x;
//                newSpell.y = y;
//                spells.add(newSpell);
//                xPressed = false;
//
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }


        }
    }




}
