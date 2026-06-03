package com.ttnet.org.chromium.net.impl;

import android.content.Context;
import com.bytedance.covode.number.Covode;
import com.ttnet.org.chromium.net.c;
import com.ttnet.org.chromium.net.f;
import java.util.Arrays;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class NativeCronetProvider extends com.ttnet.org.chromium.net.d {
    static {
        Covode.recordClassIndex(654643);
    }

    @Override // com.ttnet.org.chromium.net.d
    public String d() {
        return "App-Packaged-Cronet-Provider";
    }

    @Override // com.ttnet.org.chromium.net.d
    public boolean f() {
        return true;
    }

    @Override // com.ttnet.org.chromium.net.d
    public String e() {
        return ImplVersion.a();
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{NativeCronetProvider.class, this.a});
    }

    public NativeCronetProvider(Context context) {
        super(context);
    }

    @Override // com.ttnet.org.chromium.net.d
    public c.a b(boolean z) {
        return new f.a(new r(this.a, z));
    }

    public boolean equals(Object obj) {
        if (obj != this && (!(obj instanceof NativeCronetProvider) || !this.a.equals(((NativeCronetProvider) obj).a))) {
            return false;
        }
        return true;
    }
}
