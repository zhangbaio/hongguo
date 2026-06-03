package com.ss.ttm.player;

import com.bytedance.covode.number.Covode;
import com.ss.vcbkit.UnExpected;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class TraitObject {
    private long mNativeObj;
    private long mRecycleObj;
    private ReleaseNativeTrait mReleaseFunc;
    private final int mType;
    private final int mVersion;

    public interface ReleaseNativeTrait {
        void releaseNativeTrait(long j);
    }

    @Retention(RetentionPolicy.CLASS)
    public @interface Type {
    }

    static {
        Covode.recordClassIndex(652208);
    }

    private static native void _nativeRelease(long j);

    private static native void _nativeUnref(long j);

    private long getRecycleObj() {
        return this.mRecycleObj;
    }

    protected void finalize() {
        release();
    }

    public final int type() {
        return this.mType;
    }

    public final int version() {
        return this.mVersion;
    }

    private long takeNativeObj() {
        long j = this.mNativeObj;
        this.mNativeObj = 0L;
        return j;
    }

    private void releaseRecycleObj() {
        long j = this.mRecycleObj;
        this.mRecycleObj = 0L;
        if (j != 0) {
            _nativeUnref(j);
        }
    }

    public final void release() {
        long takeNativeObj = takeNativeObj();
        if (takeNativeObj != 0) {
            try {
                _nativeRelease(takeNativeObj);
            } catch (UnsatisfiedLinkError unused) {
                if (this.mReleaseFunc != null) {
                    this.mReleaseFunc.releaseNativeTrait(takeNativeObj);
                } else {
                    UnExpected.b(new Throwable("MemLeak"), "NativeTrait");
                }
            }
        }
        releaseRecycleObj();
    }

    public final void setReleaseFunc(ReleaseNativeTrait releaseNativeTrait) {
        this.mReleaseFunc = releaseNativeTrait;
    }

    private void setRecycleObj(long j) {
        releaseRecycleObj();
        this.mRecycleObj = j;
    }

    public boolean sameAs(TraitObject traitObject) {
        if (traitObject == null) {
            return false;
        }
        return equals(traitObject);
    }

    public TraitObject(int i, long j) {
        this.mReleaseFunc = null;
        this.mType = i;
        this.mVersion = -1;
        this.mNativeObj = j;
        this.mRecycleObj = 0L;
    }

    public TraitObject(int i, int i2, long j) {
        this.mReleaseFunc = null;
        this.mType = i;
        this.mVersion = i2;
        this.mNativeObj = 0L;
        this.mRecycleObj = 0L;
    }
}
