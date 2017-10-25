package bases;

import bases.physics.BoxCollider;
import bases.physics.PhysicsBody;
import touhou.enemies.Enemy;
import touhou.players.Player;
import touhou.players.PlayerSpell;

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


    //Tìm trong tất cả các game object, nếu gặp 1 object thoả mãn 2 điều kiện:
    //1. Game object này là playerspell
    //2. isActive == false ( rác )
    // thì return object này
    // Nếu không tìm thấy
    // Tự khởi tạo 1 playerspell mới => return
    public static <T extends GameObject> T recycle(Class<T> cls){
        for(GameObject gameObject: gameObjects){
            if(gameObject.getClass().equals(cls)){
               if(!gameObject.isActive){
                   gameObject.isActive = true;
                   return (T) gameObject;
               }
            }
        }

        try {
            T newGameObject = cls.newInstance(); // = new
            add(newGameObject);
            return newGameObject;
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }

//        PlayerSpell playerSpell = new PlayerSpell();
//        GameObject.add(playerSpell);
//        return playerSpell;

    }

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

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public static void add(GameObject gameObject){
        newGameObjects.add(gameObject);
    }

//    public static Enemy collideWithE(BoxCollider boxCollider){
//        for(GameObject gameObject : gameObjects){
//            //instanceof để check
//            if(gameObject.isActive && gameObject instanceof Enemy){
//                Enemy enemy = (Enemy) gameObject;
//
//                if(enemy.boxCollider.collideWith(boxCollider)){
//
//                    return enemy;
//                }
//            }
//        }
//
//        return null;
//    }

//    public static Player collideWithP(BoxCollider boxCollider){
//        for(GameObject gameObject: gameObjects){
//            if(gameObject.isActive && gameObject instanceof Player){
//                Player player = (Player) gameObject;
//
//                if(player.boxCollider.collideWith(boxCollider)){
//
//                    return player;
//                }
//            }
//        }
//
//        return null;
//    }

    public static <T extends PhysicsBody> T collideWith(BoxCollider boxCollider, Class<T> cls){
        for(GameObject gameObject: gameObjects){
//            //Is Object alive?
//            if(gameObject.isActive){
//                //Are the types match?
//                if(gameObject.getClass().equals(cls)){
//                    //Do the box colliders overlap?
//                    BoxCollider otherBoxCollider = gameObject.getBoxCollider();
//
//                    if(otherBoxCollider.collideWith(boxCollider)){
//                        return (T) gameObject;
//                    }
//                }
//            }
            if(!gameObject.isActive) continue;
            if(!(gameObject instanceof PhysicsBody)) continue;
            if(!(gameObject.getClass().equals(cls))) continue;

            BoxCollider otherBoxCollider = ((PhysicsBody) gameObject).getBoxCollider();
            if(otherBoxCollider.collideWith(boxCollider)){
                return (T) gameObject;
            }
        }
        return null;
    }

//    public BoxCollider getBoxCollider(){
//        return null;
//    }


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
