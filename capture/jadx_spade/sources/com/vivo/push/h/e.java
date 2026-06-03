package com.vivo.push.h;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.vivo.push.model.InsideNotificationItem;
import com.vivo.push.model.UPSNotificationMessage;
import com.vivo.push.util.NotifyAdapterUtil;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class e extends ab {
    static {
        Covode.recordClassIndex(655058);
    }

    e(com.vivo.push.v vVar) {
        super(vVar);
    }

    private void a(UPSNotificationMessage uPSNotificationMessage) {
        com.vivo.push.t.b(new g(this, uPSNotificationMessage));
    }

    @Override // com.vivo.push.s
    protected final void a(com.vivo.push.v vVar) {
        Intent parseUri;
        String str;
        String packageName;
        com.vivo.push.b.p pVar = (com.vivo.push.b.p) vVar;
        InsideNotificationItem g = pVar.g();
        if (g == null) {
            com.vivo.push.util.t.d("NotifyOpenClientTask", "current notification item is null");
            return;
        }
        UPSNotificationMessage a = com.vivo.push.util.u.a(g);
        boolean equals = this.a.getPackageName().equals(pVar.e());
        if (equals) {
            NotifyAdapterUtil.cancelNotify(this.a);
        }
        if (equals) {
            com.vivo.push.b.y yVar = new com.vivo.push.b.y(1030L);
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("type", "2");
            hashMap.put("messageID", String.valueOf(pVar.f()));
            hashMap.put("platform", this.a.getPackageName());
            String a2 = com.vivo.push.restructure.a.a().e().a();
            if (!TextUtils.isEmpty(a2)) {
                hashMap.put("remoteAppId", a2);
            }
            yVar.a(hashMap);
            com.vivo.push.m.a().a(yVar);
            com.vivo.push.util.t.d("NotifyOpenClientTask", "notification is clicked by skip type[" + a.getSkipType() + "]");
            int skipType = a.getSkipType();
            boolean z = true;
            if (skipType != 1) {
                if (skipType != 2) {
                    if (skipType != 3) {
                        if (skipType != 4) {
                            com.vivo.push.util.t.a("NotifyOpenClientTask", "illegitmacy skip type error : " + a.getSkipType());
                            return;
                        }
                        String skipContent = a.getSkipContent();
                        try {
                            parseUri = Intent.parseUri(skipContent, 1);
                            str = parseUri.getPackage();
                        } catch (Exception e) {
                            com.vivo.push.util.t.a("NotifyOpenClientTask", "open activity error : ".concat(String.valueOf(skipContent)), e);
                        }
                        if (!TextUtils.isEmpty(str) && !this.a.getPackageName().equals(str)) {
                            com.vivo.push.util.t.a("NotifyOpenClientTask", "open activity error : local pkgName is " + this.a.getPackageName() + "; but remote pkgName is " + parseUri.getPackage());
                            return;
                        }
                        if (parseUri.getComponent() == null) {
                            packageName = null;
                        } else {
                            packageName = parseUri.getComponent().getPackageName();
                        }
                        if (!TextUtils.isEmpty(packageName) && !this.a.getPackageName().equals(packageName)) {
                            com.vivo.push.util.t.a("NotifyOpenClientTask", "open activity component error : local pkgName is " + this.a.getPackageName() + "; but remote pkgName is " + parseUri.getPackage());
                            return;
                        }
                        parseUri.setSelector(null);
                        parseUri.setPackage(this.a.getPackageName());
                        parseUri.addFlags(335544320);
                        b(parseUri, a.getParams());
                        ActivityInfo resolveActivityInfo = parseUri.resolveActivityInfo(this.a.getPackageManager(), 65536);
                        if (resolveActivityInfo != null && !resolveActivityInfo.exported) {
                            com.vivo.push.util.t.a("NotifyOpenClientTask", "activity is not exported : " + resolveActivityInfo.toString());
                            return;
                        } else {
                            this.a.startActivity(parseUri);
                            a(a);
                            return;
                        }
                    }
                    a(a);
                    return;
                }
                String skipContent2 = a.getSkipContent();
                if (!skipContent2.startsWith("http://") && !skipContent2.startsWith("https://")) {
                    z = false;
                }
                if (z) {
                    Uri parse = Uri.parse(skipContent2);
                    Intent intent = new Intent("android.intent.action.VIEW", parse);
                    intent.setFlags(268435456);
                    b(intent, a.getParams());
                    try {
                        this.a.startActivity(intent);
                    } catch (Exception unused) {
                        com.vivo.push.util.t.a("NotifyOpenClientTask", "startActivity error : ".concat(String.valueOf(parse)));
                    }
                } else {
                    com.vivo.push.util.t.a("NotifyOpenClientTask", "url not legal");
                }
                a(a);
                return;
            }
            new Thread(new f(this, this.a, a.getParams())).start();
            a(a);
            return;
        }
        com.vivo.push.util.t.a("NotifyOpenClientTask", "notify is " + a + " ; isMatch is " + equals);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Intent b(Intent intent, Map<String, String> map) {
        if (map != null && map.entrySet() != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (entry != null && entry.getKey() != null) {
                    intent.putExtra(entry.getKey(), entry.getValue());
                }
            }
        }
        return intent;
    }
}
