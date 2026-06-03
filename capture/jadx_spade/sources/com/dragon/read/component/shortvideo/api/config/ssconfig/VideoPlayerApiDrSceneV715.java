package com.dragon.read.component.shortvideo.api.config.ssconfig;

import com.bytedance.covode.number.Covode;
import com.dragon.read.component.shortvideo.api.config.base.ISeriesAbValueApi;
import com.google.gson.annotations.SerializedName;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class VideoPlayerApiDrSceneV715 {
    public static final a a;
    private static final Lazy<VideoPlayerApiDrSceneV715> b;

    @SerializedName("enable")
    public final boolean enable;

    public VideoPlayerApiDrSceneV715() {
        this(false, 1, null);
    }

    public static final class a {
        static {
            Covode.recordClassIndex(598591);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final VideoPlayerApiDrSceneV715 a() {
            return (VideoPlayerApiDrSceneV715) VideoPlayerApiDrSceneV715.b.getValue();
        }
    }

    static {
        Lazy<VideoPlayerApiDrSceneV715> lazy;
        Covode.recordClassIndex(598590);
        a = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.dragon.read.component.shortvideo.api.config.ssconfig.e3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                VideoPlayerApiDrSceneV715 c;
                c = VideoPlayerApiDrSceneV715.c();
                return c;
            }
        });
        b = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final VideoPlayerApiDrSceneV715 c() {
        return (VideoPlayerApiDrSceneV715) ISeriesAbValueApi.CC.getABValue2$default(ISeriesAbValueApi.Companion.c(), "video_player_api_dr_scene", new VideoPlayerApiDrSceneV715(false, 1, null), false, 4, null);
    }

    public VideoPlayerApiDrSceneV715(boolean z) {
        this.enable = z;
    }

    public /* synthetic */ VideoPlayerApiDrSceneV715(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z);
    }
}
