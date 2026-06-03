package fk6;

import com.bytedance.covode.number.Covode;
import com.xiaomi.mipush.sdk.PushMessageReceiver;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class a {
    private static volatile a b;
    public PushMessageReceiver a;

    static {
        Covode.recordClassIndex(655768);
    }

    private a() {
    }

    public static a a() {
        if (b == null) {
            synchronized (a.class) {
                if (b == null) {
                    b = new a();
                }
            }
        }
        return b;
    }
}
