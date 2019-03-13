package com.gmail.sharpcastle33.listeners;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.gmail.sharpcastle33.Rifts;
import com.gmail.sharpcastle33.util.DimensionalRift;

import net.md_5.bungee.api.ChatColor;

public class RiftLocatorListener implements Listener {
	
	public static int RIFT_LOCATION_FALLOFF = 3000;
	
	public static String RIFT_LOCATOR_NAME = ChatColor.YELLOW + "Rift Locator Device";
	
	public static String NO_RIFTS = ChatColor.RED + "There are no active Rifts in your current dimension.";
	
	@EventHandler
	public void locatorUse(PlayerInteractEvent event) {
		if (event.getHand() == EquipmentSlot.HAND
				&& (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK)) {
			Player p = event.getPlayer();
			ItemStack i = p.getInventory().getItemInMainHand();
			
			if(i.getType() == Material.COMPASS) {
				if(i.hasItemMeta()) {
					ItemMeta meta = i.getItemMeta();
					if(meta.hasDisplayName()) {
						if(meta.getDisplayName().equals(RIFT_LOCATOR_NAME)) {
							Location nearest = findNearestRift(p.getLocation());
							
							//No rift found
							if(nearest == null || (nearest.getX() == 0 && nearest.getY() == 0)) {
								p.sendMessage(NO_RIFTS);
								
								
								
								//Rift found
							}else {
								p.setCompassTarget(nearest);
								//Check distance
								if(nearest.distance(p.getLocation()) > RIFT_LOCATION_FALLOFF) {
									p.sendMessage(ChatColor.BLUE + "The Locator wavers slightly. There is indeed a rift on this plane, but it is very far away. It appears the rift lies to the "
								+ ChatColor.GOLD + getDirectionalFromLocations(p.getLocation(),nearest) + ".");
								}else {
									p.sendMessage(ChatColor.BLUE + "There must be a Rift nearby. The locator is being pulled towards" + ChatColor.GOLD + "[x:" + nearest.getX() + ", z: " + nearest.getZ() + "].");
								}
							}
							
						}
					}
				}
			}
		}
			
	}
	
	//Finds the nearest active rift. Can return NULL.
	public Location findNearestRift(Location loc) {
		Location closest = null;
		int distance = 99999;
		for(DimensionalRift r : Rifts.riftManager.rifts) {
			if(r.getOrigin().getWorld() == loc.getWorld()) {
				if(r.getOrigin().distance(loc) < distance) {
					closest = r.getOrigin();
					distance = (int) r.getOrigin().distance(loc);
				}
			}
		}
		return closest;
	}
	
	public String getDirectionalFromLocations(Location origin, Location target) {
		double xdif = origin.getX() - target.getX();
		double zdif = origin.getZ() - target.getZ();
		
		if(xdif > zdif) {
			if(xdif > 0) {
				return "South";
			}else return "North";
		}else {
			if(zdif > 0) {
				return "West";
			}else return "East";
		}
	}

}
