package com.xiaomi.push.service;

import android.app.NotificationChannel;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bytedance.covode.number.Covode;
import com.xiaomi.push.service.ag;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class f {
    private static final SparseArray<ag.a<String, String, String>> a;

    /* renamed from: a, reason: collision with other field name */
    private static final int[] f977a;
    private static final SparseArray<Integer> b;

    private static boolean a(int i, int i2) {
        return i >= 4 || (i2 & 2) > 0 || (i2 & 1) > 0 || (i2 & 8) > 0 || (i2 & 16) > 0;
    }

    static void a(String str, String str2, int i, int i2) {
        for (int i3 : f977a) {
            if ((b.get(i3).intValue() & i2) == 0) {
                a(str, str2, i3, (i & i3) > 0);
            } else {
                com.xiaomi.channel.commonutils.logger.b.m54a("ChannelPermissions.grantPermission:" + str + ":" + str2 + ": <" + i3 + "> :stoped by userLock");
            }
        }
    }

    private static void a(String str, String str2, int i, boolean z) {
        com.xiaomi.channel.commonutils.logger.b.m54a("ChannelPermissions.grantPermission:" + str + ":" + str2 + ": <" + i + "=" + z + "> :" + ag.a(com.xiaomi.push.q.m640a(), str, str2, a.get(i), z));
    }

    /* renamed from: a, reason: collision with other method in class */
    private static boolean m720a(String str, String str2, int i) {
        boolean z = ag.a(com.xiaomi.push.q.m640a(), str, str2, a.get(i)) == 1;
        com.xiaomi.channel.commonutils.logger.b.m54a("ChannelPermissions.checkPermission:" + str + ":" + str2 + ": <" + i + "=" + z + ">");
        return z;
    }

    private static void a(SharedPreferences sharedPreferences, int i, String str, String str2, int i2) {
        if (sharedPreferences.getInt(str2, 0) != i) {
            a(str, str2, i, i2);
        }
    }

    private static void a(SharedPreferences sharedPreferences, String str) {
        a(sharedPreferences, new ArrayList<String>(str) { // from class: com.xiaomi.push.service.f.3
            final /* synthetic */ String a;

            {
                this.a = str;
                add(str);
            }
        });
    }

    private static void a(SharedPreferences sharedPreferences, List<String> list) {
        SharedPreferences.Editor edit = sharedPreferences.edit();
        Iterator<String> it2 = list.iterator();
        while (it2.hasNext()) {
            edit.remove(it2.next());
        }
        edit.commit();
    }

    static {
        Covode.recordClassIndex(655712);
        int i = 5;
        f977a = new int[]{1, 2, 4, 8, 16};
        a = new SparseArray<ag.a<String, String, String>>(i) { // from class: com.xiaomi.push.service.f.1
            {
                put(1, ag.b);
                put(2, ag.c);
                put(4, ag.d);
                put(8, ag.f);
                put(16, ag.e);
            }
        };
        b = new SparseArray<Integer>(i) { // from class: com.xiaomi.push.service.f.2
            {
                put(1, 32);
                put(2, 16);
                put(4, 8);
                put(8, 4);
                put(16, 2);
            }
        };
    }

    private static SharedPreferences a(Context context) {
        return context.getSharedPreferences("ch_permission_cache_file", 0);
    }

    /* renamed from: a, reason: collision with other method in class */
    public static Bundle m719a(String str, String str2) {
        return ag.a(com.xiaomi.push.q.m640a(), str, str2);
    }

    static int a(String str, String str2) {
        int i = 8;
        if (!m720a(str, str2, 8)) {
            i = 0;
        }
        if (m720a(str, str2, 16)) {
            i |= 16;
        }
        if (m720a(str, str2, 1)) {
            i |= 1;
        }
        if (m720a(str, str2, 2)) {
            i |= 2;
        }
        if (m720a(str, str2, 4)) {
            return i | 4;
        }
        return i;
    }

    static void a(Context context, String str) {
        List<NotificationChannel> m689a;
        if (com.xiaomi.push.j.m631a(context) && !TextUtils.isEmpty(str) && (m689a = af.a(context, str).m689a()) != null) {
            synchronized (f.class) {
                SharedPreferences a2 = a(context);
                ArrayList arrayList = new ArrayList();
                Iterator<NotificationChannel> it2 = m689a.iterator();
                while (it2.hasNext()) {
                    String str2 = (String) com.xiaomi.push.av.a(it2.next(), "mId");
                    if (!TextUtils.isEmpty(str2) && a2.contains(str2)) {
                        arrayList.add(str2);
                    }
                }
                if (arrayList.size() > 0) {
                    a(a2, arrayList);
                }
            }
        }
    }

    public static int a(String str, String str2, int i) {
        return ag.a(com.xiaomi.push.q.m640a(), str, str2, a.get(i));
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0040, code lost:
    
        if (r1 == 0) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int a(android.content.Context r3, java.lang.String r4, java.lang.String r5) {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 26
            r2 = 0
            if (r0 < r1) goto L67
            if (r3 == 0) goto L67
            boolean r0 = android.text.TextUtils.isEmpty(r4)
            if (r0 != 0) goto L67
            com.xiaomi.push.service.af r3 = com.xiaomi.push.service.af.a(r3, r4)
            if (r3 == 0) goto L61
            java.lang.String r5 = r3.m688a(r5)
            android.app.NotificationChannel r3 = r3.m685a(r5)
            if (r3 == 0) goto L5b
            int r5 = r3.getImportance()
            r0 = 1
            if (r5 == 0) goto L28
            r5 = 1
            goto L29
        L28:
            r5 = 2
        L29:
            r5 = r5 | r2
            java.lang.String r1 = r3.getId()
            r2 = 8
            int r1 = a(r4, r1, r2)
            if (r1 != r0) goto L40
            int r1 = r3.getImportance()
            r2 = 4
            if (r1 < r2) goto L42
            r5 = r5 | 4
            goto L44
        L40:
            if (r1 != 0) goto L44
        L42:
            r5 = r5 | 8
        L44:
            java.lang.String r3 = r3.getId()
            r1 = 16
            int r3 = a(r4, r3, r1)
            if (r3 != r0) goto L54
            r3 = r5 | 16
        L52:
            r2 = r3
            goto L6c
        L54:
            if (r3 != 0) goto L59
            r3 = r5 | 32
            goto L52
        L59:
            r2 = r5
            goto L6c
        L5b:
            java.lang.String r3 = "Channel must not be null"
            com.xiaomi.channel.commonutils.logger.b.m54a(r3)
            goto L6c
        L61:
            java.lang.String r3 = "create NMHelper error"
            com.xiaomi.channel.commonutils.logger.b.m54a(r3)
            goto L6c
        L67:
            java.lang.String r3 = "Must greater than or equal android O and context|packageName not be null"
            com.xiaomi.channel.commonutils.logger.b.m54a(r3)
        L6c:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.f.a(android.content.Context, java.lang.String, java.lang.String):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:48:0x007d, code lost:
    
        if (r1 == 0) goto L36;
     */
    /* JADX WARN: Removed duplicated region for block: B:44:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x008e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int a(android.content.Context r5, java.lang.String r6, android.app.NotificationChannel r7) {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 26
            r2 = 0
            if (r0 < r1) goto Lab
            if (r5 == 0) goto Lab
            boolean r5 = android.text.TextUtils.isEmpty(r6)
            if (r5 != 0) goto Lab
            if (r7 == 0) goto Lab
            int r5 = r7.getImportance()
            r0 = 1
            if (r5 == 0) goto L1a
            r5 = 1
            goto L1b
        L1a:
            r5 = 2
        L1b:
            r5 = r5 | r2
            boolean r1 = com.xiaomi.push.service.ag.a()
            r2 = 16
            r3 = 4
            r4 = 8
            if (r1 == 0) goto L6a
            java.lang.String r0 = r7.getId()
            android.os.Bundle r6 = m719a(r6, r0)
            com.xiaomi.push.service.ag$a<java.lang.String, java.lang.String, java.lang.String> r0 = com.xiaomi.push.service.ag.f
            T r1 = r0.c
            java.lang.String r1 = (java.lang.String) r1
            boolean r1 = r6.containsKey(r1)
            if (r1 == 0) goto L4f
            T r0 = r0.c
            java.lang.String r0 = (java.lang.String) r0
            boolean r0 = r6.getBoolean(r0)
            if (r0 == 0) goto L4c
            int r0 = r7.getImportance()
            if (r0 < r3) goto L4c
            goto L4e
        L4c:
            r3 = 8
        L4e:
            r5 = r5 | r3
        L4f:
            com.xiaomi.push.service.ag$a<java.lang.String, java.lang.String, java.lang.String> r0 = com.xiaomi.push.service.ag.e
            T r1 = r0.c
            java.lang.String r1 = (java.lang.String) r1
            boolean r1 = r6.containsKey(r1)
            if (r1 == 0) goto L92
            T r0 = r0.c
            java.lang.String r0 = (java.lang.String) r0
            boolean r6 = r6.getBoolean(r0)
            if (r6 == 0) goto L66
            goto L68
        L66:
            r2 = 32
        L68:
            r5 = r5 | r2
            goto L92
        L6a:
            java.lang.String r1 = r7.getId()
            int r1 = a(r6, r1, r4)
            if (r1 != r0) goto L7d
            int r1 = r7.getImportance()
            if (r1 < r3) goto L7f
            r5 = r5 | 4
            goto L81
        L7d:
            if (r1 != 0) goto L81
        L7f:
            r5 = r5 | 8
        L81:
            java.lang.String r1 = r7.getId()
            int r6 = a(r6, r1, r2)
            if (r6 != r0) goto L8e
            r5 = r5 | 16
            goto L92
        L8e:
            if (r6 != 0) goto L92
            r5 = r5 | 32
        L92:
            android.net.Uri r6 = r7.getSound()
            if (r6 == 0) goto L9b
            r5 = r5 | 64
            goto L9d
        L9b:
            r5 = r5 | 128(0x80, float:1.8E-43)
        L9d:
            boolean r6 = r7.shouldVibrate()
            if (r6 == 0) goto La6
            r6 = 256(0x100, float:3.59E-43)
            goto La8
        La6:
            r6 = 512(0x200, float:7.17E-43)
        La8:
            r2 = r5 | r6
            goto Lb0
        Lab:
            java.lang.String r5 = "context|packageName|channel must not be null "
            com.xiaomi.channel.commonutils.logger.b.m54a(r5)
        Lb0:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.f.a(android.content.Context, java.lang.String, android.app.NotificationChannel):int");
    }

    private static void a(SharedPreferences sharedPreferences, int i, String str) {
        sharedPreferences.edit().putInt(str, i).commit();
    }

    static void a(Context context, String str, String str2, int i, String str3, boolean z, int i2) {
        if (com.xiaomi.push.j.m631a(context) && !TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
            int a2 = com.xiaomi.push.r.a(str3, 0);
            boolean a3 = a(i, a2);
            if (z) {
                a(str, str2, a2, i2);
                if (a3) {
                    synchronized (f.class) {
                        a(a(context), a2, str2);
                    }
                    return;
                }
                return;
            }
            synchronized (f.class) {
                SharedPreferences a4 = a(context);
                if (a3 || a4.contains(str2)) {
                    a(a4, a2, str, str2, i2);
                    if (a3) {
                        a(a4, a2, str2);
                    } else {
                        a(a4, str2);
                    }
                }
            }
            return;
        }
        if (com.xiaomi.push.j.m631a(context)) {
            com.xiaomi.channel.commonutils.logger.b.m54a("ChannelPC: can`t setup permission with permissionCode:" + String.valueOf(str3) + " channelId:" + String.valueOf(str2) + " targetPkg:" + str);
        }
    }
}
