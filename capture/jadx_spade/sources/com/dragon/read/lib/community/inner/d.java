package com.dragon.read.lib.community.inner;

import android.graphics.drawable.Drawable;
import androidx.core.content.ContextCompat;
import com.bytedance.covode.number.Covode;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class d {
    public static final d a;

    static {
        Covode.recordClassIndex(611455);
        a = new d();
    }

    private d() {
    }

    public static final int a(int i) {
        return ContextCompat.getColor(c.a.b().a.c().getAppContext(), i);
    }

    public static final int b(int i) {
        return c.a.b().a.c().getAppContext().getResources().getDimensionPixelSize(i);
    }

    public static final Drawable c(int i) {
        Drawable drawable = ContextCompat.getDrawable(c.a.b().a.c().getAppContext(), i);
        Intrinsics.checkNotNull(drawable);
        return drawable;
    }

    public static final String d(int i) {
        String string = c.a.b().a.c().getAppContext().getString(i);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    public static final String e(int i, Object... formatArgs) {
        Intrinsics.checkNotNullParameter(formatArgs, "formatArgs");
        String string = c.a.b().a.c().getAppContext().getString(i, Arrays.copyOf(formatArgs, formatArgs.length));
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }
}
