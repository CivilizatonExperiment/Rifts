package com.gmail.sharpcastle33.listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import net.md_5.bungee.api.ChatColor;

public class ExtractorGUI implements Listener{
  
  public static String EXTRACTOR_GUI_NAME = ChatColor.DARK_BLUE + "Void Extractor";
  public static String BUTTON_UNANCHOR = ChatColor.RED + "Unanchor Extractor";
  public static String BUTTON_ANCHOR = ChatColor.GREEN + "Anchor and Activate";
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
      
      if (clicked.getType() == Material.ENDER_PEARL) {
        event.setCancelled(true);
        p.sendMessage(ChatColor.RED + "Enderpearls may not be put in this device");
      }
      
      if(event.getClickedInventory().getName().equals(EXTRACTOR_GUI_NAME)) {
        
      }
      
      if(event.getClickedInventory() instanceof PlayerInventory){
        
      }
      
      if (clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
          && clicked.getItemMeta().getDisplayName().equals(ChatColor.RED + "")) {
      event.setCancelled(true);
      }
      
      if (clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
          && clicked.getItemMeta().getDisplayName().equals(BUTTON_ANCHOR)) {
        
        
        
        
      }
      
      if (clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
          && clicked.getItemMeta().getDisplayName().equals(BUTTON_UNANCHOR)) {
        
        
        
        
        
      }
      
      
      //Check if the extractor is anchored
      
      //Unanchor button
      
      //Anchor and Activate button
      
  }
      

}
