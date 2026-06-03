package com.dragon.read.kmp.shortvideo.distribution.infinite;

import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.shortvideo.distribution.model.FilterType;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public interface f {
    void a(d dVar, FilterType filterType);

    void b(boolean z, FilterType filterType);

    void c(d dVar, FilterType filterType);

    void d(d dVar);

    void e(d dVar);

    public static final class a {
        static {
            Covode.recordClassIndex(609028);
        }

        public static void a(f fVar, boolean z, FilterType filterType) {
            Intrinsics.checkNotNullParameter(filterType, "filterType");
        }

        public static void b(f fVar, d selectorItem) {
            Intrinsics.checkNotNullParameter(selectorItem, "selectorItem");
        }

        public static void c(f fVar, d filterItem, FilterType filterType) {
            Intrinsics.checkNotNullParameter(filterItem, "filterItem");
            Intrinsics.checkNotNullParameter(filterType, "filterType");
        }

        public static void e(f fVar, d filterItem) {
            Intrinsics.checkNotNullParameter(filterItem, "filterItem");
        }

        public static /* synthetic */ void d(f fVar, d dVar, FilterType filterType, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    filterType = FilterType.DEFAULT;
                }
                fVar.c(dVar, filterType);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showInnerFiniteItem");
        }
    }
}
