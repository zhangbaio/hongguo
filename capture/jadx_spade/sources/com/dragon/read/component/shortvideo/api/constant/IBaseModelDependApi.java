package com.dragon.read.component.shortvideo.api.constant;

import com.bytedance.covode.number.Covode;
import com.bytedance.news.common.service.manager.IService;
import com.bytedance.news.common.service.manager.ServiceManager;
import com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public interface IBaseModelDependApi extends IService {
    public static final a Companion;

    static {
        Covode.recordClassIndex(598604);
        Companion = a.a;
    }

    String getUpdateInfo(SaasVideoDetailModel saasVideoDetailModel);

    public static final class a {
        static final /* synthetic */ a a;
        private static final IBaseModelDependApi b;

        private a() {
        }

        public final IBaseModelDependApi a() {
            return b;
        }

        static {
            Covode.recordClassIndex(598605);
            a = new a();
            b = (IBaseModelDependApi) ServiceManager.getService(IBaseModelDependApi.class);
        }
    }
}
