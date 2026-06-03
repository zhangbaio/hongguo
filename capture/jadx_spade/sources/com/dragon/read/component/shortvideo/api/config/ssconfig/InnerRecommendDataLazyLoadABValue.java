package com.dragon.read.component.shortvideo.api.config.ssconfig;

import com.bytedance.covode.number.Covode;
import com.google.gson.annotations.SerializedName;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class InnerRecommendDataLazyLoadABValue {
    public static final a a;
    private static final Lazy<InnerRecommendDataLazyLoadABValue> b;

    @SerializedName("enable")
    public final boolean enable;

    public InnerRecommendDataLazyLoadABValue() {
        this(false, 1, null);
    }

    public static final class a {
        static {
            Covode.recordClassIndex(598376);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean b() {
            return a().enable;
        }

        private final InnerRecommendDataLazyLoadABValue a() {
            return (InnerRecommendDataLazyLoadABValue) InnerRecommendDataLazyLoadABValue.b.getValue();
        }
    }

    static {
        Lazy<InnerRecommendDataLazyLoadABValue> lazy;
        Covode.recordClassIndex(598375);
        a = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.dragon.read.component.shortvideo.api.config.ssconfig.z
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                InnerRecommendDataLazyLoadABValue c;
                c = InnerRecommendDataLazyLoadABValue.c();
                return c;
            }
        });
        b = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InnerRecommendDataLazyLoadABValue c() {
        return (InnerRecommendDataLazyLoadABValue) qq3.a.c("inner_recommend_data_lazy_load_665", new InnerRecommendDataLazyLoadABValue(false, 1, null), false, 4, null);
    }

    public InnerRecommendDataLazyLoadABValue(boolean z) {
        this.enable = z;
    }

    public /* synthetic */ InnerRecommendDataLazyLoadABValue(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z);
    }
}
