package com.xs.fm.player.sdk;

import android.app.Application;
import android.content.Context;
import com.bytedance.covode.number.Covode;
import com.ss.android.common.applog.AppLog;
import com.ss.android.common.util.ToolUtils;
import com.ss.android.videoshop.api.VideoShop;
import com.ss.ttvideoengine.TTVideoEngine;
import com.ss.ttvideoengine.log.IVideoEventUploader;
import com.ss.ttvideoengine.log.VideoEventManager;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import com.ss.ttvideoengine.utils.TTVideoEngineLogListener;
import com.xs.fm.player.base.component.service.FMPlayService;
import com.xs.fm.player.base.play.inter.IPlayManager;
import org.json.JSONObject;
import pl6.h;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class FMPlayerSDK {
    private static final bl6.a mLog;

    public static IPlayManager getPlayManager() {
        return il6.a.B();
    }

    static class a implements TTVideoEngineLogListener {
        private final bl6.a a = new bl6.a("Engine_log");

        a() {
        }

        @Override // com.ss.ttvideoengine.utils.TTVideoEngineLogListener
        public void consoleLog(String str) {
            this.a.d(str, new Object[0]);
        }
    }

    static class c implements TTVideoEngineLogListener {
        private final bl6.a a = new bl6.a("Engine_log");

        c() {
        }

        @Override // com.ss.ttvideoengine.utils.TTVideoEngineLogListener
        public void consoleLog(String str) {
            this.a.d(str, new Object[0]);
        }
    }

    static {
        Covode.recordClassIndex(655877);
        mLog = new bl6.a("FMPlayerSDK");
    }

    public static void initConfig(lk6.b bVar) {
        lk6.c.a = bVar;
    }

    static class b implements IVideoEventUploader {
        final /* synthetic */ lk6.b a;

        b(lk6.b bVar) {
            this.a = bVar;
        }

        @Override // com.ss.ttvideoengine.log.IVideoEventUploader
        public void onUplaod(String str, JSONObject jSONObject) {
            AppLog.recordMiscLog(this.a.b, str, jSONObject);
        }
    }

    public static void init(lk6.b bVar) {
        init(bVar, true);
    }

    public static void initAppLifeCycleMonitor(Application application) {
        xk6.a.g().h(application);
    }

    public static void updateMediaSession(Context context) {
        cl6.a.g.update(context);
    }

    public static void updateNotification(Context context) {
        FMPlayService.m.n();
    }

    public static void innitPlayerSdk(lk6.b bVar) {
        if (bVar == null) {
            return;
        }
        lk6.c.a = bVar;
        FMPlayService.u();
        cl6.a.g.e();
        dl6.a.k();
        initAppLifeCycleMonitor(bVar.b);
        TTVideoEngine.setReportLogByEngine(bVar.l.j0(), bVar.b);
        if (bVar.l.z()) {
            TTVideoEngineLog.setListener(new a());
        }
        VideoEventManager.instance.setUploader(new b(bVar));
        initForEngineSettings(bVar.b, bVar.l.E());
        if (bVar.d) {
            h.g();
        }
    }

    static class d implements IVideoEventUploader {
        d() {
        }

        @Override // com.ss.ttvideoengine.log.IVideoEventUploader
        public void onUplaod(String str, JSONObject jSONObject) {
            AppLog.recordMiscLog(lk6.c.a.b, str, jSONObject);
        }
    }

    private static void initForEngineSettings(Application application, boolean z) {
        if (ToolUtils.isMainProcess(application) && !z) {
            TTVideoEngine.setApplicationContext(application);
            lk6.c.a.getClass();
            TTVideoEngine.setStringValue(116, "api.novelfm.com");
            TTVideoEngine.setStringValue(118, "vas-maliva16.byteoversea.com");
            TTVideoEngine.setStringValue(117, "vas-alisg16.byteoversea.com");
            lk6.c.a.getClass();
        }
    }

    public static void init(lk6.b bVar, boolean z) {
        if (bVar != null) {
            lk6.c.a = bVar;
        }
        FMPlayService.u();
        cl6.a.g.e();
        dl6.a.k();
        xk6.c.e.c();
        VideoShop.setAppContext(lk6.c.a.b);
        VideoShop.onlyHDRUseSurfaceView = true;
        kh6.b.d(new bl6.b());
        TTVideoEngine.setReportLogByEngine(lk6.c.a.l.j0(), lk6.c.a.b);
        if (lk6.c.a.l.z()) {
            TTVideoEngineLog.setListener(new c());
        }
        VideoEventManager.instance.setUploader(new d());
        lk6.b bVar2 = lk6.c.a;
        initForEngineSettings(bVar2.b, bVar2.l.E());
        if (z) {
            h.g();
        }
    }
}
