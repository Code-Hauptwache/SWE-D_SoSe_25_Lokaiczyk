package com.websitemonitor.strategy;

public class TextContentStrategy implements ComparisonStrategy {
    
    @Override
    public boolean hasChanged(String oldContent, String newContent) {
        if (oldContent == null || newContent == null) {
            return oldContent != newContent;
        }
        
        // Extract text content by removing HTML tags
        String oldText = extractTextContent(oldContent);
        String newText = extractTextContent(newContent);
        
        boolean changed = !oldText.equals(newText);
        
        if (changed) {
            System.out.println("Text content has changed");
        }
        
        return changed;
    }
    
    private String extractTextContent(String html) {
        // Remove HTML tags and normalize whitespace
        return html.replaceAll("<[^>]*>", "")
                  .replaceAll("&[^;]+;", "") // Remove HTML entities
                  .replaceAll("\\s+", " ")
                  .trim();
    }
    
    @Override
    public String getStrategyName() {
        return "Text Content Comparison";
    }
}