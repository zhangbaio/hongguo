package com.xiaomi.push;

import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import java.util.Collection;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class r {
    static {
        Covode.recordClassIndex(655628);
    }

    public static class a {
        private final String a;

        /* renamed from: a, reason: collision with other field name */
        private final StringBuilder f852a;
        private final String b;

        static {
            Covode.recordClassIndex(655629);
        }

        public a() {
            this(":", ",");
        }

        public String toString() {
            return this.f852a.toString();
        }

        public a(String str, String str2) {
            this.f852a = new StringBuilder();
            this.a = str;
            this.b = str2;
        }

        public a a(String str, Object obj) {
            if (!TextUtils.isEmpty(str)) {
                if (this.f852a.length() > 0) {
                    this.f852a.append(this.b);
                }
                StringBuilder sb = this.f852a;
                sb.append(str);
                sb.append(this.a);
                sb.append(obj);
            }
            return this;
        }
    }

    public static boolean a() {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            return true;
        }
        return false;
    }

    public static boolean a(Collection<?> collection) {
        if (collection != null && !collection.isEmpty()) {
            return false;
        }
        return true;
    }

    public static int a(String str, int i) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return Integer.parseInt(str);
            } catch (Exception unused) {
                return i;
            }
        }
        return i;
    }

    public static long a(String str, long j) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return Long.parseLong(str);
            } catch (Exception unused) {
                return j;
            }
        }
        return j;
    }

    public static int b(String str, int i) {
        if (!TextUtils.isEmpty(str)) {
            return ((str.hashCode() / 10) * 10) + i;
        }
        return i;
    }
}
