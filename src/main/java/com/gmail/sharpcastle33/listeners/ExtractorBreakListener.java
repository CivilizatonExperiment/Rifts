package com.gmail.sharpcastle33.listeners;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.ShulkerBox;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class ExtractorBreakListener implements Listener {
  
  @EventHandler
  public void breakExtractor(BlockBreakEvent event) {
    Player p = event.getPlayer();   
    Block b = event.getBlock();
    if(b.getType() == Material.BLACK_SHULKER_BOX) {
      ShulkerBox box = (ShulkerBox) b.getState();
      if(box.getCustomName().equals(ExtractorGUI.ANCHORED_EXTRACTOR_GUI_NAME)) {
        event.setCancelled(true);
        p.sendMessage(ExtractorGUI.ERROR_ANCHORED_DEVICE);
        
      }else if(box.getCustomName().equals(ExtractorGUI.EXTRACTOR_GUI_NAME)) {
        
      }
    }
    
    
    
  }

}
