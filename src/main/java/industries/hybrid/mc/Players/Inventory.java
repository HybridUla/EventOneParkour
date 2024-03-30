package industries.hybrid.mc.Players;

import industries.hybrid.mc.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Inventory implements Listener {

    private final Main plugin;

    public Inventory(Main plugin){
        this.plugin = plugin;

    }


    public static void HotBar(Player player){
        ItemStack start = new ItemStack(Material.REDSTONE);
        ItemMeta startmeta = start.getItemMeta();
        startmeta.setDisplayName("§b§lStart Parkour Challenge");
        start.setItemMeta(startmeta);

        player.getInventory().setItem(0,start);

    }

    public void ItemClick(InventoryClickEvent event){

        Player p = (Player) event.getWhoClicked();

        if(event.getCurrentItem().getItemMeta().getDisplayName().contains("§b§lStart Parkour Challenge")){
            p.sendTitle("PHANTOM PARKOUR","TIME STARTED",1,5,3);
            //SEND THE PARKOUR SCOREBOARD AND START THE TIMER
            //TELEPORT TO THE FIRST PARKOUR
            //SET PARKOUR TO 1
            //SET CHECKPOINT TO PARKOUR 1 SPAWNPOINT
        }


    }

}
