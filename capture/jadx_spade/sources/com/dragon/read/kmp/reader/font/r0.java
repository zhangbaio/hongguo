package com.dragon.read.kmp.reader.font;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class r0 implements gk4.f {
    public static final int f;
    public final y0 a;
    private final long b;
    private final MutableState c;
    private final MutableState d;
    private final MutableState e;

    static {
        Covode.recordClassIndex(608434);
        f = 8;
    }

    @Override // gk4.f
    public long a() {
        return this.b;
    }

    public final String b() {
        return (String) this.d.getValue();
    }

    public final boolean c() {
        return ((Boolean) this.c.getValue()).booleanValue();
    }

    public final int d() {
        return ((Number) this.e.getValue()).intValue();
    }

    public final void e(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.d.setValue(str);
    }

    public final void f(boolean z) {
        this.c.setValue(Boolean.valueOf(z));
    }

    public r0(boolean z, String currentFontName, int i, y0 depend, long j) {
        Intrinsics.checkNotNullParameter(currentFontName, "currentFontName");
        Intrinsics.checkNotNullParameter(depend, "depend");
        this.a = depend;
        this.b = j;
        this.c = SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z), (SnapshotMutationPolicy) null, 2, (Object) null);
        this.d = SnapshotStateKt.mutableStateOf$default(currentFontName, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.e = SnapshotStateKt.mutableStateOf$default(Integer.valueOf(i), (SnapshotMutationPolicy) null, 2, (Object) null);
    }
}
