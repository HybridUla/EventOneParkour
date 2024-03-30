package industries.hybrid.mc.Parkour;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.*;

public class ParkourManager {
    private final Map<String, ParkourCourse> parkours = new HashMap<>();
    private final List<String> parkourOrder = new ArrayList<>();
    private final Map<UUID, PlayerParkourProgress> playerProgressMap = new HashMap<>();



    public void addParkour(ParkourCourse parkour) {
        parkours.put(parkour.getName(), parkour);
        parkourOrder.add(parkour.getName()); // Keep track of the order in which parkours are added

    }
    public ParkourCourse getParkourByName(String name) {
        return parkours.get(name);
    }

    public ParkourCourse getNextParkour(String currentParkourName) {
        int currentIndex = parkourOrder.indexOf(currentParkourName);
        if (currentIndex >= 0 && currentIndex + 1 < parkourOrder.size()) {
            return parkours.get(parkourOrder.get(currentIndex + 1));
        }
        return null; // Return null if current is the last parkour or not found
    }

    // Load parkours from a config file or define them here
    public void loadParkours() {
        String worldName = "Parkour stripes reboot"; // Replace with your actual world name
        org.bukkit.World world = Bukkit.getWorld(worldName);
        // Example hardcoded parkour
        if (world != null) {
            parkours.put("Parkour1", new ParkourCourse("Parkour1", new Location(world, 9.3, -41.00, -6.36525), new Location(world, 9.527, -25.000, 86.565)));
            parkours.put("Parkour2", new ParkourCourse("Parkour2", new Location(world, -4.500, -41.00, -6.36525), new Location(world, -4.500, -41.000, 86.300)));
            parkours.put("Parkour3", new ParkourCourse("Parkour3", new Location(world, 23.50, -41.00, -6.36525), new Location(world, 10.700, -44.000, 1447.612)));
            parkours.put("Parkour4", new ParkourCourse("Parkour4", new Location(world, -18.480, -41.00, -6.36525), new Location(world, 18.629, -26.000, 85.211)));
            parkours.put("Parkour5", new ParkourCourse("Parkour5", new Location(world, 37.50, -41.00, -6.36525), new Location(world, 33.500, -14.000, 90.391)));
            parkours.put("Parkour6", new ParkourCourse("Parkour6", new Location(world, 32.500, -41.00, -6.36525), new Location(world, -33.500, -18.000, -3.20)));


            // Add other parkours
        } else {
            Bukkit.getLogger().warning("World '" + worldName + "' not found! Cannot load parkours.");
        }
    }

    public void handleParkourCompletion(Player player) {
        PlayerParkourProgress progress = playerProgressMap.get(player.getUniqueId());

        if (progress != null && progress.getCurrentParkour() != null) {
            ParkourCourse nextParkour = getNextParkour(progress.getCurrentParkour().getName());
            progress.setCurrentParkour(nextParkour);

            if (nextParkour != null) {
                player.teleport(nextParkour.getStartLocation());
                player.sendMessage(ChatColor.GREEN + "Next parkour: " + nextParkour.getName());
            } else {
                player.sendMessage(ChatColor.GREEN + "You've completed all the parkours!");
            }
        }
    }

    public PlayerParkourProgress getPlayerProgress(Player player) {
        return playerProgressMap.computeIfAbsent(player.getUniqueId(), k -> new PlayerParkourProgress());
    }


}
