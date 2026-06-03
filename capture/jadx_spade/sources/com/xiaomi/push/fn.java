package com.xiaomi.push;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public abstract class fn {
    protected static final String a;

    /* renamed from: a, reason: collision with other field name */
    public static final DateFormat f459a;
    private static long b;

    /* renamed from: b, reason: collision with other field name */
    private static String f460b;
    private static String c;

    /* renamed from: a, reason: collision with other field name */
    public long f461a;

    /* renamed from: a, reason: collision with other field name */
    private fr f462a;

    /* renamed from: a, reason: collision with other field name */
    private List<fk> f463a;

    /* renamed from: a, reason: collision with other field name */
    private final Map<String, Object> f464a;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;

    /* renamed from: a */
    public abstract String mo435a();

    public static String q() {
        return a;
    }

    /* renamed from: a, reason: collision with other method in class */
    public fr m436a() {
        return this.f462a;
    }

    public String k() {
        return this.h;
    }

    public String l() {
        return this.f;
    }

    public String m() {
        return this.g;
    }

    public String n() {
        return this.i;
    }

    public String p() {
        return this.d;
    }

    public synchronized Collection<String> b() {
        if (this.f464a == null) {
            return Collections.emptySet();
        }
        return Collections.unmodifiableSet(new HashSet(this.f464a.keySet()));
    }

    public String j() {
        if ("ID_NOT_AVAILABLE".equals(this.e)) {
            return null;
        }
        if (this.e == null) {
            this.e = i();
        }
        return this.e;
    }

    public fn() {
        this.d = f460b;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.f463a = new CopyOnWriteArrayList();
        this.f464a = new HashMap();
        this.f462a = null;
    }

    public static synchronized String i() {
        String sb;
        synchronized (fn.class) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(c);
            long j = b;
            b = 1 + j;
            sb2.append(Long.toString(j));
            sb = sb2.toString();
        }
        return sb;
    }

    static {
        Covode.recordClassIndex(655529);
        a = Locale.getDefault().getLanguage().toLowerCase();
        f460b = null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        f459a = simpleDateFormat;
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        c = fw.a(5) + "-";
        b = 0L;
    }

    /* renamed from: a, reason: collision with other method in class */
    public synchronized Collection<fk> m438a() {
        if (this.f463a == null) {
            return Collections.emptyList();
        }
        return Collections.unmodifiableList(new ArrayList(this.f463a));
    }

    public int hashCode() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        String str = this.d;
        int i6 = 0;
        if (str != null) {
            i = str.hashCode();
        } else {
            i = 0;
        }
        int i7 = i * 31;
        String str2 = this.e;
        if (str2 != null) {
            i2 = str2.hashCode();
        } else {
            i2 = 0;
        }
        int i8 = (i7 + i2) * 31;
        String str3 = this.f;
        if (str3 != null) {
            i3 = str3.hashCode();
        } else {
            i3 = 0;
        }
        int i9 = (i8 + i3) * 31;
        String str4 = this.g;
        if (str4 != null) {
            i4 = str4.hashCode();
        } else {
            i4 = 0;
        }
        int i10 = (i9 + i4) * 31;
        String str5 = this.h;
        if (str5 != null) {
            i5 = str5.hashCode();
        } else {
            i5 = 0;
        }
        int hashCode = (((((i10 + i5) * 31) + this.f463a.hashCode()) * 31) + this.f464a.hashCode()) * 31;
        fr frVar = this.f462a;
        if (frVar != null) {
            i6 = frVar.hashCode();
        }
        return hashCode + i6;
    }

    public Bundle a() {
        Bundle bundle = new Bundle();
        if (!TextUtils.isEmpty(this.d)) {
            bundle.putString("ext_ns", this.d);
        }
        if (!TextUtils.isEmpty(this.g)) {
            bundle.putString("ext_from", this.g);
        }
        if (!TextUtils.isEmpty(this.f)) {
            bundle.putString("ext_to", this.f);
        }
        if (!TextUtils.isEmpty(this.e)) {
            bundle.putString("ext_pkt_id", this.e);
        }
        if (!TextUtils.isEmpty(this.h)) {
            bundle.putString("ext_chid", this.h);
        }
        fr frVar = this.f462a;
        if (frVar != null) {
            bundle.putBundle("ext_ERROR", frVar.a());
        }
        List<fk> list = this.f463a;
        if (list != null) {
            Bundle[] bundleArr = new Bundle[list.size()];
            Iterator<fk> it2 = this.f463a.iterator();
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

    /* JADX WARN: Removed duplicated region for block: B:61:0x0123 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x011b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected synchronized java.lang.String o() {
        /*
            Method dump skipped, instructions count: 327
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.fn.o():java.lang.String");
    }

    public void o(String str) {
        this.i = str;
    }

    public fk a(String str) {
        return a(str, null);
    }

    public void k(String str) {
        this.e = str;
    }

    public void l(String str) {
        this.h = str;
    }

    public void m(String str) {
        this.f = str;
    }

    public void n(String str) {
        this.g = str;
    }

    /* renamed from: a, reason: collision with other method in class */
    public synchronized Object m437a(String str) {
        Map<String, Object> map = this.f464a;
        if (map == null) {
            return null;
        }
        return map.get(str);
    }

    public fn(Bundle bundle) {
        this.d = f460b;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.f463a = new CopyOnWriteArrayList();
        this.f464a = new HashMap();
        this.f462a = null;
        this.f = bundle.getString("ext_to");
        this.g = bundle.getString("ext_from");
        this.h = bundle.getString("ext_chid");
        this.e = bundle.getString("ext_pkt_id");
        Parcelable[] parcelableArray = bundle.getParcelableArray("ext_exts");
        if (parcelableArray != null) {
            this.f463a = new ArrayList(parcelableArray.length);
            for (Parcelable parcelable : parcelableArray) {
                fk a2 = fk.a((Bundle) parcelable);
                if (a2 != null) {
                    this.f463a.add(a2);
                }
            }
        }
        Bundle bundle2 = bundle.getBundle("ext_ERROR");
        if (bundle2 != null) {
            this.f462a = new fr(bundle2);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        fn fnVar = (fn) obj;
        fr frVar = this.f462a;
        if (frVar == null ? fnVar.f462a != null : !frVar.equals(fnVar.f462a)) {
            return false;
        }
        String str = this.g;
        if (str == null ? fnVar.g != null : !str.equals(fnVar.g)) {
            return false;
        }
        if (!this.f463a.equals(fnVar.f463a)) {
            return false;
        }
        String str2 = this.e;
        if (str2 == null ? fnVar.e != null : !str2.equals(fnVar.e)) {
            return false;
        }
        String str3 = this.h;
        if (str3 == null ? fnVar.h != null : !str3.equals(fnVar.h)) {
            return false;
        }
        Map<String, Object> map = this.f464a;
        if (map == null ? fnVar.f464a != null : !map.equals(fnVar.f464a)) {
            return false;
        }
        String str4 = this.f;
        if (str4 == null ? fnVar.f != null : !str4.equals(fnVar.f)) {
            return false;
        }
        String str5 = this.d;
        String str6 = fnVar.d;
        if (str5 != null) {
            if (str5.equals(str6)) {
                return true;
            }
        } else if (str6 == null) {
            return true;
        }
        return false;
    }

    public void a(fk fkVar) {
        this.f463a.add(fkVar);
    }

    public void a(fr frVar) {
        this.f462a = frVar;
    }

    public fk a(String str, String str2) {
        for (fk fkVar : this.f463a) {
            if (str2 == null || str2.equals(fkVar.b())) {
                if (str.equals(fkVar.m432a())) {
                    return fkVar;
                }
            }
        }
        return null;
    }
}
