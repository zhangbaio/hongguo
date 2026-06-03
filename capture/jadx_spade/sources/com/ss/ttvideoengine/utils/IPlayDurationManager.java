package com.ss.ttvideoengine.utils;

import android.content.Context;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public interface IPlayDurationManager {

    /* renamed from: com.ss.ttvideoengine.utils.IPlayDurationManager$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$release(IPlayDurationManager iPlayDurationManager) {
        }
    }

    void clear();

    int getPlayedDuration();

    long getWiredPlayedDuration();

    long getWirelessPlayedDuration(Context context);

    void release();

    void reset();

    void start();

    void stop();
}
