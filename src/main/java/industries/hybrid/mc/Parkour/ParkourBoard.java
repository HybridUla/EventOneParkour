package industries.hybrid.mc.Parkour;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

public class ParkourBoard implements Listener {

    public void setupScoreboard(Player p){
        Scoreboard scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
        Objective objective = scoreboard.registerNewObjective("parkour","dummy","Parkour Challenge");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);

        objective.getScore(" ").setScore(0);
        objective.getScore("  ").setScore(1);
        objective.getScore("RESETS: 0").setScore(2);
        objective.getScore("TIME:  1H:1M:1S ").setScore(3);
        objective.getScore("    ").setScore(4);
        objective.getScore("     ").setScore(5);



    }





}
