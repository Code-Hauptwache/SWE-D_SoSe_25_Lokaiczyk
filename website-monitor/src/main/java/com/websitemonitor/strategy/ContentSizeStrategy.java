package com.websitemonitor.strategy;

public class ContentSizeStrategy implements ComparisonStrategy {
    
    @Override
    public boolean hasChanged(String oldContent, String newContent) {
        if (oldContent == null || newContent == null) {
            return oldContent != newContent;
        }
        
        // Compare content size (length)
        boolean changed = oldContent.length() != newContent.length();
        
        if (changed) {
            System.out.println("Content size changed: " + oldContent.length() + 
                             " -> " + newContent.length() + " bytes");
        }
        
        return changed;
    }
    
    @Override
    public String getStrategyName() {
        return "Content Size Comparison";
    }
}