package com.websitemonitor.observer;

import com.websitemonitor.model.Website;

public interface WebsiteObserver {
    void onWebsiteUpdated(Website website, String updateInfo);
}