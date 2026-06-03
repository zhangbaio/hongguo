package com.xs.fm.player.sdk.play.address.disklrucache;

import com.bytedance.covode.number.Covode;
import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import lk6.b;
import nk6.c;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public abstract class PlayAddressDiskCache {
    private final bl6.a a = new bl6.a("FMSDKPlayerTracePlayAddressDiskCache");
    private final LinkedHashMap<String, Serializable> b;
    private final int c;

    static {
        Covode.recordClassIndex(655927);
    }

    public abstract Serializable d(String str);

    public abstract void g(String str);

    public abstract void h(String str, Serializable serializable);

    public final void f(String str) {
        this.b.remove(str);
        g(str);
    }

    public PlayAddressDiskCache(final int i) {
        this.c = i;
        final float f = 0.75f;
        final boolean z = true;
        this.b = new LinkedHashMap<String, Serializable>(i, f, z) { // from class: com.xs.fm.player.sdk.play.address.disklrucache.PlayAddressDiskCache$cache$1
            @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ Set<Map.Entry<String, Serializable>> entrySet() {
                return getEntries();
            }

            public /* bridge */ Set getEntries() {
                return super.entrySet();
            }

            public /* bridge */ Set getKeys() {
                return super.keySet();
            }

            public /* bridge */ int getSize() {
                return super.size();
            }

            public /* bridge */ Collection getValues() {
                return super.values();
            }

            @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ Set<String> keySet() {
                return getKeys();
            }

            @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ int size() {
                return getSize();
            }

            @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ Collection<Serializable> values() {
                return getValues();
            }

            public /* bridge */ boolean containsKey(String str) {
                return super.containsKey((Object) str);
            }

            public /* bridge */ boolean containsValue(Serializable serializable) {
                return super.containsValue((Object) serializable);
            }

            public /* bridge */ Serializable get(String str) {
                return (Serializable) super.get((Object) str);
            }

            public /* bridge */ Serializable remove(String str) {
                return (Serializable) super.remove((Object) str);
            }

            @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ boolean containsKey(Object obj) {
                if (obj instanceof String) {
                    return containsKey((String) obj);
                }
                return false;
            }

            @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ boolean containsValue(Object obj) {
                if (obj instanceof Serializable) {
                    return containsValue((Serializable) obj);
                }
                return false;
            }

            @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ Object get(Object obj) {
                if (obj instanceof String) {
                    return get((String) obj);
                }
                return null;
            }

            @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ Object remove(Object obj) {
                if (obj instanceof String) {
                    return remove((String) obj);
                }
                return null;
            }

            @Override // java.util.LinkedHashMap
            protected boolean removeEldestEntry(Map.Entry<String, Serializable> entry) {
                int i2;
                bl6.a aVar;
                int i3;
                String str;
                int i4;
                String str2;
                c cVar;
                b bVar = lk6.c.a;
                if (bVar != null && (cVar = bVar.m) != null && cVar.h()) {
                    return false;
                }
                int size = size();
                i2 = PlayAddressDiskCache.this.c;
                if (size > i2) {
                    PlayAddressDiskCache playAddressDiskCache = PlayAddressDiskCache.this;
                    if (entry == null || (str2 = entry.getKey()) == null) {
                        str2 = "";
                    }
                    playAddressDiskCache.f(str2);
                }
                aVar = PlayAddressDiskCache.this.a;
                StringBuilder sb = new StringBuilder();
                sb.append("removeEldestEntry: size=");
                sb.append(size());
                sb.append(", maxNum=");
                i3 = PlayAddressDiskCache.this.c;
                sb.append(i3);
                sb.append(", ");
                if (entry != null) {
                    str = entry.getKey();
                } else {
                    str = null;
                }
                sb.append(str);
                aVar.d(sb.toString(), new Object[0]);
                int size2 = size();
                i4 = PlayAddressDiskCache.this.c;
                if (size2 > i4) {
                    return true;
                }
                return false;
            }

            public /* bridge */ Serializable getOrDefault(String str, Serializable serializable) {
                return (Serializable) super.getOrDefault((Object) str, (String) serializable);
            }

            @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.Map
            public final /* bridge */ Object getOrDefault(Object obj, Object obj2) {
                if (obj instanceof String) {
                    return getOrDefault((String) obj, (Serializable) obj2);
                }
                return obj2;
            }

            @Override // java.util.HashMap, java.util.Map
            public final /* bridge */ boolean remove(Object obj, Object obj2) {
                if ((obj instanceof String) && (obj2 instanceof Serializable)) {
                    return remove((String) obj, (Serializable) obj2);
                }
                return false;
            }

            public /* bridge */ boolean remove(String str, Serializable serializable) {
                return super.remove((Object) str, (Object) serializable);
            }
        };
    }

    public final Serializable c(String str) {
        Serializable serializable = this.b.get(str);
        if (serializable == null) {
            Serializable d = d(str);
            if (d != null) {
                this.b.put(str, d);
                return d;
            }
            return null;
        }
        return serializable;
    }

    public final void e(String str, Serializable serializable) {
        h(str, serializable);
        this.b.put(str, serializable);
    }
}
