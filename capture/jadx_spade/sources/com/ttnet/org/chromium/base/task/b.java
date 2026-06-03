package com.ttnet.org.chromium.base.task;

import java.util.concurrent.Callable;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
class b implements Callable<Object> {
    @Override // java.util.concurrent.Callable
    public Object call() throws Exception {
        AsyncTask.b(null).set(true);
        try {
            throw null;
        } finally {
        }
    }
}
