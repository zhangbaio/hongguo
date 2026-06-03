package com.vivo.push.b;

import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import java.util.HashMap;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class y extends com.vivo.push.v {
    private HashMap<String, String> a;
    private long b;

    static {
        Covode.recordClassIndex(655006);
    }

    public y() {
        super(2012);
    }

    @Override // com.vivo.push.v
    public final String toString() {
        return "ReporterCommand（" + this.b + ")";
    }

    public final void e() {
        if (this.a == null) {
            com.vivo.push.util.t.d("ReporterCommand", "reportParams is empty");
            return;
        }
        StringBuilder sb = new StringBuilder("report message reportType:");
        sb.append(this.b);
        sb.append(",msgId:");
        String str = this.a.get("messageID");
        if (TextUtils.isEmpty(str)) {
            str = this.a.get("message_id");
        }
        sb.append(str);
        com.vivo.push.util.t.d("ReporterCommand", sb.toString());
    }

    public final void a(HashMap<String, String> hashMap) {
        this.a = hashMap;
    }

    public y(long j) {
        this();
        this.b = j;
    }

    @Override // com.vivo.push.v
    public final void c(com.vivo.push.d dVar) {
        dVar.a("ReporterCommand.EXTRA_PARAMS", this.a);
        dVar.a("ReporterCommand.EXTRA_REPORTER_TYPE", this.b);
    }

    @Override // com.vivo.push.v
    public final void d(com.vivo.push.d dVar) {
        this.a = (HashMap) dVar.d("ReporterCommand.EXTRA_PARAMS");
        this.b = dVar.b("ReporterCommand.EXTRA_REPORTER_TYPE", this.b);
    }
}
