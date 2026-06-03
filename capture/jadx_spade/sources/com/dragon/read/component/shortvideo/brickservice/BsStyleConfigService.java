package com.dragon.read.component.shortvideo.brickservice;

import com.bytedance.covode.number.Covode;
import com.bytedance.news.common.service.manager.IService;
import com.bytedance.news.common.service.manager.ServiceManager;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public interface BsStyleConfigService extends IService {
    public static final a Companion;

    public static final class b {
        static {
            Covode.recordClassIndex(598995);
        }

        public static boolean a(BsStyleConfigService bsStyleConfigService) {
            return false;
        }

        public static int b(BsStyleConfigService bsStyleConfigService) {
            return 2131558648;
        }
    }

    static {
        Covode.recordClassIndex(598993);
        Companion = a.a;
    }

    boolean enableAllHotStartRefresh();

    boolean enableFakeExit();

    boolean enableNewBrandColorOpt();

    boolean enablePrivacyPopupRadius();

    boolean enablePugcVideoAlbum();

    boolean enableShortVideoWithTotalAppFontScaleChange();

    boolean enableSingleFeedNextEpisodeEnhanceCountDownTextStyle();

    boolean enableSubscribeDialogStyleOpt();

    int getHotStartRefreshDuration();

    int getPrivacyPopupAgreeButtonTextColor();

    int getPrivacyPopupOptStyle();

    public static final class a {
        static final /* synthetic */ a a;
        private static final BsStyleConfigService b;

        private a() {
        }

        public final BsStyleConfigService a() {
            return b;
        }

        static {
            Covode.recordClassIndex(598994);
            a = new a();
            b = (BsStyleConfigService) ServiceManager.getService(BsStyleConfigService.class);
        }
    }
}
