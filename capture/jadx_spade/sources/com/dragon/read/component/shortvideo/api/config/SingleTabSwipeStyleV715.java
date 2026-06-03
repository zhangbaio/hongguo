package com.dragon.read.component.shortvideo.api.config;

import com.bytedance.covode.number.Covode;
import com.dragon.read.component.shortvideo.api.config.SingleTabSwipeStyleV715;
import com.dragon.read.component.shortvideo.api.config.base.ISeriesAbValueApi;
import com.google.gson.annotations.SerializedName;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class SingleTabSwipeStyleV715 {
    public static final a a;
    private static final Lazy<SingleTabSwipeStyleV715> b;
    private static final Lazy<Boolean> c;
    private static final boolean d;
    private static final boolean e;

    @SerializedName("enable_fps_opt")
    public final boolean enableFpsOpt;

    @SerializedName("enable_xml_preload")
    public final boolean enableXmlPreload;

    @SerializedName("enable_xml_preload_count")
    public final int enableXmlPreloadCount;

    @SerializedName("style")
    public final int style;

    public SingleTabSwipeStyleV715() {
        this(0, false, 0, false, 15, null);
    }

    public static final class a {
        static {
            Covode.recordClassIndex(598276);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a() {
            return SingleTabSwipeStyleV715.e;
        }

        public final boolean d() {
            return SingleTabSwipeStyleV715.d;
        }

        public final boolean b() {
            return ((Boolean) SingleTabSwipeStyleV715.c.getValue()).booleanValue();
        }

        public final SingleTabSwipeStyleV715 c() {
            return (SingleTabSwipeStyleV715) SingleTabSwipeStyleV715.b.getValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean g() {
        a aVar = a;
        if (aVar.c().style == 1 || aVar.c().style == 2) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SingleTabSwipeStyleV715 h() {
        return (SingleTabSwipeStyleV715) ISeriesAbValueApi.CC.getABValue2$default(ISeriesAbValueApi.Companion.c(), "single_tab_swipe_style_v715", new SingleTabSwipeStyleV715(0, false, 0, false, 15, null), false, 4, null);
    }

    static {
        Lazy<SingleTabSwipeStyleV715> lazy;
        Lazy<Boolean> lazy2;
        boolean z;
        Covode.recordClassIndex(598275);
        a aVar = new a(null);
        a = aVar;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: pq3.e0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                SingleTabSwipeStyleV715 h;
                h = SingleTabSwipeStyleV715.h();
                return h;
            }
        });
        b = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: pq3.f0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                boolean g;
                g = SingleTabSwipeStyleV715.g();
                return Boolean.valueOf(g);
            }
        });
        c = lazy2;
        if (aVar.c().style == 2) {
            z = true;
        } else {
            z = false;
        }
        d = z;
        e = aVar.c().enableFpsOpt;
    }

    public SingleTabSwipeStyleV715(int i, boolean z, int i2, boolean z2) {
        this.style = i;
        this.enableXmlPreload = z;
        this.enableXmlPreloadCount = i2;
        this.enableFpsOpt = z2;
    }

    public /* synthetic */ SingleTabSwipeStyleV715(int i, boolean z, int i2, boolean z2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? false : z, (i3 & 4) != 0 ? 1 : i2, (i3 & 8) != 0 ? false : z2);
    }
}
