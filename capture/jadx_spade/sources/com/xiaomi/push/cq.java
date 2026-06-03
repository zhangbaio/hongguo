package com.xiaomi.push;

import android.content.Context;
import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class cq implements fc {
    private Context a;

    static {
        Covode.recordClassIndex(655422);
    }

    @Override // com.xiaomi.push.fc
    public void a(ez ezVar) {
    }

    @Override // com.xiaomi.push.fc
    public void a(ez ezVar, Exception exc) {
    }

    public cq(Context context) {
        this.a = context;
    }

    @Override // com.xiaomi.push.fc
    public void b(ez ezVar) {
        cm.m245a(this.a);
    }

    @Override // com.xiaomi.push.fc
    public void a(ez ezVar, int i, Exception exc) {
        cm.a(this.a, ezVar.mo418a(), i);
    }
}
