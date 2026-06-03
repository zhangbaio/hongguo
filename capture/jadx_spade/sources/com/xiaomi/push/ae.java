package com.xiaomi.push;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bytedance.covode.number.Covode;
import com.ss.android.ugc.bytex.taskmonitor.proxy.HandlerDelegate;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class ae {
    private int a;

    /* renamed from: a, reason: collision with other field name */
    private Handler f91a;

    /* renamed from: a, reason: collision with other field name */
    private a f92a;

    /* renamed from: a, reason: collision with other field name */
    private volatile b f93a;

    /* renamed from: a, reason: collision with other field name */
    private volatile boolean f94a;
    private final boolean b;

    public static abstract class b {
        static {
            Covode.recordClassIndex(655335);
        }

        public void a() {
        }

        public abstract void b();

        /* renamed from: c */
        public void mo269c() {
        }
    }

    static {
        Covode.recordClassIndex(655333);
    }

    public ae() {
        this(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a() {
        this.f92a = null;
        this.f94a = true;
    }

    private class a extends Thread {

        /* renamed from: a, reason: collision with other field name */
        private final LinkedBlockingQueue<b> f96a;

        static {
            Covode.recordClassIndex(655334);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            long j;
            if (ae.this.a > 0) {
                j = ae.this.a;
            } else {
                j = Long.MAX_VALUE;
            }
            while (!ae.this.f94a) {
                try {
                    b poll = this.f96a.poll(j, TimeUnit.SECONDS);
                    ae.this.f93a = poll;
                    if (poll != null) {
                        a(0, poll);
                        poll.b();
                        a(1, poll);
                    } else if (ae.this.a > 0) {
                        ae.this.a();
                    }
                } catch (InterruptedException e) {
                    com.xiaomi.channel.commonutils.logger.b.a(e);
                }
            }
        }

        public a() {
            super("PackageProcessor");
            this.f96a = new LinkedBlockingQueue<>();
        }

        public void a(b bVar) {
            try {
                this.f96a.add(bVar);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        private void a(int i, b bVar) {
            try {
                ae.this.f91a.sendMessage(ae.this.f91a.obtainMessage(i, bVar));
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
            }
        }
    }

    public ae(boolean z) {
        this(z, 0);
    }

    public synchronized void a(b bVar) {
        if (this.f92a == null) {
            a aVar = new a();
            this.f92a = aVar;
            aVar.setDaemon(this.b);
            this.f94a = false;
            this.f92a.start();
        }
        this.f92a.a(bVar);
    }

    public ae(boolean z, int i) {
        this.f91a = null;
        this.f94a = false;
        this.a = 0;
        this.f91a = new HandlerDelegate(Looper.getMainLooper()) { // from class: com.xiaomi.push.ae.1
            /* JADX WARN: Multi-variable type inference failed */
            public void handleMessage(Message message) {
                b bVar = (b) message.obj;
                int i2 = message.what;
                if (i2 == 0) {
                    bVar.a();
                } else if (i2 == 1) {
                    bVar.mo269c();
                }
                super/*android.os.Handler*/.handleMessage(message);
            }
        };
        this.b = z;
        this.a = i;
    }

    public void a(final b bVar, long j) {
        this.f91a.postDelayed(new Runnable() { // from class: com.xiaomi.push.ae.2
            @Override // java.lang.Runnable
            public void run() {
                ae.this.a(bVar);
            }
        }, j);
    }
}
