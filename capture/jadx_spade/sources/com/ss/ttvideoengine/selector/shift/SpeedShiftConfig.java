package com.ss.ttvideoengine.selector.shift;

import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public interface SpeedShiftConfig {
    IAutoBitrateSet getIAutoBitrateSet();

    List<? extends IBandwidthSet> getIBandwidthSets();

    IGearConfig getIGearConfig();

    List<? extends IGearSet> getIGearSets();
}
