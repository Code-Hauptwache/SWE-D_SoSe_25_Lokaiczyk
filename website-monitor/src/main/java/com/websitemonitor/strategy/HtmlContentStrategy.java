package com.websitemonitor.strategy;

public class HtmlContentStrategy implements ComparisonStrategy {
    
    @Override
    public boolean hasChanged(String oldContent, String newContent) {
        if (oldContent == null || newContent == null) {
            return oldContent != newContent;
        }
        
        // Remove whitespace and normalize HTML for comparison
        String normalizedOld = normalizeHtml(oldContent);
        String normalizedNew = normalizeHtml(newContent);
        
        boolean changed = !normalizedOld.equals(normalizedNew);
        
        if (changed) {
            System.out.println("HTML content has changed");
        }
        
        return changed;
    }
    
    private String normalizeHtml(String html) {
        // Simple normalization: remove extra whitespace, lowercase tags
        return html.replaceAll("\\s+", " ")
                  .replaceAll(">\\s+<", "><")
                  .toLowerCase()
                  .trim();
    }
    
    @Override
    public String getStrategyName() {
        return "HTML Content Comparison";
    }
}