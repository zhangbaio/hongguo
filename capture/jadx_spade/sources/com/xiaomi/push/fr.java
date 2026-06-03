package com.xiaomi.push;

import android.os.Bundle;
import android.os.Parcelable;
import com.bytedance.covode.number.Covode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class fr {
    private int a;

    /* renamed from: a, reason: collision with other field name */
    private String f469a;

    /* renamed from: a, reason: collision with other field name */
    private List<fk> f470a;
    private String b;
    private String c;
    private String d;

    static {
        Covode.recordClassIndex(655535);
    }

    public static class a {
        public static final a a;
        public static final a b;
        public static final a c;
        public static final a d;
        public static final a e;
        public static final a f;
        public static final a g;
        public static final a h;
        public static final a i;
        public static final a j;
        public static final a k;
        public static final a l;
        public static final a m;
        public static final a n;
        public static final a o;
        public static final a p;
        public static final a q;
        public static final a r;
        public static final a s;
        public static final a t;
        public static final a u;
        public static final a v;
        public static final a w;
        public static final a x;

        /* renamed from: a, reason: collision with other field name */
        private String f471a;

        public String toString() {
            return this.f471a;
        }

        static {
            Covode.recordClassIndex(655536);
            a = new a("internal-server-error");
            b = new a("forbidden");
            c = new a("bad-request");
            d = new a("conflict");
            e = new a("feature-not-implemented");
            f = new a("gone");
            g = new a("item-not-found");
            h = new a("jid-malformed");
            i = new a("not-acceptable");
            j = new a("not-allowed");
            k = new a("not-authorized");
            l = new a("payment-required");
            m = new a("recipient-unavailable");
            n = new a("redirect");
            o = new a("registration-required");
            p = new a("remote-server-error");
            q = new a("remote-server-not-found");
            r = new a("remote-server-timeout");
            s = new a("resource-constraint");
            t = new a("service-unavailable");
            u = new a("subscription-required");
            v = new a("undefined-condition");
            w = new a("unexpected-request");
            x = new a("request-timeout");
        }

        public a(String str) {
            this.f471a = str;
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public synchronized List<fk> m440a() {
        List<fk> list = this.f470a;
        if (list == null) {
            return Collections.emptyList();
        }
        return Collections.unmodifiableList(list);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        String str = this.b;
        if (str != null) {
            sb.append(str);
        }
        sb.append("(");
        sb.append(this.a);
        sb.append(")");
        if (this.d != null) {
            sb.append(" ");
            sb.append(this.d);
        }
        return sb.toString();
    }

    public Bundle a() {
        Bundle bundle = new Bundle();
        String str = this.f469a;
        if (str != null) {
            bundle.putString("ext_err_type", str);
        }
        bundle.putInt("ext_err_code", this.a);
        String str2 = this.c;
        if (str2 != null) {
            bundle.putString("ext_err_reason", str2);
        }
        String str3 = this.b;
        if (str3 != null) {
            bundle.putString("ext_err_cond", str3);
        }
        String str4 = this.d;
        if (str4 != null) {
            bundle.putString("ext_err_msg", str4);
        }
        List<fk> list = this.f470a;
        if (list != null) {
            Bundle[] bundleArr = new Bundle[list.size()];
            Iterator<fk> it2 = this.f470a.iterator();
            int i = 0;
            while (it2.hasNext()) {
                Bundle a2 = it2.next().a();
                if (a2 != null) {
                    bundleArr[i] = a2;
                    i++;
                }
            }
            bundle.putParcelableArray("ext_exts", bundleArr);
        }
        return bundle;
    }

    /* renamed from: a, reason: collision with other method in class */
    public String m439a() {
        StringBuilder sb = new StringBuilder();
        sb.append("<error code=\"");
        sb.append(this.a);
        sb.append("\"");
        if (this.f469a != null) {
            sb.append(" type=\"");
            sb.append(this.f469a);
            sb.append("\"");
        }
        if (this.c != null) {
            sb.append(" reason=\"");
            sb.append(this.c);
            sb.append("\"");
        }
        sb.append(">");
        if (this.b != null) {
            sb.append("<");
            sb.append(this.b);
            sb.append(" xmlns=\"urn:ietf:params:xml:ns:xmpp-stanzas\"/>");
        }
        if (this.d != null) {
            sb.append("<text xml:lang=\"en\" xmlns=\"urn:ietf:params:xml:ns:xmpp-stanzas\">");
            sb.append(this.d);
            sb.append("</text>");
        }
        Iterator<fk> it2 = m440a().iterator();
        while (it2.hasNext()) {
            sb.append(it2.next().d());
        }
        sb.append("</error>");
        return sb.toString();
    }

    private void a(a aVar) {
        this.b = aVar.f471a;
    }

    public fr(a aVar) {
        this.f470a = null;
        a(aVar);
        this.d = null;
    }

    public fr(Bundle bundle) {
        this.f470a = null;
        this.a = bundle.getInt("ext_err_code");
        if (bundle.containsKey("ext_err_type")) {
            this.f469a = bundle.getString("ext_err_type");
        }
        this.b = bundle.getString("ext_err_cond");
        this.c = bundle.getString("ext_err_reason");
        this.d = bundle.getString("ext_err_msg");
        Parcelable[] parcelableArray = bundle.getParcelableArray("ext_exts");
        if (parcelableArray != null) {
            this.f470a = new ArrayList(parcelableArray.length);
            for (Parcelable parcelable : parcelableArray) {
                fk a2 = fk.a((Bundle) parcelable);
                if (a2 != null) {
                    this.f470a.add(a2);
                }
            }
        }
    }

    public fr(int i, String str, String str2, String str3, String str4, List<fk> list) {
        this.a = i;
        this.f469a = str;
        this.c = str2;
        this.b = str3;
        this.d = str4;
        this.f470a = list;
    }
}
