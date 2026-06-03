package com.dragon.read.component.shortvideo.api.config;

import com.bytedance.covode.number.Covode;
import com.dragon.read.component.shortvideo.api.config.VideoAudioTrackConfigV671;
import com.google.gson.annotations.SerializedName;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class VideoAudioTrackConfigV671 {
    public static final a a;
    private static final Lazy<VideoAudioTrackConfigV671> b;

    @SerializedName("audio_track_early")
    public final boolean audioTrackEarly;

    @SerializedName("audio_track_early_prepare")
    public final boolean audioTrackEarlyPrepare;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public VideoAudioTrackConfigV671() {
        /*
            r3 = this;
            r0 = 3
            r1 = 0
            r2 = 0
            r3.<init>(r2, r2, r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.component.shortvideo.api.config.VideoAudioTrackConfigV671.<init>():void");
    }

    public static final class a {
        static {
            Covode.recordClassIndex(598280);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final VideoAudioTrackConfigV671 a() {
            return (VideoAudioTrackConfigV671) VideoAudioTrackConfigV671.b.getValue();
        }
    }

    static {
        Lazy<VideoAudioTrackConfigV671> lazy;
        Covode.recordClassIndex(598279);
        a = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: pq3.g0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                VideoAudioTrackConfigV671 c;
                c = VideoAudioTrackConfigV671.c();
                return c;
            }
        });
        b = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final VideoAudioTrackConfigV671 c() {
        boolean z = false;
        return (VideoAudioTrackConfigV671) qq3.a.c("video_audio_track_config_v671", new VideoAudioTrackConfigV671(z, z, 3, null), false, 4, null);
    }

    public VideoAudioTrackConfigV671(boolean z, boolean z2) {
        this.audioTrackEarlyPrepare = z;
        this.audioTrackEarly = z2;
    }

    public /* synthetic */ VideoAudioTrackConfigV671(boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? false : z2);
    }
}
