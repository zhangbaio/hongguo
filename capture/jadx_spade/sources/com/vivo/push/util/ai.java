package com.vivo.push.util;

import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class ai {
    private static final SimpleDateFormat a;
    private static final SimpleDateFormat b;
    private static volatile ai c;
    private CopyOnWriteArrayList<a> d = new CopyOnWriteArrayList<>();
    private String e;

    private static class a {
        private long a;
        private long b;

        static {
            Covode.recordClassIndex(655186);
        }

        public final long a() {
            return this.a;
        }

        public final long b() {
            return this.b;
        }

        public a(long j, long j2) {
            this.a = j;
            this.b = j2;
        }
    }

    private ai() {
    }

    static {
        Covode.recordClassIndex(655185);
        a = new SimpleDateFormat("yyyy-MM-dd");
        b = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    }

    public static synchronized ai a() {
        ai aiVar;
        synchronized (ai.class) {
            if (c == null) {
                c = new ai();
            }
            aiVar = c;
        }
        return aiVar;
    }

    public final boolean a(String str) {
        long j;
        long j2;
        long j3;
        String str2;
        Date date;
        SimpleDateFormat simpleDateFormat;
        SimpleDateFormat simpleDateFormat2;
        String str3 = " ";
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        char c2 = 0;
        if (TextUtils.isEmpty(str)) {
            t.c("WindowPeriodManager", "invalid period");
        } else if (TextUtils.equals(str, this.e)) {
            t.c("WindowPeriodManager", "has already updated");
        } else {
            this.e = str;
            this.d.clear();
            Date date2 = new Date();
            long a2 = ag.a();
            String[] split = str.split(";");
            int length = split.length;
            int i = 0;
            while (i < length) {
                String[] split2 = split[i].split("-");
                if (split2.length == 2) {
                    try {
                        simpleDateFormat = b;
                        StringBuilder sb = new StringBuilder();
                        simpleDateFormat2 = a;
                        sb.append(simpleDateFormat2.format(date2));
                        sb.append(str3);
                        sb.append(split2[c2]);
                        j = simpleDateFormat.parse(sb.toString()).getTime();
                    } catch (Exception e) {
                        e = e;
                        j = -1;
                    }
                    try {
                        j3 = simpleDateFormat.parse(simpleDateFormat2.format(date2) + str3 + split2[1]).getTime();
                        j2 = j;
                    } catch (Exception e2) {
                        e = e2;
                        t.a("WindowPeriodManager", "parse window period failed." + e.getMessage());
                        j2 = j;
                        j3 = -1;
                        if (a2 > 0) {
                            str2 = str3;
                            date = date2;
                            this.d.add(new a(j2 - a2, j3 - a2));
                            t.c("WindowPeriodManager", "set window period to [" + split2[0] + ", " + split2[1] + "]");
                            i++;
                            str3 = str2;
                            date2 = date;
                            c2 = 0;
                        }
                        str2 = str3;
                        date = date2;
                        i++;
                        str3 = str2;
                        date2 = date;
                        c2 = 0;
                    }
                    if (a2 > 0 && j2 > 0 && j3 > 0 && j2 < j3) {
                        str2 = str3;
                        date = date2;
                        this.d.add(new a(j2 - a2, j3 - a2));
                        t.c("WindowPeriodManager", "set window period to [" + split2[0] + ", " + split2[1] + "]");
                        i++;
                        str3 = str2;
                        date2 = date;
                        c2 = 0;
                    }
                }
                str2 = str3;
                date = date2;
                i++;
                str3 = str2;
                date2 = date;
                c2 = 0;
            }
        }
        if (ah.a(this.d)) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis() - ag.a();
        Iterator<a> it2 = this.d.iterator();
        while (it2.hasNext()) {
            a next = it2.next();
            if (currentTimeMillis >= next.a() && currentTimeMillis <= next.b()) {
                return true;
            }
        }
        return false;
    }
}
