package com.xiaomi.push;

import android.content.Context;
import android.os.Build;
import com.bytedance.covode.number.Covode;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
class cz {
    private static String a;

    /* renamed from: a, reason: collision with other field name */
    private int f231a;

    /* renamed from: a, reason: collision with other field name */
    private boolean f234a;

    /* renamed from: b, reason: collision with other field name */
    private String f235b;
    private String c;

    /* renamed from: a, reason: collision with other field name */
    private final SimpleDateFormat f232a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private int b = 2097152;

    /* renamed from: a, reason: collision with other field name */
    private ArrayList<File> f233a = new ArrayList<>();

    static {
        Covode.recordClassIndex(655431);
        a = "/MiPushLog";
    }

    cz() {
    }

    void a(int i) {
        if (i != 0) {
            this.b = i;
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    cz m265a(File file) {
        if (file.exists()) {
            this.f233a.add(file);
        }
        return this;
    }

    private void a(File file) {
        BufferedReader bufferedReader;
        Pattern compile = Pattern.compile("\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}");
        BufferedReader bufferedReader2 = null;
        try {
            try {
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new PolarisFileOutputStreamWrapper(file)));
                try {
                    bufferedWriter.write("model :" + Build.MODEL + "; os :" + Build.VERSION.INCREMENTAL + "; uid :" + com.xiaomi.push.service.ax.m709a() + "; lng :" + Locale.getDefault().toString() + "; sdk :48; andver :" + Build.VERSION.SDK_INT + "\n");
                    this.f231a = 0;
                    Iterator<File> it2 = this.f233a.iterator();
                    while (it2.hasNext()) {
                        bufferedReader = new BufferedReader(new InputStreamReader(new PolarisFileInputStreamWrapper(it2.next())));
                        try {
                            a(bufferedReader, bufferedWriter, compile);
                            bufferedReader.close();
                            bufferedReader2 = bufferedReader;
                        } catch (FileNotFoundException e) {
                            e = e;
                            bufferedReader2 = bufferedWriter;
                            com.xiaomi.channel.commonutils.logger.b.c("LOG: filter error = " + e.getMessage());
                            v.a(bufferedReader2);
                            v.a(bufferedReader);
                            return;
                        } catch (IOException e2) {
                            e = e2;
                            bufferedReader2 = bufferedWriter;
                            com.xiaomi.channel.commonutils.logger.b.c("LOG: filter error = " + e.getMessage());
                            v.a(bufferedReader2);
                            v.a(bufferedReader);
                            return;
                        } catch (Throwable th) {
                            th = th;
                            bufferedReader2 = bufferedWriter;
                            v.a(bufferedReader2);
                            v.a(bufferedReader);
                            throw th;
                        }
                    }
                    bufferedWriter.write(cf.a().c());
                    v.a(bufferedWriter);
                    v.a(bufferedReader2);
                } catch (FileNotFoundException e3) {
                    e = e3;
                    bufferedReader = bufferedReader2;
                } catch (IOException e4) {
                    e = e4;
                    bufferedReader = bufferedReader2;
                } catch (Throwable th2) {
                    th = th2;
                    bufferedReader = bufferedReader2;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (FileNotFoundException e5) {
            e = e5;
            bufferedReader = null;
        } catch (IOException e6) {
            e = e6;
            bufferedReader = null;
        } catch (Throwable th4) {
            th = th4;
            bufferedReader = null;
        }
    }

    cz a(Date date, Date date2) {
        if (date.after(date2)) {
            this.f235b = this.f232a.format(date2);
            this.c = this.f232a.format(date);
        } else {
            this.f235b = this.f232a.format(date);
            this.c = this.f232a.format(date2);
        }
        return this;
    }

    private void a(BufferedReader bufferedReader, BufferedWriter bufferedWriter, Pattern pattern) {
        char[] cArr = new char[4096];
        int read = bufferedReader.read(cArr);
        boolean z = false;
        while (read != -1 && !z) {
            String str = new String(cArr, 0, read);
            Matcher matcher = pattern.matcher(str);
            int i = 0;
            int i2 = 0;
            while (true) {
                if (i >= read || !matcher.find(i)) {
                    break;
                }
                int start = matcher.start();
                String substring = str.substring(start, this.f235b.length() + start);
                if (!this.f234a) {
                    if (substring.compareTo(this.f235b) >= 0) {
                        this.f234a = true;
                        i2 = start;
                    }
                } else if (substring.compareTo(this.c) > 0) {
                    read = start;
                    z = true;
                    break;
                }
                int indexOf = str.indexOf(10, start);
                if (indexOf == -1) {
                    indexOf = this.f235b.length();
                }
                i = start + indexOf;
            }
            if (this.f234a) {
                int i3 = read - i2;
                this.f231a += i3;
                if (z) {
                    bufferedWriter.write(cArr, i2, i3);
                    return;
                } else {
                    bufferedWriter.write(cArr, i2, i3);
                    if (this.f231a > this.b) {
                        return;
                    }
                }
            }
            read = bufferedReader.read(cArr);
        }
    }

    File a(Context context, Date date, Date date2, File file) {
        File file2;
        if ("com.xiaomi.xmsf".equalsIgnoreCase(context.getPackageName())) {
            file2 = cy.a(context);
            if (file2 == null) {
                return null;
            }
            m265a((File) new PolarisFileWrapper(file2, "xmsf.log.1"));
            m265a((File) new PolarisFileWrapper(file2, "xmsf.log"));
        } else {
            File polarisFileWrapper = new PolarisFileWrapper(context.getFilesDir() + a);
            if (!u.m768a(polarisFileWrapper)) {
                return null;
            }
            m265a((File) new PolarisFileWrapper(polarisFileWrapper, "log0.txt"));
            m265a((File) new PolarisFileWrapper(polarisFileWrapper, "log1.txt"));
            file2 = polarisFileWrapper;
        }
        if (!file2.isDirectory()) {
            return null;
        }
        PolarisFileWrapper polarisFileWrapper2 = new PolarisFileWrapper(file, date.getTime() + "-" + date2.getTime() + ".zip");
        if (polarisFileWrapper2.exists()) {
            return null;
        }
        a(date, date2);
        long currentTimeMillis = System.currentTimeMillis();
        PolarisFileWrapper polarisFileWrapper3 = new PolarisFileWrapper(file, "log.txt");
        a((File) polarisFileWrapper3);
        com.xiaomi.channel.commonutils.logger.b.c("LOG: filter cost = " + (System.currentTimeMillis() - currentTimeMillis));
        if (polarisFileWrapper3.exists()) {
            long currentTimeMillis2 = System.currentTimeMillis();
            v.a((File) polarisFileWrapper2, (File) polarisFileWrapper3);
            com.xiaomi.channel.commonutils.logger.b.c("LOG: zip cost = " + (System.currentTimeMillis() - currentTimeMillis2));
            polarisFileWrapper3.delete();
            if (polarisFileWrapper2.exists()) {
                return polarisFileWrapper2;
            }
        }
        return null;
    }
}
