package com.gmail.sharpcastle33.util;

import java.util.Random;
import org.bukkit.Location;
import org.bukkit.World;

public class RiftGenerator {
  
  private static int centerX = 700;
  private static int centerZ = 700;
  private static int minY = 30;
  private static int maxY = 60;
  private static int maxRadius = 4000;
  private static int minRadius = 600;
  
  
  
  public static DimensionalRift generateRandomRift() {
    return null;
  }
  
  public static void generateRift(Location loc, RiftType type) {
    
  }
  
  public static RiftType generateRiftType() {
    return null;
  }
  
  public static Location generateRandomLocation(Byte seed, World world) {
    Random rand = new Random(seed);
    
    int x = (rand.nextInt(maxRadius-minRadius-centerX)+minRadius+centerX);
    int z = (rand.nextInt(maxRadius-minRadius-centerZ)+minRadius+centerZ);
    int y = (rand.nextInt(maxY-minY)+minY);
    
    
   return new Location(world, x,y,z);
  }
  
  
}
