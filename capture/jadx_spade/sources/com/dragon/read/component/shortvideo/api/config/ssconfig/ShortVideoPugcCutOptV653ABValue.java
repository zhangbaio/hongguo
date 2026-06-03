package com.dragon.read.component.shortvideo.api.config.ssconfig;

import com.bytedance.covode.number.Covode;
import com.dragon.read.component.shortvideo.api.config.base.ISeriesAbValueApi;
import com.google.gson.annotations.SerializedName;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class ShortVideoPugcCutOptV653ABValue {
    public static final a a;
    private static final Lazy<ShortVideoPugcCutOptV653ABValue> b;

    @SerializedName("pugc_cut_type")
    public final int pugcCutType;

    public ShortVideoPugcCutOptV653ABValue() {
        this(0, 1, null);
    }

    public static final class a {
        static {
            Covode.recordClassIndex(598522);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ShortVideoPugcCutOptV653ABValue a() {
            return (ShortVideoPugcCutOptV653ABValue) ShortVideoPugcCutOptV653ABValue.b.getValue();
        }
    }

    static {
        Lazy<ShortVideoPugcCutOptV653ABValue> lazy;
        Covode.recordClassIndex(598521);
        a = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.dragon.read.component.shortvideo.api.config.ssconfig.a2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                ShortVideoPugcCutOptV653ABValue c;
                c = ShortVideoPugcCutOptV653ABValue.c();
                return c;
            }
        });
        b = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ShortVideoPugcCutOptV653ABValue c() {
        return (ShortVideoPugcCutOptV653ABValue) ISeriesAbValueApi.Companion.c().getABValue2("short_video_pugc_cut_opt_v653", new ShortVideoPugcCutOptV653ABValue(0, 1, null), true);
    }

    public ShortVideoPugcCutOptV653ABValue(int i) {
        this.pugcCutType = i;
    }

    public /* synthetic */ ShortVideoPugcCutOptV653ABValue(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? -1 : i);
    }
}
