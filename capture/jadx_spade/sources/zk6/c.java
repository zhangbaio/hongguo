package zk6;

import al2.d;
import al2.i0;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.Args;
import com.dragon.read.component.audio.api.NsAudioModuleApi;
import com.dragon.read.component.biz.api.NsXrayApi;
import com.dragon.read.report.ReportManager;
import com.ss.ttvideoengine.Resolution;
import com.xs.fm.player.base.play.data.PlayEngineInfo;
import com.xs.fm.player.base.play.inter.IPlayManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import org.json.JSONObject;
import v03.g;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class c {
    private static final bl6.a a;
    private static String b;
    private static String c;
    private static ArrayList<Pair<a, Long>> d;
    private static HashMap<String, String> e;
    private static HashMap<String, Long> f;
    private static HashMap<String, Long> g;
    private static int h;
    private static HashMap<String, String> i;
    private static boolean j;
    private static ArrayList<String> k;
    public static final c l;

    private c() {
    }

    public static final synchronized void i(a aVar) {
        synchronized (c.class) {
            d(aVar);
        }
    }

    public static final synchronized void j(Integer num, String str, int i2, String str2) {
        synchronized (c.class) {
            g(num, str, i2, str2);
        }
    }

    public static final synchronized void u(String str) {
        synchronized (c.class) {
            h(str);
        }
    }

    public final String k() {
        return b;
    }

    public static final synchronized void o() {
        synchronized (c.class) {
            if (k.size() != 0) {
                k.add("StartPlayFailed");
            }
        }
    }

    private final void p() {
        a.d("reset monitor data!", new Object[0]);
        h = -1;
        e = null;
        f = null;
        b = "";
        d = null;
        g.clear();
    }

    static {
        Covode.recordClassIndex(655891);
        l = new c();
        a = new bl6.a("FMSDKPlayerTrace-PlayChainTraceMonitor");
        b = "";
        c = "";
        g = new HashMap<>();
        h = -1;
        k = new ArrayList<>();
    }

    @TargetClass("com.xs.fm.player.sdk.component.event.monior.PlayChainTraceMonitor")
    @Insert("startMonitor")
    public static void f(String str) {
        d.a.d("startMonitor()", new Object[0]);
        d.c = str;
        c(str);
    }

    @TargetClass("com.xs.fm.player.sdk.component.event.monior.PlayChainTraceMonitor")
    @Insert("endMonitor")
    public static void d(a aVar) {
        d.a.d("startMonitor()", new Object[0]);
        if (!TextUtils.isEmpty(d.c)) {
            Args args = new Args();
            args.put("accident_type", d.a(d.c));
            args.put("success", Boolean.TRUE);
            ReportManager.onReport("audio_accident_present_monitor", args);
            d.c = null;
        }
        a(aVar);
    }

    public static final synchronized void n(a aVar) {
        synchronized (c.class) {
            boolean z = false;
            a.d("monitor in middle stage with recentEvent, event = " + b + " and tagName = " + aVar, new Object[0]);
            if (b.length() == 0) {
                z = true;
            }
            if (z) {
                return;
            }
            l.m(b, aVar, 2);
        }
    }

    public static final synchronized void a(a aVar) {
        Resolution resolution;
        synchronized (c.class) {
            boolean z = false;
            a.d("endMonitor, event = " + b, new Object[0]);
            if (b.length() == 0) {
                z = true;
            }
            if (z) {
                return;
            }
            IPlayManager B = il6.a.B();
            Intrinsics.checkExpressionValueIsNotNull(B, "PlayManager.getInstance()");
            PlayEngineInfo currentPlayInfo = B.getCurrentPlayInfo();
            if (currentPlayInfo != null && (resolution = currentPlayInfo.resolution) != null) {
                t("resolution", resolution.toString());
            }
            l.m(b, aVar, 3);
        }
    }

    public static final synchronized void c(String str) {
        String str2;
        synchronized (c.class) {
            boolean z = false;
            a.d("startMonitor, event = " + str, new Object[0]);
            if (str.length() == 0) {
                z = true;
            }
            if (z) {
                return;
            }
            l.p();
            b = str;
            c = str;
            HashMap<String, String> hashMap = i;
            if (hashMap != null && hashMap.containsKey("before_play_time")) {
                try {
                    HashMap<String, String> hashMap2 = i;
                    if (hashMap2 != null && (str2 = hashMap2.get("before_play_time")) != null) {
                        q("before_play_time", System.currentTimeMillis() - Long.parseLong(str2));
                        HashMap<String, String> hashMap3 = i;
                        if (hashMap3 != null) {
                            hashMap3.remove("before_play_time");
                        }
                    }
                } catch (NumberFormatException e2) {
                    e2.printStackTrace();
                }
            }
            l.m(str, new b("start", -1), 1);
        }
    }

    @TargetClass("com.xs.fm.player.sdk.component.event.monior.PlayChainTraceMonitor")
    @Insert("startMonitor")
    public static void h(String str) {
        String str2;
        NsXrayApi nsXrayApi = NsXrayApi.IMPL;
        if (nsXrayApi.enable()) {
            NsAudioModuleApi.IMPL.xrayDepend().b();
            g gVar = new g();
            Map map = (Map) i0.b.getValue();
            if (map.containsKey(str)) {
                str2 = (String) map.get(str);
            } else {
                str2 = "未知原因起播-" + str;
            }
            gVar.j("原因", str2);
            i0.a.i("PlayChainTraceMonitor.startMonitor(" + gVar + ")", new Object[0]);
            nsXrayApi.sendEvent("听书开始", gVar);
        }
        f(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0033  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final synchronized void t(java.lang.String r5, java.lang.String r6) {
        /*
            java.lang.Class<zk6.c> r0 = zk6.c.class
            monitor-enter(r0)
            bl6.a r1 = zk6.c.a     // Catch: java.lang.Throwable -> L58
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L58
            r2.<init>()     // Catch: java.lang.Throwable -> L58
            java.lang.String r3 = "setMonitorCategory, key = "
            r2.append(r3)     // Catch: java.lang.Throwable -> L58
            r2.append(r5)     // Catch: java.lang.Throwable -> L58
            java.lang.String r3 = " and value = "
            r2.append(r3)     // Catch: java.lang.Throwable -> L58
            r2.append(r6)     // Catch: java.lang.Throwable -> L58
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L58
            r3 = 0
            java.lang.Object[] r4 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> L58
            r1.d(r2, r4)     // Catch: java.lang.Throwable -> L58
            r1 = 1
            if (r5 == 0) goto L30
            int r2 = r5.length()     // Catch: java.lang.Throwable -> L58
            if (r2 != 0) goto L2e
            goto L30
        L2e:
            r2 = 0
            goto L31
        L30:
            r2 = 1
        L31:
            if (r2 != 0) goto L56
            if (r6 == 0) goto L3b
            int r2 = r6.length()     // Catch: java.lang.Throwable -> L58
            if (r2 != 0) goto L3c
        L3b:
            r3 = 1
        L3c:
            if (r3 == 0) goto L3f
            goto L56
        L3f:
            java.util.HashMap<java.lang.String, java.lang.String> r1 = zk6.c.e     // Catch: java.lang.Throwable -> L58
            if (r1 != 0) goto L4a
            java.util.HashMap r1 = new java.util.HashMap     // Catch: java.lang.Throwable -> L58
            r1.<init>()     // Catch: java.lang.Throwable -> L58
            zk6.c.e = r1     // Catch: java.lang.Throwable -> L58
        L4a:
            java.util.HashMap<java.lang.String, java.lang.String> r1 = zk6.c.e     // Catch: java.lang.Throwable -> L58
            if (r1 == 0) goto L54
            java.lang.Object r5 = r1.put(r5, r6)     // Catch: java.lang.Throwable -> L58
            java.lang.String r5 = (java.lang.String) r5     // Catch: java.lang.Throwable -> L58
        L54:
            monitor-exit(r0)
            return
        L56:
            monitor-exit(r0)
            return
        L58:
            r5 = move-exception
            monitor-exit(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: zk6.c.t(java.lang.String, java.lang.String):void");
    }

    public static final synchronized void q(String str, long j2) {
        synchronized (c.class) {
            boolean z = false;
            a.d("setMonitorCategory, key = " + str + " and value = " + j2, new Object[0]);
            if (str == null || str.length() == 0) {
                z = true;
            }
            if (!z && !TextUtils.isEmpty(b)) {
                if (f == null) {
                    f = new HashMap<>();
                }
                HashMap<String, Long> hashMap = f;
                if (hashMap != null && hashMap.containsKey(str)) {
                    HashMap<String, Long> hashMap2 = f;
                    if (hashMap2 != null) {
                        hashMap2.put(str + "_1", Long.valueOf(j2));
                    }
                } else {
                    HashMap<String, Long> hashMap3 = f;
                    if (hashMap3 != null) {
                        hashMap3.put(str, Long.valueOf(j2));
                    }
                }
            }
        }
    }

    public static final synchronized void r(String str, long j2, boolean z) {
        synchronized (c.class) {
            a.d("setMiddleTime, key = " + str + " and value = " + j2, new Object[0]);
            if (TextUtils.isEmpty(b)) {
                return;
            }
            if (g.get(str) != null || z) {
                g.put(str, Long.valueOf(j2));
            }
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(53:35|(1:37)|38|(2:39|40)|(3:240|241|(44:243|43|(1:45)|46|(1:239)|52|53|(4:55|(8:58|(4:102|63|64|65)|61|(5:66|(12:68|(1:70)(1:93)|71|(1:73)(1:92)|74|(1:76)(1:91)|77|(4:82|83|(1:85)(1:89)|86)|90|83|(0)(0)|86)(2:94|(1:99)(1:98))|87|88|65)|63|64|65|56)|123|124)(1:238)|125|(5:128|(1:130)(1:137)|(3:132|133|134)(1:136)|135|126)|138|139|140|141|(1:143)(1:234)|144|(1:146)(1:233)|(1:232)(2:151|152)|153|154|155|(1:229)(1:159)|160|(1:228)(1:164)|165|(2:226|227)|168|(1:170)|171|(1:173)(1:223)|174|(1:176)|177|(4:179|(2:182|180)|183|184)|185|(4:187|(2:190|188)|191|192)|193|(4:195|(2:198|196)|199|200)|201|(6:207|(1:211)|212|(4:214|(2:217|215)|218|219)|220|(1:222))|107|(4:113|(1:115)|116|(1:120))|121|122))|42|43|(0)|46|(1:48)|239|52|53|(0)(0)|125|(1:126)|138|139|140|141|(0)(0)|144|(0)(0)|(0)|232|153|154|155|(1:157)|229|160|(1:162)|228|165|(1:167)(3:224|226|227)|168|(0)|171|(0)(0)|174|(0)|177|(0)|185|(0)|193|(0)|201|(8:203|205|207|(2:209|211)|212|(0)|220|(0))|107|(6:109|111|113|(0)|116|(2:118|120))|121|122) */
    /* JADX WARN: Code restructure failed: missing block: B:230:0x0511, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:235:0x0513, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:236:0x0514, code lost:
    
        r10 = 0;
     */
    /* JADX WARN: Removed duplicated region for block: B:109:0x055f  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0581  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x02da A[Catch: JSONException -> 0x0517, TryCatch #2 {JSONException -> 0x0517, blocks: (B:40:0x00d5, B:43:0x00fd, B:46:0x0107, B:52:0x011b, B:55:0x0125, B:56:0x0131, B:58:0x0137, B:61:0x01ac, B:66:0x01be, B:68:0x01d0, B:71:0x01e1, B:74:0x01fd, B:77:0x021d, B:82:0x022f, B:86:0x0244, B:87:0x02ad, B:89:0x023d, B:90:0x0232, B:91:0x0217, B:92:0x01f7, B:93:0x01dd, B:98:0x0270, B:99:0x0290, B:100:0x0196, B:124:0x02c5, B:125:0x02cc, B:126:0x02d4, B:128:0x02da, B:130:0x02e4, B:133:0x0303, B:239:0x0116), top: B:39:0x00d5 }] */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0324 A[Catch: JSONException -> 0x0513, TryCatch #1 {JSONException -> 0x0513, blocks: (B:141:0x0320, B:143:0x0324, B:144:0x032e, B:146:0x0332, B:149:0x033e, B:151:0x034a), top: B:140:0x0320 }] */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0332 A[Catch: JSONException -> 0x0513, TryCatch #1 {JSONException -> 0x0513, blocks: (B:141:0x0320, B:143:0x0324, B:144:0x032e, B:146:0x0332, B:149:0x033e, B:151:0x034a), top: B:140:0x0320 }] */
    /* JADX WARN: Removed duplicated region for block: B:170:0x03c3 A[Catch: JSONException -> 0x0511, TryCatch #0 {JSONException -> 0x0511, blocks: (B:155:0x0358, B:157:0x0368, B:159:0x036c, B:160:0x0376, B:162:0x0387, B:164:0x038b, B:165:0x0391, B:170:0x03c3, B:171:0x03cc, B:174:0x03dc, B:176:0x03e7, B:177:0x03ea, B:179:0x03ee, B:180:0x03f6, B:182:0x03fc, B:184:0x0410, B:185:0x0412, B:187:0x0416, B:188:0x041e, B:190:0x0424, B:192:0x0438, B:193:0x043a, B:195:0x043e, B:196:0x0446, B:198:0x044c, B:200:0x0460, B:201:0x0462, B:203:0x0466, B:205:0x046a, B:207:0x0471, B:209:0x047f, B:211:0x0487, B:212:0x049c, B:214:0x04a5, B:215:0x04aa, B:217:0x04b0, B:219:0x04ff, B:220:0x0501, B:222:0x0507, B:226:0x039d), top: B:154:0x0358 }] */
    /* JADX WARN: Removed duplicated region for block: B:173:0x03d9  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x03e7 A[Catch: JSONException -> 0x0511, TryCatch #0 {JSONException -> 0x0511, blocks: (B:155:0x0358, B:157:0x0368, B:159:0x036c, B:160:0x0376, B:162:0x0387, B:164:0x038b, B:165:0x0391, B:170:0x03c3, B:171:0x03cc, B:174:0x03dc, B:176:0x03e7, B:177:0x03ea, B:179:0x03ee, B:180:0x03f6, B:182:0x03fc, B:184:0x0410, B:185:0x0412, B:187:0x0416, B:188:0x041e, B:190:0x0424, B:192:0x0438, B:193:0x043a, B:195:0x043e, B:196:0x0446, B:198:0x044c, B:200:0x0460, B:201:0x0462, B:203:0x0466, B:205:0x046a, B:207:0x0471, B:209:0x047f, B:211:0x0487, B:212:0x049c, B:214:0x04a5, B:215:0x04aa, B:217:0x04b0, B:219:0x04ff, B:220:0x0501, B:222:0x0507, B:226:0x039d), top: B:154:0x0358 }] */
    /* JADX WARN: Removed duplicated region for block: B:179:0x03ee A[Catch: JSONException -> 0x0511, TryCatch #0 {JSONException -> 0x0511, blocks: (B:155:0x0358, B:157:0x0368, B:159:0x036c, B:160:0x0376, B:162:0x0387, B:164:0x038b, B:165:0x0391, B:170:0x03c3, B:171:0x03cc, B:174:0x03dc, B:176:0x03e7, B:177:0x03ea, B:179:0x03ee, B:180:0x03f6, B:182:0x03fc, B:184:0x0410, B:185:0x0412, B:187:0x0416, B:188:0x041e, B:190:0x0424, B:192:0x0438, B:193:0x043a, B:195:0x043e, B:196:0x0446, B:198:0x044c, B:200:0x0460, B:201:0x0462, B:203:0x0466, B:205:0x046a, B:207:0x0471, B:209:0x047f, B:211:0x0487, B:212:0x049c, B:214:0x04a5, B:215:0x04aa, B:217:0x04b0, B:219:0x04ff, B:220:0x0501, B:222:0x0507, B:226:0x039d), top: B:154:0x0358 }] */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0416 A[Catch: JSONException -> 0x0511, TryCatch #0 {JSONException -> 0x0511, blocks: (B:155:0x0358, B:157:0x0368, B:159:0x036c, B:160:0x0376, B:162:0x0387, B:164:0x038b, B:165:0x0391, B:170:0x03c3, B:171:0x03cc, B:174:0x03dc, B:176:0x03e7, B:177:0x03ea, B:179:0x03ee, B:180:0x03f6, B:182:0x03fc, B:184:0x0410, B:185:0x0412, B:187:0x0416, B:188:0x041e, B:190:0x0424, B:192:0x0438, B:193:0x043a, B:195:0x043e, B:196:0x0446, B:198:0x044c, B:200:0x0460, B:201:0x0462, B:203:0x0466, B:205:0x046a, B:207:0x0471, B:209:0x047f, B:211:0x0487, B:212:0x049c, B:214:0x04a5, B:215:0x04aa, B:217:0x04b0, B:219:0x04ff, B:220:0x0501, B:222:0x0507, B:226:0x039d), top: B:154:0x0358 }] */
    /* JADX WARN: Removed duplicated region for block: B:195:0x043e A[Catch: JSONException -> 0x0511, TryCatch #0 {JSONException -> 0x0511, blocks: (B:155:0x0358, B:157:0x0368, B:159:0x036c, B:160:0x0376, B:162:0x0387, B:164:0x038b, B:165:0x0391, B:170:0x03c3, B:171:0x03cc, B:174:0x03dc, B:176:0x03e7, B:177:0x03ea, B:179:0x03ee, B:180:0x03f6, B:182:0x03fc, B:184:0x0410, B:185:0x0412, B:187:0x0416, B:188:0x041e, B:190:0x0424, B:192:0x0438, B:193:0x043a, B:195:0x043e, B:196:0x0446, B:198:0x044c, B:200:0x0460, B:201:0x0462, B:203:0x0466, B:205:0x046a, B:207:0x0471, B:209:0x047f, B:211:0x0487, B:212:0x049c, B:214:0x04a5, B:215:0x04aa, B:217:0x04b0, B:219:0x04ff, B:220:0x0501, B:222:0x0507, B:226:0x039d), top: B:154:0x0358 }] */
    /* JADX WARN: Removed duplicated region for block: B:214:0x04a5 A[Catch: JSONException -> 0x0511, TryCatch #0 {JSONException -> 0x0511, blocks: (B:155:0x0358, B:157:0x0368, B:159:0x036c, B:160:0x0376, B:162:0x0387, B:164:0x038b, B:165:0x0391, B:170:0x03c3, B:171:0x03cc, B:174:0x03dc, B:176:0x03e7, B:177:0x03ea, B:179:0x03ee, B:180:0x03f6, B:182:0x03fc, B:184:0x0410, B:185:0x0412, B:187:0x0416, B:188:0x041e, B:190:0x0424, B:192:0x0438, B:193:0x043a, B:195:0x043e, B:196:0x0446, B:198:0x044c, B:200:0x0460, B:201:0x0462, B:203:0x0466, B:205:0x046a, B:207:0x0471, B:209:0x047f, B:211:0x0487, B:212:0x049c, B:214:0x04a5, B:215:0x04aa, B:217:0x04b0, B:219:0x04ff, B:220:0x0501, B:222:0x0507, B:226:0x039d), top: B:154:0x0358 }] */
    /* JADX WARN: Removed duplicated region for block: B:222:0x0507 A[Catch: JSONException -> 0x0511, TRY_LEAVE, TryCatch #0 {JSONException -> 0x0511, blocks: (B:155:0x0358, B:157:0x0368, B:159:0x036c, B:160:0x0376, B:162:0x0387, B:164:0x038b, B:165:0x0391, B:170:0x03c3, B:171:0x03cc, B:174:0x03dc, B:176:0x03e7, B:177:0x03ea, B:179:0x03ee, B:180:0x03f6, B:182:0x03fc, B:184:0x0410, B:185:0x0412, B:187:0x0416, B:188:0x041e, B:190:0x0424, B:192:0x0438, B:193:0x043a, B:195:0x043e, B:196:0x0446, B:198:0x044c, B:200:0x0460, B:201:0x0462, B:203:0x0466, B:205:0x046a, B:207:0x0471, B:209:0x047f, B:211:0x0487, B:212:0x049c, B:214:0x04a5, B:215:0x04aa, B:217:0x04b0, B:219:0x04ff, B:220:0x0501, B:222:0x0507, B:226:0x039d), top: B:154:0x0358 }] */
    /* JADX WARN: Removed duplicated region for block: B:223:0x03db  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x0339  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x032d  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x02c8  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0101 A[Catch: JSONException -> 0x00f8, TRY_ENTER, TRY_LEAVE, TryCatch #3 {JSONException -> 0x00f8, blocks: (B:241:0x00d9, B:243:0x00e1, B:45:0x0101, B:48:0x010b, B:50:0x010f, B:102:0x019e), top: B:240:0x00d9 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0125 A[Catch: JSONException -> 0x0517, TRY_ENTER, TryCatch #2 {JSONException -> 0x0517, blocks: (B:40:0x00d5, B:43:0x00fd, B:46:0x0107, B:52:0x011b, B:55:0x0125, B:56:0x0131, B:58:0x0137, B:61:0x01ac, B:66:0x01be, B:68:0x01d0, B:71:0x01e1, B:74:0x01fd, B:77:0x021d, B:82:0x022f, B:86:0x0244, B:87:0x02ad, B:89:0x023d, B:90:0x0232, B:91:0x0217, B:92:0x01f7, B:93:0x01dd, B:98:0x0270, B:99:0x0290, B:100:0x0196, B:124:0x02c5, B:125:0x02cc, B:126:0x02d4, B:128:0x02da, B:130:0x02e4, B:133:0x0303, B:239:0x0116), top: B:39:0x00d5 }] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x023a  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x023d A[Catch: JSONException -> 0x0517, TryCatch #2 {JSONException -> 0x0517, blocks: (B:40:0x00d5, B:43:0x00fd, B:46:0x0107, B:52:0x011b, B:55:0x0125, B:56:0x0131, B:58:0x0137, B:61:0x01ac, B:66:0x01be, B:68:0x01d0, B:71:0x01e1, B:74:0x01fd, B:77:0x021d, B:82:0x022f, B:86:0x0244, B:87:0x02ad, B:89:0x023d, B:90:0x0232, B:91:0x0217, B:92:0x01f7, B:93:0x01dd, B:98:0x0270, B:99:0x0290, B:100:0x0196, B:124:0x02c5, B:125:0x02cc, B:126:0x02d4, B:128:0x02da, B:130:0x02e4, B:133:0x0303, B:239:0x0116), top: B:39:0x00d5 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void m(java.lang.String r31, zk6.a r32, int r33) {
        /*
            Method dump skipped, instructions count: 1740
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: zk6.c.m(java.lang.String, zk6.a, int):void");
    }

    @TargetClass("com.xs.fm.player.sdk.component.event.monior.PlayChainTraceMonitor")
    @Insert("endMonitorByError")
    public static void e(Integer num, String str, int i2, String str2) {
        d.a.d("endMonitor()", new Object[0]);
        if (!TextUtils.isEmpty(d.c)) {
            Args args = new Args();
            args.put("accident_type", d.a(d.c));
            args.put("success", Boolean.FALSE);
            ReportManager.onReport("audio_accident_present_monitor", args);
            d.c = null;
        }
        b(num, str, i2, str2);
    }

    public static final synchronized void b(Integer num, String str, int i2, String str2) {
        gl6.b bVar;
        String str3;
        synchronized (c.class) {
            lk6.b bVar2 = lk6.c.a;
            if (bVar2 != null && (bVar = bVar2.k) != null) {
                boolean z = true;
                if (bVar.h()) {
                    a.d("endMonitorByError, event = " + b, new Object[0]);
                    if (b.length() != 0) {
                        z = false;
                    }
                    if (z) {
                        return;
                    }
                    t("is_error", "1");
                    if (num == null || (str3 = String.valueOf(num.intValue())) == null) {
                        str3 = "";
                    }
                    t("genre_type", str3);
                    if (str == null) {
                        str = "";
                    }
                    t("error_type", str);
                    t("error_code", String.valueOf(i2));
                    if (str2 == null) {
                        str2 = "";
                    }
                    t("error_msg", str2);
                    l.m(b, new b("error", 100), 3);
                }
            }
        }
    }

    @TargetClass("com.xs.fm.player.sdk.component.event.monior.PlayChainTraceMonitor")
    @Insert("endMonitorByError")
    public static void g(Integer num, String str, int i2, String str2) {
        String str3;
        String str4;
        NsXrayApi nsXrayApi = NsXrayApi.IMPL;
        if (nsXrayApi.enable()) {
            g gVar = new g();
            Map map = (Map) i0.d.getValue();
            if (map.containsKey(Integer.valueOf(i2))) {
                str3 = i2 + "-" + ((String) map.get(Integer.valueOf(i2)));
            } else {
                str3 = i2 + "";
            }
            gVar.j("错误码", str3);
            if (!TextUtils.isEmpty(str2)) {
                gVar.j("错误信息", str2);
            }
            Map map2 = (Map) i0.c.getValue();
            if (map2.containsKey(str)) {
                str4 = (String) map2.get(str);
            } else {
                str4 = str;
            }
            gVar.j("错误来自", str4);
            gVar.j("原因", "发生错误");
            i0.a.e("endMonitorByError(" + gVar + ")", new Object[0]);
            NsAudioModuleApi.IMPL.xrayDepend().a();
            nsXrayApi.sendEvent("听书流程出错", gVar);
        }
        e(num, str, i2, str2);
    }

    public static /* synthetic */ void s(String str, long j2, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        r(str, j2, z);
    }

    private final JSONObject l(String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, JSONObject jSONObject4) {
        if (!TextUtils.isEmpty(str) && jSONObject != null && jSONObject2 != null) {
            try {
                JSONObject jSONObject5 = new JSONObject();
                jSONObject5.putOpt("event", str);
                Iterator<String> keys = jSONObject.keys();
                Intrinsics.checkExpressionValueIsNotNull(keys, "categoryJson.keys()");
                while (keys.hasNext()) {
                    String next = keys.next();
                    jSONObject5.putOpt(next, jSONObject.get(next));
                }
                if (jSONObject4 != null) {
                    Iterator<String> keys2 = jSONObject4.keys();
                    Intrinsics.checkExpressionValueIsNotNull(keys2, "mapForExtra.keys()");
                    while (keys2.hasNext()) {
                        String next2 = keys2.next();
                        jSONObject5.putOpt(next2, jSONObject4.get(next2));
                    }
                }
                if (jSONObject3 != null) {
                    Iterator<String> keys3 = jSONObject3.keys();
                    Intrinsics.checkExpressionValueIsNotNull(keys3, "otherValue.keys()");
                    while (keys3.hasNext()) {
                        String next3 = keys3.next();
                        jSONObject5.putOpt(next3, jSONObject3.get(next3));
                    }
                }
                Iterator<String> keys4 = jSONObject2.keys();
                Intrinsics.checkExpressionValueIsNotNull(keys4, "metric.keys()");
                while (keys4.hasNext()) {
                    String next4 = keys4.next();
                    jSONObject5.putOpt(next4, jSONObject2.get(next4));
                }
                return jSONObject5;
            } catch (Throwable unused) {
            }
        }
        return null;
    }
}
