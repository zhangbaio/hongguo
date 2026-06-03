package com.dragon.read.component.shortvideo.data.saas.model;

import com.bytedance.covode.number.Covode;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.annotation.AnnotationRetention;

@Retention(RetentionPolicy.SOURCE)
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public @interface SaasRefreshType {
    public static final a Companion;

    public static final class a {
        static final /* synthetic */ a a;

        static {
            Covode.recordClassIndex(599072);
            a = new a();
        }

        private a() {
        }

        public final boolean a(int i) {
            return i == 5 || i == 6 || i == 7 || i == 11 || i == 12 || i == 13 || i == 14;
        }

        public final boolean b(int i) {
            return i == 1 || i == 0;
        }
    }

    static {
        Covode.recordClassIndex(599071);
        Companion = a.a;
    }
}
