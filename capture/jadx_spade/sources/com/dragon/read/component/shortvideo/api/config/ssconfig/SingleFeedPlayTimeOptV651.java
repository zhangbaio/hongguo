package com.dragon.read.component.shortvideo.api.config.ssconfig;

import com.bytedance.covode.number.Covode;
import com.dragon.read.component.shortvideo.api.ShortSeriesApi;
import com.google.gson.annotations.SerializedName;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class SingleFeedPlayTimeOptV651 {
    public static final a a;
    private static final Lazy<SingleFeedPlayTimeOptV651> b;

    @SerializedName("lazy_init_unselect_tab")
    public final boolean lazyInitUnSelectTab;

    @SerializedName("lazy_init_view_pager")
    public final boolean lazyInitViewPager;

    @SerializedName("preload_delay_time")
    public final int preloadDelayTime;

    @SerializedName("preload_fragment_type")
    public final int preloadFragmentType;

    @SerializedName("trace_monitor_opt")
    public final boolean traceMonitorOpt;

    @SerializedName("trace_monitor_opt2")
    public final boolean traceMonitorOpt2;

    @SerializedName("trace_monitor_opt3")
    public final boolean traceMonitorOpt3;

    @SerializedName("trace_monitor_opt4")
    public final boolean traceMonitorOpt4;

    public SingleFeedPlayTimeOptV651() {
        this(0, 0, false, false, false, false, false, false, 255, null);
    }

    public static final class a {
        static {
            Covode.recordClassIndex(598537);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean b() {
            if (d().preloadFragmentType != 0) {
                return true;
            }
            return false;
        }

        public final SingleFeedPlayTimeOptV651 d() {
            return (SingleFeedPlayTimeOptV651) SingleFeedPlayTimeOptV651.b.getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final SingleFeedPlayTimeOptV651 c() {
            if (((tq3.g) ShortSeriesApi.Companion.c().getDocker().d(tq3.g.class)).enableNewUserOptV711()) {
                return new SingleFeedPlayTimeOptV651(1, 0, true, true, true, false, false, false, 226, null);
            }
            return new SingleFeedPlayTimeOptV651(0, 0, false, false, false, false, false, false, 255, null);
        }
    }

    static {
        Lazy<SingleFeedPlayTimeOptV651> lazy;
        Covode.recordClassIndex(598536);
        a = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.dragon.read.component.shortvideo.api.config.ssconfig.i2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                SingleFeedPlayTimeOptV651 c;
                c = SingleFeedPlayTimeOptV651.c();
                return c;
            }
        });
        b = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SingleFeedPlayTimeOptV651 c() {
        return (SingleFeedPlayTimeOptV651) qq3.a.c("single_feed_play_time_opt_v651", a.c(), false, 4, null);
    }

    public SingleFeedPlayTimeOptV651(int i, int i2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        this.preloadFragmentType = i;
        this.preloadDelayTime = i2;
        this.lazyInitUnSelectTab = z;
        this.lazyInitViewPager = z2;
        this.traceMonitorOpt = z3;
        this.traceMonitorOpt2 = z4;
        this.traceMonitorOpt3 = z5;
        this.traceMonitorOpt4 = z6;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ SingleFeedPlayTimeOptV651(int r10, int r11, boolean r12, boolean r13, boolean r14, boolean r15, boolean r16, boolean r17, int r18, kotlin.jvm.internal.DefaultConstructorMarker r19) {
        /*
            r9 = this;
            r0 = r18
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L9
            r1 = 0
            goto La
        L9:
            r1 = r10
        La:
            r3 = r0 & 2
            if (r3 == 0) goto L10
            r3 = 0
            goto L11
        L10:
            r3 = r11
        L11:
            r4 = r0 & 4
            if (r4 == 0) goto L17
            r4 = 0
            goto L18
        L17:
            r4 = r12
        L18:
            r5 = r0 & 8
            if (r5 == 0) goto L1e
            r5 = 0
            goto L1f
        L1e:
            r5 = r13
        L1f:
            r6 = r0 & 16
            if (r6 == 0) goto L25
            r6 = 0
            goto L26
        L25:
            r6 = r14
        L26:
            r7 = r0 & 32
            if (r7 == 0) goto L2b
            goto L2c
        L2b:
            r2 = r15
        L2c:
            r7 = r0 & 64
            r8 = 1
            if (r7 == 0) goto L33
            r7 = 1
            goto L35
        L33:
            r7 = r16
        L35:
            r0 = r0 & 128(0x80, float:1.8E-43)
            if (r0 == 0) goto L3a
            goto L3c
        L3a:
            r8 = r17
        L3c:
            r10 = r9
            r11 = r1
            r12 = r3
            r13 = r4
            r14 = r5
            r15 = r6
            r16 = r2
            r17 = r7
            r18 = r8
            r10.<init>(r11, r12, r13, r14, r15, r16, r17, r18)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.component.shortvideo.api.config.ssconfig.SingleFeedPlayTimeOptV651.<init>(int, int, boolean, boolean, boolean, boolean, boolean, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
