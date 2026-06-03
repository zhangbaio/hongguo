package com.dragon.read.multigenre.factory;

import com.bytedance.covode.number.Covode;
import com.dragon.read.multigenre.factory.a;
import com.dragon.read.util.UiConfigSetter;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public interface b<T> extends com.dragon.read.multigenre.factory.a {
    T b();

    public static final class a {
        static {
            Covode.recordClassIndex(612388);
        }

        public static <T> boolean a(b<T> bVar) {
            return true;
        }

        public static <T> UiConfigSetter.e b(b<T> bVar) {
            return a.C0090a.a(bVar);
        }
    }
}
