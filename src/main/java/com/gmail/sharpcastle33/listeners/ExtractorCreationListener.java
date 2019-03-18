package com.gmail.sharpcastle33.listeners;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.ShulkerBox;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import net.md_5.bungee.api.ChatColor;

public class ExtractorCreationListener implements Listener {
  
  public static String EXTRACTOR_ITEM_NAME = ChatColor.YELLOW + "Void Extractor";
  
  @EventHandler
  public void createExtractor(BlockPlaceEvent event){
    Player p = event.getPlayer();
    ItemStack i = event.getItemInHand();
    if(i.hasItemMeta()
        && i.getItemMeta().hasDisplayName()
        && i.getItemMeta().getDisplayName().equals(EXTRACTOR_ITEM_NAME)) {
      Block b = event.getBlock();
      //valid block and location
      if(b.getType() == Material.BLACK_SHULKER_BOX
          && isValidExtractorLocation(b.getLocation())) {
        
        ShulkerBox box = (ShulkerBox) b.getState();
        Inventory inv = box.getInventory();
        inv.clear();
        
        
       //invalid location 
      }else {
        p.sendMessage(ChatColor.RED + "Void Extractors must be placed on top of furnaces, which are used as a fuel source.");
      }
      
      
      
      
      
      
    }
    
  }
  
  public Boolean isValidExtractorLocation(Location loc) {
    if(loc.getBlock().getRelative(BlockFace.DOWN).getType() == Material.FURNACE) {
      return true;
    }else return false;
  }
 

}
