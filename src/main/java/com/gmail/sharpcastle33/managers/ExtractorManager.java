package com.gmail.sharpcastle33.managers;

import java.util.ArrayList;
import org.bukkit.block.Block;
import com.gmail.sharpcastle33.util.VoidExtractor;

public class ExtractorManager {
  
  private ArrayList<VoidExtractor> extractors;
  
  public VoidExtractor createExtractor(Block b){
    VoidExtractor e = new VoidExtractor();
    extractors.add(e);
    return e;
  }
  
  public void removeExtractor(VoidExtractor e){
    extractors.remove(e);
  }

}
