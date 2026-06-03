package com.tt.android.qualitystat.base;

import com.bytedance.apm.ApmAgent;
import com.bytedance.covode.number.Covode;
import com.ss.android.common.lib.AppLogNewUtils;
import com.tt.android.qualitystat.UserStatAgent;
import com.tt.android.qualitystat.base.QualityReportWrapper$defaultReportDelegate$2;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.json.JSONObject;
import tj6.k;
import tj6.m;
import uj6.f;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class QualityReportWrapper {
    static final /* synthetic */ KProperty[] a;
    private static final Lazy b;
    public static final QualityReportWrapper c;

    private QualityReportWrapper() {
    }

    private final f c() {
        Lazy lazy = b;
        KProperty kProperty = a[0];
        return (f) lazy.getValue();
    }

    private final f d() {
        f h = UserStatAgent.g.h();
        if (h == null) {
            return c();
        }
        return h;
    }

    static {
        Lazy lazy;
        Covode.recordClassIndex(654029);
        a = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(QualityReportWrapper.class), "defaultReportDelegate", "getDefaultReportDelegate()Lcom/tt/android/qualitystat/interceptor/IReportDelegate;"))};
        c = new QualityReportWrapper();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<QualityReportWrapper$defaultReportDelegate$2.a>() { // from class: com.tt.android.qualitystat.base.QualityReportWrapper$defaultReportDelegate$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final a invoke() {
                return new a();
            }

            public static final class a implements f {
                a() {
                }

                @Override // uj6.a
                public void a(String str, JSONObject jSONObject) {
                    QualityStatLog.c.f("*** ReportToTEA, serviceName=" + str + ", params=" + jSONObject);
                    AppLogNewUtils.onEventV3(str, jSONObject);
                }

                @Override // uj6.b
                public void b(String str, JSONObject jSONObject) {
                    QualityStatLog.c.f("*** ReportToSlardar, logType=" + str + ", params=" + jSONObject);
                    ApmAgent.monitorCommonLog(str, jSONObject);
                }
            }
        });
        b = lazy;
    }

    public final void a(k kVar) {
        if (!com.tt.android.qualitystat.config.c.b.a() && !kVar.b) {
            QualityStatLog.c.h("*** doReportByConfig, drop event!");
        } else {
            b(kVar);
        }
    }

    private final void b(k kVar) {
        sj6.b scene = kVar.a.getScene();
        com.tt.android.qualitystat.config.c cVar = com.tt.android.qualitystat.config.c.b;
        if (cVar.b(scene).m()) {
            m b2 = kVar.b();
            d().b(b2.a, b2.b);
        }
        if (cVar.b(scene).q()) {
            tj6.a a2 = kVar.a();
            d().a(a2.a, a2.b);
        }
    }
}
