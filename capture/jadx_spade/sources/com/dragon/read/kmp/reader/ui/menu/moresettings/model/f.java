package com.dragon.read.kmp.reader.ui.menu.moresettings.model;

import android.content.Context;
import b35.i0;
import com.bytedance.covode.number.Covode;
import com.dragon.read.reader.ui.ReaderActivity;
import com.dragon.read.reader.ui.ReaderViewLayout;
import com.dragon.reader.lib.ReaderClient;
import com.dragon.reader.lib.support.DefaultFrameController;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class f {
    static {
        Covode.recordClassIndex(608625);
    }

    public static final void a(e eVar, Context context, boolean z) {
        StringBuilder sb;
        ReaderActivity readerActivity;
        DefaultFrameController frameController;
        i0 highlightController;
        Intrinsics.checkNotNullParameter(eVar, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        String b = em4.a.b(null, null, 3, null);
        if (z) {
            sb = new StringBuilder();
            sb.append("已开启");
            sb.append(b);
            b = "展示";
        } else {
            sb = new StringBuilder();
            sb.append("不再展示");
        }
        sb.append(b);
        String sb2 = sb.toString();
        if (context instanceof ReaderActivity) {
            readerActivity = (ReaderActivity) context;
        } else {
            readerActivity = null;
        }
        if (readerActivity != null) {
            ReaderViewLayout readerViewLayout = readerActivity.K;
            if (readerViewLayout != null && (highlightController = readerViewLayout.getHighlightController()) != null) {
                i0.w(highlightController, sb2, false, 2, (Object) null);
            }
            ReaderClient readerClient = readerActivity.getReaderClient();
            if (readerClient != null && (frameController = readerClient.getFrameController()) != null) {
                frameController.g2(new com.dragon.reader.lib.model.d(), new com.dragon.read.reader.model.c());
            }
        }
    }
}
