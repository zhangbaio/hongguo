package com.xs.fm.player.sdk.play.player.audio.engine;

import android.app.Application;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.covode.number.Covode;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.common.applog.AppLog;
import com.ss.ttvideoengine.DataLoaderHelper;
import com.ss.ttvideoengine.DataLoaderListener;
import com.ss.ttvideoengine.Resolution;
import com.ss.ttvideoengine.TTVideoEngine;
import com.ss.ttvideoengine.utils.DataLoaderCDNLog;
import com.ss.ttvideoengine.utils.Error;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class j {
    private static final bl6.a a;
    private static final String b;
    private static volatile boolean c;
    public static final j d;

    private j() {
    }

    private final void b() {
        lk6.b bVar = lk6.c.a;
    }

    public static final boolean c() {
        return c;
    }

    private final void d() {
        lk6.b bVar = lk6.c.a;
    }

    static {
        Application application;
        Covode.recordClassIndex(655954);
        d = new j();
        a = new bl6.a("MediaLoaderInitializer");
        lk6.b bVar = lk6.c.a;
        if (bVar != null) {
            application = bVar.b;
        } else {
            application = null;
        }
        b = Intrinsics.stringPlus(xk6.b.e(application), "medialoader");
    }

    private final void e() {
        nk6.e eVar;
        lk6.b bVar = lk6.c.a;
        if (bVar != null && (eVar = bVar.n) != null) {
            try {
                if (eVar.v() && !TextUtils.isEmpty(eVar.H())) {
                    TTVideoEngine.setStringValue(9010, eVar.H());
                }
            } catch (Throwable th) {
                a.d("failed socketStrategy, msg = " + th.getMessage(), new Object[0]);
                th.printStackTrace();
            }
        }
    }

    public static final synchronized void f() {
        Application application;
        nk6.e eVar;
        nk6.e eVar2;
        boolean z;
        int i;
        boolean z2;
        synchronized (j.class) {
            if (c) {
                return;
            }
            DataLoaderHelper dataLoader = DataLoaderHelper.getDataLoader();
            Intrinsics.checkExpressionValueIsNotNull(dataLoader, "DataLoaderHelper.getDataLoader()");
            if (dataLoader.isRunning()) {
                a.d("tryInit but dataloader already running", new Object[0]);
                c = true;
                return;
            }
            try {
                String str = b;
                PolarisFileWrapper polarisFileWrapper = new PolarisFileWrapper(str);
                if (!polarisFileWrapper.exists()) {
                    polarisFileWrapper.mkdirs();
                }
                lk6.b bVar = lk6.c.a;
                TTVideoEngine.setStringValue(0, str);
                if (bVar != null && (eVar2 = bVar.n) != null) {
                    gl6.a aVar = bVar.s;
                    if (aVar != null && aVar.g()) {
                        TTVideoEngine.setIntValue(1, bVar.s.b());
                    } else {
                        TTVideoEngine.setIntValue(1, eVar2.B());
                    }
                    TTVideoEngine.setIntValue(8, eVar2.t());
                    TTVideoEngine.setIntValue(114, eVar2.M());
                    TTVideoEngine.setIntValue(115, eVar2.l());
                    TTVideoEngine.setIntValue(103, eVar2.c());
                    TTVideoEngine.setIntValue(105, eVar2.a());
                    if (eVar2.G() > 0) {
                        TTVideoEngine.setIntValue(92, eVar2.G());
                    }
                    if (eVar2.s() == 1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        TTVideoEngine.setIntValue(7, 1);
                        if (eVar2.n().length() > 0) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (z2) {
                            TTVideoEngine.setStringValue(107, eVar2.n());
                        }
                        if (eVar2.F()) {
                            TTVideoEngine.setIntValue(90, 2);
                            TTVideoEngine.setIntValue(91, 0);
                        }
                    }
                    j jVar = d;
                    jVar.e();
                    jVar.b();
                    if (eVar2.h()) {
                        TTVideoEngine.setIntValue(1005, 1);
                        if (eVar2.u() > 0) {
                            TTVideoEngine.setIntValue(1105, eVar2.u());
                        }
                        if (eVar2.I()) {
                            i = 1;
                        } else {
                            i = 0;
                        }
                        TTVideoEngine.setIntValue(1010, i);
                        TTVideoEngine.setIntValue(800, eVar2.i());
                    }
                    a.d("socketReuseEnable:" + eVar2.t() + " externDnsEnable:" + eVar2.s(), new Object[0]);
                }
                nk6.f fVar = lk6.c.a.o;
                if (fVar != null && fVar.l()) {
                    TTVideoEngine.setIntValue(973, fVar.k());
                }
                lk6.b bVar2 = lk6.c.a;
                TTVideoEngine.setDataLoaderListener(new a());
                lk6.b bVar3 = lk6.c.a;
                if (bVar3 != null) {
                    application = bVar3.b;
                } else {
                    application = null;
                }
                TTVideoEngine.startDataLoader(application);
                d.d();
                if (bVar != null && (eVar = bVar.n) != null && eVar.w()) {
                    DataLoaderHelper.getDataLoader().doParseHosts(bVar.n.f());
                }
                c = true;
                a.d("tryInit success", new Object[0]);
            } catch (Throwable th) {
                a.d("tryInit failed stack=" + Log.getStackTraceString(th), new Object[0]);
            }
        }
    }

    public static final /* synthetic */ bl6.a a(j jVar) {
        return a;
    }

    private static final class a implements DataLoaderListener {
        static {
            Covode.recordClassIndex(655955);
        }

        @Override // com.ss.ttvideoengine.DataLoaderListener
        public String apiStringForFetchVideoModel(Map<String, String> map, String str, Resolution resolution) {
            return null;
        }

        @Override // com.ss.ttvideoengine.DataLoaderListener
        public String authStringForFetchVideoModel(String str, Resolution resolution) {
            return null;
        }

        @Override // com.ss.ttvideoengine.DataLoaderListener
        public String getCheckSumInfo(String str) {
            return null;
        }

        @Override // com.ss.ttvideoengine.DataLoaderListener
        public HashMap<String, String> getCustomHttpHeaders(String str) {
            return null;
        }

        @Override // com.ss.ttvideoengine.DataLoaderListener
        public boolean loadLibrary(String str) {
            return false;
        }

        @Override // com.ss.ttvideoengine.DataLoaderListener
        public void onLogInfoToMonitor(int i, String str, JSONObject jSONObject) {
        }

        @Override // com.ss.ttvideoengine.DataLoaderListener
        public /* synthetic */ void onMultiNetworkSwitch(String str, String str2) {
            DataLoaderListener.CC.$default$onMultiNetworkSwitch(this, str, str2);
        }

        @Override // com.ss.ttvideoengine.DataLoaderListener
        public void onNotifyCDNLog(DataLoaderCDNLog dataLoaderCDNLog) {
        }

        @Override // com.ss.ttvideoengine.DataLoaderListener
        public void onNotifyCDNLog(JSONObject jSONObject) {
        }

        @Override // com.ss.ttvideoengine.DataLoaderListener
        public /* synthetic */ void onStartComplete() {
            DataLoaderListener.CC.$default$onStartComplete(this);
        }

        @Override // com.ss.ttvideoengine.DataLoaderListener
        public void onLoadProgress(DataLoaderHelper.DataLoaderTaskLoadProgress dataLoaderTaskLoadProgress) {
            Boolean bool;
            bl6.a a = j.a(j.d);
            StringBuilder sb = new StringBuilder();
            sb.append("onLoadProgress, isCacheEnd = ");
            if (dataLoaderTaskLoadProgress != null) {
                bool = Boolean.valueOf(dataLoaderTaskLoadProgress.isCacheEnd());
            } else {
                bool = null;
            }
            sb.append(bool);
            a.d(sb.toString(), new Object[0]);
        }

        @Override // com.ss.ttvideoengine.DataLoaderListener
        public void onTaskProgress(DataLoaderHelper.DataLoaderTaskProgressInfo dataLoaderTaskProgressInfo) {
            String str;
            Long l;
            Long l2;
            bl6.a a = j.a(j.d);
            StringBuilder sb = new StringBuilder();
            sb.append("onTaskProgress, mKey = ");
            String str2 = null;
            if (dataLoaderTaskProgressInfo != null) {
                str = dataLoaderTaskProgressInfo.mKey;
            } else {
                str = null;
            }
            sb.append(str);
            sb.append(", mediaSize = ");
            if (dataLoaderTaskProgressInfo != null) {
                l = Long.valueOf(dataLoaderTaskProgressInfo.mMediaSize);
            } else {
                l = null;
            }
            sb.append(l);
            sb.append(", cacheSize = ");
            if (dataLoaderTaskProgressInfo != null) {
                l2 = Long.valueOf(dataLoaderTaskProgressInfo.mCacheSizeFromZero);
            } else {
                l2 = null;
            }
            sb.append(l2);
            sb.append(", localFilePath = ");
            if (dataLoaderTaskProgressInfo != null) {
                str2 = dataLoaderTaskProgressInfo.mLocalFilePath;
            }
            sb.append(str2);
            a.d(sb.toString(), new Object[0]);
        }

        @Override // com.ss.ttvideoengine.DataLoaderListener
        public void dataLoaderError(String str, int i, Error error) {
            String str2;
            bl6.a a = j.a(j.d);
            StringBuilder sb = new StringBuilder();
            sb.append("videoId = ");
            sb.append(str);
            sb.append(", errorType = ");
            sb.append(i);
            sb.append(", error = ");
            if (error != null) {
                str2 = error.toString();
            } else {
                str2 = null;
            }
            sb.append(str2);
            a.b(sb.toString(), new Object[0]);
        }

        @Override // com.ss.ttvideoengine.DataLoaderListener
        public void onLogInfo(int i, String str, JSONObject jSONObject) {
            Application application;
            lk6.b bVar = lk6.c.a;
            if (bVar != null) {
                application = bVar.b;
            } else {
                application = null;
            }
            AppLog.recordMiscLog(application, str, jSONObject);
            j.a(j.d).d("onLogInfo, what = " + i + ", logType = " + str + ", log = " + jSONObject, new Object[0]);
        }

        @Override // com.ss.ttvideoengine.DataLoaderListener
        public void onNotify(int i, long j, long j2, String str) {
            j.a(j.d).d("onNotify, code = " + j + ", parameter = " + j2 + ", info = " + str, new Object[0]);
            lk6.b bVar = lk6.c.a;
        }
    }
}
