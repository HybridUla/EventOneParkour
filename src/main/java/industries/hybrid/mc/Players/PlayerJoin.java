package industries.hybrid.mc.Players;

import industries.hybrid.mc.Main;
import industries.hybrid.mc.Parkour.CustomScoreboardManager;
import org.bukkit.Location;
import org.bukkit.Sound;
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
        ParkourInventoryListener.HotBar(p);

        CustomScoreboardManager.getInstance().clearScoreboard(p);
        CustomScoreboardManager.getInstance().setLobbyScoreboard(p);

        p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_PLACE,1,1);
        p.sendTitle("§e§lPHANTOM PARKOUR", "§lWELCOME§a§l " + p.getDisplayName(), 50, 50, 30);

    }

}
