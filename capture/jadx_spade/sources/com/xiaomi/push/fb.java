package com.xiaomi.push;

import com.bytedance.covode.number.Covode;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class fb {
    static {
        Covode.recordClassIndex(655516);
    }

    public static int a(Throwable th) {
        boolean z = th instanceof fh;
        if (z) {
            fh fhVar = (fh) th;
            if (fhVar.a() != null) {
                th = fhVar.a();
            }
        }
        String message = th.getMessage();
        if (th.getCause() != null) {
            message = th.getCause().getMessage();
        }
        if (th instanceof SocketTimeoutException) {
            return 105;
        }
        if (th instanceof SocketException) {
            if (message.indexOf("Network is unreachable") != -1) {
                return 102;
            }
            if (message.indexOf("Connection refused") != -1) {
                return 103;
            }
            if (message.indexOf("Connection timed out") != -1) {
                return 105;
            }
            if (message.endsWith("EACCES (Permission denied)")) {
                return 101;
            }
            if (message.indexOf("Connection reset by peer") != -1) {
                return 109;
            }
            if (message.indexOf("Broken pipe") != -1) {
                return 110;
            }
            if (message.indexOf("No route to host") != -1) {
                return 104;
            }
            if (message.endsWith("EINVAL (Invalid argument)")) {
                return 106;
            }
            return 199;
        }
        if (th instanceof UnknownHostException) {
            return 107;
        }
        if (z) {
            return 399;
        }
        return 0;
    }
}
