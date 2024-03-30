package industries.hybrid.mc.Parkour;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import java.util.HashMap;
import java.util.UUID;

public class PlayerParkourProgress implements Listener {

    private ParkourCourse currentParkour;
    private int resets;

    public PlayerParkourProgress() {
        this.resets = 0;
        this.currentParkour = null; // Assuming null means not currently in a parkour
    }

    // Getter and setter for currentParkour
    public ParkourCourse getCurrentParkour() {
        return currentParkour;
    }

    public void setCurrentParkour(ParkourCourse currentParkour) {
        this.currentParkour = currentParkour;
    }

    // Getter and setter for resets
    public int getResets() {
        return resets;
    }

    public void setResets(int resets) {
        this.resets = resets;
    }

    public void incrementResets() {
        this.resets++;
    }

    // Getters and setters


}
