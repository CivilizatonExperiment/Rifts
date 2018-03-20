package com.gmail.sharpcastle33.managers;

import java.util.ArrayList;
import org.bukkit.Location;
import org.bukkit.World;
import com.gmail.sharpcastle33.util.DimensionalFlux;
import com.gmail.sharpcastle33.util.FluxGenerator;

public class FluxManager {

  public ArrayList<DimensionalFlux> fluxes;
  
  public boolean validExtractorLocation(Location loc){
    for(DimensionalFlux f : fluxes){
      if(f.getOrigin().getWorld().equals(loc.getWorld())){
        if(loc.distance(f.getOrigin()) <= f.getRadius()){
          return true;
        }
      }
    }
    return false;
  }
  
  public Location generateFlux(World world){
   DimensionalFlux f = FluxGenerator.generateFlux(world);
   fluxes.add(f);
   return f.getOrigin();
  }

  public Location generateFlux(){
    DimensionalFlux f = FluxGenerator.generateFlux();
    fluxes.add(f);
    return f.getOrigin();
  }
  
}
