package com.vivo.push.c;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.bytedance.helios.statichook.api.ExtraInfo;
import com.bytedance.helios.statichook.api.HeliosApiHook;
import com.bytedance.helios.statichook.api.Result;
import com.vivo.push.util.t;
import java.util.HashMap;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class a {
    private Context a;
    private HashMap<String, String> b = new HashMap<>();

    static {
        Covode.recordClassIndex(655009);
    }

    private static Cursor com_vivo_push_c_a_android_content_ContentResolver_query(ContentResolver contentResolver, Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        Result preInvoke = new HeliosApiHook().preInvoke(240004, "android/content/ContentResolver", "query", contentResolver, new Object[]{uri, strArr, str, strArr2, str2}, "android.database.Cursor", new ExtraInfo(false, "(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;"));
        return preInvoke.isIntercept() ? (Cursor) preInvoke.getReturnValue() : contentResolver.query(uri, strArr, str, strArr2, str2);
    }

    public final int a() {
        int b = b(1);
        t.d("CoreConfigManager", "isSupportNewControlStrategies : ".concat(String.valueOf(b)));
        return b;
    }

    public final int b() {
        int b = b(4);
        t.d("CoreConfigManager", "isSupportSyncProfileInfo : ".concat(String.valueOf(b)));
        return b;
    }

    public final boolean c() {
        int b = b(8);
        t.d("CoreConfigManager", "isSupportdeleteRegid : ".concat(String.valueOf(b)));
        if (b == 0) {
            return true;
        }
        return false;
    }

    public final boolean d() {
        int b = b(16);
        t.d("CoreConfigManager", "isSupportQueryCurrentAppState : ".concat(String.valueOf(b)));
        if (b == 0) {
            return true;
        }
        return false;
    }

    public final boolean e() {
        int b = b(32);
        t.d("CoreConfigManager", "isSupportCreateNotifyChannel : ".concat(String.valueOf(b)));
        if (b == 0) {
            return true;
        }
        return false;
    }

    public final boolean f() {
        int b = b(128);
        t.d("CoreConfigManager", "isSupportAliasSubscribeCheck : ".concat(String.valueOf(b)));
        if (b == 0) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00c4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v3, types: [android.content.ContentProviderClient, android.database.Cursor] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int g() {
        /*
            Method dump skipped, instructions count: 216
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.push.c.a.g():int");
    }

    public a(Context context) {
        this.a = context;
    }

    private int b(int i) {
        int g = g();
        if (g != 0) {
            return g;
        }
        HashMap<String, String> hashMap = this.b;
        if (hashMap != null && hashMap.size() != 0) {
            String str = this.b.get("pushSupport");
            if (!TextUtils.isEmpty(str)) {
                try {
                    if ((i & Integer.parseInt(str)) > 0) {
                        return 0;
                    }
                    return 1;
                } catch (Exception unused) {
                    return 8007;
                }
            }
            return 2;
        }
        return 8006;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x003f, code lost:
    
        if (r10 != 4096) goto L39;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean a(int r10) {
        /*
            r9 = this;
            int r0 = r9.b(r10)
            r1 = 1
            if (r0 != 0) goto L8
            return r1
        L8:
            r0 = 2048(0x800, float:2.87E-42)
            r2 = 1024(0x400, float:1.435E-42)
            r3 = 4096(0x1000, float:5.74E-42)
            r4 = 512(0x200, float:7.17E-43)
            r5 = 256(0x100, float:3.59E-43)
            r6 = 0
            if (r10 == r5) goto L20
            if (r10 == r4) goto L20
            if (r10 == r3) goto L20
            if (r10 == r2) goto L20
            if (r10 != r0) goto L1e
            goto L20
        L1e:
            r7 = 0
            goto L21
        L20:
            r7 = 1
        L21:
            if (r7 == 0) goto L61
            android.content.Context r7 = r9.a
            java.lang.String r7 = com.vivo.push.util.aa.a(r7)
            java.lang.String r8 = "com.vivo.pushservice"
            boolean r7 = r8.equals(r7)
            if (r7 == 0) goto L61
            android.content.Context r7 = r9.a
            long r7 = com.vivo.push.util.ah.a(r7)
            if (r10 == r5) goto L5a
            if (r10 == r4) goto L52
            if (r10 == r2) goto L4a
            if (r10 == r0) goto L42
            if (r10 == r3) goto L52
            goto L61
        L42:
            r2 = 4400(0x1130, double:2.174E-320)
            int r10 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r10 < 0) goto L49
            return r1
        L49:
            return r6
        L4a:
            r2 = 4200(0x1068, double:2.075E-320)
            int r10 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r10 < 0) goto L51
            return r1
        L51:
            return r6
        L52:
            r2 = 4100(0x1004, double:2.0257E-320)
            int r10 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r10 < 0) goto L59
            return r1
        L59:
            return r6
        L5a:
            r2 = 3700(0xe74, double:1.828E-320)
            int r10 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r10 < 0) goto L61
            return r1
        L61:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.push.c.a.a(int):boolean");
    }

    /* JADX WARN: Not initialized variable reg: 8, insn: 0x00b0: MOVE (r4 I:??[OBJECT, ARRAY]) = (r8 I:??[OBJECT, ARRAY]) (LINE:33947824), block:B:71:0x00af */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00a1 A[Catch: Exception -> 0x008e, TRY_ENTER, TryCatch #0 {Exception -> 0x008e, blocks: (B:29:0x0083, B:32:0x008a, B:40:0x00a1, B:42:0x00a6, B:44:0x00aa), top: B:2:0x0007 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String a(android.content.Context r15, java.lang.String r16) {
        /*
            Method dump skipped, instructions count: 199
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.push.c.a.a(android.content.Context, java.lang.String):java.lang.String");
    }
}
