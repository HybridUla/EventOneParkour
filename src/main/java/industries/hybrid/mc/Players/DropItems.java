package industries.hybrid.mc.Players;

import industries.hybrid.mc.Main;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerItemBreakEvent;

public class DropItems implements Listener {

    private final Main plugin;

    public DropItems(Main plugin){
        this.plugin = plugin;

    }
@EventHandler
    public void Dropitem(PlayerDropItemEvent e){
        Player p = e.getPlayer();
        if(p.getGameMode() == GameMode.CREATIVE){
            e.setCancelled(false);
        }else {
            e.setCancelled(true);
        }
    }
    @EventHandler
    public void PlaceItem(BlockPlaceEvent e){
        Player p = e.getPlayer();
        if(p.getGameMode() == GameMode.CREATIVE){
            e.setCancelled(false);
        }else {
            e.setCancelled(true);
        }
    }



}
