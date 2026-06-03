package com.xiaomi.push;

import com.bytedance.covode.number.Covode;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class eg implements ee {
    private ee a;

    static {
        Covode.recordClassIndex(655484);
    }

    private static class a {
        private static eg a;

        static {
            Covode.recordClassIndex(655485);
            a = new eg();
        }
    }

    private eg() {
    }

    public static eg a() {
        return a.a;
    }

    @Override // com.xiaomi.push.ee
    public void a(ed edVar) {
        ee eeVar = this.a;
        if (eeVar != null) {
            eeVar.a(edVar);
        }
    }

    @Override // com.xiaomi.push.ee
    public void a(String str, Map<String, Object> map) {
        ee eeVar = this.a;
        if (eeVar != null) {
            eeVar.a(str, map);
        }
    }
}
