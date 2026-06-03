package com.xiaomi.push;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.SystemClock;
import com.bytedance.covode.number.Covode;
import com.xiaomi.push.dy;
import com.xiaomi.push.service.XMJobService;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class ea implements dy.a {
    JobScheduler a;

    /* renamed from: a, reason: collision with other field name */
    Context f353a;

    /* renamed from: a, reason: collision with other field name */
    private boolean f354a = false;

    static {
        Covode.recordClassIndex(655478);
    }

    @Override // com.xiaomi.push.dy.a
    /* renamed from: a */
    public boolean mo376a() {
        return this.f354a;
    }

    @Override // com.xiaomi.push.dy.a
    public void a() {
        this.f354a = false;
        this.a.cancel(1);
    }

    ea(Context context) {
        this.f353a = context;
        this.a = (JobScheduler) context.getSystemService("jobscheduler");
    }

    @Override // com.xiaomi.push.dy.a
    public void a(boolean z) {
        if (!z && !this.f354a) {
            return;
        }
        long b = ff.b();
        if (z) {
            a();
            b -= SystemClock.elapsedRealtime() % b;
        }
        this.f354a = true;
        a(b);
    }

    void a(long j) {
        JobInfo.Builder builder = new JobInfo.Builder(1, new ComponentName(this.f353a.getPackageName(), XMJobService.class.getName()));
        builder.setMinimumLatency(j);
        builder.setOverrideDeadline(j);
        builder.setRequiredNetworkType(1);
        com.xiaomi.channel.commonutils.logger.b.c("schedule Job = " + builder.build().getId() + " in " + j);
        this.a.schedule(builder.build());
    }
}
