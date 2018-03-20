package com.gmail.sharpcastle33.managers;

import java.util.ArrayList;
import org.bukkit.block.Block;
import com.gmail.sharpcastle33.util.FluxExtractor;

public class ExtractorManager {
  
  private ArrayList<FluxExtractor> extractors;
  
  public FluxExtractor createExtractor(Block b){
    FluxExtractor e = new FluxExtractor();
    extractors.add(e);
    return e;
  }
  
  public void removeExtractor(FluxExtractor e){
    extractors.remove(e);
  }

}
