package xk6;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.util.Log;
import com.bytedance.common.utility.concurrent.ThreadPlus;
import com.bytedance.covode.number.Covode;
import com.bytedance.helios.statichook.api.ExtraInfo;
import com.bytedance.helios.statichook.api.HeliosApiHook;
import com.bytedance.helios.statichook.api.Result;
import java.io.IOException;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class f {
    private static bl6.a a;

    static {
        Covode.recordClassIndex(655872);
        a = new bl6.a("NetWorkUtils");
    }

    static class a implements Runnable {
        final /* synthetic */ Context a;

        private static Process a(Runtime runtime, String str) {
            Result preInvoke = new HeliosApiHook().preInvoke(102900, "java/lang/Runtime", "exec", runtime, new Object[]{str}, "java.lang.Process", new ExtraInfo(false, "(Ljava/lang/String;)Ljava/lang/Process;"));
            return preInvoke.isIntercept() ? (Process) preInvoke.getReturnValue() : runtime.exec(str);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (Build.VERSION.SDK_INT >= 23) {
                ConnectivityManager connectivityManager = (ConnectivityManager) this.a.getSystemService("connectivity");
                if (connectivityManager != null && !connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork()).hasCapability(16)) {
                    f.a.d("network connected, but can not be used", new Object[0]);
                    return;
                }
                return;
            }
            try {
                if (a(Runtime.getRuntime(), "ping -c 3 -w 100 bytedance.net").waitFor() != 0) {
                    f.a.d("network connected, but can not be used", new Object[0]);
                }
            } catch (IOException e) {
                f.a.d("network ping IOException %s", Log.getStackTraceString(e));
            } catch (InterruptedException e2) {
                f.a.d("network ping InterruptedException %s", Log.getStackTraceString(e2));
            }
        }

        a(Context context) {
            this.a = context;
        }
    }

    public static void c(Context context) {
        ThreadPlus.submitRunnable(new a(context));
    }

    public static boolean b(Context context) {
        NetworkInfo activeNetworkInfo;
        if (context != null && (activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo()) != null) {
            return activeNetworkInfo.isAvailable();
        }
        return false;
    }
}
