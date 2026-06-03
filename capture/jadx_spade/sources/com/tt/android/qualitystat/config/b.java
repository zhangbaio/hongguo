package com.tt.android.qualitystat.config;

import com.bytedance.covode.number.Covode;
import com.tt.android.qualitystat.base.QualityStatLog;
import com.tt.android.qualitystat.config.QualityPreference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Triple;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.reflect.KProperty;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class b {
    static final /* synthetic */ KProperty[] a;
    private static final QualityPreference b;
    private static final QualityPreference c;
    private static final Triple<Long, Boolean, Boolean> d;
    private static final QualityPreference e;
    public static final b f;

    private b() {
    }

    private final JSONObject b() {
        return (JSONObject) b.d(this, a[0]);
    }

    private final ArrayList<Triple<Long, Boolean, Boolean>> c() {
        return (ArrayList) e.d(this, a[2]);
    }

    private final void g(JSONObject jSONObject) {
        b.f(this, a[0], jSONObject);
    }

    private final void h(ArrayList<Triple<Long, Boolean, Boolean>> arrayList) {
        e.f(this, a[2], arrayList);
    }

    public final StatConfig d() {
        if (!QualityPreference.f.e("local_stat_config")) {
            QualityStatLog.c.f("loadQualityStatConfigLocal, sp do not has key: local_stat_config");
            return null;
        }
        JSONObject b2 = b();
        if (b2 == null) {
            return null;
        }
        QualityStatLog.c.a("loadQualityStatConfigLocal, content= " + b2);
        return new StatConfig(b2);
    }

    public final Triple<Long, Boolean, Boolean> a() {
        boolean z;
        ArrayList<Triple<Long, Boolean, Boolean>> c2 = c();
        Object obj = null;
        if (c2 == null || c2.size() <= 0) {
            return null;
        }
        Iterator<T> it2 = c2.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            Object next = it2.next();
            if (((Number) ((Triple) next).getFirst()).longValue() > d.g.d()) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                obj = next;
                break;
            }
        }
        Triple<Long, Boolean, Boolean> triple = (Triple) obj;
        if (triple == null) {
            return c2.get(0);
        }
        return triple;
    }

    static {
        ArrayList arrayListOf;
        Covode.recordClassIndex(654036);
        a = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(b.class), "localQualityStatConfig", "getLocalQualityStatConfig()Lorg/json/JSONObject;")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(b.class), "lastReportSwitchDate", "getLastReportSwitchDate$qualitystat_core_release()Ljava/lang/Long;")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(b.class), "switchChangeHistory", "getSwitchChangeHistory()Ljava/util/ArrayList;"))};
        f = new b();
        QualityPreference.a aVar = QualityPreference.f;
        b = aVar.h("local_stat_config", new JSONObject());
        c = aVar.h("local_last_report_switch_date", 0L);
        Boolean bool = Boolean.FALSE;
        Triple<Long, Boolean, Boolean> triple = new Triple<>(0L, bool, bool);
        d = triple;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(triple);
        e = aVar.h("config_switch_change_history", arrayListOf);
    }

    public final void f(StatConfig statConfig) {
        JSONObject jSONObject;
        if (statConfig == null) {
            QualityPreference.a aVar = QualityPreference.f;
            if (aVar.e("local_stat_config")) {
                aVar.d("local_stat_config");
                QualityStatLog.c.f("saveQualityStatConfigLocal, config= " + statConfig);
            }
        }
        if (statConfig == null || (jSONObject = statConfig.b) == null) {
            if (statConfig != null) {
                jSONObject = statConfig.toJsonObject();
            } else {
                jSONObject = null;
            }
        }
        g(jSONObject);
        QualityStatLog.c.f("saveQualityStatConfigLocal, config= " + statConfig);
    }

    public final void e(boolean z, boolean z2) {
        Object lastOrNull;
        if (z != z2) {
            ArrayList<Triple<Long, Boolean, Boolean>> c2 = c();
            if (c2 == null) {
                c2 = new ArrayList<>();
            }
            c2.add(0, new Triple<>(Long.valueOf(System.currentTimeMillis()), Boolean.valueOf(z), Boolean.valueOf(z2)));
            if (c2.size() > 20 && System.currentTimeMillis() - ((Number) ((Triple) CollectionsKt___CollectionsKt.last((List) c2)).getFirst()).longValue() > 604800000) {
                lastOrNull = CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) c2);
                TypeIntrinsics.asMutableCollection(c2).remove(lastOrNull);
            }
            h(c2);
            QualityStatLog.c.i("onEnableStatusChanged(" + z + " -> " + z2 + ')', "size= " + c2.size() + ", list=" + c2);
        }
    }
}
