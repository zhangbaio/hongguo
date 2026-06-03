package com.dragon.read.component.shortvideo.api.config.ssconfig;

import com.bytedance.covode.number.Covode;
import com.dragon.read.component.shortvideo.api.config.base.ISeriesAbValueApi;
import com.google.gson.annotations.SerializedName;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class ShortVideoUiOpt {
    public static final a a;
    private static final Lazy<ShortVideoUiOpt> b;

    @SerializedName("bg_color")
    public final String bgColor;

    @SerializedName("bg_mode")
    public final int bgMode;

    @SerializedName("hide_mask")
    public final boolean hideMask;

    public ShortVideoUiOpt() {
        this(null, 0, false, 7, null);
    }

    public static final class a {
        static {
            Covode.recordClassIndex(598526);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ShortVideoUiOpt a() {
            return (ShortVideoUiOpt) ShortVideoUiOpt.b.getValue();
        }
    }

    static {
        Lazy<ShortVideoUiOpt> lazy;
        Covode.recordClassIndex(598525);
        a = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.dragon.read.component.shortvideo.api.config.ssconfig.c2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                ShortVideoUiOpt d;
                d = ShortVideoUiOpt.d();
                return d;
            }
        });
        b = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ShortVideoUiOpt d() {
        return (ShortVideoUiOpt) ISeriesAbValueApi.Companion.c().getABValue2("short_video_player_ui_opt", new ShortVideoUiOpt(null, 0, false, 7, null), false);
    }

    public final boolean c(Boolean bool) {
        int i;
        if (Intrinsics.areEqual(bool, Boolean.FALSE)) {
            i = this.bgMode & 1;
        } else {
            i = this.bgMode & 2;
        }
        if (i != 0) {
            return true;
        }
        return false;
    }

    public ShortVideoUiOpt(String str, int i, boolean z) {
        this.bgColor = str;
        this.bgMode = i;
        this.hideMask = z;
    }

    public /* synthetic */ ShortVideoUiOpt(String str, int i, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? 1 : i, (i2 & 4) != 0 ? true : z);
    }
}
