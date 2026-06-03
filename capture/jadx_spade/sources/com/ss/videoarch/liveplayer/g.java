package com.ss.videoarch.liveplayer;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.covode.number.Covode;
import com.ss.android.ugc.bytex.taskmonitor.proxy.HandlerDelegate;
import com.ss.videoarch.liveplayer.h;
import com.ss.videoarch.liveplayer.model.LiveStreamInfo;
import com.ss.videoarch.strategy.LiveStrategyManager;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import java.net.InetAddress;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class g implements h.a {
    private HandlerThread B;
    private c C;
    private HandlerThread E;
    private Handler F;
    private e I;
    private final Context a;
    private final VideoLiveManager b;
    private final int d;
    private final fj6.c e;
    private String f;
    private String g;
    private final d w;
    private final f x;
    private int h = 0;
    private int i = 3;
    private int j = 1000;
    private int k = 100;
    private int l = 5000;
    private int m = 0;
    private int n = 0;
    private int o = 3;
    private int p = -1;
    private String q = "";
    private String r = "";
    private int s = 1;
    private int t = 1;
    private int u = 1;
    private int v = 1;
    private volatile boolean y = false;
    private boolean z = false;
    private final Object A = new Object();
    private final Object D = new Object();
    private final RunnableC0098g G = new RunnableC0098g();
    private boolean H = false;
    private int J = -999;
    private final AtomicBoolean K = new AtomicBoolean(false);
    public int L = 0;
    public int M = 0;
    public int N = 0;
    public int O = 0;
    private int P = 0;
    private final Object Q = new Object();
    private ArrayList<b> R = new ArrayList<>();
    private final h c = new h(this);

    static {
        Covode.recordClassIndex(652926);
    }

    private void e0() {
    }

    public class c extends HandlerDelegate {
        static {
            Covode.recordClassIndex(652928);
        }

        private void b() {
            g.this.H = false;
        }

        private void d() {
            g.this.H = false;
        }

        private void e() {
            if (g.this.w.e() > 0) {
                g.this.w.d();
            }
            g.this.H = false;
            g.e(g.this);
            com.ss.videoarch.liveplayer.log.a.a("tt_preload", "preload fail : " + g.this.O);
        }

        private void g() {
            if (!g.this.H) {
                return;
            }
            if (g.this.I != null && !TextUtils.isEmpty(g.this.I.a)) {
                int c = g.this.c.c(g.this.d, g.this.I.a);
                if (c != 0) {
                    com.ss.videoarch.liveplayer.log.a.f("tt_preload", "preload cancel : " + c);
                }
                g.this.H = false;
                return;
            }
            com.ss.videoarch.liveplayer.log.a.f("tt_preload", "stopping task while mpd updating");
        }

        private void h() {
            if (g.this.w.e() > 0) {
                g.this.w.d();
            }
            g.this.H = false;
            g.i(g.this);
            com.ss.videoarch.liveplayer.log.a.a("tt_preload", "preload success : " + g.this.N);
            g.H(g.this);
            com.ss.videoarch.liveplayer.log.a.a("tt_preload", "preload io success : " + g.this.P);
        }

        private void c() {
            b bVar;
            if (g.this.H) {
                return;
            }
            synchronized (g.this.Q) {
                bVar = null;
                if (g.this.R.size() > 0) {
                    b bVar2 = (b) g.this.R.get(0);
                    if (bVar2.a.longValue() > SystemClock.uptimeMillis()) {
                        com.ss.videoarch.liveplayer.log.a.f("tt_preload", "updating mpd failed, too early!");
                    } else {
                        g.this.R.remove(0);
                        bVar = bVar2;
                    }
                }
            }
            if (bVar != null) {
                Bundle bundle = bVar.b;
                if (bundle == null) {
                    com.ss.videoarch.liveplayer.log.a.f("tt_preload", "updating mpd failed, bundle is null!");
                    return;
                }
                int i = bundle.getInt("mpd_update_count", 0) + 1;
                String string = bundle.getString("url");
                String string2 = bundle.getString("sdkParams");
                if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
                    bundle.putInt("mpd_updating", 1);
                    bundle.putInt("mpd_update_count", i);
                    g.this.H = true;
                    int k = g.this.c.k(g.this.d, string, string2, bundle);
                    com.ss.videoarch.liveplayer.log.a.a("tt_preload", "invoke mpd updating preload : " + k + " count: " + i);
                    if (k == 0) {
                        return;
                    }
                    g.this.H = false;
                    com.ss.videoarch.liveplayer.log.a.f("tt_preload", "mpd updating preload failed, error: " + k);
                    return;
                }
                com.ss.videoarch.liveplayer.log.a.f("tt_preload", "updating mpd failed, url: " + string + " sdkParams: " + string2);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:51:0x010f A[Catch: Exception -> 0x013e, TryCatch #0 {Exception -> 0x013e, blocks: (B:36:0x00b4, B:39:0x00c4, B:40:0x00c8, B:42:0x00ce, B:43:0x00d2, B:45:0x00f3, B:48:0x00fe, B:49:0x0109, B:51:0x010f, B:52:0x0129, B:53:0x0103), top: B:35:0x00b4 }] */
        /* JADX WARN: Removed duplicated region for block: B:52:0x0129 A[Catch: Exception -> 0x013e, TRY_LEAVE, TryCatch #0 {Exception -> 0x013e, blocks: (B:36:0x00b4, B:39:0x00c4, B:40:0x00c8, B:42:0x00ce, B:43:0x00d2, B:45:0x00f3, B:48:0x00fe, B:49:0x0109, B:51:0x010f, B:52:0x0129, B:53:0x0103), top: B:35:0x00b4 }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private void f() {
            /*
                Method dump skipped, instructions count: 502
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ss.videoarch.liveplayer.g.c.f():void");
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    f();
                    break;
                case 1:
                    g();
                    break;
                case 2:
                    h();
                    break;
                case 3:
                    e();
                    break;
                case 4:
                    c();
                    break;
                case 5:
                    d();
                    break;
                case ConstantsAPI.COMMAND_LAUNCH_BY_WX /* 6 */:
                    b();
                    break;
            }
        }

        c(Looper looper) {
            super(looper);
        }
    }

    public int R() {
        return this.c.g();
    }

    public int U() {
        return this.w.e();
    }

    private static class d {
        private final Object a;
        private final ArrayList<e> b;

        static {
            Covode.recordClassIndex(652929);
        }

        public void a() {
            synchronized (this.a) {
                this.b.clear();
            }
        }

        public int e() {
            int size;
            synchronized (this.a) {
                size = this.b.size();
            }
            return size;
        }

        private d() {
            this.a = new Object();
            this.b = new ArrayList<>();
        }

        public e c() {
            e eVar;
            synchronized (this.a) {
                if (this.b.size() > 0) {
                    eVar = this.b.get(0);
                } else {
                    eVar = null;
                }
            }
            return eVar;
        }

        public e d() {
            e eVar;
            synchronized (this.a) {
                if (this.b.size() > 0) {
                    eVar = this.b.remove(0);
                } else {
                    eVar = null;
                }
            }
            return eVar;
        }

        public void b(e eVar) {
            synchronized (this.a) {
                this.b.add(eVar);
            }
        }
    }

    private static class f {
        private final Object a;
        private final LinkedList<Integer> b;

        static {
            Covode.recordClassIndex(652931);
        }

        public void a() {
            synchronized (this.a) {
                this.b.clear();
            }
        }

        public Integer c() {
            Integer peekLast;
            synchronized (this.a) {
                peekLast = this.b.peekLast();
            }
            return peekLast;
        }

        public Integer d() {
            Integer pollFirst;
            synchronized (this.a) {
                pollFirst = this.b.pollFirst();
            }
            return pollFirst;
        }

        public int e() {
            int size;
            synchronized (this.a) {
                size = this.b.size();
            }
            return size;
        }

        private f() {
            this.a = new Object();
            this.b = new LinkedList<>();
        }

        public boolean b(int i) {
            boolean offer;
            synchronized (this.a) {
                offer = this.b.offer(Integer.valueOf(i));
            }
            return offer;
        }
    }

    private void g0() {
        Handler handler = this.F;
        if (handler != null) {
            handler.post(this.G);
        }
    }

    private void h0() {
        synchronized (this.A) {
            HandlerDelegate handlerDelegate = this.C;
            if (handlerDelegate != null) {
                handlerDelegate.removeCallbacksAndMessages(null);
            }
        }
    }

    private void j0() {
        synchronized (this.D) {
            Handler handler = this.F;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
        }
    }

    public void M() {
        Log.d("tt_preload", "invoke PreloadHelper cancelAll");
        this.c.d();
    }

    /* renamed from: com.ss.videoarch.liveplayer.g$g, reason: collision with other inner class name */
    public class RunnableC0098g implements Runnable {
        private long a = -1;

        static {
            Covode.recordClassIndex(652932);
        }

        private void b() {
            if (g.this.C != null) {
                g.this.C.sendEmptyMessage(0);
            }
        }

        private void c() {
            if (g.this.C != null) {
                g.this.C.sendEmptyMessage(1);
            }
        }

        private void d() {
            if (g.this.C == null) {
                return;
            }
            synchronized (g.this.Q) {
                if (g.this.R.size() > 0) {
                    if (SystemClock.uptimeMillis() >= ((b) g.this.R.get(0)).a.longValue()) {
                        g.this.C.sendEmptyMessage(4);
                    }
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (g.this.D) {
                long uptimeMillis = SystemClock.uptimeMillis();
                if (g.this.K.get()) {
                    g.this.x.a();
                    g.this.K.set(false);
                }
                d();
                long j = this.a;
                if (j == -1 || uptimeMillis - j > g.this.j) {
                    this.a = uptimeMillis;
                    if (a()) {
                        b();
                    } else {
                        c();
                    }
                }
                if (g.this.F != null) {
                    g.this.F.postAtTime(this, uptimeMillis + g.this.k);
                }
            }
        }

        private boolean a() {
            boolean z = false;
            try {
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (g.this.t == 0 && !g.this.b.haveFirstLiveFrame()) {
                return false;
            }
            if (g.this.u == 0) {
                if (!g.this.q.contains(g.this.b.getNetType())) {
                    return false;
                }
            }
            if (g.this.v == 0) {
                if (!g.this.r.contains(g.this.b.getNetConnectType())) {
                    return false;
                }
            }
            if (g.this.l <= 0) {
                return true;
            }
            int bufferingStallCount = g.this.b.getBufferingStallCount();
            long videoBufferLength = g.this.b.getVideoBufferLength();
            long audioBufferLength = g.this.b.getAudioBufferLength();
            if (g.this.x.e() < g.this.l / g.this.j) {
                g.this.x.b(bufferingStallCount);
                return false;
            }
            if (bufferingStallCount < g.this.x.c().intValue()) {
                g.this.x.a();
                return false;
            }
            int intValue = g.this.x.d().intValue();
            g.this.x.b(bufferingStallCount);
            int i = bufferingStallCount - intValue;
            if (i != 0 ? !(g.this.o <= i || videoBufferLength < g.this.n || audioBufferLength < g.this.n) : !(videoBufferLength < g.this.m || audioBufferLength < g.this.m)) {
                z = true;
            }
            if (!z) {
                g.this.x.a();
            }
            return z;
        }

        public RunnableC0098g() {
        }
    }

    public void P() {
        com.ss.videoarch.liveplayer.log.a.a("tt_preload", "PreloadHelper destroy");
        synchronized (this.A) {
            HandlerDelegate handlerDelegate = this.C;
            if (handlerDelegate != null) {
                handlerDelegate.removeCallbacksAndMessages(null);
                this.C = null;
            }
            HandlerThread handlerThread = this.B;
            if (handlerThread != null) {
                handlerThread.quit();
                this.B = null;
            }
        }
        synchronized (this.D) {
            Handler handler = this.F;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
                this.F = null;
            }
            HandlerThread handlerThread2 = this.E;
            if (handlerThread2 != null) {
                handlerThread2.quit();
                this.E = null;
            }
        }
    }

    static class e {
        String a;
        String b;
        String c;
        String d;
        String e;
        String f;
        int g;
        int h;

        static {
            Covode.recordClassIndex(652930);
        }

        e() {
        }

        public String toString() {
            return "PreloadParam{url='" + this.a + "', format='" + this.b + "', protocol='" + this.c + "', resolution='" + this.f + "', enableProbeStartupBitrate='" + this.g + "', probeStartupBitrate='" + this.h + "'}";
        }
    }

    public void f0() {
        if (!this.z) {
            com.ss.videoarch.liveplayer.log.a.f("tt_preload", "[playerID : " + this.d + "] startPreload: PreloadHelper initialize error: " + this.J);
            return;
        }
        if (this.y) {
            com.ss.videoarch.liveplayer.log.a.f("tt_preload", "[playerID : " + this.d + "] startPreload: PreloadHelper have running");
            return;
        }
        com.ss.videoarch.liveplayer.log.a.a("tt_preload", "[playerID : " + this.d + "] startPreload");
        this.c.a(this.d);
        e0();
        g0();
        this.y = true;
    }

    public void i0() {
        if (!this.z) {
            com.ss.videoarch.liveplayer.log.a.f("tt_preload", "[playerID : " + this.d + "] stopPreload: PreloadHelper initialize error: " + this.J);
            return;
        }
        if (!this.y) {
            com.ss.videoarch.liveplayer.log.a.f("tt_preload", "[playerID : " + this.d + "] stopPreload: PreloadHelper no running");
            return;
        }
        com.ss.videoarch.liveplayer.log.a.a("tt_preload", "[playerID : " + this.d + "] stopPreload");
        this.c.m(this.d);
        this.C.sendEmptyMessage(1);
        j0();
        h0();
        synchronized (this.Q) {
            this.R.clear();
        }
        this.w.a();
        this.x.a();
        this.L = 0;
        this.M = 0;
        this.N = 0;
        this.O = 0;
        this.P = 0;
        this.H = false;
        this.y = false;
    }

    static /* synthetic */ int H(g gVar) {
        int i = gVar.P;
        gVar.P = i + 1;
        return i;
    }

    static /* synthetic */ int e(g gVar) {
        int i = gVar.O;
        gVar.O = i + 1;
        return i;
    }

    static /* synthetic */ int i(g gVar) {
        int i = gVar.N;
        gVar.N = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String X(String str) {
        try {
            return InetAddress.getByName(str).getHostAddress();
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public void L(int i) {
        Log.d("tt_preload", "invoke attachPlayer : " + i);
        this.c.b(i);
    }

    public void Q(int i) {
        Log.d("tt_preload", "invoke detachPlayer : " + i);
        this.c.f(i);
    }

    private class b implements Comparable {
        Long a;
        Bundle b;
        int c;

        static {
            Covode.recordClassIndex(652927);
        }

        @Override // java.lang.Comparable
        public int compareTo(Object obj) {
            b bVar = (b) obj;
            if (this.a.longValue() > bVar.a.longValue()) {
                return 1;
            }
            if (this.a.longValue() < bVar.a.longValue()) {
                return -1;
            }
            return 0;
        }

        public b(Long l, Bundle bundle) {
            this.c = 0;
            this.a = l;
            this.b = bundle;
            if (bundle != null) {
                this.c = bundle.getInt("mpd_update_count", 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int O(e eVar) {
        if (TextUtils.isEmpty(eVar.a)) {
            com.ss.videoarch.liveplayer.log.a.f("tt_preload", "checkPreloadParam url is null");
            return -2001;
        }
        if (!TextUtils.equals("cmaf", eVar.b) && !TextUtils.equals("flv", eVar.b)) {
            com.ss.videoarch.liveplayer.log.a.f("tt_preload", "checkPreloadParam format is invalid : " + eVar.b);
            return -2002;
        }
        if (TextUtils.equals("cmaf", eVar.b) && !TextUtils.equals("h2", eVar.c) && !TextUtils.equals("h2q", eVar.c)) {
            com.ss.videoarch.liveplayer.log.a.f("tt_preload", "checkPreloadParam cmaf only support H2 or H2Q : " + eVar.c);
            return -2003;
        }
        return 0;
    }

    void d0(ArrayList<String> arrayList) {
        for (int i = 0; i < arrayList.size(); i++) {
            e eVar = new e();
            if (T(arrayList.get(i), eVar) == 0) {
                this.w.b(eVar);
                this.c.l(eVar.a);
                this.M++;
            }
        }
        this.L += arrayList.size();
        com.ss.videoarch.liveplayer.log.a.a("tt_preload", "[playerID : " + this.d + "] setPreloadResource : PreloadResourceTotal = " + this.L + "\tPreloadTaskTotal = " + this.M);
    }

    private Bundle Y(JSONObject jSONObject) {
        JSONArray jSONArray;
        Bundle bundle = new Bundle();
        if (jSONObject != null) {
            try {
                if (jSONObject.has("StrategyList")) {
                    jSONArray = jSONObject.optJSONArray("StrategyList");
                } else {
                    jSONArray = null;
                }
                if (jSONArray != null && jSONArray.length() > 0) {
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONObject jSONObject2 = (JSONObject) jSONArray.get(i);
                        if (jSONObject2 != null && jSONObject2.has("Name")) {
                            String optString = jSONObject2.optString("Name");
                            if (!TextUtils.isEmpty(optString)) {
                                bundle.putInt(optString, jSONObject2.optInt("Enable"));
                                if (jSONObject2.has("Time")) {
                                    bundle.putInt("smooth_switch_interval", jSONObject2.optInt("Time"));
                                }
                                if (jSONObject2.has("FallbackToPlayerAbr")) {
                                    bundle.putInt("enable_strategy_fallback", jSONObject2.optInt("FallbackToPlayerAbr"));
                                }
                                if (jSONObject2.has("Repeat")) {
                                    bundle.putInt("enable_repeat_strategy", jSONObject2.optInt("Repeat"));
                                }
                            }
                        }
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return bundle;
    }

    public void N(int i) {
        if (!this.z) {
            com.ss.videoarch.liveplayer.log.a.f("tt_preload", "[playerID : " + this.d + "] cancelPreload: PreloadHelper initialize error: " + this.J);
            return;
        }
        if (!this.y) {
            com.ss.videoarch.liveplayer.log.a.f("tt_preload", "[playerID : " + this.d + "] cancelPreload: PreloadHelper no running");
            return;
        }
        if (i == 0 && this.s == 1) {
            com.ss.videoarch.liveplayer.log.a.f("tt_preload", "[playerID : " + this.d + "] cancelPreload: don't need cancel because ignore stall");
            return;
        }
        com.ss.videoarch.liveplayer.log.a.a("tt_preload", "[playerID : " + this.d + "] cancelPreload");
        this.K.set(true);
        synchronized (this.A) {
            HandlerDelegate handlerDelegate = this.C;
            if (handlerDelegate != null) {
                handlerDelegate.sendEmptyMessage(1);
            }
        }
    }

    public int W(String str) {
        String str2;
        JSONObject jSONObject;
        com.ss.videoarch.liveplayer.log.a.a("tt_preload", "PreloadHelper init");
        this.J = 0;
        try {
            l3.a.q("com.ss.videoarch.live.ttquic.PreloadManager");
            str2 = "IgnoreStall";
        } catch (Exception e2) {
            StringBuilder sb = new StringBuilder();
            str2 = "IgnoreStall";
            sb.append("preload class load error : ");
            sb.append(e2);
            com.ss.videoarch.liveplayer.log.a.f("tt_preload", sb.toString());
            this.J = -100;
        }
        int i = this.J;
        if (i != 0) {
            return i;
        }
        try {
            jSONObject = new JSONObject(str);
        } catch (Exception e3) {
            e3.printStackTrace();
            this.J = -104;
        }
        if (jSONObject.has("Enable") && jSONObject.optInt("Enable") == 0) {
            com.ss.videoarch.liveplayer.log.a.f("tt_preload", "preload is disable");
            this.J = -101;
            return -101;
        }
        if (jSONObject.has("FastOpenDuration")) {
            this.p = jSONObject.optInt("FastOpenDuration", -1);
        }
        if (jSONObject.has("EngineConfig")) {
            this.f = jSONObject.optString("EngineConfig");
        }
        if (TextUtils.isEmpty(this.f)) {
            com.ss.videoarch.liveplayer.log.a.f("tt_preload", "EngineConfig is null");
            this.J = -102;
            return -102;
        }
        if (jSONObject.has("StrategyConfig")) {
            this.g = jSONObject.optString("StrategyConfig");
        }
        if (TextUtils.isEmpty(this.g)) {
            com.ss.videoarch.liveplayer.log.a.f("tt_preload", "StrategyConfig is null");
            this.J = -103;
            return -103;
        }
        JSONObject jSONObject2 = new JSONObject(this.g);
        if (jSONObject2.has("TmerInterval")) {
            this.j = jSONObject2.optInt("TmerInterval");
        }
        if (jSONObject2.has("StallWindowTimeMs")) {
            this.l = jSONObject2.optInt("StallWindowTimeMs");
        }
        if (jSONObject2.has("BufferNoStallThresholdMs")) {
            this.m = jSONObject2.optInt("BufferNoStallThresholdMs");
        }
        if (jSONObject2.has("BufferStallThresholdMs")) {
            this.n = jSONObject2.optInt("BufferStallThresholdMs");
        }
        if (jSONObject2.has("StallCountThreshold")) {
            this.o = jSONObject2.optInt("StallCountThreshold");
        }
        if (jSONObject2.has("NetType")) {
            this.q = jSONObject2.optString("NetType");
        }
        if (jSONObject2.has("NetConnectType")) {
            this.r = jSONObject2.optString("NetConnectType");
        }
        String str3 = str2;
        if (jSONObject2.has(str3)) {
            this.s = jSONObject2.optInt(str3);
        }
        if (jSONObject2.has("IgnoreFirstLiveFrame")) {
            this.t = jSONObject2.optInt("IgnoreFirstLiveFrame");
        }
        if (jSONObject2.has("IgnoreNetType")) {
            this.u = jSONObject2.optInt("IgnoreNetType");
        }
        if (jSONObject2.has("IgnoreNQE")) {
            this.v = jSONObject2.optInt("IgnoreNQE");
        }
        if (jSONObject2.has("PreloadTaskMaxNum")) {
            this.i = jSONObject2.optInt("PreloadTaskMaxNum");
        }
        if (jSONObject.has("EnableStrategyEngine")) {
            this.h = jSONObject.optInt("EnableStrategyEngine");
        }
        int i2 = this.J;
        if (i2 != 0) {
            return i2;
        }
        int i3 = this.c.i(this.a, this.f);
        this.J = i3;
        if (i3 != 0) {
            com.ss.videoarch.liveplayer.log.a.f("tt_preload", "Preload Manager init error : " + this.J);
            return this.J;
        }
        HandlerThread handlerThread = new HandlerThread("PRELOAD_EVENT");
        this.B = handlerThread;
        handlerThread.start();
        this.C = new c(this.B.getLooper());
        HandlerThread handlerThread2 = new HandlerThread("PRELOAD_TIMER");
        this.E = handlerThread2;
        handlerThread2.start();
        this.F = new HandlerDelegate(this.E.getLooper());
        this.z = true;
        this.J = 0;
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b0(int i, Bundle bundle) {
        fj6.c cVar = this.e;
        if (cVar != null) {
            cVar.O0(i, bundle);
        }
    }

    private String Z(String str, String str2) {
        String a0 = a0(str, str2);
        int i = this.p;
        if (i != -1) {
            return i.a(a0, "abr_pts", String.valueOf(i));
        }
        return a0;
    }

    public Bundle S(String str, int i) {
        if (!this.z) {
            return new Bundle();
        }
        return this.c.h(str, i);
    }

    @Override // com.ss.videoarch.liveplayer.h.a
    public void onPreloadEvent(int i, Bundle bundle) {
        if (bundle.getInt("mode", 0) == 1) {
            Bundle bundle2 = bundle.getBundle("ext_info");
            if (bundle2 != null) {
                int i2 = bundle2.getInt("mpd_updating", 0);
                int i3 = bundle2.getInt("mpd_update_int", 2000);
                c0(i, i2, bundle);
                if (i == 1) {
                    synchronized (this.Q) {
                        this.R.add(new b(Long.valueOf(SystemClock.uptimeMillis() + i3), bundle2));
                        Collections.sort(this.R);
                    }
                    return;
                }
                return;
            }
            return;
        }
        c0(i, 0, bundle);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private String a0(String str, String str2) {
        String str3;
        String str4;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            str2.hashCode();
            char c2 = 65535;
            switch (str2.hashCode()) {
                case 3274:
                    if (str2.equals("h2")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 101607:
                    if (str2.equals("h2q")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 114657:
                    if (str2.equals("tcp")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 114939:
                    if (str2.equals("tls")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 3482174:
                    if (str2.equals("quic")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case 107947511:
                    if (str2.equals("quicu")) {
                        c2 = 5;
                        break;
                    }
                    break;
            }
            int i = 80;
            switch (c2) {
                case 0:
                case 1:
                case 3:
                default:
                    str3 = "https";
                    i = 443;
                    break;
                case 2:
                    str3 = "http";
                    break;
                case 4:
                case 5:
                    str3 = "httpq";
                    break;
            }
            if (str.startsWith("httpx")) {
                str4 = str.replaceAll("httpx", "https");
            } else {
                str4 = str;
            }
            if (str.startsWith("httpq")) {
                str4 = str.replaceAll("httpq", "https");
            }
            try {
                URL url = new URL(str4);
                return str3 + "://" + url.getHost() + ":" + i + url.getPath();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return "";
    }

    private int T(String str, e eVar) {
        JSONObject optJSONObject;
        int i;
        try {
            com.ss.videoarch.liveplayer.model.a aVar = new com.ss.videoarch.liveplayer.model.a();
            com.ss.videoarch.liveplayer.model.b bVar = new com.ss.videoarch.liveplayer.model.b(new JSONObject(str));
            String str2 = bVar.b;
            LiveStreamInfo liveStreamInfo = bVar.c;
            aVar.T0(liveStreamInfo);
            eVar.e = str;
            eVar.d = liveStreamInfo.D(str2, "main").toString();
            if (TextUtils.equals(str2, "auto")) {
                JSONObject jSONObject = new JSONObject(eVar.d);
                if (jSONObject.has("StrategyInLss") && (optJSONObject = jSONObject.optJSONObject("StrategyInLss")) != null) {
                    int i2 = Y(optJSONObject).getInt("live_stream_strategy_startup_bitrate_predict", 0);
                    com.ss.videoarch.liveplayer.log.a.a("tt_preload", "live_stream_strategy_startup_bitrate_predict = " + i2);
                    if (i2 == 1) {
                        JSONObject V = V(aVar, "main", 21);
                        com.ss.videoarch.liveplayer.log.a.a("tt_preload", "probe startup bitrate result: " + V);
                        if (V != null) {
                            i = V.optInt("startup_probe_bitrate");
                        } else {
                            i = 0;
                        }
                        String u = aVar.u(i, "main", null);
                        if (!TextUtils.isEmpty(u) && aVar.E0(u)) {
                            aVar.I0(u);
                        }
                        eVar.g = 1;
                        eVar.h = i;
                    }
                }
                str2 = liveStreamInfo.d;
                com.ss.videoarch.liveplayer.log.a.a("tt_preload", "[resolution] auto -> " + str2);
            }
            eVar.f = str2;
            String d0 = aVar.d0(str2, "main");
            eVar.b = d0;
            if (TextUtils.isEmpty(d0)) {
                Log.d("tt_preload", "getPreloadParam SuggestFormat is empty, use default FLV");
                eVar.b = "flv";
            }
            String H = aVar.H(str2, eVar.b, "main");
            if (TextUtils.isEmpty(H)) {
                com.ss.videoarch.liveplayer.log.a.a("tt_preload", "getPreloadParam url is empty");
                return -2001;
            }
            String e0 = aVar.e0(str2, "main");
            eVar.c = e0;
            if (TextUtils.isEmpty(e0)) {
                if (H.startsWith("https")) {
                    eVar.c = "tls";
                } else if (H.startsWith("http")) {
                    eVar.c = "tcp";
                } else {
                    com.ss.videoarch.liveplayer.log.a.f("tt_preload", "getPreloadParam url scheme invalid");
                    return -2003;
                }
                com.ss.videoarch.liveplayer.log.a.a("tt_preload", "getPreloadParam SuggestProtocol is empty, use " + eVar.c);
            }
            String Z = Z(H, eVar.c);
            eVar.a = Z;
            if (!TextUtils.isEmpty(Z)) {
                return 0;
            }
            return -2001;
        } catch (Exception e2) {
            com.ss.videoarch.liveplayer.log.a.f("tt_preload", "streamData invalid : " + e2);
            return -2000;
        }
    }

    private JSONObject V(com.ss.videoarch.liveplayer.model.a aVar, String str, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            switch (i) {
                case ConstantsAPI.COMMAND_NON_TAX_PAY /* 21 */:
                case ConstantsAPI.COMMAND_PAY_INSURANCE /* 22 */:
                case ConstantsAPI.COMMAND_SUBSCRIBE_MINI_PROGRAM_MSG /* 23 */:
                    jSONObject2.put("PLAY-BitrateList", aVar.c(str, i, null));
                    jSONObject2.put("stream_session_vv_id", this.e.N6);
                    break;
            }
            return (JSONObject) LiveStrategyManager.inst().getConfigAndStrategyByKeyInt(0, i, null, jSONObject2);
        } catch (JSONException e2) {
            e2.printStackTrace();
            return jSONObject;
        }
    }

    private void c0(int i, int i2, Bundle bundle) {
        int i3;
        int i4;
        e eVar;
        if (i == 1 || i == 2) {
            synchronized (this.A) {
                HandlerDelegate handlerDelegate = this.C;
                if (handlerDelegate != null) {
                    if (i2 == 0) {
                        if (i == 1) {
                            i4 = 2;
                        } else {
                            i4 = 3;
                        }
                        handlerDelegate.sendEmptyMessage(i4);
                    } else {
                        if (i == 1) {
                            i3 = 5;
                        } else {
                            i3 = 6;
                        }
                        handlerDelegate.sendEmptyMessage(i3);
                    }
                }
            }
        }
        if (i2 == 0 && (eVar = this.I) != null) {
            bundle.putInt("enable_probe_startup_bitrate", eVar.g);
            bundle.putInt("probe_startup_bitrate", this.I.h);
            if (i == 1 || i == 2) {
                bundle.putString("pull_data", this.I.e);
            }
            b0(i, bundle);
        }
    }

    g(Context context, VideoLiveManager videoLiveManager, fj6.c cVar) {
        this.w = new d();
        this.x = new f();
        this.a = context.getApplicationContext();
        this.b = videoLiveManager;
        this.d = videoLiveManager.hashCode();
        this.e = cVar;
    }
}
