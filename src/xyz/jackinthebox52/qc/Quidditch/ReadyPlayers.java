package xyz.jackinthebox52.qc.Quidditch;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class ReadyPlayers {
	
	
	public static void equipChaser(Player p) {
		
	}
	
	public static void equipSeeker(Player p) {
		
	}
	
	public static void equipBasic(Player p) {
		p.getInventory().clear();
		ItemStack wings = new ItemStack(Material.ELYTRA, 1);
		ItemStack firework = new ItemStack(Material.FIREWORK_ROCKET, 1);
		p.getInventory().setChestplate(wings);
		p.getInventory().addItem(firework);
	}
	

}
