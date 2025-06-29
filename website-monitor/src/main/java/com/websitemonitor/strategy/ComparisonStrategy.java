package com.websitemonitor.strategy;

public interface ComparisonStrategy {
    boolean hasChanged(String oldContent, String newContent);
    String getStrategyName();
}