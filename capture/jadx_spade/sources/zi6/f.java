package zi6;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.LinkAddress;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.os.BatteryManager;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.content.ContextCompat;
import com.bytedance.covode.number.Covode;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.dragon.read.base.util.LogWrapper;
import com.ss.android.ugc.bytex.taskmonitor.proxy.HandlerDelegate;
import com.ss.videoarch.strategy.LiveStrategyManager;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import java.lang.ref.WeakReference;
import java.net.Inet6Address;
import java.net.URLEncoder;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.Skip;
import me.ele.lancet.base.annotations.TargetClass;
import org.json.JSONException;
import org.json.JSONObject;
import zi6.e;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class f {
    private static zi6.a x;
    private static Context y;
    private String m;
    private i r;
    private final Object a = new Object();
    private zi6.e b = null;
    private long c = 5000;
    private long d = 1500;
    private int e = 10;
    private int f = 0;
    private zi6.d g = new zi6.d();
    private String h = null;
    private zi6.b i = null;
    private Handler j = null;
    private HandlerThread k = null;
    private int l = -1;
    private long n = 0;
    private int o = 0;
    private int p = 0;
    private int q = 1;
    private final BroadcastReceiver s = new a();
    private final e.a t = new b();
    private final e.c u = new c();
    private final e.InterfaceC0303e v = new d();
    private final e.d w = new e();

    /* renamed from: zi6.f$f, reason: collision with other inner class name */
    private static class C0304f {
        private static f a;

        static {
            Covode.recordClassIndex(652867);
            a = new f();
        }
    }

    public static f t() {
        return C0304f.a;
    }

    static {
        Covode.recordClassIndex(652866);
        x = null;
        y = null;
    }

    public boolean A() {
        synchronized (this.a) {
            zi6.e eVar = this.b;
            if (eVar == null) {
                return false;
            }
            return eVar.e();
        }
    }

    public class i {
        private long b = 0;
        private long c = 0;
        private long d = 0;
        private ConnectivityManager a = (ConnectivityManager) f.y.getSystemService("connectivity");

        static {
            Covode.recordClassIndex(652870);
        }

        private boolean l() {
            try {
                int i = Build.VERSION.SDK_INT;
                if (i < 24) {
                    Log.e("LiveIOWrapper", "Low sdk_version " + i);
                    return false;
                }
                if (this.a == null) {
                    Log.e("LiveIOWrapper", "ConnectivityManager is null");
                    return false;
                }
                return true;
            } catch (Throwable th) {
                Log.e("LiveIOWrapper", "exception when preCheck");
                th.printStackTrace();
                return false;
            }
        }

        public boolean j() {
            try {
                if (!l()) {
                    Log.e("LiveIOWrapper", "preCheck failed!");
                    return false;
                }
                try {
                    this.a.requestNetwork(new NetworkRequest.Builder().addTransportType(0).addCapability(12).build(), new a());
                    return true;
                } catch (Throwable th) {
                    th.printStackTrace();
                    return false;
                }
            } catch (Throwable th2) {
                Log.e("LiveIOWrapper", "exception when activeCellularOn");
                th2.printStackTrace();
                return false;
            }
        }

        public boolean k() {
            try {
                if (!l()) {
                    Log.e("LiveIOWrapper", "preCheck failed!");
                    return false;
                }
                try {
                    this.a.requestNetwork(new NetworkRequest.Builder().addTransportType(1).addCapability(12).build(), new b());
                    return true;
                } catch (Throwable th) {
                    th.printStackTrace();
                    return false;
                }
            } catch (Throwable th2) {
                Log.e("LiveIOWrapper", "exception when activeWifiOn");
                th2.printStackTrace();
                return false;
            }
        }

        class a extends ConnectivityManager.NetworkCallback {
            a() {
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onAvailable(Network network) {
                if (network == null) {
                    return;
                }
                try {
                    NetworkCapabilities networkCapabilities = i.this.a.getNetworkCapabilities(network);
                    if (networkCapabilities != null && networkCapabilities.hasTransport(0) && networkCapabilities.hasCapability(12)) {
                        i.this.b = network.getNetworkHandle();
                        i iVar = i.this;
                        iVar.m(iVar.b);
                        i.this.d |= 2;
                    }
                    i iVar2 = i.this;
                    iVar2.n(iVar2.d);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onLost(Network network) {
                if (network != null && i.this.a != null) {
                    try {
                        if (i.this.b != 0 && i.this.b == network.getNetworkHandle()) {
                            i.this.b = 0L;
                            i iVar = i.this;
                            iVar.m(iVar.b);
                            i.this.d &= -3;
                        }
                        i iVar2 = i.this;
                        iVar2.n(iVar2.d);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            }
        }

        class b extends ConnectivityManager.NetworkCallback {
            b() {
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onAvailable(Network network) {
                if (network == null) {
                    return;
                }
                NetworkCapabilities networkCapabilities = i.this.a.getNetworkCapabilities(network);
                if (networkCapabilities != null && networkCapabilities.hasTransport(1) && networkCapabilities.hasCapability(12)) {
                    i.this.c = network.getNetworkHandle();
                    i.this.d |= 1;
                }
                i iVar = i.this;
                iVar.n(iVar.d);
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onLost(Network network) {
                if (network != null && i.this.a != null) {
                    if (i.this.c != 0 && i.this.c == network.getNetworkHandle()) {
                        i.this.c = 0L;
                        i.this.d &= -2;
                    }
                    i iVar = i.this;
                    iVar.n(iVar.d);
                }
            }
        }

        public i() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void m(long j) {
            if (f.this.j != null) {
                Message message = new Message();
                message.what = 1028;
                message.obj = Long.valueOf(j);
                f.this.j.sendMessage(message);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void n(long j) {
            if (f.this.j != null) {
                Message message = new Message();
                message.what = 1029;
                message.obj = Long.valueOf(j);
                f.this.j.sendMessage(message);
            }
        }
    }

    public String r() {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) y.getSystemService("connectivity");
            for (LinkAddress linkAddress : connectivityManager.getLinkProperties(connectivityManager.getActiveNetwork()).getLinkAddresses()) {
                if ((linkAddress.getAddress() instanceof Inet6Address) && !linkAddress.getAddress().isLoopbackAddress() && !linkAddress.getAddress().isLinkLocalAddress()) {
                    Log.w("LiveIOWrapper", linkAddress.getAddress().toString());
                    return linkAddress.getAddress().toString();
                }
            }
            return "::";
        } catch (Throwable th) {
            th.printStackTrace();
            return "::";
        }
    }

    public int s() {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) y.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                return -1;
            }
            int type = activeNetworkInfo.getType();
            if (type != 0) {
                if (type != 1) {
                    return -1;
                }
                return 0;
            }
            int subtype = activeNetworkInfo.getSubtype();
            if (subtype != 20) {
                switch (subtype) {
                    case 1:
                    case 2:
                    case 4:
                    case 7:
                    case 11:
                        return 2;
                    case 3:
                    case 5:
                    case ConstantsAPI.COMMAND_LAUNCH_BY_WX /* 6 */:
                    case ConstantsAPI.COMMAND_JUMP_BIZ_WEBVIEW /* 8 */:
                    case 9:
                    case 10:
                    case ConstantsAPI.COMMAND_OPEN_WEBVIEW /* 12 */:
                    case 14:
                    case 15:
                        return 3;
                    case ConstantsAPI.COMMAND_OPEN_BUSI_LUCKY_MONEY /* 13 */:
                        return 1;
                    default:
                        return -1;
                }
            }
            return 4;
        } catch (Throwable th) {
            th.printStackTrace();
            return -1;
        }
    }

    public boolean z() {
        Looper looper;
        HandlerThread handlerThread;
        if (this.b.e()) {
            Log.w("LiveIOWrapper", "LiveIO is already running");
            return true;
        }
        try {
            JSONObject jSONObject = new JSONObject(this.h);
            JSONObject jSONObject2 = new JSONObject(jSONObject.optString("ttquic_engine_config", "{}"));
            if (jSONObject2.optInt("ttquic_use_lsengine", 0) == 1) {
                JSONObject jSONObject3 = new JSONObject(jSONObject2.optString("ttquic_lsengine_params", "{}"));
                jSONObject3.put("SCFGPath", this.m);
                jSONObject2.put("ttquic_lsengine_params", jSONObject3.toString());
                jSONObject.put("ttquic_engine_config", jSONObject2.toString());
                this.h = jSONObject.toString();
            }
            this.b.j(1000, this.h);
            this.b.m(2000, this.t);
            this.b.m(2001, this.u);
            this.b.m(2002, this.w);
            this.b.m(2003, this.v);
            if (this.o == 1 && (handlerThread = this.k) != null) {
                looper = handlerThread.getLooper();
            } else {
                looper = null;
            }
            if (this.b.p(looper) != 0) {
                Log.e("LiveIOWrapper", "start LiveIO fail");
                return false;
            }
            int s = s();
            if (this.q == 1) {
                i iVar = new i();
                this.r = iVar;
                iVar.j();
                this.r.k();
            }
            Log.w("LiveIOWrapper", "initial networkType: " + s);
            this.b.l(1005, s);
            LiveStrategyManager.inst().setIFunctionCalledByStrategyEngine(new g());
            return true;
        } catch (JSONException unused) {
            Log.e("LiveIOWrapper", "not valid json for init LiveIO");
            return false;
        }
    }

    private class j implements Runnable {
        private final WeakReference<f> a;

        static {
            Covode.recordClassIndex(652871);
        }

        @Override // java.lang.Runnable
        public void run() {
            int i;
            int i2;
            int i3;
            f fVar = this.a.get();
            if (fVar != null && fVar.A()) {
                JSONObject jSONObject = new JSONObject();
                try {
                    Runtime runtime = Runtime.getRuntime();
                    ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                    ActivityManager activityManager = (ActivityManager) f.y.getSystemService("activity");
                    if (activityManager != null) {
                        activityManager.getMemoryInfo(memoryInfo);
                    }
                    Intent b = b(f.y, null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
                    int i4 = 0;
                    if (b != null) {
                        i = b.getIntExtra("temperature", 0) / 10;
                    } else {
                        i = 0;
                    }
                    BatteryManager batteryManager = (BatteryManager) f.y.getSystemService("batterymanager");
                    if (batteryManager != null) {
                        i3 = batteryManager.getIntProperty(4);
                        i2 = batteryManager.getIntProperty(6);
                    } else {
                        i2 = 0;
                        i3 = 0;
                    }
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("battery_percentage", i3);
                    jSONObject2.put("battery_temperature", i);
                    jSONObject2.put("battery_status", i2);
                    jSONObject.put("DEVICE-Battery", jSONObject2);
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("sys_total_mem", memoryInfo.totalMem);
                    jSONObject3.put("sys_avail_mem", memoryInfo.availMem);
                    if (memoryInfo.lowMemory) {
                        i4 = 1;
                    }
                    jSONObject3.put("sys_low_mem_flag", i4);
                    jSONObject3.put("app_max_mem", runtime.maxMemory());
                    jSONObject3.put("app_total_mem", runtime.totalMemory());
                    jSONObject3.put("app_free_mem", runtime.freeMemory());
                    jSONObject.put("DEVICE-Memory", jSONObject3);
                } catch (Exception e) {
                    Log.w("LiveIOWrapper", "LiveIO generate sys info json failed " + e.toString());
                }
                if (jSONObject.length() != 0) {
                    fVar.b.o(1136, jSONObject.toString());
                }
                fVar.j.postDelayed(f.this.new j(fVar), fVar.n);
                return;
            }
            Log.w("LiveIOWrapper", "LiveIO SysInfoSyncRunner stop running");
        }

        public j(f fVar) {
            this.a = new WeakReference<>(fVar);
        }

        @Proxy("registerReceiver")
        @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
        @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator"})
        public static Intent a(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
            if (ReceiverRegisterCrashOptimizer.fixedOpen()) {
                ReceiverRegisterCrashOptimizer.doHWReceiverFix();
            }
            try {
                if (ReceiverRegisterCrashOptimizer.doRegisterHandler()) {
                    ReceiverRegisterLancet.initHandler();
                    return context.registerReceiver(broadcastReceiver, intentFilter, null, ReceiverRegisterLancet.sReceiverHandler);
                }
                return context.registerReceiver(broadcastReceiver, intentFilter);
            } catch (Exception e) {
                if (ReceiverRegisterCrashOptimizer.fixedOpen()) {
                    return ReceiverRegisterCrashOptimizer.registerReceiver(broadcastReceiver, intentFilter);
                }
                throw e;
            }
        }

        @Proxy("registerReceiver")
        @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
        public static Intent b(Context context, BroadcastReceiver broadcastReceiver, IntentFilter filter) {
            Intrinsics.checkNotNullParameter(filter, "filter");
            if (Build.VERSION.SDK_INT >= 34) {
                if (!(context instanceof Context)) {
                    context = null;
                }
                if (context == null) {
                    return null;
                }
                LogWrapper.error("BroadcastAop", "registerReceiver 要传flag参数啦！", new Object[0]);
                return ContextCompat.registerReceiver(context, broadcastReceiver, filter, 2);
            }
            return a(context, broadcastReceiver, filter);
        }
    }

    public void G(zi6.a aVar) {
        x = aVar;
    }

    class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (isInitialStickyBroadcast() || !"android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                return;
            }
            try {
                if (f.this.j != null) {
                    Message message = new Message();
                    message.what = 1026;
                    message.obj = context;
                    f.this.j.sendMessage(message);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    class b implements e.a {
        b() {
        }
    }

    class c implements e.c {
        c() {
        }
    }

    class d implements e.InterfaceC0303e {
        d() {
        }
    }

    class e implements e.d {
        e() {
        }

        @Override // zi6.e.d
        public JSONObject a(int i, JSONObject jSONObject) {
            return LiveStrategyManager.inst().executeCommand(2, i, 0, jSONObject);
        }
    }

    static /* synthetic */ int l(f fVar) {
        int i2 = fVar.f;
        fVar.f = i2 + 1;
        return i2;
    }

    public long v(int i2) {
        if (A()) {
            return this.b.a(i2);
        }
        return -1L;
    }

    public String x(int i2) {
        if (A()) {
            return this.b.c(i2);
        }
        return null;
    }

    public String u(String str) {
        String str2 = null;
        if (TextUtils.isEmpty(str)) {
            Log.e("LiveIOWrapper", "should not get live url with empty string");
            return null;
        }
        try {
            str2 = URLEncoder.encode(str, "UTF-8");
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return "live://127.0.0.1" + ("?u0=" + str2);
    }

    private class h extends HandlerDelegate {
        static {
            Covode.recordClassIndex(652869);
        }

        /* JADX WARN: Finally extract failed */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:32:0x0205  */
        /* JADX WARN: Removed duplicated region for block: B:47:0x02b8  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void handleMessage(android.os.Message r7) {
            /*
                Method dump skipped, instructions count: 762
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: zi6.f.h.handleMessage(android.os.Message):void");
        }

        public h(Looper looper) {
            super(looper);
        }

        @Proxy("registerReceiver")
        @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
        @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator"})
        public static Intent a(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
            if (ReceiverRegisterCrashOptimizer.fixedOpen()) {
                ReceiverRegisterCrashOptimizer.doHWReceiverFix();
            }
            try {
                if (ReceiverRegisterCrashOptimizer.doRegisterHandler()) {
                    ReceiverRegisterLancet.initHandler();
                    return context.registerReceiver(broadcastReceiver, intentFilter, null, ReceiverRegisterLancet.sReceiverHandler);
                }
                return context.registerReceiver(broadcastReceiver, intentFilter);
            } catch (Exception e) {
                if (ReceiverRegisterCrashOptimizer.fixedOpen()) {
                    return ReceiverRegisterCrashOptimizer.registerReceiver(broadcastReceiver, intentFilter);
                }
                throw e;
            }
        }

        @Proxy("registerReceiver")
        @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
        public static Intent b(Context context, BroadcastReceiver broadcastReceiver, IntentFilter filter) {
            Intrinsics.checkNotNullParameter(filter, "filter");
            if (Build.VERSION.SDK_INT >= 34) {
                if (!(context instanceof Context)) {
                    context = null;
                }
                if (context == null) {
                    return null;
                }
                LogWrapper.error("BroadcastAop", "registerReceiver 要传flag参数啦！", new Object[0]);
                return ContextCompat.registerReceiver(context, broadcastReceiver, filter, 2);
            }
            return a(context, broadcastReceiver, filter);
        }
    }

    public void B(String str, String str2) {
        if (A()) {
            this.b.f(str, str2);
        }
    }

    public void C(String str, String str2) {
        if (A()) {
            this.b.g(str, str2);
        }
    }

    public void D(String str, String str2) {
        if (A()) {
            this.b.h(str, str2);
        }
    }

    public void E(String str, String str2) {
        if (A()) {
            this.b.i(str, str2);
        }
    }

    public void I(int i2, String str) {
        if (A()) {
            this.b.o(i2, str);
        }
    }

    public void K(String str, String str2) {
        if (A()) {
            this.b.q(str, str2);
        }
    }

    public long w(String str, int i2) {
        if (A()) {
            return this.b.b(str, i2);
        }
        return -1L;
    }

    public String y(String str, int i2) {
        if (A()) {
            return this.b.d(str, i2);
        }
        return null;
    }

    public static class g implements com.ss.videoarch.strategy.a {
        static {
            Covode.recordClassIndex(652868);
        }

        @Override // com.ss.videoarch.strategy.a
        public <T> T a(int i, T t) {
            if (t == null) {
                return null;
            }
            if (!f.t().A()) {
                Log.w("LiveIOWrapper", "LiveIO is not running");
                return null;
            }
            if (i == 1) {
                try {
                    JSONObject jSONObject = new JSONObject(String.valueOf(t));
                    String optString = jSONObject.optString("url_info");
                    String optString2 = jSONObject.optString("preconn_params");
                    if (optString != null) {
                        f.t().D(optString, optString2);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }

    public void H(zi6.b bVar, zi6.c cVar) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (cVar != null) {
            jSONObject.put("app_info", "{\"device_id\":\"" + cVar.b + "\",\"app_id\":" + cVar.c + ",\"device_score\":" + cVar.d + "}");
            jSONObject.put("cache_dir", cVar.a);
        }
        if (bVar != null) {
            this.i = bVar;
            jSONObject.put("commom_container_conf", bVar.getSettingsValueForKey("commom_container_conf", "{}"));
            jSONObject.put("http_container_conf", bVar.getSettingsValueForKey("http_container_conf", "{}"));
            jSONObject.put("connect_pool_container_conf", bVar.getSettingsValueForKey("connect_pool_container_conf", "{}"));
            jSONObject.put("pcdn_container_conf", bVar.getSettingsValueForKey("pcdn_container_conf", "{}"));
            jSONObject.put("preconnect_container_conf", bVar.getSettingsValueForKey("preconnect_container_conf", "{}"));
            jSONObject.put("ttquic_engine_config", bVar.getSettingsValueForKey("ttquic_engine_config", "{}"));
            jSONObject.put("liveio_use_least_thread", bVar.getSettingsValueForKey("liveio_use_least_thread", 0));
            String str = (String) bVar.getSettingsValueForKey("io_lib_name", "avio");
            if (!str.endsWith(".so")) {
                str = String.format("lib%s.so", str);
            }
            jSONObject.put("io_lib_name", str);
        }
        this.h = jSONObject.toString();
        Log.w("LiveIOWrapper", "LiveIO settings: " + this.h);
    }

    public void F(int i2, String str, long j2) {
        if (A()) {
            this.b.k(i2, str, j2);
        }
    }

    public void J(Context context, zi6.b bVar, zi6.c cVar) throws JSONException {
        if (context != null && bVar != null) {
            Log.w("LiveIOWrapper", "start liveio");
            y = context;
            this.c = ((Integer) bVar.getSettingsValueForKey("liveio_load_so_interval", 5000)).intValue();
            Log.w("LiveIOWrapper", "load so interval: " + this.c);
            this.e = ((Integer) bVar.getSettingsValueForKey("liveio_load_so_maxcount", 10)).intValue();
            Log.w("LiveIOWrapper", "load so max count: " + this.e);
            this.n = (long) ((Integer) bVar.getSettingsValueForKey("liveio_get_sysinfo_interval", 0)).intValue();
            Log.w("LiveIOWrapper", "get sys info interval: " + this.n);
            this.o = ((Integer) bVar.getSettingsValueForKey("liveio_use_least_thread", 0)).intValue();
            Log.w("LiveIOWrapper", "liveio use least thread: " + this.o);
            this.p = ((Integer) bVar.getSettingsValueForKey("check_before_load_quic_so", 0)).intValue();
            Log.w("LiveIOWrapper", "check before load quic so: " + this.p);
            this.q = ((Integer) bVar.getSettingsValueForKey("liveio_network_monitor", 1)).intValue();
            Log.w("LiveIOWrapper", "liveio network monitor: " + this.q);
            H(bVar, cVar);
            if (this.k == null) {
                HandlerThread handlerThread = new HandlerThread("startliveio");
                this.k = handlerThread;
                handlerThread.start();
            }
            if (this.j == null) {
                HandlerDelegate hVar = new h(this.k.getLooper());
                this.j = hVar;
                hVar.sendEmptyMessage(1025);
            }
        }
    }
}
