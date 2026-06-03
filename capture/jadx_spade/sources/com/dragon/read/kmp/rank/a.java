package com.dragon.read.kmp.rank;

import android.view.ViewGroup;
import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a extends me4.e<re4.e, CrossRank2ColModel> {
    public static final int n;
    private final az2.c m;

    static {
        Covode.recordClassIndex(608227);
        n = 8;
    }

    public uh4.a M2() {
        return new C0035a();
    }

    /* renamed from: com.dragon.read.kmp.rank.a$a, reason: collision with other inner class name */
    public static final class C0035a implements uh4.a {
        C0035a() {
        }

        public int a(int i) {
            return a.this.m.a(i);
        }

        public void b(int i) {
            a.this.m.b(i);
        }
    }

    /* renamed from: Z2, reason: merged with bridge method [inline-methods] */
    public yh4.g<re4.e> N2(re4.e kmpModel, wh4.i depend) {
        Intrinsics.checkNotNullParameter(kmpModel, "kmpModel");
        Intrinsics.checkNotNullParameter(depend, "depend");
        return new q(depend);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(q64.r staggeredFeedDepend, ViewGroup parentViewGroup, az2.c viewModelService) {
        super(staggeredFeedDepend, parentViewGroup);
        Intrinsics.checkNotNullParameter(staggeredFeedDepend, "staggeredFeedDepend");
        Intrinsics.checkNotNullParameter(parentViewGroup, "parentViewGroup");
        Intrinsics.checkNotNullParameter(viewModelService, "viewModelService");
        this.m = viewModelService;
    }
}
