package industries.hybrid.mc;

import industries.hybrid.mc.Parkour.ParkourCompletionListener;
import industries.hybrid.mc.Parkour.ParkourManager;
import industries.hybrid.mc.Parkour.PlayerMovementListener;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    @Override
    public void onEnable(){
        Bukkit.getServer().getConsoleSender().sendMessage("§2PHANTOM PARKOUR >>  PLUGIN ENABLED! ");
        ParkourManager parkourManager = new ParkourManager();

        getServer().getPluginManager().registerEvents(new ParkourCompletionListener(parkourManager), this);
        getServer().getPluginManager().registerEvents(new PlayerMovementListener(parkourManager), this);


    }
    @Override
    public void onDisable(){
        Bukkit.getServer().getConsoleSender().sendMessage(" §4PHANTOM PARKOUR >> LETS HOPE THE SERVER WAS STOPPED BY AN ADMIN... BUT IF NOT ALL LOGS HAVE BEEN SAVED! ");

    }


}