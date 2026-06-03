package com.dragon.read.component.shortvideo.api.config.ssconfig;

import com.bytedance.covode.number.Covode;
import com.google.gson.annotations.SerializedName;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class VideoPlayerProgressOptV673ABValue {
    public static final a a;
    private static final Lazy<VideoPlayerProgressOptV673ABValue> b;

    @SerializedName("enable_hotspot_opt")
    public final boolean dragHotspotOptEnable;

    @SerializedName("enable_progress_bar_mark_style")
    public final boolean enableDragBarDoubleThumbMode;

    @SerializedName("enable_transition_effect_opt")
    public final boolean enableProgressAnimateOpt;

    @SerializedName("exception_show_opt")
    public final boolean networkExceptionShowOpt;

    @SerializedName("enable_drag_opt")
    public final boolean seekBarEdgeDragSensitive;

    public VideoPlayerProgressOptV673ABValue() {
        this(false, false, false, false, false, 31, null);
    }

    public static final class a {
        static {
            Covode.recordClassIndex(598595);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final VideoPlayerProgressOptV673ABValue a() {
            return (VideoPlayerProgressOptV673ABValue) VideoPlayerProgressOptV673ABValue.b.getValue();
        }
    }

    static {
        Lazy<VideoPlayerProgressOptV673ABValue> lazy;
        Covode.recordClassIndex(598594);
        a = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.dragon.read.component.shortvideo.api.config.ssconfig.f3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                VideoPlayerProgressOptV673ABValue c;
                c = VideoPlayerProgressOptV673ABValue.c();
                return c;
            }
        });
        b = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final VideoPlayerProgressOptV673ABValue c() {
        return (VideoPlayerProgressOptV673ABValue) qq3.a.b("short_video_progress_opt_v673", new VideoPlayerProgressOptV673ABValue(false, false, false, false, false, 31, null), true);
    }

    public VideoPlayerProgressOptV673ABValue(boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        this.seekBarEdgeDragSensitive = z;
        this.dragHotspotOptEnable = z2;
        this.enableDragBarDoubleThumbMode = z3;
        this.enableProgressAnimateOpt = z4;
        this.networkExceptionShowOpt = z5;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ VideoPlayerProgressOptV673ABValue(boolean r5, boolean r6, boolean r7, boolean r8, boolean r9, int r10, kotlin.jvm.internal.DefaultConstructorMarker r11) {
        /*
            r4 = this;
            r11 = r10 & 1
            r0 = 0
            if (r11 == 0) goto L7
            r11 = 0
            goto L8
        L7:
            r11 = r5
        L8:
            r5 = r10 & 2
            if (r5 == 0) goto Le
            r1 = 0
            goto Lf
        Le:
            r1 = r6
        Lf:
            r5 = r10 & 4
            if (r5 == 0) goto L15
            r2 = 0
            goto L16
        L15:
            r2 = r7
        L16:
            r5 = r10 & 8
            if (r5 == 0) goto L1c
            r3 = 0
            goto L1d
        L1c:
            r3 = r8
        L1d:
            r5 = r10 & 16
            if (r5 == 0) goto L23
            r10 = 0
            goto L24
        L23:
            r10 = r9
        L24:
            r5 = r4
            r6 = r11
            r7 = r1
            r8 = r2
            r9 = r3
            r5.<init>(r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.component.shortvideo.api.config.ssconfig.VideoPlayerProgressOptV673ABValue.<init>(boolean, boolean, boolean, boolean, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
