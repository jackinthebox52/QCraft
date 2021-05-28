package xyz.jackinthebox52.qc.Listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;

import net.md_5.bungee.api.ChatColor;
import xyz.jackinthebox52.qc.Main;
import xyz.jackinthebox52.qc.Quidditch.GameInstance;

public class AreaListeners  implements Listener{
	
	@EventHandler
	public void playerDeathEvent(PlayerDeathEvent e) {
		for(GameInstance gi : Main.games) {
			if(gi.getPitch().containsEntity(e.getEntity())) {
				e.setKeepInventory(true);
				e.getEntity().setBedSpawnLocation(gi.getPitch().center, true);
				gi.messagePlayers(ChatColor.RED + e.getEntity().getDisplayName() + " was killed!");
			}
		}
	}
	
	@EventHandler
	public void entityDamageEvent(EntityDamageEvent e) {
		for(GameInstance gi : Main.games) {
			if(gi.getPitch().containsEntity(e.getEntity())) {
				if(e.getEntity() instanceof Player) {
					e.setDamage(e.getDamage() / 6);
				}
			}
		}
	}


}
