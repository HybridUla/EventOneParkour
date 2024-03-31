package industries.hybrid.mc.Parkour;

import industries.hybrid.mc.Main;
import industries.hybrid.mc.Utils.ColorScrollPlus;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import java.util.ArrayList;
import java.util.List;

public class CustomScoreboardManager implements Listener {
    private static CustomScoreboardManager instance;
    private Plugin plugin;

    public static void initialize(Plugin plugin) {
        if (instance == null) {
            instance = new CustomScoreboardManager();
            instance.plugin = plugin;
        }
    }

    public static CustomScoreboardManager getInstance() {
        return instance;
    }



    private final ScoreboardManager manager = Bukkit.getScoreboardManager();

    public Scoreboard createLobbyScoreboard(Player player) {
        int TotalOnline = Bukkit.getServer().getOnlinePlayers().size();
        Scoreboard scoreboard = manager.getNewScoreboard();
        final ColorScrollPlus cs1 = new ColorScrollPlus(ChatColor.YELLOW, "PHANTOM PARKOUR CHALLENGE", "§f", "§6", "§f", true, false, ColorScrollPlus.ScrollType.FORWARD);


        this.list.add(cs1.next());


        Objective objective = scoreboard.registerNewObjective("lobby", "dummy", "PHANTOM PARKOUR CHALLENGE");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);

        objective.getScore(" ").setScore(0);
        objective.getScore("  ").setScore(1);
        objective.getScore("§lWelcome §a§l" + player.getDisplayName()).setScore(2);
        objective.getScore("§e§lPlayers: " + TotalOnline + "/24").setScore(3);
        objective.getScore("   ").setScore(4);
        objective.getScore("    ").setScore(5);


        new BukkitRunnable()
        {
            public void run()
            {
                if (cs1.getScrollType() == ColorScrollPlus.ScrollType.FORWARD)
                {
                    if (cs1.getPosition() >= cs1.getString().length()) {
                        cs1.setScrollType(ColorScrollPlus.ScrollType.BACKWARD);
                    }
                }
                else if (cs1.getPosition() <= -2) {
                    cs1.setScrollType(ColorScrollPlus.ScrollType.FORWARD);
                }
                objective.setDisplayName(cs1.next());

            }
        }.runTaskTimer(instance.plugin, 0L, 2L);


        return scoreboard;
    }

    List<String> list = new ArrayList();


    public Scoreboard createParkourScoreboard() {
        Scoreboard scoreboard = manager.getNewScoreboard();
        final ColorScrollPlus cs1 = new ColorScrollPlus(ChatColor.YELLOW, "PHANTOM PARKOUR CHALLENGE", "§f", "§6", "§f", true, false, ColorScrollPlus.ScrollType.FORWARD);
        this.list.add(cs1.next());

        Objective objective = scoreboard.registerNewObjective("parkour","dummy","Parkour Challenge");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);

        objective.getScore(" ").setScore(0);
        objective.getScore("  ").setScore(1);
        objective.getScore("RESETS: 0").setScore(2);
        objective.getScore("TIME:  1H:1M:1S ").setScore(3);
        objective.getScore("    ").setScore(4);
        objective.getScore("     ").setScore(5);

        new BukkitRunnable()
        {
            @Override
            public void run()
            {
                if (cs1.getScrollType() == ColorScrollPlus.ScrollType.FORWARD)
                {
                    if (cs1.getPosition() >= cs1.getString().length()) {
                        cs1.setScrollType(ColorScrollPlus.ScrollType.BACKWARD);
                    }
                }
                else if (cs1.getPosition() <= -2) {
                    cs1.setScrollType(ColorScrollPlus.ScrollType.FORWARD);
                }
                objective.setDisplayName(cs1.next());

            }
        }.runTaskTimer(this.plugin, 0L, 2L);


        return scoreboard;
    }

    public void setLobbyScoreboard(Player player) {
        Scoreboard lobbyScoreboard = createLobbyScoreboard(player);
        player.setScoreboard(lobbyScoreboard);
    }
    public void clearScoreboard(Player player) {
        ScoreboardManager manager = Bukkit.getScoreboardManager();
        Scoreboard clearBoard = manager.getNewScoreboard(); // Creates an empty scoreboard
        player.setScoreboard(clearBoard); // Sets the player's scoreboard to the empty one
    }

    public void setParkourScoreboard(Player player) {
        Scoreboard parkourScoreboard = createParkourScoreboard();
        player.setScoreboard(parkourScoreboard);
    }
}
