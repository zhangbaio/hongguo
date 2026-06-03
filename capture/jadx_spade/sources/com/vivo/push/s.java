package com.vivo.push;

import android.content.Context;
import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public abstract class s implements Runnable {
    protected Context a;
    private int b;
    private v c;

    static {
        Covode.recordClassIndex(655147);
    }

    protected abstract void a(v vVar);

    public final int a() {
        return this.b;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context = this.a;
        if (context != null && !(this.c instanceof com.vivo.push.b.n)) {
            com.vivo.push.util.t.a(context, "[执行指令]" + this.c);
        }
        a(this.c);
    }

    public String toString() {
        String vVar;
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("{");
        v vVar2 = this.c;
        if (vVar2 == null) {
            vVar = "[null]";
        } else {
            vVar = vVar2.toString();
        }
        sb.append(vVar);
        sb.append("}");
        return sb.toString();
    }

    public s(v vVar) {
        this.b = -1;
        this.c = vVar;
        int b = vVar.b();
        this.b = b;
        if (b >= 0) {
            this.a = m.a().h();
            return;
        }
        throw new IllegalArgumentException("PushTask need a > 0 task id.");
    }
}
