package com.dragon.read.kmp.reader.utils;

import android.content.Context;
import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.utils.n0;
import com.dragon.read.reader.utils.ReaderBundleBuilder;
import java.io.Serializable;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class o {
    public static final int b;
    private final ReaderBundleBuilder a;

    static {
        Covode.recordClassIndex(608660);
        b = 8;
    }

    public final void a() {
        this.a.openReader();
    }

    public final o b(String str) {
        this.a.setChapterId(str);
        return this;
    }

    public final o c(boolean z) {
        this.a.setCheckBookStatus(z);
        return this;
    }

    public final o d(int i) {
        this.a.setEnterAnim(i);
        return this;
    }

    public final o f(String str) {
        this.a.setGenreType(str);
        return this;
    }

    public final o g(boolean z) {
        this.a.setIgnoreSlideStart(z);
        return this;
    }

    public final o h(boolean z) {
        this.a.setIsSimpleReader(z);
        return this;
    }

    public final o j(String str) {
        this.a.setSource(str);
        return this;
    }

    public final o i(ym4.k pageRecorder) {
        Intrinsics.checkNotNullParameter(pageRecorder, "pageRecorder");
        this.a.setPageRecoder(n0.c(pageRecorder));
        return this;
    }

    public final o e(String key, Object obj) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (obj instanceof Serializable) {
            this.a.setExtra(key, (Serializable) obj);
        }
        return this;
    }

    public o(Context context, String str, String str2, String str3) {
        this.a = new ReaderBundleBuilder(context, str, str2, str3);
    }
}
