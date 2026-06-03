package com.tencent.open.a;

import com.bytedance.covode.number.Covode;
import java.io.IOException;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
class d implements g {
    private Response a;
    private String b = null;
    private int c;
    private int d;
    private int e;

    static {
        Covode.recordClassIndex(653502);
    }

    @Override // com.tencent.open.a.g
    public int b() {
        return this.e;
    }

    @Override // com.tencent.open.a.g
    public int c() {
        return this.d;
    }

    @Override // com.tencent.open.a.g
    public int d() {
        return this.c;
    }

    @Override // com.tencent.open.a.g
    public String a() throws IOException {
        if (this.b == null) {
            ResponseBody body = this.a.body();
            if (body != null) {
                this.b = body.string();
            }
            if (this.b == null) {
                this.b = "";
            }
        }
        return this.b;
    }

    public String toString() {
        return getClass().getSimpleName() + '@' + hashCode() + this.b + this.c + this.d + this.e;
    }

    d(Response response, int i) {
        this.a = response;
        this.d = i;
        this.c = response.code();
        ResponseBody body = this.a.body();
        if (body != null) {
            this.e = (int) body.contentLength();
        } else {
            this.e = 0;
        }
    }
}
