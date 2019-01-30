package com.gmail.sharpcastle33.managers;

import java.util.ArrayList;
import org.bukkit.Location;
import org.bukkit.World;
import com.gmail.sharpcastle33.util.DimensionalRift;
import com.gmail.sharpcastle33.util.RiftGenerator;

public class RiftManager {

  public ArrayList<DimensionalRift> rifts;
  
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
  
  public Location generateRift(){
   DimensionalRift f = RiftGenerator.generateRandomRift();
   rifts.add(f);
   return f.getOrigin();
  }

  
}
