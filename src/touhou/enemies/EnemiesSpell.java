package touhou.enemies;

import bases.GameObject;
import bases.Utils;
import bases.physics.BoxCollider;
import touhou.players.Player;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by duyanh on 10/16/17.
 */
public class EnemiesSpell extends GameObject{
//    BufferedImage image;
//    public int x;
//    public int y;
    final int SPEED = 8;
    BoxCollider boxCollider;


    public EnemiesSpell(){
        boxCollider = new BoxCollider(16,16);
        image = Utils.loadImage("assets/images/enemies/bullets/blue.png");


    }

//    public void render(Graphics g){
//        g.drawImage(image,x,y,null);
//
//    }

    public void run(){


        this.position.addUp(0, SPEED);
        boxCollider.position.set(this.position);

        Player player = GameObject.collideWithP(this.boxCollider);


        if(player != null){
            player.getHit();
            this.isActive = false;
        }
    }
}
