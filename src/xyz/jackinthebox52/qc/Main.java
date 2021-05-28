package xyz.jackinthebox52.qc;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import xyz.jackinthebox52.qc.Commands.command;
import xyz.jackinthebox52.qc.Listeners.AreaListeners;
import xyz.jackinthebox52.qc.Listeners.BallListeners;
import xyz.jackinthebox52.qc.Quidditch.GameInstance;
import xyz.jackinthebox52.qc.Quidditch.QuidditchPitch;

public class Main extends JavaPlugin
{
    private final Server server = getServer();
    
    public static Plugin plugin;
    
    //Global list of pitches
  	public static List<QuidditchPitch> pitches = new ArrayList<QuidditchPitch>();
  	//Global list of games
  	public static List<GameInstance> games = new ArrayList<GameInstance>();

    @Override
    public void onEnable()
    {
        saveDefaultConfig();
        plugin = this;
        this.getCommand("qc").setExecutor(new command());
        
        Bukkit.getPluginManager().registerEvents(new BallListeners(), this);
        Bukkit.getPluginManager().registerEvents(new AreaListeners(), this);
    }

    /**
     * Obtains the minecraft server isntance
     * @return  The minecraft server
     */
    private Server getS()
    {
        return server;
    }
    
    /**
     * Obtains the minecraft server isntance
     * @return  The minecraft server
     */
    private Server getPlugin()
    {
        return this.getPlugin();
    }

}
