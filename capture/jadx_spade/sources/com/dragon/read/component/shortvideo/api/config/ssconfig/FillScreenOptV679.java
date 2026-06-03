package com.dragon.read.component.shortvideo.api.config.ssconfig;

import com.bytedance.covode.number.Covode;
import com.google.gson.annotations.SerializedName;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class FillScreenOptV679 {
    public static final a a;
    private static final Lazy<FillScreenOptV679> b;

    @SerializedName("default_video_size_aspect_fit")
    public final boolean defaultVideoSizeAspectFit;

    @SerializedName("enable_add_canvas_opt")
    public final boolean enableAddCanvasOpt;

    @SerializedName("enable_setting_ui_opt")
    public final boolean enableSettingUIOpt;

    public FillScreenOptV679() {
        this(false, false, false, 7, null);
    }

    public static final class a {
        static {
            Covode.recordClassIndex(598355);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final FillScreenOptV679 a() {
            return (FillScreenOptV679) FillScreenOptV679.b.getValue();
        }
    }

    static {
        Lazy<FillScreenOptV679> lazy;
        Covode.recordClassIndex(598354);
        a = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.dragon.read.component.shortvideo.api.config.ssconfig.s
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                FillScreenOptV679 c;
                c = FillScreenOptV679.c();
                return c;
            }
        });
        b = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FillScreenOptV679 c() {
        return (FillScreenOptV679) qq3.a.c("short_video_setting_opt_v679", new FillScreenOptV679(false, false, false, 7, null), false, 4, null);
    }

    public FillScreenOptV679(boolean z, boolean z2, boolean z3) {
        this.enableAddCanvasOpt = z;
        this.enableSettingUIOpt = z2;
        this.defaultVideoSizeAspectFit = z3;
    }

    public /* synthetic */ FillScreenOptV679(boolean z, boolean z2, boolean z3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? false : z2, (i & 4) != 0 ? false : z3);
    }
}
