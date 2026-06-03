package com.tencent.mm.opensdk.diffdev.a;

import com.bytedance.covode.number.Covode;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadAsyncTask;
import com.tencent.mm.opensdk.diffdev.OAuthErrCode;
import com.tencent.mm.opensdk.diffdev.OAuthListener;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
class c extends PthreadAsyncTask<Void, Void, a> {
    private String a;
    private String b;
    private OAuthListener c;
    private int d;

    static class a {
        public OAuthErrCode a;
        public String b;
        public int c;

        static {
            Covode.recordClassIndex(653299);
        }

        a() {
        }
    }

    static {
        Covode.recordClassIndex(653298);
    }

    public c(String str, OAuthListener oAuthListener) {
        this.a = str;
        this.c = oAuthListener;
        this.b = String.format("https://long.open.weixin.qq.com/connect/l/qrconnect?f=json&uuid=%s", str);
    }

    protected void onPostExecute(Object obj) {
        a aVar = (a) obj;
        this.c.onAuthFinish(aVar.a, aVar.b);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:29:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0168 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected java.lang.Object doInBackground(java.lang.Object[] r14) {
        /*
            Method dump skipped, instructions count: 426
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.opensdk.diffdev.a.c.doInBackground(java.lang.Object[]):java.lang.Object");
    }
}
