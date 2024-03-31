package industries.hybrid.mc.Parkour;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class ParkourCompletionListener implements Listener {

    private final ParkourManager parkourManager;

    public ParkourCompletionListener(ParkourManager parkourManager) {
        this.parkourManager = parkourManager;
    }


}
