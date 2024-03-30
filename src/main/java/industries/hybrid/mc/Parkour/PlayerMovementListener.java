package industries.hybrid.mc.Parkour;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerMovementListener implements Listener {

    private final ParkourManager parkourManager;

    public PlayerMovementListener(ParkourManager parkourManager) {
        this.parkourManager = parkourManager;
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        // Check if player is within start or end locations of a parkour
        // You might need to expand the logic to determine the exact location match
    }
}
