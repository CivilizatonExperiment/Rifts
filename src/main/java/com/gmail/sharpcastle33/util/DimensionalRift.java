package com.gmail.sharpcastle33.util;

import org.bukkit.Location;

public class DimensionalRift {
  
  private Location origin;
  private VoidExtractor extractor;
  private int duration;
  private int radius;
  private RiftType type;
  private double size;
  private boolean inUse;
  
  
  public DimensionalRift(RiftType type, Location origin, int radius, int duration){
    
    this.type = type;
    this.origin = origin;
    this.radius = radius;
    this.duration = duration;
    inUse = false;
    extractor = null;
    size = 1;
    
  }
  
  public DimensionalRift(RiftType type, Location origin, int radius, int duration, double size){
    
    this.type = type;
    this.origin = origin;
    this.radius = radius;
    this.duration = duration;
    inUse = false;
    extractor = null;
    this.size = size;
    
  }
  

  public RiftType getType() {
    return type;
  }

  public void setType(RiftType type) {
    this.type = type;
  }

  public double getSize() {
    return size;
  }

  public void setSize(double size) {
    this.size = size;
  }

  public Location getOrigin() {
    return origin;
  }


  public void setOrigin(Location origin) {
    this.origin = origin;
  }


  public VoidExtractor getExtractor() {
    return extractor;
  }


  public void setExtractor(VoidExtractor extractor) {
    this.extractor = extractor;
  }


  public int getDuration() {
    return duration;
  }


  public void setDuration(int duration) {
    this.duration = duration;
  }


  public int getRadius() {
    return radius;
  }


  public void setRadius(int radius) {
    this.radius = radius;
  }

  public boolean isInUse() {
    return inUse;
  }


  public void setInUse(boolean inUse) {
    this.inUse = inUse;
  }
  
  
}
