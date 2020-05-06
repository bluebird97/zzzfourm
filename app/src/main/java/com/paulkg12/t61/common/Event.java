package com.paulkg12.t61.common;

public class Event {

    /**
     * 网络状态改变事件
     */
    public static class NetChangedEvent {
        public int preNetStatus;
        public int curNetStatus;

        public NetChangedEvent(int preNetStatus, int curNetStatus) {
            this.preNetStatus = preNetStatus;
            this.curNetStatus = curNetStatus;
        }
    }
}
