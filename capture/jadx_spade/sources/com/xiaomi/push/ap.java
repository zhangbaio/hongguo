package com.xiaomi.push;

import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import com.bytedance.covode.number.Covode;
import com.bytedance.helios.statichook.api.ExtraInfo;
import com.bytedance.helios.statichook.api.HeliosApiHook;
import com.bytedance.helios.statichook.api.Result;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
class ap implements ah {
    private static String a;
    private static String b;
    private static String c;
    private static String d;
    private static String e;
    private static String f;

    /* renamed from: a, reason: collision with other field name */
    private Context f126a;

    private static Cursor com_xiaomi_push_ap_android_content_ContentResolver_query(ContentResolver contentResolver, Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        Result preInvoke = new HeliosApiHook().preInvoke(240004, "android/content/ContentResolver", "query", contentResolver, new Object[]{uri, strArr, str, strArr2, str2}, "android.database.Cursor", new ExtraInfo(false, "(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;"));
        return preInvoke.isIntercept() ? (Cursor) preInvoke.getReturnValue() : contentResolver.query(uri, strArr, str, strArr2, str2);
    }

    @Override // com.xiaomi.push.ah
    /* renamed from: a */
    public String mo140a() {
        return a(b);
    }

    @Override // com.xiaomi.push.ah
    /* renamed from: a */
    public boolean mo141a() {
        return "1".equals(p.a(f, "0"));
    }

    static {
        Covode.recordClassIndex(655352);
        a = "content://com.vivo.vms.IdProvider/IdentifierId/";
        b = a + "OAID";
        c = a + "VAID_";
        d = a + "AAID_";
        e = a + "OAIDSTATUS";
        f = "persist.sys.identifierid.supported";
    }

    public ap(Context context) {
        this.f126a = context;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x003c, code lost:
    
        if (r10 == null) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x002a, code lost:
    
        if (r10 != null) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x002c, code lost:
    
        r10.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x003f, code lost:
    
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.String a(java.lang.String r10) {
        /*
            r9 = this;
            r0 = 0
            android.content.Context r1 = r9.f126a     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L3a
            android.content.ContentResolver r2 = r1.getContentResolver()     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L3a
            android.net.Uri r3 = android.net.Uri.parse(r10)     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L3a
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r10 = com_xiaomi_push_ap_android_content_ContentResolver_query(r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L3a
            if (r10 == 0) goto L2a
            boolean r1 = r10.moveToNext()     // Catch: java.lang.Throwable -> L26 java.lang.Exception -> L28
            if (r1 == 0) goto L2a
            java.lang.String r1 = "value"
            int r1 = r10.getColumnIndex(r1)     // Catch: java.lang.Throwable -> L26 java.lang.Exception -> L28
            java.lang.String r0 = r10.getString(r1)     // Catch: java.lang.Throwable -> L26 java.lang.Exception -> L28
            goto L2a
        L26:
            r0 = move-exception
            goto L34
        L28:
            goto L3c
        L2a:
            if (r10 == 0) goto L3f
        L2c:
            r10.close()
            goto L3f
        L30:
            r10 = move-exception
            r8 = r0
            r0 = r10
            r10 = r8
        L34:
            if (r10 == 0) goto L39
            r10.close()
        L39:
            throw r0
        L3a:
            r10 = r0
        L3c:
            if (r10 == 0) goto L3f
            goto L2c
        L3f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.ap.a(java.lang.String):java.lang.String");
    }

    public static boolean a(Context context) {
        boolean z;
        try {
            ProviderInfo resolveContentProvider = context.getPackageManager().resolveContentProvider(Uri.parse(a).getAuthority(), 128);
            if (resolveContentProvider != null) {
                if ((resolveContentProvider.applicationInfo.flags & 1) != 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }
}
