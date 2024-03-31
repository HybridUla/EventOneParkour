package industries.hybrid.mc.Players;

import industries.hybrid.mc.Main;
import industries.hybrid.mc.Parkour.CustomScoreboardManager;
import industries.hybrid.mc.Parkour.ParkourManager;
import industries.hybrid.mc.Parkour.PlayerParkourProgress;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ParkourInventoryListener implements Listener {

    private final Main plugin;

    public ParkourInventoryListener(Main plugin){
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
    @EventHandler(priority = EventPriority.HIGHEST)
    public void ItemClick(PlayerInteractEvent event){
        Player player = event.getPlayer();
        ItemStack item = event.getItem();

        if (item != null && item.hasItemMeta()) {
            String itemName = item.getItemMeta().getDisplayName();

            if (itemName.equals("§b§lStart Parkour Challenge") && (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK)) {
                event.setCancelled(true);
                handleStartParkour(player);
            }

            if (itemName.equals("§b§lReset To Last Checkpoint") && (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK)) {
                event.setCancelled(true);
                handleResetToCheckpoint(player);
            }
        }


    }

    private void handleStartParkour(Player player) {
        player.sendTitle("PHANTOM PARKOUR", "TIME STARTED", 50, 50, 30);
        CustomScoreboardManager.getInstance().clearScoreboard(player);
        CustomScoreboardManager.getInstance().setParkourScoreboard(player);
        player.getInventory().clear();

        // Reset item
        ItemStack reset = new ItemStack(Material.SLIME_BALL);
        ItemMeta resetMeta = reset.getItemMeta();
        if (resetMeta != null) {
            resetMeta.setDisplayName("§b§lReset To Last Checkpoint");
            reset.setItemMeta(resetMeta);
            player.getInventory().setItem(0, reset);
        }

        // Teleport to the first parkour
        player.teleport(new Location(player.getWorld(), 9.300, -41.0000, -6.36525));
        // Additional logic for setting the parkour to 1 and checkpoint handling goes here

    }

    public void handleResetToCheckpoint(Player player) {
        PlayerParkourProgress progress = ParkourManager.getInstance().getPlayerProgress(player.getUniqueId());
        Location checkpoint = progress.getCurrentCheckpoint();
        if (checkpoint != null) {
            // Log for debugging
            Bukkit.getLogger().info("Teleporting " + player.getName() + " to checkpoint at " + checkpoint.toString());
            player.teleport(checkpoint);
            player.sendMessage(ChatColor.GREEN + "Teleported to your last checkpoint!");
        } else {
            player.sendMessage(ChatColor.RED + "No checkpoint reached.");
        }
    }

}
