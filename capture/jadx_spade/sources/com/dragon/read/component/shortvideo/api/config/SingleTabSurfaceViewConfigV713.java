package com.dragon.read.component.shortvideo.api.config;

import com.bytedance.covode.number.Covode;
import com.dragon.read.component.shortvideo.api.config.SingleTabSurfaceViewConfigV713;
import com.dragon.read.component.shortvideo.api.config.base.ISeriesAbValueApi;
import com.google.gson.annotations.SerializedName;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class SingleTabSurfaceViewConfigV713 {
    public static final a a;
    private static final Lazy<SingleTabSurfaceViewConfigV713> b;

    @SerializedName("delay_restore_time")
    public final int delayRestoreTime;

    @SerializedName("disable_surface_view_scene")
    public final int[] disableSurfaceViewScene;

    @SerializedName("enable_texture_render_low_os")
    public final boolean enableTextureRenderLowOs;

    @SerializedName("smooth_enter")
    public final boolean smoothEnter;

    public SingleTabSurfaceViewConfigV713() {
        this(false, null, false, 0, 15, null);
    }

    public static final class a {
        static {
            Covode.recordClassIndex(598274);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SingleTabSurfaceViewConfigV713 a() {
            return (SingleTabSurfaceViewConfigV713) SingleTabSurfaceViewConfigV713.b.getValue();
        }
    }

    static {
        Lazy<SingleTabSurfaceViewConfigV713> lazy;
        Covode.recordClassIndex(598273);
        a = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: pq3.d0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                SingleTabSurfaceViewConfigV713 c;
                c = SingleTabSurfaceViewConfigV713.c();
                return c;
            }
        });
        b = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SingleTabSurfaceViewConfigV713 c() {
        return (SingleTabSurfaceViewConfigV713) ISeriesAbValueApi.CC.getABValue2$default(ISeriesAbValueApi.Companion.c(), "single_tab_surface_view_v713", new SingleTabSurfaceViewConfigV713(false, null, false, 0, 15, null), false, 4, null);
    }

    public SingleTabSurfaceViewConfigV713(boolean z, int[] disableSurfaceViewScene, boolean z2, int i) {
        Intrinsics.checkNotNullParameter(disableSurfaceViewScene, "disableSurfaceViewScene");
        this.smoothEnter = z;
        this.disableSurfaceViewScene = disableSurfaceViewScene;
        this.enableTextureRenderLowOs = z2;
        this.delayRestoreTime = i;
    }

    public /* synthetic */ SingleTabSurfaceViewConfigV713(boolean z, int[] iArr, boolean z2, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? false : z, (i2 & 2) != 0 ? new int[]{1} : iArr, (i2 & 4) != 0 ? false : z2, (i2 & 8) != 0 ? 3000 : i);
    }
}
