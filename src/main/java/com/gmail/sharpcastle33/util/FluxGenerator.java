package com.gmail.sharpcastle33.util;

import org.bukkit.Location;
import org.bukkit.World;

public class FluxGenerator {
  
  public static DimensionalFlux generateFlux(){
    return new DimensionalFlux(null, 0, 0, 0);
  }
  
  public static DimensionalFlux generateFlux(World world){
    return new DimensionalFlux(null, 0, 0, 0);
  }
  
  public static Location generateFluxLocation(World world){
    return null;
  }
  
  public static Location generateFluxLocation(){
    return null;
  }
  
  public static Location generateRandomLocation(){
    return null;
  }
  
  
}
