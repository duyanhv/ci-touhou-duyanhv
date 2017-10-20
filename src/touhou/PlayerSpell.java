package touhou;

import bases.GameObject;
import bases.Utils;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

/**
 * Created by duyanh on 10/14/17.
 */
public class PlayerSpell extends GameObject{
//    BufferedImage image;
    Player player = new Player();
    Utils utils = new Utils();
//
//    public int x;
//    public int y;

    final int SPEED = 10;

    final int LEFT = 0;
    final int RIGHT = 384;
    final int TOP = 0;
    final int BOTTOM = 530;

    boolean spacePressed;


    public PlayerSpell(){
        image = Utils.loadImage("assets/images/player-bullets/a/0.png");
    }

//    public void render(Graphics graphics){
//
//        graphics.drawImage(image,x,y, null);
//    }

//    public void KeyPressed(KeyEvent e){
//        if(e.getKeyCode() == KeyEvent.VK_SPACE){
//            spacePressed = false;
//
//        }
//    }
//
//    public void KeyReleased(KeyEvent e ){
//        if(e.getKeyCode() == KeyEvent.VK_SPACE){
//            spacePressed = true;
//        }
//    }

    public void run(){
        int vy = 0;


        vy -= SPEED;


        y += vy;


    }


}
