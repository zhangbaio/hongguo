package com.dragon.read.kmp.utils;

import com.bytedance.covode.number.Covode;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public abstract class a<T> {
    static {
        Covode.recordClassIndex(609520);
    }

    private a() {
    }

    public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final void a(Function1<? super Throwable, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        if (this instanceof t) {
            block.invoke(((t) this).a);
        }
    }

    public final void b(Function1<? super T, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        if (this instanceof u0) {
            block.invoke((Object) ((u0) this).c());
        }
    }
}
