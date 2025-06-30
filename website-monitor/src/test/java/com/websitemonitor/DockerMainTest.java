package com.websitemonitor;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class DockerMainTest {
    
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    
    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }
    
    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }
    
    @Test
    public void testInvalidUrl() {
        // Test with invalid URL
        DockerMain.main(new String[]{"not-a-valid-url"});
        String output = outContent.toString();
        assertTrue(output.contains("Error:"));
        assertTrue(output.contains("Status: ERROR"));
    }
    
    @Test
    public void testValidUrlFormat() {
        // Test that monitoring message is displayed
        DockerMain.main(new String[]{"https://invalid.domain.that.does.not.exist"});
        String output = outContent.toString();
        assertTrue(output.contains("Monitoring: https://invalid.domain.that.does.not.exist"));
    }
    
    @Test
    public void testHttpUrl() {
        // Test with HTTP URL
        DockerMain.main(new String[]{"http://example.invalid"});
        String output = outContent.toString();
        assertTrue(output.contains("Monitoring: http://example.invalid"));
        // Should have error since domain doesn't exist
        assertTrue(output.contains("Error:") || output.contains("Status: ERROR"));
    }
}