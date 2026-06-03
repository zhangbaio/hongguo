package lk4;

import android.app.Activity;
import com.bytedance.covode.number.Covode;
import com.dragon.read.NsCommonDepend;
import com.dragon.read.app.ActivityRecordManager;
import com.dragon.read.app.App;
import com.dragon.read.base.skin.SkinManager;
import com.dragon.read.base.ui.util.ScreenUtils;
import com.dragon.read.component.audio.api.NsAudioModuleApi;
import com.dragon.read.component.biz.api.NsUgDepend;
import com.dragon.read.polaris.video.l3;
import ix4.d5;
import java.util.LinkedHashMap;
import java.util.Map;
import jx4.f;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a implements pg1.a {
    static {
        Covode.recordClassIndex(607897);
    }

    public String getCurrentShareFromType() {
        return f.a.e();
    }

    public boolean isNightMode() {
        return SkinManager.isNightMode();
    }

    public long getPureShortVideoTime() {
        return l3.a.I().H() / 1000;
    }

    public boolean isLogin() {
        return NsCommonDepend.IMPL.acctManager().islogin();
    }

    public long getPureListentime() {
        return d5.X2().t().longValue() / 1000;
    }

    public long getPureReadTime() {
        return d5.X2().g().longValue() / 1000;
    }

    public Map<String, String> getScreenInfo() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("width", String.valueOf(ScreenUtils.getScreenWidth(App.context())));
        linkedHashMap.put("height", String.valueOf(ScreenUtils.getScreenHeight(App.context())));
        return linkedHashMap;
    }

    public String getCurrentPage() {
        int seriesSubTabType;
        Activity currentVisibleActivity = ActivityRecordManager.inst().getCurrentVisibleActivity();
        NsAudioModuleApi nsAudioModuleApi = NsAudioModuleApi.IMPL;
        if (nsAudioModuleApi.obtainAudioNavigatorApi().isAudioPlayActivity(currentVisibleActivity)) {
            return "audio_player";
        }
        if (nsAudioModuleApi.obtainAudioNavigatorApi().i(currentVisibleActivity)) {
            return "audio_detail";
        }
        NsUgDepend nsUgDepend = NsUgDepend.IMPL;
        if (nsUgDepend.isMainFragmentActivity(currentVisibleActivity) && nsUgDepend.isInBookMallTab(currentVisibleActivity)) {
            int subTabType = nsUgDepend.getSubTabType(currentVisibleActivity);
            if (subTabType > 0) {
                return String.valueOf(subTabType);
            }
        } else if (nsUgDepend.isMainFragmentActivity(currentVisibleActivity) && nsUgDepend.isInSeriesMallTab(currentVisibleActivity) && (seriesSubTabType = nsUgDepend.getSeriesSubTabType(currentVisibleActivity)) > 0) {
            return String.valueOf(seriesSubTabType);
        }
        Activity currentVisibleActivity2 = ActivityRecordManager.inst().getCurrentVisibleActivity();
        if (currentVisibleActivity2 != null) {
            return currentVisibleActivity2.getClass().getSimpleName();
        }
        return null;
    }
}
