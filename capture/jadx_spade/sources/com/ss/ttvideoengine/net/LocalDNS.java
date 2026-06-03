package com.ss.ttvideoengine.net;

import com.bytedance.covode.number.Covode;
import com.ss.ttvideoengine.utils.EngineThreadPool;
import com.ss.ttvideoengine.utils.Error;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import java.lang.ref.WeakReference;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.util.concurrent.Future;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class LocalDNS extends BaseDNS {
    private InetAddress mAddress;
    private Future mFuture;
    private boolean mRet;

    static {
        Covode.recordClassIndex(652583);
    }

    @Override // com.ss.ttvideoengine.net.BaseDNS
    public void cancel() {
        if (this.mCancelled) {
            return;
        }
        this.mCancelled = true;
        Future future = this.mFuture;
        if (future != null) {
            future.cancel(true);
            this.mFuture = null;
        }
    }

    @Override // com.ss.ttvideoengine.net.BaseDNS
    public void close() {
        super.close();
        this.mCancelled = true;
        Future future = this.mFuture;
        if (future != null) {
            future.cancel(true);
            this.mFuture = null;
        }
    }

    private static class MyRunnable implements Runnable {
        private final WeakReference<LocalDNS> mLocalDNSRef;

        static {
            Covode.recordClassIndex(652584);
        }

        @Override // java.lang.Runnable
        public void run() {
            LocalDNS localDNS = this.mLocalDNSRef.get();
            if (localDNS == null) {
                return;
            }
            synchronized (LocalDNS.class) {
                if (!localDNS.mRet) {
                    localDNS.mRet = true;
                    localDNS.notifyError(new Error("kTTVideoErrorDomainLocalDNS", -10000));
                }
            }
        }

        public MyRunnable(LocalDNS localDNS) {
            this.mLocalDNSRef = new WeakReference<>(localDNS);
        }
    }

    @Override // com.ss.ttvideoengine.net.BaseDNS
    public void start() {
        try {
            this.mFuture = EngineThreadPool.addExecuteTask(new Runnable() { // from class: com.ss.ttvideoengine.net.LocalDNS.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        LocalDNS localDNS = LocalDNS.this;
                        localDNS.mAddress = InetAddress.getByName(localDNS.mHostname);
                        if (LocalDNS.this.mAddress == null) {
                            synchronized (LocalDNS.class) {
                                if (!LocalDNS.this.mRet) {
                                    LocalDNS.this.mRet = true;
                                    LocalDNS.this.notifyError(new Error("kTTVideoErrorDomainLocalDNS", -9998));
                                }
                            }
                            return;
                        }
                        String hostAddress = LocalDNS.this.mAddress.getHostAddress();
                        if (LocalDNS.this.mAddress instanceof Inet6Address) {
                            hostAddress = String.format("[%s]", hostAddress);
                        }
                        synchronized (LocalDNS.class) {
                            if (LocalDNS.this.mRet) {
                                return;
                            }
                            LocalDNS.this.mRet = true;
                            if (hostAddress == null) {
                                LocalDNS.this.notifyError(new Error("kTTVideoErrorDomainLocalDNS", -9997));
                                return;
                            }
                            JSONObject jSONObject = new JSONObject();
                            JSONArray jSONArray = new JSONArray();
                            jSONArray.put(hostAddress);
                            try {
                                jSONObject.put("ips", jSONArray);
                                jSONObject.put("time", System.currentTimeMillis());
                                jSONObject.put("dns_type", "localDNS");
                            } catch (JSONException e) {
                                TTVideoEngineLog.d(e);
                            }
                            LocalDNS.this.notifySuccess(jSONObject);
                        }
                    } catch (Throwable th) {
                        TTVideoEngineLog.d(th);
                        synchronized (LocalDNS.class) {
                            if (!LocalDNS.this.mRet) {
                                LocalDNS.this.mRet = true;
                                LocalDNS.this.notifyError(new Error("kTTVideoErrorDomainLocalDNS", -9968, th.getMessage()));
                            }
                        }
                    }
                }
            });
        } catch (Exception e) {
            notifyError(new Error("kTTVideoErrorDomainLocalDNS", -9968, e.getMessage()));
        }
        this.mHandler.postDelayed(new MyRunnable(this), 10000L);
    }

    public LocalDNS(String str) {
        super(str);
        this.mRet = false;
        TTVideoEngineLog.i("LocalDNS", "DNS use LocalDNS");
    }
}
