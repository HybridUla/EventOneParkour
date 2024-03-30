package industries.hybrid.mc.Players;

import industries.hybrid.mc.Main;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

public class DropItems implements Listener {

    private final Main plugin;

    public DropItems(Main plugin){
        this.plugin = plugin;

    }

    public void Dropitem(PlayerDropItemEvent e){
        Player p = e.getPlayer();
        if(p.getGameMode() == GameMode.ADVENTURE){
            e.setCancelled(false);
        }else {
            e.setCancelled(true);
        }
    }

}
