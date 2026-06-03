package com.xiaomi.push;

import android.util.Pair;
import com.bytedance.covode.number.Covode;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class dx {
    private static Vector<Pair<String, Long>> a;

    /* renamed from: a, reason: collision with other field name */
    private static ConcurrentHashMap<String, Long> f348a;

    static {
        Covode.recordClassIndex(655473);
        a = new Vector<>();
        f348a = new ConcurrentHashMap<>();
    }

    public static String a() {
        StringBuilder sb = new StringBuilder();
        synchronized (a) {
            for (int i = 0; i < a.size(); i++) {
                Pair<String, Long> elementAt = a.elementAt(i);
                sb.append((String) elementAt.first);
                sb.append(":");
                sb.append(elementAt.second);
                if (i < a.size() - 1) {
                    sb.append(";");
                }
            }
            a.clear();
        }
        return sb.toString();
    }
}
