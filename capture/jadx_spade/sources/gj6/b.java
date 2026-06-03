package gj6;

import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.ss.mediakit.medialoader.AVMDLDataLoader;
import com.ss.mediakit.medialoader.AVMDLDataLoaderConfigure;
import com.ss.mediakit.medialoader.AVMDLDataLoaderListener;
import com.ss.mediakit.medialoader.AVMDLDataLoaderNotifyInfo;
import com.ss.ttm.player.MediaPlayer;
import java.net.URLEncoder;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class b implements AVMDLDataLoaderListener {
    public AVMDLDataLoaderConfigure a;
    private volatile boolean b;
    private gj6.a c;
    public MediaPlayer d;
    private boolean e;
    private boolean f;

    static {
        Covode.recordClassIndex(653056);
    }

    private boolean i() {
        return true;
    }

    public void b() {
        this.f = true;
    }

    public String getCheckSumInfo(String str) {
        return null;
    }

    public String getStringValue(int i, long j, String str) {
        return null;
    }

    /* renamed from: gj6.b$b, reason: collision with other inner class name */
    private static class C0159b {
        private static b a;

        static {
            Covode.recordClassIndex(653057);
            a = new b();
        }
    }

    public static b c() {
        return C0159b.a;
    }

    private b() {
        this.b = false;
        this.e = false;
        this.f = false;
        this.a = AVMDLDataLoaderConfigure.getDefaultonfigure();
    }

    public boolean h() {
        if (AVMDLDataLoader.getInstance() == null) {
            return false;
        }
        return AVMDLDataLoader.getInstance().isRunning();
    }

    public void a() {
        if (!this.e) {
            com.ss.videoarch.liveplayer.log.a.b("MediaLoaderWrapper", "MediaLoader not started, not need close");
            return;
        }
        this.c = null;
        AVMDLDataLoader.getInstance().close();
        AVMDLDataLoader.getInstance().cancelAll();
        this.e = false;
    }

    private boolean g() {
        if (this.f) {
            if (!i()) {
                com.ss.videoarch.liveplayer.log.a.c("MediaLoaderWrapper", String.format("library load fail", new Object[0]));
                return false;
            }
            if (AVMDLDataLoader.init(false) != 0) {
                com.ss.videoarch.liveplayer.log.a.a("MediaLoaderWrapper", String.format("library has not been loaded", new Object[0]));
                return false;
            }
        }
        try {
            AVMDLDataLoader.getInstance().setListener(107, this);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            com.ss.videoarch.liveplayer.log.a.c("MediaLoaderWrapper", String.format("create loader failed: exception is" + e.toString(), new Object[0]));
            return false;
        }
    }

    public void o() throws Exception {
        if (this.e) {
            return;
        }
        if (g()) {
            JSONObject jSONObject = new JSONObject();
            try {
                String str = com.ss.videoarch.liveplayer.a.d;
                if (str != null) {
                    if (!TextUtils.isEmpty(str)) {
                        jSONObject.put("app_channel", com.ss.videoarch.liveplayer.a.d);
                    }
                    if (!TextUtils.isEmpty(com.ss.videoarch.liveplayer.a.c)) {
                        jSONObject.put("app_name", com.ss.videoarch.liveplayer.a.c);
                    }
                    if (!TextUtils.isEmpty(com.ss.videoarch.liveplayer.a.f)) {
                        jSONObject.put("device_id", com.ss.videoarch.liveplayer.a.f);
                    }
                    if (!TextUtils.isEmpty(com.ss.videoarch.liveplayer.a.e)) {
                        jSONObject.put("app_version", com.ss.videoarch.liveplayer.a.e);
                    }
                    jSONObject.put("app_id", com.ss.videoarch.liveplayer.a.b);
                }
            } catch (JSONException e) {
                e.printStackTrace();
                jSONObject = null;
            }
            if (jSONObject == null) {
                return;
            }
            this.a.mAppInfo = jSONObject.toString();
            if (com.ss.videoarch.liveplayer.a.b != -1) {
                com.ss.videoarch.liveplayer.log.a.c("MediaLoaderWrapper", "set config");
                AVMDLDataLoader.getInstance().setConfigure(this.a);
            }
            if (AVMDLDataLoader.getInstance().start() >= 0) {
                this.e = true;
                return;
            }
            throw new Exception("start mediaLoader fail");
        }
        throw new Exception("init mediaLoader fail");
    }

    public String f(int i) {
        com.ss.videoarch.liveplayer.log.a.c("MediaLoaderWrapper", "get string value from loader");
        AVMDLDataLoader aVMDLDataLoader = AVMDLDataLoader.getInstance();
        if (i != 11 || aVMDLDataLoader == null) {
            return null;
        }
        return aVMDLDataLoader.getStringValue(11);
    }

    public void l(gj6.a aVar) {
        this.c = aVar;
        try {
            AVMDLDataLoader.getInstance().setListener(107, this);
        } catch (Exception e) {
            e.printStackTrace();
            com.ss.videoarch.liveplayer.log.a.c("MediaLoaderWrapper", String.format("create loader failed: exception is" + e.toString(), new Object[0]));
        }
    }

    private boolean p(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String lowerCase = str.toLowerCase();
        if (lowerCase.startsWith("http://127.0.0.1") || lowerCase.startsWith("http://localhost") || lowerCase.startsWith("file://") || lowerCase.startsWith("/") || lowerCase.endsWith(".mpd") || lowerCase.contains(".mpd?") || lowerCase.contains(".m3u8?") || lowerCase.endsWith(".m3u8")) {
            return false;
        }
        return true;
    }

    public long d(int i) {
        com.ss.videoarch.liveplayer.log.a.c("MediaLoaderWrapper", "get long value from loader");
        AVMDLDataLoader aVMDLDataLoader = AVMDLDataLoader.getInstance();
        long j = -1;
        if (i != 7218) {
            switch (i) {
                case 8100:
                    if (aVMDLDataLoader == null) {
                        return -1L;
                    }
                    return aVMDLDataLoader.getLongValue(8100);
                case 8101:
                    if (aVMDLDataLoader == null) {
                        return -1L;
                    }
                    return aVMDLDataLoader.getLongValue(8101);
                case 8102:
                    if (aVMDLDataLoader != null) {
                        j = aVMDLDataLoader.getLongValue(8102);
                    }
                    if (j == 1) {
                        return 1L;
                    }
                    return 0L;
                default:
                    return -1L;
            }
        }
        if (aVMDLDataLoader == null) {
            return -1L;
        }
        return aVMDLDataLoader.getLongValue(7218);
    }

    public void onNotify(AVMDLDataLoaderNotifyInfo aVMDLDataLoaderNotifyInfo) {
        if (aVMDLDataLoaderNotifyInfo != null && this.c != null) {
            com.ss.videoarch.liveplayer.log.a.c("MediaLoaderWrapper", "what:" + aVMDLDataLoaderNotifyInfo.what);
            int i = aVMDLDataLoaderNotifyInfo.what;
            if (i != 9) {
                if (i == 12) {
                    gj6.a aVar = this.c;
                    if (aVar != null) {
                        aVar.a((int) aVMDLDataLoaderNotifyInfo.parameter, aVMDLDataLoaderNotifyInfo.logInfo);
                    }
                    com.ss.videoarch.liveplayer.log.a.c("MediaLoaderWrapper", "switch reason:" + aVMDLDataLoaderNotifyInfo.parameter + " switchInfo:" + aVMDLDataLoaderNotifyInfo.logInfo);
                    return;
                }
                return;
            }
            gj6.a aVar2 = this.c;
            if (aVar2 != null) {
                aVar2.b((int) aVMDLDataLoaderNotifyInfo.parameter, aVMDLDataLoaderNotifyInfo.logInfo);
            }
            com.ss.videoarch.liveplayer.log.a.c("MediaLoaderWrapper", "live loader errorCode:" + aVMDLDataLoaderNotifyInfo.parameter + " errorInfo:" + aVMDLDataLoaderNotifyInfo.logInfo);
        }
    }

    public void n(int i, String str) {
        AVMDLDataLoader aVMDLDataLoader = AVMDLDataLoader.getInstance();
        if (aVMDLDataLoader == null) {
            return;
        }
        aVMDLDataLoader.setStringValue(i, str);
    }

    public void m(int i, long j) {
        AVMDLDataLoader aVMDLDataLoader = AVMDLDataLoader.getInstance();
        if (aVMDLDataLoader == null || i != 59) {
            return;
        }
        aVMDLDataLoader.setLongValue(1100, j);
    }

    public long getInt64Value(int i, long j) {
        com.ss.videoarch.liveplayer.log.a.c("MediaLoaderWrapper", "getInt64Value:" + i);
        if (i != 8003) {
            if (i != 8004) {
                return j;
            }
            gj6.a aVar = this.c;
            if (aVar != null) {
                return aVar.getInt64Value(0, j);
            }
            return j;
        }
        MediaPlayer mediaPlayer = this.d;
        if (mediaPlayer != null) {
            return mediaPlayer.getLongOption(73, 0L);
        }
        return j;
    }

    public String e(String str, Boolean bool) {
        String str2 = null;
        if (str == null) {
            return null;
        }
        if (!p(str)) {
            return str;
        }
        String localAddr = AVMDLDataLoader.getInstance().getLocalAddr();
        if (TextUtils.isEmpty(localAddr)) {
            return null;
        }
        try {
            str2 = URLEncoder.encode(str, "UTF-8");
        } catch (Throwable th) {
            th.printStackTrace();
        }
        String str3 = localAddr + "?rk=v02004b50000bh9ajqhdli3lfv2rgsgg&k=426161df8c5ce110209a6fc6641e049ddfrfgaf&u0=" + str2;
        if (bool.booleanValue()) {
            return "mdl://" + str3;
        }
        return "http://" + str3;
    }

    public void k(int i, int i2) {
        if (i == 51) {
            this.a.mRWTimeOut = i2;
            return;
        }
        if (i == 52) {
            this.a.mOpenTimeOut = i2;
            return;
        }
        if (i == 53) {
            this.a.mTryCount = i2;
            return;
        }
        if (i == 49) {
            com.ss.videoarch.liveplayer.log.a.c("MediaLoaderWrapper", "allow p2p:" + i2);
            this.a.mLiveP2pAllow = i2;
            return;
        }
        if (i == 50) {
            com.ss.videoarch.liveplayer.log.a.c("MediaLoaderWrapper", "loader type:" + i2);
            this.a.mLiveLoaderType = i2;
        }
    }

    public void j(int i, String str, int i2) {
        AVMDLDataLoader aVMDLDataLoader = AVMDLDataLoader.getInstance();
        if (aVMDLDataLoader == null) {
            return;
        }
        if (i != 7213 && i != 7215) {
            aVMDLDataLoader.setInt64ValueByStrKey(i, str, System.currentTimeMillis());
        } else {
            aVMDLDataLoader.setInt64ValueByStrKey(i, str, i2);
        }
    }
}
