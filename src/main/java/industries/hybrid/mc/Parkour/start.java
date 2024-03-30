package industries.hybrid.mc.Parkour;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class start implements CommandExecutor {

    public boolean onCommand(final CommandSender cs, Command cmd, String label, final String[] args) {
    if (cs instanceof Player){
        Player p = (Player) cs;

        if(cmd.getName().equalsIgnoreCase("Start")){
            p.teleport(new Location(p.getWorld(),9.3,-41,-6.36525));

            //Give Scoreboard and set Parkour to 1


        }

    }
    return true;
    }
}
