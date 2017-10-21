package touhou.enemies;

import bases.GameObject;
import bases.Utils;
import bases.physics.BoxCollider;

import javax.swing.*;
import java.util.Random;

/**
 * Created by duyanh on 10/16/17.
 */
public class Enemy extends GameObject{

    public BoxCollider boxCollider;
//    BufferedImage image;
    long lastTurn = System.currentTimeMillis();

    final int SPEED = 1 ;


    boolean spellDisabled;
    final int COOL_DOWN_TIME = 30;
    int coolDownCount;



    public Enemy(){
        boxCollider = new BoxCollider(30,30);

        image = Utils.loadImage("assets/images/enemies/level0/black/0.png");
        spellDisabled = false;
    }



    public void run(){
        move();
        shoot();

        boxCollider.position.set(this.position);

    }

    private void shoot() {
        if(spellDisabled){
            coolDownCount++;
            if(coolDownCount >= COOL_DOWN_TIME){
                spellDisabled = false;
                coolDownCount = 0;

            }
            return;
        }

        if(coolDownCount < 1){
            EnemiesSpell enemiesSpell = new EnemiesSpell();
//            enemiesSpell.x = x + 5;
//
//            enemiesSpell.y = y + 50;
            enemiesSpell.position.set(position.x, position.y);
            GameObject.add(enemiesSpell);
            spellDisabled = true;
        }
    }

    private void move() {
        position.addUp(0, SPEED);
    }


    public void getHit(){
        isActive = false;
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
