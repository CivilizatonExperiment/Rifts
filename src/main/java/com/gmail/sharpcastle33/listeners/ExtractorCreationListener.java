package com.gmail.sharpcastle33.listeners;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.ShulkerBox;
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
    
    ItemStack i = event.getItemInHand();
    if(i.hasItemMeta()
        && i.getItemMeta().hasDisplayName()
        && i.getItemMeta().getDisplayName().equals(EXTRACTOR_ITEM_NAME)) {
      Block b = event.getBlock();
      if(b.getType() == Material.BLACK_SHULKER_BOX) {
        
        ShulkerBox box = (ShulkerBox) b.getState();
        Inventory inv = box.getInventory();
        inv.clear();
        
        
        
      }
      
      
      
      
      
      
    }
    
  }

}
