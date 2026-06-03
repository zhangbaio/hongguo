package com.dragon.read.component.biz.impl;

import com.bytedance.covode.number.Covode;
import com.dragon.read.app.App;
import com.dragon.read.base.share2.absettings.ShareIconOptimizeConfig;
import com.dragon.read.base.share2.absettings.ShortSeriesSharePanelExp;
import com.dragon.read.base.share2.absettings.WeiboShareChannelConfig;
import com.dragon.read.component.biz.api.NsShareDepend;
import com.dragon.read.component.biz.impl.brickservice.BsShareConfigService;
import com.dragon.read.component.biz.impl.brickservice.h;
import com.dragon.read.util.kotlin.StringKt;
import kotlin.Pair;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class HongGuoShareConfig implements BsShareConfigService {
    public static final int $stable = 0;

    static {
        Covode.recordClassIndex(588072);
    }

    public boolean enableShare() {
        return true;
    }

    public boolean enableShareSeriesScene() {
        return true;
    }

    public int getCopyListShareItem(boolean z) {
        return z ? 2130844552 : 2130844551;
    }

    public boolean isRequestShareEntrance() {
        return true;
    }

    public boolean isWeiboImageShareWithText() {
        return true;
    }

    public boolean isWeiboWebShareChangeText() {
        return true;
    }

    public boolean enableShareOtherScene() {
        return BsShareConfigService.b.a(this);
    }

    public boolean enableShareWebJsbScene() {
        return NsShareDepend.IMPL.enableSharePanelWebJsbEnable();
    }

    public h getActivitySharePanelConfig() {
        return new h.a("8662_activity_1").a;
    }

    public h getImagerSharePanelConfig() {
        return new h.a("8662_imagesave_2").a;
    }

    public h getWebSharePanelConfig() {
        return new h.a("8662_novelapp_1").a;
    }

    public Pair<String, Integer> getCustomLongItemUIConfig() {
        return new Pair<>(App.context().getResources().getString(2131106573), 2130844582);
    }

    public int getImageShareItemId() {
        if (ShareIconOptimizeConfig.a.a().iconStyle == 2) {
            return 2130844586;
        }
        return 2130844582;
    }

    public h getCommonCardSharePanelConfig() {
        WeiboShareChannelConfig.a aVar = WeiboShareChannelConfig.a;
        if (aVar.a().isEnable && StringKt.isNotNullOrEmpty(aVar.a().androidCardPanelId)) {
            return new h.a(aVar.a().androidCardPanelId).a;
        }
        return new h.a("8662_shortvideo_5").a;
    }

    public h getCommonPostSharePanelConfig() {
        WeiboShareChannelConfig.a aVar = WeiboShareChannelConfig.a;
        if (aVar.a().isEnable && StringKt.isNotNullOrEmpty(aVar.a().androidPostPanelId)) {
            return new h.a(aVar.a().androidPostPanelId).a;
        }
        return new h.a("8662_imagesave_3").a;
    }

    public h getCommonScreenSharePanelConfig() {
        WeiboShareChannelConfig.a aVar = WeiboShareChannelConfig.a;
        if (aVar.a().isEnable && StringKt.isNotNullOrEmpty(aVar.a().androidScreenShotPanelId)) {
            return new h.a(aVar.a().androidScreenShotPanelId).a;
        }
        return new h.a("8662_screenshot_1").a;
    }

    public h getCopyLinkSharePanelConfig() {
        WeiboShareChannelConfig.a aVar = WeiboShareChannelConfig.a;
        if (aVar.a().isEnable && StringKt.isNotNullOrEmpty(aVar.a().androidLinkPanelId)) {
            return new h.a(aVar.a().androidLinkPanelId).a;
        }
        return new h.a("8662_link_1").a;
    }

    public h getCommonSharePanelConfig() {
        String str;
        ShortSeriesSharePanelExp.a aVar = ShortSeriesSharePanelExp.a;
        if (aVar.a().isEnable && StringKt.isNotNullOrEmpty(aVar.a().androidSharePanelId)) {
            WeiboShareChannelConfig.a aVar2 = WeiboShareChannelConfig.a;
            if (aVar2.a().isEnable && StringKt.isNotNullOrEmpty(aVar2.a().androidCardPanelId)) {
                str = aVar2.a().androidCardPanelId;
            } else {
                str = aVar.a().androidSharePanelId;
            }
        } else {
            str = "8662_shortvideo_4";
        }
        return new h.a(str).a;
    }

    public h getSeriesPostSharePanelConfig() {
        String str;
        ShortSeriesSharePanelExp.a aVar = ShortSeriesSharePanelExp.a;
        if (aVar.a().isEnable && StringKt.isNotNullOrEmpty(aVar.a().androidVideoPoster)) {
            WeiboShareChannelConfig.a aVar2 = WeiboShareChannelConfig.a;
            if (aVar2.a().isEnable && StringKt.isNotNullOrEmpty(aVar2.a().androidPostPanelId)) {
                str = aVar2.a().androidPostPanelId;
            } else {
                str = aVar.a().androidVideoPoster;
            }
        } else {
            str = "8662_imagesave_4";
        }
        return new h.a(str).a;
    }

    public h getShortSeriesSharePanelConfig() {
        String str;
        ShortSeriesSharePanelExp.a aVar = ShortSeriesSharePanelExp.a;
        if (aVar.a().isEnable && StringKt.isNotNullOrEmpty(aVar.a().androidSharePanelId)) {
            WeiboShareChannelConfig.a aVar2 = WeiboShareChannelConfig.a;
            if (aVar2.a().isEnable && StringKt.isNotNullOrEmpty(aVar2.a().androidCardPanelId)) {
                str = aVar2.a().androidCardPanelId;
            } else {
                str = aVar.a().androidSharePanelId;
            }
        } else {
            str = "8662_shortvideo_4";
        }
        return new h.a(str).c(61).b("hongguo_video").a("hongguo").a;
    }
}
