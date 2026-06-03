package com.xiaomi.push;

import android.content.Context;
import com.bytedance.covode.number.Covode;
import com.ss.android.ugc.bytex.taskmonitor.proxy.PThreadPoolExecutorDelegate;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class cw {
    private static ThreadPoolExecutor a;

    public static void a(Context context) {
    }

    static {
        Covode.recordClassIndex(655428);
        a = new PThreadPoolExecutorDelegate(1, 1, 15L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new DefaultThreadFactory("iaomi/push/cw"));
    }
}
