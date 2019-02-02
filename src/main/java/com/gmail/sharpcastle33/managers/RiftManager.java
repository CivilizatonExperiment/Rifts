package com.gmail.sharpcastle33.managers;

import java.security.SecureRandom;
import java.util.ArrayList;
import org.bukkit.Location;
import org.bukkit.World;
import com.gmail.sharpcastle33.util.DimensionalRift;
import com.gmail.sharpcastle33.util.RiftGenerator;

public class RiftManager {
  
  private byte [] seeds;
  private int currentSeed;

  public ArrayList<DimensionalRift> rifts;
  
  public RiftManager() {
    seeds = new byte[20];
    currentSeed = 0;
    
    SecureRandom sec = new SecureRandom();
    seeds = sec.generateSeed(20);
  }
  
  private Byte getNextSeed() {
   Byte ret = 0;
    if(currentSeed < 20) {
      ret = seeds[currentSeed];
      currentSeed++;
    }else {
      SecureRandom sec = new SecureRandom();
      seeds = sec.generateSeed(20);
      currentSeed = 0;
      ret = seeds[currentSeed];
      currentSeed++;
    }
    return ret;
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
   DimensionalRift f = RiftGenerator.generateRandomRift(getNextSeed(), world);
   rifts.add(f);
   return f;
  }
  
  public void despawnRift(DimensionalRift rift) {
    rifts.remove(rift);
  }

  
}
