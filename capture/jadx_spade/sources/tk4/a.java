package tk4;

import com.bytedance.covode.number.Covode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.JsonArray;
import kotlinx.serialization.json.JsonArrayBuilder;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonNull;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonObjectBuilder;
import kotlinx.serialization.json.JsonPrimitive;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a {
    public static final a a;

    static {
        Covode.recordClassIndex(607993);
        a = new a();
    }

    private a() {
    }

    public final JsonElement d(Map<String, ? extends Object> map) {
        if (map == null) {
            return null;
        }
        JsonObjectBuilder jsonObjectBuilder = new JsonObjectBuilder();
        for (Map.Entry<String, ? extends Object> entry : map.entrySet()) {
            jsonObjectBuilder.put(entry.getKey(), a.a(entry.getValue()));
        }
        return jsonObjectBuilder.build();
    }

    public final Map<String, Object> c(JsonElement jsonElement) {
        int mapCapacity;
        if (jsonElement != null && (jsonElement instanceof JsonObject)) {
            Map map = (Map) jsonElement;
            mapCapacity = MapsKt__MapsJVMKt.mapCapacity(map.size());
            LinkedHashMap linkedHashMap = new LinkedHashMap(mapCapacity);
            for (Map.Entry entry : map.entrySet()) {
                linkedHashMap.put(entry.getKey(), a.b((JsonElement) entry.getValue()));
            }
            return linkedHashMap;
        }
        return null;
    }

    public final JsonElement a(Object obj) {
        if (obj == null) {
            return JsonNull.INSTANCE;
        }
        if (obj instanceof String) {
            return JsonElementKt.JsonPrimitive((String) obj);
        }
        if (obj instanceof Integer) {
            return JsonElementKt.JsonPrimitive((Number) obj);
        }
        if (obj instanceof Long) {
            return JsonElementKt.JsonPrimitive((Number) obj);
        }
        if (obj instanceof Float) {
            return JsonElementKt.JsonPrimitive((Number) obj);
        }
        if (obj instanceof Double) {
            return JsonElementKt.JsonPrimitive((Number) obj);
        }
        if (obj instanceof Boolean) {
            return JsonElementKt.JsonPrimitive((Boolean) obj);
        }
        if (obj instanceof Map) {
            JsonObjectBuilder jsonObjectBuilder = new JsonObjectBuilder();
            for (Map.Entry entry : ((Map) obj).entrySet()) {
                Object key = entry.getKey();
                Object value = entry.getValue();
                if (key instanceof String) {
                    jsonObjectBuilder.put((String) key, a.a(value));
                }
            }
            return jsonObjectBuilder.build();
        }
        if (obj instanceof List) {
            JsonArrayBuilder jsonArrayBuilder = new JsonArrayBuilder();
            Iterator it2 = ((Iterable) obj).iterator();
            while (it2.hasNext()) {
                jsonArrayBuilder.add(a.a(it2.next()));
            }
            return jsonArrayBuilder.build();
        }
        if (obj instanceof Object[]) {
            JsonArrayBuilder jsonArrayBuilder2 = new JsonArrayBuilder();
            for (Object obj2 : (Object[]) obj) {
                jsonArrayBuilder2.add(a.a(obj2));
            }
            return jsonArrayBuilder2.build();
        }
        return JsonElementKt.JsonPrimitive(obj.toString());
    }

    public final Object b(JsonElement element) {
        int mapCapacity;
        Intrinsics.checkNotNullParameter(element, "element");
        if (element instanceof JsonNull) {
            return null;
        }
        if (element instanceof JsonPrimitive) {
            JsonPrimitive jsonPrimitive = (JsonPrimitive) element;
            if (jsonPrimitive.isString()) {
                return jsonPrimitive.getContent();
            }
            if (JsonElementKt.getBooleanOrNull(jsonPrimitive) != null) {
                return Boolean.valueOf(JsonElementKt.getBoolean(jsonPrimitive));
            }
            if (JsonElementKt.getIntOrNull(jsonPrimitive) != null) {
                return Integer.valueOf(JsonElementKt.getInt(jsonPrimitive));
            }
            if (JsonElementKt.getLongOrNull(jsonPrimitive) != null) {
                return Long.valueOf(JsonElementKt.getLong(jsonPrimitive));
            }
            if (JsonElementKt.getDoubleOrNull(jsonPrimitive) != null) {
                return Double.valueOf(JsonElementKt.getDouble(jsonPrimitive));
            }
            return jsonPrimitive.getContent();
        }
        if (element instanceof JsonObject) {
            Map map = (Map) element;
            mapCapacity = MapsKt__MapsJVMKt.mapCapacity(map.size());
            LinkedHashMap linkedHashMap = new LinkedHashMap(mapCapacity);
            for (Map.Entry entry : map.entrySet()) {
                linkedHashMap.put(entry.getKey(), a.b((JsonElement) entry.getValue()));
            }
            return linkedHashMap;
        }
        if (!(element instanceof JsonArray)) {
            return null;
        }
        Iterable iterable = (Iterable) element;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        Iterator it2 = iterable.iterator();
        while (it2.hasNext()) {
            arrayList.add(a.b((JsonElement) it2.next()));
        }
        return arrayList;
    }
}
