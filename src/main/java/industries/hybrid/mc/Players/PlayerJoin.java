package industries.hybrid.mc.Players;

import industries.hybrid.mc.Main;
import industries.hybrid.mc.Parkour.CustomScoreboardManager;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {


    private final Main plugin;

    public PlayerJoin (Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoinEvent(PlayerJoinEvent e){
        Player p = e.getPlayer();
        int x = 0;
        int y = 17;
        int z = 41;
        p.teleport(new Location(p.getWorld(), x,y,z));
        Inventory.HotBar(p);
        CustomScoreboardManager.getInstance().clearScoreboard(p);
        CustomScoreboardManager.getInstance().setLobbyScoreboard(p);
    }

}
