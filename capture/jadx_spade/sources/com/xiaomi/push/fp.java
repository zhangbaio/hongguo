package com.xiaomi.push;

import android.os.Bundle;
import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class fp extends fn {
    private int a;

    /* renamed from: a, reason: collision with other field name */
    private a f465a;

    /* renamed from: a, reason: collision with other field name */
    private b f466a;
    private String b;

    static {
        Covode.recordClassIndex(655531);
    }

    @Override // com.xiaomi.push.fn
    public Bundle a() {
        Bundle a2 = super.a();
        b bVar = this.f466a;
        if (bVar != null) {
            a2.putString("ext_pres_type", bVar.toString());
        }
        String str = this.b;
        if (str != null) {
            a2.putString("ext_pres_status", str);
        }
        int i = this.a;
        if (i != Integer.MIN_VALUE) {
            a2.putInt("ext_pres_prio", i);
        }
        a aVar = this.f465a;
        if (aVar != null && aVar != a.available) {
            a2.putString("ext_pres_mode", aVar.toString());
        }
        return a2;
    }

    public enum a {
        chat,
        available,
        away,
        xa,
        dnd;

        static {
            Covode.recordClassIndex(655532);
        }
    }

    public enum b {
        available,
        unavailable,
        subscribe,
        subscribed,
        unsubscribe,
        unsubscribed,
        error,
        probe;

        static {
            Covode.recordClassIndex(655533);
        }
    }

    @Override // com.xiaomi.push.fn
    /* renamed from: a */
    public String mo435a() {
        StringBuilder sb = new StringBuilder();
        sb.append("<presence");
        if (p() != null) {
            sb.append(" xmlns=\"");
            sb.append(p());
            sb.append("\"");
        }
        if (j() != null) {
            sb.append(" id=\"");
            sb.append(j());
            sb.append("\"");
        }
        if (l() != null) {
            sb.append(" to=\"");
            sb.append(fw.a(l()));
            sb.append("\"");
        }
        if (m() != null) {
            sb.append(" from=\"");
            sb.append(fw.a(m()));
            sb.append("\"");
        }
        if (k() != null) {
            sb.append(" chid=\"");
            sb.append(fw.a(k()));
            sb.append("\"");
        }
        if (this.f466a != null) {
            sb.append(" type=\"");
            sb.append(this.f466a);
            sb.append("\"");
        }
        sb.append(">");
        if (this.b != null) {
            sb.append("<status>");
            sb.append(fw.a(this.b));
            sb.append("</status>");
        }
        if (this.a != Integer.MIN_VALUE) {
            sb.append("<priority>");
            sb.append(this.a);
            sb.append("</priority>");
        }
        a aVar = this.f465a;
        if (aVar != null && aVar != a.available) {
            sb.append("<show>");
            sb.append(this.f465a);
            sb.append("</show>");
        }
        sb.append(o());
        fr m436a = m436a();
        if (m436a != null) {
            sb.append(m436a.m439a());
        }
        sb.append("</presence>");
        return sb.toString();
    }

    public void a(a aVar) {
        this.f465a = aVar;
    }

    public void a(String str) {
        this.b = str;
    }

    public void a(b bVar) {
        if (bVar != null) {
            this.f466a = bVar;
            return;
        }
        throw new NullPointerException("Type cannot be null");
    }

    public fp(b bVar) {
        this.f466a = b.available;
        this.b = null;
        this.a = Integer.MIN_VALUE;
        this.f465a = null;
        a(bVar);
    }

    public fp(Bundle bundle) {
        super(bundle);
        this.f466a = b.available;
        this.b = null;
        this.a = Integer.MIN_VALUE;
        this.f465a = null;
        if (bundle.containsKey("ext_pres_type")) {
            this.f466a = b.valueOf(bundle.getString("ext_pres_type"));
        }
        if (bundle.containsKey("ext_pres_status")) {
            this.b = bundle.getString("ext_pres_status");
        }
        if (bundle.containsKey("ext_pres_prio")) {
            this.a = bundle.getInt("ext_pres_prio");
        }
        if (bundle.containsKey("ext_pres_mode")) {
            this.f465a = a.valueOf(bundle.getString("ext_pres_mode"));
        }
    }

    public void a(int i) {
        if (i >= -128 && i <= 128) {
            this.a = i;
            return;
        }
        throw new IllegalArgumentException("Priority value " + i + " is not valid. Valid range is -128 through 128.");
    }
}
