package com.vivo.push.b;

import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.vivo.push.model.UnvarnishedMessage;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class o extends w {
    protected UnvarnishedMessage a;

    static {
        Covode.recordClassIndex(654996);
    }

    @Override // com.vivo.push.b.t, com.vivo.push.v
    public final String toString() {
        return "OnMessageCommand";
    }

    public final UnvarnishedMessage f() {
        return this.a;
    }

    public o() {
        super(3);
    }

    public final String e() {
        UnvarnishedMessage unvarnishedMessage = this.a;
        if (unvarnishedMessage == null) {
            return null;
        }
        return unvarnishedMessage.unpackToJson();
    }

    @Override // com.vivo.push.b.w, com.vivo.push.b.t, com.vivo.push.v
    protected final void c(com.vivo.push.d dVar) {
        super.c(dVar);
        dVar.a("msg_v1", this.a.unpackToJson());
    }

    @Override // com.vivo.push.b.w, com.vivo.push.b.t, com.vivo.push.v
    protected final void d(com.vivo.push.d dVar) {
        super.d(dVar);
        String a = dVar.a("msg_v1");
        if (!TextUtils.isEmpty(a)) {
            UnvarnishedMessage unvarnishedMessage = new UnvarnishedMessage(a);
            this.a = unvarnishedMessage;
            unvarnishedMessage.setMsgId(h());
            this.a.setTransmissionMessageEventType(dVar.b("transmission_message_event_type", 0));
        }
    }
}
