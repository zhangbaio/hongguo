package hk6;

import android.app.Notification;
import android.app.NotificationChannel;
import android.content.Context;
import androidx.core.app.NotificationCompat;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public interface a {
    boolean a();

    boolean b();

    NotificationChannel c();

    boolean d();

    int e();

    void ensureNotReachHere(Throwable th, String str);

    int f();

    Notification g(Context context, NotificationCompat.Builder builder);

    String getChannelId();

    b h();

    boolean i();
}
