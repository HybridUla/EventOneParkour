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

        if (event.getCurrentItem() == null || !event.getCurrentItem().hasItemMeta()) return;

        Player p = (Player) event.getWhoClicked();

        if(event.getCurrentItem().getItemMeta().getDisplayName().contains("§b§lStart Parkour Challenge")){
            event.setCancelled(true);
            //SET CHECKPOINT TO PARKOUR 1 SPAWNPOINT
            handleStartParkour(p);

        }

        if(event.getCurrentItem().getItemMeta().getDisplayName().contains("Throw to reset to last checkpoint")){


        }


    }

    private void handleStartParkour(Player player) {
        player.sendTitle("PHANTOM PARKOUR", "TIME STARTED", 1, 5, 3);
        CustomScoreboardManager.getInstance().clearScoreboard(player);
        CustomScoreboardManager.getInstance().setParkourScoreboard(player);
        player.getInventory().clear();

        // Reset item
        ItemStack reset = new ItemStack(Material.SLIME_BALL);
        ItemMeta resetMeta = reset.getItemMeta();
        if (resetMeta != null) {
            resetMeta.setDisplayName("§b§lReset To Last Checkpoint");
            reset.setItemMeta(resetMeta);
            player.getInventory().setItem(1, reset);
        }

        // Teleport to the first parkour
        player.teleport(new Location(player.getWorld(), 9.300, -41.0000, -6.36525));
        // Additional logic for setting the parkour to 1 and checkpoint handling goes here
    }

    private void handleResetToCheckpoint(Player player) {
        // Logic to reset the player to the last checkpoint
    }

}
