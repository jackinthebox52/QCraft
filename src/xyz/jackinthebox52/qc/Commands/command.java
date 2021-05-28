package xyz.jackinthebox52.qc.Commands;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.md_5.bungee.api.ChatColor;
import xyz.jackinthebox52.qc.Main;
import xyz.jackinthebox52.qc.Items.Balls;
import xyz.jackinthebox52.qc.Quidditch.GameInstance;
import xyz.jackinthebox52.qc.Quidditch.QuidditchPitch;

import org.bukkit.entity.LivingEntity;

public class command implements CommandExecutor {

    // This method is called, when somebody uses our command
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    	if (sender instanceof Player) {
            Player player = (Player) sender;
            Location l = player.getLocation();
            if(args.length > 0) {
            	if(args[0].contains("game")) {
            		if(args.length > 1) {
            			if(args[1].contains("start")){
            				for(GameInstance gi : Main.games) {
            					if(player == gi.blueCaptain || player == gi.redCaptain) {
            						gi.startGame();
            						return true;
            					}
            				}
            				player.sendMessage(ChatColor.DARK_RED + "You are not a captain in a game");
	                		return true;
            			}else if(args[1].contains("stop")){
            				for(GameInstance gi : Main.games) {
            					if(player == gi.blueCaptain || player == gi.redCaptain) {
            						gi.endGame
            						();
            						return true;
            					}
            				}
            				player.sendMessage(ChatColor.DARK_RED + "You are not a captain in a game");
	                		return true;
            			}else if(args[1].contains("join")){
            			
            				if(args.length > 2) {
            					for(GameInstance game : Main.games) {
            						if(game.name == args[2]) {
            							return game.addPlayer(player);
            						}
            					}
            					player.sendMessage(ChatColor.DARK_RED + "Cannot find game");
            					return true;
            				}
            			}if(args[1].contains("create")){
            				QuidditchPitch pitch = null;
            				for(QuidditchPitch qp : Main.pitches) {
            					if(!qp.isOccupied()) {
            						pitch = qp;
            					}
            				}
            				if(pitch == null) {
            					player.sendMessage(ChatColor.DARK_RED + "All pitches are full!");
            					return true;
            				}
            				if(args.length >= 2) {
            					GameInstance gi = new GameInstance(Main.plugin, player, pitch, args[2]);
            					gi.init();
            					Main.games.add(gi);
            					return true;
            				}
            			}
            		}
            		
            	}else if(args[0].contains("pitch")) {
            		if(args.length > 1) {
	            		if(args[1].contains("define")){
	            			Main.pitches.add(new QuidditchPitch(l, args[2]));
	            			player.sendMessage(ChatColor.GOLD + "Created a new pitch at: " + l.toString());
	            			return true;
	            		}else if(args[1].contains("list")) {
	            			for(QuidditchPitch qp : Main.pitches) {
	            				player.sendMessage(ChatColor.GREEN + "Quidditch Pitch: " + qp.name);
	            			}
	            			return true;
	            		}else if(args[1] == "setgoal") {
	            			return true;
	            		}
            		}
            	}
            }
            
    	}
        return false;
    }
    
}
