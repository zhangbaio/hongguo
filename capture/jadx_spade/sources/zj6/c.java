package zj6;

import com.bytedance.covode.number.Covode;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.Skip;
import me.ele.lancet.base.annotations.TargetClass;
import u55.k;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class c {
    public String a = null;
    private InputStream b = null;
    private d c;
    private String d;

    static {
        Covode.recordClassIndex(654849);
    }

    public c(d dVar, String str) {
        this.c = dVar;
        this.d = str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0120, code lost:
    
        if (r0 == null) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0122, code lost:
    
        r0.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0137, code lost:
    
        if (r0 == null) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x012e, code lost:
    
        if (r0 == null) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0140, code lost:
    
        if (r0 == null) goto L71;
     */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00bb A[Catch: all -> 0x0126, Exception -> 0x0128, IllegalStateException -> 0x0131, IOException -> 0x013a, SSLHandshakeException -> 0x0143, TRY_ENTER, TryCatch #3 {IllegalStateException -> 0x0131, blocks: (B:8:0x0012, B:10:0x0026, B:11:0x004d, B:13:0x006e, B:14:0x0076, B:16:0x007c, B:18:0x008c, B:26:0x00bb, B:27:0x00d4, B:29:0x00df, B:31:0x00e7, B:38:0x00ef, B:41:0x00fc, B:44:0x0109, B:45:0x00a1, B:48:0x00ab, B:51:0x0043), top: B:7:0x0012, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00df A[Catch: all -> 0x0126, Exception -> 0x0128, IllegalStateException -> 0x0131, IOException -> 0x013a, SSLHandshakeException -> 0x0143, TryCatch #3 {IllegalStateException -> 0x0131, blocks: (B:8:0x0012, B:10:0x0026, B:11:0x004d, B:13:0x006e, B:14:0x0076, B:16:0x007c, B:18:0x008c, B:26:0x00bb, B:27:0x00d4, B:29:0x00df, B:31:0x00e7, B:38:0x00ef, B:41:0x00fc, B:44:0x0109, B:45:0x00a1, B:48:0x00ab, B:51:0x0043), top: B:7:0x0012, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00ef A[Catch: all -> 0x0126, Exception -> 0x0128, IllegalStateException -> 0x0131, IOException -> 0x013a, SSLHandshakeException -> 0x0143, TryCatch #3 {IllegalStateException -> 0x0131, blocks: (B:8:0x0012, B:10:0x0026, B:11:0x004d, B:13:0x006e, B:14:0x0076, B:16:0x007c, B:18:0x008c, B:26:0x00bb, B:27:0x00d4, B:29:0x00df, B:31:0x00e7, B:38:0x00ef, B:41:0x00fc, B:44:0x0109, B:45:0x00a1, B:48:0x00ab, B:51:0x0043), top: B:7:0x0012, outer: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int b() {
        /*
            Method dump skipped, instructions count: 349
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: zj6.c.b():int");
    }

    @Proxy("openConnection")
    @TargetClass("java.net.URL")
    @Skip({"com.bytedance.crash.upload.CrashUploader"})
    public static URLConnection a(URL url) throws IOException {
        URLConnection openConnection = url.openConnection();
        if (!k.o()) {
            return openConnection;
        }
        return u55.b.a(openConnection);
    }
}
