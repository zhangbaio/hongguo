package com.ttnet.org.chromium.net;

import android.accounts.AccountManager;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.bytedance.covode.number.Covode;
import com.ttnet.org.chromium.base.ApplicationStatus;
import com.ttnet.org.chromium.base.annotations.JNINamespace;

@JNINamespace("net::android")
/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class HttpNegotiateAuthenticator {
    private Bundle a;
    private final String b;

    static class a {
        public long a;
        public AccountManager b;
        public Bundle c;
        public String d;

        static {
            Covode.recordClassIndex(654465);
        }

        a() {
        }
    }

    private void a(Context context, Activity activity, a aVar, String[] strArr) {
    }

    private void b(Context context, a aVar, String[] strArr) {
    }

    static {
        Covode.recordClassIndex(654461);
    }

    protected HttpNegotiateAuthenticator(String str) {
        this.b = str;
    }

    static HttpNegotiateAuthenticator create(String str) {
        return new HttpNegotiateAuthenticator(str);
    }

    void getNextAuthToken(long j, String str, String str2, boolean z) {
        Context f = com.ttnet.org.chromium.base.c.f();
        a aVar = new a();
        aVar.d = "SPNEGO:HOSTBASED:" + str;
        aVar.b = AccountManager.get(f);
        aVar.a = j;
        String[] strArr = {"SPNEGO"};
        Bundle bundle = new Bundle();
        aVar.c = bundle;
        if (str2 != null) {
            bundle.putString("incomingAuthToken", str2);
        }
        Bundle bundle2 = this.a;
        if (bundle2 != null) {
            aVar.c.putBundle("spnegoContext", bundle2);
        }
        aVar.c.putBoolean("canDelegate", z);
        Activity c = ApplicationStatus.c();
        if (c == null) {
            b(f, aVar, strArr);
        } else {
            a(f, c, aVar, strArr);
        }
    }
}
