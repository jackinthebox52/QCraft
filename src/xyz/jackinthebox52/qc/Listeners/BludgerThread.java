package xyz.jackinthebox52.qc.Listeners;

import java.util.concurrent.ThreadLocalRandom;

import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Slime;
import org.bukkit.util.Vector;

import xyz.jackinthebox52.qc.Main;
import xyz.jackinthebox52.qc.Quidditch.GameInstance;

public class BludgerThread implements Runnable {

	GameInstance gi;
	
	public BludgerThread(GameInstance g) {
		gi = g;
	}
	
    @Override
    public void run() {
        while(true) {
	        	for(Slime b : gi.bludgers) {
	        		//b.setVelocity(new Vector(1,1,1));
	        		Player target = gi.randomPlayer();
	        		//Vector shoot = target.getLocation().toVector().subtract(b.getLocation().toVector());
	        		
	        		Vector shoot = new Vector(randomInt(-3,3), randomInt(-3,3),randomInt(-3,3));
	        		
	        		b.setVelocity(shoot);
	        		
	        	}

				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        }
    }
    
    private int randomInt(int min, int max) {
    	return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

}