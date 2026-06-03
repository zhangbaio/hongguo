package com.vivo.push;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bytedance.covode.number.Covode;
import com.vivo.push.sdk.PushMessageCallback;
import com.vivo.push.util.ContextDelegate;
import com.vivo.push.util.VivoPushException;
import com.vivo.push.util.ad;
import com.vivo.push.util.ah;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class m {
    private static volatile m a;
    private Context h;
    private String j;
    private Boolean m;
    private Long n;
    private boolean o;
    private int q;
    private long b = -1;
    private long c = -1;
    private long d = -1;
    private long e = -1;
    private long f = -1;
    private long g = -1;
    private boolean i = true;
    private SparseArray<a> k = new SparseArray<>();
    private int l = 0;
    private IPushClientFactory p = new l();

    static {
        Covode.recordClassIndex(655089);
    }

    public static class a {
        private IPushActionListener a;
        private com.vivo.push.b.c b;
        private IPushActionListener c;
        private Runnable d;
        private Object[] e;

        static {
            Covode.recordClassIndex(655090);
        }

        public final Object[] b() {
            return this.e;
        }

        public final void a() {
            Runnable runnable = this.d;
            if (runnable == null) {
                com.vivo.push.util.t.a("PushClientManager", "task is null");
            } else {
                runnable.run();
            }
        }

        public final void a(IPushActionListener iPushActionListener) {
            this.c = iPushActionListener;
        }

        public final void a(Runnable runnable) {
            this.d = runnable;
        }

        public a(com.vivo.push.b.c cVar, IPushActionListener iPushActionListener) {
            this.b = cVar;
            this.a = iPushActionListener;
        }

        public final void a(int i, Object... objArr) {
            this.e = objArr;
            IPushActionListener iPushActionListener = this.c;
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(i);
            }
            IPushActionListener iPushActionListener2 = this.a;
            if (iPushActionListener2 != null) {
                iPushActionListener2.onStateChanged(i);
            }
        }
    }

    public final boolean f() {
        return this.o;
    }

    public final boolean g() {
        return this.i;
    }

    public final Context h() {
        return this.h;
    }

    public final String i() {
        return this.j;
    }

    public final int j() {
        return this.q;
    }

    public final synchronized void a(Context context) {
        if (this.h == null) {
            this.h = ContextDelegate.getContext(context);
            this.o = com.vivo.push.util.aa.c(context, context.getPackageName());
            ad.c().a(this.h);
            a(new com.vivo.push.b.g());
            this.j = com.vivo.push.restructure.a.a().e().i();
        }
    }

    public final void a(List<String> list) {
        if (list.contains(this.j)) {
            e();
        }
    }

    final void a(IPushActionListener iPushActionListener, String str, String str2) {
        if (this.h == null) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(102);
                return;
            }
            return;
        }
        if (a(str, str2)) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(10001);
                return;
            }
            return;
        }
        com.vivo.push.restructure.a.a().h().b();
        if (!a(this.b)) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(1002);
                return;
            }
            return;
        }
        this.b = SystemClock.elapsedRealtime();
        String packageName = this.h.getPackageName();
        a aVar = null;
        if (this.h != null) {
            com.vivo.push.b.b bVar = new com.vivo.push.b.b(true, packageName);
            bVar.f();
            bVar.c(str);
            bVar.d(str2);
            bVar.b(100);
            if (this.o) {
                if (l()) {
                    aVar = a(bVar, iPushActionListener);
                } else if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(101);
                }
            } else {
                aVar = a(bVar, iPushActionListener);
            }
        } else if (iPushActionListener != null) {
            iPushActionListener.onStateChanged(102);
        }
        if (aVar == null) {
            return;
        }
        aVar.a(new n(this, aVar, str, str2));
        aVar.a();
    }

    public final void a(String str, int i, Object... objArr) {
        a b = b(str);
        if (b != null) {
            b.a(i, objArr);
        } else {
            com.vivo.push.util.t.d("PushClientManager", "notifyApp token is null");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0082 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    final void a(java.lang.String r8, java.lang.String r9, java.lang.String r10, com.vivo.push.IPushActionListener r11) {
        /*
            r7 = this;
            android.content.Context r0 = r7.h
            if (r0 != 0) goto Lc
            if (r11 == 0) goto Lb
            r8 = 102(0x66, float:1.43E-43)
            r11.onStateChanged(r8)
        Lb:
            return
        Lc:
            boolean r0 = android.text.TextUtils.isEmpty(r8)
            if (r0 == 0) goto L1a
            if (r11 == 0) goto L19
            r8 = 30002(0x7532, float:4.2042E-41)
            r11.onStateChanged(r8)
        L19:
            return
        L1a:
            com.vivo.push.restructure.a r0 = com.vivo.push.restructure.a.a()
            com.vivo.push.c.a r0 = r0.g()
            boolean r0 = r0.f()
            r1 = 1
            if (r0 != 0) goto L83
            java.lang.String r0 = r7.j
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            r2 = 0
            if (r0 != 0) goto L40
            java.lang.String r0 = r7.j
            boolean r0 = r0.equals(r8)
            if (r0 == 0) goto L40
            if (r11 == 0) goto L52
            r11.onStateChanged(r2)
            goto L52
        L40:
            int r0 = r8.length()
            long r3 = (long) r0
            r5 = 70
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 <= 0) goto L54
            if (r11 == 0) goto L52
            r0 = 30003(0x7533, float:4.2043E-41)
            r11.onStateChanged(r0)
        L52:
            r2 = 1
            goto L80
        L54:
            boolean r0 = r7.o
            if (r0 == 0) goto L80
            boolean r0 = r7.l()
            if (r0 != 0) goto L66
            if (r11 == 0) goto L52
            r0 = 101(0x65, float:1.42E-43)
            r11.onStateChanged(r0)
            goto L52
        L66:
            com.vivo.push.restructure.a r0 = com.vivo.push.restructure.a.a()
            com.vivo.push.k r0 = r0.h()
            java.lang.String r0 = r0.b()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L80
            if (r11 == 0) goto L52
            r0 = 30001(0x7531, float:4.204E-41)
            r11.onStateChanged(r0)
            goto L52
        L80:
            if (r2 == 0) goto L83
            return
        L83:
            long r2 = r7.d
            boolean r0 = a(r2)
            if (r0 != 0) goto L93
            if (r11 == 0) goto L92
            r8 = 1002(0x3ea, float:1.404E-42)
            r11.onStateChanged(r8)
        L92:
            return
        L93:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r0.add(r8)
            com.vivo.push.b.a r8 = new com.vivo.push.b.a
            android.content.Context r2 = r7.h
            java.lang.String r2 = r2.getPackageName()
            r8.<init>(r1, r2, r0)
            r0 = 100
            r8.b(r0)
            r8.c(r9)
            r8.d(r10)
            long r9 = android.os.SystemClock.elapsedRealtime()
            r7.d = r9
            com.vivo.push.m$a r9 = new com.vivo.push.m$a
            r9.<init>(r8, r11)
            java.lang.String r9 = r7.a(r9)
            r8.b(r9)
            r7.a(r8)
            r7.c(r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.push.m.a(java.lang.String, java.lang.String, java.lang.String, com.vivo.push.IPushActionListener):void");
    }

    public final void a(String str, int i) {
        a b = b(str);
        if (b != null) {
            b.a(i, new Object[0]);
        } else {
            com.vivo.push.util.t.d("PushClientManager", "notifyStatusChanged token is null");
        }
    }

    final void a(ArrayList<String> arrayList, String str, String str2, IPushActionListener iPushActionListener) {
        if (this.h == null) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(102);
                return;
            }
            return;
        }
        if (!a(this.f)) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(1002);
                return;
            }
            return;
        }
        this.f = SystemClock.elapsedRealtime();
        if (arrayList.size() < 0) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(20002);
                return;
            }
            return;
        }
        if (arrayList.size() + c().size() > 500) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(20004);
                return;
            }
            return;
        }
        Iterator<String> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            if (it2.next().length() > 70) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(20003);
                    return;
                }
                return;
            }
        }
        if (this.o) {
            if (!l()) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(101);
                    return;
                }
                return;
            } else if (TextUtils.isEmpty(com.vivo.push.restructure.a.a().h().b())) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(20001);
                    return;
                }
                return;
            }
        }
        com.vivo.push.b.z zVar = new com.vivo.push.b.z(true, this.h.getPackageName(), arrayList);
        zVar.b(500);
        zVar.c(str);
        zVar.d(str2);
        String a2 = a(new a(zVar, iPushActionListener));
        zVar.b(a2);
        a(zVar);
        c(a2);
    }

    public final int a(Intent intent, PushMessageCallback pushMessageCallback) {
        v createReceiverCommand = this.p.createReceiverCommand(intent);
        Context context = a().h;
        if (createReceiverCommand == null) {
            com.vivo.push.util.t.a("PushClientManager", "sendCommand, null command!");
            if (context == null) {
                return 2805;
            }
            com.vivo.push.util.t.c(context, "[执行指令失败]指令空！");
            return 2805;
        }
        com.vivo.push.h.ab createReceiveTask = this.p.createReceiveTask(createReceiverCommand);
        if (createReceiveTask == null) {
            com.vivo.push.util.t.a("PushClientManager", "sendCommand, null command task! pushCommand = ".concat(String.valueOf(createReceiverCommand)));
            if (context == null) {
                return 2806;
            }
            com.vivo.push.util.t.c(context, "[执行指令失败]指令" + createReceiverCommand + "任务空！");
            return 2806;
        }
        if (context != null && !(createReceiverCommand instanceof com.vivo.push.b.n)) {
            com.vivo.push.util.t.a(context, "[接收指令]".concat(String.valueOf(createReceiverCommand)));
        }
        createReceiveTask.a(pushMessageCallback);
        createReceiveTask.run();
        return createReceiveTask.c();
    }

    public final void a(v vVar) {
        Context context = a().h;
        if (vVar == null) {
            com.vivo.push.util.t.a("PushClientManager", "sendCommand, null command!");
            if (context != null) {
                com.vivo.push.util.t.c(context, "[执行指令失败]指令空！");
                return;
            }
            return;
        }
        s createTask = this.p.createTask(vVar);
        if (createTask == null) {
            com.vivo.push.util.t.a("PushClientManager", "sendCommand, null command task! pushCommand = ".concat(String.valueOf(vVar)));
            if (context != null) {
                com.vivo.push.util.t.c(context, "[执行指令失败]指令" + vVar + "任务空！");
                return;
            }
            return;
        }
        com.vivo.push.util.t.d("PushClientManager", "client--sendCommand, command = ".concat(String.valueOf(vVar)));
        t.a(createTask, v.c());
    }

    protected final void b() throws VivoPushException {
        Context context = this.h;
        if (context != null) {
            ah.b(context);
        }
    }

    public final void e() {
        this.j = null;
        com.vivo.push.restructure.a.a().e().j();
    }

    public final boolean d() {
        if (this.h == null) {
            com.vivo.push.util.t.d("PushClientManager", "support:context is null");
            return false;
        }
        Boolean valueOf = Boolean.valueOf(l());
        this.m = valueOf;
        return valueOf.booleanValue();
    }

    public final long k() {
        Context context = this.h;
        if (context == null) {
            return -1L;
        }
        if (this.n == null) {
            this.n = Long.valueOf(ah.a(context));
        }
        return this.n.longValue();
    }

    private m() {
    }

    public static synchronized m a() {
        m mVar;
        synchronized (m.class) {
            if (a == null) {
                a = new m();
            }
            mVar = a;
        }
        return mVar;
    }

    private boolean l() {
        boolean z;
        if (this.m == null) {
            if (k() >= 1230 && ah.d(this.h)) {
                z = true;
            } else {
                z = false;
            }
            this.m = Boolean.valueOf(z);
        }
        return this.m.booleanValue();
    }

    public static List<String> c() {
        String g = com.vivo.push.restructure.a.a().e().g();
        ArrayList arrayList = new ArrayList();
        try {
        } catch (JSONException unused) {
            com.vivo.push.restructure.a.a().e().h();
            arrayList.clear();
            com.vivo.push.util.t.d("PushClientManager", "getTags error");
        }
        if (TextUtils.isEmpty(g)) {
            return arrayList;
        }
        Iterator<String> keys = new JSONObject(g).keys();
        while (keys.hasNext()) {
            arrayList.add(keys.next());
        }
        return arrayList;
    }

    protected final void a(boolean z) {
        this.i = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        t.a(new r(this, str));
    }

    public final void a(String str) {
        this.j = str;
        com.vivo.push.restructure.a.a().e().e(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized a b(String str) {
        if (str != null) {
            try {
                int parseInt = Integer.parseInt(str);
                a aVar = this.k.get(parseInt);
                this.k.delete(parseInt);
                return aVar;
            } catch (Exception unused) {
            }
        }
        return null;
    }

    private synchronized String a(a aVar) {
        int i;
        this.k.put(this.l, aVar);
        i = this.l;
        this.l = i + 1;
        return Integer.toString(i);
    }

    public static boolean a(long j) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (j != -1 && elapsedRealtime > j && elapsedRealtime < j + 2000) {
            return false;
        }
        return true;
    }

    private a a(com.vivo.push.b.b bVar, IPushActionListener iPushActionListener) {
        a aVar = new a(bVar, iPushActionListener);
        String a2 = a(aVar);
        bVar.b(a2);
        aVar.a(new o(this, bVar, a2));
        return aVar;
    }

    private static boolean a(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            return false;
        }
        return true;
    }

    public final void c(IPushActionListener iPushActionListener, String str, String str2) {
        a(iPushActionListener, str, str2, 1);
    }

    public final void b(IPushActionListener iPushActionListener, String str, String str2) {
        a(iPushActionListener, str, str2, 11);
    }

    final void b(String str, String str2, String str3, IPushActionListener iPushActionListener) {
        if (this.h == null) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(102);
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(this.j)) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(0);
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(str)) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(30002);
                return;
            }
            return;
        }
        if (str.length() > 70) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(30003);
                return;
            }
            return;
        }
        if (!a(this.e)) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(1002);
                return;
            }
            return;
        }
        if (this.o) {
            if (!l()) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(101);
                    return;
                }
                return;
            } else if (TextUtils.isEmpty(com.vivo.push.restructure.a.a().h().b())) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(30001);
                    return;
                }
                return;
            }
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        com.vivo.push.b.a aVar = new com.vivo.push.b.a(false, this.h.getPackageName(), arrayList);
        aVar.b(100);
        aVar.c(str2);
        aVar.d(str3);
        this.e = SystemClock.elapsedRealtime();
        String a2 = a(new a(aVar, iPushActionListener));
        aVar.b(a2);
        a(aVar);
        c(a2);
    }

    private void a(IPushActionListener iPushActionListener, String str, String str2, int i) {
        if (this.h == null) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(102);
                return;
            }
            return;
        }
        if (a(str, str2)) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(10001);
            }
        } else if (!a(this.c)) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(1002);
            }
        } else {
            this.c = SystemClock.elapsedRealtime();
            a a2 = a(iPushActionListener, this.h.getPackageName(), str, str2, i);
            if (a2 == null) {
                return;
            }
            a2.a(new p(this));
            a2.a();
        }
    }

    final void b(ArrayList<String> arrayList, String str, String str2, IPushActionListener iPushActionListener) {
        if (this.h == null) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(102);
                return;
            }
            return;
        }
        if (!a(this.g)) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(1002);
                return;
            }
            return;
        }
        this.g = SystemClock.elapsedRealtime();
        if (arrayList.size() < 0) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(20002);
                return;
            }
            return;
        }
        Iterator<String> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            if (it2.next().length() > 70) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(20003);
                    return;
                }
                return;
            }
        }
        if (this.o) {
            if (!l()) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(101);
                    return;
                }
                return;
            } else if (TextUtils.isEmpty(com.vivo.push.restructure.a.a().h().b())) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(20001);
                    return;
                }
                return;
            }
        }
        com.vivo.push.b.z zVar = new com.vivo.push.b.z(false, this.h.getPackageName(), arrayList);
        zVar.b(500);
        zVar.c(str);
        zVar.d(str2);
        String a2 = a(new a(zVar, iPushActionListener));
        zVar.b(a2);
        a(zVar);
        c(a2);
    }

    private a a(IPushActionListener iPushActionListener, String str, String str2, String str3, int i) {
        if (this.h == null) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(102);
            }
            return null;
        }
        com.vivo.push.b.b bVar = new com.vivo.push.b.b(false, str);
        bVar.c(str2);
        bVar.d(str3);
        if (i > 0) {
            bVar.a(i);
        }
        bVar.f();
        bVar.b(100);
        if (this.o) {
            if (!l()) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(101);
                }
                return null;
            }
            a aVar = new a(bVar, iPushActionListener);
            String a2 = a(aVar);
            bVar.b(a2);
            aVar.a(new q(this, bVar, a2));
            return aVar;
        }
        if (bVar.a(this.h) == 2) {
            return a(bVar, iPushActionListener);
        }
        return a(bVar, iPushActionListener);
    }
}
