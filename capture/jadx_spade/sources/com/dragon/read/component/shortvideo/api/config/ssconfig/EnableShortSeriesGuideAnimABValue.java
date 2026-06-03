package com.dragon.read.component.shortvideo.api.config.ssconfig;

import com.bytedance.covode.number.Covode;
import com.google.gson.annotations.SerializedName;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class EnableShortSeriesGuideAnimABValue {
    public static final a a;
    private static final Lazy<EnableShortSeriesGuideAnimABValue> b;

    @SerializedName("enable")
    public final boolean enable;

    public static final class a {
        static {
            Covode.recordClassIndex(598344);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public EnableShortSeriesGuideAnimABValue() {
        this(false, 1, null);
    }

    static {
        Lazy<EnableShortSeriesGuideAnimABValue> lazy;
        Covode.recordClassIndex(598343);
        a = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.dragon.read.component.shortvideo.api.config.ssconfig.n
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                EnableShortSeriesGuideAnimABValue b2;
                b2 = EnableShortSeriesGuideAnimABValue.b();
                return b2;
            }
        });
        b = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EnableShortSeriesGuideAnimABValue b() {
        return (EnableShortSeriesGuideAnimABValue) qq3.a.b("enable_short_series_guide_anim_v657", new EnableShortSeriesGuideAnimABValue(false, 1, null), true);
    }

    public EnableShortSeriesGuideAnimABValue(boolean z) {
        this.enable = z;
    }

    public /* synthetic */ EnableShortSeriesGuideAnimABValue(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z);
    }
}
