package com.dragon.read.openanim;

import android.graphics.drawable.Drawable;
import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public abstract class o {
    public static final int b;
    public final Drawable a;

    static {
        Covode.recordClassIndex(612635);
        b = 8;
    }

    public abstract void a();

    public o(Drawable drawable) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        this.a = drawable;
    }
}
