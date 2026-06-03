package com.dragon.read.component.shortvideo.api.config.ssconfig;

import com.bytedance.covode.number.Covode;
import com.google.gson.annotations.SerializedName;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class MorePanelLongPressV715 {
    public static final a a;
    private static final Lazy<MorePanelLongPressV715> b;

    @SerializedName("enable")
    public final boolean enable;

    @SerializedName("mode")
    public final int mode;

    /* JADX WARN: Multi-variable type inference failed */
    public MorePanelLongPressV715() {
        this(false, 0 == true ? 1 : 0, 3, null);
    }

    public static final class a {
        static {
            Covode.recordClassIndex(598389);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final MorePanelLongPressV715 a() {
            return (MorePanelLongPressV715) MorePanelLongPressV715.b.getValue();
        }
    }

    static {
        Lazy<MorePanelLongPressV715> lazy;
        Covode.recordClassIndex(598388);
        a = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.dragon.read.component.shortvideo.api.config.ssconfig.e0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                MorePanelLongPressV715 c;
                c = MorePanelLongPressV715.c();
                return c;
            }
        });
        b = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final MorePanelLongPressV715 c() {
        return (MorePanelLongPressV715) qq3.a.c("short_viedo_panel_long_press_config_v719", new MorePanelLongPressV715(false, 0 == true ? 1 : 0, 3, null), false, 4, null);
    }

    public final float d() {
        int i = this.mode;
        if (i != 2) {
            if (i != 3) {
                return 0.33333334f;
            }
            return 0.6f;
        }
        return 0.8f;
    }

    public MorePanelLongPressV715(boolean z, int i) {
        this.enable = z;
        this.mode = i;
    }

    public /* synthetic */ MorePanelLongPressV715(boolean z, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? false : z, (i2 & 2) != 0 ? 0 : i);
    }
}
