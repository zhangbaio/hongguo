package com.tencent.open.log;

import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import com.bytedance.covode.number.Covode;
import java.io.File;
import java.text.SimpleDateFormat;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class d {

    public static final class a {
        static {
            Covode.recordClassIndex(653540);
        }

        public static final boolean a(int i, int i2) {
            return i2 == (i & i2);
        }
    }

    static {
        Covode.recordClassIndex(653539);
    }

    public static class c {
        private File a;
        private long b;
        private long c;

        static {
            Covode.recordClassIndex(653542);
        }

        public File a() {
            return this.a;
        }

        public long b() {
            return this.b;
        }

        public long c() {
            return this.c;
        }

        public String toString() {
            return String.format("[%s : %d / %d]", a().getAbsolutePath(), Long.valueOf(c()), Long.valueOf(b()));
        }

        public void a(long j) {
            this.b = j;
        }

        public void b(long j) {
            this.c = j;
        }

        public void a(File file) {
            this.a = file;
        }

        public static c b(File file) {
            c cVar = new c();
            cVar.a(file);
            StatFs statFs = new StatFs(file.getAbsolutePath());
            long blockSize = statFs.getBlockSize();
            long blockCount = statFs.getBlockCount();
            long availableBlocks = statFs.getAvailableBlocks();
            cVar.a(blockCount * blockSize);
            cVar.b(availableBlocks * blockSize);
            return cVar;
        }
    }

    public static final class b {
        static {
            Covode.recordClassIndex(653541);
        }

        public static boolean a() {
            String externalStorageState = Environment.getExternalStorageState();
            if (!"mounted".equals(externalStorageState) && !"mounted_ro".equals(externalStorageState)) {
                return false;
            }
            return true;
        }

        public static c b() {
            if (!a()) {
                return null;
            }
            return c.b(Environment.getExternalStorageDirectory());
        }
    }

    /* renamed from: com.tencent.open.log.d$d, reason: collision with other inner class name */
    public static final class C0113d {
        static {
            Covode.recordClassIndex(653543);
        }

        public static SimpleDateFormat a(String str) {
            return new SimpleDateFormat(str);
        }
    }

    public static boolean a(Bundle bundle) {
        if (!bundle.containsKey("access_token") && !bundle.containsKey("pay_token") && !bundle.containsKey("pfkey") && !bundle.containsKey("expires_in") && !bundle.containsKey("openid") && !bundle.containsKey("proxy_code") && !bundle.containsKey("proxy_expires_in")) {
            return false;
        }
        return true;
    }

    public static Bundle b(Bundle bundle) {
        if (!a(bundle)) {
            return bundle;
        }
        Bundle bundle2 = new Bundle(bundle);
        bundle2.remove("access_token");
        bundle2.remove("pay_token");
        bundle2.remove("pfkey");
        bundle2.remove("expires_in");
        bundle2.remove("openid");
        bundle2.remove("proxy_code");
        bundle2.remove("proxy_expires_in");
        return bundle2;
    }

    public static boolean a(String str) {
        if (!str.contains("access_token") && !str.contains("pay_token") && !str.contains("pfkey") && !str.contains("expires_in") && !str.contains("openid") && !str.contains("proxy_code") && !str.contains("proxy_expires_in")) {
            return false;
        }
        return true;
    }
}
