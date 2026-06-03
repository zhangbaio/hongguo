package mk6;

import android.app.Notification;
import android.app.NotificationChannel;
import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class d implements hk6.a {
    static {
        Covode.recordClassIndex(655792);
    }

    @Override // hk6.a
    public boolean a() {
        return true;
    }

    @Override // hk6.a
    public boolean b() {
        return false;
    }

    @Override // hk6.a
    public boolean d() {
        return true;
    }

    @Override // hk6.a
    public int e() {
        return 0;
    }

    @Override // hk6.a
    public void ensureNotReachHere(Throwable th, String str) {
    }

    @Override // hk6.a
    public int f() {
        return 18;
    }

    @Override // hk6.a
    public String getChannelId() {
        return "audio_notify_channel";
    }

    @Override // hk6.a
    public hk6.b h() {
        return null;
    }

    @Override // hk6.a
    public boolean i() {
        return false;
    }

    @Override // hk6.a
    public NotificationChannel c() {
        NotificationChannel notificationChannel = new NotificationChannel("audio_notify_channel", "听书音频", 2);
        notificationChannel.setDescription("在通知栏显现听书音频播放控件");
        return notificationChannel;
    }

    @Override // hk6.a
    public Notification g(Context context, NotificationCompat.Builder builder) {
        if (context != null && builder != null) {
            return builder.setContentText("音频播放中").setAutoCancel(false).build();
        }
        return null;
    }
}
