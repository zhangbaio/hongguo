package com.xiaomi.push;

import com.bytedance.covode.number.Covode;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class ar {
    public int a;

    /* renamed from: a, reason: collision with other field name */
    public String f127a;

    /* renamed from: a, reason: collision with other field name */
    public Map<String, String> f128a = new HashMap();

    static {
        Covode.recordClassIndex(655354);
    }

    public String a() {
        return this.f127a;
    }

    public String toString() {
        return String.format("resCode = %1$d, headers = %2$s, response = %3$s", Integer.valueOf(this.a), this.f128a.toString(), this.f127a);
    }
}
