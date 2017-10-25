package touhou.enemies;

import bases.GameObject;
import bases.physics.BoxCollider;
import bases.physics.PhysicsBody;
import touhou.players.Player;

/**
 * Created by duyanh on 10/25/17.
 */
public class PlayerDamage {
    public void run(PhysicsBody owner){
        BoxCollider boxCollider = owner.getBoxCollider();
        Player player = GameObject.collideWith(boxCollider,Player.class);
        if(player != null) {
            owner.setIsActive(false);
            player.getHit();
        }
    }
}
