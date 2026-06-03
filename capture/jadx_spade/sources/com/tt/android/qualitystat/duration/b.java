package com.tt.android.qualitystat.duration;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final /* synthetic */ class b {
    public static final /* synthetic */ int[] a;

    static {
        Covode.recordClassIndex(654087);
        int[] iArr = new int[EventType.values().length];
        a = iArr;
        iArr[EventType.START.ordinal()] = 1;
        iArr[EventType.END.ordinal()] = 2;
        iArr[EventType.CONTINUE.ordinal()] = 3;
    }
}
