package com.tt.android.qualitystat.util;

import com.bytedance.covode.number.Covode;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class b {
    private static Executor a;
    private static boolean b;
    public static final b c;

    private b() {
    }

    static {
        Covode.recordClassIndex(654100);
        c = new b();
        ExecutorService newSingleThreadExecutor = PThreadExecutorsUtils.newSingleThreadExecutor(new DefaultThreadFactory("l/ThreadProxy"), "com.tt.android.qualitystat.util.ThreadProxy");
        Intrinsics.checkExpressionValueIsNotNull(newSingleThreadExecutor, "Executors.newSingleThreadExecutor()");
        a = newSingleThreadExecutor;
    }

    public final void a(Function0<Unit> function0) {
        if (b) {
            function0.invoke();
        } else {
            a.execute(new a(function0));
        }
    }
}
