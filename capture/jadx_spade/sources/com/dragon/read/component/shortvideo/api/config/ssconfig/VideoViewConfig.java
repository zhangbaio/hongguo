package com.dragon.read.component.shortvideo.api.config.ssconfig;

import com.bytedance.covode.number.Covode;
import com.google.gson.annotations.SerializedName;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class VideoViewConfig {
    public static final a a;
    private static final Lazy<VideoViewConfig> b;

    @SerializedName("enable_surface_view")
    public final boolean enableSurfaceView;

    @SerializedName("fix_set_surface_timeout")
    public final boolean fixSetSurfaceTimeout;

    @SerializedName("surface_position_check_valid")
    public final boolean surfacePositionCheckValid;

    @SerializedName("surface_position_listener_hook")
    public final boolean surfacePositionListenerHook;

    @SerializedName("surface_position_post_main")
    public final boolean surfacePositionPostMain;

    @SerializedName("texture_update_surface_hook_all")
    public final boolean textureUpdateSurfaceHookAll;

    @SerializedName("texture_update_surface_hook_null")
    public final boolean textureUpdateSurfaceHookNull;

    public VideoViewConfig() {
        this(false, false, false, false, false, false, false, 127, null);
    }

    public static final class a {
        static {
            Covode.recordClassIndex(598601);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final VideoViewConfig a() {
            return (VideoViewConfig) VideoViewConfig.b.getValue();
        }
    }

    static {
        Lazy<VideoViewConfig> lazy;
        Covode.recordClassIndex(598600);
        a = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.dragon.read.component.shortvideo.api.config.ssconfig.i3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                VideoViewConfig c;
                c = VideoViewConfig.c();
                return c;
            }
        });
        b = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final VideoViewConfig c() {
        return (VideoViewConfig) qq3.a.c("video_view_config_v613", new VideoViewConfig(false, false, false, false, false, false, false, 127, null), false, 4, null);
    }

    public String toString() {
        return "VideoViewConfig(enableSurfaceView=" + this.enableSurfaceView + ", surfacePositionListenerHook=" + this.surfacePositionListenerHook + ", textureUpdateSurfaceHookAll=" + this.textureUpdateSurfaceHookAll + ", textureUpdateSurfaceHookNull=" + this.textureUpdateSurfaceHookNull + ", fixSetSurfaceTimeout=" + this.fixSetSurfaceTimeout + ')';
    }

    public VideoViewConfig(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
        this.enableSurfaceView = z;
        this.surfacePositionListenerHook = z2;
        this.surfacePositionPostMain = z3;
        this.surfacePositionCheckValid = z4;
        this.textureUpdateSurfaceHookAll = z5;
        this.textureUpdateSurfaceHookNull = z6;
        this.fixSetSurfaceTimeout = z7;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ VideoViewConfig(boolean r7, boolean r8, boolean r9, boolean r10, boolean r11, boolean r12, boolean r13, int r14, kotlin.jvm.internal.DefaultConstructorMarker r15) {
        /*
            r6 = this;
            r15 = r14 & 1
            r0 = 0
            if (r15 == 0) goto L7
            r15 = 0
            goto L8
        L7:
            r15 = r7
        L8:
            r7 = r14 & 2
            if (r7 == 0) goto Le
            r1 = 0
            goto Lf
        Le:
            r1 = r8
        Lf:
            r7 = r14 & 4
            if (r7 == 0) goto L15
            r2 = 0
            goto L16
        L15:
            r2 = r9
        L16:
            r7 = r14 & 8
            if (r7 == 0) goto L1c
            r3 = 0
            goto L1d
        L1c:
            r3 = r10
        L1d:
            r7 = r14 & 16
            if (r7 == 0) goto L23
            r4 = 0
            goto L24
        L23:
            r4 = r11
        L24:
            r7 = r14 & 32
            if (r7 == 0) goto L2a
            r5 = 0
            goto L2b
        L2a:
            r5 = r12
        L2b:
            r7 = r14 & 64
            if (r7 == 0) goto L31
            r14 = 0
            goto L32
        L31:
            r14 = r13
        L32:
            r7 = r6
            r8 = r15
            r9 = r1
            r10 = r2
            r11 = r3
            r12 = r4
            r13 = r5
            r7.<init>(r8, r9, r10, r11, r12, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.component.shortvideo.api.config.ssconfig.VideoViewConfig.<init>(boolean, boolean, boolean, boolean, boolean, boolean, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
