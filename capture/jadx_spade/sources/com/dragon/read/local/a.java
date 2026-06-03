package com.dragon.read.local;

import android.util.Log;
import android.util.Pair;
import com.bytedance.covode.number.Covode;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.dragon.read.base.util.LogWrapper;
import com.dragon.read.util.FileUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
class a {
    private static final Map<String, a> b;
    private final b a;

    public void a() {
        this.a.m();
    }

    private static final class b {
        protected File a;
        private final AtomicInteger b;
        private final AtomicLong c;
        private final int d;
        private final ConcurrentHashMap<File, Long> e;
        private final long f;

        static {
            Covode.recordClassIndex(611467);
        }

        private void k() {
            new Thread(new RunnableC0088a()).start();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void m() {
            this.e.clear();
            this.c.set(0L);
            File file = this.a;
            if (file != null && FileUtils.deleteDirectory(file)) {
                LogWrapper.info("FileCacheHelper#ACacheManager", "删除成功，cacheDir = " + this.a.getAbsolutePath(), new Object[0]);
            }
        }

        /* renamed from: com.dragon.read.local.a$b$a, reason: collision with other inner class name */
        class RunnableC0088a implements Runnable {
            @Override // java.lang.Runnable
            public void run() {
                File[] listFiles = b.this.a.listFiles();
                if (listFiles != null) {
                    int i = 0;
                    int i2 = 0;
                    for (File file : listFiles) {
                        i = (int) (i + b.this.l(file));
                        i2++;
                        b.this.e.put(file, Long.valueOf(file.lastModified()));
                    }
                    b.this.c.set(i);
                    b.this.b.set(i2);
                }
            }

            RunnableC0088a() {
            }
        }

        private Pair<String, Long> r() {
            File file;
            if (this.e.isEmpty()) {
                return Pair.create("", 0L);
            }
            Set<Map.Entry<File, Long>> entrySet = this.e.entrySet();
            synchronized (this.e) {
                file = null;
                Long l = null;
                for (Map.Entry<File, Long> entry : entrySet) {
                    if (file == null) {
                        file = entry.getKey();
                        l = entry.getValue();
                    } else {
                        Long value = entry.getValue();
                        if (value.longValue() < l.longValue()) {
                            file = entry.getKey();
                            l = value;
                        }
                    }
                }
            }
            if (file != null) {
                long l2 = l(file);
                if (file.exists()) {
                    file.delete();
                }
                this.e.remove(file);
                LogWrapper.error("FileCacheHelper#ACacheManager", "删除最久不使用的文件，file = " + file.getAbsolutePath() + ", size = " + l2, new Object[0]);
                return Pair.create(file.getAbsolutePath(), Long.valueOf(l2));
            }
            return Pair.create("", 0L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public long l(File file) {
            if (file == null) {
                return 0L;
            }
            return file.length();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean q(String str) {
            return n(str).delete();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public File n(String str) {
            File o = o(str);
            long currentTimeMillis = System.currentTimeMillis();
            o.setLastModified(currentTimeMillis);
            this.e.put(o, Long.valueOf(currentTimeMillis));
            return o;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public File o(String str) {
            return new PolarisFileWrapper(this.a, str.hashCode() + "");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void p(File file) {
            while (this.b.get() + 1 > this.d) {
                Pair<String, Long> r = r();
                if (((Long) r.second).longValue() > 0) {
                    LogWrapper.error("FileCacheHelper#ACacheManager", "文件夹超过数量限制，删除最老的文件，file = " + ((String) r.first) + ", size = " + r.second, new Object[0]);
                }
                this.c.addAndGet(-((Long) r.second).longValue());
                this.b.addAndGet(-1);
            }
            this.b.addAndGet(1);
            long l = l(file);
            while (true) {
                if (this.c.get() + l <= this.f) {
                    break;
                }
                Pair<String, Long> r2 = r();
                if (((Long) r2.second).longValue() > 0) {
                    LogWrapper.error("FileCacheHelper#ACacheManager", "文件夹超过容量限制，删除最老的文件，file = " + ((String) r2.first) + ", size = " + r2.second, new Object[0]);
                }
                if (this.e.isEmpty()) {
                    this.c.set(0L);
                    break;
                }
                this.c.addAndGet(-((Long) r2.second).longValue());
            }
            LogWrapper.info("FileCacheHelper#ACacheManager", "put操作，file = " + file.getAbsolutePath() + ", size = " + l + ", cacheSize = " + this.c.addAndGet(l) + ", limitSize = " + this.f, new Object[0]);
            long currentTimeMillis = System.currentTimeMillis();
            file.setLastModified(currentTimeMillis);
            this.e.put(file, Long.valueOf(currentTimeMillis));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void s(File file, long j) {
            this.c.addAndGet(-j);
            long l = l(file);
            while (true) {
                if (this.c.get() + l <= this.f) {
                    break;
                }
                Pair<String, Long> r = r();
                if (((Long) r.second).longValue() > 0) {
                    LogWrapper.error("FileCacheHelper#ACacheManager", "文件夹超过容量限制，删除最老的文件，file = " + ((String) r.first) + ", size = " + r.second, new Object[0]);
                }
                if (this.e.isEmpty()) {
                    this.c.set(0L);
                    break;
                }
                this.c.addAndGet(-((Long) r.second).longValue());
            }
            this.c.addAndGet(l);
            long currentTimeMillis = System.currentTimeMillis();
            file.setLastModified(currentTimeMillis);
            this.e.put(file, Long.valueOf(currentTimeMillis));
        }

        private b(File file, long j, int i) {
            this.e = new ConcurrentHashMap<>();
            this.a = file;
            this.f = j;
            this.d = i;
            this.c = new AtomicLong();
            this.b = new AtomicInteger();
            k();
        }
    }

    static {
        Covode.recordClassIndex(611466);
        b = new HashMap();
    }

    private static class c {
        static {
            Covode.recordClassIndex(611468);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static byte[] d(byte[] bArr) {
            if (h(bArr)) {
                return e(bArr, i(bArr, ' ') + 1, bArr.length);
            }
            return bArr;
        }

        private static boolean h(byte[] bArr) {
            if (bArr != null && bArr.length > 15 && bArr[13] == 45 && i(bArr, ' ') > 14) {
                return true;
            }
            return false;
        }

        private static String[] g(byte[] bArr) {
            if (h(bArr)) {
                return new String[]{new String(e(bArr, 0, 13)), new String(e(bArr, 14, i(bArr, ' ')))};
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean j(byte[] bArr) {
            String[] g = g(bArr);
            if (g != null && g.length == 2) {
                String str = g[0];
                while (str.startsWith("0")) {
                    str = str.substring(1, str.length());
                }
                if (System.currentTimeMillis() > Long.valueOf(str).longValue() + (Long.valueOf(g[1]).longValue() * 1000)) {
                    return true;
                }
            }
            return false;
        }

        private static String f(int i) {
            String str = System.currentTimeMillis() + "";
            while (str.length() < 13) {
                str = "0" + str;
            }
            return str + "-" + i + ' ';
        }

        private static int i(byte[] bArr, char c) {
            for (int i = 0; i < bArr.length; i++) {
                if (bArr[i] == c) {
                    return i;
                }
            }
            return -1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static byte[] k(int i, byte[] bArr) {
            byte[] bytes = f(i).getBytes();
            byte[] bArr2 = new byte[bytes.length + bArr.length];
            System.arraycopy(bytes, 0, bArr2, 0, bytes.length);
            System.arraycopy(bArr, 0, bArr2, bytes.length, bArr.length);
            return bArr2;
        }

        private static byte[] e(byte[] bArr, int i, int i2) {
            int i3 = i2 - i;
            if (i3 >= 0) {
                byte[] bArr2 = new byte[i3];
                System.arraycopy(bArr, i, bArr2, 0, Math.min(bArr.length - i, i3));
                return bArr2;
            }
            throw new IllegalArgumentException(i + " > " + i2);
        }
    }

    public <T> T f(String str) {
        return (T) g(str, false);
    }

    public static a b(File file) {
        return c(file, 100000000L, Integer.MAX_VALUE);
    }

    public boolean i(String str) {
        return this.a.n(str).exists();
    }

    public boolean p(String str) {
        boolean q = this.a.q(str);
        j(true, 4, "删除文件，key:%s, result:%b", str, Boolean.valueOf(q));
        return q;
    }

    public byte[] d(String str, boolean z) {
        return e(str, z, false);
    }

    public <T> T g(String str, boolean z) {
        return (T) h(str, z, false);
    }

    public void m(String str, byte[] bArr) {
        o(str, bArr, false);
    }

    public void k(String str, Serializable serializable, int i) {
        l(str, serializable, i, false);
    }

    public static a c(File file, long j, int i) {
        Map<String, a> map = b;
        a aVar = map.get(file.getAbsolutePath());
        if (aVar == null) {
            a aVar2 = new a(file, j, i);
            map.put(file.getAbsolutePath(), aVar2);
            return aVar2;
        }
        return aVar;
    }

    private a(File file, long j, int i) {
        if (!file.exists() && !file.mkdirs()) {
            throw new RuntimeException("can't make dirs in " + file.getAbsolutePath());
        }
        this.a = new b(file, j, i);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00a5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:43:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00be A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public byte[] e(java.lang.String r13, boolean r14, boolean r15) {
        /*
            Method dump skipped, instructions count: 211
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.local.a.e(java.lang.String, boolean, boolean):byte[]");
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x009d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:51:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0093 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public <T> T h(java.lang.String r8, boolean r9, boolean r10) {
        /*
            r7 = this;
            byte[] r9 = r7.e(r8, r9, r10)
            r0 = 0
            if (r9 == 0) goto La6
            r1 = 0
            java.io.ByteArrayInputStream r2 = new java.io.ByteArrayInputStream     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L53
            r2.<init>(r9)     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L53
            java.io.ObjectInputStream r3 = new java.io.ObjectInputStream     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4d
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4d
            java.lang.Object r4 = r3.readObject()     // Catch: java.lang.Exception -> L48 java.lang.Throwable -> L8f
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L48 java.lang.Throwable -> L8f
            r5.<init>()     // Catch: java.lang.Exception -> L48 java.lang.Throwable -> L8f
            java.lang.String r6 = "成功获取文件内容，key: "
            r5.append(r6)     // Catch: java.lang.Exception -> L48 java.lang.Throwable -> L8f
            r5.append(r8)     // Catch: java.lang.Exception -> L48 java.lang.Throwable -> L8f
            java.lang.String r6 = ", data length:"
            r5.append(r6)     // Catch: java.lang.Exception -> L48 java.lang.Throwable -> L8f
            int r9 = r9.length     // Catch: java.lang.Exception -> L48 java.lang.Throwable -> L8f
            r5.append(r9)     // Catch: java.lang.Exception -> L48 java.lang.Throwable -> L8f
            java.lang.String r9 = r5.toString()     // Catch: java.lang.Exception -> L48 java.lang.Throwable -> L8f
            java.lang.Object[] r5 = new java.lang.Object[r1]     // Catch: java.lang.Exception -> L48 java.lang.Throwable -> L8f
            r6 = 4
            r7.j(r10, r6, r9, r5)     // Catch: java.lang.Exception -> L48 java.lang.Throwable -> L8f
            r2.close()     // Catch: java.lang.Exception -> L3b
            goto L3f
        L3b:
            r8 = move-exception
            r8.printStackTrace()
        L3f:
            r3.close()     // Catch: java.lang.Exception -> L43
            goto L47
        L43:
            r8 = move-exception
            r8.printStackTrace()
        L47:
            return r4
        L48:
            r9 = move-exception
            goto L56
        L4a:
            r8 = move-exception
            r3 = r0
            goto L90
        L4d:
            r9 = move-exception
            r3 = r0
            goto L56
        L50:
            r8 = move-exception
            r3 = r0
            goto L91
        L53:
            r9 = move-exception
            r2 = r0
            r3 = r2
        L56:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L8f
            r4.<init>()     // Catch: java.lang.Throwable -> L8f
            java.lang.String r5 = "获取 "
            r4.append(r5)     // Catch: java.lang.Throwable -> L8f
            r4.append(r8)     // Catch: java.lang.Throwable -> L8f
            java.lang.String r8 = ", 内容出错: "
            r4.append(r8)     // Catch: java.lang.Throwable -> L8f
            java.lang.String r8 = android.util.Log.getStackTraceString(r9)     // Catch: java.lang.Throwable -> L8f
            r4.append(r8)     // Catch: java.lang.Throwable -> L8f
            java.lang.String r8 = r4.toString()     // Catch: java.lang.Throwable -> L8f
            java.lang.Object[] r9 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L8f
            r1 = 6
            r7.j(r10, r1, r8, r9)     // Catch: java.lang.Throwable -> L8f
            if (r2 == 0) goto L84
            r2.close()     // Catch: java.lang.Exception -> L80
            goto L84
        L80:
            r8 = move-exception
            r8.printStackTrace()
        L84:
            if (r3 == 0) goto L8e
            r3.close()     // Catch: java.lang.Exception -> L8a
            goto L8e
        L8a:
            r8 = move-exception
            r8.printStackTrace()
        L8e:
            return r0
        L8f:
            r8 = move-exception
        L90:
            r0 = r2
        L91:
            if (r0 == 0) goto L9b
            r0.close()     // Catch: java.lang.Exception -> L97
            goto L9b
        L97:
            r9 = move-exception
            r9.printStackTrace()
        L9b:
            if (r3 == 0) goto La5
            r3.close()     // Catch: java.lang.Exception -> La1
            goto La5
        La1:
            r9 = move-exception
            r9.printStackTrace()
        La5:
            throw r8
        La6:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.local.a.h(java.lang.String, boolean, boolean):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x007f, code lost:
    
        if (r6 != false) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x00cd, code lost:
    
        r16.a.p(r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x00d2, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x00c7, code lost:
    
        r16.a.s(r10, r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00c5, code lost:
    
        if (r6 == false) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void o(java.lang.String r17, byte[] r18, boolean r19) {
        /*
            Method dump skipped, instructions count: 263
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.local.a.o(java.lang.String, byte[], boolean):void");
    }

    public void n(String str, byte[] bArr, int i, boolean z) {
        o(str, c.k(i, bArr), z);
    }

    private void j(boolean z, int i, String str, Object... objArr) {
        if (z) {
            if (i <= 4) {
                LogWrapper.info("FileCacheHelper", str, objArr);
            } else if (i <= 6) {
                LogWrapper.error("FileCacheHelper", str, objArr);
            }
        }
    }

    public void l(String str, Serializable serializable, int i, boolean z) {
        ByteArrayOutputStream byteArrayOutputStream;
        ObjectOutputStream objectOutputStream;
        ObjectOutputStream objectOutputStream2 = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                try {
                    objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                } catch (Exception e) {
                    e = e;
                }
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e2) {
            e = e2;
            byteArrayOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            byteArrayOutputStream = null;
        }
        try {
            objectOutputStream.writeObject(serializable);
            objectOutputStream.flush();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            if (i != -1) {
                n(str, byteArray, i, z);
            } else {
                o(str, byteArray, z);
            }
            j(z, 4, "写入数据成功，key:%s, length:%d，saveTime:%d", str, Integer.valueOf(byteArray.length), Integer.valueOf(i));
            try {
                objectOutputStream.close();
                byteArrayOutputStream.close();
            } catch (Exception e3) {
                j(true, 6, Log.getStackTraceString(e3), new Object[0]);
            }
        } catch (Exception e4) {
            e = e4;
            objectOutputStream2 = objectOutputStream;
            j(true, 6, "写入数据异常，key:%s, error:%s", str, Log.getStackTraceString(e));
            try {
                objectOutputStream2.close();
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
            } catch (Exception e5) {
                j(true, 6, Log.getStackTraceString(e5), new Object[0]);
            }
        } catch (Throwable th3) {
            th = th3;
            objectOutputStream2 = objectOutputStream;
            try {
                objectOutputStream2.close();
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
            } catch (Exception e6) {
                j(true, 6, Log.getStackTraceString(e6), new Object[0]);
            }
            throw th;
        }
    }
}
