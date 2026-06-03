package vl6;

import android.content.Context;
import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class a implements hl6.a {
    private static final a b;
    public hl6.a a;

    private a() {
    }

    public static a a() {
        return b;
    }

    static {
        Covode.recordClassIndex(656046);
        b = new a();
    }

    @Override // hl6.a
    public Context getContext() {
        hl6.a aVar = this.a;
        if (aVar == null) {
            return null;
        }
        return aVar.getContext();
    }
}
