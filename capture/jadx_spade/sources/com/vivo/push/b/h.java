package com.vivo.push.b;

import android.text.TextUtils;
import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class h extends com.vivo.push.v {
    private String a;
    private String b;

    static {
        Covode.recordClassIndex(654989);
    }

    public h() {
        super(2013);
    }

    public h(String str) {
        this();
        this.a = str;
    }

    @Override // com.vivo.push.v
    protected final void c(com.vivo.push.d dVar) {
        dVar.a("MsgArriveCommand.MSG_TAG", this.a);
        if (!TextUtils.isEmpty(this.b)) {
            dVar.a("MsgArriveCommand.NODE_INFO", this.b);
        }
    }

    @Override // com.vivo.push.v
    protected final void d(com.vivo.push.d dVar) {
        this.a = dVar.a("MsgArriveCommand.MSG_TAG");
        this.b = dVar.a("MsgArriveCommand.NODE_INFO");
    }

    public h(String str, String str2) {
        this(str);
        this.b = str2;
    }
}
