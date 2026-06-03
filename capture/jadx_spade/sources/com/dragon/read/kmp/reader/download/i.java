package com.dragon.read.kmp.reader.download;

import android.content.Context;
import com.bytedance.covode.number.Covode;
import com.dragon.reader.lib.ReaderClient;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class i {
    public static final int d;
    private final Context a;
    public final ReaderClient b;
    public final Function1<Boolean, Unit> c;

    static {
        Covode.recordClassIndex(608412);
        d = 8;
    }

    public final Context getContext() {
        return this.a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public i(Context context, ReaderClient readerClient, Function1<? super Boolean, Unit> onAddBookShelfCallback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(readerClient, "readerClient");
        Intrinsics.checkNotNullParameter(onAddBookShelfCallback, "onAddBookShelfCallback");
        this.a = context;
        this.b = readerClient;
        this.c = onAddBookShelfCallback;
    }
}
