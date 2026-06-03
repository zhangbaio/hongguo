package com.dragon.read.component.shortvideo.api.config.ssconfig;

import com.bytedance.covode.number.Covode;
import com.dragon.read.component.shortvideo.api.config.base.ISeriesAbValueApi;
import com.google.gson.annotations.SerializedName;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class FullscreenButtonHideConfig {
    public static final a a;
    private static final Lazy<FullscreenButtonHideConfig> b;

    @SerializedName("enable")
    public final boolean enable;

    public FullscreenButtonHideConfig() {
        this(false, 1, null);
    }

    public static final class a {
        static {
            Covode.recordClassIndex(598359);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final FullscreenButtonHideConfig a() {
            return (FullscreenButtonHideConfig) FullscreenButtonHideConfig.b.getValue();
        }
    }

    static {
        Lazy<FullscreenButtonHideConfig> lazy;
        Covode.recordClassIndex(598358);
        a = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.dragon.read.component.shortvideo.api.config.ssconfig.u
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                FullscreenButtonHideConfig c;
                c = FullscreenButtonHideConfig.c();
                return c;
            }
        });
        b = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FullscreenButtonHideConfig c() {
        return (FullscreenButtonHideConfig) ISeriesAbValueApi.Companion.c().getABValue2("hide_full_screen_button_when_dialog_show_enable", new FullscreenButtonHideConfig(false, 1, null), true);
    }

    public FullscreenButtonHideConfig(boolean z) {
        this.enable = z;
    }

    public /* synthetic */ FullscreenButtonHideConfig(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z);
    }
}
