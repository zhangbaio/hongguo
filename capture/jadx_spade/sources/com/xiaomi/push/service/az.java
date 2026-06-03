package com.xiaomi.push.service;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.xiaomi.push.gh;
import com.xiaomi.push.gi;
import com.xiaomi.push.go;
import com.xiaomi.push.hd;
import com.xiaomi.push.ho;
import java.text.SimpleDateFormat;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class az {
    private static String a;

    /* renamed from: a, reason: collision with other field name */
    private static SimpleDateFormat f961a;

    /* renamed from: a, reason: collision with other field name */
    private static AtomicLong f962a;

    static {
        Covode.recordClassIndex(655702);
        f962a = new AtomicLong(0L);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        f961a = simpleDateFormat;
        a = simpleDateFormat.format(Long.valueOf(System.currentTimeMillis()));
    }

    public static synchronized String a() {
        String str;
        synchronized (az.class) {
            String format = f961a.format(Long.valueOf(System.currentTimeMillis()));
            if (!TextUtils.equals(a, format)) {
                f962a.set(0L);
                a = format;
            }
            str = format + "-" + f962a.incrementAndGet();
        }
        return str;
    }

    public static boolean a(String str) {
        if (com.xiaomi.push.q.m644b() && !"com.miui.hybrid".equals(str)) {
            return false;
        }
        return true;
    }

    public static boolean a(gi giVar, boolean z) {
        if (giVar == null) {
            com.xiaomi.channel.commonutils.logger.b.m54a("item is null, verfiy ClientUploadDataItem failed.");
            return true;
        }
        if (!z && TextUtils.isEmpty(giVar.f501a)) {
            com.xiaomi.channel.commonutils.logger.b.m54a("item.channel is null or empty, verfiy ClientUploadDataItem failed.");
            return true;
        }
        if (TextUtils.isEmpty(giVar.f508d)) {
            com.xiaomi.channel.commonutils.logger.b.m54a("item.category is null or empty, verfiy ClientUploadDataItem failed.");
            return true;
        }
        if (TextUtils.isEmpty(giVar.f507c)) {
            com.xiaomi.channel.commonutils.logger.b.m54a("item.name is null or empty, verfiy ClientUploadDataItem failed.");
            return true;
        }
        if (!com.xiaomi.push.ba.m181a(giVar.f508d)) {
            com.xiaomi.channel.commonutils.logger.b.m54a("item.category can only contain ascii char, verfiy ClientUploadDataItem failed.");
            return true;
        }
        if (!com.xiaomi.push.ba.m181a(giVar.f507c)) {
            com.xiaomi.channel.commonutils.logger.b.m54a("item.name can only contain ascii char, verfiy ClientUploadDataItem failed.");
            return true;
        }
        String str = giVar.f506b;
        if (str != null && str.length() > 30720) {
            com.xiaomi.channel.commonutils.logger.b.m54a("item.data is too large(" + giVar.f506b.length() + "), max size for data is 30720 , verfiy ClientUploadDataItem failed.");
            return true;
        }
        return false;
    }

    private static hd a(String str, String str2, gh ghVar) {
        return new hd("-1", false).d(str).b(str2).a(com.xiaomi.push.v.a(ho.a(ghVar))).c(go.UploadTinyData.f529a);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x006a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.ArrayList<com.xiaomi.push.hd> a(java.util.List<com.xiaomi.push.gi> r11, java.lang.String r12, java.lang.String r13, int r14) {
        /*
            r0 = 0
            if (r11 != 0) goto L9
            java.lang.String r11 = "requests can not be null in TinyDataHelper.transToThriftObj()."
            com.xiaomi.channel.commonutils.logger.b.d(r11)
            return r0
        L9:
            int r1 = r11.size()
            if (r1 != 0) goto L15
            java.lang.String r11 = "requests.length is 0 in TinyDataHelper.transToThriftObj()."
            com.xiaomi.channel.commonutils.logger.b.d(r11)
            return r0
        L15:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            com.xiaomi.push.gh r2 = new com.xiaomi.push.gh
            r2.<init>()
            r3 = 0
            r4 = 0
            r5 = 0
        L22:
            int r6 = r11.size()
            if (r4 >= r6) goto Lae
            java.lang.Object r6 = r11.get(r4)
            com.xiaomi.push.gi r6 = (com.xiaomi.push.gi) r6
            if (r6 != 0) goto L32
            goto Laa
        L32:
            java.util.Map r7 = r6.m468a()
            if (r7 == 0) goto L72
            java.util.Map r7 = r6.m468a()
            java.lang.String r8 = "item_size"
            boolean r7 = r7.containsKey(r8)
            if (r7 == 0) goto L72
            java.util.Map r7 = r6.m468a()
            java.lang.Object r7 = r7.get(r8)
            java.lang.String r7 = (java.lang.String) r7
            boolean r9 = android.text.TextUtils.isEmpty(r7)
            if (r9 != 0) goto L5a
            int r7 = java.lang.Integer.parseInt(r7)     // Catch: java.lang.Exception -> L59
            goto L5b
        L59:
        L5a:
            r7 = 0
        L5b:
            java.util.Map r9 = r6.m468a()
            int r9 = r9.size()
            r10 = 1
            if (r9 != r10) goto L6a
            r6.a(r0)
            goto L73
        L6a:
            java.util.Map r9 = r6.m468a()
            r9.remove(r8)
            goto L73
        L72:
            r7 = 0
        L73:
            if (r7 > 0) goto L7a
            byte[] r7 = com.xiaomi.push.ho.a(r6)
            int r7 = r7.length
        L7a:
            if (r7 <= r14) goto L95
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "TinyData is too big, ignore upload request item:"
            r7.append(r8)
            java.lang.String r6 = r6.d()
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            com.xiaomi.channel.commonutils.logger.b.d(r6)
            goto Laa
        L95:
            int r8 = r5 + r7
            if (r8 <= r14) goto La6
            com.xiaomi.push.hd r2 = a(r12, r13, r2)
            r1.add(r2)
            com.xiaomi.push.gh r2 = new com.xiaomi.push.gh
            r2.<init>()
            r5 = 0
        La6:
            r2.a(r6)
            int r5 = r5 + r7
        Laa:
            int r4 = r4 + 1
            goto L22
        Lae:
            int r11 = r2.a()
            if (r11 == 0) goto Lbb
            com.xiaomi.push.hd r11 = a(r12, r13, r2)
            r1.add(r11)
        Lbb:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.az.a(java.util.List, java.lang.String, java.lang.String, int):java.util.ArrayList");
    }

    public static void a(Context context, String str, String str2, long j, String str3) {
        gi giVar = new gi();
        giVar.d(str);
        giVar.c(str2);
        giVar.a(j);
        giVar.b(str3);
        giVar.a("push_sdk_channel");
        giVar.g(context.getPackageName());
        giVar.e(context.getPackageName());
        giVar.a(true);
        giVar.b(System.currentTimeMillis());
        giVar.f(a());
        ba.a(context, giVar);
    }
}
