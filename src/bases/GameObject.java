package bases;

import bases.physics.BoxCollider;
import touhou.enemies.Enemy;
import touhou.players.Player;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Vector;

/**
 * Created by duyanh on 10/18/17.
 */
public class GameObject {
//    public float x;
//    public float y;
    public Vector2D position;
    public BufferedImage image;
    public boolean isActive;

    static Vector<GameObject> gameObjects = new Vector<>();
    static Vector<GameObject> newGameObjects = new Vector<>();

    public static void runAll(){
        for(GameObject gameObject : gameObjects){
            if(gameObject.isActive){
                gameObject.run();
            }

        }

        gameObjects.addAll(newGameObjects);
        newGameObjects.clear();
    }

    public static void renderAll(Graphics g){
        for(GameObject gameObject : gameObjects){
            if(gameObject.isActive){
                gameObject.render(g);
            }
        }
    }

    public static void add(GameObject gameObject){
        newGameObjects.add(gameObject);
    }

    public static Enemy collideWithE(BoxCollider boxCollider){
        for(GameObject gameObject : gameObjects){
            //instanceof để check
            if(gameObject.isActive && gameObject instanceof Enemy){
                Enemy enemy = (Enemy) gameObject;

                if(enemy.boxCollider.collideWith(boxCollider)){

                    return enemy;
                }
            }
        }

        return null;
    }

    public static Player collideWithP(BoxCollider boxCollider){
        for(GameObject gameObject: gameObjects){
            if(gameObject.isActive && gameObject instanceof Player){
                Player player = (Player) gameObject;

                if(player.boxCollider.collideWith(boxCollider)){

                    return player;
                }
            }
        }

        return null;
    }


    public GameObject(){
        position = new Vector2D();
        isActive = true;
    }

    public void run(){


    }

    public void render(Graphics g){
        if(image != null){
            g.drawImage(
                    image,
                    (int) (position.x - image.getWidth() / 2),
                    (int) (position.y - image.getHeight() / 2),
                    null);
        }
    }
}
