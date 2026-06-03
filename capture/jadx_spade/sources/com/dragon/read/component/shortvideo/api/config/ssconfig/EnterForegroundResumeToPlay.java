package com.dragon.read.component.shortvideo.api.config.ssconfig;

import com.bytedance.covode.number.Covode;
import com.google.gson.annotations.SerializedName;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class EnterForegroundResumeToPlay {
    public static final a a;
    private static final Lazy<EnterForegroundResumeToPlay> b;

    @SerializedName("enable")
    public final boolean enable;

    public EnterForegroundResumeToPlay() {
        this(false, 1, null);
    }

    public static final class a {
        static {
            Covode.recordClassIndex(598349);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final EnterForegroundResumeToPlay a() {
            return (EnterForegroundResumeToPlay) EnterForegroundResumeToPlay.b.getValue();
        }
    }

    static {
        Lazy<EnterForegroundResumeToPlay> lazy;
        Covode.recordClassIndex(598348);
        a = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.dragon.read.component.shortvideo.api.config.ssconfig.p
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                EnterForegroundResumeToPlay c;
                c = EnterForegroundResumeToPlay.c();
                return c;
            }
        });
        b = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EnterForegroundResumeToPlay c() {
        return (EnterForegroundResumeToPlay) qq3.a.c("short_series_enter_foreground_resume_playing_v663", new EnterForegroundResumeToPlay(false, 1, null), false, 4, null);
    }

    public EnterForegroundResumeToPlay(boolean z) {
        this.enable = z;
    }

    public /* synthetic */ EnterForegroundResumeToPlay(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z);
    }
}
