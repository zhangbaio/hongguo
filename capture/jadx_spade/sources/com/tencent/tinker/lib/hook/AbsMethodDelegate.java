package com.tencent.tinker.lib.hook;

import com.bytedance.covode.number.Covode;
import java.lang.reflect.Method;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public abstract class AbsMethodDelegate {
    static {
        Covode.recordClassIndex(653743);
    }

    public Object afterInvoke(Object obj, Method method, Object[] objArr, Object obj2) {
        return obj2;
    }

    public Object beforeInvoke(Object obj, Method method, Object[] objArr) {
        return null;
    }
}
