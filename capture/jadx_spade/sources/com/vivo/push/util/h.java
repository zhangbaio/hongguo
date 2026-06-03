package com.vivo.push.util;

import com.bytedance.covode.number.Covode;
import java.util.concurrent.ThreadFactory;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class h implements ThreadFactory {
    final /* synthetic */ String a;

    static {
        Covode.recordClassIndex(655193);
    }

    h(String str) {
        this.a = str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable);
        thread.setName(this.a);
        thread.setDaemon(true);
        return thread;
    }
}
