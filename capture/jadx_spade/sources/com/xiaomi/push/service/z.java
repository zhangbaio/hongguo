package com.xiaomi.push.service;

import android.os.Process;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.ugc.bytex.taskmonitor.proxy.PThreadPoolExecutorDelegate;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import com.xiaomi.push.cd;
import com.xiaomi.push.dn;
import com.xiaomi.push.en;
import com.xiaomi.push.eo;
import java.io.BufferedReader;
import java.net.Socket;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class z {
    private static long a;

    /* renamed from: a, reason: collision with other field name */
    private static ThreadPoolExecutor f1033a;

    /* renamed from: a, reason: collision with other field name */
    private static final Pattern f1034a;

    static {
        Covode.recordClassIndex(655752);
        f1034a = Pattern.compile("([0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3})");
        a = 0L;
        f1033a = new PThreadPoolExecutorDelegate(1, 1, 20L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new DefaultThreadFactory("ush/service/z"));
    }

    public static void a() {
        dn.a m713a;
        long currentTimeMillis = System.currentTimeMillis();
        if ((f1033a.getActiveCount() <= 0 || currentTimeMillis - a >= 1800000) && en.m386a().m391a() && (m713a = ax.a().m713a()) != null && m713a.e() > 0) {
            a = currentTimeMillis;
            a(m713a.m279a(), true);
        }
    }

    public static void b() {
        String a2 = a("/proc/self/net/tcp");
        if (!TextUtils.isEmpty(a2)) {
            com.xiaomi.channel.commonutils.logger.b.m54a("dump tcp for uid = " + Process.myUid());
            com.xiaomi.channel.commonutils.logger.b.m54a(a2);
        }
        String a3 = a("/proc/self/net/tcp6");
        if (!TextUtils.isEmpty(a3)) {
            com.xiaomi.channel.commonutils.logger.b.m54a("dump tcp6 for uid = " + Process.myUid());
            com.xiaomi.channel.commonutils.logger.b.m54a(a3);
        }
    }

    private static String a(String str) {
        BufferedReader bufferedReader;
        Throwable th;
        try {
            bufferedReader = new BufferedReader(new PolarisFileReaderWrapper(new PolarisFileWrapper(str)));
            try {
                StringBuilder sb = new StringBuilder();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        sb.append("\n");
                        sb.append(readLine);
                    } else {
                        String sb2 = sb.toString();
                        com.xiaomi.push.v.a(bufferedReader);
                        return sb2;
                    }
                }
            } catch (Exception unused) {
                com.xiaomi.push.v.a(bufferedReader);
                return null;
            } catch (Throwable th2) {
                th = th2;
                com.xiaomi.push.v.a(bufferedReader);
                throw th;
            }
        } catch (Exception unused2) {
            bufferedReader = null;
        } catch (Throwable th3) {
            bufferedReader = null;
            th = th3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            com.xiaomi.channel.commonutils.logger.b.m54a("ConnectivityTest: begin to connect to " + str);
            Socket socket = new Socket();
            socket.connect(cd.m229a(str, 5222), 5000);
            socket.setTcpNoDelay(true);
            com.xiaomi.channel.commonutils.logger.b.m54a("ConnectivityTest: connect to " + str + " in " + (System.currentTimeMillis() - currentTimeMillis));
            socket.close();
            return true;
        } catch (Throwable th) {
            com.xiaomi.channel.commonutils.logger.b.d("ConnectivityTest: could not connect to:" + str + " exception: " + th.getClass().getSimpleName() + " description: " + th.getMessage());
            return false;
        }
    }

    public static void a(final List<String> list, final boolean z) {
        f1033a.execute(new Runnable() { // from class: com.xiaomi.push.service.z.1
            @Override // java.lang.Runnable
            public void run() {
                int i;
                boolean b = z.b("www.baidu.com:80");
                Iterator it2 = list.iterator();
                while (true) {
                    i = 1;
                    if (!it2.hasNext()) {
                        break;
                    }
                    String str = (String) it2.next();
                    if (!b && !z.b(str)) {
                        b = false;
                    } else {
                        b = true;
                    }
                    if (b && !z) {
                        break;
                    }
                }
                if (!b) {
                    i = 2;
                }
                eo.a(i);
            }
        });
    }
}
