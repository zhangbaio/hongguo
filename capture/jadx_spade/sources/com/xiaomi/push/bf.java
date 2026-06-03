package com.xiaomi.push;

import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.LinkedHashMap;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class bf extends JSONObject implements bd {
    private static final int a;
    private static final int b;

    /* renamed from: a, reason: collision with other field name */
    private final LinkedHashMap<String, Integer> f140a = new LinkedHashMap<>();

    static {
        Covode.recordClassIndex(655374);
        a = 2;
        b = 3;
    }

    @Override // com.xiaomi.push.bd
    public int a() {
        int i = a;
        Iterator<Integer> it2 = this.f140a.values().iterator();
        while (it2.hasNext()) {
            i += it2.next().intValue();
        }
        return i + (length() - 1);
    }

    @Override // org.json.JSONObject
    public Object remove(String str) {
        this.f140a.remove(str);
        return super.remove(str);
    }

    @Override // org.json.JSONObject
    public JSONObject put(String str, double d) {
        if (!TextUtils.isEmpty(str)) {
            this.f140a.put(str, Integer.valueOf(str.length() + String.valueOf(d).length() + b));
        }
        return super.put(str, d);
    }

    @Override // org.json.JSONObject
    public JSONObject put(String str, int i) {
        if (!TextUtils.isEmpty(str)) {
            this.f140a.put(str, Integer.valueOf(str.length() + String.valueOf(i).length() + b));
        }
        return super.put(str, i);
    }

    @Override // org.json.JSONObject
    public JSONObject put(String str, long j) {
        if (!TextUtils.isEmpty(str)) {
            this.f140a.put(str, Integer.valueOf(str.length() + String.valueOf(j).length() + b));
        }
        return super.put(str, j);
    }

    @Override // org.json.JSONObject
    public JSONObject put(String str, Object obj) {
        JSONObject put = super.put(str, obj);
        if (!TextUtils.isEmpty(str) && obj != null) {
            if (obj instanceof bd) {
                this.f140a.put(str, Integer.valueOf(str.length() + ((bd) obj).a() + b));
            } else {
                this.f140a.put(str, Integer.valueOf(str.length() + String.valueOf(obj).getBytes(StandardCharsets.UTF_8).length + b + a));
            }
        }
        return put;
    }

    @Override // org.json.JSONObject
    public JSONObject put(String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            this.f140a.put(str, Integer.valueOf(str.length() + String.valueOf(z).length() + b));
        }
        return super.put(str, z);
    }
}
