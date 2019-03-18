package com.gmail.sharpcastle33.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import net.md_5.bungee.api.ChatColor;

public class ExtractorGUI implements Listener{
  
  public static String EXTRACTOR_GUI_NAME = ChatColor.DARK_BLUE + "Void Extractor";
  public static String BUTTON_UNANCHOR = ChatColor.GOLD + "Unanchor Extractor";
  public static String BUTTON_ANCHOR = ChatColor.GOLD + "Anchor and Activate";
  public static String INFORMATION = ChatColor.BLUE + "Information";
  public static String RIFT_INFORMATION = ChatColor.BLUE + "Rift Information";
  
  @EventHandler
  public void alembicGUI(InventoryClickEvent event) {
     
      if (!(event.getWhoClicked() instanceof Player)) {
          return;
      }

      if (event.getClickedInventory() == null) {
          return;
      }

      Player p = (Player) event.getWhoClicked();
      ItemStack clicked = event.getCurrentItem();
      String invName = event.getInventory().getName();
      
      
      if(!(invName.equals(EXTRACTOR_GUI_NAME))) {
        return;
      }
      
      //Check if the extractor is anchored
      
      //Unanchor button
      
      //Anchor and Activate button
      
  }
      

}
