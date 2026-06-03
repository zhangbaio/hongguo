package com.dragon.read.kmp.utils;

import com.bytedance.covode.number.Covode;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.json.JsonArrayBuilder;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonNull;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonObjectBuilder;
import kotlinx.serialization.json.JsonPrimitive;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class w {
    static {
        Covode.recordClassIndex(609542);
    }

    public static final String b(JsonElement jsonElement) {
        if (jsonElement == null) {
            return "";
        }
        if (jsonElement instanceof JsonPrimitive) {
            return ((JsonPrimitive) jsonElement).getContent();
        }
        return jsonElement.toString();
    }

    public static final Object i(JsonElement jsonElement) {
        if (jsonElement == null) {
            return null;
        }
        if (jsonElement instanceof JsonPrimitive) {
            JsonPrimitive jsonPrimitive = (JsonPrimitive) jsonElement;
            Integer intOrNull = JsonElementKt.getIntOrNull(jsonPrimitive);
            if (intOrNull == null) {
                Boolean booleanOrNull = JsonElementKt.getBooleanOrNull(jsonPrimitive);
                if (booleanOrNull == null) {
                    Float floatOrNull = JsonElementKt.getFloatOrNull(jsonPrimitive);
                    if (floatOrNull == null) {
                        Double doubleOrNull = JsonElementKt.getDoubleOrNull(jsonPrimitive);
                        if (doubleOrNull == null) {
                            return jsonPrimitive.getContent();
                        }
                        return doubleOrNull;
                    }
                    return floatOrNull;
                }
                return booleanOrNull;
            }
            return intOrNull;
        }
        return jsonElement.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final JsonElement h(Object obj) {
        if (obj == null) {
            return JsonNull.INSTANCE;
        }
        if (obj instanceof String) {
            return JsonElementKt.JsonPrimitive((String) obj);
        }
        if (obj instanceof Number) {
            return JsonElementKt.JsonPrimitive((Number) obj);
        }
        if (obj instanceof Boolean) {
            return JsonElementKt.JsonPrimitive((Boolean) obj);
        }
        if (obj instanceof Enum) {
            return JsonElementKt.JsonPrimitive(((Enum) obj).name());
        }
        if (obj instanceof JsonElement) {
            return (JsonElement) obj;
        }
        if (obj instanceof Map) {
            JsonObjectBuilder jsonObjectBuilder = new JsonObjectBuilder();
            for (Map.Entry entry : ((Map) obj).entrySet()) {
                jsonObjectBuilder.put(String.valueOf(entry.getKey()), h(entry.getValue()));
            }
            return jsonObjectBuilder.build();
        }
        if (obj instanceof List) {
            JsonArrayBuilder jsonArrayBuilder = new JsonArrayBuilder();
            Iterator it2 = ((Iterable) obj).iterator();
            while (it2.hasNext()) {
                jsonArrayBuilder.add(h(it2.next()));
            }
            return jsonArrayBuilder.build();
        }
        if (obj instanceof Object[]) {
            JsonArrayBuilder jsonArrayBuilder2 = new JsonArrayBuilder();
            for (Object obj2 : (Object[]) obj) {
                jsonArrayBuilder2.add(h(obj2));
            }
            return jsonArrayBuilder2.build();
        }
        gn6.a c = com.dragon.read.kmp.base.h.c();
        gn6.a c2 = com.dragon.read.kmp.base.h.c();
        return c.e(c2.a(dn6.s.a(c2.getSerializersModule(), Reflection.getOrCreateKotlinClass(Object.class)), obj));
    }

    public static final JsonObject e(JsonObject jsonObject, String key) {
        Intrinsics.checkNotNullParameter(jsonObject, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        JsonElement jsonElement = (JsonElement) jsonObject.get(key);
        if (jsonElement != null) {
            return JsonElementKt.getJsonObject(jsonElement);
        }
        return null;
    }

    public static final int c(JsonObject jsonObject, String key, int i) {
        JsonPrimitive jsonPrimitive;
        Integer intOrNull;
        Intrinsics.checkNotNullParameter(jsonObject, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        JsonElement jsonElement = (JsonElement) jsonObject.get(key);
        if (jsonElement != null && (jsonPrimitive = JsonElementKt.getJsonPrimitive(jsonElement)) != null && (intOrNull = JsonElementKt.getIntOrNull(jsonPrimitive)) != null) {
            return intOrNull.intValue();
        }
        return i;
    }

    public static final String f(JsonObject jsonObject, String key, String str) {
        JsonPrimitive jsonPrimitive;
        String content;
        Intrinsics.checkNotNullParameter(jsonObject, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(str, "default");
        JsonElement jsonElement = (JsonElement) jsonObject.get(key);
        if (jsonElement != null && (jsonPrimitive = JsonElementKt.getJsonPrimitive(jsonElement)) != null && (content = jsonPrimitive.getContent()) != null) {
            return content;
        }
        return str;
    }

    public static /* synthetic */ int d(JsonObject jsonObject, String str, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return c(jsonObject, str, i);
    }

    public static /* synthetic */ String g(JsonObject jsonObject, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "";
        }
        return f(jsonObject, str, str2);
    }
}
