package com.dragon.read.component.shortvideo.api.config.ssconfig;

import com.bytedance.covode.number.Covode;
import com.google.gson.annotations.SerializedName;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class SeriesResolutionABValue {
    public static final a a;
    private static final Lazy<SeriesResolutionABValue> b;

    @SerializedName("check_hijack")
    public final boolean checkHijack;

    @SerializedName("config_definition")
    public final boolean configDefinition;

    @SerializedName("hijack_retry_backup_dns_type")
    public final int hijackRetryBackupDnsType;

    @SerializedName("hijack_retry_main_dns_type")
    public final int hijackRetryMainDnsType;

    @SerializedName("opt_cache")
    public final boolean optCache;

    @SerializedName("opt_prepared")
    public final boolean optPrepared;

    @SerializedName("read_mode")
    public final int readMode;

    @SerializedName("request_all_definition")
    public final boolean requestAllDefinition;

    @SerializedName("request_mp4_align")
    public final boolean requestMp4Align;

    @SerializedName("seamless_switch")
    public final boolean seamlessSwitch;

    @SerializedName("show")
    public final boolean show;

    @SerializedName("single_progress")
    public final boolean singleProgress;

    @SerializedName("single_series")
    public final boolean singleSeries;

    @SerializedName("skip_find_stream_info")
    public final boolean skipFindStreamInfo;

    @SerializedName("slow_tip")
    public final boolean slowTip;

    @SerializedName("supported_definitions")
    public final String supportedDefinitions;

    @SerializedName("use_mdl2")
    public final boolean useMdl2;

    public SeriesResolutionABValue() {
        this(false, false, false, false, false, false, false, false, false, false, null, false, 0, false, 0, 0, false, 131071, null);
    }

    public static final class a {
        static {
            Covode.recordClassIndex(598496);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SeriesResolutionABValue a() {
            return (SeriesResolutionABValue) SeriesResolutionABValue.b.getValue();
        }
    }

    static {
        Lazy<SeriesResolutionABValue> lazy;
        Covode.recordClassIndex(598495);
        a = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.dragon.read.component.shortvideo.api.config.ssconfig.s1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                SeriesResolutionABValue c;
                c = SeriesResolutionABValue.c();
                return c;
            }
        });
        b = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SeriesResolutionABValue c() {
        int i = 0;
        return (SeriesResolutionABValue) qq3.a.a("series_resolution_v635", new SeriesResolutionABValue(false, false, false, false, false, false, false, false, false, false, null, false, 0, false, i, i, false, 131071, null), true);
    }

    public SeriesResolutionABValue(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, String supportedDefinitions, boolean z11, int i, boolean z12, int i2, int i3, boolean z13) {
        Intrinsics.checkNotNullParameter(supportedDefinitions, "supportedDefinitions");
        this.requestMp4Align = z;
        this.requestAllDefinition = z2;
        this.configDefinition = z3;
        this.seamlessSwitch = z4;
        this.optPrepared = z5;
        this.optCache = z6;
        this.show = z7;
        this.slowTip = z8;
        this.singleProgress = z9;
        this.singleSeries = z10;
        this.supportedDefinitions = supportedDefinitions;
        this.skipFindStreamInfo = z11;
        this.readMode = i;
        this.checkHijack = z12;
        this.hijackRetryMainDnsType = i2;
        this.hijackRetryBackupDnsType = i3;
        this.useMdl2 = z13;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ SeriesResolutionABValue(boolean r19, boolean r20, boolean r21, boolean r22, boolean r23, boolean r24, boolean r25, boolean r26, boolean r27, boolean r28, java.lang.String r29, boolean r30, int r31, boolean r32, int r33, int r34, boolean r35, int r36, kotlin.jvm.internal.DefaultConstructorMarker r37) {
        /*
            Method dump skipped, instructions count: 185
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.component.shortvideo.api.config.ssconfig.SeriesResolutionABValue.<init>(boolean, boolean, boolean, boolean, boolean, boolean, boolean, boolean, boolean, boolean, java.lang.String, boolean, int, boolean, int, int, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
