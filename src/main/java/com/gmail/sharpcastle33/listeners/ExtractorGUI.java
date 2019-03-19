package com.gmail.sharpcastle33.listeners;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.Furnace;
import org.bukkit.block.ShulkerBox;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import com.gmail.sharpcastle33.Rifts;
import com.gmail.sharpcastle33.util.DimensionalRift;
import net.md_5.bungee.api.ChatColor;

public class ExtractorGUI implements Listener{
  
  public static String EXTRACTOR_GUI_NAME = ChatColor.DARK_BLUE + "Void Extractor";
  public static String ANCHORED_EXTRACTOR_GUI_NAME = ChatColor.RED + "(Anchored)" + ChatColor.DARK_BLUE + "Void Extractor";

  public static String BUTTON_UNANCHOR = ChatColor.RED + "Unanchor Extractor";
  public static String BUTTON_ANCHOR = ChatColor.GREEN + "Anchor and Activate";
  public static String INFORMATION = ChatColor.BLUE + "Information";
  public static String EXTRACTOR_INFORMATION = ChatColor.BLUE + "Extractor Information";
  
  public static String ERROR_NO_RIFT = ChatColor.RED + "There is not an active Rift at this location.";
  public static String ERROR_RIFT_IN_USE = ChatColor.RED + "There is already an active Void Extractor in use on this Rift.";
  public static String ERROR_NO_FURNACE = ChatColor.RED + "There must be a furnace below the Void Extractor.";
  public static String ERROR_NO_COAL = ChatColor.RED + "There must be at least 10 coal in the Void Extractor in order to activate it.";
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
      
      
      if(!(    invName.equals(EXTRACTOR_GUI_NAME) || invName.equals(ANCHORED_EXTRACTOR_GUI_NAME))) {
        return;
      }
      
      if (clicked.getType() == Material.ENDER_PEARL) {
        event.setCancelled(true);
        p.sendMessage(ChatColor.RED + "Enderpearls may not be put in this device");
      }
      
      if(event.getClickedInventory() instanceof PlayerInventory){
        
      }
      
      if (clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
          && clicked.getItemMeta().getDisplayName().equals(ChatColor.RED + "")) {
      event.setCancelled(true);
      }
      
      if (clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
          && clicked.getItemMeta().getDisplayName().equals(BUTTON_ANCHOR)) {
        
        Block b = (Block) event.getClickedInventory().getHolder();
        ShulkerBox box = (ShulkerBox) b.getState();
        
        //If no furnace
       if(b.getRelative(BlockFace.DOWN).getType() == Material.FURNACE) {
         Furnace furnace = (Furnace) b.getRelative(BlockFace.DOWN).getState();
         //If no coal
         if(furnace.getInventory().contains(Material.COAL) && furnace.getInventory().getFuel().getAmount() >= 10) {
           //If rift at location
           if(Rifts.riftManager.validExtractorLocation(b.getLocation())) {
             DimensionalRift rift = Rifts.riftManager.getRiftAtLocation(b.getLocation());
             
             //If rift not in use
             if(rift.isInUse() == false) {
               //Anchor and activate
              
               /*rift.setInUse(true);
               box.setCustomName(ANCHORED_EXTRACTOR_GUI_NAME);
               box.update(true);*/
               
               
               
               
             }else {
               p.sendMessage(ERROR_RIFT_IN_USE);
               p.closeInventory();
             }
             
           }else {
             p.sendMessage(ERROR_NO_RIFT);
             p.closeInventory();
           }
             
         }else {
          p.sendMessage(ERROR_NO_COAL); 
          p.closeInventory();
         }
                
       }else {
         p.sendMessage(ERROR_NO_FURNACE);
         p.closeInventory();
       }      
        
      }
      
      if (clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
          && clicked.getItemMeta().getDisplayName().equals(BUTTON_UNANCHOR)) {
        
       

        
        
        
      }
      
      
      //Check if the extractor is anchored
      
      //Unanchor button
      
      //Anchor and Activate button
      
  }
      

}
