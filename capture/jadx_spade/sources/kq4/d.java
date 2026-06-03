package kq4;

import android.media.MediaPlayer;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.bytedance.crash.util.i;
import com.dragon.read.base.util.LogHelper;
import com.dragon.read.util.s6;
import java.lang.reflect.Field;
import kq4.d;
import org.json.JSONObject;
import qo3.p0;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class d {
    private static final LogHelper a;

    static {
        Covode.recordClassIndex(611236);
        a = new LogHelper("MediaPlayerAop");
    }

    public static class a implements Handler.Callback {
        private MediaPlayer a;
        private Handler b;

        static {
            Covode.recordClassIndex(611237);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void e() {
            boolean z;
            try {
                MediaPlayer.OnPreparedListener onPreparedListener = (MediaPlayer.OnPreparedListener) i.a(MediaPlayer.class, "mOnPreparedListener").get(this.a);
                LogHelper logHelper = d.a;
                Object[] objArr = new Object[1];
                if (onPreparedListener != null) {
                    z = true;
                } else {
                    z = false;
                }
                objArr[0] = Boolean.valueOf(z);
                logHelper.i("call original onPreparedListener.onPrepared:%b", objArr);
                if (onPreparedListener != null) {
                    onPreparedListener.onPrepared(this.a);
                }
            } catch (Throwable th) {
                d.a.e("do original logic error:%s", new Object[]{th});
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void f(Message message) {
            boolean z;
            try {
                MediaPlayer.OnInfoListener onInfoListener = (MediaPlayer.OnInfoListener) i.a(MediaPlayer.class, "mOnInfoListener").get(this.a);
                LogHelper logHelper = d.a;
                Object[] objArr = new Object[1];
                if (onInfoListener != null) {
                    z = true;
                } else {
                    z = false;
                }
                objArr[0] = Boolean.valueOf(z);
                logHelper.i("call original onInfoListener.onInfo:%b", objArr);
                if (onInfoListener != null) {
                    onInfoListener.onInfo(this.a, message.arg1, message.arg2);
                }
            } catch (Throwable th) {
                d.a.e("do original logic error:%s", new Object[]{th});
            }
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(final Message message) {
            int i = message.what;
            if (i == 1) {
                try {
                    this.b.handleMessage(message);
                    d.a.i("handle 1 succeed", new Object[0]);
                } catch (Throwable th) {
                    d(message.what, th, new Runnable() { // from class: kq4.a
                        @Override // java.lang.Runnable
                        public final void run() {
                            d.a.this.e();
                        }
                    });
                }
                return true;
            }
            if (i != 200 || message.arg1 != 802) {
                return false;
            }
            try {
                this.b.handleMessage(message);
                d.a.i("handle 200 succeed", new Object[0]);
            } catch (Throwable th2) {
                d(message.what, th2, new Runnable() { // from class: kq4.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        d.a.this.f(message);
                    }
                });
            }
            return true;
        }

        public a(MediaPlayer mediaPlayer, Handler handler) {
            this.a = mediaPlayer;
            this.b = handler;
        }

        private void h(final int i, final String str, final boolean z) {
            s6.c(new p0.a() { // from class: kq4.c
                public final JSONObject a() {
                    JSONObject g;
                    g = d.a.g(i, z, str);
                    return g;
                }
            }, false);
        }

        private void d(int i, Throwable th, Runnable runnable) {
            for (StackTraceElement stackTraceElement : th.getStackTrace()) {
                if (TextUtils.equals(stackTraceElement.getMethodName(), "scanInternalSubtitleTracks")) {
                    h(i, th.getMessage(), true);
                    this.b.sendMessage(this.b.obtainMessage(100, 1, -1010, null));
                    runnable.run();
                    return;
                }
            }
            h(i, th.getMessage(), false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ JSONObject g(int i, boolean z, String str) throws Exception {
            String str2 = i + ":" + (z ? 1 : 0) + ":" + str;
            d.a.e("handle exception:%s", new Object[]{str2});
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("MediaPlayerAop", str2);
            return jSONObject;
        }
    }

    public static void b(MediaPlayer mediaPlayer) {
        if (Build.VERSION.SDK_INT > 22 || !com.dragon.read.base.ssconfig.c.v().enableMediaPlayerAop) {
            return;
        }
        LogHelper logHelper = a;
        logHelper.i("onHook", new Object[0]);
        try {
            Handler handler = (Handler) i.a(MediaPlayer.class, "mEventHandler").get(mediaPlayer);
            logHelper.i("get handler succeed", new Object[0]);
            Field a2 = i.a(Handler.class, "mCallback");
            Object obj = a2.get(handler);
            if (obj != null) {
                logHelper.e("already hooked by:%s", new Object[]{obj.getClass().getCanonicalName()});
            } else {
                a2.set(handler, new a(mediaPlayer, handler));
                logHelper.i("set ProxyCallback succeed", new Object[0]);
            }
        } catch (Throwable th) {
            a.e("hook failed:%s", new Object[]{th});
        }
    }
}
