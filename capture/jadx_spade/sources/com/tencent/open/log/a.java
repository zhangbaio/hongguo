package com.tencent.open.log;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.bytedance.security.android.aopcheck.PolarisFileWriterWrapper;
import com.ss.android.ugc.bytex.taskmonitor.proxy.HandlerDelegate;
import com.tencent.tauth.Tencent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class a extends Tracer implements Handler.Callback {
    private b a;
    private FileWriter b;
    private FileWriter c;
    private File d;
    private File e;
    private char[] f;
    private volatile f g;
    private volatile f h;
    private volatile f i;
    private volatile f j;
    private volatile boolean k;
    private HandlerThread l;
    private Handler m;

    static {
        Covode.recordClassIndex(653536);
    }

    public b c() {
        return this.a;
    }

    public void b() {
        h();
        i();
        this.l.quit();
    }

    private void h() {
        try {
            FileWriter fileWriter = this.b;
            if (fileWriter != null) {
                fileWriter.flush();
                this.b.close();
            }
        } catch (IOException e) {
            SLog.e("openSDK_LOG", "-->closeFileWriter() exception:", e);
        }
    }

    private void i() {
        try {
            FileWriter fileWriter = this.c;
            if (fileWriter != null) {
                fileWriter.flush();
                this.c.close();
            }
        } catch (IOException e) {
            SLog.e("openSDK_LOG", "-->closeAppSpecificFileWriter() exception:", e);
        }
    }

    private void j() {
        synchronized (this) {
            if (this.i == this.g) {
                this.i = this.h;
                this.j = this.g;
            } else {
                this.i = this.g;
                this.j = this.h;
            }
        }
    }

    private void f() {
        if (Thread.currentThread() != this.l || this.k) {
            return;
        }
        this.k = true;
        j();
        try {
            try {
                this.j.a(g(), this.f);
            } catch (IOException e) {
                SLog.e("FileTracer", "flushBuffer exception", e);
            }
            this.k = false;
        } finally {
            this.j.b();
        }
    }

    public void a() {
        if (this.m.hasMessages(1024)) {
            this.m.removeMessages(1024);
        }
        this.m.sendEmptyMessage(1024);
    }

    private Writer[] g() {
        File[] a = c().a();
        if (a != null && a.length >= 2) {
            File file = a[0];
            if ((file != null && !file.equals(this.d)) || (this.b == null && file != null)) {
                this.d = file;
                h();
                try {
                    this.b = new PolarisFileWriterWrapper(this.d, true);
                } catch (IOException unused) {
                    this.b = null;
                    SLog.e("openSDK_LOG", "-->obtainFileWriter() old log file permission denied");
                }
            }
            File file2 = a[1];
            if ((file2 != null && !file2.equals(this.e)) || (this.c == null && file2 != null)) {
                this.e = file2;
                i();
                try {
                    this.c = new PolarisFileWriterWrapper(this.e, true);
                } catch (IOException unused2) {
                    this.c = null;
                    SLog.e("openSDK_LOG", "-->obtainFileWriter() app specific file permission denied");
                }
                a(file2);
            }
        }
        return new Writer[]{this.b, this.c};
    }

    public void a(b bVar) {
        this.a = bVar;
    }

    public a(b bVar) {
        this(c.b, true, g.a, bVar);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what == 1024) {
            f();
            return true;
        }
        return true;
    }

    private void a(String str) {
        this.i.a(str);
        if (this.i.a() >= c().d()) {
            a();
        }
    }

    private boolean b(File file) {
        if (file == null) {
            return false;
        }
        String name = file.getName();
        SLog.d("FileTracer", "name=" + name);
        if (TextUtils.isEmpty(name) || name.length() != 47 || !name.startsWith("com.tencent.mobileqq_connectSdk.") || !name.endsWith(".log")) {
            return false;
        }
        return true;
    }

    private void a(File file) {
        File[] listFiles;
        long j;
        File parentFile = file.getParentFile();
        if (parentFile == null || !parentFile.exists() || !parentFile.isDirectory() || (listFiles = parentFile.listFiles()) == null) {
            return;
        }
        for (File file2 : listFiles) {
            if (b(file2)) {
                String name = file2.getName();
                String substring = name.substring(32, 43);
                long currentTimeMillis = System.currentTimeMillis();
                if (Tencent.USE_ONE_HOUR) {
                    j = 3600000;
                } else {
                    j = 259200000;
                }
                if (b.a(currentTimeMillis - j).compareTo(substring) > 0) {
                    SLog.d("FileTracer", "delete name=" + name + ", success=" + file2.delete());
                }
            }
        }
    }

    public a(int i, boolean z, g gVar, b bVar) {
        super(i, z, gVar);
        this.k = false;
        a(bVar);
        this.g = new f();
        this.h = new f();
        this.i = this.g;
        this.j = this.h;
        this.f = new char[bVar.d()];
        HandlerThread handlerThread = new HandlerThread(bVar.c(), bVar.f());
        this.l = handlerThread;
        handlerThread.start();
        if (this.l.isAlive() && this.l.getLooper() != null) {
            this.m = new HandlerDelegate(this.l.getLooper(), this);
        }
    }

    @Override // com.tencent.open.log.Tracer
    protected void doTrace(int i, Thread thread, long j, String str, String str2, Throwable th) {
        a(e().a(i, thread, j, str, str2, th));
    }
}
