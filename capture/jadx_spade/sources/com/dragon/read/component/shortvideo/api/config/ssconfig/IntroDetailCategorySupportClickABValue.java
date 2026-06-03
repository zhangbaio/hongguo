package com.dragon.read.component.shortvideo.api.config.ssconfig;

import com.bytedance.covode.number.Covode;
import com.google.gson.annotations.SerializedName;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class IntroDetailCategorySupportClickABValue {
    public static final a a;
    private static final Lazy<IntroDetailCategorySupportClickABValue> b;

    @SerializedName("enable")
    public final boolean enable;

    public static final class a {
        static {
            Covode.recordClassIndex(598381);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public IntroDetailCategorySupportClickABValue() {
        this(false, 1, null);
    }

    static {
        Lazy<IntroDetailCategorySupportClickABValue> lazy;
        Covode.recordClassIndex(598380);
        a = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.dragon.read.component.shortvideo.api.config.ssconfig.b0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                IntroDetailCategorySupportClickABValue b2;
                b2 = IntroDetailCategorySupportClickABValue.b();
                return b2;
            }
        });
        b = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IntroDetailCategorySupportClickABValue b() {
        return (IntroDetailCategorySupportClickABValue) qq3.a.a("intro_detail_category_support_click_v637", new IntroDetailCategorySupportClickABValue(false, 1, null), true);
    }

    public IntroDetailCategorySupportClickABValue(boolean z) {
        this.enable = z;
    }

    public /* synthetic */ IntroDetailCategorySupportClickABValue(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z);
    }
}
