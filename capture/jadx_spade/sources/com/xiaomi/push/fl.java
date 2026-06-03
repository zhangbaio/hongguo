package com.xiaomi.push;

import android.os.Bundle;
import com.bytedance.covode.number.Covode;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class fl extends fn {
    private a a;

    /* renamed from: a, reason: collision with other field name */
    private final Map<String, String> f456a;

    static {
        Covode.recordClassIndex(655526);
    }

    public String b() {
        return null;
    }

    public static class a {
        public static final a a;
        public static final a b;
        public static final a c;
        public static final a d;
        public static final a e;

        /* renamed from: a, reason: collision with other field name */
        private String f457a;

        public String toString() {
            return this.f457a;
        }

        static {
            Covode.recordClassIndex(655527);
            a = new a("get");
            b = new a("set");
            c = new a("result");
            d = new a("error");
            e = new a("command");
        }

        private a(String str) {
            this.f457a = str;
        }

        public static a a(String str) {
            if (str == null) {
                return null;
            }
            String lowerCase = str.toLowerCase();
            a aVar = a;
            if (aVar.toString().equals(lowerCase)) {
                return aVar;
            }
            a aVar2 = b;
            if (aVar2.toString().equals(lowerCase)) {
                return aVar2;
            }
            a aVar3 = d;
            if (aVar3.toString().equals(lowerCase)) {
                return aVar3;
            }
            a aVar4 = c;
            if (aVar4.toString().equals(lowerCase)) {
                return aVar4;
            }
            a aVar5 = e;
            if (!aVar5.toString().equals(lowerCase)) {
                return null;
            }
            return aVar5;
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public a m434a() {
        return this.a;
    }

    public fl() {
        this.a = a.a;
        this.f456a = new HashMap();
    }

    @Override // com.xiaomi.push.fn
    public Bundle a() {
        Bundle a2 = super.a();
        a aVar = this.a;
        if (aVar != null) {
            a2.putString("ext_iq_type", aVar.toString());
        }
        return a2;
    }

    @Override // com.xiaomi.push.fn
    /* renamed from: a, reason: collision with other method in class */
    public String mo435a() {
        StringBuilder sb = new StringBuilder();
        sb.append("<iq ");
        if (j() != null) {
            sb.append("id=\"" + j() + "\" ");
        }
        if (l() != null) {
            sb.append("to=\"");
            sb.append(fw.a(l()));
            sb.append("\" ");
        }
        if (m() != null) {
            sb.append("from=\"");
            sb.append(fw.a(m()));
            sb.append("\" ");
        }
        if (k() != null) {
            sb.append("chid=\"");
            sb.append(fw.a(k()));
            sb.append("\" ");
        }
        for (Map.Entry<String, String> entry : this.f456a.entrySet()) {
            sb.append(fw.a(entry.getKey()));
            sb.append("=\"");
            sb.append(fw.a(entry.getValue()));
            sb.append("\" ");
        }
        if (this.a == null) {
            sb.append("type=\"get\">");
        } else {
            sb.append("type=\"");
            sb.append(m434a());
            sb.append("\">");
        }
        String b = b();
        if (b != null) {
            sb.append(b);
        }
        sb.append(o());
        fr m436a = m436a();
        if (m436a != null) {
            sb.append(m436a.m439a());
        }
        sb.append("</iq>");
        return sb.toString();
    }

    public void a(a aVar) {
        if (aVar == null) {
            this.a = a.a;
        } else {
            this.a = aVar;
        }
    }

    public fl(Bundle bundle) {
        super(bundle);
        this.a = a.a;
        this.f456a = new HashMap();
        if (bundle.containsKey("ext_iq_type")) {
            this.a = a.a(bundle.getString("ext_iq_type"));
        }
    }

    public synchronized void a(Map<String, String> map) {
        this.f456a.putAll(map);
    }
}
