package com.xiaomi.mipush.sdk;

import android.text.TextUtils;
import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
class n {
    int a = 0;

    /* renamed from: a, reason: collision with other field name */
    String f60a = "";

    static {
        Covode.recordClassIndex(655314);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof n)) {
            n nVar = (n) obj;
            if (!TextUtils.isEmpty(nVar.f60a) && nVar.f60a.equals(this.f60a)) {
                return true;
            }
            return false;
        }
        return false;
    }
}
