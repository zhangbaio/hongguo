package com.xiaomi.clientreport.processor;

import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWriterWrapper;
import com.xiaomi.clientreport.data.PerfClientReport;
import com.xiaomi.push.v;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.HashMap;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class e {
    static {
        Covode.recordClassIndex(655255);
    }

    private static void a(HashMap<String, String> hashMap, String str, long j, long j2) {
        String str2;
        String str3 = hashMap.get(str);
        if (TextUtils.isEmpty(str3)) {
            hashMap.put(str, j + "#" + j2);
            return;
        }
        long[] m69a = m69a(str3);
        if (m69a != null) {
            long j3 = m69a[0];
            if (j3 > 0) {
                long j4 = m69a[1];
                if (j4 >= 0) {
                    str2 = (j + j3) + "#" + (j2 + j4);
                    hashMap.put(str, str2);
                }
            }
        }
        str2 = j + "#" + j2;
        hashMap.put(str, str2);
    }

    /* renamed from: a, reason: collision with other method in class */
    protected static long[] m69a(String str) {
        long[] jArr = new long[2];
        try {
            String[] split = str.split("#");
            if (split.length >= 2) {
                jArr[0] = Long.parseLong(split[0].trim());
                jArr[1] = Long.parseLong(split[1].trim());
            }
            return jArr;
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            return null;
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    private static String[] m70a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return str.split("#");
    }

    public static String a(PerfClientReport perfClientReport) {
        return perfClientReport.production + "#" + perfClientReport.clientInterfaceId + "#" + perfClientReport.reportType + "#" + perfClientReport.code;
    }

    private static PerfClientReport a(String str) {
        PerfClientReport perfClientReport = null;
        try {
            String[] m70a = m70a(str);
            if (m70a == null || m70a.length < 4 || TextUtils.isEmpty(m70a[0]) || TextUtils.isEmpty(m70a[1]) || TextUtils.isEmpty(m70a[2]) || TextUtils.isEmpty(m70a[3])) {
                return null;
            }
            perfClientReport = PerfClientReport.getBlankInstance();
            perfClientReport.production = Integer.parseInt(m70a[0]);
            perfClientReport.clientInterfaceId = m70a[1];
            perfClientReport.reportType = Integer.parseInt(m70a[2]);
            perfClientReport.code = Integer.parseInt(m70a[3]);
            return perfClientReport;
        } catch (Exception unused) {
            com.xiaomi.channel.commonutils.logger.b.c("parse per key error");
            return perfClientReport;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v12, types: [int] */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r5v8, types: [java.lang.String[]] */
    /* JADX WARN: Type inference failed for: r5v9, types: [java.lang.Object] */
    /* renamed from: a, reason: collision with other method in class */
    private static HashMap<String, String> m68a(String str) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str) && new PolarisFileWrapper(str).exists()) {
            BufferedReader bufferedReader = null;
            ?? r1 = 0;
            BufferedReader bufferedReader2 = null;
            try {
                try {
                    BufferedReader bufferedReader3 = new BufferedReader(new PolarisFileReaderWrapper(str));
                    while (true) {
                        try {
                            String readLine = bufferedReader3.readLine();
                            if (readLine == null) {
                                break;
                            }
                            ?? split = readLine.split("%%%");
                            r1 = split.length;
                            if (r1 >= 2) {
                                r1 = 0;
                                r1 = 0;
                                if (!TextUtils.isEmpty(split[0]) && !TextUtils.isEmpty(split[1])) {
                                    r1 = split[0];
                                    hashMap.put(r1, split[1]);
                                }
                            }
                        } catch (Exception e) {
                            e = e;
                            bufferedReader2 = bufferedReader3;
                            com.xiaomi.channel.commonutils.logger.b.a(e);
                            v.a(bufferedReader2);
                            bufferedReader = bufferedReader2;
                            return hashMap;
                        } catch (Throwable th) {
                            th = th;
                            bufferedReader = bufferedReader3;
                            v.a(bufferedReader);
                            throw th;
                        }
                    }
                    v.a(bufferedReader3);
                    bufferedReader = r1;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception e2) {
                e = e2;
            }
            return hashMap;
        }
        return hashMap;
    }

    private static PerfClientReport a(PerfClientReport perfClientReport, String str) {
        long[] m69a;
        if (perfClientReport == null || (m69a = m69a(str)) == null) {
            return null;
        }
        perfClientReport.perfCounts = m69a[0];
        perfClientReport.perfLatencies = m69a[1];
        return perfClientReport;
    }

    /* JADX WARN: Code restructure failed: missing block: B:67:0x00d5, code lost:
    
        if (r1 != null) goto L67;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:82:? A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v10, types: [java.io.BufferedReader, java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.List<java.lang.String> a(android.content.Context r7, java.lang.String r8) {
        /*
            Method dump skipped, instructions count: 249
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.clientreport.processor.e.a(android.content.Context, java.lang.String):java.util.List");
    }

    private static void a(String str, HashMap<String, String> hashMap) {
        BufferedWriter bufferedWriter;
        Throwable th;
        Exception e;
        if (!TextUtils.isEmpty(str) && hashMap != null && hashMap.size() != 0) {
            PolarisFileWrapper polarisFileWrapper = new PolarisFileWrapper(str);
            if (polarisFileWrapper.exists()) {
                polarisFileWrapper.delete();
            }
            try {
                bufferedWriter = new BufferedWriter(new PolarisFileWriterWrapper(polarisFileWrapper));
                try {
                    try {
                        for (String str2 : hashMap.keySet()) {
                            bufferedWriter.write(str2 + "%%%" + hashMap.get(str2));
                            bufferedWriter.newLine();
                        }
                    } catch (Exception e2) {
                        e = e2;
                        com.xiaomi.channel.commonutils.logger.b.a(e);
                        v.a(bufferedWriter);
                    }
                } catch (Throwable th2) {
                    th = th2;
                    v.a(bufferedWriter);
                    throw th;
                }
            } catch (Exception e3) {
                bufferedWriter = null;
                e = e3;
            } catch (Throwable th3) {
                bufferedWriter = null;
                th = th3;
                v.a(bufferedWriter);
                throw th;
            }
            v.a(bufferedWriter);
        }
    }

    public static void a(String str, com.xiaomi.clientreport.data.a[] aVarArr) {
        RandomAccessFile randomAccessFile;
        if (aVarArr != null && aVarArr.length > 0 && !TextUtils.isEmpty(str)) {
            FileLock fileLock = null;
            try {
                PolarisFileWrapper polarisFileWrapper = new PolarisFileWrapper(str + ".lock");
                v.m769a((File) polarisFileWrapper);
                randomAccessFile = new RandomAccessFile((File) polarisFileWrapper, "rw");
            } catch (Throwable unused) {
                randomAccessFile = null;
            }
            try {
                fileLock = randomAccessFile.getChannel().lock();
                HashMap<String, String> m68a = m68a(str);
                for (com.xiaomi.clientreport.data.a aVar : aVarArr) {
                    if (aVar != null) {
                        String a = a((PerfClientReport) aVar);
                        long j = ((PerfClientReport) aVar).perfCounts;
                        long j2 = ((PerfClientReport) aVar).perfLatencies;
                        if (!TextUtils.isEmpty(a) && j > 0 && j2 >= 0) {
                            a(m68a, a, j, j2);
                        }
                    }
                }
                a(str, m68a);
                if (fileLock != null && fileLock.isValid()) {
                    try {
                        fileLock.release();
                    } catch (IOException e) {
                        e = e;
                        com.xiaomi.channel.commonutils.logger.b.a(e);
                        v.a(randomAccessFile);
                    }
                }
            } catch (Throwable unused2) {
                try {
                    com.xiaomi.channel.commonutils.logger.b.c("failed to write perf to file ");
                    if (fileLock != null && fileLock.isValid()) {
                        try {
                            fileLock.release();
                        } catch (IOException e2) {
                            e = e2;
                            com.xiaomi.channel.commonutils.logger.b.a(e);
                            v.a(randomAccessFile);
                        }
                    }
                    v.a(randomAccessFile);
                } catch (Throwable th) {
                    if (fileLock != null && fileLock.isValid()) {
                        try {
                            fileLock.release();
                        } catch (IOException e3) {
                            com.xiaomi.channel.commonutils.logger.b.a(e3);
                        }
                    }
                    v.a(randomAccessFile);
                    throw th;
                }
            }
            v.a(randomAccessFile);
        }
    }
}
