package industries.hybrid.mc.Players;

import industries.hybrid.mc.Main;
import industries.hybrid.mc.Parkour.CustomScoreboardManager;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scoreboard.Scoreboard;

public class Inventory implements Listener {

    private final Main plugin;

    public Inventory(Main plugin){
        this.plugin = plugin;

    }

    CustomScoreboardManager scoreboardManager = CustomScoreboardManager.getInstance();



    public static void HotBar(Player player){
        ItemStack start = new ItemStack(Material.REDSTONE);
        ItemMeta startmeta = start.getItemMeta();
        startmeta.setDisplayName("§b§lStart Parkour Challenge");
        start.setItemMeta(startmeta);

        player.getInventory().setItem(0,start);

    }

    public void ItemClick(InventoryClickEvent event){

        Player p = (Player) event.getWhoClicked();

        ItemStack reset = new ItemStack(Material.SLIME_BALL);
        ItemMeta resetmeta = reset.getItemMeta();
        resetmeta.setDisplayName("§b§lReset To Last Checkpoint");
        reset.setItemMeta(resetmeta);

        if(event.getCurrentItem().getItemMeta().getDisplayName().contains("§b§lStart Parkour Challenge")){
            event.setCancelled(true);
            p.sendTitle("PHANTOM PARKOUR","TIME STARTED",1,5,3);
            //SEND THE PARKOUR SCOREBOARD AND START THE TIMER
            CustomScoreboardManager.getInstance().clearScoreboard(p);
             CustomScoreboardManager.getInstance().setParkourScoreboard(p);
            //CLEAR INVENTORY
            p.getInventory().clear();

            //ADD SLIME FOR PLAYER TO DROP FOR RESET CHECKPOINT
            p.getInventory().setItem(1, reset);

            //TELEPORT TO THE FIRST PARKOUR
            p.teleport(new Location(p.getWorld(), 9.300,-41.0000,-6.36525));
            //SET PARKOUR TO 1

            //SET CHECKPOINT TO PARKOUR 1 SPAWNPOINT

        }

        if(event.getCurrentItem().getItemMeta().getDisplayName().contains("Throw to reset to last checkpoint")){


        }


    }

}
