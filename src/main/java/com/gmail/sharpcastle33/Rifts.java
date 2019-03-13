package com.gmail.sharpcastle33;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import com.gmail.sharpcastle33.listeners.ExtractorBreakListener;
import com.gmail.sharpcastle33.listeners.ExtractorCreationListener;
import com.gmail.sharpcastle33.listeners.RedstoneExploitListener;
import com.gmail.sharpcastle33.listeners.RiftLocatorListener;
import com.gmail.sharpcastle33.managers.RiftManager;

public class Rifts extends JavaPlugin{
	public static Plugin plugin;
	public static RiftManager riftManager;

  
  public void onEnable(){
		plugin = this;
		riftManager = new RiftManager();
		
		Bukkit.getServer().getPluginManager().registerEvents(new ExtractorBreakListener(), plugin);			
		Bukkit.getServer().getPluginManager().registerEvents(new ExtractorCreationListener(), plugin);			

		Bukkit.getServer().getPluginManager().registerEvents(new RedstoneExploitListener(), plugin);			

		Bukkit.getServer().getPluginManager().registerEvents(new RiftLocatorListener(), plugin);			

  }
  
  public void onDisable(){
    
  }

}
