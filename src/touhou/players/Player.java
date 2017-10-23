package touhou.players;

import bases.GameObject;
import bases.Utils;
import bases.Vector2D;
import bases.physics.BoxCollider;
import touhou.enemies.Enemy;

import java.awt.event.KeyEvent;

import static java.awt.event.KeyEvent.VK_X;

/**
 * Created by duyanh on 10/14/17.
 */
public class Player extends GameObject{
//    BufferedImage image;
//    Utils utils = new Utils();
//    Enemy enemy = new Enemy();
      public BoxCollider boxCollider;
//    public int x =  182;
//    public int y = 500;

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

    boolean spellDisabled;
    final int COOL_DOWN_TIME = 10;
    int coolDownCount;

    public Player(){
//        x = 182;
//        y = 500;
        boxCollider = new BoxCollider(32,48);
        position.set(182,500);
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

        boxCollider.position.set(this.position);

    }

    public void getHit(){
        isActive = false;
    }

    Vector2D velocity = new Vector2D();

    private void move() {

        /**
         * A' = A + v
         * (x',y') = (x,y) + (vx,vy)
         * x' = x+vx
         * y' = y+vy
         */

        velocity.set(0,0);



        if(rightPressed){
            velocity.x += SPEED;
        }





        if(leftPressed){
            velocity.x -= SPEED;
        }






        if(upPressed){
            velocity.y -= SPEED;
        }



        if(downPressed){
            velocity.y += SPEED;
        }


        position.addUp(velocity);


        position.x = (int) Utils.clamp(position.x,LEFT,RIGHT);
        position.y = (int) Utils.clamp(position.y,TOP,BOTTOM);
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
                newSpell.position.set(position.x, position.y - 14);
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
