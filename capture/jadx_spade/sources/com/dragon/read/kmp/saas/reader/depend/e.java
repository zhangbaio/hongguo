package com.dragon.read.kmp.saas.reader.depend;

import android.app.Application;
import android.content.Context;
import com.bytedance.covode.number.Covode;
import com.dragon.read.app.App;
import com.dragon.read.report.PageRecorder;
import dm4.h;
import kotlin.jvm.internal.Intrinsics;
import m25.p0;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class e implements dm4.h {
    public static final e a;

    static {
        Covode.recordClassIndex(608726);
        a = new e();
    }

    private e() {
    }

    @Override // dm4.h
    public void c(String str) {
        h.a.c(this, str);
    }

    @Override // dm4.h
    public void b(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        Application context = App.context();
        Intrinsics.checkNotNullExpressionValue(context, "context(...)");
        p0.b.openUrl(context, url, (PageRecorder) null);
    }

    @Override // dm4.h
    public void a(Context context, String str, boolean z, String str2) {
        p0.b.a(context, str, z, str2);
    }
}
