package com.ss.ttm.player;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public abstract class LoadControl extends NativeObject {
    static {
        Covode.recordClassIndex(652119);
    }

    protected abstract int onCodecStackSelected(int i);

    protected abstract int onFilterStackSelected(int i);

    protected abstract int onTrackSelected(int i);

    protected abstract boolean shouldStartPlayback(long j, float f, boolean z);
}
