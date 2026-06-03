package com.dragon.read.component.biz.impl;

import com.bytedance.covode.number.Covode;
import com.dragon.read.base.AbsFragment;
import com.dragon.read.component.biz.impl.brickservice.BsECConfigService;
import com.dragon.read.component.biz.impl.mall.BottomTabMallNAFragment;
import com.dragon.read.component.biz.impl.mall.model.LoginAuthSetting;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class HongguoECConfig implements BsECConfigService {
    public static final int $stable = 0;
    public static final a Companion;

    public static final class a {
        static {
            Covode.recordClassIndex(588079);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Covode.recordClassIndex(588078);
        Companion = new a(null);
    }

    public String getBindedCouponDialogBg() {
        return "img_659_douyin_pay_coupon_bg_hongguo.png";
    }

    public String getEcomSearchPageCardDefaultSchema() {
        return "sslocal://lynxview/?surl=https%3A%2F%2Freading.snssdk.com%2Freading_offline%2Fnrlynx_monetize_search%2Fecom-search-page-card%2Ftemplate.js&prefix=reading_offline";
    }

    public String getMallStraightOutConfig() {
        return "{\"native_mall_bundle_config_url\":\"https://lf-ecom-gr-sourcecdn.bytegecko.com/obj/byte-gurd-source-gr/mall/saas/8662/ecom_mall_cards_novelhg/config.json\",\"mall_gecko_channel\":\"ecom_mall_cards_novelhg\",\"mall_enable_first_screen_render\":2,\"native_mall_bundle_config_preload\":true}";
    }

    public String getNativeMallConfig() {
        return "{\"native_mall_bundle_config_url\":\"https://lf-ecom-gr-sourcecdn.bytegecko.com/obj/byte-gurd-source-gr/mall/saas/8662/ecom_mall_cards_novelhg/config.json\",\"mall_gecko_channel\":\"ecom_mall_cards_novelhg\"}";
    }

    public String getPageCardSchema() {
        return "hybrid://lynxview?enable_code_cache=1&enable_js_runtime=true&surl=https%3A%2F%2Flf-ecom-gr-sourcecdn.bytegecko.com%2Fobj%2Fbyte-gurd-source-gr%2Fmall%2Fsaas%2F8662%2Fecom_mall_cards_novelhg%2Fcards%2Fpage_card%2Ftemplate.js";
    }

    public float getPreviewPlayerViewHeightThreshold() {
        return 0.5f;
    }

    public boolean useNativeTabMall() {
        return true;
    }

    public boolean useNewPreloadMallConfigOrHomepage() {
        return true;
    }

    public AbsFragment getTabMallFragment() {
        return BottomTabMallNAFragment.G.a();
    }

    public LoginAuthSetting getECSaasLoginAuthSetting() {
        return new LoginAuthSetting(true, "完成抖音登录抢购超值好物");
    }

    public boolean isInTabMall(AbsFragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        return fragment instanceof BottomTabMallNAFragment;
    }
}
