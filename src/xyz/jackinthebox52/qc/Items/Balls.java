package xyz.jackinthebox52.qc.Items;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Slime;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.metadata.FixedMetadataValue;

import xyz.jackinthebox52.qc.Main;

public class Balls {
	
	static ItemStack sis = new ItemStack(Material.GOLD_BLOCK);
	static ItemMeta sim = sis.getItemMeta();
	
	static ItemStack bis = new ItemStack(Material.BLACK_TERRACOTTA);
	static ItemMeta bim = sis.getItemMeta();
	
	
    public static void spawnSnitch(Location l) {
		LivingEntity bat = (LivingEntity) l.getWorld().spawnEntity(l.add(0, 2, 0), EntityType.BAT);
		bat.setInvulnerable(true);
		bat.setInvisible(true);
		sim.setDisplayName("§6Golden Snitch");
		sis.setItemMeta(sim);
		bat.setPassenger(l.getWorld().dropItem(bat.getLocation(), sis));
	}
    
    public static Slime spawnBludger(Location l) {
		Slime blud =  (Slime) l.getWorld().spawnEntity(l.add(radnomInt(0,5), 10, radnomInt(0,5)), EntityType.SLIME);
		bim.setDisplayName("§4Bludger");
		bis.setItemMeta(bim);
		Item blud_block = l.getWorld().dropItem(blud.getLocation(), bis);
		blud.setPassenger(blud_block);
		blud.setSize(2);
		blud.setAware(true);
		blud.setGravity(false);
		return blud;
	}
   
    public static int radnomInt(int min, int max) {
    	return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

}
