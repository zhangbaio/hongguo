package com.unionpay;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class h implements Runnable {
    static {
        Covode.recordClassIndex(654856);
    }

    h() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        Handler handler;
        zj6.d dVar;
        Context G;
        Handler handler2;
        Handler handler3;
        Handler handler4;
        Handler handler5;
        try {
            handler = a.W;
            handler.sendEmptyMessageDelayed(1001, 800L);
            dVar = a.V;
            G = a.G();
            zj6.c cVar = new zj6.c(dVar, com.unionpay.utils.b.d(G));
            cVar.b();
            String str = cVar.a;
            handler2 = a.W;
            if (handler2 != null) {
                handler3 = a.W;
                Message obtainMessage = handler3.obtainMessage();
                obtainMessage.what = 1002;
                obtainMessage.obj = str;
                handler4 = a.W;
                handler4.removeMessages(1001);
                handler5 = a.W;
                handler5.sendMessage(obtainMessage);
            }
        } catch (Exception unused) {
        }
    }
}
