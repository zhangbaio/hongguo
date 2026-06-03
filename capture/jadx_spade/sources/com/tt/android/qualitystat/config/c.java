package com.tt.android.qualitystat.config;

import android.content.Context;
import com.bytedance.covode.number.Covode;
import com.tt.android.qualitystat.base.QualityStatLog;
import java.util.HashMap;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class c {
    private static StatConfig a;
    public static final c b;

    private c() {
    }

    public final StatConfig c() {
        return a;
    }

    static {
        Covode.recordClassIndex(654037);
        b = new c();
        a = StatConfig.i.c();
    }

    public final boolean a() {
        int C = a.C();
        if (C != 1) {
            if (C != 2) {
                return a.enable();
            }
            return a.enable();
        }
        return d.g.i(a.enable());
    }

    public final a b(sj6.a aVar) {
        StatConfig statConfig = a;
        HashMap<String, a> hashMap = statConfig.e;
        if (hashMap != null) {
            a aVar2 = hashMap.get(aVar.getScene());
            if (aVar2 == null) {
                aVar2 = hashMap.get(sj6.c.e(aVar));
            }
            if (aVar2 == null) {
                aVar2 = hashMap.get(aVar.getMainScene());
            }
            if (aVar2 == null) {
                return a;
            }
            return aVar2;
        }
        return statConfig;
    }

    public final void d(StatConfig statConfig, Context context) {
        StatConfig c;
        if (statConfig != null) {
            c = statConfig;
        } else {
            c = StatConfig.i.c();
        }
        a = c;
        if (context != null) {
            com.tt.android.qualitystat.base.a.b.a(context);
            d.g.g(a.enable());
            b.f.f(statConfig);
            return;
        }
        QualityStatLog.c.h("param context is null in ReportConfig.init");
    }
}
