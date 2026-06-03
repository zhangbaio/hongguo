package com.dragon.read.kmp.service;

import android.content.Context;
import android.content.Intent;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.utils.AppUtils;
import java.io.File;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class z0 {
    public static final z0 a;

    static {
        Covode.recordClassIndex(608888);
        a = new z0();
    }

    private z0() {
    }

    public final String a() {
        String path = AppUtils.a.a().getFilesDir().getPath();
        Intrinsics.checkNotNullExpressionValue(path, "getPath(...)");
        return path;
    }

    public final Object b(Continuation<? super Long> continuation) {
        long j;
        File externalCacheDir = AppUtils.a.a().getExternalCacheDir();
        if (externalCacheDir != null) {
            j = externalCacheDir.getFreeSpace();
        } else {
            j = 0;
        }
        return Boxing.boxLong(j);
    }

    public final void c(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        LocalBroadcastManager.getInstance(context.getApplicationContext()).sendBroadcast(intent);
    }
}
