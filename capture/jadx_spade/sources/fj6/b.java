package fj6;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.bytedance.applog.AppLog;
import com.bytedance.applog.IAppLogInstance;
import com.bytedance.applog.InitConfig;
import com.bytedance.bdinstall.ILogger;
import com.bytedance.bdinstall.INetworkClient;
import com.bytedance.bdinstall.RangersHttpException;
import com.bytedance.bdinstall.i;
import com.bytedance.common.utility.CommonHttpException;
import com.bytedance.common.utility.NetworkClient;
import com.bytedance.covode.number.Covode;
import com.ss.android.common.lib.AppLogNewUtils;
import com.ss.videoarch.liveplayer.ILiveListener;
import com.ss.videoarch.liveplayer.VideoLiveManager;
import com.ss.videoarch.liveplayer.u;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class b {
    private static IAppLogInstance u;
    private com.ss.videoarch.liveplayer.b a;
    private HashMap<String, Object> b;
    public ExecutorService c;
    public ILiveListener d;
    public VideoLiveManager f;
    private u e = null;
    public int g = 0;
    public int h = 0;
    public int i = 0;
    public int j = 9099990;
    private int k = 0;
    private int l = 0;
    public int m = 0;
    public int n = 0;
    public int o = 0;
    private long p = 0;
    int q = -1;
    int r = 0;
    int s = 1;
    int t = 2;

    static {
        Covode.recordClassIndex(653039);
    }

    private void g() {
    }

    class a implements Runnable {
        final /* synthetic */ JSONObject a;
        final /* synthetic */ String b;

        @Override // java.lang.Runnable
        public void run() {
            b.this.j(this.a, this.b);
        }

        a(JSONObject jSONObject, String str) {
            this.a = jSONObject;
            this.b = str;
        }
    }

    public void k() {
        this.c = null;
        this.a = null;
        this.b = null;
        this.d = null;
        this.g = 0;
        this.h = 0;
        this.k = 0;
        this.i = 0;
        this.n = 0;
    }

    public b() {
        g();
    }

    private void p() {
        com.ss.videoarch.liveplayer.b bVar = this.a;
        if (bVar != null) {
            HashMap<String, Object> appInfo = bVar.getAppInfo();
            this.b = appInfo;
            if (appInfo.containsKey("live_base_new")) {
                Object obj = this.b.get("live_base_new");
                new HashMap();
                if (obj instanceof Map) {
                    Map map = (Map) obj;
                    if (map.containsKey("resolution_ui_name")) {
                        this.b.put("resolution_ui_name", map.get("resolution_ui_name"));
                    }
                    if (map.containsKey("cpu_rate")) {
                        this.b.put("app_cpu_used_rate", map.get("cpu_rate"));
                    }
                    if (map.containsKey("gpu_usage")) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add((Float) map.get("gpu_usage"));
                        if (arrayList.size() > 0) {
                            this.b.put("app_gpu_used_rate", arrayList);
                        }
                    }
                    if (map.containsKey("mem_pss_total")) {
                        this.b.put("app_mem_used_mb", map.get("mem_pss_total"));
                    }
                    if (map.containsKey("battery_state_android")) {
                        int intValue = ((Integer) map.get("battery_state_android")).intValue();
                        if (intValue == 1) {
                            this.b.put("battery_state", Integer.valueOf(this.q));
                        }
                        if (intValue == 2) {
                            this.b.put("battery_state", Integer.valueOf(this.r));
                        }
                        if (intValue == 4) {
                            this.b.put("battery_state", Integer.valueOf(this.s));
                        }
                        if (intValue == 5) {
                            this.b.put("battery_state", Integer.valueOf(this.t));
                        }
                    }
                    if (map.containsKey("battery_level")) {
                        this.b.put("battery_level", map.get("battery_level"));
                    }
                    if (map.containsKey("temperature_android")) {
                        this.b.put("temperature", map.get("temperature_android"));
                        return;
                    }
                    return;
                }
                com.ss.videoarch.liveplayer.log.a.c("LiveApplog", "live_base_new is not map");
            }
        }
    }

    /* renamed from: fj6.b$b, reason: collision with other inner class name */
    private class C0154b implements INetworkClient {
        static {
            Covode.recordClassIndex(653040);
        }

        private C0154b() {
        }

        /* synthetic */ C0154b(b bVar, a aVar) {
            this();
        }

        public String post(String str, List<Pair<String, String>> list) throws RangersHttpException {
            try {
                return NetworkClient.getDefault().post(str, list);
            } catch (CommonHttpException e) {
                throw new RangersHttpException(e.getResponseCode(), e.getCause());
            }
        }

        public String get(String str, Map<String, String> map) throws RangersHttpException {
            try {
                return NetworkClient.getDefault().get(str, map, (NetworkClient.ReqContext) null);
            } catch (Exception e) {
                if (e instanceof CommonHttpException) {
                    CommonHttpException commonHttpException = e;
                    throw new RangersHttpException(commonHttpException.getResponseCode(), commonHttpException.getCause());
                }
                throw new RangersHttpException(400, e.getCause());
            }
        }

        public byte[] postStream(String str, byte[] bArr, Map<String, String> map) throws RangersHttpException {
            try {
                return NetworkClient.getDefault().postDataStream(str, bArr, map, (NetworkClient.ReqContext) null);
            } catch (CommonHttpException e) {
                throw new RangersHttpException(e.getResponseCode(), e.getCause());
            }
        }

        public String post(String str, byte[] bArr, String str2) throws RangersHttpException {
            HashMap hashMap = new HashMap();
            if (!TextUtils.isEmpty(str2)) {
                hashMap.put("Content-Type", str2);
            }
            return post(str, bArr, hashMap);
        }

        public String post(String str, byte[] bArr, Map<String, String> map) throws RangersHttpException {
            try {
                return NetworkClient.getDefault().post(str, bArr, map, (NetworkClient.ReqContext) null);
            } catch (CommonHttpException e) {
                throw new RangersHttpException(e.getResponseCode(), e.getCause());
            }
        }
    }

    private class c implements ILogger {
        static {
            Covode.recordClassIndex(653041);
        }

        private c() {
        }

        private String a(String str) {
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
            return "null";
        }

        /* synthetic */ c(b bVar, a aVar) {
            this();
        }

        public void d(String str, Throwable th) {
            b.this.e.l(b.this.f, 3, a(str));
            com.ss.videoarch.liveplayer.log.a.a("applogsdk", a(str));
        }

        public void e(String str, Throwable th) {
            b.this.e.l(b.this.f, 6, a(str));
        }

        public void i(String str, Throwable th) {
            b.this.e.l(b.this.f, 4, a(str));
        }

        public void v(String str, Throwable th) {
            b.this.e.l(b.this.f, 2, str);
            com.ss.videoarch.liveplayer.log.a.c("applogsdk", str);
        }

        public void w(String str, Throwable th) {
            b.this.e.l(b.this.f, 5, a(str));
            Log.w("applogsdk", a(str));
        }
    }

    private String e(String str) {
        if (str.equals("live_webrtc_monitor_log")) {
            return "livesdk_live_client_applog_webrtc_monitor_log";
        }
        return "livesdk_live_client_applog_monitor_log";
    }

    public void m(int i) {
        this.k = i;
        com.ss.videoarch.liveplayer.log.a.c("LiveApplog", "set enableReportET: " + i);
    }

    public void n(u uVar) {
        this.e = uVar;
        com.ss.videoarch.liveplayer.log.a.c("LiveApplog", "setLogObserver, this: " + this);
    }

    public void o(int i) {
        this.l = i;
        com.ss.videoarch.liveplayer.log.a.c("LiveApplog", "set monitorEnabled: " + i);
    }

    private boolean d(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (this.i != 1 && !TextUtils.equals(str, "session_stop") && !TextUtils.equals(str, "play_stop")) {
            return false;
        }
        return true;
    }

    private HashMap<String, Object> f(String str) {
        if (this.b == null || TextUtils.equals(str, "first_frame") || TextUtils.equals(str, "playing") || TextUtils.equals(str, "play_stop")) {
            p();
        }
        return this.b;
    }

    public void l(com.ss.videoarch.liveplayer.b bVar) {
        this.a = bVar;
        com.ss.videoarch.liveplayer.log.a.c("LiveApplog", "set IAppInfoFetcher: " + this.a + ", this: " + this);
    }

    public void h(Context context) {
        if (u != null) {
            return;
        }
        InitConfig initConfig = new InitConfig("1476", "Live-Player");
        initConfig.setAppName("Live-Player");
        a aVar = null;
        boolean z = true;
        if (this.m == 1) {
            initConfig.setLogEnable(true);
            c cVar = new c(this, aVar);
            initConfig.setLogger(cVar);
            i.o(cVar);
        }
        initConfig.setVersionCode(this.j);
        initConfig.setUpdateVersionCode(this.j);
        initConfig.setNetworkClient(new C0154b(this, aVar));
        initConfig.setAutoStart(true);
        IAppLogInstance newInstance = AppLog.newInstance();
        u = newInstance;
        newInstance.setEncryptAndCompress(true);
        u.setEnableEventPriority(true);
        u.init(context, initConfig);
        IAppLogInstance iAppLogInstance = u;
        if (this.k != 1) {
            z = false;
        }
        iAppLogInstance.setEventSenderEnable(z, "https://log.snssdk.com");
    }

    public void i(JSONObject jSONObject, String str) {
        try {
            ExecutorService executorService = this.c;
            if (executorService != null && !executorService.isShutdown()) {
                executorService.submit(new a(jSONObject, str));
            } else {
                j(jSONObject, str);
            }
        } catch (Throwable th) {
            com.ss.videoarch.liveplayer.log.a.b("LiveApplog", "onMonitorLog common params ex=" + th.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(JSONObject jSONObject, String str) {
        String optString;
        HashMap<String, Object> f;
        Integer num;
        if (jSONObject == null) {
            return;
        }
        try {
            optString = jSONObject.optString("event_key");
        } catch (Throwable th) {
            com.ss.videoarch.liveplayer.log.a.b("LiveApplog", "onMonitorLog common params ex=" + th.toString());
        }
        if (this.n == 1 && !d(optString)) {
            return;
        }
        if (!TextUtils.isEmpty(optString)) {
            if (this.o == 1) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.p >= 10000) {
                    f = f(optString);
                    this.p = currentTimeMillis;
                } else {
                    f = this.b;
                }
            } else {
                f = f(optString);
            }
        } else {
            f = f(str);
        }
        if (f != null) {
            for (Map.Entry<String, Object> entry : f.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
        }
        if (optString != null && (num = fj6.c.Kh.get(optString)) != null && (num.intValue() & this.g) == 0) {
            u uVar = this.e;
            if (uVar != null) {
                uVar.c(this.f, jSONObject, str);
            } else {
                ILiveListener iLiveListener = this.d;
                if (iLiveListener != null) {
                    iLiveListener.onMonitorLog(jSONObject, str);
                }
            }
        }
        if (this.h == 1 && this.i == 1) {
            String str2 = "none";
            int i = 1476;
            try {
                Class q = l3.a.q("com.ss.android.common.applog.AppLog");
                if (q != null) {
                    Method method = q.getMethod("getAppId", new Class[0]);
                    method.setAccessible(true);
                    Object invoke = method.invoke(null, new Object[0]);
                    if (invoke instanceof Integer) {
                        i = ((Integer) invoke).intValue();
                    }
                    Method method2 = q.getMethod("getUserId", new Class[0]);
                    method2.setAccessible(true);
                    Object invoke2 = method2.invoke(null, new Object[0]);
                    if (invoke2 instanceof String) {
                        str2 = (String) invoke2;
                    }
                }
            } catch (Throwable th2) {
                com.ss.videoarch.liveplayer.log.a.b("LiveApplog", "applog get aid error" + th2.toString());
            }
            try {
                if (u != null) {
                    jSONObject.put("live_applog_error", 0);
                } else {
                    jSONObject.put("live_applog_error", 1);
                }
                jSONObject.put("live_aid", i).put("live_uid", str2);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            IAppLogInstance iAppLogInstance = u;
            if (iAppLogInstance != null) {
                iAppLogInstance.onEventV3(e(str), jSONObject);
                return;
            } else {
                AppLogNewUtils.onEventV3(e(str), jSONObject);
                return;
            }
        }
        AppLogNewUtils.onEventV3(e(str), jSONObject);
    }
}
