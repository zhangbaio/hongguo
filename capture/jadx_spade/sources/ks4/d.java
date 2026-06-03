package ks4;

import android.content.Context;
import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class d {
    public static final int f;
    private final Context a;
    public int b;
    public String c;
    public String d;
    public int e;

    static {
        Covode.recordClassIndex(612362);
        f = 8;
    }

    public final Context getContext() {
        return this.a;
    }

    public String toString() {
        String str = "parentScene = " + this.b + ", novelBookId = " + this.c + ", audioBookId = " + this.d + ", initReadingTheme = " + this.e;
        Intrinsics.checkNotNullExpressionValue(str, "toString(...)");
        return str;
    }

    public d(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = context;
        this.b = -1;
    }
}
