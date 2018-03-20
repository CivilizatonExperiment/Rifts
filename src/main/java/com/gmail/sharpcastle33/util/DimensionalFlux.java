package com.gmail.sharpcastle33.util;

import org.bukkit.Location;

public class DimensionalFlux {
  
  private Location origin;
  private FluxExtractor extractor;
  private int duration;
  private int radius;
  private int value;
  private boolean active;
  private boolean inUse;
  
  
  public DimensionalFlux(Location origin, int radius, int duration, int value){
    
    this.origin = origin;
    this.radius = radius;
    this.duration = duration;
    this.value = value;
    
    active = true;
    inUse = false;
    extractor = null;
    
  }
  
  public int getValue(){
    return value;
  }
  
  public void setValue(int i){
    value = i;
  }


  public Location getOrigin() {
    return origin;
  }


  public void setOrigin(Location origin) {
    this.origin = origin;
  }


  public FluxExtractor getExtractor() {
    return extractor;
  }


  public void setExtractor(FluxExtractor extractor) {
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


  public boolean isActive() {
    return active;
  }


  public void setActive(boolean active) {
    this.active = active;
  }


  public boolean isInUse() {
    return inUse;
  }


  public void setInUse(boolean inUse) {
    this.inUse = inUse;
  }
  
  
}
