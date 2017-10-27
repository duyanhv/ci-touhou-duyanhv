package touhou.enemies;

import bases.GameObject;
import bases.Utils;
import bases.Vector2D;
import bases.physics.BoxCollider;
import bases.physics.PhysicsBody;
import touhou.players.Player;

import javax.swing.*;
import java.util.Random;

/**
 * Created by duyanh on 10/16/17.
 */
public class Enemy extends GameObject implements PhysicsBody{

    public BoxCollider boxCollider;
    EnemyCastSpell enemyCastSpell;
//    PlayerDamage playerDamage;
//    BufferedImage image;
    Vector2D velocity;
    Player player;
    long lastTurn = System.currentTimeMillis();

    final int SPEED = 1 ;







    public Enemy(){
        boxCollider = new BoxCollider(30,30);

        image = Utils.loadImage("assets/images/enemies/level0/black/0.png");

        enemyCastSpell = new EnemyCastSpell();

        player = new Player();
//        this.playerDamage = new PlayerDamage();
        velocity = new Vector2D();
        velocity.set(0,0);
    }



    public void run(){
        move();
//        shoot();
        enemyCastSpell.run(this);
        boxCollider.position.set(this.position);
//        this.playerDamage.run(this);

    }



//    private void shoot() {
//        if(spellDisabled){
//            coolDownCount++;
//            if(coolDownCount >= COOL_DOWN_TIME){
//                spellDisabled = false;
//                coolDownCount = 0;
//
//            }
//            return;
//        }
//
//        if(coolDownCount < 1){
//            EnemiesSpell enemiesSpell = new EnemiesSpell();
////            enemiesSpell.x = x + 5;
////
////            enemiesSpell.y = y + 50;
//            enemiesSpell.position.set(position.x, position.y);
//            GameObject.add(enemiesSpell);
//            spellDisabled = true;
//        }
//    }

    private void move() {




//        this.position.addUp(player.position.x - this.position.x * SPEED / (player.position.length() - this.position.length())  ,
//          player.position.y - this.position.y * this.position.x * SPEED / (player.position.length() - this.position.length()));
//          velocity = player.position.subtract(this.position);
//        velocity.normalize();
////        velocity.print();
//        velocity.mutiply(SPEED);
//        this.position.addUp(velocity);

        if(player.position.x > this.position.x){
            this.position.x ++;
        }else{
            this.position.x --;
        }

        if(player.position.y > this.position.y){
            this.position.y ++;
        }else{
            this.position.y --;
        }


    }


    public void getHit(){
        isActive = false;
    }

    @Override
    public BoxCollider getBoxCollider() {
        return boxCollider;
    }

//    public void render(Graphics g){
//        g.drawImage(image,x,y, null);
//    }

 //   public void shoot(ArrayList<EnemiesSpell> enemSpells){
//        try {
//            Thread.sleep(17);
//
//            EnemiesSpell enemiesSpell = new EnemiesSpell();
//            enemiesSpell.x = x;
//            enemiesSpell.y = y;
//            enemSpells.add(enemiesSpell);
//
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }


