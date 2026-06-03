package com.dragon.read.component.shortvideo.api.config.ssconfig;

import com.bytedance.covode.number.Covode;
import com.google.gson.annotations.SerializedName;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class InnerFeedItemsConfigValue {
    public static final a a;
    private static final Lazy<InnerFeedItemsConfigValue> b;

    /* renamed from: default, reason: not valid java name */
    @SerializedName("default")
    public final InnerItemsConfig f0default;

    @SerializedName("episode_end_inner")
    public final InnerItemsConfig episodeEndInner;

    @SerializedName("episode_end_outer")
    public final InnerItemsConfig episodeEndOuter;

    @SerializedName("recommend_show_episode_index")
    public final int recommendInfoShowEpisodeIndex;

    @SerializedName("search")
    public final InnerItemsConfig search;

    @SerializedName("single_col")
    public final InnerItemsConfig single;

    @SerializedName("tag_show_episode_index")
    public final int tagShowEpisodeIndex;

    @SerializedName("three_col")
    public final InnerItemsConfig three;

    public InnerFeedItemsConfigValue() {
        this(null, null, null, null, null, null, 0, 0, 255, null);
    }

    public static final class a {
        static {
            Covode.recordClassIndex(598369);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String a(int i) {
            if (i == 101) {
                return "three_col";
            }
            if (i == 200) {
                return "search";
            }
            if (i == 901 || i == 903) {
                return "single_col";
            }
            if (i != 2400) {
                return null;
            }
            return "reader_video_ball";
        }

        public final String b(int i) {
            if (i == 0) {
                return "three_col";
            }
            if (i != 4) {
                return null;
            }
            return "search";
        }

        public final boolean i(int i) {
            return i == 2400;
        }

        public final int g() {
            return c().recommendInfoShowEpisodeIndex;
        }

        public final int h() {
            return c().tagShowEpisodeIndex;
        }

        private final InnerFeedItemsConfigValue c() {
            return (InnerFeedItemsConfigValue) InnerFeedItemsConfigValue.b.getValue();
        }

        public final InnerItemsConfig e() {
            if (c().episodeEndInner.enable) {
                return c().episodeEndInner;
            }
            return c().f0default;
        }

        public final InnerItemsConfig f() {
            if (c().episodeEndOuter.enable) {
                return c().episodeEndOuter;
            }
            return c().f0default;
        }

        public final InnerItemsConfig d(int i) {
            if (i != 101) {
                if (i != 200) {
                    if ((i == 901 || i == 903) && c().single.enable) {
                        return c().single;
                    }
                } else if (c().search.enable) {
                    return c().search;
                }
            } else if (c().three.enable) {
                return c().three;
            }
            return c().f0default;
        }
    }

    static {
        Lazy<InnerFeedItemsConfigValue> lazy;
        Covode.recordClassIndex(598368);
        a = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.dragon.read.component.shortvideo.api.config.ssconfig.x
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                InnerFeedItemsConfigValue c;
                c = InnerFeedItemsConfigValue.c();
                return c;
            }
        });
        b = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InnerFeedItemsConfigValue c() {
        return (InnerFeedItemsConfigValue) qq3.a.b("short_series_inner_feed_items_config", new InnerFeedItemsConfigValue(null, null, null, null, null, null, 0, 0, 255, null), true);
    }

    public InnerFeedItemsConfigValue(InnerItemsConfig innerItemsConfig, InnerItemsConfig three, InnerItemsConfig single, InnerItemsConfig search, InnerItemsConfig episodeEndOuter, InnerItemsConfig episodeEndInner, int i, int i2) {
        Intrinsics.checkNotNullParameter(innerItemsConfig, "default");
        Intrinsics.checkNotNullParameter(three, "three");
        Intrinsics.checkNotNullParameter(single, "single");
        Intrinsics.checkNotNullParameter(search, "search");
        Intrinsics.checkNotNullParameter(episodeEndOuter, "episodeEndOuter");
        Intrinsics.checkNotNullParameter(episodeEndInner, "episodeEndInner");
        this.f0default = innerItemsConfig;
        this.three = three;
        this.single = single;
        this.search = search;
        this.episodeEndOuter = episodeEndOuter;
        this.episodeEndInner = episodeEndInner;
        this.tagShowEpisodeIndex = i;
        this.recommendInfoShowEpisodeIndex = i2;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ InnerFeedItemsConfigValue(com.dragon.read.component.shortvideo.api.config.ssconfig.InnerItemsConfig r10, com.dragon.read.component.shortvideo.api.config.ssconfig.InnerItemsConfig r11, com.dragon.read.component.shortvideo.api.config.ssconfig.InnerItemsConfig r12, com.dragon.read.component.shortvideo.api.config.ssconfig.InnerItemsConfig r13, com.dragon.read.component.shortvideo.api.config.ssconfig.InnerItemsConfig r14, com.dragon.read.component.shortvideo.api.config.ssconfig.InnerItemsConfig r15, int r16, int r17, int r18, kotlin.jvm.internal.DefaultConstructorMarker r19) {
        /*
            r9 = this;
            r0 = r18
            r1 = r0 & 1
            if (r1 == 0) goto Lc
            com.dragon.read.component.shortvideo.api.config.ssconfig.InnerItemsConfig r1 = new com.dragon.read.component.shortvideo.api.config.ssconfig.InnerItemsConfig
            r1.<init>()
            goto Ld
        Lc:
            r1 = r10
        Ld:
            r2 = r0 & 2
            if (r2 == 0) goto L17
            com.dragon.read.component.shortvideo.api.config.ssconfig.InnerItemsConfig r2 = new com.dragon.read.component.shortvideo.api.config.ssconfig.InnerItemsConfig
            r2.<init>()
            goto L18
        L17:
            r2 = r11
        L18:
            r3 = r0 & 4
            if (r3 == 0) goto L22
            com.dragon.read.component.shortvideo.api.config.ssconfig.InnerItemsConfig r3 = new com.dragon.read.component.shortvideo.api.config.ssconfig.InnerItemsConfig
            r3.<init>()
            goto L23
        L22:
            r3 = r12
        L23:
            r4 = r0 & 8
            if (r4 == 0) goto L2d
            com.dragon.read.component.shortvideo.api.config.ssconfig.InnerItemsConfig r4 = new com.dragon.read.component.shortvideo.api.config.ssconfig.InnerItemsConfig
            r4.<init>()
            goto L2e
        L2d:
            r4 = r13
        L2e:
            r5 = r0 & 16
            if (r5 == 0) goto L38
            com.dragon.read.component.shortvideo.api.config.ssconfig.InnerItemsConfig r5 = new com.dragon.read.component.shortvideo.api.config.ssconfig.InnerItemsConfig
            r5.<init>()
            goto L39
        L38:
            r5 = r14
        L39:
            r6 = r0 & 32
            if (r6 == 0) goto L43
            com.dragon.read.component.shortvideo.api.config.ssconfig.InnerItemsConfig r6 = new com.dragon.read.component.shortvideo.api.config.ssconfig.InnerItemsConfig
            r6.<init>()
            goto L44
        L43:
            r6 = r15
        L44:
            r7 = r0 & 64
            r8 = -1
            if (r7 == 0) goto L4b
            r7 = -1
            goto L4d
        L4b:
            r7 = r16
        L4d:
            r0 = r0 & 128(0x80, float:1.8E-43)
            if (r0 == 0) goto L52
            goto L54
        L52:
            r8 = r17
        L54:
            r10 = r9
            r11 = r1
            r12 = r2
            r13 = r3
            r14 = r4
            r15 = r5
            r16 = r6
            r17 = r7
            r18 = r8
            r10.<init>(r11, r12, r13, r14, r15, r16, r17, r18)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.component.shortvideo.api.config.ssconfig.InnerFeedItemsConfigValue.<init>(com.dragon.read.component.shortvideo.api.config.ssconfig.InnerItemsConfig, com.dragon.read.component.shortvideo.api.config.ssconfig.InnerItemsConfig, com.dragon.read.component.shortvideo.api.config.ssconfig.InnerItemsConfig, com.dragon.read.component.shortvideo.api.config.ssconfig.InnerItemsConfig, com.dragon.read.component.shortvideo.api.config.ssconfig.InnerItemsConfig, com.dragon.read.component.shortvideo.api.config.ssconfig.InnerItemsConfig, int, int, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
