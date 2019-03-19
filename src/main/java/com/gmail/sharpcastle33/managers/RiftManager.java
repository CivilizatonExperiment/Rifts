package com.gmail.sharpcastle33.managers;

import java.util.ArrayList;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import com.gmail.sharpcastle33.util.DimensionalRift;
import com.gmail.sharpcastle33.util.RiftGenerator;
import com.gmail.sharpcastle33.util.RiftType;
import com.gmail.sharpcastle33.util.VoidExtractor;

public class RiftManager {
  


  public ArrayList<DimensionalRift> rifts; //Active rifts in all dimensions
  
  public RiftManager() {

  }
  
  public void anchorExtractor(Block b) {
    if(b.getType() == Material.BLACK_SHULKER_BOX) {
      
    }
  }
  
  public VoidExtractor getExtractor(DimensionalRift r) {
    return r.extractor;
  }
  
  public void setExtractor(DimensionalRift r, Block b) {
    if(b.getType() == Material.BLACK_SHULKER_BOX) {
      VoidExtractor ext = new VoidExtractor(b.getLocation());
      r.extractor = ext;
    }
  }
  
  public void cycleLoot(DimensionalRift r) {
    if(getExtractor(r) != null) {
      RiftType type = r.getType();
      double size = r.getSize();
      
    }else { return; }
  }
  
  public boolean validExtractorLocation(Location loc){
    for(DimensionalRift f : rifts){
      if(f.getOrigin().getWorld().equals(loc.getWorld())){
        if(loc.distance(f.getOrigin()) <= f.getRadius()){
          return true;
        }
      }
    }
    return false;
  }
  
  public DimensionalRift getRiftAtLocation(Location loc) {
    for(DimensionalRift f : rifts){
      if(f.getOrigin().getWorld().equals(loc.getWorld())){
        if(loc.distance(f.getOrigin()) <= f.getRadius()){
          return f;
        }
      }
    }
    return null;
  }
  
  public DimensionalRift generateRift(World world){
   DimensionalRift f = RiftGenerator.generateRandomRift(world);
   rifts.add(f);
   return f;
  }
  
  public DimensionalRift generateRift(World world, Location loc) {
	  return null;
  }
  
  public void despawnRift(DimensionalRift rift) {
    rifts.remove(rift);
  }

  
}
