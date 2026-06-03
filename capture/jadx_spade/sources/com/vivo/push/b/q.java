package com.vivo.push.b;

import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.vivo.push.model.InsideNotificationItem;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class q extends w {
    protected InsideNotificationItem a;
    private String b;

    static {
        Covode.recordClassIndex(654998);
    }

    @Override // com.vivo.push.b.t, com.vivo.push.v
    public final String toString() {
        return "OnNotifyArrivedCommand";
    }

    public final InsideNotificationItem e() {
        return this.a;
    }

    public q() {
        super(4);
    }

    public final boolean g() {
        InsideNotificationItem insideNotificationItem = this.a;
        if (insideNotificationItem != null && insideNotificationItem.isNoShowOnForeground()) {
            return true;
        }
        return false;
    }

    public final String f() {
        if (TextUtils.isEmpty(this.b)) {
            InsideNotificationItem insideNotificationItem = this.a;
            if (insideNotificationItem == null) {
                return null;
            }
            return com.vivo.push.util.u.b(insideNotificationItem);
        }
        return this.b;
    }

    @Override // com.vivo.push.b.w, com.vivo.push.b.t, com.vivo.push.v
    protected final void c(com.vivo.push.d dVar) {
        super.c(dVar);
        String b = com.vivo.push.util.u.b(this.a);
        this.b = b;
        dVar.a("notification_v1", b);
    }

    @Override // com.vivo.push.b.w, com.vivo.push.b.t, com.vivo.push.v
    protected final void d(com.vivo.push.d dVar) {
        super.d(dVar);
        String a = dVar.a("notification_v1");
        this.b = a;
        if (!TextUtils.isEmpty(a)) {
            InsideNotificationItem a2 = com.vivo.push.util.u.a(this.b);
            this.a = a2;
            if (a2 != null) {
                a2.setMsgId(h());
            }
        }
    }
}
