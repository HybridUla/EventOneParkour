package industries.hybrid.mc;

import industries.hybrid.mc.Parkour.*;
import industries.hybrid.mc.Players.DropItems;
import industries.hybrid.mc.Players.ParkourInventoryListener;
import industries.hybrid.mc.Players.PlayerJoin;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    @Override
    public void onEnable(){
        Bukkit.getServer().getConsoleSender().sendMessage("§2PHANTOM PARKOUR >>  PLUGIN ENABLED! ");
        ParkourManager parkourManager = new ParkourManager();
        CustomScoreboardManager.initialize(this); // Assuming you have an initialize method that stores the plugin instance

        getServer().getPluginManager().registerEvents(new ParkourCompletionListener(parkourManager), this);
        getServer().getPluginManager().registerEvents(new PlayerMovementListener(parkourManager), this);
        getServer().getPluginManager().registerEvents(new PlayerParkourProgress(),this);



        getServer().getPluginManager().registerEvents(new DropItems(this), this);
        getServer().getPluginManager().registerEvents(new ParkourInventoryListener(this), this);
        getServer().getPluginManager().registerEvents(new PlayerJoin(this), this);


        ParkourManager.getInstance().loadParkours();

    }
    @Override
    public void onDisable(){
        Bukkit.getServer().getConsoleSender().sendMessage(" §4PHANTOM PARKOUR >> LETS HOPE THE SERVER WAS STOPPED BY AN ADMIN... BUT IF NOT ALL LOGS HAVE BEEN SAVED! ");

    }


}