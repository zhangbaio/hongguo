package com.xiaomi.push;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.SystemClock;
import com.bytedance.covode.number.Covode;
import com.xiaomi.push.dy;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
class dz implements dy.a {

    /* renamed from: a, reason: collision with other field name */
    protected Context f352a;

    /* renamed from: a, reason: collision with other field name */
    private PendingIntent f351a = null;
    private volatile long a = 0;

    static {
        Covode.recordClassIndex(655476);
    }

    @Override // com.xiaomi.push.dy.a
    /* renamed from: a */
    public boolean mo376a() {
        if (this.a != 0) {
            return true;
        }
        return false;
    }

    @Override // com.xiaomi.push.dy.a
    public void a() {
        if (this.f351a != null) {
            try {
                ((AlarmManager) this.f352a.getSystemService("alarm")).cancel(this.f351a);
            } catch (Exception unused) {
            } catch (Throwable th) {
                this.f351a = null;
                com.xiaomi.channel.commonutils.logger.b.c("[Alarm] unregister timer");
                this.a = 0L;
                throw th;
            }
            this.f351a = null;
            com.xiaomi.channel.commonutils.logger.b.c("[Alarm] unregister timer");
            this.a = 0L;
        }
        this.a = 0L;
    }

    public dz(Context context) {
        this.f352a = null;
        this.f352a = context;
    }

    @Override // com.xiaomi.push.dy.a
    public void a(boolean z) {
        long m727a = com.xiaomi.push.service.m.a(this.f352a).m727a();
        if (!z && this.a == 0) {
            return;
        }
        if (z) {
            a();
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (!z && this.a != 0) {
            if (this.a <= elapsedRealtime) {
                this.a += m727a;
                if (this.a < elapsedRealtime) {
                    this.a = elapsedRealtime + m727a;
                }
            }
        } else {
            this.a = elapsedRealtime + (m727a - (elapsedRealtime % m727a));
        }
        Intent intent = new Intent(com.xiaomi.push.service.an.q);
        intent.setPackage(this.f352a.getPackageName());
        a(intent, this.a);
    }

    public void a(Intent intent, long j) {
        AlarmManager alarmManager = (AlarmManager) this.f352a.getSystemService("alarm");
        int i = Build.VERSION.SDK_INT;
        if (i >= 31) {
            this.f351a = INVOKESTATIC_com_xiaomi_push_dz_com_dragon_read_aop_target31_PendingIntentAop_getBroadcast(this.f352a, 0, intent, 33554432);
        } else {
            this.f351a = INVOKESTATIC_com_xiaomi_push_dz_com_dragon_read_aop_target31_PendingIntentAop_getBroadcast(this.f352a, 0, intent, 0);
        }
        if (i >= 31 && !j.m631a(this.f352a)) {
            alarmManager.set(2, j, this.f351a);
        } else if (i >= 23) {
            av.a((Object) alarmManager, "setExactAndAllowWhileIdle", 2, Long.valueOf(j), this.f351a);
        } else {
            a(alarmManager, j, this.f351a);
        }
        com.xiaomi.channel.commonutils.logger.b.c("[Alarm] register timer " + j);
    }

    private void a(AlarmManager alarmManager, long j, PendingIntent pendingIntent) {
        try {
            AlarmManager.class.getMethod("setExact", Integer.TYPE, Long.TYPE, PendingIntent.class).invoke(alarmManager, 2, Long.valueOf(j), pendingIntent);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.d("[Alarm] invoke setExact method meet error. " + e);
        }
    }

    @Proxy("getBroadcast")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.app.PendingIntent")
    public static PendingIntent INVOKESTATIC_com_xiaomi_push_dz_com_dragon_read_aop_target31_PendingIntentAop_getBroadcast(Context context, int i, Intent intent, int i2) {
        boolean z;
        if (Build.VERSION.SDK_INT >= 31) {
            boolean z2 = true;
            if ((67108864 & i2) != 0) {
                z = true;
            } else {
                z = false;
            }
            if ((i2 & 33554432) == 0) {
                z2 = false;
            }
            if (!z2 && !z) {
                i2 |= 33554432;
            }
        }
        return PendingIntent.getBroadcast(context, i, intent, i2);
    }
}
