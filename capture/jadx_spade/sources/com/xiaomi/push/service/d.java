package com.xiaomi.push.service;

import android.app.Notification;
import android.content.Context;
import android.os.SystemClock;
import android.service.notification.StatusBarNotification;
import com.bytedance.covode.number.Covode;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class d {
    private static List<a> a;

    static {
        Covode.recordClassIndex(655709);
        a = new CopyOnWriteArrayList();
    }

    private static void a() {
        for (int size = a.size() - 1; size >= 0; size--) {
            a aVar = a.get(size);
            if (SystemClock.elapsedRealtime() - aVar.f974a > 5000) {
                a.remove(aVar);
            }
        }
        if (a.size() > 10) {
            a.remove(0);
        }
    }

    private static void a(a aVar) {
        a.add(aVar);
        a();
    }

    protected static void a(Context context, StatusBarNotification statusBarNotification, int i) {
        if (com.xiaomi.push.j.m631a(context) && i > 0 && statusBarNotification != null) {
            a(new a(statusBarNotification.getKey(), SystemClock.elapsedRealtime(), i, ag.m694a(statusBarNotification.getNotification())));
        }
    }

    private static class a {
        public final int a;

        /* renamed from: a, reason: collision with other field name */
        public final long f974a;

        /* renamed from: a, reason: collision with other field name */
        public final String f975a;

        /* renamed from: a, reason: collision with other field name */
        public final Notification.Action[] f976a;

        static {
            Covode.recordClassIndex(655710);
        }

        a(String str, long j, int i, Notification.Action[] actionArr) {
            this.f975a = str;
            this.f974a = j;
            this.a = i;
            this.f976a = actionArr;
        }
    }
}
