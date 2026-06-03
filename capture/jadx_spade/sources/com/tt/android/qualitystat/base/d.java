package com.tt.android.qualitystat.base;

import com.bytedance.covode.number.Covode;
import com.tt.android.qualitystat.UserStatAgent;
import com.tt.android.qualitystat.constants.SystemScene;
import com.tt.android.qualitystat.util.KotlinExtKt;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.json.JSONObject;
import tj6.e;
import tj6.g;
import tj6.k;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class d {
    private static e a;
    private static final CopyOnWriteArrayList<g> b;
    public static final d c;

    private d() {
    }

    static {
        Covode.recordClassIndex(654028);
        c = new d();
        b = new CopyOnWriteArrayList<>();
    }

    public final void a() {
        QualityStatLog qualityStatLog = QualityStatLog.c;
        StringBuilder sb = new StringBuilder();
        sb.append("** flush Cached Report Event, cached event size = ");
        CopyOnWriteArrayList<g> copyOnWriteArrayList = b;
        sb.append(copyOnWriteArrayList.size());
        qualityStatLog.f(sb.toString());
        for (g it2 : copyOnWriteArrayList) {
            d dVar = c;
            Intrinsics.checkExpressionValueIsNotNull(it2, "it");
            dVar.e(it2);
        }
        b.clear();
    }

    public final void g(e eVar) {
        a = eVar;
    }

    public final void d(g gVar) {
        if (UserStatAgent.g.f().get()) {
            e(gVar);
            return;
        }
        CopyOnWriteArrayList<g> copyOnWriteArrayList = b;
        if (copyOnWriteArrayList.size() < 50) {
            copyOnWriteArrayList.add(gVar);
            QualityStatLog.c.f("** report, add to cache list,  current cache size = " + copyOnWriteArrayList.size());
            return;
        }
        QualityStatLog.c.c("** report, cached event size is more than 50 , do not cache!");
    }

    private final void b(g gVar) {
        Object obj;
        JSONObject jsonObject = gVar.k().toJsonObject();
        List<? extends Pair<? extends JSONObject, ? extends JSONObject>> list = com.tt.android.qualitystat.config.c.b.c().f;
        if (list != null) {
            Iterator<T> it2 = list.iterator();
            while (true) {
                if (it2.hasNext()) {
                    obj = it2.next();
                    if (KotlinExtKt.b(jsonObject, (JSONObject) ((Pair) obj).getFirst())) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            Pair pair = (Pair) obj;
            if (pair != null) {
                QualityStatLog.c.h("param_convertor: " + ((JSONObject) pair.getFirst()) + " -> " + ((JSONObject) pair.getSecond()));
                gVar.C((JSONObject) pair.getSecond());
                gVar.b("processor", "param_convertor");
            }
        }
    }

    private final boolean h(e eVar) {
        if (eVar.getDataType() <= -100) {
            QualityStatLog.c.i("QualityReportHelper", "NOT report: dataType= " + eVar.getDataType() + ", param= " + eVar);
            return false;
        }
        if (eVar.getDataType() <= -1) {
            QualityStatLog.c.i("QualityReportHelper", "report but NOT STAT: dataType= " + eVar.getDataType());
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x006a, code lost:
    
        throw new kotlin.TypeCastException("null cannot be cast to non-null type com.tt.android.qualitystat.interceptor.IQualityEventInterceptor");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void e(tj6.g r7) {
        /*
            r6 = this;
            com.tt.android.qualitystat.base.QualityStatLog r0 = com.tt.android.qualitystat.base.QualityStatLog.c
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "param="
            r1.append(r2)
            r1.append(r7)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "** reportQualityEvent"
            r0.g(r2, r1)
            com.tt.android.qualitystat.UserStatAgent r0 = com.tt.android.qualitystat.UserStatAgent.g
            java.util.concurrent.ConcurrentHashMap r1 = r0.c()
            r7.c(r1)
            r6.c(r7)
            r6.b(r7)
            tj6.e r7 = r7.k()
            com.tt.android.qualitystat.base.d.a = r7
            boolean r1 = r6.h(r7)
            if (r1 == 0) goto L8a
            r1 = 0
            r2 = 2
            r3 = 0
            java.util.concurrent.ConcurrentHashMap r0 = r0.e()     // Catch: java.lang.Throwable -> L7b
            java.lang.Class<uj6.d> r4 = uj6.d.class
            java.lang.Object r0 = r0.get(r4)     // Catch: java.lang.Throwable -> L7b
            java.util.LinkedHashSet r0 = (java.util.LinkedHashSet) r0     // Catch: java.lang.Throwable -> L7b
            if (r0 == 0) goto L6d
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> L7b
        L48:
            r4 = 0
        L49:
            boolean r5 = r0.hasNext()     // Catch: java.lang.Throwable -> L6b
            if (r5 == 0) goto L6e
            java.lang.Object r5 = r0.next()     // Catch: java.lang.Throwable -> L6b
            uj6.e r5 = (uj6.e) r5     // Catch: java.lang.Throwable -> L6b
            if (r5 == 0) goto L63
            uj6.d r5 = (uj6.d) r5     // Catch: java.lang.Throwable -> L6b
            boolean r5 = r5.a(r7)     // Catch: java.lang.Throwable -> L6b
            if (r5 != 0) goto L61
            if (r4 == 0) goto L48
        L61:
            r4 = 1
            goto L49
        L63:
            kotlin.TypeCastException r0 = new kotlin.TypeCastException     // Catch: java.lang.Throwable -> L6b
            java.lang.String r5 = "null cannot be cast to non-null type com.tt.android.qualitystat.interceptor.IQualityEventInterceptor"
            r0.<init>(r5)     // Catch: java.lang.Throwable -> L6b
            throw r0     // Catch: java.lang.Throwable -> L6b
        L6b:
            r0 = move-exception
            goto L7d
        L6d:
            r4 = 0
        L6e:
            if (r4 != 0) goto L8a
            com.tt.android.qualitystat.base.QualityReportWrapper r0 = com.tt.android.qualitystat.base.QualityReportWrapper.c
            tj6.k r4 = new tj6.k
            r4.<init>(r7, r3, r2, r1)
            r0.a(r4)
            goto L8a
        L7b:
            r0 = move-exception
            r4 = 0
        L7d:
            if (r4 != 0) goto L89
            com.tt.android.qualitystat.base.QualityReportWrapper r4 = com.tt.android.qualitystat.base.QualityReportWrapper.c
            tj6.k r5 = new tj6.k
            r5.<init>(r7, r3, r2, r1)
            r4.a(r5)
        L89:
            throw r0
        L8a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tt.android.qualitystat.base.d.e(tj6.g):void");
    }

    public final void f(boolean z) {
        g l = new g().D(sj6.c.b(SystemScene.Event, "switch_change")).s("internal_event").l(-11);
        StringBuilder sb = new StringBuilder();
        sb.append("switch_change:");
        com.tt.android.qualitystat.config.d dVar = com.tt.android.qualitystat.config.d.g;
        sb.append(dVar.e());
        g o = l.m(sb.toString()).p("switch_change").o(dVar.e());
        com.tt.android.qualitystat.config.c cVar = com.tt.android.qualitystat.config.c.b;
        g b2 = o.b("report_enable", Boolean.valueOf(cVar.a())).b("report_enable_config", Boolean.valueOf(cVar.c().enable())).b("report_enable_now", Boolean.valueOf(dVar.i(cVar.c().enable()))).b("match_mode", Integer.valueOf(cVar.c().z())).b("effect_mode", Integer.valueOf(cVar.c().C()));
        QualityStatLog.c.g("** reportMonitorSwitch", " content = " + b2);
        QualityReportWrapper.c.a(new k(b2.k(), z));
    }

    private final void c(g gVar) {
        e k = gVar.k();
        sj6.b scene = k.getScene();
        if (k.getDataType() < 0) {
            return;
        }
        com.tt.android.qualitystat.config.c cVar = com.tt.android.qualitystat.config.c.b;
        if (Intrinsics.areEqual(cVar.b(scene).getEnable(), Boolean.FALSE)) {
            QualityStatLog.c.h("match enable black list:" + k);
            gVar.l(-103);
            gVar.b("processor", "scene_disable");
            return;
        }
        if (!cVar.a() && cVar.b(scene).enable()) {
            gVar.l(-2);
            gVar.b("processor", "event_downgrade");
            return;
        }
        if (Intrinsics.areEqual(k.v(), "direct_report")) {
            if (k.getStatus() == 1) {
                if (b.b.a("error", gVar.w(), cVar.b(scene).i())) {
                    gVar.l(-26);
                    gVar.b("processor", "duplicate_error");
                    return;
                }
            }
            int y = cVar.b(scene).y();
            if (y > 0) {
                if (b.b.a("quality_event", gVar.w(), y)) {
                    gVar.l(-24);
                    gVar.b("processor", "frequency_control");
                    return;
                }
            }
        }
        int duration = k.getDuration();
        if (duration > 0) {
            com.tt.android.qualitystat.config.a b2 = cVar.b(scene);
            if (duration < b2.p()) {
                gVar.l(-21);
                gVar.b("processor", "duration_too_short");
                return;
            } else if (duration > b2.l()) {
                gVar.l(-22);
                gVar.b("processor", "duration_too_long");
                return;
            }
        } else if (duration < 0) {
            gVar.l(-21);
            gVar.b("processor", "duration_below_zero");
            return;
        }
        if (StringsKt__StringsJVMKt.endsWith$default(scene.getMainScene(), "_V2", false, 2, null)) {
            gVar.l(-6);
            gVar.b("processor", "v2_event");
            if (duration > 60000) {
                gVar.l(-22);
                gVar.b("processor", "duration_larger_than_60000");
            }
        }
    }
}
