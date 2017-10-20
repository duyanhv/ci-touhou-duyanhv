package touhou;

import bases.GameObject;
import bases.Utils;

import javax.rmi.CORBA.Util;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by duyanh on 10/16/17.
 */
public class Enemies extends GameObject{
//    BufferedImage image;
    long lastTurn = System.currentTimeMillis();

    final int SPEED = 5 ;


    final int LEFT = 0;
    final int RIGHT = 360;
    final int TOP = 0;
    final int BOTTOM = 200;
    boolean spellDisabled;
    final int COOL_DOWN_TIME = 10;
    int coolDownCount;



    public Enemies(){
        x = 150;
        y = 0;
        image = Utils.loadImage("assets/images/players/straight/0.png");
        spellDisabled = false;
    }



    public void run(){
        move();
        shoot();

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
            enemiesSpell.x = x + 5;
            enemiesSpell.y = y + 50;
            GameObject.add(enemiesSpell);
            spellDisabled = true;
        }
    }

    private void move() {
        Random rdm = new Random();
        float vx = 0;
        float vy = 0;


        if(vy < BOTTOM){
            vy += SPEED;

            if(vy == 300){
                vx += SPEED;
            }
        }




        x += vx;
        y += vy;
        x = (int) Utils.clamp(x,LEFT,RIGHT);
        y = (int) Utils.clamp(y,TOP,BOTTOM);


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

