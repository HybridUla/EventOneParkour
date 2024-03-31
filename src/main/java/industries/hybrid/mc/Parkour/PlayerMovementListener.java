package industries.hybrid.mc.Parkour;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
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
        Block blockBelow = player.getLocation().getBlock().getRelative(0, -1, 0);

        if (blockBelow.getType() == Material.BEACON) {
            PlayerParkourProgress progress = parkourManager.getPlayerProgress(player.getUniqueId());
            Location beaconLocation = blockBelow.getLocation();
            // Normalize the location
            beaconLocation.setPitch(0);
            beaconLocation.setYaw(0);
            beaconLocation.setX(beaconLocation.getBlockX() + 0.5);
            beaconLocation.setY(beaconLocation.getBlockY());
            beaconLocation.setZ(beaconLocation.getBlockZ() + 0.5);

            if (!beaconLocation.equals(progress.getCurrentCheckpoint())) {
                progress.setCurrentCheckpoint(beaconLocation);
                player.sendMessage(ChatColor.GREEN + "Checkpoint updated!");
            }
        }

        if (to.getBlock().getRelative(0, -1, 0).getType() == Material.REDSTONE_BLOCK) {
            // Assuming you have a method in ParkourManager to check completion
            if (parkourManager.checkIfEndOfParkour(player, to)) {
                // Logic to handle parkour completion
                player.sendMessage(ChatColor.GOLD + "Parkour completed!");
                // Reset the player's parkour progress, teleport them to a new location, etc.
            }
        }
    }

    private boolean isNearBeacon(Location location) {
        // Check the block at the player's feet and two blocks above
        // Checks the block directly beneath the player's feet
        return location.getBlock().getRelative(0, -1, 0).getType() == Material.BEACON;
    }

    private boolean isInNewParkourStart(Location to, ParkourCourse currentParkour) {
        for (ParkourCourse parkour : parkourManager.getAllParkours()) {
            if (!parkour.equals(currentParkour) && to.getWorld().equals(parkour.getStartLocation().getWorld()) && to.distance(parkour.getStartLocation()) < 5) {
                // The player is within 5 blocks of the start of another parkour course.
                return true;
            }
        }
        return false;
    }
}
