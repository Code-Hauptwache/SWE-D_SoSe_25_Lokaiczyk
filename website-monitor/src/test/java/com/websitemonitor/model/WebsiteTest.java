package com.websitemonitor.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import com.websitemonitor.strategy.ContentSizeStrategy;
import com.websitemonitor.strategy.HtmlContentStrategy;

public class WebsiteTest {
    
    private Website website;
    
    @BeforeEach
    public void setUp() {
        website = new Website("test-id", "https://example.com");
    }
    
    @Test
    public void testWebsiteCreation() {
        // Test website creation with ID and URL
        assertEquals("test-id", website.getWebsiteId());
        assertEquals("https://example.com", website.getUrl());
        assertNotNull(website.getLastChecked());
        assertNotNull(website.getLastModified());
        assertEquals("", website.getLastContent());
    }
    
    @Test
    public void testDefaultStrategy() {
        // Test that default strategy is ContentSizeStrategy
        assertNotNull(website.getComparisonStrategy());
        assertTrue(website.getComparisonStrategy() instanceof ContentSizeStrategy);
    }
    
    @Test
    public void testStrategyChange() {
        // Test changing comparison strategy
        HtmlContentStrategy newStrategy = new HtmlContentStrategy();
        website.setComparisonStrategy(newStrategy);
        assertEquals(newStrategy, website.getComparisonStrategy());
    }
    
    @Test
    public void testContentUpdate() {
        // Test setting content
        website.setLastContent("Test content");
        assertEquals("Test content", website.getLastContent());
    }
    
    @Test
    public void testObserverManagement() {
        // Test that observers list is initialized
        assertNotNull(website.getObservers());
        assertEquals(0, website.getObservers().size());
    }
}