package com.tencent.open.b;

import android.os.Bundle;
import com.bytedance.covode.number.Covode;
import java.io.Serializable;
import java.util.HashMap;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class c implements Serializable {
    public final HashMap<String, String> a;

    static {
        Covode.recordClassIndex(653515);
    }

    public String toString() {
        return "BaseData{time=" + this.a.get("time") + ", name=" + this.a.get("interface_name") + '}';
    }

    public c(HashMap<String, String> hashMap) {
        this.a = new HashMap<>(hashMap);
    }

    public c(Bundle bundle) {
        this.a = new HashMap<>();
        if (bundle != null) {
            for (String str : bundle.keySet()) {
                this.a.put(str, bundle.getString(str));
            }
        }
    }
}
