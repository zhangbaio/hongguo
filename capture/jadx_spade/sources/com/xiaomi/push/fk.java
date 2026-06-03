package com.xiaomi.push;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class fk implements fo {
    private String a;

    /* renamed from: a, reason: collision with other field name */
    private List<fk> f453a;

    /* renamed from: a, reason: collision with other field name */
    private String[] f454a;
    private String b;

    /* renamed from: b, reason: collision with other field name */
    private String[] f455b;
    private String c;

    static {
        Covode.recordClassIndex(655525);
    }

    /* renamed from: a, reason: collision with other method in class */
    public String m432a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }

    /* renamed from: a, reason: collision with other method in class */
    public Parcelable m431a() {
        return a();
    }

    public String toString() {
        return d();
    }

    public String c() {
        if (!TextUtils.isEmpty(this.c)) {
            return fw.b(this.c);
        }
        return this.c;
    }

    public Bundle a() {
        Bundle bundle = new Bundle();
        bundle.putString("ext_ele_name", this.a);
        bundle.putString("ext_ns", this.b);
        bundle.putString("ext_text", this.c);
        Bundle bundle2 = new Bundle();
        String[] strArr = this.f454a;
        if (strArr != null && strArr.length > 0) {
            int i = 0;
            while (true) {
                String[] strArr2 = this.f454a;
                if (i >= strArr2.length) {
                    break;
                }
                bundle2.putString(strArr2[i], this.f455b[i]);
                i++;
            }
        }
        bundle.putBundle("attributes", bundle2);
        List<fk> list = this.f453a;
        if (list != null && list.size() > 0) {
            bundle.putParcelableArray("children", a(this.f453a));
        }
        return bundle;
    }

    @Override // com.xiaomi.push.fo
    public String d() {
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        sb.append(this.a);
        if (!TextUtils.isEmpty(this.b)) {
            sb.append(" ");
            sb.append("xmlns=");
            sb.append("\"");
            sb.append(this.b);
            sb.append("\"");
        }
        String[] strArr = this.f454a;
        if (strArr != null && strArr.length > 0) {
            for (int i = 0; i < this.f454a.length; i++) {
                if (!TextUtils.isEmpty(this.f455b[i])) {
                    sb.append(" ");
                    sb.append(this.f454a[i]);
                    sb.append("=\"");
                    sb.append(fw.a(this.f455b[i]));
                    sb.append("\"");
                }
            }
        }
        if (!TextUtils.isEmpty(this.c)) {
            sb.append(">");
            sb.append(this.c);
            sb.append("</");
            sb.append(this.a);
            sb.append(">");
        } else {
            List<fk> list = this.f453a;
            if (list != null && list.size() > 0) {
                sb.append(">");
                Iterator<fk> it2 = this.f453a.iterator();
                while (it2.hasNext()) {
                    sb.append(it2.next().d());
                }
                sb.append("</");
                sb.append(this.a);
                sb.append(">");
            } else {
                sb.append("/>");
            }
        }
        return sb.toString();
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m433a(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.c = fw.a(str);
        } else {
            this.c = str;
        }
    }

    public static Parcelable[] a(List<fk> list) {
        return a((fk[]) list.toArray(new fk[list.size()]));
    }

    public static Parcelable[] a(fk[] fkVarArr) {
        if (fkVarArr == null) {
            return null;
        }
        Parcelable[] parcelableArr = new Parcelable[fkVarArr.length];
        for (int i = 0; i < fkVarArr.length; i++) {
            parcelableArr[i] = fkVarArr[i].m431a();
        }
        return parcelableArr;
    }

    public static fk a(Bundle bundle) {
        ArrayList arrayList;
        String string = bundle.getString("ext_ele_name");
        String string2 = bundle.getString("ext_ns");
        String string3 = bundle.getString("ext_text");
        Bundle bundle2 = bundle.getBundle("attributes");
        Set<String> keySet = bundle2.keySet();
        String[] strArr = new String[keySet.size()];
        String[] strArr2 = new String[keySet.size()];
        int i = 0;
        for (String str : keySet) {
            strArr[i] = str;
            strArr2[i] = bundle2.getString(str);
            i++;
        }
        if (bundle.containsKey("children")) {
            Parcelable[] parcelableArray = bundle.getParcelableArray("children");
            ArrayList arrayList2 = new ArrayList(parcelableArray.length);
            for (Parcelable parcelable : parcelableArray) {
                arrayList2.add(a((Bundle) parcelable));
            }
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        return new fk(string, string2, strArr, strArr2, string3, arrayList);
    }

    public String a(String str) {
        if (str != null) {
            if (this.f454a != null) {
                int i = 0;
                while (true) {
                    String[] strArr = this.f454a;
                    if (i < strArr.length) {
                        if (str.equals(strArr[i])) {
                            return this.f455b[i];
                        }
                        i++;
                    } else {
                        return null;
                    }
                }
            } else {
                return null;
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void a(fk fkVar) {
        if (this.f453a == null) {
            this.f453a = new ArrayList();
        }
        if (!this.f453a.contains(fkVar)) {
            this.f453a.add(fkVar);
        }
    }

    public fk(String str, String str2, String[] strArr, String[] strArr2) {
        this.f453a = null;
        this.a = str;
        this.b = str2;
        this.f454a = strArr;
        this.f455b = strArr2;
    }

    public fk(String str, String str2, String[] strArr, String[] strArr2, String str3, List<fk> list) {
        this.a = str;
        this.b = str2;
        this.f454a = strArr;
        this.f455b = strArr2;
        this.c = str3;
        this.f453a = list;
    }
}
