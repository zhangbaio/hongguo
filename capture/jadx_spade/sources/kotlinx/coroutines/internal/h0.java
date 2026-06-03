package kotlinx.coroutines.internal;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final /* synthetic */ class h0 {
    private static final int a;

    public static final int a() {
        return a;
    }

    static {
        Covode.recordClassIndex(659268);
        a = Runtime.getRuntime().availableProcessors();
    }

    public static final String b(String str) {
        try {
            return System.getProperty(str);
        } catch (SecurityException unused) {
            return null;
        }
    }
}
