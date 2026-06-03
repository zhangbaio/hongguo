package com.xiaomi.push.service;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import com.bytedance.covode.number.Covode;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;
import java.util.Comparator;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.Skip;
import me.ele.lancet.base.annotations.TargetClass;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class ae {
    private static long a;

    /* renamed from: a, reason: collision with other field name */
    private static boolean f910a;
    private static long b;

    private static void a(Context context, byte[] bArr, String str) {
        PolarisFileOutputStreamWrapper polarisFileOutputStreamWrapper;
        BufferedOutputStream bufferedOutputStream;
        if (bArr == null) {
            com.xiaomi.channel.commonutils.logger.b.m54a("cannot save small icon cause bitmap is null");
            return;
        }
        m680a(context);
        BufferedOutputStream bufferedOutputStream2 = null;
        try {
            PolarisFileWrapper polarisFileWrapper = new PolarisFileWrapper(a(context));
            if (!polarisFileWrapper.exists()) {
                polarisFileWrapper.mkdirs();
            }
            PolarisFileWrapper polarisFileWrapper2 = new PolarisFileWrapper(polarisFileWrapper, com.xiaomi.push.ba.a(str));
            if (!polarisFileWrapper2.exists()) {
                polarisFileWrapper2.createNewFile();
            }
            polarisFileOutputStreamWrapper = new PolarisFileOutputStreamWrapper(polarisFileWrapper2);
            try {
                try {
                    bufferedOutputStream = new BufferedOutputStream(polarisFileOutputStreamWrapper);
                } catch (Exception e) {
                    e = e;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                bufferedOutputStream.write(bArr);
                bufferedOutputStream.flush();
                a += polarisFileWrapper2.length();
                long j = b;
                if (j <= 0) {
                    b = polarisFileWrapper2.lastModified();
                } else {
                    b = Math.min(j, polarisFileWrapper2.lastModified());
                }
                com.xiaomi.push.v.a(bufferedOutputStream);
            } catch (Exception e2) {
                e = e2;
                bufferedOutputStream2 = bufferedOutputStream;
                com.xiaomi.channel.commonutils.logger.b.d("Save pic error: " + e);
                com.xiaomi.push.v.a(bufferedOutputStream2);
                com.xiaomi.push.v.a((Closeable) polarisFileOutputStreamWrapper);
            } catch (Throwable th2) {
                th = th2;
                bufferedOutputStream2 = bufferedOutputStream;
                com.xiaomi.push.v.a(bufferedOutputStream2);
                com.xiaomi.push.v.a((Closeable) polarisFileOutputStreamWrapper);
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            polarisFileOutputStreamWrapper = null;
        } catch (Throwable th3) {
            th = th3;
            polarisFileOutputStreamWrapper = null;
        }
        com.xiaomi.push.v.a((Closeable) polarisFileOutputStreamWrapper);
    }

    static {
        Covode.recordClassIndex(655663);
        b = 0L;
        f910a = false;
    }

    @Proxy("openConnection")
    @TargetClass("java.net.URL")
    @Skip({"com.bytedance.crash.upload.CrashUploader"})
    public static URLConnection INVOKEVIRTUAL_com_xiaomi_push_service_ae_com_dragon_read_aop_NetworkTrafficAop_openConnection(URL url) throws IOException {
        URLConnection openConnection = url.openConnection();
        if (!u55.k.o()) {
            return openConnection;
        }
        return u55.b.a(openConnection);
    }

    private static String a(Context context) {
        return context.getCacheDir().getPath() + File.separator + "mipush_icon";
    }

    private static void a(File[] fileArr) {
        if (fileArr != null) {
            try {
                if (fileArr.length > 1) {
                    Arrays.sort(fileArr, new Comparator<File>() { // from class: com.xiaomi.push.service.ae.1
                        @Override // java.util.Comparator
                        /* renamed from: a, reason: merged with bridge method [inline-methods] */
                        public int compare(File file, File file2) {
                            if (file == file2) {
                                return 0;
                            }
                            if (file == null) {
                                return 1;
                            }
                            if (file2 == null) {
                                return -1;
                            }
                            long lastModified = file.lastModified() - file2.lastModified();
                            if (lastModified == 0) {
                                return 0;
                            }
                            if (lastModified < 0) {
                                return 1;
                            }
                            return -1;
                        }
                    });
                }
            } catch (Throwable th) {
                com.xiaomi.channel.commonutils.logger.b.d("Sort pic cache error: " + th);
            }
        }
    }

    private static synchronized void b(Context context) {
        String str;
        PolarisFileWrapper polarisFileWrapper;
        synchronized (ae.class) {
            if (f910a) {
                return;
            }
            a = 0L;
            b = 0L;
            try {
                polarisFileWrapper = new PolarisFileWrapper(a(context));
            } catch (Throwable th) {
                try {
                    com.xiaomi.channel.commonutils.logger.b.d("Init pic cache error: " + th);
                    f910a = true;
                    str = "Init pic cache finish.";
                } finally {
                    f910a = true;
                    com.xiaomi.channel.commonutils.logger.b.b("Init pic cache finish.");
                }
            }
            if (!polarisFileWrapper.exists()) {
                return;
            }
            File[] listFiles = polarisFileWrapper.listFiles();
            if (listFiles != null) {
                for (File file : listFiles) {
                    a += file.length();
                    long j = b;
                    if (j <= 0) {
                        b = file.lastModified();
                    } else {
                        b = Math.min(j, file.lastModified());
                    }
                }
            }
            f910a = true;
            str = "Init pic cache finish.";
            com.xiaomi.channel.commonutils.logger.b.b(str);
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    private static synchronized void m680a(Context context) {
        PolarisFileWrapper polarisFileWrapper;
        long j;
        synchronized (ae.class) {
            b(context);
            if (a < 62914560 && System.currentTimeMillis() - b < 1209600000) {
                return;
            }
            try {
                polarisFileWrapper = new PolarisFileWrapper(a(context));
            } catch (Throwable th) {
                com.xiaomi.channel.commonutils.logger.b.d("Clear pic cache error: " + th);
            }
            if (!polarisFileWrapper.exists()) {
                com.xiaomi.channel.commonutils.logger.b.m54a("The pic cache dir do not exists.");
                return;
            }
            File[] listFiles = polarisFileWrapper.listFiles();
            if (listFiles != null) {
                a(listFiles);
                long j2 = a;
                int length = listFiles.length - 1;
                while (true) {
                    if (length >= 0) {
                        File file = listFiles[length];
                        if (file != null) {
                            if (j2 <= 31457280 && System.currentTimeMillis() - file.lastModified() <= 864000000) {
                                j = file.lastModified();
                                break;
                            }
                            j2 -= file.length();
                            file.delete();
                        }
                        length--;
                    } else {
                        j = 0;
                        break;
                    }
                }
                a = Math.max(j2, 0L);
                b = j;
            } else {
                com.xiaomi.channel.commonutils.logger.b.m54a("The pic cache file list is null.");
            }
        }
    }

    public static class a {
        int a;

        /* renamed from: a, reason: collision with other field name */
        byte[] f911a;

        static {
            Covode.recordClassIndex(655664);
        }

        public a(byte[] bArr, int i) {
            this.f911a = bArr;
            this.a = i;
        }
    }

    public static class b {
        public long a;

        /* renamed from: a, reason: collision with other field name */
        public Bitmap f912a;

        static {
            Covode.recordClassIndex(655665);
        }

        public b(Bitmap bitmap, long j) {
            this.f912a = bitmap;
            this.a = j;
        }
    }

    private static int a(Context context, InputStream inputStream) {
        int i;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(inputStream, null, options);
        if (options.outWidth != -1 && options.outHeight != -1) {
            int round = Math.round((context.getResources().getDisplayMetrics().densityDpi / 160.0f) * 48.0f);
            int i2 = options.outWidth;
            if (i2 <= round || (i = options.outHeight) <= round) {
                return 1;
            }
            return Math.min(i2 / round, i / round);
        }
        com.xiaomi.channel.commonutils.logger.b.m54a("decode dimension failed for bitmap.");
        return 1;
    }

    private static synchronized Bitmap b(Context context, String str) {
        PolarisFileInputStreamWrapper polarisFileInputStreamWrapper;
        PolarisFileWrapper polarisFileWrapper;
        synchronized (ae.class) {
            PolarisFileInputStreamWrapper polarisFileInputStreamWrapper2 = null;
            try {
                polarisFileWrapper = new PolarisFileWrapper(a(context), com.xiaomi.push.ba.a(str));
            } catch (Throwable th) {
                th = th;
                polarisFileInputStreamWrapper = null;
            }
            if (!polarisFileWrapper.exists()) {
                return null;
            }
            if (System.currentTimeMillis() - polarisFileWrapper.lastModified() > 1209600000) {
                com.xiaomi.channel.commonutils.logger.b.m54a("The pic cache has expired.");
                return null;
            }
            PolarisFileInputStreamWrapper polarisFileInputStreamWrapper3 = new PolarisFileInputStreamWrapper(polarisFileWrapper);
            try {
                polarisFileInputStreamWrapper2 = BitmapFactory.decodeStream(polarisFileInputStreamWrapper3);
                polarisFileWrapper.setLastModified(System.currentTimeMillis());
                com.xiaomi.push.v.a((Closeable) polarisFileInputStreamWrapper3);
            } catch (Throwable th2) {
                PolarisFileInputStreamWrapper polarisFileInputStreamWrapper4 = polarisFileInputStreamWrapper2;
                polarisFileInputStreamWrapper2 = polarisFileInputStreamWrapper3;
                th = th2;
                polarisFileInputStreamWrapper = polarisFileInputStreamWrapper4;
                try {
                    com.xiaomi.channel.commonutils.logger.b.d("Load bmp from cache error: " + th);
                    polarisFileInputStreamWrapper2 = polarisFileInputStreamWrapper;
                    return polarisFileInputStreamWrapper2;
                } finally {
                    com.xiaomi.push.v.a((Closeable) polarisFileInputStreamWrapper2);
                }
            }
            return polarisFileInputStreamWrapper2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r0v3 */
    public static Bitmap a(Context context, String str) {
        InputStream inputStream;
        InputStream inputStream2;
        Uri parse = Uri.parse(str);
        ?? r0 = 0;
        r0 = 0;
        try {
            try {
                inputStream = ContentResolverWrapper.openInputStream(context.getContentResolver(), parse);
            } catch (Throwable th) {
                th = th;
                r0 = context;
            }
        } catch (IOException e) {
            e = e;
            inputStream2 = null;
            inputStream = null;
        } catch (Throwable th2) {
            th = th2;
            inputStream = null;
        }
        try {
            int a2 = a(context, inputStream);
            inputStream2 = ContentResolverWrapper.openInputStream(context.getContentResolver(), parse);
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = a2;
                Bitmap decodeStream = BitmapFactory.decodeStream(inputStream2, null, options);
                com.xiaomi.push.v.a((Closeable) inputStream2);
                com.xiaomi.push.v.a((Closeable) inputStream);
                return decodeStream;
            } catch (IOException e2) {
                e = e2;
                com.xiaomi.channel.commonutils.logger.b.a(e);
                com.xiaomi.push.v.a((Closeable) inputStream2);
                com.xiaomi.push.v.a((Closeable) inputStream);
                return null;
            }
        } catch (IOException e3) {
            e = e3;
            inputStream2 = null;
        } catch (Throwable th3) {
            th = th3;
            com.xiaomi.push.v.a((Closeable) r0);
            com.xiaomi.push.v.a((Closeable) inputStream);
            throw th;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x00fd, code lost:
    
        if (r1 == null) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0100, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00e0, code lost:
    
        r1.disconnect();
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00de, code lost:
    
        if (r1 == null) goto L54;
     */
    /* JADX WARN: Not initialized variable reg: 2, insn: 0x0102: MOVE (r0 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]) (LINE:34013442), block:B:59:0x0102 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static com.xiaomi.push.service.ae.a a(java.lang.String r10, boolean r11) {
        /*
            Method dump skipped, instructions count: 268
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.ae.a(java.lang.String, boolean):com.xiaomi.push.service.ae$a");
    }

    public static b a(Context context, String str, boolean z) {
        Bitmap b2;
        ByteArrayInputStream byteArrayInputStream = null;
        b bVar = new b(null, 0L);
        try {
            try {
                b2 = b(context, str);
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e) {
            e = e;
        }
        if (b2 != null) {
            bVar.f912a = b2;
            com.xiaomi.push.v.a((Closeable) null);
            return bVar;
        }
        a a2 = a(str, z);
        if (a2 == null) {
            com.xiaomi.push.v.a((Closeable) null);
            return bVar;
        }
        bVar.a = a2.a;
        byte[] bArr = a2.f911a;
        if (bArr != null) {
            if (z) {
                ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(bArr);
                try {
                    int a3 = a(context, byteArrayInputStream2);
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inSampleSize = a3;
                    bVar.f912a = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
                    byteArrayInputStream = byteArrayInputStream2;
                } catch (Exception e2) {
                    e = e2;
                    byteArrayInputStream = byteArrayInputStream2;
                    com.xiaomi.channel.commonutils.logger.b.a(e);
                    com.xiaomi.push.v.a((Closeable) byteArrayInputStream);
                    return bVar;
                } catch (Throwable th2) {
                    th = th2;
                    byteArrayInputStream = byteArrayInputStream2;
                    com.xiaomi.push.v.a((Closeable) byteArrayInputStream);
                    throw th;
                }
            } else {
                bVar.f912a = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
            }
        }
        a(context, a2.f911a, str);
        com.xiaomi.push.v.a((Closeable) byteArrayInputStream);
        return bVar;
    }
}
