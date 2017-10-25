package touhou.enemies;

import bases.GameObject;
import bases.Utils;
import bases.physics.BoxCollider;
import bases.physics.PhysicsBody;
import touhou.players.Player;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by duyanh on 10/16/17.
 */
public class EnemiesSpell extends GameObject implements PhysicsBody {
//    BufferedImage image;
//    public int x;
//    public int y;
    final int SPEED = 4;
    BoxCollider boxCollider;
    PlayerDamage playerDamage;
    Enemy enemy;


    public EnemiesSpell(){
        boxCollider = new BoxCollider(16,16);
        image = Utils.loadImage("assets/images/enemies/bullets/blue.png");

        playerDamage = new PlayerDamage();
        enemy = new Enemy();
    }

//    public void render(Graphics g){
//        g.drawImage(image,x,y,null);
//
//    }

    public void run(){


        this.position.addUp(0, SPEED);
        boxCollider.position.set(this.position);
        this.playerDamage.run(this);
//        Player player = GameObject.collideWith(this.boxCollider,Player.class);
//
//
//        if(player != null){
//            player.getHit();
//            this.isActive = false;
//        }
    }

    @Override
    public BoxCollider getBoxCollider() {
        return boxCollider;
    }
}
