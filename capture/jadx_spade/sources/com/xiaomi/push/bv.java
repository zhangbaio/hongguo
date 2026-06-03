package com.xiaomi.push;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.ugc.bytex.taskmonitor.proxy.PThreadPoolExecutorDelegate;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import com.xiaomi.push.ad;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class bv {
    private static volatile bv a;

    /* renamed from: a, reason: collision with other field name */
    private Context f160a;

    /* renamed from: a, reason: collision with other field name */
    private bu f161a;

    /* renamed from: a, reason: collision with other field name */
    private final HashMap<String, bt> f163a = new HashMap<>();

    /* renamed from: a, reason: collision with other field name */
    private ThreadPoolExecutor f164a = new PThreadPoolExecutorDelegate(1, 1, 15, TimeUnit.SECONDS, new LinkedBlockingQueue(), new DefaultThreadFactory("iaomi/push/bv"));

    /* renamed from: a, reason: collision with other field name */
    private final ArrayList<a> f162a = new ArrayList<>();

    static {
        Covode.recordClassIndex(655391);
    }

    public static abstract class a implements Runnable {

        /* renamed from: a, reason: collision with other field name */
        private a f166a;

        /* renamed from: a, reason: collision with other field name */
        private String f167a;

        /* renamed from: a, reason: collision with other field name */
        private WeakReference<Context> f168a;
        protected String b;

        /* renamed from: a, reason: collision with other field name */
        protected bt f165a = null;

        /* renamed from: a, reason: collision with other field name */
        private Random f169a = new Random();
        private int a = 0;

        static {
            Covode.recordClassIndex(655392);
        }

        /* renamed from: a, reason: collision with other method in class */
        public Object mo197a() {
            return null;
        }

        public abstract void a(Context context, SQLiteDatabase sQLiteDatabase);

        public void b(Context context) {
        }

        public SQLiteDatabase a() {
            return this.f165a.getWritableDatabase();
        }

        /* renamed from: a, reason: collision with other method in class */
        public String m198a() {
            return this.f167a;
        }

        @Override // java.lang.Runnable
        public final void run() {
            final Context context;
            WeakReference<Context> weakReference = this.f168a;
            if (weakReference != null && (context = weakReference.get()) != null && context.getFilesDir() != null && this.f165a != null && !TextUtils.isEmpty(this.f167a)) {
                PolarisFileWrapper polarisFileWrapper = new PolarisFileWrapper(this.f167a);
                t.a(context, new PolarisFileWrapper(polarisFileWrapper.getParentFile(), az.b(polarisFileWrapper.getAbsolutePath())), new Runnable() { // from class: com.xiaomi.push.bv.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SQLiteDatabase sQLiteDatabase = null;
                        try {
                            try {
                                sQLiteDatabase = a.this.a();
                                if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                                    sQLiteDatabase.beginTransaction();
                                    a.this.a(context, sQLiteDatabase);
                                    sQLiteDatabase.setTransactionSuccessful();
                                }
                                if (sQLiteDatabase != null) {
                                    try {
                                        sQLiteDatabase.endTransaction();
                                    } catch (Exception e) {
                                        e = e;
                                        com.xiaomi.channel.commonutils.logger.b.a(e);
                                        a.this.a(context);
                                    }
                                }
                                bt btVar = a.this.f165a;
                                if (btVar != null) {
                                    btVar.close();
                                }
                            } catch (Exception e2) {
                                com.xiaomi.channel.commonutils.logger.b.a(e2);
                                if (sQLiteDatabase != null) {
                                    try {
                                        sQLiteDatabase.endTransaction();
                                    } catch (Exception e3) {
                                        e = e3;
                                        com.xiaomi.channel.commonutils.logger.b.a(e);
                                        a.this.a(context);
                                    }
                                }
                                bt btVar2 = a.this.f165a;
                                if (btVar2 != null) {
                                    btVar2.close();
                                }
                            }
                            a.this.a(context);
                        } catch (Throwable th) {
                            if (sQLiteDatabase != null) {
                                try {
                                    sQLiteDatabase.endTransaction();
                                } catch (Exception e4) {
                                    com.xiaomi.channel.commonutils.logger.b.a(e4);
                                    a.this.a(context);
                                    throw th;
                                }
                            }
                            bt btVar3 = a.this.f165a;
                            if (btVar3 != null) {
                                btVar3.close();
                            }
                            a.this.a(context);
                            throw th;
                        }
                    }
                });
            }
        }

        /* renamed from: a, reason: collision with other method in class */
        public boolean m199a() {
            if (this.f165a != null && !TextUtils.isEmpty(this.b) && this.f168a != null) {
                return false;
            }
            return true;
        }

        public a(String str) {
            this.f167a = str;
        }

        void a(Context context) {
            a aVar = this.f166a;
            if (aVar != null) {
                aVar.a(context, mo197a());
            }
            b(context);
        }

        public void a(a aVar) {
            this.f166a = aVar;
        }

        public void a(Context context, Object obj) {
            bv.a(context).a(this);
        }

        void a(bt btVar, Context context) {
            this.f165a = btVar;
            this.b = btVar.a();
            this.f168a = new WeakReference<>(context);
        }
    }

    public static abstract class b<T> extends a {
        private int a;

        /* renamed from: a, reason: collision with other field name */
        private String f171a;

        /* renamed from: a, reason: collision with other field name */
        private List<String> f172a;

        /* renamed from: a, reason: collision with other field name */
        private String[] f173a;
        private List<T> b;
        private String c;
        private String d;
        private String e;

        static {
            Covode.recordClassIndex(655393);
        }

        public abstract T a(Context context, Cursor cursor);

        public abstract void a(Context context, List<T> list);

        @Override // com.xiaomi.push.bv.a
        public SQLiteDatabase a() {
            return ((a) this).f165a.getReadableDatabase();
        }

        @Override // com.xiaomi.push.bv.a
        public void a(Context context, SQLiteDatabase sQLiteDatabase) {
            String[] strArr;
            this.b.clear();
            List<String> list = this.f172a;
            String str = null;
            if (list != null && list.size() > 0) {
                String[] strArr2 = new String[this.f172a.size()];
                this.f172a.toArray(strArr2);
                strArr = strArr2;
            } else {
                strArr = null;
            }
            int i = this.a;
            if (i > 0) {
                str = String.valueOf(i);
            }
            Cursor query = sQLiteDatabase.query(super.b, strArr, this.f171a, this.f173a, this.c, this.d, this.e, str);
            if (query != null && query.moveToFirst()) {
                do {
                    T a = a(context, query);
                    if (a != null) {
                        this.b.add(a);
                    }
                } while (query.moveToNext());
                query.close();
            }
            a(context, (List) this.b);
        }

        public b(String str, List<String> list, String str2, String[] strArr, String str3, String str4, String str5, int i) {
            super(str);
            this.b = new ArrayList();
            this.f172a = list;
            this.f171a = str2;
            this.f173a = strArr;
            this.c = str3;
            this.d = str4;
            this.e = str5;
            this.a = i;
        }
    }

    private void a() {
        ad.a(this.f160a).b(new ad.a() { // from class: com.xiaomi.push.bv.1
            @Override // com.xiaomi.push.ad.a
            /* renamed from: a */
            public String mo187a() {
                return "100957";
            }

            @Override // java.lang.Runnable
            public void run() {
                synchronized (bv.this.f162a) {
                    if (bv.this.f162a.size() > 0) {
                        if (bv.this.f162a.size() > 1) {
                            bv bvVar = bv.this;
                            bvVar.a(bvVar.f162a);
                        } else {
                            bv bvVar2 = bv.this;
                            bvVar2.b((a) bvVar2.f162a.get(0));
                        }
                        bv.this.f162a.clear();
                        System.gc();
                    }
                }
            }
        }, com.xiaomi.push.service.ah.a(this.f160a).a(gj.StatDataProcessFrequency.a(), 5));
    }

    /* renamed from: a, reason: collision with other method in class */
    public String m196a(String str) {
        return a(str).a();
    }

    public static class c extends a {
        private ArrayList<a> a;

        static {
            Covode.recordClassIndex(655394);
        }

        @Override // com.xiaomi.push.bv.a
        public final void a(Context context) {
            super.a(context);
            Iterator<a> it2 = this.a.iterator();
            while (it2.hasNext()) {
                a next = it2.next();
                if (next != null) {
                    next.a(context);
                }
            }
        }

        public c(String str, ArrayList<a> arrayList) {
            super(str);
            ArrayList<a> arrayList2 = new ArrayList<>();
            this.a = arrayList2;
            arrayList2.addAll(arrayList);
        }

        @Override // com.xiaomi.push.bv.a
        public void a(Context context, SQLiteDatabase sQLiteDatabase) {
            Iterator<a> it2 = this.a.iterator();
            while (it2.hasNext()) {
                a next = it2.next();
                if (next != null) {
                    next.a(context, sQLiteDatabase);
                }
            }
        }
    }

    public static bv a(Context context) {
        if (a == null) {
            synchronized (bv.class) {
                if (a == null) {
                    a = new bv(context);
                }
            }
        }
        return a;
    }

    private bv(Context context) {
        this.f160a = context;
    }

    private bt a(String str) {
        bt btVar = this.f163a.get(str);
        if (btVar == null) {
            synchronized (this.f163a) {
                if (btVar == null) {
                    btVar = this.f161a.a(this.f160a, str);
                    this.f163a.put(str, btVar);
                }
            }
        }
        return btVar;
    }

    public void b(a aVar) {
        bt btVar;
        if (aVar == null) {
            return;
        }
        if (this.f161a != null) {
            String m198a = aVar.m198a();
            synchronized (this.f163a) {
                btVar = this.f163a.get(m198a);
                if (btVar == null) {
                    btVar = this.f161a.a(this.f160a, m198a);
                    this.f163a.put(m198a, btVar);
                }
            }
            if (!this.f164a.isShutdown()) {
                aVar.a(btVar, this.f160a);
                a((Runnable) aVar);
                return;
            }
            return;
        }
        throw new IllegalStateException("should exec init method first!");
    }

    public void a(a aVar) {
        bt btVar;
        if (aVar == null) {
            return;
        }
        if (this.f161a != null) {
            String m198a = aVar.m198a();
            synchronized (this.f163a) {
                btVar = this.f163a.get(m198a);
                if (btVar == null) {
                    btVar = this.f161a.a(this.f160a, m198a);
                    this.f163a.put(m198a, btVar);
                }
            }
            if (!this.f164a.isShutdown()) {
                aVar.a(btVar, this.f160a);
                synchronized (this.f162a) {
                    this.f162a.add(aVar);
                    a();
                }
                return;
            }
            return;
        }
        throw new IllegalStateException("should exec init method first!");
    }

    public void a(Runnable runnable) {
        if (!this.f164a.isShutdown()) {
            this.f164a.execute(runnable);
        }
    }

    public void a(ArrayList<a> arrayList) {
        if (this.f161a != null) {
            HashMap hashMap = new HashMap();
            if (!this.f164a.isShutdown()) {
                Iterator<a> it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    a next = it2.next();
                    if (next.m199a()) {
                        next.a(a(next.m198a()), this.f160a);
                    }
                    ArrayList arrayList2 = (ArrayList) hashMap.get(next.m198a());
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList();
                        hashMap.put(next.m198a(), arrayList2);
                    }
                    arrayList2.add(next);
                }
                for (String str : hashMap.keySet()) {
                    ArrayList arrayList3 = (ArrayList) hashMap.get(str);
                    if (arrayList3 != null && arrayList3.size() > 0) {
                        c cVar = new c(str, arrayList3);
                        cVar.a(((a) arrayList3.get(0)).f165a, this.f160a);
                        this.f164a.execute(cVar);
                    }
                }
                return;
            }
            return;
        }
        throw new IllegalStateException("should exec setDbHelperFactory method first!");
    }

    public static class e extends a {
        private ContentValues a;

        static {
            Covode.recordClassIndex(655396);
        }

        public e(String str, ContentValues contentValues) {
            super(str);
            this.a = contentValues;
        }

        @Override // com.xiaomi.push.bv.a
        public void a(Context context, SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.insert(this.b, null, this.a);
        }
    }

    public static class d extends a {
        private String a;

        /* renamed from: a, reason: collision with other field name */
        protected String[] f174a;

        static {
            Covode.recordClassIndex(655395);
        }

        @Override // com.xiaomi.push.bv.a
        public void a(Context context, SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.delete(this.b, this.a, this.f174a);
        }

        public d(String str, String str2, String[] strArr) {
            super(str);
            this.a = str2;
            this.f174a = strArr;
        }
    }
}
