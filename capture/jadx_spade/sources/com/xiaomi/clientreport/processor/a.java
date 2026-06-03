package com.xiaomi.clientreport.processor;

import android.content.Context;
import android.text.TextUtils;
import android.text.format.Formatter;
import android.util.Base64;
import com.bytedance.covode.number.Covode;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.xiaomi.clientreport.data.EventClientReport;
import com.xiaomi.push.ba;
import com.xiaomi.push.bk;
import com.xiaomi.push.h;
import com.xiaomi.push.v;
import com.xiaomi.push.x;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class a implements IEventProcessor {
    protected Context a;

    /* renamed from: a, reason: collision with other field name */
    private HashMap<String, ArrayList<com.xiaomi.clientreport.data.a>> f21a;

    static {
        Covode.recordClassIndex(655251);
    }

    @Override // com.xiaomi.clientreport.processor.d
    public void b() {
        HashMap<String, ArrayList<com.xiaomi.clientreport.data.a>> hashMap = this.f21a;
        if (hashMap == null) {
            return;
        }
        if (hashMap.size() > 0) {
            Iterator<String> it2 = this.f21a.keySet().iterator();
            while (it2.hasNext()) {
                ArrayList<com.xiaomi.clientreport.data.a> arrayList = this.f21a.get(it2.next());
                if (arrayList != null && arrayList.size() > 0) {
                    com.xiaomi.clientreport.data.a[] aVarArr = new com.xiaomi.clientreport.data.a[arrayList.size()];
                    arrayList.toArray(aVarArr);
                    m67a(aVarArr);
                }
            }
        }
        this.f21a.clear();
    }

    @Override // com.xiaomi.clientreport.processor.c
    public void a() {
        RandomAccessFile randomAccessFile;
        bk.a(this.a, "event", "eventUploading");
        File[] m190a = bk.m190a(this.a, "eventUploading");
        if (m190a != null && m190a.length > 0) {
            FileLock fileLock = null;
            RandomAccessFile randomAccessFile2 = null;
            File file = null;
            for (File file2 : m190a) {
                if (file2 == null) {
                    if (fileLock != null && fileLock.isValid()) {
                        try {
                            fileLock.release();
                        } catch (IOException e) {
                            com.xiaomi.channel.commonutils.logger.b.a(e);
                        }
                    }
                    v.a(randomAccessFile2);
                    if (file == null) {
                    }
                    file.delete();
                } else {
                    try {
                        try {
                        } catch (Throwable th) {
                            th = th;
                        }
                    } catch (Exception e2) {
                        e = e2;
                    }
                    if (file2.length() > 5242880) {
                        com.xiaomi.channel.commonutils.logger.b.d("eventData read from cache file failed because " + file2.getName() + " is too big, length " + file2.length());
                        a(file2.getName(), Formatter.formatFileSize(this.a, file2.length()));
                        file2.delete();
                        if (fileLock != null && fileLock.isValid()) {
                            try {
                                fileLock.release();
                            } catch (IOException e3) {
                                com.xiaomi.channel.commonutils.logger.b.a(e3);
                            }
                        }
                        v.a(randomAccessFile2);
                        if (file == null) {
                        }
                        file.delete();
                    } else {
                        String absolutePath = file2.getAbsolutePath();
                        File polarisFileWrapper = new PolarisFileWrapper(absolutePath + ".lock");
                        try {
                            v.m769a(polarisFileWrapper);
                            randomAccessFile = new RandomAccessFile(polarisFileWrapper, "rw");
                        } catch (Exception e4) {
                            e = e4;
                        } catch (Throwable th2) {
                            th = th2;
                        }
                        try {
                            fileLock = randomAccessFile.getChannel().lock();
                            a(a(absolutePath));
                            file2.delete();
                            if (fileLock != null && fileLock.isValid()) {
                                try {
                                    fileLock.release();
                                } catch (IOException e5) {
                                    com.xiaomi.channel.commonutils.logger.b.a(e5);
                                }
                            }
                            v.a(randomAccessFile);
                            polarisFileWrapper.delete();
                            randomAccessFile2 = randomAccessFile;
                            file = polarisFileWrapper;
                        } catch (Exception e6) {
                            e = e6;
                            randomAccessFile2 = randomAccessFile;
                            file = polarisFileWrapper;
                            com.xiaomi.channel.commonutils.logger.b.a(e);
                            if (fileLock != null && fileLock.isValid()) {
                                try {
                                    fileLock.release();
                                } catch (IOException e7) {
                                    com.xiaomi.channel.commonutils.logger.b.a(e7);
                                }
                            }
                            v.a(randomAccessFile2);
                            if (file == null) {
                            }
                            file.delete();
                        } catch (Throwable th3) {
                            th = th3;
                            randomAccessFile2 = randomAccessFile;
                            file = polarisFileWrapper;
                            if (fileLock != null && fileLock.isValid()) {
                                try {
                                    fileLock.release();
                                } catch (IOException e8) {
                                    com.xiaomi.channel.commonutils.logger.b.a(e8);
                                }
                            }
                            v.a(randomAccessFile2);
                            if (file != null) {
                                file.delete();
                                throw th;
                            }
                            throw th;
                        }
                    }
                }
            }
        }
    }

    public void a(Context context) {
        this.a = context;
    }

    @Override // com.xiaomi.clientreport.processor.IEventProcessor
    public void setEventMap(HashMap<String, ArrayList<com.xiaomi.clientreport.data.a>> hashMap) {
        this.f21a = hashMap;
    }

    public a(Context context) {
        a(context);
    }

    public static String a(com.xiaomi.clientreport.data.a aVar) {
        return String.valueOf(aVar.production);
    }

    public void a(List<String> list) {
        bk.a(this.a, list);
    }

    private String b(com.xiaomi.clientreport.data.a aVar) {
        PolarisFileWrapper polarisFileWrapper = new PolarisFileWrapper(this.a.getFilesDir(), "event");
        String str = polarisFileWrapper.getAbsolutePath() + File.separator + a(aVar);
        for (int i = 0; i < 100; i++) {
            String str2 = str + i;
            if (bk.m189a(this.a, str2)) {
                return str2;
            }
        }
        return null;
    }

    @Override // com.xiaomi.clientreport.processor.d
    /* renamed from: a, reason: collision with other method in class */
    public void mo66a(com.xiaomi.clientreport.data.a aVar) {
        if (!(aVar instanceof EventClientReport) || this.f21a == null) {
            return;
        }
        EventClientReport eventClientReport = (EventClientReport) aVar;
        String a = a((com.xiaomi.clientreport.data.a) eventClientReport);
        ArrayList<com.xiaomi.clientreport.data.a> arrayList = this.f21a.get(a);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }
        arrayList.add(eventClientReport);
        this.f21a.put(a, arrayList);
    }

    @Override // com.xiaomi.clientreport.processor.IEventProcessor
    public String bytesToString(byte[] bArr) {
        byte[] a;
        if (bArr != null && bArr.length >= 1) {
            if (!com.xiaomi.clientreport.manager.a.a(this.a).m63a().isEventEncrypted()) {
                return ba.b(bArr);
            }
            String a2 = bk.a(this.a);
            if (!TextUtils.isEmpty(a2) && (a = bk.a(a2)) != null && a.length > 0) {
                try {
                    return ba.b(Base64.decode(h.a(a, bArr), 2));
                } catch (InvalidAlgorithmParameterException e) {
                    com.xiaomi.channel.commonutils.logger.b.a(e);
                } catch (InvalidKeyException e2) {
                    com.xiaomi.channel.commonutils.logger.b.a(e2);
                } catch (NoSuchAlgorithmException e3) {
                    com.xiaomi.channel.commonutils.logger.b.a(e3);
                } catch (BadPaddingException e4) {
                    com.xiaomi.channel.commonutils.logger.b.a(e4);
                } catch (IllegalBlockSizeException e5) {
                    com.xiaomi.channel.commonutils.logger.b.a(e5);
                } catch (NoSuchPaddingException e6) {
                    com.xiaomi.channel.commonutils.logger.b.a(e6);
                }
            }
        }
        return null;
    }

    @Override // com.xiaomi.clientreport.processor.IEventProcessor
    public byte[] stringToBytes(String str) {
        byte[] a;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!com.xiaomi.clientreport.manager.a.a(this.a).m63a().isEventEncrypted()) {
            return ba.m182a(str);
        }
        String a2 = bk.a(this.a);
        byte[] m182a = ba.m182a(str);
        if (!TextUtils.isEmpty(a2) && m182a != null && m182a.length > 1 && (a = bk.a(a2)) != null) {
            try {
                if (a.length > 1) {
                    return h.b(a, Base64.encode(m182a, 2));
                }
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
            }
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x0069, code lost:
    
        com.xiaomi.channel.commonutils.logger.b.d("eventData read from cache file failed cause lengthBuffer < 1 || lengthBuffer > 4K");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.util.List<java.lang.String> a(java.lang.String r9) {
        /*
            r8 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 4
            byte[] r2 = new byte[r1]
            byte[] r3 = new byte[r1]
            r4 = 0
            com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper r5 = new com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper     // Catch: java.lang.Throwable -> L78 java.lang.Exception -> L7a
            com.bytedance.security.android.aopcheck.PolarisFileWrapper r6 = new com.bytedance.security.android.aopcheck.PolarisFileWrapper     // Catch: java.lang.Throwable -> L78 java.lang.Exception -> L7a
            r6.<init>(r9)     // Catch: java.lang.Throwable -> L78 java.lang.Exception -> L7a
            r5.<init>(r6)     // Catch: java.lang.Throwable -> L78 java.lang.Exception -> L7a
        L15:
            int r9 = r5.read(r2)     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L75
            r4 = -1
            if (r9 != r4) goto L1d
            goto L6e
        L1d:
            java.lang.String r6 = "eventData read from cache file failed because magicNumber error"
            if (r9 == r1) goto L25
            com.xiaomi.channel.commonutils.logger.b.d(r6)     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L75
            goto L6e
        L25:
            int r9 = com.xiaomi.push.x.a(r2)     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L75
            r7 = -573785174(0xffffffffddccbbaa, float:-1.8440715E18)
            if (r9 == r7) goto L32
            com.xiaomi.channel.commonutils.logger.b.d(r6)     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L75
            goto L6e
        L32:
            int r9 = r5.read(r3)     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L75
            if (r9 != r4) goto L39
            goto L6e
        L39:
            if (r9 == r1) goto L41
            java.lang.String r9 = "eventData read from cache file failed cause lengthBuffer error"
            com.xiaomi.channel.commonutils.logger.b.d(r9)     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L75
            goto L6e
        L41:
            int r9 = com.xiaomi.push.x.a(r3)     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L75
            r4 = 1
            if (r9 < r4) goto L69
            r4 = 4096(0x1000, float:5.74E-42)
            if (r9 <= r4) goto L4d
            goto L69
        L4d:
            byte[] r4 = new byte[r9]     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L75
            int r6 = r5.read(r4)     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L75
            if (r6 == r9) goto L5b
            java.lang.String r9 = "eventData read from cache file failed cause buffer size not equal length"
            com.xiaomi.channel.commonutils.logger.b.d(r9)     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L75
            goto L6e
        L5b:
            java.lang.String r9 = r8.bytesToString(r4)     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L75
            boolean r4 = android.text.TextUtils.isEmpty(r9)     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L75
            if (r4 != 0) goto L15
            r0.add(r9)     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L75
            goto L15
        L69:
            java.lang.String r9 = "eventData read from cache file failed cause lengthBuffer < 1 || lengthBuffer > 4K"
            com.xiaomi.channel.commonutils.logger.b.d(r9)     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L75
        L6e:
            com.xiaomi.push.v.a(r5)
            goto L81
        L72:
            r9 = move-exception
            r4 = r5
            goto L82
        L75:
            r9 = move-exception
            r4 = r5
            goto L7b
        L78:
            r9 = move-exception
            goto L82
        L7a:
            r9 = move-exception
        L7b:
            com.xiaomi.channel.commonutils.logger.b.a(r9)     // Catch: java.lang.Throwable -> L78
            com.xiaomi.push.v.a(r4)
        L81:
            return r0
        L82:
            com.xiaomi.push.v.a(r4)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.clientreport.processor.a.a(java.lang.String):java.util.List");
    }

    private com.xiaomi.clientreport.data.a[] a(com.xiaomi.clientreport.data.a[] aVarArr) {
        FileLock fileLock;
        RandomAccessFile randomAccessFile;
        BufferedOutputStream bufferedOutputStream;
        String b = b(aVarArr[0]);
        BufferedOutputStream bufferedOutputStream2 = null;
        if (TextUtils.isEmpty(b)) {
            return null;
        }
        try {
            PolarisFileWrapper polarisFileWrapper = new PolarisFileWrapper(b + ".lock");
            v.m769a((File) polarisFileWrapper);
            randomAccessFile = new RandomAccessFile((File) polarisFileWrapper, "rw");
            try {
                fileLock = randomAccessFile.getChannel().lock();
            } catch (Exception e) {
                e = e;
                fileLock = null;
                bufferedOutputStream = null;
            } catch (Throwable th) {
                th = th;
                fileLock = null;
            }
        } catch (Exception e2) {
            e = e2;
            fileLock = null;
            randomAccessFile = null;
            bufferedOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            fileLock = null;
            randomAccessFile = null;
        }
        try {
            bufferedOutputStream = new BufferedOutputStream(new PolarisFileOutputStreamWrapper(new PolarisFileWrapper(b), true));
            try {
                try {
                    int i = 0;
                    for (com.xiaomi.clientreport.data.a aVar : aVarArr) {
                        if (aVar != null) {
                            byte[] stringToBytes = stringToBytes(aVar.toJsonString());
                            if (stringToBytes != null && stringToBytes.length >= 1 && stringToBytes.length <= 4096) {
                                if (!bk.m189a(this.a, b)) {
                                    int length = aVarArr.length - i;
                                    com.xiaomi.clientreport.data.a[] aVarArr2 = new com.xiaomi.clientreport.data.a[length];
                                    System.arraycopy(aVarArr, i, aVarArr2, 0, length);
                                    v.a(bufferedOutputStream);
                                    a(randomAccessFile, fileLock);
                                    return aVarArr2;
                                }
                                bufferedOutputStream.write(x.a(-573785174));
                                bufferedOutputStream.write(x.a(stringToBytes.length));
                                bufferedOutputStream.write(stringToBytes);
                                bufferedOutputStream.flush();
                                i++;
                            }
                            com.xiaomi.channel.commonutils.logger.b.d("event data throw a invalid item ");
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                    com.xiaomi.channel.commonutils.logger.b.a("event data write to cache file failed cause exception", e);
                    v.a(bufferedOutputStream);
                    a(randomAccessFile, fileLock);
                    return null;
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedOutputStream2 = bufferedOutputStream;
                v.a(bufferedOutputStream2);
                a(randomAccessFile, fileLock);
                throw th;
            }
        } catch (Exception e4) {
            e = e4;
            bufferedOutputStream = null;
        } catch (Throwable th4) {
            th = th4;
            v.a(bufferedOutputStream2);
            a(randomAccessFile, fileLock);
            throw th;
        }
        v.a(bufferedOutputStream);
        a(randomAccessFile, fileLock);
        return null;
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m67a(com.xiaomi.clientreport.data.a[] aVarArr) {
        if (aVarArr != null && aVarArr.length != 0 && aVarArr[0] != null) {
            do {
                aVarArr = a(aVarArr);
                if (aVarArr == null || aVarArr.length <= 0) {
                    return;
                }
            } while (aVarArr[0] != null);
            return;
        }
        com.xiaomi.channel.commonutils.logger.b.m54a("event data write to cache file failed because data null");
    }

    private void a(RandomAccessFile randomAccessFile, FileLock fileLock) {
        if (fileLock != null && fileLock.isValid()) {
            try {
                fileLock.release();
            } catch (IOException e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
            }
        }
        v.a(randomAccessFile);
    }

    private void a(String str, String str2) {
        EventClientReport a = com.xiaomi.clientreport.manager.a.a(this.a).a(5001, "24:" + str + "," + str2);
        ArrayList arrayList = new ArrayList();
        arrayList.add(a.toJsonString());
        a(arrayList);
    }
}
