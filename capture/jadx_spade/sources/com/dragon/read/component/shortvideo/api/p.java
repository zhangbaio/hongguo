package com.dragon.read.component.shortvideo.api;

import com.bytedance.covode.number.Covode;
import com.dragon.read.component.shortvideo.api.model.DataSource;
import io.reactivex.Single;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public interface p {

    public static final class a {
        static {
            Covode.recordClassIndex(598146);
        }

        public static int a(p pVar, String seriesId) {
            Intrinsics.checkNotNullParameter(seriesId, "seriesId");
            return -1;
        }

        public static Single<DataSource> b(p pVar) {
            return null;
        }

        public static Single<DataSource> c(p pVar) {
            return null;
        }

        public static Single<DataSource> d(p pVar) {
            return null;
        }
    }

    Single<DataSource> K1();

    Single<DataSource> L1();

    int M1(String str);

    Single<DataSource> e();
}
