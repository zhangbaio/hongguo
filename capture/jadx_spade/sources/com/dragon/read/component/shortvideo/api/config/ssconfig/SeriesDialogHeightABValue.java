package com.dragon.read.component.shortvideo.api.config.ssconfig;

import com.bytedance.covode.number.Covode;
import com.google.gson.annotations.SerializedName;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.math.MathKt__MathJVMKt;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class SeriesDialogHeightABValue {
    public static final a a;
    private static final Lazy<SeriesDialogHeightABValue> b;

    @SerializedName("is_ceiling")
    public final boolean enableDrag;

    @SerializedName("percent")
    public final float heightPercent;

    @SerializedName("style")
    public final int style;

    public SeriesDialogHeightABValue() {
        this(0, false, 0.0f, 7, null);
    }

    public static final class a {
        static {
            Covode.recordClassIndex(598471);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean c() {
            return d().enableDrag;
        }

        private final SeriesDialogHeightABValue d() {
            return (SeriesDialogHeightABValue) SeriesDialogHeightABValue.b.getValue();
        }

        public final int a() {
            int roundToInt;
            roundToInt = MathKt__MathJVMKt.roundToInt(d().heightPercent * 100);
            return roundToInt;
        }

        public final boolean b() {
            if (d().style > 0) {
                return true;
            }
            return false;
        }
    }

    static {
        Lazy<SeriesDialogHeightABValue> lazy;
        Covode.recordClassIndex(598470);
        a = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.dragon.read.component.shortvideo.api.config.ssconfig.j1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                SeriesDialogHeightABValue c;
                c = SeriesDialogHeightABValue.c();
                return c;
            }
        });
        b = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SeriesDialogHeightABValue c() {
        SeriesDialogHeightABValue seriesDialogHeightABValue = new SeriesDialogHeightABValue(0, false, 0.0f, 7, null);
        SeriesDialogHeightABValue seriesDialogHeightABValue2 = (SeriesDialogHeightABValue) qq3.a.a("episode_height_ab_style_v631", seriesDialogHeightABValue, true);
        if (seriesDialogHeightABValue2.style > 0) {
            return seriesDialogHeightABValue2;
        }
        return seriesDialogHeightABValue;
    }

    public SeriesDialogHeightABValue(int i, boolean z, float f) {
        this.style = i;
        this.enableDrag = z;
        this.heightPercent = f;
    }

    public /* synthetic */ SeriesDialogHeightABValue(int i, boolean z, float f, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? false : z, (i2 & 4) != 0 ? 0.5f : f);
    }
}
