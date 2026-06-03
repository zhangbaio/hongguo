package com.dragon.read.component.shortvideo.api.config.ssconfig;

import com.bytedance.covode.number.Covode;
import com.google.gson.annotations.SerializedName;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class WastedLocalVideoProgressVidFixV655 {
    public static final a a;
    private static final Lazy<WastedLocalVideoProgressVidFixV655> b;

    @SerializedName("enable")
    public final boolean enable;

    public WastedLocalVideoProgressVidFixV655() {
        this(false, 1, null);
    }

    public static final class a {
        static {
            Covode.recordClassIndex(598603);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final WastedLocalVideoProgressVidFixV655 a() {
            return (WastedLocalVideoProgressVidFixV655) WastedLocalVideoProgressVidFixV655.b.getValue();
        }
    }

    static {
        Lazy<WastedLocalVideoProgressVidFixV655> lazy;
        Covode.recordClassIndex(598602);
        a = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.dragon.read.component.shortvideo.api.config.ssconfig.j3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                WastedLocalVideoProgressVidFixV655 c;
                c = WastedLocalVideoProgressVidFixV655.c();
                return c;
            }
        });
        b = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WastedLocalVideoProgressVidFixV655 c() {
        return (WastedLocalVideoProgressVidFixV655) qq3.a.c("waste_local_video_progress_fix_v665", new WastedLocalVideoProgressVidFixV655(false, 1, null), false, 4, null);
    }

    public WastedLocalVideoProgressVidFixV655(boolean z) {
        this.enable = z;
    }

    public /* synthetic */ WastedLocalVideoProgressVidFixV655(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z);
    }
}
