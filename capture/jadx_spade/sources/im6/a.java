package im6;

import com.bytedance.android.bytehook.ByteHook;
import com.bytedance.covode.number.Covode;
import com.bytedance.shadowhook.ShadowHook;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class a {
    static {
        Covode.recordClassIndex(656177);
    }

    public static int a() {
        return ByteHook.init(new ByteHook.c().a());
    }

    public static int b() {
        return ShadowHook.init(new ShadowHook.c().a());
    }
}
