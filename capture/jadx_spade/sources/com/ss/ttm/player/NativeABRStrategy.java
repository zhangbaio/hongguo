package com.ss.ttm.player;

import android.util.AndroidRuntimeException;
import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class NativeABRStrategy extends ABRStrategy {
    static {
        Covode.recordClassIndex(652143);
    }

    public static boolean isNativeABRStrategy(ABRStrategy aBRStrategy) {
        return aBRStrategy instanceof NativeABRStrategy;
    }

    public NativeABRStrategy(long j) {
        setWeakNativeObj(j);
    }

    @Override // com.ss.ttm.player.ABRStrategy
    protected int probeBitrate(int i) {
        throw new AndroidRuntimeException("Should not be here");
    }

    @Override // com.ss.ttm.player.ABRStrategy
    protected String probeBitrate(String str) {
        throw new AndroidRuntimeException("Should not be here");
    }
}
