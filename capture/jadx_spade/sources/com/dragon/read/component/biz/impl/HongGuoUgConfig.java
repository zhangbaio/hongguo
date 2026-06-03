package com.dragon.read.component.biz.impl;

import android.graphics.ColorFilter;
import android.net.Uri;
import androidx.core.content.ContextCompat;
import com.bytedance.covode.number.Covode;
import com.bytedance.geckox.model.CheckRequestBodyModel;
import com.dragon.read.NsCommonDepend;
import com.dragon.read.app.ActivityRecordManager;
import com.dragon.read.app.App;
import com.dragon.read.base.ssconfig.model.LocalAppLogUpgradeConfig;
import com.dragon.read.base.ui.util.ScreenUtils;
import com.dragon.read.component.biz.api.NsUgDepend;
import com.dragon.read.component.biz.impl.brickservice.BsUgConfigService;
import com.dragon.read.polaris.cold.start.e;
import com.dragon.read.polaris.video.w2;
import com.dragon.reader.lib.ReaderClient;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.ss.android.messagebus.BusProvider;
import dn2.p;
import dw4.j;
import dw4.k;
import gw4.y0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import zr3.g;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class HongGuoUgConfig implements BsUgConfigService {
    public static final int $stable = 0;

    static {
        Covode.recordClassIndex(588073);
    }

    public boolean enableBuiltInForest() {
        return true;
    }

    public boolean enableShotUgReport() {
        return true;
    }

    public String getAppWidgetGuideBizName() {
        return "hongguo_widget_guide_model_predict";
    }

    public String getBuildInForestChannel() {
        return "growth_incentive-monorepo_novel-lite";
    }

    public String getGoldBoxChannel() {
        return "novel-video-box";
    }

    public String getPushGuideBizName() {
        return "hongguo_push_guide_model_predict";
    }

    public String getSecondFloorBackUpImage() {
        return "img_703_second_floor_back_up_hong_guo.png";
    }

    public String getSecondFloorErrorImage() {
        return "img_second_floor_error_image_hongguo.png";
    }

    public String getTakeCashOneYuanTaskReadType() {
        return "short_video";
    }

    public String getVideoRewardTaskAdAliasPosition() {
        return "watch_reward_ad";
    }

    public String getVideoRewardTaskAdRit() {
        return "5800901";
    }

    public boolean improveAttributionRequest() {
        return true;
    }

    public boolean isDefaultSupportAppWidgetCep() {
        return true;
    }

    public boolean isGoldBoxHideViewEnableClose() {
        return false;
    }

    public boolean isNewUserInspireWithTips() {
        return true;
    }

    public boolean needVibrateSwitch() {
        return true;
    }

    public boolean optBookShelfGoldBoxEnterance() {
        return true;
    }

    public boolean showNewBookGuideSnackBarInVideoConsumer() {
        return true;
    }

    public int surlRequestOptTimeOut() {
        return -1;
    }

    public void resetMultiInviteTaskDataFanqie() {
        BsUgConfigService.b.A(this);
    }

    public boolean enableColdStartWidget() {
        return BsUgConfigService.b.a(this);
    }

    public boolean enableFreeCellularTokenOpt() {
        return BsUgConfigService.b.b(this);
    }

    public boolean enableHostFission() {
        return BsUgConfigService.b.c(this);
    }

    public boolean enableMergeDailyTaskFeature() {
        return BsUgConfigService.b.d(this);
    }

    public boolean enablePolarisMultiTab() {
        return BsUgConfigService.b.e(this);
    }

    public boolean enablePolarisWidgetReverse() {
        return BsUgConfigService.b.f(this);
    }

    public boolean enablePrivacyDialogCompliance() {
        return BsUgConfigService.b.g(this);
    }

    public boolean enableRequestRandomReward() {
        return BsUgConfigService.b.h(this);
    }

    public boolean enableShortVideoExitIntercept() {
        return BsUgConfigService.b.i(this);
    }

    public boolean enableWechatPay() {
        return BsUgConfigService.b.j(this);
    }

    public boolean enableWxOpenTag() {
        return BsUgConfigService.b.k(this);
    }

    public boolean forceUseDefaultCertConfig() {
        return BsUgConfigService.b.l(this);
    }

    public List<CheckRequestBodyModel.TargetChannel> getColdStartLoadChannelList() {
        return BsUgConfigService.b.n(this);
    }

    public LocalAppLogUpgradeConfig getLocalAppLogUpgradeConfig() {
        return mb0.a.b(true);
    }

    public g getLossEpisodesTaskShortSeriesSeekBarConfig() {
        return new a();
    }

    public int getSurlTimeout() {
        return BsUgConfigService.b.o(this);
    }

    public com.dragon.read.component.biz.impl.brickservice.g getWebPrefetchConfig() {
        return BsUgConfigService.b.p(this);
    }

    public int getWithDrawDarkDrawableRes() {
        return BsUgConfigService.b.q(this);
    }

    public int getWithDrawDrawableRes() {
        return BsUgConfigService.b.r(this);
    }

    public boolean isEnableLaHuoAppUndertakeExpr() {
        return BsUgConfigService.b.t(this);
    }

    public boolean isGoldCoinVideoSeries() {
        return BsUgConfigService.b.u(this);
    }

    public boolean isInspireSettingsEnable() {
        return BsUgConfigService.b.v(this);
    }

    public boolean isNeedReportAppInstallStatusForResourcePlan() {
        return BsUgConfigService.b.w(this);
    }

    public boolean isTakeCashSmallBottomBar() {
        return BsUgConfigService.b.x(this);
    }

    public boolean skipLightRedPackTakeCashDialog() {
        return w2.a.G();
    }

    public static final class a implements g {
        a() {
        }

        @Override // zr3.g
        public String a() {
            return "short_series_gold_coin_bar_lottie/images";
        }

        @Override // zr3.g
        public String h() {
            return "short_series_gold_coin_bar_lottie/data.json";
        }

        @Override // zr3.g
        public int b() {
            return ScreenUtils.dpToPxInt(App.context(), 2.0f);
        }

        @Override // zr3.g
        public int c() {
            return ContextCompat.getColor(App.context(), 2131560018);
        }

        @Override // zr3.g
        public int d() {
            return ScreenUtils.dpToPxInt(App.context(), 4.0f);
        }

        @Override // zr3.g
        public int e() {
            return ScreenUtils.dpToPxInt(App.context(), 10.0f);
        }

        @Override // zr3.g
        public int f() {
            return ScreenUtils.dpToPxInt(App.context(), 40.0f);
        }

        @Override // zr3.g
        public int g() {
            return ScreenUtils.dpToPxInt(App.context(), 40.0f);
        }
    }

    public boolean enableSurlRequestOpt() {
        Boolean d = nb0.a.d(true);
        Intrinsics.checkNotNullExpressionValue(d, "enableSurlRequestOptHg(...)");
        return d.booleanValue();
    }

    public void postMultiInviteTaskFragmentVisibleHongguo() {
        BusProvider.post(new j());
    }

    public void resetMultiInviteTaskDataHongguo() {
        y0.a.s();
        BusProvider.post(new k(false));
    }

    public void setAttributionDefaultArg() {
        NsCommonDepend.IMPL.attributionManager().markPopRed(0);
    }

    public boolean skipLightRedPackExitConsumeDialog() {
        boolean isInSeriesFeedBottomTab = NsUgDepend.IMPL.isInSeriesFeedBottomTab(ActivityRecordManager.inst().getCurrentVisibleActivity());
        boolean j = e.a.j();
        boolean G = w2.a.G();
        if (!isInSeriesFeedBottomTab && !j && !G) {
            return false;
        }
        return true;
    }

    public void handleSchemaForExternalExchange(String str) {
        BsUgConfigService.b.s(this, str);
    }

    public void onAttachReaderClient(ReaderClient readerClient) {
        BsUgConfigService.b.z(this, readerClient);
    }

    public ColorFilter getCoinBitmapPaintColorFilter(ReaderClient readerClient) {
        return BsUgConfigService.b.m(this, readerClient);
    }

    public boolean isTaskPage(String str) {
        return BsUgConfigService.b.y(this, str);
    }

    public boolean isInMiuiWidget(String widgetName) {
        Intrinsics.checkNotNullParameter(widgetName, "widgetName");
        if (!Intrinsics.areEqual(widgetName, "multi_genre_short_video_recommend") && !Intrinsics.areEqual(widgetName, "welfare_task")) {
            return false;
        }
        return true;
    }

    public List<CheckRequestBodyModel.TargetChannel> getDrColdStartLoadChannelList(List<String> channelList) {
        Intrinsics.checkNotNullParameter(channelList, "channelList");
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(channelList, 10));
        Iterator<T> it2 = channelList.iterator();
        while (it2.hasNext()) {
            arrayList.add(new CheckRequestBodyModel.TargetChannel((String) it2.next()));
        }
        return arrayList;
    }

    public boolean isInVivoLowVersionWidget(String widgetName) {
        Intrinsics.checkNotNullParameter(widgetName, "widgetName");
        if (!Intrinsics.areEqual(widgetName, "welfare_task") && !Intrinsics.areEqual(widgetName, "short_video_recent") && !Intrinsics.areEqual(widgetName, "short_video_recent_v2") && !Intrinsics.areEqual(widgetName, "multi_genre_short_video_recommend") && !Intrinsics.areEqual(widgetName, "search")) {
            return false;
        }
        return true;
    }

    public boolean isZlink(Uri uri) {
        boolean contains$default;
        boolean contains$default2;
        boolean contains$default3;
        Intrinsics.checkNotNullParameter(uri, "uri");
        String uri2 = uri.toString();
        Intrinsics.checkNotNullExpressionValue(uri2, "toString(...)");
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) uri2, (CharSequence) "/z", false, 2, (Object) null);
        if (!contains$default) {
            String uri3 = uri.toString();
            Intrinsics.checkNotNullExpressionValue(uri3, "toString(...)");
            contains$default2 = StringsKt__StringsKt.contains$default((CharSequence) uri3, (CharSequence) "applink.changdunovel.com", false, 2, (Object) null);
            if (!contains$default2) {
                String uri4 = uri.toString();
                Intrinsics.checkNotNullExpressionValue(uri4, "toString(...)");
                contains$default3 = StringsKt__StringsKt.contains$default((CharSequence) uri4, (CharSequence) "novel8662.ugurl.cn", false, 2, (Object) null);
                if (!contains$default3) {
                    return false;
                }
            }
        }
        return true;
    }

    public void buildDefaultCertConfig(JsonObject jsonObject) {
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        JsonObject jsonObject2 = new JsonObject();
        jsonObject2.addProperty("expire_time", 1710907200000L);
        Unit unit = Unit.INSTANCE;
        jsonObject.add("bpea-ug_luckycat_fission_clipboard", jsonObject2);
        JsonObject jsonObject3 = new JsonObject();
        jsonObject3.addProperty("unit_disable", 3072);
        jsonObject3.addProperty("pattern_confidence", Double.valueOf(0.8d));
        JsonArray jsonArray = new JsonArray();
        jsonArray.add("email");
        jsonArray.add("datetime");
        jsonObject3.add("patterns", jsonArray);
        jsonObject.add("bpea-ug_share_sdk_clipboard", jsonObject3);
        JsonObject jsonObject4 = new JsonObject();
        jsonObject4.addProperty("unit_disable", 3072);
        JsonArray jsonArray2 = new JsonArray();
        jsonArray2.add("email");
        jsonArray2.add("datetime");
        jsonObject4.add("patterns", jsonArray2);
        jsonObject.add("bpea-ug_zlink_sdk_clipboard", jsonObject4);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public p getVivoWidgetGuide(boolean z, String widgetName) {
        int i;
        int i2;
        int i3;
        int i4;
        Intrinsics.checkNotNullParameter(widgetName, "widgetName");
        switch (widgetName.hashCode()) {
            case -1294513037:
                if (widgetName.equals("multi_genre_short_video_recommend")) {
                    if (z) {
                        i = 2131104071;
                    } else {
                        i = 2131104070;
                    }
                    return new p(i, "添加「短剧推荐组件」到桌面", "一键直达热门短剧", "2 x 4", (String) null, 16, (DefaultConstructorMarker) null);
                }
                return null;
            case -1118417534:
                if (widgetName.equals("short_video_recent")) {
                    if (z) {
                        i2 = 2131104077;
                    } else {
                        i2 = 2131104076;
                    }
                    return new p(i2, "添加「追剧组件」到桌面", "一键续看更新的短剧", "2 x 2", (String) null, 16, (DefaultConstructorMarker) null);
                }
                return null;
            case -906336856:
                if (widgetName.equals("search")) {
                    if (z) {
                        i3 = 2131104075;
                    } else {
                        i3 = 2131104074;
                    }
                    return new p(i3, "添加「搜索组件」到桌面", "随时搜索，快速找剧", "2 x 4", (String) null, 16, (DefaultConstructorMarker) null);
                }
                return null;
            case 280043864:
                if (widgetName.equals("welfare_task")) {
                    if (z) {
                        i4 = 2131104063;
                    } else {
                        i4 = 2131104062;
                    }
                    return new p(i4, "添加「福利组件」到桌面", "一键直达，奖励不错过", "2 x 2", p.f.a());
                }
                return null;
            default:
                return null;
        }
    }
}
