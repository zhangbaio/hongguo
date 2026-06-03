package com.dragon.read.kmp.story.impl.feeds.container;

import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.compose.common.load.LoadStatus;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class m<T> {
    public static final int d;
    public final LoadStatus a;
    public final T b;
    public final Throwable c;

    static {
        Covode.recordClassIndex(609260);
        d = 8;
    }

    public final boolean a() {
        if (this.a == LoadStatus.Error && this.c != null) {
            return true;
        }
        return false;
    }

    public final boolean b() {
        if (this.a == LoadStatus.Content && this.b != null) {
            return true;
        }
        return false;
    }

    public m(LoadStatus dataState, T t, Throwable th) {
        Intrinsics.checkNotNullParameter(dataState, "dataState");
        this.a = dataState;
        this.b = t;
        this.c = th;
    }

    public /* synthetic */ m(LoadStatus loadStatus, Object obj, Throwable th, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(loadStatus, (i & 2) != 0 ? null : obj, (i & 4) != 0 ? null : th);
    }
}
