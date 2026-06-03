package com.ttnet.org.chromium.base;

import com.bytedance.covode.number.Covode;

@FunctionalInterface
/* loaded from: D:\code\hongguo\capture\classes16.dex */
public interface Callback<T> {
    void onResult(T t);

    public static abstract class Helper {
        static {
            Covode.recordClassIndex(654162);
        }

        static void runRunnable(Runnable runnable) {
            runnable.run();
        }

        static void onObjectResultFromNative(Callback callback, Object obj) {
            callback.onResult(obj);
        }

        static void onBooleanResultFromNative(Callback callback, boolean z) {
            callback.onResult(Boolean.valueOf(z));
        }

        static void onIntResultFromNative(Callback callback, int i) {
            callback.onResult(Integer.valueOf(i));
        }

        static void onLongResultFromNative(Callback callback, long j) {
            callback.onResult(Long.valueOf(j));
        }

        static void onTimeResultFromNative(Callback callback, long j) {
            callback.onResult(Long.valueOf(j));
        }
    }
}
