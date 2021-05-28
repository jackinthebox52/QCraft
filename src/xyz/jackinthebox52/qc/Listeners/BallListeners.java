package xyz.jackinthebox52.qc.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.ItemDespawnEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;

import net.md_5.bungee.api.ChatColor;
import xyz.jackinthebox52.qc.Main;
import xyz.jackinthebox52.qc.Quidditch.GameInstance;

public class BallListeners implements Listener {
	

	@EventHandler
	public void onItemDespawn(ItemDespawnEvent e) {
		for(GameInstance gi : Main.games) {
			if(gi.getPitch().containsEntity(e.getEntity())) {
				e.setCancelled(true);
			}
		}
	}
	
	@EventHandler
	public void onPlayerPickupItem(PlayerPickupItemEvent e) {
		if(e.getItem().getItemStack().getItemMeta().getDisplayName().contains("Snitch")) {
			Bukkit.broadcastMessage(e.getPlayer().getName() + " has caught the §6golden snitch!");
			for(Entity en : e.getItem().getNearbyEntities(2, 2, 2)) {
				if(en instanceof LivingEntity && en.getType() == EntityType.BAT) {
					en.remove();
				}
			}
		}else if(e.getItem().getItemStack().getItemMeta().getDisplayName().contains("Bludger")) {
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	public void onDamage(EntityDamageByEntityEvent e) {
		
	
	}
	

}
