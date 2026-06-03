package com.ss.ttm.utils;

import com.bytedance.covode.number.Covode;
import com.ss.ttm.player.TTPlayer;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class ConfigImpl extends ConfigAPI {
    private long mHandle;

    private static native long _nativeCopy(long j);

    private static native long _nativeCreate(long j);

    private static native int _nativeGetInt(long j, int i, int i2);

    private static native void _nativeRelease(long j);

    private static native void _nativeSetInt(long j, int i, int i2);

    @Override // com.ss.ttm.utils.ConfigAPI
    long nativeHandle() {
        return this.mHandle;
    }

    static {
        Covode.recordClassIndex(652232);
        TTPlayer.getAppPath();
    }

    @Override // com.ss.ttm.utils.ConfigAPI
    void release() {
        long j = this.mHandle;
        if (j != 0) {
            this.mHandle = 0L;
            _nativeRelease(j);
        }
    }

    static ConfigAPI create(long j, int i) {
        return new ConfigImpl(j, i);
    }

    @Override // com.ss.ttm.utils.ConfigAPI
    int getIntValue(int i, int i2) {
        long j = this.mHandle;
        if (j != 0) {
            return _nativeGetInt(j, i, i2);
        }
        return i2;
    }

    @Override // com.ss.ttm.utils.ConfigAPI
    void setIntValue(int i, int i2) {
        long j = this.mHandle;
        if (j != 0) {
            _nativeSetInt(j, i, i2);
        }
    }

    ConfigImpl(long j, int i) {
        this.mHandle = 0L;
        if (i == 0) {
            this.mHandle = _nativeCreate(j);
        } else if (i == 1) {
            this.mHandle = _nativeCopy(j);
        }
    }
}
