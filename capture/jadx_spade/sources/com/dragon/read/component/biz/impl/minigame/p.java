package com.dragon.read.component.biz.impl.minigame;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.apm.ApmAgent;
import com.bytedance.covode.number.Covode;
import com.bytedance.router.SmartRouter;
import com.bytedance.ug.sdk.luckyhost.api.LuckyServiceSDK;
import com.dragon.read.NsCommonDepend;
import com.dragon.read.app.ActivityRecordManager;
import com.dragon.read.app.App;
import com.dragon.read.base.AbsBroadcastReceiver;
import com.dragon.read.base.util.AdLog;
import com.dragon.read.base.util.LogWrapper;
import com.dragon.read.base.util.ThreadUtils;
import com.dragon.read.component.biz.api.NsAdApi;
import com.dragon.read.component.biz.api.NsMineApi;
import com.dragon.read.component.biz.api.NsUgApi;
import com.dragon.read.component.biz.impl.gamedetail.MiniGameDetailActivity;
import com.dragon.read.local.KvCacheMgr;
import com.dragon.read.plugin.common.PluginServiceManager;
import com.dragon.read.polaris.model.SingleTaskModel;
import com.dragon.read.report.PageRecorder;
import com.dragon.read.report.PageRecorderUtils;
import com.dragon.read.rpc.model.BookApiERR;
import com.dragon.read.rpc.model.SSTimorEntryType;
import com.dragon.read.rpc.model.SSTimorFrom;
import com.dragon.read.rpc.model.SSTimorTimeInfo;
import com.dragon.read.rpc.model.SSTimorTimeRequest;
import com.dragon.read.rpc.model.SSTimorTimeResponse;
import com.dragon.read.util.simple.SimpleActivityLifecycleCallbacks;
import f03.r;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import na3.z;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class p implements r {
    private static volatile p h;
    private volatile boolean b;
    private boolean d;
    private fz2.d e;
    private String f;
    AdLog a = new AdLog("PolarisMiniGameManager");
    private long c = -1;
    private String g = "";

    static {
        Covode.recordClassIndex(594688);
    }

    public void J() {
        this.f = null;
    }

    public void c() {
        this.b = false;
        this.c = -1L;
        this.d = false;
        this.f = null;
    }

    public static p t() {
        if (h == null) {
            synchronized (p.class) {
                if (h == null) {
                    h = new p();
                }
            }
        }
        return h;
    }

    private String u() {
        if (TextUtils.isEmpty(this.g)) {
            return "";
        }
        if ("benefit_page".equals(this.g)) {
            return "goldcoin";
        }
        return this.g;
    }

    public int b() {
        return KvCacheMgr.getPrivate(App.context(), "preference_ss_timor_entry").getInt("ss_timor_entry_type", SSTimorEntryType.EntryTypeOld.getValue());
    }

    private p() {
        new a().localRegister(new String[]{"game_lifecycle_callback", "game_center_on_resume"});
        c23.c.d().j();
        App.context().registerActivityLifecycleCallbacks(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void D() {
        if (!this.b) {
            this.d = false;
            this.a.i("福利页小游戏 游戏时长奖励 requestTimeAwardAvailable=false", new Object[0]);
        } else {
            g65.c.f0(new SSTimorTimeRequest()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer() { // from class: com.dragon.read.component.biz.impl.minigame.m
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    p.this.B((SSTimorTimeResponse) obj);
                }
            }, new Consumer() { // from class: com.dragon.read.component.biz.impl.minigame.n
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    p.this.C((Throwable) obj);
                }
            });
        }
    }

    public boolean g() {
        if (PluginServiceManager.ins().isPluginInstalled("com.dragon.read.plugin.appbrand") && PluginServiceManager.ins().isPluginLoaded("com.dragon.read.plugin.appbrand") && t().b() == SSTimorEntryType.EntryTypeCenter.getValue()) {
            return true;
        }
        return false;
    }

    public Map<String, Serializable> h() {
        String str;
        if (PluginServiceManager.ins().getAppBrandPlugin().isLoaded()) {
            str = PluginServiceManager.ins().getAppBrandPlugin().getJsSdkVersion(App.context());
        } else {
            str = "";
        }
        HashMap hashMap = new HashMap();
        hashMap.put("scene", v(this.g));
        hashMap.put("jssdk", str);
        hashMap.put("position", u());
        return hashMap;
    }

    private void I() {
        NsUgApi nsUgApi = NsUgApi.IMPL;
        SingleTaskModel A = nsUgApi.getTaskService().polarisTaskMgr().A("newbie_play_game");
        if (A == null) {
            this.a.i("福利页小游戏，任务为空：taskInMemory == null", new Object[0]);
            return;
        }
        long w = w(A);
        if (w > 0) {
            long j = this.c;
            if (j > 0 && j >= w) {
                this.a.i("福利页小游戏 游戏时长奖励", new Object[0]);
                nsUgApi.getTaskService().getReward("play_game", new JSONObject(), new d());
                return;
            }
        }
        this.a.i("福利页小游戏 游戏时长奖励 timorPlayTimeConf=%d, ssTimorTime=%d", new Object[]{Long.valueOf(w), Long.valueOf(this.c)});
    }

    public void d() {
        this.a.i("福利页小游戏 游戏时长奖励 小游戏列表页 onResume", new Object[0]);
        SingleTaskModel A = NsUgApi.IMPL.getTaskService().polarisTaskMgr().A("newbie_play_game");
        if (A != null && A.getDonePercent() == 33) {
            if (this.d) {
                this.a.i("福利页小游戏 游戏时长奖励 hasPostInBackground=true", new Object[0]);
            } else {
                ThreadUtils.postInBackground(new Runnable() { // from class: com.dragon.read.component.biz.impl.minigame.l
                    @Override // java.lang.Runnable
                    public final void run() {
                        p.this.D();
                    }
                }, 500L);
                this.d = true;
            }
        }
    }

    class a extends AbsBroadcastReceiver {
        a() {
        }

        public void onReceive(Context context, Intent intent, String str) {
            str.hashCode();
            if (!str.equals("game_center_on_resume")) {
                if (str.equals("game_lifecycle_callback")) {
                    p.this.x(intent);
                    return;
                }
                return;
            }
            p.this.d();
        }
    }

    class b extends SimpleActivityLifecycleCallbacks {
        b() {
        }

        public void onActivityDestroyed(Activity activity) {
            if (NsMineApi.IMPL.isLoginActivity(activity) && p.this.e != null) {
                if (NsCommonDepend.IMPL.acctManager().islogin()) {
                    p.this.e.a(activity);
                }
                p.this.e = null;
            }
        }
    }

    class c implements gi1.h {
        c() {
        }

        public void onSuccess(JSONObject jSONObject) {
            p.this.G(2, "MiniGameManager 首次玩小游戏奖励成功");
            if (jSONObject == null) {
                p.this.a.i("福利页小游戏 首次玩小游戏奖励 data == null", new Object[0]);
                return;
            }
            int optInt = jSONObject.optInt("amount");
            p.this.a.i("福利页小游戏 首次玩小游戏奖励 获取%1s金币: ", new Object[]{Integer.valueOf(optInt)});
            KvCacheMgr.getPrivate(App.context(), "Timor_" + NsCommonDepend.IMPL.acctManager().getUserId()).edit().putBoolean("has_timor_first_award", true).apply();
            NsUgApi.IMPL.getUtilsService().showRewardToast(App.context(), String.format(Locale.CHINA, "+ %d 金币\n首次玩小游戏奖励", Integer.valueOf(optInt)));
        }

        public void onFailed(int i, String str) {
            p.this.G(3, "MiniGameManager 福利页小游戏 首次玩小游戏奖励 award errorcode = " + i + ", msg = " + str);
            LogWrapper.e("PolarisMiniGameManager", new Object[]{"福利页小游戏 首次玩小游戏奖励 award error: %d, %s", Integer.valueOf(i), str});
        }
    }

    class d implements gi1.h {
        d() {
        }

        public void onSuccess(JSONObject jSONObject) {
            p.this.G(7, "MiniGameManager 福利页小游戏 游戏时长奖励成功");
            if (jSONObject == null) {
                p.this.a.i("福利页小游戏 游戏时长奖励 data == null ", new Object[0]);
                return;
            }
            int optInt = jSONObject.optInt("amount");
            p.this.a.i("福利页小游戏 游戏时长奖励 获取%1s金币: ", new Object[]{Integer.valueOf(optInt)});
            KvCacheMgr.getPrivate(App.context(), "Timor_" + NsCommonDepend.IMPL.acctManager().getUserId()).edit().putBoolean("has_timor_time_award", true).apply();
            NsUgApi nsUgApi = NsUgApi.IMPL;
            nsUgApi.getUtilsService().showRewardToast(App.context(), String.format(Locale.CHINA, "+ %d 金币\n游戏时长奖励", Integer.valueOf(optInt)));
            p.this.b = false;
            if (nsUgApi.getUtilsService().isInPolarisPage(ActivityRecordManager.inst().getCurrentActivity())) {
                LuckyServiceSDK.getCatService().sendEventToLuckyCatWebView("novelOnTaskPageRefresh", new JSONObject());
                LuckyServiceSDK.getCatService().sendEventToLynxView("novelOnTaskPageRefresh", new JSONObject());
            }
        }

        public void onFailed(int i, String str) {
            p.this.b = false;
            p.this.G(8, "MiniGameManager 福利页小游戏 游戏时长奖励 award error = " + i + ", msg = " + str);
            LogWrapper.e("PolarisMiniGameManager", new Object[]{"福利页小游戏 游戏时长奖励 award error: %d, %s", Integer.valueOf(i), str});
        }
    }

    public void e(String str) {
        Uri parse = Uri.parse(str);
        String queryParameter = parse.getQueryParameter("scene");
        String queryParameter2 = parse.getQueryParameter("app_id");
        if (TextUtils.isEmpty(queryParameter2)) {
            queryParameter2 = "tt157f63c28a555a38";
        }
        y(str, queryParameter, queryParameter2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void C(Throwable th) throws Exception {
        this.d = false;
        G(6, "MiniGameManager 福利页小游戏 获取游戏奖励时长失败 error msg = " + th.getMessage());
        LogWrapper.error("PolarisMiniGameManager", "福利页小游戏 获取游戏奖励时长失败 error=%s", new Object[]{Log.getStackTraceString(th)});
    }

    private long w(SingleTaskModel singleTaskModel) {
        int i;
        JSONObject statusExtra = singleTaskModel.getStatusExtra();
        if (!statusExtra.isNull("second")) {
            try {
                i = statusExtra.getInt("second");
            } catch (JSONException e) {
                LogWrapper.error("PolarisMiniGameManager", "福利页小游戏 获取福利页游戏时长配置 error=%s", new Object[]{Log.getStackTraceString(e)});
                e.printStackTrace();
            }
            LogWrapper.info("PolarisMiniGameManager", "福利页小游戏 获取福利页游戏时长配置->%d", new Object[]{Integer.valueOf(i)});
            return i;
        }
        i = -1;
        LogWrapper.info("PolarisMiniGameManager", "福利页小游戏 获取福利页游戏时长配置->%d", new Object[]{Integer.valueOf(i)});
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void B(SSTimorTimeResponse sSTimorTimeResponse) throws Exception {
        this.d = false;
        if (sSTimorTimeResponse.code == BookApiERR.SUCCESS) {
            G(5, "MiniGameManager 福利页小游戏 获取游戏奖励时长成功->" + this.c);
            SSTimorTimeInfo sSTimorTimeInfo = sSTimorTimeResponse.data;
            if (sSTimorTimeInfo != null) {
                long j = sSTimorTimeInfo.playTime;
                this.c = j;
                LogWrapper.info("PolarisMiniGameManager", "福利页小游戏 获取游戏奖励时长为->%s", new Object[]{Long.valueOf(j)});
                I();
                return;
            }
            LogWrapper.info("PolarisMiniGameManager", "福利页小游戏 获取游戏奖励时长为->response.data == null", new Object[0]);
            return;
        }
        G(6, "MiniGameManager 福利页小游戏 获取游戏奖励时长->response.code == " + sSTimorTimeResponse.code);
        LogWrapper.info("PolarisMiniGameManager", "福利页小游戏 获取游戏奖励时长response.code == %s", new Object[]{sSTimorTimeResponse.code});
    }

    public String v(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        str.hashCode();
        switch (str) {
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(Intent intent) {
        if (!NsAdApi.IMPL.getCommonAdConfig().polarisTimorSwitch) {
            this.a.i("福利页小游戏 settings开关：polaris_timor_switch未打开", new Object[0]);
            return;
        }
        String stringExtra = intent.getStringExtra("mini_game_lifecycle");
        NsUgApi nsUgApi = NsUgApi.IMPL;
        SingleTaskModel A = nsUgApi.getTaskService().polarisTaskMgr().A("newbie_play_game");
        if (A == null) {
            LogWrapper.info("PolarisMiniGameManager", "福利页小游戏，任务为空：taskInMemory == null", new Object[0]);
            return;
        }
        SharedPreferences sharedPreferences = KvCacheMgr.getPrivate(App.context(), "Timor_" + NsCommonDepend.IMPL.acctManager().getUserId());
        boolean z = sharedPreferences.getBoolean("has_timor_first_award", false);
        if (A.getDonePercent() == 0 && !z && TextUtils.equals("open", stringExtra)) {
            G(1, "MiniGameManager 福利页小游戏 首次玩小游戏奖励");
            this.a.i("福利页小游戏 首次玩小游戏奖励", new Object[0]);
            nsUgApi.getTaskService().getReward("play_game", new JSONObject(), new c());
            return;
        }
        boolean z2 = sharedPreferences.getBoolean("has_timor_time_award", false);
        int donePercent = A.getDonePercent();
        this.a.i("福利页小游戏 游戏时长奖励 donePercent = %d, hasTimorTimeAward=%b", new Object[]{Integer.valueOf(donePercent), Boolean.valueOf(z2)});
        if (donePercent == 33) {
            if ((!z2 || A.isGameStyleProgress()) && TextUtils.equals("close", stringExtra)) {
                G(4, "MiniGameManager 福利页小游戏 游戏时长奖励");
                this.a.i("福利页小游戏 游戏时长奖励 requestTimeAwardAvailable = true", new Object[0]);
                this.b = true;
            }
        }
    }

    public void openMiniGameDetailActivity(Context context, String str) {
        Intent intent = new Intent(context, (Class<?>) MiniGameDetailActivity.class);
        intent.putExtra("scene", str);
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G(int i, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("status_msg", str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            ApmAgent.monitorStatusAndEvent("mini_game_monitor", i, jSONObject, (JSONObject) null, (JSONObject) null);
        } catch (Throwable th) {
            LogWrapper.e("PolarisMiniGameManager", new Object[]{"福利页小游戏 monitorStatusRate case exception: " + th});
        }
    }

    public void f(Context context, fz2.d dVar) {
        NsCommonDepend nsCommonDepend = NsCommonDepend.IMPL;
        if (nsCommonDepend.acctManager().islogin()) {
            dVar.a((Activity) null);
        } else {
            nsCommonDepend.appNavigator().openLoginActivity(context, PageRecorderUtils.getCurrentPageRecorder(), "game_center");
            this.e = dVar;
        }
    }

    public void y(String str, String str2, String str3) {
        z(str, str2, str3, null);
    }

    public void a(final Context context, final String str, final PageRecorder pageRecorder, final SSTimorFrom sSTimorFrom) {
        f(context, new fz2.d() { // from class: com.dragon.read.component.biz.impl.minigame.j
            public final void a(Activity activity) {
                p.this.E(sSTimorFrom, pageRecorder, str, context, activity);
            }
        });
    }

    public void z(final String str, final String str2, final String str3, final Bundle bundle) {
        f(App.context(), new fz2.d() { // from class: com.dragon.read.component.biz.impl.minigame.k
            public final void a(Activity activity) {
                p.this.A(str, bundle, str2, str3, activity);
            }
        });
    }

    public void H(final Context context, final String str, PageRecorder pageRecorder, final SSTimorFrom sSTimorFrom, final String str2) {
        f(context, new fz2.d() { // from class: com.dragon.read.component.biz.impl.minigame.o
            public final void a(Activity activity) {
                p.this.F(sSTimorFrom, str2, str, context, activity);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void A(String str, Bundle bundle, String str2, String str3, Activity activity) {
        this.f = str;
        Bundle bundle2 = new Bundle();
        if (bundle == null) {
            bundle = bundle2;
        }
        SmartRouter.buildRoute(App.context(), str).withParam("position", str2).withParam("game_id", str3).withParam(bundle).open();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F(SSTimorFrom sSTimorFrom, String str, String str2, Context context, Activity activity) {
        String gameCenterSchema = z.a.getGameCenterSchema(sSTimorFrom);
        if (!TextUtils.isEmpty(gameCenterSchema)) {
            y(gameCenterSchema + "&direct_jump_sstimor=" + str, str2, "tt157f63c28a555a38");
            return;
        }
        NsCommonDepend.IMPL.appNavigator().openMiniGameDetailActivity(context, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void E(SSTimorFrom sSTimorFrom, PageRecorder pageRecorder, String str, Context context, Activity activity) {
        String gameCenterSchema = z.a.getGameCenterSchema(sSTimorFrom);
        if (!TextUtils.isEmpty(gameCenterSchema)) {
            if (pageRecorder != null && pageRecorder.getParam("slide_bar_tab_name") != null) {
                Bundle bundle = new Bundle();
                Serializable param = pageRecorder.getParam("slide_bar_tab_name");
                if (param instanceof String) {
                    bundle.putString("slide_bar_tab_name", (String) param);
                }
                Serializable param2 = pageRecorder.getParam("launch_from");
                if (param2 instanceof String) {
                    bundle.putString("launch_from", (String) param2);
                }
                Serializable param3 = pageRecorder.getParam("location");
                if (param3 instanceof String) {
                    bundle.putString("location", (String) param3);
                }
                Serializable param4 = pageRecorder.getParam("scene");
                if (param4 instanceof String) {
                    bundle.putString("scene", (String) param4);
                }
                if (!bundle.isEmpty()) {
                    z(gameCenterSchema, str, "tt157f63c28a555a38", bundle);
                    return;
                }
            }
            y(gameCenterSchema, str, "tt157f63c28a555a38");
            return;
        }
        NsCommonDepend.IMPL.appNavigator().openMiniGameDetailActivity(context, str);
    }
}
