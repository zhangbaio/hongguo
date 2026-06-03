package com.vivo.push.sdk;

import android.content.Intent;
import android.os.Message;
import com.bytedance.covode.number.Covode;
import com.vivo.push.ab;
import com.vivo.push.util.g;
import com.vivo.push.util.t;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class a extends ab {
    private static a c;
    private String d = "";

    static {
        Covode.recordClassIndex(655151);
    }

    private a() {
    }

    public final String b() {
        return this.d;
    }

    public static synchronized a a() {
        a aVar;
        synchronized (a.class) {
            if (c == null) {
                c = new a();
            }
            aVar = c;
        }
        return aVar;
    }

    public final void a(String str) {
        this.d = str;
    }

    public final void a(Intent intent) {
        if (intent != null && this.a != null) {
            Message obtain = Message.obtain();
            obtain.obj = intent;
            a(obtain);
        } else {
            t.d("CommandWorker", " sendMessage error: intent : " + intent + ", mContext: " + this.a);
        }
    }

    @Override // com.vivo.push.ab
    public final void b(Message message) {
        Intent intent = (Intent) message.obj;
        if (intent != null && this.a != null) {
            com.vivo.push.restructure.a.b bVar = new com.vivo.push.restructure.a.b(intent);
            try {
                t.d("CommandWorker", "received msg : ".concat(String.valueOf(bVar.a())));
                g.a().execute(new b(this, bVar));
                return;
            } catch (Exception e) {
                t.a("CommandWorker", "handle message err : " + e.getMessage());
                return;
            }
        }
        t.d("CommandWorker", " handleMessage error: intent : " + intent + ", mContext: " + this.a);
    }
}
