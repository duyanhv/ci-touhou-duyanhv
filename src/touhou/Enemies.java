package touhou;

import bases.Utils;

import javax.rmi.CORBA.Util;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * Created by duyanh on 10/16/17.
 */
public class Enemies {
    BufferedImage image;

    final int SPEED = 5 ;
    int x = 100;
    int y = 0;

    final int LEFT = 0;
    final int RIGHT = 360;
    final int TOP = 0;
    final int BOTTOM = 200;



    public Enemies(){
        image = Utils.loadImage("assets/images/players/straight/0.png");
    }

    public void run(){
        int vx = 0;
        int vy = 0;

        x = (int) Utils.clamp(x,LEFT,RIGHT);
        y = (int) Utils.clamp(y,TOP,BOTTOM);

        if(y < BOTTOM){
           vy += SPEED;
       }

       if(y == BOTTOM){
            vx -= SPEED;

       }




       x += vx;
       y += vy;



    }

    public void render(Graphics g){
        g.drawImage(image,x,y, null);
    }

    public void shoot(ArrayList<EnemiesSpell> enemSpells){
        try {
            Thread.sleep(17);

            EnemiesSpell enemiesSpell = new EnemiesSpell();
            enemiesSpell.x = x;
            enemiesSpell.y = y;
            enemSpells.add(enemiesSpell);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
