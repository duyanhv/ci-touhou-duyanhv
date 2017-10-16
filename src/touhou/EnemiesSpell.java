package touhou;

import bases.Utils;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by duyanh on 10/16/17.
 */
public class EnemiesSpell {
    BufferedImage image;
    public int x;
    public int y;
    final int SPEED = 8;


    public EnemiesSpell(){
        image = Utils.loadImage("assets/images/enemies/bullets/blue.png");


    }

    public void render(Graphics g){
        g.drawImage(image,x,y,null);

    }

    public void run(){
        int vy = 0;

        vy += SPEED;

        y += vy;
    }
}
