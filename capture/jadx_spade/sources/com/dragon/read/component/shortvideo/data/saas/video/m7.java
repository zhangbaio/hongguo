package com.dragon.read.component.shortvideo.data.saas.video;

import com.bytedance.covode.number.Covode;
import com.dragon.read.component.shortvideo.api.config.ssconfig.VideoDetailTransformOptV693;
import seriessdk.com.dragon.read.saas.rpc.model.VideoDetailInfo;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class m7 {
    public static final m7 a;

    static {
        Covode.recordClassIndex(599124);
        a = new m7();
    }

    private m7() {
    }

    public static final SaasVideoDetailModel a(Object obj) {
        if (VideoDetailTransformOptV693.a.a().enable) {
            if (obj instanceof VideoDetailInfo) {
                return new SaasModelWrapperByRpc((VideoDetailInfo) obj);
            }
            if (obj instanceof SaasVideoDetailModel) {
                return new SaasModelWrapperBySelf((SaasVideoDetailModel) obj);
            }
            return new SaasVideoDetailModelWrapper();
        }
        return new SaasVideoDetailModel();
    }
}
