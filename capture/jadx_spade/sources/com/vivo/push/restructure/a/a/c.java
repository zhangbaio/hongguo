package com.vivo.push.restructure.a.a;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Base64;
import com.bytedance.covode.number.Covode;
import com.vivo.push.util.aa;
import com.vivo.push.util.ab;
import com.vivo.push.util.ah;
import com.vivo.push.util.t;
import java.util.Arrays;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class c extends a<com.vivo.push.restructure.a.a> {
    private static final List<Integer> b;

    static {
        Covode.recordClassIndex(655108);
        b = Arrays.asList(3);
    }

    @Override // com.vivo.push.restructure.a.a.a
    protected final /* bridge */ /* synthetic */ int a(com.vivo.push.restructure.a.a aVar) {
        return a2(aVar);
    }

    private static boolean a(Intent intent) {
        try {
            String stringExtra = intent.getStringExtra("security_avoid_pull");
            if (!TextUtils.isEmpty(stringExtra)) {
                try {
                    String a = com.vivo.push.util.a.a(com.vivo.push.restructure.a.a().b()).a(stringExtra);
                    if (!"com.vivo.pushservice".equals(a)) {
                        t.a("CheckNode", "!decrypt.equals, so decrypt == ".concat(String.valueOf(a)));
                        return false;
                    }
                    return true;
                } catch (Exception e) {
                    t.a("CheckNode", "checkIntentIsSecurity Exception: " + e.getMessage());
                    return false;
                }
            }
            t.a("CheckNode", "checkIntentIsSecurityTextUtils.isEmpty");
            return true;
        } catch (Exception unused) {
            t.a("CheckNode", "getStringExtra error");
            return true;
        }
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static int a2(com.vivo.push.restructure.a.a aVar) {
        boolean z;
        try {
        } catch (Exception e) {
            t.a("CheckNode", e);
        }
        if (!com.vivo.push.restructure.a.a().e().m().isAgreePrivacyStatement()) {
            t.d("CheckNode", " checkNeedReportByPrivacyStatement is false  ");
            return 2809;
        }
        Intent b2 = aVar.b();
        String b3 = com.vivo.push.sdk.a.a().b();
        if (!TextUtils.isEmpty(b3) && b3.contains("CommandService")) {
            if (b2 != null && a(b2) && a(b2, aVar)) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                t.a("CheckNode", " !checkIntentIsSecurity(intent)");
                return 2801;
            }
        }
        Context b4 = com.vivo.push.restructure.a.a().b();
        String packageName = b4.getPackageName();
        String stringExtra = b2.getStringExtra("command_type");
        if (!TextUtils.isEmpty(stringExtra) && stringExtra.equals("reflect_receiver")) {
            int intExtra = b2.getIntExtra("command", -1);
            if (intExtra < 0) {
                intExtra = b2.getIntExtra("method", -1);
            }
            if (b.contains(Integer.valueOf(intExtra)) && aa.c(b4, packageName) && !aa.b(b4)) {
                t.a("CheckNode", "METHOD_ON_MESSAGE is not support");
                return 2803;
            }
            String action = b2.getAction();
            if (TextUtils.isEmpty(com.vivo.push.restructure.a.a().e().a(b4, action))) {
                t.d("CheckNode", " reflectReceiver error: receiver for: " + action + " not found, package: " + packageName);
                b2.setPackage(packageName);
                b4.sendBroadcast(b2);
                return 2802;
            }
            return 0;
        }
        t.a("CheckNode", "commandTypeStr is not satisfy == ".concat(String.valueOf(stringExtra)));
        return 2801;
    }

    public c(com.vivo.push.restructure.a.a aVar, j jVar) {
        super("CheckNode", aVar, jVar);
    }

    private static boolean a(Intent intent, com.vivo.push.restructure.a.a aVar) {
        boolean z;
        boolean k;
        try {
            Context b2 = com.vivo.push.restructure.a.a().b();
            String b3 = ah.b(b2, "com.vivo.pushservice");
            t.d("CheckNode", " 配置的验签参数 = ".concat(String.valueOf(b3)));
            if (!TextUtils.equals(b3, "1")) {
                return true;
            }
            String stringExtra = intent.getStringExtra("security_avoid_pull_rsa");
            String stringExtra2 = intent.getStringExtra("security_avoid_rsa_public_key");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                if (com.vivo.push.g.b.a().a(b2).a("com.vivo.pushservice".getBytes("UTF-8"), ab.a(stringExtra2), Base64.decode(stringExtra, 2))) {
                    t.d("CheckNode", " RSA验签通过  ");
                    return true;
                }
                StringBuilder sb = new StringBuilder(" 验签参数传入错误 securityContent = ");
                sb.append(stringExtra);
                sb.append(" publickKey= ");
                sb.append(stringExtra2);
                sb.append(" receivedMsg isempty? ");
                if (aVar == null) {
                    z = true;
                } else {
                    z = false;
                }
                sb.append(z);
                sb.append(" receivedMsg isClickMsg? ");
                if (aVar == null) {
                    k = false;
                } else {
                    k = aVar.k();
                }
                sb.append(k);
                t.c("CheckNode", sb.toString());
                if (aVar != null && aVar.k() && (TextUtils.equals(stringExtra, "com.vivo.pushservice") || TextUtils.equals(stringExtra2, "com.vivo.pushservice"))) {
                    return true;
                }
                t.d("CheckNode", " RSA验签 不通过  ");
                return false;
            }
            t.a("CheckNode", "!decrypt.equals, so securityContent == " + stringExtra + " or publickKey isempty ");
            return false;
        } catch (Exception e) {
            t.a("CheckNode", "checkIntentIsSecurity Exception: " + e.getMessage());
            return true;
        }
    }
}
