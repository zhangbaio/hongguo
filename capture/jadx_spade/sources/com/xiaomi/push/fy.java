package com.xiaomi.push;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.xiaomi.push.ae;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class fy {
    private static volatile int a;

    /* renamed from: a, reason: collision with other field name */
    private static long f474a;

    /* renamed from: a, reason: collision with other field name */
    private static ae f475a;

    /* renamed from: a, reason: collision with other field name */
    private static com.xiaomi.push.providers.a f476a;

    /* renamed from: a, reason: collision with other field name */
    private static final Object f477a;

    /* renamed from: a, reason: collision with other field name */
    private static String f478a;

    /* renamed from: a, reason: collision with other field name */
    private static List<a> f479a;

    /* renamed from: a, reason: collision with other method in class */
    public static synchronized void m452a(String str) {
        synchronized (fy.class) {
            if (!j.m636d() && !TextUtils.isEmpty(str)) {
                f478a = str;
            }
        }
    }

    private static void a(a aVar) {
        for (a aVar2 : f479a) {
            if (aVar2.a(aVar)) {
                aVar2.f482b += aVar.f482b;
                return;
            }
        }
        f479a.add(aVar);
    }

    static {
        Covode.recordClassIndex(655543);
        f475a = new ae(true);
        a = -1;
        f474a = System.currentTimeMillis();
        f477a = new Object();
        f479a = Collections.synchronizedList(new ArrayList());
        f478a = "";
        f476a = null;
    }

    public static int a(Context context) {
        if (a == -1) {
            a = b(context);
        }
        return a;
    }

    private static int b(Context context) {
        au m148a = at.m148a();
        if (m148a == null) {
            return -1;
        }
        return m148a.a();
    }

    public static int a(String str) {
        try {
            return str.getBytes("UTF-8").length;
        } catch (UnsupportedEncodingException unused) {
            return str.getBytes().length;
        }
    }

    static class a {
        public int a;

        /* renamed from: a, reason: collision with other field name */
        public long f480a;

        /* renamed from: a, reason: collision with other field name */
        public String f481a;
        public int b;

        /* renamed from: b, reason: collision with other field name */
        public long f482b;

        /* renamed from: b, reason: collision with other field name */
        public String f483b;

        static {
            Covode.recordClassIndex(655544);
        }

        public boolean a(a aVar) {
            if (TextUtils.equals(aVar.f481a, this.f481a) && TextUtils.equals(aVar.f483b, this.f483b) && aVar.a == this.a && aVar.b == this.b && Math.abs(aVar.f480a - this.f480a) <= 5000) {
                return true;
            }
            return false;
        }

        public a(String str, long j, int i, int i2, String str2, long j2) {
            this.f481a = str;
            this.f480a = j;
            this.a = i;
            this.b = i2;
            this.f483b = str2;
            this.f482b = j2;
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    private static com.xiaomi.push.providers.a m448a(Context context) {
        com.xiaomi.push.providers.a aVar = f476a;
        if (aVar != null) {
            return aVar;
        }
        com.xiaomi.push.providers.a aVar2 = new com.xiaomi.push.providers.a(context);
        f476a = aVar2;
        return aVar2;
    }

    /* renamed from: a, reason: collision with other method in class */
    private static synchronized String m449a(Context context) {
        synchronized (fy.class) {
            if (!TextUtils.isEmpty(f478a)) {
                return f478a;
            }
            return "";
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public static void m451a(Context context) {
        a = b(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Context context, List<a> list) {
        try {
            synchronized (com.xiaomi.push.providers.a.f849a) {
                SQLiteDatabase writableDatabase = m448a(context).getWritableDatabase();
                writableDatabase.beginTransaction();
                try {
                    for (a aVar : list) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("package_name", aVar.f481a);
                        contentValues.put("message_ts", Long.valueOf(aVar.f480a));
                        contentValues.put("network_type", Integer.valueOf(aVar.a));
                        contentValues.put("bytes", Long.valueOf(aVar.f482b));
                        contentValues.put("rcv", Integer.valueOf(aVar.b));
                        contentValues.put("imsi", aVar.f483b);
                        writableDatabase.insert("traffic", null, contentValues);
                    }
                    writableDatabase.setTransactionSuccessful();
                } finally {
                    writableDatabase.endTransaction();
                }
            }
        } catch (Throwable th) {
            com.xiaomi.channel.commonutils.logger.b.a(th);
        }
    }

    private static long a(int i, long j, boolean z, long j2, boolean z2) {
        int i2;
        if (z && z2) {
            long j3 = f474a;
            f474a = j2;
            if (j2 - j3 > 30000 && j > ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_XLS) {
                return j * 2;
            }
        }
        if (i == 0) {
            i2 = 13;
        } else {
            i2 = 11;
        }
        return (j * i2) / 10;
    }

    private static void a(final Context context, String str, long j, boolean z, long j2) {
        int a2;
        boolean isEmpty;
        String str2;
        if (context == null || TextUtils.isEmpty(str) || !"com.xiaomi.xmsf".equals(context.getPackageName()) || "com.xiaomi.xmsf".equals(str) || -1 == (a2 = a(context))) {
            return;
        }
        synchronized (f477a) {
            isEmpty = f479a.isEmpty();
            if (a2 == 0) {
                str2 = m449a(context);
            } else {
                str2 = "";
            }
            a(new a(str, j2, a2, z ? 1 : 0, str2, j));
        }
        if (isEmpty) {
            f475a.a(new ae.b() { // from class: com.xiaomi.push.fy.1
                @Override // com.xiaomi.push.ae.b
                public void b() {
                    ArrayList arrayList;
                    synchronized (fy.f477a) {
                        arrayList = new ArrayList(fy.f479a);
                        fy.f479a.clear();
                    }
                    fy.b(context, arrayList);
                }
            }, 5000L);
        }
    }

    public static void a(Context context, String str, long j, boolean z, boolean z2, long j2) {
        a(context, str, a(a(context), j, z, j2, z2), z, j2);
    }
}
