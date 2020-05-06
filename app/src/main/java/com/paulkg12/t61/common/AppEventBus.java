package com.paulkg12.t61.common;

import org.greenrobot.eventbus.EventBus;

public enum AppEventBus {
    INSTANCE;
    AppEventBus() {
        init();
    }
    private EventBus eventBus;

    private void init() {
        eventBus = EventBus.builder()
                .installDefaultEventBus();
    }
    public EventBus getEventBus() {
        return eventBus;
    }
}
