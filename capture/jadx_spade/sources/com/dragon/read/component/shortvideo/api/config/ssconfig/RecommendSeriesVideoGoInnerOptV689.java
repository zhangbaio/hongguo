package com.dragon.read.component.shortvideo.api.config.ssconfig;

import com.bytedance.covode.number.Covode;
import com.google.gson.annotations.SerializedName;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class RecommendSeriesVideoGoInnerOptV689 {
    public static final a a;
    private static final Lazy<RecommendSeriesVideoGoInnerOptV689> b;

    @SerializedName("video_name")
    public final String descPrefix;

    @SerializedName("type")
    public final int type;

    /* JADX WARN: Multi-variable type inference failed */
    public RecommendSeriesVideoGoInnerOptV689() {
        this(0, null, 3, 0 == true ? 1 : 0);
    }

    public static final class a {
        static {
            Covode.recordClassIndex(598454);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final RecommendSeriesVideoGoInnerOptV689 a() {
            return (RecommendSeriesVideoGoInnerOptV689) RecommendSeriesVideoGoInnerOptV689.b.getValue();
        }
    }

    static {
        Lazy<RecommendSeriesVideoGoInnerOptV689> lazy;
        Covode.recordClassIndex(598453);
        a = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.dragon.read.component.shortvideo.api.config.ssconfig.d1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                RecommendSeriesVideoGoInnerOptV689 c;
                c = RecommendSeriesVideoGoInnerOptV689.c();
                return c;
            }
        });
        b = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final RecommendSeriesVideoGoInnerOptV689 c() {
        return (RecommendSeriesVideoGoInnerOptV689) qq3.a.b("recommend_series_video_rerun_optimize_v693", new RecommendSeriesVideoGoInnerOptV689(0, null, 3, 0 == true ? 1 : 0), true);
    }

    public RecommendSeriesVideoGoInnerOptV689(int i, String str) {
        this.type = i;
        this.descPrefix = str;
    }

    public /* synthetic */ RecommendSeriesVideoGoInnerOptV689(int i, String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? null : str);
    }
}
