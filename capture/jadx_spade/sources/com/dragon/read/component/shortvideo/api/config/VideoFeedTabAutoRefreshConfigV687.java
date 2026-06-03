package com.dragon.read.component.shortvideo.api.config;

import com.bytedance.covode.number.Covode;
import com.dragon.read.component.shortvideo.api.config.VideoFeedTabAutoRefreshConfigV687;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class VideoFeedTabAutoRefreshConfigV687 {
    public static final a a;
    private static final VideoFeedTabAutoRefreshConfigV687 b;
    private static final Lazy<VideoFeedTabAutoRefreshConfigV687> c;

    @SerializedName("action_change_refresh_enable")
    public final boolean actionChangeRefreshEnable;

    @SerializedName("app_background_refresh_interval")
    public final int appBackgroundRefreshInterval;

    @SerializedName("bottom_tab_refresh_interval")
    public final int bottomTabRefreshInterval;

    @SerializedName("disable_old_refresh")
    public final boolean disableOldRefresh;

    @SerializedName("enable")
    public final boolean enable;

    @SerializedName("enter_inner_player_refresh_interval")
    public final int enterInnerPlayerRefreshInterval;

    @SerializedName("request_recommend")
    public final boolean requestRecommend;

    @SerializedName("search_return_refresh_interval")
    public final int searchReturnRefreshInterval;

    @SerializedName("tab_type_list")
    public final List<Integer> tabTypeList;

    @SerializedName("top_tab_refresh_interval")
    public final int topTabRefreshInterval;

    public VideoFeedTabAutoRefreshConfigV687() {
        this(false, false, 0, 0, 0, 0, false, null, false, 0, 1023, null);
    }

    public static final int d() {
        return a.b();
    }

    public static final int e() {
        return a.d();
    }

    public static final int f() {
        return a.f();
    }

    public static final boolean g() {
        return a.g();
    }

    public static final boolean h() {
        return a.i();
    }

    public static final boolean i() {
        return a.k();
    }

    public static final boolean j() {
        return a.l();
    }

    public static final boolean k() {
        return a.n();
    }

    public static final boolean l() {
        return a.o();
    }

    public static final class a {
        static {
            Covode.recordClassIndex(598283);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return c().appBackgroundRefreshInterval;
        }

        public final int b() {
            return c().bottomTabRefreshInterval;
        }

        public final int d() {
            return c().enterInnerPlayerRefreshInterval;
        }

        public final int e() {
            return c().searchReturnRefreshInterval;
        }

        public final int f() {
            return c().topTabRefreshInterval;
        }

        public final boolean j() {
            return c().disableOldRefresh;
        }

        public final boolean k() {
            return c().enable;
        }

        public final boolean m() {
            return c().requestRecommend;
        }

        public final VideoFeedTabAutoRefreshConfigV687 c() {
            return (VideoFeedTabAutoRefreshConfigV687) VideoFeedTabAutoRefreshConfigV687.c.getValue();
        }

        public final boolean h() {
            if (c().appBackgroundRefreshInterval > 0) {
                return true;
            }
            return false;
        }

        public final boolean i() {
            if (c().bottomTabRefreshInterval > 0) {
                return true;
            }
            return false;
        }

        public final boolean l() {
            if (c().enterInnerPlayerRefreshInterval > 0) {
                return true;
            }
            return false;
        }

        public final boolean n() {
            if (c().searchReturnRefreshInterval > 0) {
                return true;
            }
            return false;
        }

        public final boolean o() {
            if (c().topTabRefreshInterval > 0) {
                return true;
            }
            return false;
        }

        public final boolean g() {
            if (k() && c().actionChangeRefreshEnable) {
                return true;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final VideoFeedTabAutoRefreshConfigV687 c() {
        return (VideoFeedTabAutoRefreshConfigV687) qq3.a.c("video_series_tab_auto_refresh_config_v685", b, false, 4, null);
    }

    static {
        Lazy<VideoFeedTabAutoRefreshConfigV687> lazy;
        Covode.recordClassIndex(598282);
        a = new a(null);
        b = new VideoFeedTabAutoRefreshConfigV687(false, false, 0, 0, 0, 0, false, null, false, 0, 1023, null);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: pq3.h0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                VideoFeedTabAutoRefreshConfigV687 c2;
                c2 = VideoFeedTabAutoRefreshConfigV687.c();
                return c2;
            }
        });
        c = lazy;
    }

    public VideoFeedTabAutoRefreshConfigV687(boolean z, boolean z2, int i, int i2, int i3, int i4, boolean z3, List<Integer> tabTypeList, boolean z4, int i5) {
        Intrinsics.checkNotNullParameter(tabTypeList, "tabTypeList");
        this.enable = z;
        this.actionChangeRefreshEnable = z2;
        this.topTabRefreshInterval = i;
        this.bottomTabRefreshInterval = i2;
        this.appBackgroundRefreshInterval = i3;
        this.enterInnerPlayerRefreshInterval = i4;
        this.disableOldRefresh = z3;
        this.tabTypeList = tabTypeList;
        this.requestRecommend = z4;
        this.searchReturnRefreshInterval = i5;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ VideoFeedTabAutoRefreshConfigV687(boolean r12, boolean r13, int r14, int r15, int r16, int r17, boolean r18, java.util.List r19, boolean r20, int r21, int r22, kotlin.jvm.internal.DefaultConstructorMarker r23) {
        /*
            r11 = this;
            r0 = r22
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L9
            r1 = 0
            goto La
        L9:
            r1 = r12
        La:
            r3 = r0 & 2
            if (r3 == 0) goto L10
            r3 = 0
            goto L11
        L10:
            r3 = r13
        L11:
            r4 = r0 & 4
            if (r4 == 0) goto L17
            r4 = 0
            goto L18
        L17:
            r4 = r14
        L18:
            r5 = r0 & 8
            if (r5 == 0) goto L1e
            r5 = 0
            goto L1f
        L1e:
            r5 = r15
        L1f:
            r6 = r0 & 16
            if (r6 == 0) goto L25
            r6 = 0
            goto L27
        L25:
            r6 = r16
        L27:
            r7 = r0 & 32
            if (r7 == 0) goto L2d
            r7 = 0
            goto L2f
        L2d:
            r7 = r17
        L2f:
            r8 = r0 & 64
            if (r8 == 0) goto L35
            r8 = 0
            goto L37
        L35:
            r8 = r18
        L37:
            r9 = r0 & 128(0x80, float:1.8E-43)
            if (r9 == 0) goto L40
            java.util.List r9 = kotlin.collections.CollectionsKt.emptyList()
            goto L42
        L40:
            r9 = r19
        L42:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L48
            r10 = 1
            goto L4a
        L48:
            r10 = r20
        L4a:
            r0 = r0 & 512(0x200, float:7.17E-43)
            if (r0 == 0) goto L4f
            goto L51
        L4f:
            r2 = r21
        L51:
            r12 = r11
            r13 = r1
            r14 = r3
            r15 = r4
            r16 = r5
            r17 = r6
            r18 = r7
            r19 = r8
            r20 = r9
            r21 = r10
            r22 = r2
            r12.<init>(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.component.shortvideo.api.config.VideoFeedTabAutoRefreshConfigV687.<init>(boolean, boolean, int, int, int, int, boolean, java.util.List, boolean, int, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
