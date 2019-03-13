package com.gmail.sharpcastle33.managers;

import java.security.SecureRandom;
import java.util.ArrayList;
import org.bukkit.Location;
import org.bukkit.World;
import com.gmail.sharpcastle33.util.DimensionalRift;
import com.gmail.sharpcastle33.util.RiftGenerator;

public class RiftManager {
  


  public ArrayList<DimensionalRift> rifts; //Active rifts in all dimensions
  
  public RiftManager() {

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
  
  public DimensionalRift generateRift(World world){
   DimensionalRift f = RiftGenerator.generateRandomRift(world);
   rifts.add(f);
   return f;
  }
  
  public void despawnRift(DimensionalRift rift) {
    rifts.remove(rift);
  }

  
}
