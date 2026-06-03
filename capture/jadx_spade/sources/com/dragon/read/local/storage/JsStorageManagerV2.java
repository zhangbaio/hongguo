package com.dragon.read.local.storage;

import android.content.SharedPreferences;
import com.bytedance.covode.number.Covode;
import com.bytedance.framwork.core.monitor.MonitorUtils;
import com.dragon.base.ssconfig.model.JsStorageConfigModel;
import com.dragon.read.app.App;
import com.dragon.read.base.util.JSONUtils;
import com.dragon.read.base.util.LogWrapper;
import com.dragon.read.local.KvCacheMgr;
import com.dragon.read.local.storage.JsStorageManagerV2;
import er4.d0;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.Charsets;
import ob2.i;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class JsStorageManagerV2 extends com.dragon.read.local.storage.a {
    public static final JsStorageManagerV2 g;
    private static final Map<StorageType, c> h;
    private static final boolean i;
    public static final int j;

    public interface c {
        ResultCode a(String str, String str2);

        Pair<ResultCode, String> b(String str);

        ResultCode c(String str);

        int getSize();
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class ActionType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ ActionType[] $VALUES;
        public static final ActionType GET;
        public static final ActionType REMOVE;
        public static final ActionType SET;
        private final String v;

        private static final /* synthetic */ ActionType[] $values() {
            return new ActionType[]{SET, GET, REMOVE};
        }

        public static EnumEntries<ActionType> getEntries() {
            return $ENTRIES;
        }

        public final String getV() {
            return this.v;
        }

        public static ActionType[] values() {
            return (ActionType[]) $VALUES.clone();
        }

        static {
            Covode.recordClassIndex(611939);
            SET = new ActionType("SET", 0, "set");
            GET = new ActionType("GET", 1, "get");
            REMOVE = new ActionType("REMOVE", 2, "remove");
            ActionType[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        public static ActionType valueOf(String str) {
            return (ActionType) Enum.valueOf(ActionType.class, str);
        }

        private ActionType(String str, int i, String str2) {
            this.v = str2;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class ResultCode {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ ResultCode[] $VALUES;
        public static final ResultCode BEYOND_OCCUPY;
        public static final ResultCode CLOSE;
        public static final ResultCode ERROR;
        public static final ResultCode NO_KEY;
        public static final ResultCode NULL_KEY;
        public static final ResultCode SUCCESS;
        private final int v;

        private static final /* synthetic */ ResultCode[] $values() {
            return new ResultCode[]{SUCCESS, BEYOND_OCCUPY, NULL_KEY, CLOSE, NO_KEY, ERROR};
        }

        public static EnumEntries<ResultCode> getEntries() {
            return $ENTRIES;
        }

        public final int getV() {
            return this.v;
        }

        public static ResultCode[] values() {
            return (ResultCode[]) $VALUES.clone();
        }

        static {
            Covode.recordClassIndex(611943);
            SUCCESS = new ResultCode("SUCCESS", 0, 0);
            BEYOND_OCCUPY = new ResultCode("BEYOND_OCCUPY", 1, 1);
            NULL_KEY = new ResultCode("NULL_KEY", 2, 2);
            CLOSE = new ResultCode("CLOSE", 3, 3);
            NO_KEY = new ResultCode("NO_KEY", 4, 4);
            ERROR = new ResultCode("ERROR", 5, 5);
            ResultCode[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        public static ResultCode valueOf(String str) {
            return (ResultCode) Enum.valueOf(ResultCode.class, str);
        }

        private ResultCode(String str, int i, int i2) {
            this.v = i2;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class StorageType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ StorageType[] $VALUES;
        public static final StorageType DISK;
        public static final StorageType MEMORY;
        private final String v;

        private static final /* synthetic */ StorageType[] $values() {
            return new StorageType[]{DISK, MEMORY};
        }

        public static EnumEntries<StorageType> getEntries() {
            return $ENTRIES;
        }

        public final String getV() {
            return this.v;
        }

        public static StorageType[] values() {
            return (StorageType[]) $VALUES.clone();
        }

        static {
            Covode.recordClassIndex(611945);
            DISK = new StorageType("DISK", 0, "disk");
            MEMORY = new StorageType("MEMORY", 1, "memory");
            StorageType[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        public static StorageType valueOf(String str) {
            return (StorageType) Enum.valueOf(StorageType.class, str);
        }

        private StorageType(String str, int i, String str2) {
            this.v = str2;
        }
    }

    public static final class a implements c {
        public static final C0089a f;
        public static final int g;
        private final ReentrantReadWriteLock a = new ReentrantReadWriteLock();
        private final SharedPreferences b;
        private int c;
        private final int d;
        private final List<String> e;

        /* renamed from: com.dragon.read.local.storage.JsStorageManagerV2$a$a, reason: collision with other inner class name */
        public static final class C0089a {
            static {
                Covode.recordClassIndex(611941);
            }

            private C0089a() {
            }

            public /* synthetic */ C0089a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        static {
            Covode.recordClassIndex(611940);
            f = new C0089a(null);
            g = 8;
        }

        @Override // com.dragon.read.local.storage.JsStorageManagerV2.c
        public int getSize() {
            return this.c;
        }

        public a() {
            JsStorageConfigModel b = i.b();
            this.d = b.maxDiskOccupy;
            List deleteListOnTrim = b.deleteListOnTrim;
            Intrinsics.checkNotNullExpressionValue(deleteListOnTrim, "deleteListOnTrim");
            this.e = CollectionsKt___CollectionsKt.toList(deleteListOnTrim);
            this.c = 0;
            SharedPreferences createSelfControl = KvCacheMgr.createSelfControl(App.context(), "js_storage_stats");
            Intrinsics.checkNotNullExpressionValue(createSelfControl, "createSelfControl(...)");
            this.b = createSelfControl;
            o();
        }

        private final void o() {
            int i = this.b.getInt("size", -1);
            if (i >= 0) {
                LogWrapper.info("js_storage_v2", "read local stats, size: " + i, new Object[0]);
                this.c = i;
                return;
            }
            j();
        }

        private final void j() {
            long currentTimeMillis = System.currentTimeMillis();
            SharedPreferences.Editor clear = this.b.edit().clear();
            final LinkedHashMap linkedHashMap = new LinkedHashMap();
            int i = i(new Function2() { // from class: sr4.a
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit k;
                    k = JsStorageManagerV2.a.k(linkedHashMap, (String) obj, ((Integer) obj2).intValue());
                    return k;
                }
            });
            this.c = i;
            clear.putInt("size", i);
            for (Map.Entry entry : linkedHashMap.entrySet()) {
                LogWrapper.debug("js_storage_v2", "init, key: " + ((String) entry.getKey()) + ", size: " + ((Number) entry.getValue()).intValue(), new Object[0]);
                clear.putInt((String) entry.getKey(), ((Number) entry.getValue()).intValue());
            }
            clear.apply();
            LogWrapper.info("js_storage_v2", "init stats, collect real sp size: " + this.c + ", elapsed millis: " + (System.currentTimeMillis() - currentTimeMillis), new Object[0]);
        }

        private final int e(String str) {
            return Math.abs(str.hashCode()) % 29;
        }

        private final SharedPreferences f(String str) {
            return l(e(str));
        }

        private final boolean m(int i) {
            if (i + this.c <= this.d) {
                return true;
            }
            return false;
        }

        private final SharedPreferences l(int i) {
            SharedPreferences createSelfControl = KvCacheMgr.createSelfControl(App.context(), "js_storage" + i);
            Intrinsics.checkNotNullExpressionValue(createSelfControl, "createSelfControl(...)");
            return createSelfControl;
        }

        @Override // com.dragon.read.local.storage.JsStorageManagerV2.c
        public Pair<ResultCode, String> b(String key) {
            Pair<ResultCode, String> pair;
            Intrinsics.checkNotNullParameter(key, "key");
            ReentrantReadWriteLock.ReadLock readLock = this.a.readLock();
            readLock.lock();
            try {
                String string = f(key).getString(key, null);
                if (string == null) {
                    pair = TuplesKt.to(ResultCode.NO_KEY, "");
                } else {
                    pair = TuplesKt.to(ResultCode.SUCCESS, string);
                }
                return pair;
            } finally {
                readLock.unlock();
            }
        }

        private final int i(Function2<? super String, ? super Integer, Unit> function2) {
            IntRange until;
            int h;
            until = RangesKt___RangesKt.until(0, 29);
            Iterator<Integer> it2 = until.iterator();
            int i = 0;
            while (it2.hasNext()) {
                int nextInt = ((IntIterator) it2).nextInt();
                SharedPreferences l = l(nextInt);
                if (l instanceof d0) {
                    h = g((d0) l, function2);
                } else {
                    h = h(l, function2);
                }
                LogWrapper.info("js_storage_v2", "sp index " + nextInt + " size " + h, new Object[0]);
                i += h;
            }
            return i;
        }

        private final Pair<Boolean, Integer> n(int i) {
            if (m(i)) {
                return TuplesKt.to(Boolean.TRUE, Integer.valueOf(i + this.c));
            }
            LogWrapper.warn("js_storage_v2", "lack free space, gc on demand", new Object[0]);
            for (String str : this.e) {
                LogWrapper.warn("js_storage_v2", "remove key " + str + " to clean storage, code: " + c(str), new Object[0]);
            }
            return TuplesKt.to(Boolean.valueOf(m(i)), Integer.valueOf(i + this.c));
        }

        @Override // com.dragon.read.local.storage.JsStorageManagerV2.c
        public ResultCode c(String key) {
            int i;
            ResultCode resultCode;
            Intrinsics.checkNotNullParameter(key, "key");
            ReentrantReadWriteLock reentrantReadWriteLock = this.a;
            ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
            int i2 = 0;
            if (reentrantReadWriteLock.getWriteHoldCount() == 0) {
                i = reentrantReadWriteLock.getReadHoldCount();
            } else {
                i = 0;
            }
            for (int i3 = 0; i3 < i; i3++) {
                readLock.unlock();
            }
            ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
            writeLock.lock();
            try {
                SharedPreferences f2 = f(key);
                String string = f2.getString(key, null);
                if (string == null) {
                    resultCode = ResultCode.NO_KEY;
                } else {
                    this.c -= d.a.a(key, null, string);
                    q(this, key, null, 2, null);
                    f2.edit().remove(key).apply();
                    resultCode = ResultCode.SUCCESS;
                }
                return resultCode;
            } finally {
                while (i2 < i) {
                    readLock.lock();
                    i2++;
                }
                writeLock.unlock();
            }
        }

        private final int g(d0 d0Var, Function2<? super String, ? super Integer, Unit> function2) {
            int i = 0;
            for (String str : d0Var.k()) {
                int m = d0Var.m(str);
                byte[] bytes = str.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                int length = m + bytes.length;
                function2.invoke(str, Integer.valueOf(length));
                i += length;
            }
            return i;
        }

        private final void p(String str, Integer num) {
            SharedPreferences.Editor edit = this.b.edit();
            edit.putInt("size", this.c);
            if (str != null) {
                if (num == null) {
                    edit.remove(str);
                } else {
                    edit.putInt(str, num.intValue());
                }
            }
            edit.apply();
        }

        private final int h(SharedPreferences sharedPreferences, Function2<? super String, ? super Integer, Unit> function2) {
            Set<Map.Entry<String, ?>> entrySet = sharedPreferences.getAll().entrySet();
            ArrayList<Map.Entry> arrayList = new ArrayList();
            for (Object obj : entrySet) {
                if (((Map.Entry) obj).getValue() instanceof String) {
                    arrayList.add(obj);
                }
            }
            int i = 0;
            for (Map.Entry entry : arrayList) {
                d dVar = d.a;
                Object key = entry.getKey();
                Intrinsics.checkNotNullExpressionValue(key, "<get-key>(...)");
                Object value = entry.getValue();
                Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.String");
                int a = dVar.a((String) key, null, (String) value);
                Object key2 = entry.getKey();
                Intrinsics.checkNotNullExpressionValue(key2, "<get-key>(...)");
                function2.invoke(key2, Integer.valueOf(a));
                i += a;
            }
            return i;
        }

        @Override // com.dragon.read.local.storage.JsStorageManagerV2.c
        public ResultCode a(String key, String value) {
            int i;
            ResultCode resultCode;
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(value, "value");
            ReentrantReadWriteLock reentrantReadWriteLock = this.a;
            ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
            int i2 = 0;
            if (reentrantReadWriteLock.getWriteHoldCount() == 0) {
                i = reentrantReadWriteLock.getReadHoldCount();
            } else {
                i = 0;
            }
            for (int i3 = 0; i3 < i; i3++) {
                readLock.unlock();
            }
            ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
            writeLock.lock();
            try {
                SharedPreferences f2 = f(key);
                d dVar = d.a;
                Pair<Boolean, Integer> n = n(dVar.a(key, f2.getString(key, null), value));
                boolean booleanValue = n.component1().booleanValue();
                int intValue = n.component2().intValue();
                if (booleanValue) {
                    this.c = intValue;
                    p(key, Integer.valueOf(dVar.a(key, null, value)));
                    f2.edit().putString(key, value).apply();
                    LogWrapper.info("js_storage_v2", "key " + key + " written, sp index: " + e(key), new Object[0]);
                    resultCode = ResultCode.SUCCESS;
                } else {
                    LogWrapper.warn("js_storage_v2", "key " + key + " value size exceed limit, excepted: " + this.d + ", actual " + intValue, new Object[0]);
                    resultCode = ResultCode.BEYOND_OCCUPY;
                }
                return resultCode;
            } finally {
                while (i2 < i) {
                    readLock.lock();
                    i2++;
                }
                writeLock.unlock();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit k(Map map, String key, int i) {
            int i2;
            Intrinsics.checkNotNullParameter(key, "key");
            Integer num = (Integer) map.get(key);
            if (num != null) {
                i2 = num.intValue();
            } else {
                i2 = 0;
            }
            map.put(key, Integer.valueOf(i2 + i));
            return Unit.INSTANCE;
        }

        static /* synthetic */ void q(a aVar, String str, Integer num, int i, Object obj) {
            if ((i & 1) != 0) {
                str = null;
            }
            if ((i & 2) != 0) {
                num = null;
            }
            aVar.p(str, num);
        }
    }

    public static final class b implements c {
        public static final int e;
        private final Map<String, String> a;
        private final int b;
        private int c;
        private final ReentrantReadWriteLock d;

        static {
            Covode.recordClassIndex(611942);
            e = 8;
        }

        @Override // com.dragon.read.local.storage.JsStorageManagerV2.c
        public int getSize() {
            return this.c;
        }

        public b() {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            this.a = linkedHashMap;
            this.d = new ReentrantReadWriteLock();
            this.b = i.b().maxMemoryOccupy;
            this.c = 0;
            linkedHashMap.clear();
        }

        @Override // com.dragon.read.local.storage.JsStorageManagerV2.c
        public Pair<ResultCode, String> b(String key) {
            Pair<ResultCode, String> pair;
            Intrinsics.checkNotNullParameter(key, "key");
            ReentrantReadWriteLock.ReadLock readLock = this.d.readLock();
            readLock.lock();
            try {
                String str = this.a.get(key);
                if (str == null) {
                    pair = TuplesKt.to(ResultCode.NO_KEY, "");
                } else {
                    pair = TuplesKt.to(ResultCode.SUCCESS, str);
                }
                return pair;
            } finally {
                readLock.unlock();
            }
        }

        @Override // com.dragon.read.local.storage.JsStorageManagerV2.c
        public ResultCode c(String key) {
            int i;
            ResultCode resultCode;
            Intrinsics.checkNotNullParameter(key, "key");
            ReentrantReadWriteLock reentrantReadWriteLock = this.d;
            ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
            int i2 = 0;
            if (reentrantReadWriteLock.getWriteHoldCount() == 0) {
                i = reentrantReadWriteLock.getReadHoldCount();
            } else {
                i = 0;
            }
            for (int i3 = 0; i3 < i; i3++) {
                readLock.unlock();
            }
            ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
            writeLock.lock();
            try {
                String remove = this.a.remove(key);
                if (remove == null) {
                    resultCode = ResultCode.NO_KEY;
                } else {
                    this.c -= d.a.a(key, null, remove);
                    resultCode = ResultCode.SUCCESS;
                }
                return resultCode;
            } finally {
                while (i2 < i) {
                    readLock.lock();
                    i2++;
                }
                writeLock.unlock();
            }
        }

        @Override // com.dragon.read.local.storage.JsStorageManagerV2.c
        public ResultCode a(String key, String value) {
            int i;
            ResultCode resultCode;
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(value, "value");
            ReentrantReadWriteLock reentrantReadWriteLock = this.d;
            ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
            int i2 = 0;
            if (reentrantReadWriteLock.getWriteHoldCount() == 0) {
                i = reentrantReadWriteLock.getReadHoldCount();
            } else {
                i = 0;
            }
            for (int i3 = 0; i3 < i; i3++) {
                readLock.unlock();
            }
            ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
            writeLock.lock();
            try {
                int a = d.a.a(key, this.a.get(key), value) + this.c;
                if (a <= this.b) {
                    this.a.put(key, value);
                    this.c = a;
                    resultCode = ResultCode.SUCCESS;
                } else {
                    this.a.clear();
                    resultCode = ResultCode.BEYOND_OCCUPY;
                }
                return resultCode;
            } finally {
                while (i2 < i) {
                    readLock.lock();
                    i2++;
                }
                writeLock.unlock();
            }
        }
    }

    private JsStorageManagerV2() {
    }

    static {
        boolean z;
        Map<StorageType, c> mutableMapOf;
        Covode.recordClassIndex(611938);
        g = new JsStorageManagerV2();
        JsStorageConfigModel b2 = i.b();
        LogWrapper.debug("js_storage_v2", "config: " + b2, new Object[0]);
        if (b2.openJsStorage == 1) {
            z = true;
        } else {
            z = false;
        }
        i = z;
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(StorageType.DISK, new a()), TuplesKt.to(StorageType.MEMORY, new b()));
        h = mutableMapOf;
        j = 8;
    }

    private final c f(boolean z) {
        if (z) {
            c cVar = h.get(StorageType.DISK);
            Intrinsics.checkNotNull(cVar);
            return cVar;
        }
        c cVar2 = h.get(StorageType.MEMORY);
        Intrinsics.checkNotNull(cVar2);
        return cVar2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final JSONObject g(JSONObject jSONObject, ResultCode resultCode) {
        JSONObject jSONObject2;
        if (jSONObject != null) {
            try {
                Result.Companion companion = Result.Companion;
                jSONObject2 = Result.m773constructorimpl(jSONObject.put("status", resultCode.getV()));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                jSONObject2 = Result.m773constructorimpl(ResultKt.createFailure(th));
            }
            if (!Result.m779isFailureimpl(jSONObject2)) {
                jSONObject = jSONObject2;
            }
            return jSONObject;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final JSONObject h(JSONObject jSONObject, String str) {
        JSONObject jSONObject2;
        if (jSONObject != null) {
            try {
                Result.Companion companion = Result.Companion;
                jSONObject2 = Result.m773constructorimpl(jSONObject.put("value", str));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                jSONObject2 = Result.m773constructorimpl(ResultKt.createFailure(th));
            }
            if (!Result.m779isFailureimpl(jSONObject2)) {
                jSONObject = jSONObject2;
            }
            return jSONObject;
        }
        return null;
    }

    public static final class d {
        public static final d a;

        static {
            Covode.recordClassIndex(611946);
            a = new d();
        }

        private d() {
        }

        public final int a(String key, String str, String newValue) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(newValue, "newValue");
            if (str == null) {
                Charset charset = Charsets.UTF_8;
                byte[] bytes = key.getBytes(charset);
                Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                int length = bytes.length;
                byte[] bytes2 = newValue.getBytes(charset);
                Intrinsics.checkNotNullExpressionValue(bytes2, "getBytes(...)");
                return length + bytes2.length;
            }
            Charset charset2 = Charsets.UTF_8;
            byte[] bytes3 = newValue.getBytes(charset2);
            Intrinsics.checkNotNullExpressionValue(bytes3, "getBytes(...)");
            int length2 = bytes3.length;
            byte[] bytes4 = str.getBytes(charset2);
            Intrinsics.checkNotNullExpressionValue(bytes4, "getBytes(...)");
            return length2 - bytes4.length;
        }

        public final void b(String key, String str, ActionType actionType, boolean z, ResultCode resultCode, int i) {
            StorageType storageType;
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(actionType, "actionType");
            Intrinsics.checkNotNullParameter(resultCode, "resultCode");
            if (z) {
                storageType = StorageType.DISK;
            } else {
                storageType = StorageType.MEMORY;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                jSONObject.put("type", storageType.getV()).put("action", actionType.getV()).put("key", key).put("result", resultCode.getV());
                jSONObject2.put("total", i);
                if (str != null) {
                    jSONObject2.put("set_size", a(key, null, str));
                }
                MonitorUtils.monitorEvent("js_storage_action", jSONObject, jSONObject2, (JSONObject) null);
            } catch (Throwable th) {
                LogWrapper.warn("js_storage_v2", "create report json failed " + th.getMessage(), new Object[0]);
            }
        }
    }

    @Override // com.dragon.read.local.storage.a
    public JSONObject a(String str, boolean z, JSONObject jSONObject) {
        c f = f(z);
        if (!i) {
            JSONObject g2 = g(jSONObject, ResultCode.CLOSE);
            LogWrapper.warn("js_storage_v2", "[getStorage] key = " + str + ", storage disabled", new Object[0]);
            return g2;
        }
        if (str == null) {
            JSONObject g3 = g(jSONObject, ResultCode.NULL_KEY);
            LogWrapper.warn("js_storage_v2", "[getStorage] key = " + str + ", key is null", new Object[0]);
            return g3;
        }
        if (jSONObject == null) {
            JSONObject parseJSONObject = JSONUtils.parseJSONObject(f.b(str).getSecond());
            LogWrapper.info("js_storage_v2", "[getStorage] key = " + str + ", resp is " + g, new Object[0]);
            return parseJSONObject;
        }
        Pair<ResultCode, String> b2 = f.b(str);
        d.a.b(str, null, ActionType.GET, z, b2.getFirst(), f.getSize());
        LogWrapper.info("js_storage_v2", "[getStorage] key = " + str + ", code = " + b2.getFirst().getV(), new Object[0]);
        JsStorageManagerV2 jsStorageManagerV2 = g;
        return jsStorageManagerV2.h(jsStorageManagerV2.g(jSONObject, b2.getFirst()), b2.getSecond());
    }

    @Override // com.dragon.read.local.storage.a
    public JSONObject c(String str, boolean z, JSONObject jSONObject) {
        c f = f(z);
        if (!i) {
            JSONObject g2 = g(jSONObject, ResultCode.CLOSE);
            LogWrapper.warn("js_storage_v2", "[removeStorage] key = " + str + ", storage disabled", new Object[0]);
            return g2;
        }
        if (str == null) {
            JSONObject g3 = g(jSONObject, ResultCode.NULL_KEY);
            LogWrapper.warn("js_storage_v2", "[removeStorage] key = " + str + ", key is null", new Object[0]);
            return g3;
        }
        ResultCode c2 = f.c(str);
        d.a.b(str, null, ActionType.REMOVE, z, c2, f.getSize());
        LogWrapper.info("js_storage_v2", "[removeStorage] key = " + str + ", code = " + c2.getV(), new Object[0]);
        return g.g(jSONObject, c2);
    }

    @Override // com.dragon.read.local.storage.a
    public JSONObject d(String str, String str2, boolean z, JSONObject jSONObject) {
        c f = f(z);
        if (!i) {
            JSONObject g2 = g(jSONObject, ResultCode.CLOSE);
            LogWrapper.warn("js_storage_v2", "[setStorage] key = " + str + ", storage disabled", new Object[0]);
            return g2;
        }
        if (str == null) {
            JSONObject g3 = g(jSONObject, ResultCode.NULL_KEY);
            LogWrapper.warn("js_storage_v2", "[setStorage] key = " + str + ", key is null", new Object[0]);
            return g3;
        }
        if (str2 == null) {
            return c(str, z, jSONObject);
        }
        ResultCode a2 = f.a(str, str2);
        d.a.b(str, str2, ActionType.SET, z, a2, f.getSize());
        LogWrapper.info("js_storage_v2", "[setStorage] key = " + str + ", code = " + a2.getV(), new Object[0]);
        return g.g(jSONObject, a2);
    }
}
