package com.tt.android.qualitystat.util;

import com.bytedance.covode.number.Covode;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class KotlinExtKt {
    static final /* synthetic */ KProperty[] a;
    private static final Lazy b;

    private static final SimpleDateFormat d() {
        Lazy lazy = b;
        KProperty kProperty = a[0];
        return (SimpleDateFormat) lazy.getValue();
    }

    static {
        Lazy lazy;
        Covode.recordClassIndex(654098);
        a = new KProperty[]{Reflection.property0(new PropertyReference0Impl(Reflection.getOrCreateKotlinPackage(KotlinExtKt.class, "qualitystat_core_release"), "sdf", "getSdf()Ljava/text/SimpleDateFormat;"))};
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<SimpleDateFormat>() { // from class: com.tt.android.qualitystat.util.KotlinExtKt$sdf$2
            @Override // kotlin.jvm.functions.Function0
            public final SimpleDateFormat invoke() {
                return new SimpleDateFormat("HH:mm:ss.SSS", Locale.CHINA);
            }
        });
        b = lazy;
    }

    public static final String c(Long l) {
        if (l == null) {
            return "null";
        }
        String format = d().format(l);
        Intrinsics.checkExpressionValueIsNotNull(format, "sdf.format(ts)");
        return format;
    }

    public static final <T> List<T> f(JSONArray jSONArray) {
        if (jSONArray == null) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            Object opt = jSONArray.opt(i);
            if (!(opt instanceof Object)) {
                opt = null;
            }
            if (opt != null) {
                arrayList.add(opt);
            }
        }
        return CollectionsKt___CollectionsKt.sortedWith(arrayList, new a());
    }

    public static final class a<T> implements Comparator<T> {
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            int compareValues;
            compareValues = ComparisonsKt__ComparisonsKt.compareValues(t.toString(), t2.toString());
            return compareValues;
        }
    }

    public static final <T> T e(JSONObject jSONObject, String str) {
        T t = (T) jSONObject.opt(str);
        if (!(t instanceof Object)) {
            return null;
        }
        return t;
    }

    public static final JSONObject a(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject != null && jSONObject2 != null) {
            Iterator<String> keys = jSONObject2.keys();
            Intrinsics.checkExpressionValueIsNotNull(keys, "json.keys()");
            while (keys.hasNext()) {
                String next = keys.next();
                if (!jSONObject.has(next)) {
                    jSONObject.putOpt(next, jSONObject2.get(next));
                }
            }
        }
        return jSONObject;
    }

    public static final boolean b(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject2 == null) {
            return false;
        }
        Iterator<String> keys = jSONObject2.keys();
        Intrinsics.checkExpressionValueIsNotNull(keys, "js.keys()");
        Boolean bool = null;
        while (keys.hasNext()) {
            String next = keys.next();
            Boolean bool2 = Boolean.FALSE;
            if (!Intrinsics.areEqual(bool, bool2)) {
                Object opt = jSONObject2.opt(next);
                Object opt2 = jSONObject.opt(next);
                if (opt != null && opt2 != null) {
                    if (Intrinsics.areEqual(opt2.getClass(), opt.getClass())) {
                        if ((opt instanceof JSONObject) && (opt2 instanceof JSONObject)) {
                            bool = Boolean.valueOf(b((JSONObject) opt2, (JSONObject) opt));
                        } else {
                            bool = Boolean.valueOf(Intrinsics.areEqual(opt2, opt));
                        }
                    } else {
                        bool = Boolean.valueOf(Intrinsics.areEqual(opt2.toString(), opt.toString()));
                    }
                } else {
                    bool = bool2;
                }
            }
        }
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }
}
