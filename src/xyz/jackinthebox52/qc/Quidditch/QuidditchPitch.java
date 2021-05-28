package xyz.jackinthebox52.qc.Quidditch;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;

public class QuidditchPitch {
	
	public Location center;
	public String name;
	public List<Location> redSpawns;
	public List<Location> blueSpawns;
	public boolean occupied;
	
	public QuidditchPitch(Location center, String name){
		this.center = center;
		this.name = name;
		
		init();
	}
	
	public void init() {
		populateSpawnList();
	}
	
	public boolean containsEntity(Entity e) {
		if(e.getLocation().distance(center) < 143) {
			return true;
		}
		return false;
	}
	
	private void populateSpawnList() {
		World w = center.getWorld();
		int x = center.getBlockX(); int y = center.getBlockY(); int z = center.getBlockZ();
		redSpawns = new ArrayList<Location>();
		blueSpawns = new ArrayList<Location>();
		
		redSpawns.add(new Location(w ,x+9 ,y ,z+2 )); redSpawns.add(new Location(w ,x+9 ,y ,z-2 ));
		redSpawns.add(new Location(w ,x+7 ,y ,z+5 )); redSpawns.add(new Location(w ,x+7 ,y ,z-5 ));
		redSpawns.add(new Location(w ,x+5 ,y ,z+7 )); redSpawns.add(new Location(w ,x+5 ,y ,z-7 ));
		
		blueSpawns.add(new Location(w ,x-9 ,y ,z+2 )); blueSpawns.add(new Location(w ,x-9 ,y ,z-2 ));
		blueSpawns.add(new Location(w ,x-7 ,y ,z+5 )); blueSpawns.add(new Location(w ,x-7 ,y ,z-5 ));
		blueSpawns.add(new Location(w ,x-5 ,y ,z+7 )); blueSpawns.add(new Location(w ,x-5 ,y ,z-7 ));

	}
	
	public boolean isOccupied() {
		return occupied;
	}
	
	public void setOccupied(boolean o) {
		occupied = o;
	}

}
