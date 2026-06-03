package com.ss.ttvideoengine.log;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.bytedance.helios.statichook.api.ExtraInfo;
import com.bytedance.helios.statichook.api.HeliosApiHook;
import com.bytedance.helios.statichook.api.Result;
import com.ss.ttvideoengine.DataLoaderHelper;
import com.ss.ttvideoengine.utils.EngineThreadPool;
import com.ss.ttvideoengine.utils.Inspector;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicInteger;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.ImplementedInterface;
import me.ele.lancet.base.annotations.Insert;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class AppLogEngineUploader implements VideoEventEngineUploader {
    private static volatile Method getSessionIdStaticMethod;
    private static AtomicInteger isApplogOrBDTracker;
    private static volatile Method onEventV3StaticMethod;
    private static volatile Method onMiscEventStaticMethod;
    private Context mContext;

    private AppLogEngineUploader() {
    }

    private static Object com_ss_ttvideoengine_log_AppLogEngineUploader_java_lang_reflect_Method_invoke(Method method, Object obj, Object[] objArr) {
        Result preInvoke = new HeliosApiHook().preInvoke(110000, "java/lang/reflect/Method", "invoke", method, new Object[]{obj, objArr}, "java.lang.Object", new ExtraInfo(true, "(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;"));
        return preInvoke.isIntercept() ? preInvoke.getReturnValue() : method.invoke(obj, objArr);
    }

    @Override // com.ss.ttvideoengine.log.VideoEventEngineUploader
    public void onEvent(String str, JSONObject jSONObject) {
        com_ss_ttvideoengine_log_AppLogEngineUploader_com_dragon_read_aop_NetworkTrafficAop_onEvent(this, str, jSONObject);
    }

    private static class Holder {
        private static final AppLogEngineUploader instance;

        private Holder() {
        }

        static {
            Covode.recordClassIndex(652457);
            instance = new AppLogEngineUploader();
        }
    }

    public static AppLogEngineUploader getInstance() {
        return Holder.instance;
    }

    static {
        Covode.recordClassIndex(652456);
        getSessionIdStaticMethod = null;
        onMiscEventStaticMethod = null;
        onEventV3StaticMethod = null;
        isApplogOrBDTracker = new AtomicInteger(0);
        getMethod();
    }

    private static void getMethod() {
        if (getSessionIdStaticMethod == null || onMiscEventStaticMethod == null || onEventV3StaticMethod == null) {
            getMethodFromAppLog();
        }
        if (getSessionIdStaticMethod == null || onMiscEventStaticMethod == null || onEventV3StaticMethod == null) {
            getMethodFromBDTracker();
        }
    }

    private static void getMethodFromAppLog() {
        try {
            Class q = l3.a.q("com.ss.android.common.applog.AppLog");
            getSessionIdStaticMethod = q.getMethod("getCurrentSessionId", new Class[0]);
            onMiscEventStaticMethod = q.getMethod("recordMiscLog", Context.class, String.class, JSONObject.class);
            onEventV3StaticMethod = l3.a.q("com.ss.android.common.lib.AppLogNewUtils").getMethod("onEventV3", String.class, JSONObject.class);
            isApplogOrBDTracker.set(1);
            TTVideoEngineLog.i("AppLogEngineUploader", "upload AppLog Success!");
        } catch (Exception e) {
            e.printStackTrace();
            TTVideoEngineLog.e("AppLogEngineUploader", "upload error (AppLog)" + e);
        }
    }

    private static void getMethodFromBDTracker() {
        try {
            Class q = l3.a.q("com.bytedance.applog.AppLog");
            getSessionIdStaticMethod = q.getMethod("getSessionId", new Class[0]);
            onMiscEventStaticMethod = q.getMethod("onMiscEvent", String.class, JSONObject.class);
            onEventV3StaticMethod = q.getMethod("onEventV3", String.class, JSONObject.class);
            isApplogOrBDTracker.set(2);
            TTVideoEngineLog.i("AppLogEngineUploader", "upload BDTracker Success!");
        } catch (Exception e) {
            e.printStackTrace();
            TTVideoEngineLog.e("AppLogEngineUploader", "upload error (bdtracker)" + e);
        }
    }

    public void setReportLogByEngine(boolean z, Context context) {
        this.mContext = context;
        if (z) {
            DataLoaderHelper.getDataLoader().setEngineUploader(this);
            VideoEventManager.instance.setEngineUploader(this);
        } else {
            DataLoaderHelper.getDataLoader().setEngineUploader(null);
            VideoEventManager.instance.setEngineUploader(null);
        }
    }

    public void AppLogEngineUploader__onEvent$___twin___(final String str, final JSONObject jSONObject) {
        if (str != null && jSONObject != null) {
            EngineThreadPool.addExecuteTask(new Runnable() { // from class: com.ss.ttvideoengine.log.a
                @Override // java.lang.Runnable
                public final void run() {
                    AppLogEngineUploader.this.lambda$onEvent$0(str, jSONObject);
                }
            });
            return;
        }
        TTVideoEngineLog.e("AppLogEngineUploader", "onEvent, invalid parameter, event: " + str + ", " + jSONObject);
    }

    @Override // com.ss.ttvideoengine.log.VideoEventEngineUploader
    public void onEventV2(final String str, final JSONObject jSONObject) {
        if (str != null && jSONObject != null) {
            EngineThreadPool.addExecuteTask(new Runnable() { // from class: com.ss.ttvideoengine.log.b
                @Override // java.lang.Runnable
                public final void run() {
                    AppLogEngineUploader.lambda$onEventV2$1(str, jSONObject);
                }
            });
            return;
        }
        TTVideoEngineLog.e("AppLogEngineUploader", "onEventV2, invalid parameter, event: " + str + ", " + jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$onEventV2$1(String str, JSONObject jSONObject) {
        TTVideoEngineLog.i("AppLogEngineUploader", "onEventV2 monitorName " + str);
        if (!TextUtils.isEmpty(str)) {
            getMethod();
            if (onEventV3StaticMethod != null) {
                try {
                    jSONObject.putOpt("params_for_special", "videoplayer_monitor");
                    jSONObject.put("auto_report", 1);
                    com_ss_ttvideoengine_log_AppLogEngineUploader_java_lang_reflect_Method_invoke(onEventV3StaticMethod, null, new Object[]{str, jSONObject});
                } catch (Exception e) {
                    e.printStackTrace();
                    TTVideoEngineLog.e("AppLogEngineUploader", "upload error " + e);
                }
            }
            VideoEventManager.showEvent(jSONObject);
            Inspector.share().inspectEvent(str, jSONObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onEvent$0(String str, JSONObject jSONObject) {
        TTVideoEngineLog.i("AppLogEngineUploader", "onEvent event " + str);
        getMethod();
        if (getSessionIdStaticMethod != null && onMiscEventStaticMethod != null) {
            try {
                jSONObject.put("session_id", (String) com_ss_ttvideoengine_log_AppLogEngineUploader_java_lang_reflect_Method_invoke(getSessionIdStaticMethod, null, new Object[0]));
                jSONObject.put("auto_report", 1);
                if (1 == isApplogOrBDTracker.get()) {
                    com_ss_ttvideoengine_log_AppLogEngineUploader_java_lang_reflect_Method_invoke(onMiscEventStaticMethod, null, new Object[]{this.mContext, str, jSONObject});
                } else if (2 == isApplogOrBDTracker.get()) {
                    com_ss_ttvideoengine_log_AppLogEngineUploader_java_lang_reflect_Method_invoke(onMiscEventStaticMethod, null, new Object[]{str, jSONObject});
                }
            } catch (Exception e) {
                TTVideoEngineLog.e("AppLogEngineUploader", "upload error " + e.toString());
            }
        }
        VideoEventManager.showEvent(jSONObject);
        Inspector.share().inspectEvent(str, jSONObject);
    }

    @Insert("onEvent")
    @ImplementedInterface(scope = Scope.LEAF, value = {"com.ss.ttvideoengine.log.VideoEventEngineUploader"})
    public static void com_ss_ttvideoengine_log_AppLogEngineUploader_com_dragon_read_aop_NetworkTrafficAop_onEvent(AppLogEngineUploader appLogEngineUploader, String str, JSONObject jSONObject) {
        appLogEngineUploader.AppLogEngineUploader__onEvent$___twin___(str, jSONObject);
        if (!u55.k.o() || jSONObject == null) {
            return;
        }
        u55.q.d(str, jSONObject);
    }
}
