package com.ss.ttvideoengine.selector.shift;

import android.util.Pair;
import java.util.Set;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public interface IGearConfig {
    Pair<Double, Double> getBitrateInterval();

    double getDefaultBitrate();

    String getDefaultGearName();

    Set<String> getGearGroup();
}
