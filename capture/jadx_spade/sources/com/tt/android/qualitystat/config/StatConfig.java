package com.tt.android.qualitystat.config;

import com.bytedance.covode.number.Covode;
import com.tt.android.qualitystat.base.QualityStatLog;
import com.tt.android.qualitystat.config.a;
import com.tt.android.qualitystat.util.KotlinExtKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.text.StringsKt__StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class StatConfig implements com.tt.android.qualitystat.config.a, tj6.b {
    private static final StatConfig h;
    public static final a i;
    public JSONObject b;
    public final Integer c;
    public final Integer d;
    public final HashMap<String, com.tt.android.qualitystat.config.a> e;
    public List<? extends Pair<? extends JSONObject, ? extends JSONObject>> f;
    public final com.tt.android.qualitystat.config.a g;

    public static final class Builder {
        public JSONObject a;
        public String b;
        public Boolean c;
        public Boolean d;
        public Boolean e;
        public Integer f;
        public Integer g;
        public Integer h;
        public Integer i;
        public Integer j;
        public Integer k;
        public Integer l;
        public com.tt.android.qualitystat.config.a m;
        public Integer n;
        public Integer o;
        public HashMap<String, com.tt.android.qualitystat.config.a> p;
        public final ArrayList<Pair<JSONObject, JSONObject>> q = new ArrayList<>();

        static {
            Covode.recordClassIndex(654040);
        }

        public static final class a implements com.tt.android.qualitystat.config.a {
            private final String b;
            private final Boolean c;
            private final Integer d;
            private final Integer e;
            private final Boolean f;
            private final Boolean g;
            private final Integer h;
            private final Integer i;
            private final Integer j;
            private final Integer k;
            private final Integer l;
            private com.tt.android.qualitystat.config.a m;

            @Override // com.tt.android.qualitystat.config.a
            public Integer b() {
                return this.i;
            }

            @Override // com.tt.android.qualitystat.config.a
            public Integer e() {
                return this.h;
            }

            @Override // com.tt.android.qualitystat.config.a
            public Integer g() {
                return this.k;
            }

            @Override // com.tt.android.qualitystat.config.a
            public Boolean getEnable() {
                return this.c;
            }

            @Override // com.tt.android.qualitystat.config.a
            public com.tt.android.qualitystat.config.a getFallback() {
                return this.m;
            }

            @Override // com.tt.android.qualitystat.config.a
            public String getScene() {
                return this.b;
            }

            @Override // com.tt.android.qualitystat.config.a
            public Integer h() {
                return this.l;
            }

            @Override // com.tt.android.qualitystat.config.a
            public Boolean k() {
                return this.g;
            }

            @Override // com.tt.android.qualitystat.config.a
            public Integer o() {
                return this.d;
            }

            @Override // com.tt.android.qualitystat.config.a
            public Boolean r() {
                return this.f;
            }

            @Override // com.tt.android.qualitystat.config.a
            public Integer s() {
                return this.j;
            }

            @Override // com.tt.android.qualitystat.config.a
            public Integer w() {
                return this.e;
            }

            @Override // com.tt.android.qualitystat.config.a
            public int c() {
                return a.b.k(this);
            }

            @Override // com.tt.android.qualitystat.config.a
            public boolean enable() {
                return a.b.a(this);
            }

            @Override // com.tt.android.qualitystat.config.a
            public int i() {
                return a.b.c(this);
            }

            @Override // com.tt.android.qualitystat.config.a
            public int l() {
                return a.b.g(this);
            }

            @Override // com.tt.android.qualitystat.config.a
            public boolean m() {
                return a.b.i(this);
            }

            @Override // com.tt.android.qualitystat.config.a
            public int p() {
                return a.b.h(this);
            }

            @Override // com.tt.android.qualitystat.config.a
            public boolean q() {
                return a.b.j(this);
            }

            @Override // com.tt.android.qualitystat.config.a
            public int t() {
                return a.b.b(this);
            }

            @Override // com.tt.android.qualitystat.config.a, tj6.b
            public JSONObject toJsonObject() {
                return a.b.l(this);
            }

            @Override // com.tt.android.qualitystat.config.a
            public int y() {
                return a.b.e(this);
            }

            @Override // com.tt.android.qualitystat.config.a
            public int z() {
                return a.b.f(this);
            }

            @Override // com.tt.android.qualitystat.config.a
            public void x(com.tt.android.qualitystat.config.a aVar) {
                this.m = aVar;
            }

            a() {
                this.b = Builder.this.b;
                this.c = Builder.this.c;
                this.d = Builder.this.j;
                this.e = Builder.this.k;
                this.f = Builder.this.d;
                this.g = Builder.this.e;
                this.h = Builder.this.f;
                this.i = Builder.this.g;
                this.j = Builder.this.h;
                this.k = Builder.this.i;
                this.l = Builder.this.l;
                this.m = Builder.this.m;
            }
        }

        public final StatConfig e() {
            this.m = StatConfig.i.c();
            return new StatConfig(this, null);
        }

        public final com.tt.android.qualitystat.config.a f() {
            this.m = null;
            return new a();
        }

        public final Builder c(Set<String> set) {
            return d(set, new Function2<JSONObject, JSONObject, Unit>() { // from class: com.tt.android.qualitystat.config.StatConfig$Builder$blackList$1
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(JSONObject jSONObject, JSONObject jSONObject2) {
                    jSONObject2.put("data_type", -33);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(JSONObject jSONObject, JSONObject jSONObject2) {
                    invoke2(jSONObject, jSONObject2);
                    return Unit.INSTANCE;
                }
            });
        }

        public final Builder g(Set<String> set) {
            return d(set, new Function2<JSONObject, JSONObject, Unit>() { // from class: com.tt.android.qualitystat.config.StatConfig$Builder$errorStatBlackList$1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(JSONObject jSONObject, JSONObject jSONObject2) {
                    invoke2(jSONObject, jSONObject2);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(JSONObject jSONObject, JSONObject jSONObject2) {
                    jSONObject.put("status", 1L);
                    jSONObject2.put("data_type", -32);
                }
            });
        }

        public final Builder j(Set<String> set) {
            return d(set, new Function2<JSONObject, JSONObject, Unit>() { // from class: com.tt.android.qualitystat.config.StatConfig$Builder$timingStatBlackList$1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(JSONObject jSONObject, JSONObject jSONObject2) {
                    invoke2(jSONObject, jSONObject2);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(JSONObject jSONObject, JSONObject jSONObject2) {
                    jSONObject.put("error_type", 0L);
                    jSONObject2.put("data_type", -31);
                }
            });
        }

        private final Builder i(com.tt.android.qualitystat.config.a aVar) {
            if (aVar == null) {
                return this;
            }
            this.b = aVar.getScene();
            this.c = aVar.getEnable();
            this.d = aVar.r();
            this.e = aVar.k();
            this.f = aVar.e();
            this.g = aVar.b();
            this.h = aVar.s();
            this.i = aVar.g();
            this.j = aVar.o();
            this.k = aVar.w();
            this.l = aVar.h();
            return this;
        }

        public final Builder h(JSONObject jSONObject) {
            Set<String> set;
            Set<String> set2;
            Set<String> set3;
            Iterator<String> keys;
            if (jSONObject != null && jSONObject.length() != 0) {
                this.a = jSONObject;
                i(StatConfig.i.f(jSONObject));
                JSONObject jSONObject2 = (JSONObject) KotlinExtKt.e(jSONObject, "stat_scene_config");
                if (jSONObject2 != null && (keys = jSONObject2.keys()) != null) {
                    while (keys.hasNext()) {
                        String next = keys.next();
                        QualityStatLog.c.h("* " + next + ": " + jSONObject2.optJSONObject(next));
                        a(next, jSONObject2.optJSONObject(next));
                    }
                }
                if (jSONObject.has("stat_black_list")) {
                    set3 = CollectionsKt___CollectionsKt.toSet(KotlinExtKt.f((JSONArray) KotlinExtKt.e(jSONObject, "stat_black_list")));
                    c(set3);
                } else {
                    set = CollectionsKt___CollectionsKt.toSet(KotlinExtKt.f((JSONArray) KotlinExtKt.e(jSONObject, "timing_stat_black_list")));
                    j(set);
                    set2 = CollectionsKt___CollectionsKt.toSet(KotlinExtKt.f((JSONArray) KotlinExtKt.e(jSONObject, "error_stat_black_list")));
                    g(set2);
                }
                this.n = (Integer) KotlinExtKt.e(jSONObject, "flush_duration");
                this.o = (Integer) KotlinExtKt.e(jSONObject, "sampling_effect_mode");
                List d = StatConfig.i.d((JSONArray) KotlinExtKt.e(jSONObject, "param_convertor"));
                if (d != null) {
                    Iterator it2 = d.iterator();
                    while (it2.hasNext()) {
                        this.q.add((Pair) it2.next());
                    }
                }
                return this;
            }
            QualityStatLog.c.h("ConfigBuilder.fromJson, json is NULL !");
            return this;
        }

        private final Builder a(String str, JSONObject jSONObject) {
            if (jSONObject != null) {
                jSONObject.putOpt("scene_name", str);
            }
            return b(str, StatConfig.i.f(jSONObject));
        }

        public final Builder b(String str, com.tt.android.qualitystat.config.a aVar) {
            HashMap<String, com.tt.android.qualitystat.config.a> hashMap;
            if (aVar == null) {
                return this;
            }
            if (this.p == null) {
                this.p = new HashMap<>();
            }
            if (str != null && (!StringsKt__StringsKt.isBlank(str)) && (hashMap = this.p) != null) {
                hashMap.put(str, aVar);
            }
            return this;
        }

        private final Builder d(Set<String> set, Function2<? super JSONObject, ? super JSONObject, Unit> function2) {
            boolean contains$default;
            ArrayList<String> arrayList = new ArrayList();
            for (Object obj : set) {
                if (!StringsKt__StringsKt.isBlank((String) obj)) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10));
            for (String str : arrayList) {
                JSONObject jSONObject = new JSONObject();
                contains$default = StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) ".", false, 2, (Object) null);
                if (contains$default) {
                    jSONObject.put("sub_scene", str);
                } else {
                    jSONObject.put("scene", str);
                }
                JSONObject jSONObject2 = new JSONObject();
                function2.invoke(jSONObject, jSONObject2);
                arrayList2.add(new Pair(jSONObject, jSONObject2));
            }
            this.q.addAll(arrayList2);
            return this;
        }
    }

    public static final class a {
        static {
            Covode.recordClassIndex(654041);
        }

        private a() {
        }

        /* renamed from: com.tt.android.qualitystat.config.StatConfig$a$a, reason: collision with other inner class name */
        public static final class C0114a implements com.tt.android.qualitystat.config.a {
            private final String b;
            private final Boolean c;
            private final Integer d;
            private final Integer e;
            private final Boolean f;
            private final Boolean g;
            private final Integer h;
            private final Integer i;
            private final Integer j;
            private final Integer k;
            private final Integer l;
            private com.tt.android.qualitystat.config.a m;
            final /* synthetic */ JSONObject o;
            final /* synthetic */ Ref$ObjectRef p;
            final /* synthetic */ Ref$ObjectRef q;

            @Override // com.tt.android.qualitystat.config.a
            public Integer b() {
                return this.i;
            }

            @Override // com.tt.android.qualitystat.config.a
            public Integer e() {
                return this.h;
            }

            @Override // com.tt.android.qualitystat.config.a
            public Integer g() {
                return this.k;
            }

            @Override // com.tt.android.qualitystat.config.a
            public Boolean getEnable() {
                return this.c;
            }

            @Override // com.tt.android.qualitystat.config.a
            public com.tt.android.qualitystat.config.a getFallback() {
                return this.m;
            }

            @Override // com.tt.android.qualitystat.config.a
            public String getScene() {
                return this.b;
            }

            @Override // com.tt.android.qualitystat.config.a
            public Integer h() {
                return this.l;
            }

            @Override // com.tt.android.qualitystat.config.a
            public Boolean k() {
                return this.g;
            }

            @Override // com.tt.android.qualitystat.config.a
            public Integer o() {
                return this.d;
            }

            @Override // com.tt.android.qualitystat.config.a
            public Boolean r() {
                return this.f;
            }

            @Override // com.tt.android.qualitystat.config.a
            public Integer s() {
                return this.j;
            }

            @Override // com.tt.android.qualitystat.config.a
            public Integer w() {
                return this.e;
            }

            @Override // com.tt.android.qualitystat.config.a
            public int c() {
                return a.b.k(this);
            }

            @Override // com.tt.android.qualitystat.config.a
            public boolean enable() {
                return a.b.a(this);
            }

            @Override // com.tt.android.qualitystat.config.a
            public int i() {
                return a.b.c(this);
            }

            @Override // com.tt.android.qualitystat.config.a
            public int l() {
                return a.b.g(this);
            }

            @Override // com.tt.android.qualitystat.config.a
            public boolean m() {
                return a.b.i(this);
            }

            @Override // com.tt.android.qualitystat.config.a
            public int p() {
                return a.b.h(this);
            }

            @Override // com.tt.android.qualitystat.config.a
            public boolean q() {
                return a.b.j(this);
            }

            @Override // com.tt.android.qualitystat.config.a
            public int t() {
                return a.b.b(this);
            }

            @Override // com.tt.android.qualitystat.config.a, tj6.b
            public JSONObject toJsonObject() {
                return a.b.l(this);
            }

            @Override // com.tt.android.qualitystat.config.a
            public int y() {
                return a.b.e(this);
            }

            @Override // com.tt.android.qualitystat.config.a
            public int z() {
                return a.b.f(this);
            }

            @Override // com.tt.android.qualitystat.config.a
            public void x(com.tt.android.qualitystat.config.a aVar) {
                this.m = aVar;
            }

            /* JADX WARN: Multi-variable type inference failed */
            C0114a(JSONObject jSONObject, Ref$ObjectRef ref$ObjectRef, Ref$ObjectRef ref$ObjectRef2) {
                this.o = jSONObject;
                this.p = ref$ObjectRef;
                this.q = ref$ObjectRef2;
                this.b = (String) KotlinExtKt.e(jSONObject, "scene_name");
                this.c = (Boolean) KotlinExtKt.e(jSONObject, "enable");
                this.d = (Integer) KotlinExtKt.e(jSONObject, "min_stat_duration");
                this.e = (Integer) KotlinExtKt.e(jSONObject, "max_stat_duration");
                this.f = (Boolean) ref$ObjectRef.element;
                this.g = (Boolean) ref$ObjectRef2.element;
                this.h = (Integer) KotlinExtKt.e(jSONObject, "error_stat_interval");
                this.i = (Integer) KotlinExtKt.e(jSONObject, "start_event_interval");
                this.j = (Integer) KotlinExtKt.e(jSONObject, "end_event_interval");
                this.k = (Integer) KotlinExtKt.e(jSONObject, "frequency_interval");
                this.l = (Integer) KotlinExtKt.e(jSONObject, "match_mode");
            }
        }

        public final StatConfig c() {
            return StatConfig.h;
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final List<Pair<JSONObject, JSONObject>> d(JSONArray jSONArray) {
            if (jSONArray == null || jSONArray.length() == 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("condition");
                JSONObject optJSONObject3 = optJSONObject.optJSONObject("convertor");
                if (optJSONObject2 != null && optJSONObject3 != null) {
                    arrayList.add(new Pair(optJSONObject2, optJSONObject3));
                }
            }
            if (arrayList.isEmpty()) {
                return null;
            }
            return arrayList;
        }

        private final Pair<Boolean, Boolean> e(int i) {
            boolean z;
            boolean z2 = false;
            if (i != 1 && i != 10) {
                z = false;
            } else {
                z = true;
            }
            if (i == 0 || i == 2 || i == 10) {
                z2 = true;
            }
            return new Pair<>(Boolean.valueOf(z), Boolean.valueOf(z2));
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Type inference failed for: r1v2, types: [T, java.lang.Boolean] */
        /* JADX WARN: Type inference failed for: r2v10, types: [T, java.lang.Boolean] */
        /* JADX WARN: Type inference failed for: r2v2, types: [T, java.lang.Boolean] */
        /* JADX WARN: Type inference failed for: r3v1, types: [T, java.lang.Boolean] */
        public final com.tt.android.qualitystat.config.a f(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
            ref$ObjectRef.element = (Boolean) KotlinExtKt.e(jSONObject, "double_send");
            Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
            ref$ObjectRef2.element = (Boolean) KotlinExtKt.e(jSONObject, "send_to_slardar");
            Integer num = (Integer) KotlinExtKt.e(jSONObject, "report_event_type");
            if (num != null) {
                Pair<Boolean, Boolean> e = e(num.intValue());
                ref$ObjectRef.element = e.getFirst();
                ref$ObjectRef2.element = e.getSecond();
            }
            return new C0114a(jSONObject, ref$ObjectRef, ref$ObjectRef2);
        }
    }

    @Override // com.tt.android.qualitystat.config.a
    public Integer b() {
        return this.g.b();
    }

    @Override // com.tt.android.qualitystat.config.a
    public int c() {
        return this.g.c();
    }

    @Override // com.tt.android.qualitystat.config.a
    public Integer e() {
        return this.g.e();
    }

    @Override // com.tt.android.qualitystat.config.a
    public boolean enable() {
        return this.g.enable();
    }

    @Override // com.tt.android.qualitystat.config.a
    public Integer g() {
        return this.g.g();
    }

    @Override // com.tt.android.qualitystat.config.a
    public Boolean getEnable() {
        return this.g.getEnable();
    }

    @Override // com.tt.android.qualitystat.config.a
    public com.tt.android.qualitystat.config.a getFallback() {
        return this.g.getFallback();
    }

    @Override // com.tt.android.qualitystat.config.a
    public String getScene() {
        return this.g.getScene();
    }

    @Override // com.tt.android.qualitystat.config.a
    public Integer h() {
        return this.g.h();
    }

    @Override // com.tt.android.qualitystat.config.a
    public int i() {
        return this.g.i();
    }

    @Override // com.tt.android.qualitystat.config.a
    public Boolean k() {
        return this.g.k();
    }

    @Override // com.tt.android.qualitystat.config.a
    public int l() {
        return this.g.l();
    }

    @Override // com.tt.android.qualitystat.config.a
    public boolean m() {
        return this.g.m();
    }

    @Override // com.tt.android.qualitystat.config.a
    public Integer o() {
        return this.g.o();
    }

    @Override // com.tt.android.qualitystat.config.a
    public int p() {
        return this.g.p();
    }

    @Override // com.tt.android.qualitystat.config.a
    public boolean q() {
        return this.g.q();
    }

    @Override // com.tt.android.qualitystat.config.a
    public Boolean r() {
        return this.g.r();
    }

    @Override // com.tt.android.qualitystat.config.a
    public Integer s() {
        return this.g.s();
    }

    @Override // com.tt.android.qualitystat.config.a
    public int t() {
        return this.g.t();
    }

    @Override // com.tt.android.qualitystat.config.a
    public Integer w() {
        return this.g.w();
    }

    @Override // com.tt.android.qualitystat.config.a
    public void x(com.tt.android.qualitystat.config.a aVar) {
        this.g.x(aVar);
    }

    @Override // com.tt.android.qualitystat.config.a
    public int y() {
        return this.g.y();
    }

    @Override // com.tt.android.qualitystat.config.a
    public int z() {
        return this.g.z();
    }

    public final int B() {
        Integer num = this.c;
        if (num != null) {
            return num.intValue();
        }
        return h.B();
    }

    public final int C() {
        Integer num = this.d;
        if (num != null) {
            return num.intValue();
        }
        return h.C();
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public String toString() {
        String jSONObject = toJsonObject().toString();
        Intrinsics.checkExpressionValueIsNotNull(jSONObject, "toJsonObject().toString()");
        return jSONObject;
    }

    static {
        Covode.recordClassIndex(654039);
        i = new a(null);
        h = new StatConfig(600000, 2, null, CollectionsKt__CollectionsKt.emptyList(), com.tt.android.qualitystat.config.a.a.a());
    }

    @Override // com.tt.android.qualitystat.config.a, tj6.b
    public JSONObject toJsonObject() {
        JSONObject jSONObject = this.b;
        if (jSONObject == null) {
            JSONObject jSONObject2 = null;
            com.tt.android.qualitystat.base.c c = com.tt.android.qualitystat.base.c.c(com.tt.android.qualitystat.base.c.c(com.tt.android.qualitystat.base.c.c(com.tt.android.qualitystat.base.c.d(new com.tt.android.qualitystat.base.c(0L, 1, null), a.b.l(this), 0L, 2, null), "sampling_effect_mode", this.d, 0L, 4, null), "flush_duration", this.c, 0L, 4, null), "param_convertor", new JSONArray((Collection) this.f), 0L, 4, null);
            HashMap<String, com.tt.android.qualitystat.config.a> hashMap = this.e;
            if (hashMap != null) {
                jSONObject2 = new JSONObject();
                for (Map.Entry<String, com.tt.android.qualitystat.config.a> entry : hashMap.entrySet()) {
                    jSONObject2.putOpt(entry.getKey(), entry.getValue().toJsonObject());
                }
            }
            return com.tt.android.qualitystat.base.c.c(c, "stat_scene_config", jSONObject2, 0L, 4, null).a;
        }
        return jSONObject;
    }

    public boolean equals(Object obj) {
        return Intrinsics.areEqual(toString(), String.valueOf(obj));
    }

    public StatConfig(JSONObject jSONObject) {
        this(new Builder().h(jSONObject));
    }

    private StatConfig(Builder builder) {
        this(builder.n, builder.o, builder.p, builder.q, builder.f());
        x(h);
        HashMap<String, com.tt.android.qualitystat.config.a> hashMap = this.e;
        if (hashMap != null) {
            Iterator<Map.Entry<String, com.tt.android.qualitystat.config.a>> it2 = hashMap.entrySet().iterator();
            while (it2.hasNext()) {
                it2.next().getValue().x(this);
            }
        }
        this.b = builder.a;
    }

    public /* synthetic */ StatConfig(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    public StatConfig(Integer num, Integer num2, HashMap<String, com.tt.android.qualitystat.config.a> hashMap, List<? extends Pair<? extends JSONObject, ? extends JSONObject>> list, com.tt.android.qualitystat.config.a aVar) {
        this.c = num;
        this.d = num2;
        this.e = hashMap;
        this.f = list;
        this.g = aVar;
    }
}
