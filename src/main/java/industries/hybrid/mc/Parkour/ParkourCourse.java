package industries.hybrid.mc.Parkour;

import org.bukkit.Location;

public class ParkourCourse {
    private final String name;
    private final Location startLocation;
    private final Location endLocation;

    public ParkourCourse(String name, Location startLocation, Location endLocation) {
        this.name = name;
        this.startLocation = startLocation;
        this.endLocation = endLocation;
    }

    // Getters
    public String getName() {
        return name;
    }

    public Location getStartLocation() {
        return startLocation;
    }

    public Location getEndLocation() {
        return endLocation;
    }
}
