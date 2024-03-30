package industries.hybrid.mc.Parkour;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

public class LobbyScoreboard implements Listener {

    public void LobbyBoard(Player p){

        int TotalOnline = Bukkit.getServer().getOnlinePlayers().size();

        Scoreboard scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
        Objective objective = scoreboard.registerNewObjective("lobby", "dummy", "PHANTOM PARKOUR");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);

        objective.getScore(" ").setScore(0);
        objective.getScore("  ").setScore(1);
        objective.getScore("Welcome " + p.getDisplayName()).setScore(2);
        objective.getScore("Players: " + TotalOnline + "/24").setScore(3);
        objective.getScore("   ").setScore(4);
        objective.getScore("    ").setScore(5);

        p.setScoreboard(scoreboard);


    }
}
