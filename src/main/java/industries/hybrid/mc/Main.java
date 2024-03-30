package industries.hybrid.mc;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    @Override
    public void onEnable(){
        Bukkit.getServer().getConsoleSender().sendMessage("§2PHANTOM PARKOUR >>  PLUGIN ENABLED! ");
    }
    @Override
    public void onDisable(){
        Bukkit.getServer().getConsoleSender().sendMessage(" §4PHANTOM PARKOUR >> LETS HOPE THE SERVER WAS STOPPED BY AN ADMIN... BUT IF NOT ALL LOGS HAVE BEEN SAVED! ");

    }


}