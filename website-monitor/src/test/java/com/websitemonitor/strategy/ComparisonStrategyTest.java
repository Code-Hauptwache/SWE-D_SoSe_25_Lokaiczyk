package com.websitemonitor.strategy;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ComparisonStrategyTest {
    
    @Test
    public void testContentSizeStrategy() {
        ComparisonStrategy strategy = new ContentSizeStrategy();
        
        // Test same size - no change
        assertFalse(strategy.hasChanged("Hello World", "Hello World"));
        
        // Test different size - change detected
        assertTrue(strategy.hasChanged("Hello", "Hello World"));
    }
    
    @Test
    public void testHtmlContentStrategy() {
        ComparisonStrategy strategy = new HtmlContentStrategy();
        
        // Test identical content - no change
        assertFalse(strategy.hasChanged("<p>Hello</p>", "<p>Hello</p>"));
        
        // Test different content - change detected
        assertTrue(strategy.hasChanged("<p>Hello</p>", "<p>World</p>"));
    }
    
    @Test
    public void testTextContentStrategy() {
        ComparisonStrategy strategy = new TextContentStrategy();
        
        // Test identical text - no change
        assertFalse(strategy.hasChanged("Hello World", "Hello World"));
        
        // Test different text - change detected
        assertTrue(strategy.hasChanged("Hello World", "Hello Universe"));
        
        // Test case sensitivity
        assertTrue(strategy.hasChanged("Hello", "hello"));
    }
}