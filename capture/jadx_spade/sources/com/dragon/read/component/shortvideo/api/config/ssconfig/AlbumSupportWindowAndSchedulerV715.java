package com.dragon.read.component.shortvideo.api.config.ssconfig;

import com.bytedance.covode.number.Covode;
import com.dragon.read.component.shortvideo.api.config.base.ISeriesAbValueApi;
import com.google.gson.annotations.SerializedName;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class AlbumSupportWindowAndSchedulerV715 {
    public static final a a;
    private static final Lazy<AlbumSupportWindowAndSchedulerV715> b;

    @SerializedName("enable_scheduler")
    public final boolean enableScheduler;

    @SerializedName("enable_window")
    public final boolean enableWindow;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public AlbumSupportWindowAndSchedulerV715() {
        /*
            r3 = this;
            r0 = 3
            r1 = 0
            r2 = 0
            r3.<init>(r2, r2, r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.component.shortvideo.api.config.ssconfig.AlbumSupportWindowAndSchedulerV715.<init>():void");
    }

    public static final class a {
        static {
            Covode.recordClassIndex(598315);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a() {
            return b().enableWindow;
        }

        public final AlbumSupportWindowAndSchedulerV715 b() {
            return (AlbumSupportWindowAndSchedulerV715) AlbumSupportWindowAndSchedulerV715.b.getValue();
        }
    }

    static {
        Lazy<AlbumSupportWindowAndSchedulerV715> lazy;
        Covode.recordClassIndex(598314);
        a = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.dragon.read.component.shortvideo.api.config.ssconfig.d
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                AlbumSupportWindowAndSchedulerV715 c;
                c = AlbumSupportWindowAndSchedulerV715.c();
                return c;
            }
        });
        b = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AlbumSupportWindowAndSchedulerV715 c() {
        boolean z = false;
        return (AlbumSupportWindowAndSchedulerV715) ISeriesAbValueApi.Companion.c().getABValue2("album_support_window_and_scheduler_v715", new AlbumSupportWindowAndSchedulerV715(z, z, 3, null), true);
    }

    public AlbumSupportWindowAndSchedulerV715(boolean z, boolean z2) {
        this.enableWindow = z;
        this.enableScheduler = z2;
    }

    public /* synthetic */ AlbumSupportWindowAndSchedulerV715(boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? false : z2);
    }
}
