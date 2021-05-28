package xyz.jackinthebox52.qc.Quidditch;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Slime;
import org.bukkit.plugin.Plugin;

import xyz.jackinthebox52.qc.Items.Balls;
import xyz.jackinthebox52.qc.Listeners.BludgerThread;

public class GameInstance {
	
	Plugin plugin;
	Player owner;
	QuidditchPitch qp;
	public String name;
	
	public List<Player> redTeam;
	public List<Player> blueTeam;
	
	public List<Player> players = new ArrayList<Player>();
	
	public Thread t1;
	
	public List<Slime> bludgers = new ArrayList<Slime>();
	
	public Player redCaptain;
	public Player blueCaptain;
	
	public GameInstance(Plugin plugin, Player owner, QuidditchPitch qp, String name) {
		this.owner = owner;
		this.plugin = plugin;
		this.qp = qp;
		this.name = name;
	}
	
	public QuidditchPitch getPitch() {
		return qp;
	}
	
	public void init() {
		redTeam = new ArrayList<Player>();
		blueTeam = new ArrayList<Player>();
		
		redTeam.add(owner);
		redCaptain = owner;
		owner.sendMessage("§6You will be your team captain, choose the other team captain with /qc game captain {playername}, once they have joined the game");
		players.add(owner);
		owner.teleport(qp.center);
		
		qp.center.getBlock().setType(Material.ENDER_CHEST);
	}
	
	public void startGame() {
		qp.setOccupied(true);
		
		playersToSpawn();
		
		t1 = new Thread(new BludgerThread(this), "t1");
		t1.start();
        
		spawnBalls();
		
	}
	
	public void endGame() {
		qp.setOccupied(false);
		t1.stop();
	}
	
	public void spawnBalls() {
		Balls.spawnSnitch(qp.center.add(0, 40, 0));
		
		for(int i=10; i>1; i--){
            bludgers.add(Balls.spawnBludger(qp.center));
       }
	}
	
	public void playersToSpawn() {
		
	}
	
	public void messagePlayers(String msg) {
		for(Player p : players) {
			p.sendMessage(msg);
		}
	}
	
	public Player randomPlayer() {
		return players.get(randomInt(0,players.size()-1));
	}
	
	private int randomInt(int min, int max) {
    	return ThreadLocalRandom.current().nextInt(min, max + 1);
    }
	
	
	public boolean addPlayer(Player p) {//First player always added to red team
		if(blueTeam.size() <= 7 && redTeam.size() <= 7) {
			if(blueTeam.size() < redTeam.size()) {
				blueTeam.add(p);
			}else {
				redTeam.add(p);
			}
		}else {
			p.sendMessage("§4This game is full");
			return false;
		}
		players.addAll(blueTeam);
		players.addAll(redTeam);
		p.teleport(qp.center.add(3,0,1));
		p.sendMessage("§cYou are in the lobby for " + name + ". Other players can join by using /qc game join " + name);
		return true;
	}

}
