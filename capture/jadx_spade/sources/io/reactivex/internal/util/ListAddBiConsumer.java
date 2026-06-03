package io.reactivex.internal.util;

import com.bytedance.covode.number.Covode;
import io.reactivex.functions.BiFunction;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public enum ListAddBiConsumer implements BiFunction<List, Object, List> {
    INSTANCE;

    public static <T> BiFunction<List<T>, T, List<T>> instance() {
        return INSTANCE;
    }

    static {
        Covode.recordClassIndex(657734);
    }

    @Override // io.reactivex.functions.BiFunction
    public List apply(List list, Object obj) throws Exception {
        list.add(obj);
        return list;
    }
}
