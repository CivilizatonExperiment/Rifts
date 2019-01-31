package com.gmail.sharpcastle33.managers;

import java.security.SecureRandom;
import java.util.ArrayList;
import org.bukkit.Location;
import org.bukkit.World;
import com.gmail.sharpcastle33.util.DimensionalRift;
import com.gmail.sharpcastle33.util.RiftGenerator;

public class RiftManager {
  
  private byte [] seeds;

  public ArrayList<DimensionalRift> rifts;
  
  public RiftManager() {
    seeds = new byte[20];
    
    SecureRandom sec = new SecureRandom();
    seeds = sec.generateSeed(20);
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
  
  public DimensionalRift generateRift(Byte seed, World world){
   DimensionalRift f = RiftGenerator.generateRandomRift(seed, world);
   rifts.add(f);
   return f;
  }

  
}
