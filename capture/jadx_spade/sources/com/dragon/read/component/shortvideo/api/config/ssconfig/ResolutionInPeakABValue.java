package com.dragon.read.component.shortvideo.api.config.ssconfig;

import com.bytedance.covode.number.Covode;
import com.google.gson.annotations.SerializedName;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class ResolutionInPeakABValue {
    public static final a a;
    private static final Lazy<ResolutionInPeakABValue> b;

    @SerializedName("resolution_type")
    public final int resolutionType;

    @SerializedName("resolution_type_for_low")
    public final int resolutionTypeForLow;

    @SerializedName("resolution_type_for_mid_low")
    public final int resolutionTypeForMidLow;

    public ResolutionInPeakABValue() {
        this(0, 0, 0, 7, null);
    }

    public static final class a {
        static {
            Covode.recordClassIndex(598461);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ResolutionInPeakABValue a() {
            return (ResolutionInPeakABValue) ResolutionInPeakABValue.b.getValue();
        }
    }

    static {
        Lazy<ResolutionInPeakABValue> lazy;
        Covode.recordClassIndex(598460);
        a = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.dragon.read.component.shortvideo.api.config.ssconfig.f1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                ResolutionInPeakABValue c;
                c = ResolutionInPeakABValue.c();
                return c;
            }
        });
        b = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ResolutionInPeakABValue c() {
        return (ResolutionInPeakABValue) qq3.a.a("resolution_in_peak_v629", new ResolutionInPeakABValue(0, 0, 0, 7, null), true);
    }

    public ResolutionInPeakABValue(int i, int i2, int i3) {
        this.resolutionType = i;
        this.resolutionTypeForMidLow = i2;
        this.resolutionTypeForLow = i3;
    }

    public /* synthetic */ ResolutionInPeakABValue(int i, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? 0 : i, (i4 & 2) != 0 ? 0 : i2, (i4 & 4) != 0 ? 0 : i3);
    }
}
