package com.xiaomi.push.service;

import com.bytedance.covode.number.Covode;
import com.xiaomi.push.gr;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class au {
    static {
        Covode.recordClassIndex(655695);
    }

    public static gr a(gr grVar) {
        Map<String, String> map;
        if (grVar != null && (map = grVar.f568b) != null) {
            map.remove("score_info");
        }
        return grVar;
    }
}
