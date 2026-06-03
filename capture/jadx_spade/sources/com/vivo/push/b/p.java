package com.vivo.push.b;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.vivo.push.model.InsideNotificationItem;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class p extends com.vivo.push.v {
    private String a;
    private String b;
    private byte[] c;
    private long d;
    private InsideNotificationItem e;
    private String f;
    private String g;
    private Uri h;
    private String i;
    private Bundle j;

    static {
        Covode.recordClassIndex(654997);
    }

    @Override // com.vivo.push.v
    public final String toString() {
        return "OnNotificationClickCommand";
    }

    public final String e() {
        return this.a;
    }

    public final long f() {
        return this.d;
    }

    public final InsideNotificationItem g() {
        return this.e;
    }

    public final String h() {
        return this.f;
    }

    public final String i() {
        return this.g;
    }

    public final String j() {
        return this.i;
    }

    public final Uri k() {
        return this.h;
    }

    public p() {
        super(5);
    }

    public final Bundle l() {
        if (this.j == null) {
            return null;
        }
        Bundle bundle = new Bundle(this.j);
        try {
            bundle.remove("command_type");
            bundle.remove("security_avoid_pull");
            bundle.remove("security_avoid_pull_rsa");
            bundle.remove("security_avoid_rsa_public_key");
            bundle.remove("security_avoid_rsa_public_key");
            bundle.remove("notify_action");
            bundle.remove("notify_componet_pkg");
            bundle.remove("notify_componet_class_name");
            bundle.remove("notification_v1");
            bundle.remove("command");
            bundle.remove("package_name");
            bundle.remove("method");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bundle;
    }

    public final void a(Uri uri) {
        this.h = uri;
    }

    public final void b(String str) {
        this.f = str;
    }

    public final void c(String str) {
        this.g = str;
    }

    public final void d(String str) {
        this.i = str;
    }

    private static Uri e(String str) {
        try {
            return Uri.parse(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.vivo.push.v
    protected final void c(com.vivo.push.d dVar) {
        dVar.a("package_name", this.a);
        dVar.a("notify_id", this.d);
        dVar.a("notification_v1", com.vivo.push.util.u.b(this.e));
        dVar.a("open_pkg_name", this.b);
        dVar.a("open_pkg_name_encode", this.c);
        dVar.a("notify_action", this.f);
        dVar.a("notify_componet_pkg", this.g);
        dVar.a("notify_componet_class_name", this.i);
        Uri uri = this.h;
        if (uri != null) {
            dVar.a("notify_uri_data", uri.toString());
        }
    }

    @Override // com.vivo.push.v
    protected final void d(com.vivo.push.d dVar) {
        this.a = dVar.a("package_name");
        this.d = dVar.b("notify_id", -1L);
        this.b = dVar.a("open_pkg_name");
        this.c = dVar.b("open_pkg_name_encode");
        this.f = dVar.a("notify_action");
        this.g = dVar.a("notify_componet_pkg");
        this.i = dVar.a("notify_componet_class_name");
        String a = dVar.a("notification_v1");
        if (!TextUtils.isEmpty(a)) {
            this.e = com.vivo.push.util.u.a(a);
        }
        InsideNotificationItem insideNotificationItem = this.e;
        if (insideNotificationItem != null) {
            insideNotificationItem.setMsgId(this.d);
        }
        String a2 = dVar.a("notify_uri_data");
        if (!TextUtils.isEmpty(a2)) {
            this.h = e(a2);
        }
        this.j = dVar.b();
    }

    public p(String str, long j, InsideNotificationItem insideNotificationItem) {
        super(5);
        this.a = str;
        this.d = j;
        this.e = insideNotificationItem;
    }
}
