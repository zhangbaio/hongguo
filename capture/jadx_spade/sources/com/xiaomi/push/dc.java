package com.xiaomi.push;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Process;
import android.util.Log;
import android.util.Pair;
import com.bytedance.covode.number.Covode;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.ugc.bytex.taskmonitor.proxy.HandlerDelegate;
import com.xiaomi.channel.commonutils.logger.LoggerInterface;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class dc implements LoggerInterface {
    private static volatile dc a;

    /* renamed from: a, reason: collision with other field name */
    public static String f250a;

    /* renamed from: a, reason: collision with other field name */
    private static final SimpleDateFormat f251a;

    /* renamed from: a, reason: collision with other field name */
    private static List<Pair<String, Throwable>> f252a;

    /* renamed from: a, reason: collision with other field name */
    private Context f253a;

    /* renamed from: a, reason: collision with other field name */
    private Handler f254a;
    private String b;

    static {
        Covode.recordClassIndex(655438);
        f251a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss aaa");
        f250a = "/MiPushLog";
        f252a = Collections.synchronizedList(new ArrayList());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:107:0x015b -> B:49:0x0160). Please report as a decompilation issue!!! */
    /* renamed from: a, reason: collision with other method in class */
    public void m271a() {
        RandomAccessFile randomAccessFile;
        FileLock fileLock;
        PolarisFileWrapper polarisFileWrapper;
        BufferedWriter bufferedWriter = null;
        try {
            try {
                try {
                    polarisFileWrapper = new PolarisFileWrapper(this.f253a.getFilesDir(), f250a);
                } catch (IOException e) {
                    Log.e(this.b, "", e);
                }
            } catch (Exception e2) {
                e = e2;
                fileLock = null;
                randomAccessFile = null;
            } catch (Throwable th) {
                th = th;
                fileLock = null;
                randomAccessFile = null;
            }
            if (!u.m768a((File) polarisFileWrapper)) {
                Log.w(this.b, "Cannot wirte internal file: " + polarisFileWrapper);
                return;
            }
            if ((!polarisFileWrapper.exists() || !polarisFileWrapper.isDirectory()) && !polarisFileWrapper.mkdirs()) {
                Log.w(this.b, "Create mipushlog directory fail.");
                return;
            }
            PolarisFileWrapper polarisFileWrapper2 = new PolarisFileWrapper(polarisFileWrapper, "log.lock");
            if (!polarisFileWrapper2.exists() || polarisFileWrapper2.isDirectory()) {
                polarisFileWrapper2.createNewFile();
            }
            randomAccessFile = new RandomAccessFile((File) polarisFileWrapper2, "rw");
            try {
                fileLock = randomAccessFile.getChannel().lock();
                try {
                    BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(new PolarisFileOutputStreamWrapper(new PolarisFileWrapper(polarisFileWrapper, "log1.txt"), true)));
                    while (!f252a.isEmpty()) {
                        try {
                            Pair<String, Throwable> remove = f252a.remove(0);
                            String str = (String) remove.first;
                            if (remove.second != null) {
                                str = (str + "\n") + Log.getStackTraceString((Throwable) remove.second);
                            }
                            bufferedWriter2.write(str + "\n");
                        } catch (Exception e3) {
                            e = e3;
                            bufferedWriter = bufferedWriter2;
                            Log.e(this.b, "", e);
                            if (bufferedWriter != null) {
                                try {
                                    bufferedWriter.close();
                                } catch (IOException e4) {
                                    Log.e(this.b, "", e4);
                                }
                            }
                            if (fileLock != null && fileLock.isValid()) {
                                try {
                                    fileLock.release();
                                } catch (IOException e5) {
                                    Log.e(this.b, "", e5);
                                }
                            }
                            if (randomAccessFile != null) {
                                randomAccessFile.close();
                            }
                            return;
                        } catch (Throwable th2) {
                            th = th2;
                            bufferedWriter = bufferedWriter2;
                            if (bufferedWriter != null) {
                                try {
                                    bufferedWriter.close();
                                } catch (IOException e6) {
                                    Log.e(this.b, "", e6);
                                }
                            }
                            if (fileLock != null && fileLock.isValid()) {
                                try {
                                    fileLock.release();
                                } catch (IOException e7) {
                                    Log.e(this.b, "", e7);
                                }
                            }
                            if (randomAccessFile != null) {
                                try {
                                    randomAccessFile.close();
                                    throw th;
                                } catch (IOException e8) {
                                    Log.e(this.b, "", e8);
                                    throw th;
                                }
                            }
                            throw th;
                        }
                    }
                    bufferedWriter2.flush();
                    bufferedWriter2.close();
                    PolarisFileWrapper polarisFileWrapper3 = new PolarisFileWrapper(polarisFileWrapper, "log1.txt");
                    if (polarisFileWrapper3.length() >= 1048576) {
                        PolarisFileWrapper polarisFileWrapper4 = new PolarisFileWrapper(polarisFileWrapper, "log0.txt");
                        if (polarisFileWrapper4.exists() && polarisFileWrapper4.isFile()) {
                            polarisFileWrapper4.delete();
                        }
                        polarisFileWrapper3.renameTo(polarisFileWrapper4);
                    }
                    if (fileLock != null && fileLock.isValid()) {
                        try {
                            fileLock.release();
                        } catch (IOException e9) {
                            Log.e(this.b, "", e9);
                        }
                    }
                    randomAccessFile.close();
                } catch (Exception e10) {
                    e = e10;
                }
            } catch (Exception e11) {
                e = e11;
                fileLock = null;
            } catch (Throwable th3) {
                th = th3;
                fileLock = null;
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
    public final void setTag(String str) {
        this.b = str;
    }

    @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
    public final void log(String str) {
        log(str, null);
    }

    public static dc a(Context context) {
        if (a == null) {
            synchronized (dc.class) {
                if (a == null) {
                    a = new dc(context);
                }
            }
        }
        return a;
    }

    private dc(Context context) {
        this.f253a = context;
        if (context.getApplicationContext() != null) {
            this.f253a = context.getApplicationContext();
        }
        this.b = this.f253a.getPackageName() + "-" + Process.myPid();
        HandlerThread handlerThread = new HandlerThread("Log2FileHandlerThread");
        handlerThread.start();
        this.f254a = new HandlerDelegate(handlerThread.getLooper());
    }

    @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
    public final void log(final String str, final Throwable th) {
        this.f254a.post(new Runnable() { // from class: com.xiaomi.push.dc.1
            @Override // java.lang.Runnable
            public void run() {
                dc.f252a.add(new Pair(String.format("%1$s %2$s %3$s ", dc.f251a.format(new Date()), dc.this.b, str), th));
                if (dc.f252a.size() > 20000) {
                    int size = (dc.f252a.size() - 20000) + 50;
                    for (int i = 0; i < size; i++) {
                        try {
                            if (dc.f252a.size() > 0) {
                                dc.f252a.remove(0);
                            }
                        } catch (IndexOutOfBoundsException unused) {
                        }
                    }
                    dc.f252a.add(new Pair(String.format("%1$s %2$s %3$s ", dc.f251a.format(new Date()), dc.this.b, "flush " + size + " lines logs."), null));
                }
                try {
                    dc.this.m271a();
                } catch (Exception e) {
                    Log.e(dc.this.b, "", e);
                }
            }
        });
    }
}
