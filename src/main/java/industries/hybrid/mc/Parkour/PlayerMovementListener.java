package industries.hybrid.mc.Parkour;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
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
        Location to = event.getTo();

        // Check blocks around the player's feet and head for a beacon
        if (isNearBeacon(to)) {
            PlayerParkourProgress progress = parkourManager.getPlayerProgress(player);
            ParkourCourse currentParkour = progress.getCurrentParkour();

            // If in a new parkour, ignore beacon touches until the player starts the new course
            // Assuming you have logic to determine if "to" is within a new parkour start
            if (currentParkour != null && !isInNewParkourStart(to, currentParkour)) {
                progress.setCurrentCheckpoint(to);
                player.sendMessage(ChatColor.GREEN + "Checkpoint updated!");
            }
        }
    }

    private boolean isNearBeacon(Location location) {
        // Check the block at the player's feet and two blocks above
        return location.getBlock().getType() == Material.BEACON ||
                location.getBlock().getRelative(0, 1, 0).getType() == Material.BEACON ||
                location.getBlock().getRelative(0, -1, 0).getType() == Material.BEACON;
    }

    private boolean isInNewParkourStart(Location to, ParkourCourse currentParkour) {
        // Implement your logic to determine if the player is in a new parkour start area
        return false; // Placeholder
    }
}
