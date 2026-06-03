package com.dragon.read.component.shortvideo.api.config.ssconfig;

import com.bytedance.covode.number.Covode;
import com.dragon.read.component.shortvideo.api.config.base.ISeriesAbValueApi;
import com.google.gson.annotations.SerializedName;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class SaasVideoTagInfoCrashUploadV711 {
    public static final a a;
    private static final Lazy<SaasVideoTagInfoCrashUploadV711> b;

    @SerializedName("enable")
    public final boolean enable;

    public SaasVideoTagInfoCrashUploadV711() {
        this(false, 1, null);
    }

    public static final class a {
        static {
            Covode.recordClassIndex(598465);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SaasVideoTagInfoCrashUploadV711 a() {
            return (SaasVideoTagInfoCrashUploadV711) SaasVideoTagInfoCrashUploadV711.b.getValue();
        }
    }

    static {
        Lazy<SaasVideoTagInfoCrashUploadV711> lazy;
        Covode.recordClassIndex(598464);
        a = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.dragon.read.component.shortvideo.api.config.ssconfig.h1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                SaasVideoTagInfoCrashUploadV711 b2;
                b2 = SaasVideoTagInfoCrashUploadV711.b();
                return b2;
            }
        });
        b = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SaasVideoTagInfoCrashUploadV711 b() {
        return (SaasVideoTagInfoCrashUploadV711) ISeriesAbValueApi.Companion.c().getABValue2("saas_video_tag_info_crash_upload_v711", new SaasVideoTagInfoCrashUploadV711(false, 1, null), true);
    }

    public SaasVideoTagInfoCrashUploadV711(boolean z) {
        this.enable = z;
    }

    public /* synthetic */ SaasVideoTagInfoCrashUploadV711(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z);
    }
}
