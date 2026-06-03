package com.dragon.read.kmp.utils;

import com.bytedance.covode.number.Covode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.JsonArray;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonNull;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonObjectBuilder;
import kotlinx.serialization.json.JsonPrimitive;
import yn0.a;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class v {
    public static final v a;
    private static final Lazy b;
    public static final int c;

    private v() {
    }

    static {
        Lazy lazy;
        Covode.recordClassIndex(609541);
        a = new v();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.dragon.read.kmp.utils.u
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                JsonObject b2;
                b2 = v.b();
                return b2;
            }
        });
        b = lazy;
        c = 8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final JsonObject b() {
        gn6.a c2 = com.dragon.read.kmp.base.h.c();
        c2.getSerializersModule();
        return (JsonObject) c2.c(JsonObject.Companion.serializer(), "{}");
    }

    public final JsonObject i(Map<String, ?> map) {
        return j(map);
    }

    public final String k(Map<String, ? extends Object> map) {
        return i(map).toString();
    }

    public final JsonElement g(String str) {
        boolean z;
        if (str != null && str.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            return null;
        }
        try {
            return com.dragon.read.kmp.base.h.c().e(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x000e A[Catch: Exception -> 0x003a, TryCatch #0 {Exception -> 0x003a, blocks: (B:14:0x0002, B:4:0x000e, B:7:0x0014, B:9:0x002d, B:11:0x0034), top: B:13:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014 A[Catch: Exception -> 0x003a, TryCatch #0 {Exception -> 0x003a, blocks: (B:14:0x0002, B:4:0x000e, B:7:0x0014, B:9:0x002d, B:11:0x0034), top: B:13:0x0002 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List<java.lang.Object> d(java.lang.String r3) {
        /*
            r2 = this;
            if (r3 == 0) goto Lb
            int r0 = r3.length()     // Catch: java.lang.Exception -> L3a
            if (r0 != 0) goto L9
            goto Lb
        L9:
            r0 = 0
            goto Lc
        Lb:
            r0 = 1
        Lc:
            if (r0 == 0) goto L14
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch: java.lang.Exception -> L3a
            r3.<init>()     // Catch: java.lang.Exception -> L3a
            goto L3f
        L14:
            gn6.a r0 = com.dragon.read.kmp.base.h.c()     // Catch: java.lang.Exception -> L3a
            r0.getSerializersModule()     // Catch: java.lang.Exception -> L3a
            kotlinx.serialization.json.JsonElement$a r1 = kotlinx.serialization.json.JsonElement.Companion     // Catch: java.lang.Exception -> L3a
            kotlinx.serialization.KSerializer r1 = r1.serializer()     // Catch: java.lang.Exception -> L3a
            kotlinx.serialization.DeserializationStrategy r1 = (kotlinx.serialization.DeserializationStrategy) r1     // Catch: java.lang.Exception -> L3a
            java.lang.Object r3 = r0.c(r1, r3)     // Catch: java.lang.Exception -> L3a
            kotlinx.serialization.json.JsonElement r3 = (kotlinx.serialization.json.JsonElement) r3     // Catch: java.lang.Exception -> L3a
            boolean r0 = r3 instanceof kotlinx.serialization.json.JsonArray     // Catch: java.lang.Exception -> L3a
            if (r0 == 0) goto L34
            kotlinx.serialization.json.JsonArray r3 = (kotlinx.serialization.json.JsonArray) r3     // Catch: java.lang.Exception -> L3a
            java.util.List r3 = r2.c(r3)     // Catch: java.lang.Exception -> L3a
            goto L3f
        L34:
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch: java.lang.Exception -> L3a
            r3.<init>()     // Catch: java.lang.Exception -> L3a
            goto L3f
        L3a:
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
        L3f:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.utils.v.d(java.lang.String):java.util.List");
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x000e A[Catch: Exception -> 0x003a, TryCatch #0 {Exception -> 0x003a, blocks: (B:14:0x0002, B:4:0x000e, B:7:0x0014, B:9:0x002d, B:11:0x0034), top: B:13:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014 A[Catch: Exception -> 0x003a, TryCatch #0 {Exception -> 0x003a, blocks: (B:14:0x0002, B:4:0x000e, B:7:0x0014, B:9:0x002d, B:11:0x0034), top: B:13:0x0002 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.Map<java.lang.String, java.lang.Object> f(java.lang.String r3) {
        /*
            r2 = this;
            if (r3 == 0) goto Lb
            int r0 = r3.length()     // Catch: java.lang.Exception -> L3a
            if (r0 != 0) goto L9
            goto Lb
        L9:
            r0 = 0
            goto Lc
        Lb:
            r0 = 1
        Lc:
            if (r0 == 0) goto L14
            java.util.HashMap r3 = new java.util.HashMap     // Catch: java.lang.Exception -> L3a
            r3.<init>()     // Catch: java.lang.Exception -> L3a
            goto L3f
        L14:
            gn6.a r0 = com.dragon.read.kmp.base.h.c()     // Catch: java.lang.Exception -> L3a
            r0.getSerializersModule()     // Catch: java.lang.Exception -> L3a
            kotlinx.serialization.json.JsonElement$a r1 = kotlinx.serialization.json.JsonElement.Companion     // Catch: java.lang.Exception -> L3a
            kotlinx.serialization.KSerializer r1 = r1.serializer()     // Catch: java.lang.Exception -> L3a
            kotlinx.serialization.DeserializationStrategy r1 = (kotlinx.serialization.DeserializationStrategy) r1     // Catch: java.lang.Exception -> L3a
            java.lang.Object r3 = r0.c(r1, r3)     // Catch: java.lang.Exception -> L3a
            kotlinx.serialization.json.JsonElement r3 = (kotlinx.serialization.json.JsonElement) r3     // Catch: java.lang.Exception -> L3a
            boolean r0 = r3 instanceof kotlinx.serialization.json.JsonObject     // Catch: java.lang.Exception -> L3a
            if (r0 == 0) goto L34
            kotlinx.serialization.json.JsonObject r3 = (kotlinx.serialization.json.JsonObject) r3     // Catch: java.lang.Exception -> L3a
            java.util.HashMap r3 = r2.e(r3)     // Catch: java.lang.Exception -> L3a
            goto L3f
        L34:
            java.util.HashMap r3 = new java.util.HashMap     // Catch: java.lang.Exception -> L3a
            r3.<init>()     // Catch: java.lang.Exception -> L3a
            goto L3f
        L3a:
            java.util.HashMap r3 = new java.util.HashMap
            r3.<init>()
        L3f:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.utils.v.f(java.lang.String):java.util.Map");
    }

    public final JsonElement h(String str) {
        JsonElement g = g(str);
        if (g == null) {
            gn6.a c2 = com.dragon.read.kmp.base.h.c();
            c2.getSerializersModule();
            g = (JsonElement) c2.c(en6.a.u(JsonElement.Companion.serializer()), "{}");
        }
        Intrinsics.checkNotNull(g);
        return g;
    }

    private final JsonObject j(Map<?, ?> map) {
        boolean z;
        JsonElement h;
        if (map != null && !map.isEmpty()) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            return new JsonObjectBuilder().build();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            try {
                String valueOf = String.valueOf(key);
                h = w.h(value);
                linkedHashMap.put(valueOf, h);
            } catch (Exception e) {
                a.a.b(yn0.b.b, "JSONUtils", "fail to convert args to json,error = " + e, false, 4, (Object) null);
            }
        }
        return new JsonObject(linkedHashMap);
    }

    public final List<Object> c(JsonArray jsonArray) {
        Object obj;
        ArrayList arrayList = new ArrayList();
        if (jsonArray == null) {
            return arrayList;
        }
        Iterator it2 = jsonArray.iterator();
        while (it2.hasNext()) {
            JsonPrimitive jsonPrimitive = (JsonElement) it2.next();
            if (jsonPrimitive instanceof JsonObject) {
                obj = e((JsonObject) jsonPrimitive);
            } else if (jsonPrimitive instanceof JsonArray) {
                obj = c((JsonArray) jsonPrimitive);
            } else {
                if (jsonPrimitive instanceof JsonPrimitive) {
                    JsonPrimitive jsonPrimitive2 = jsonPrimitive;
                    if (jsonPrimitive2.isString()) {
                        obj = jsonPrimitive2.getContent();
                    } else if (JsonElementKt.getBooleanOrNull(jsonPrimitive2) != null) {
                        obj = JsonElementKt.getBooleanOrNull(jsonPrimitive2);
                    } else if (JsonElementKt.getIntOrNull(jsonPrimitive2) != null) {
                        obj = JsonElementKt.getIntOrNull(jsonPrimitive2);
                    } else if (JsonElementKt.getDoubleOrNull(jsonPrimitive2) != null) {
                        obj = JsonElementKt.getDoubleOrNull(jsonPrimitive2);
                    }
                } else {
                    boolean z = jsonPrimitive instanceof JsonNull;
                }
                obj = null;
            }
            if (obj != null) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final HashMap<String, Object> e(JsonObject jsonObject) {
        Object obj;
        HashMap<String, Object> hashMap = new HashMap<>();
        if (jsonObject == null) {
            return hashMap;
        }
        for (Map.Entry entry : jsonObject.entrySet()) {
            JsonPrimitive jsonPrimitive = (JsonElement) entry.getValue();
            if (jsonPrimitive instanceof JsonObject) {
                obj = e((JsonObject) jsonPrimitive);
            } else if (jsonPrimitive instanceof JsonArray) {
                obj = c((JsonArray) jsonPrimitive);
            } else {
                if (jsonPrimitive instanceof JsonPrimitive) {
                    JsonPrimitive jsonPrimitive2 = jsonPrimitive;
                    if (jsonPrimitive2.isString()) {
                        obj = jsonPrimitive2.getContent();
                    } else if (JsonElementKt.getBooleanOrNull(jsonPrimitive2) != null) {
                        obj = JsonElementKt.getBooleanOrNull(jsonPrimitive2);
                    } else if (JsonElementKt.getIntOrNull(jsonPrimitive2) != null) {
                        obj = JsonElementKt.getIntOrNull(jsonPrimitive2);
                    } else if (JsonElementKt.getDoubleOrNull(jsonPrimitive2) != null) {
                        obj = JsonElementKt.getDoubleOrNull(jsonPrimitive2);
                    }
                } else {
                    boolean z = jsonPrimitive instanceof JsonNull;
                }
                obj = null;
            }
            if (obj != null) {
                hashMap.put(entry.getKey(), obj);
            }
        }
        return hashMap;
    }
}
