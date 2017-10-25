package touhou.players;

import bases.GameObject;
import bases.Utils;
import bases.Vector2D;
import bases.physics.BoxCollider;
import bases.physics.PhysicsBody;
import touhou.enemies.Enemy;
import touhou.inputs.InputManager;

import java.awt.event.KeyEvent;

import static java.awt.event.KeyEvent.VK_X;

/**
 * Created by duyanh on 10/14/17.
 */
public class Player extends GameObject implements PhysicsBody{
//    BufferedImage image;
//    Utils utils = new Utils();
//    Enemy enemy = new Enemy();
      public BoxCollider boxCollider;

      PlayerCastSpell playerCastSpell;
//    public int x =  182;
//    public int y = 500;

//    boolean rightPressed;
//    boolean leftPressed;
//    boolean upPressed;
//    boolean downPressed;
//    boolean xPressed;

    final int SPEED = 5;

    final int LEFT = 0;
    final int RIGHT = 376;
    final int TOP = 0;
    final int BOTTOM = 530;



    public Player(){
//        x = 182;
//        y = 500;
        boxCollider = new BoxCollider(8,8);
        position.set(182,500);
        image = Utils.loadImage("assets/images/players/straight/0.png");

        playerCastSpell = new PlayerCastSpell();
    }

//    public void render(Graphics graphics){
//        graphics.drawImage(image, x,y,null);
//
//    }

//    public void keyPressed(KeyEvent e) {
//
//        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
//            rightPressed = true;
//
//        }
//
//        if(e.getKeyCode() == KeyEvent.VK_LEFT){
//            leftPressed = true;
//
//
//        }
//
//        if(e.getKeyCode() == KeyEvent.VK_UP){
//            upPressed = true;
//
//        }
//
//        if(e.getKeyCode() == KeyEvent.VK_DOWN){
//            downPressed = true;
//        }
//
//        if(e.getKeyCode() == VK_X){ //KeyEvent.VK_X
//            xPressed = true;
//        }
//
//    }
//
//
//    public void keyReleased(KeyEvent e) {
//        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
//            rightPressed = false;
//
//        }
//
//        if(e.getKeyCode() == KeyEvent.VK_LEFT){
//            leftPressed = false;
//
//
//        }
//
//        if(e.getKeyCode() == KeyEvent.VK_UP){
//            upPressed = false;
//
//        }
//
//        if(e.getKeyCode() == KeyEvent.VK_DOWN){
//            downPressed = false;
//        }
//
//        if(e.getKeyCode() == VK_X){
//            xPressed = false;
//        }
//    }


    public void run(){

        move();
//        shoot();
        playerCastSpell.run(this);

        //cho boxCollider bám theo Player
        boxCollider.position.set(this.position);

    }

    public void getHit(){
        isActive = false;
//        System.out.println("Player get hit");
    }

    Vector2D velocity = new Vector2D();

    private void move() {

        /**
         * A' = A + v
         * (x',y') = (x,y) + (vx,vy)
         * x' = x+vx
         * y' = y+vy
         */
        InputManager inputManager =  InputManager.instance;
        velocity.set(0,0);



        if(inputManager.rightPressed){
            velocity.x += SPEED;
        }





        if(inputManager.leftPressed){
            velocity.x -= SPEED;
        }






        if(inputManager.upPressed){
            velocity.y -= SPEED;
        }



        if(inputManager.downPressed){
            velocity.y += SPEED;
        }


        position.addUp(velocity);


        position.x = (int) Utils.clamp(position.x,LEFT,RIGHT);
        position.y = (int) Utils.clamp(position.y,TOP,BOTTOM);
    }


//    public void shoot(){
//        if(spellDisabled){
//            coolDownCount++;
//            if(coolDownCount >= COOL_DOWN_TIME){
//                spellDisabled = false;
//                coolDownCount = 0;
//            }
//            return;
//        }
//        if(xPressed){
//
//
//            PlayerSpell newSpell = new PlayerSpell();
//                newSpell.position.set(position.x, position.y - 14);
//                GameObject.add(newSpell);
//
//                spellDisabled = true;
//
////            try {
////                Thread.sleep(17);
////
////                PlayerSpell newSpell = new PlayerSpell();
////                newSpell.x = x;
////                newSpell.y = y;
////                spells.add(newSpell);
////                xPressed = false;
////
////            } catch (InterruptedException e) {
////                e.printStackTrace();
////            }
//
//
//        }
//    }


    @Override
    public BoxCollider getBoxCollider() {
        return boxCollider;
    }
}
