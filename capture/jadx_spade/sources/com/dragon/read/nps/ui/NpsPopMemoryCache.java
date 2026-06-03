package com.dragon.read.nps.ui;

import com.bytedance.covode.number.Covode;
import com.dragon.read.rpc.model.ResearchSceneType;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class NpsPopMemoryCache {
    public static final NpsPopMemoryCache a;
    private static ResultKey b;
    private static ResearchSceneType c;
    private static Map<Boolean, String> d;
    private static Map<Boolean, Map<String, Boolean>> e;
    private static boolean f;
    public static final int g;

    private NpsPopMemoryCache() {
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class ResultKey {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ ResultKey[] $VALUES;
        public static final ResultKey enum_average;
        public static final ResultKey enum_dissatisfied;
        public static final ResultKey enum_extremely_dissatisfied;
        public static final ResultKey enum_extremely_satisfied;
        public static final ResultKey enum_none;
        public static final ResultKey enum_satisfied;
        private final int number;

        private static final /* synthetic */ ResultKey[] $values() {
            return new ResultKey[]{enum_none, enum_extremely_dissatisfied, enum_dissatisfied, enum_average, enum_satisfied, enum_extremely_satisfied};
        }

        public static EnumEntries<ResultKey> getEntries() {
            return $ENTRIES;
        }

        public final int getNumber() {
            return this.number;
        }

        public static ResultKey[] values() {
            return (ResultKey[]) $VALUES.clone();
        }

        static {
            Covode.recordClassIndex(612581);
            enum_none = new ResultKey("enum_none", 0, -1);
            enum_extremely_dissatisfied = new ResultKey("enum_extremely_dissatisfied", 1, 1);
            enum_dissatisfied = new ResultKey("enum_dissatisfied", 2, 2);
            enum_average = new ResultKey("enum_average", 3, 3);
            enum_satisfied = new ResultKey("enum_satisfied", 4, 4);
            enum_extremely_satisfied = new ResultKey("enum_extremely_satisfied", 5, 5);
            ResultKey[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        public static ResultKey valueOf(String str) {
            return (ResultKey) Enum.valueOf(ResultKey.class, str);
        }

        private ResultKey(String str, int i, int i2) {
            this.number = i2;
        }
    }

    public final boolean c() {
        return f;
    }

    public final ResultKey e() {
        return b;
    }

    public final void a() {
        b = ResultKey.enum_none;
        e.clear();
        d.clear();
        f = false;
        c = null;
    }

    static {
        Covode.recordClassIndex(612580);
        a = new NpsPopMemoryCache();
        b = ResultKey.enum_none;
        d = new LinkedHashMap();
        e = new LinkedHashMap();
        g = 8;
    }

    public final void h(ResearchSceneType researchSceneType) {
        c = researchSceneType;
    }

    public final void j(boolean z) {
        f = z;
    }

    public final void k(int i) {
        b = f(i);
    }

    public final void l(ResultKey resultKey) {
        Intrinsics.checkNotNullParameter(resultKey, "<set-?>");
        b = resultKey;
    }

    public final String b(ResultKey selected) {
        Intrinsics.checkNotNullParameter(selected, "selected");
        return d.get(Boolean.valueOf(g(selected)));
    }

    public final ResultKey f(int i) {
        ResultKey resultKey;
        boolean z;
        ResultKey[] values = ResultKey.values();
        int length = values.length;
        int i2 = 0;
        while (true) {
            if (i2 < length) {
                resultKey = values[i2];
                if (resultKey.getNumber() == i) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    break;
                }
                i2++;
            } else {
                resultKey = null;
                break;
            }
        }
        if (resultKey == null) {
            return ResultKey.enum_none;
        }
        return resultKey;
    }

    public final boolean g(ResultKey selected) {
        Intrinsics.checkNotNullParameter(selected, "selected");
        if (selected.getNumber() <= ResultKey.enum_average.getNumber()) {
            return true;
        }
        return false;
    }

    public final Map<String, Boolean> d(ResultKey selected) {
        Intrinsics.checkNotNullParameter(selected, "selected");
        Map<String, Boolean> map = e.get(Boolean.valueOf(g(selected)));
        if (map == null) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            e.put(Boolean.valueOf(g(selected)), linkedHashMap);
            return linkedHashMap;
        }
        return map;
    }

    public final void i(ResultKey selected, String str) {
        Intrinsics.checkNotNullParameter(selected, "selected");
        d.put(Boolean.valueOf(g(selected)), str);
    }
}
