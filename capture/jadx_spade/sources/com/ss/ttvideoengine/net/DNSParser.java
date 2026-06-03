package com.ss.ttvideoengine.net;

import android.content.Context;
import android.os.SystemClock;
import com.bytedance.covode.number.Covode;
import com.ss.ttvideoengine.TTVideoEngine;
import com.ss.ttvideoengine.net.IPCache;
import com.ss.ttvideoengine.utils.Error;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class DNSParser extends BaseDNS implements DNSCompletionListener {
    private boolean hasRecAndExpired;
    private long mClearTime;
    private Context mContext;
    private BaseDNS mCurrentDNS;
    private int mDNSCount;
    private JSONObject mDnsInfo;
    private long mDnsTime;
    private int mExpiredTime;
    private boolean mForceReparse;
    private IPCache mIPCache;
    private boolean mIPFromCache;
    private boolean mIPFromServer;
    private int mIndex;
    private int[] mParserIndex;
    private boolean mUseDNSCache;
    private boolean mUseServerDNS;

    static {
        Covode.recordClassIndex(652578);
    }

    @Override // com.ss.ttvideoengine.net.DNSCompletionListener
    public void onCancelled() {
    }

    @Override // com.ss.ttvideoengine.net.DNSCompletionListener
    public void onRetry(Error error) {
    }

    public void setForceReparse() {
        this.mForceReparse = true;
    }

    public boolean getIsUseDNSCache() {
        return this.mUseDNSCache;
    }

    public boolean getIsUseServerDNS() {
        return this.mUseServerDNS;
    }

    @Override // com.ss.ttvideoengine.net.BaseDNS
    public void cancel() {
        if (this.mCancelled) {
            return;
        }
        this.mCancelled = true;
        BaseDNS baseDNS = this.mCurrentDNS;
        if (baseDNS != null) {
            baseDNS.cancel();
        }
    }

    private void DNSParseAsync() {
        int i = this.mParserIndex[this.mIndex];
        if (i != 0) {
            if (i != 1) {
                if (i == 2) {
                    this.mCurrentDNS = new HTTPDNS(this.mHostname, this.mNetClient, 2);
                }
            } else {
                this.mCurrentDNS = new HTTPDNS(this.mHostname, this.mNetClient, 1);
            }
        } else {
            this.mCurrentDNS = new LocalDNS(this.mHostname);
        }
        BaseDNS baseDNS = this.mCurrentDNS;
        if (baseDNS != null) {
            baseDNS.setCompletionListener(this);
            this.mCurrentDNS.start();
        }
    }

    public String getTypeStr() {
        if (this.mIPFromCache) {
            return "FromCache";
        }
        if (this.mIPFromServer) {
            return "FromServer";
        }
        int i = this.mParserIndex[this.mIndex];
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    return "";
                }
                return "TT_HTTP";
            }
            return "HTTP AL";
        }
        return "local";
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00a7  */
    @Override // com.ss.ttvideoengine.net.BaseDNS
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void start() {
        /*
            Method dump skipped, instructions count: 325
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.ttvideoengine.net.DNSParser.start():void");
    }

    public void setDNSExpiredTimeInS(int i) {
        this.mExpiredTime = i;
    }

    public void setIsUseDNSCache(boolean z) {
        this.mUseDNSCache = z;
    }

    public void setIsUseServerDNS(boolean z) {
        this.mUseServerDNS = z;
    }

    public void setDnsInfo(JSONObject jSONObject, Long l) {
        this.mDnsInfo = jSONObject;
        this.mDnsTime = l.longValue();
    }

    private void recordIPInfo(JSONObject jSONObject, long j) {
        if (this.mIPCache != null) {
            IPCache.IpInfo ipInfo = new IPCache.IpInfo();
            ipInfo.ip_json = jSONObject;
            ipInfo.ip_expiretime = SystemClock.elapsedRealtime() + (j * 1000);
            this.mIPCache.put(this.mHostname, ipInfo);
        }
    }

    @Override // com.ss.ttvideoengine.net.DNSCompletionListener
    public void onCompletion(JSONObject jSONObject, Error error) {
        JSONArray jSONArray;
        if (this.mCancelled) {
            if (!this.hasRecAndExpired || this.mForceReparse) {
                notifyCancelled();
                return;
            }
            return;
        }
        if (error == null) {
            if (jSONObject != null) {
                jSONArray = jSONObject.optJSONArray("ips");
            } else {
                jSONArray = null;
            }
            if (jSONArray != null && jSONArray.length() != 0) {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("ip", jSONArray.optString(0));
                } catch (Exception unused) {
                }
                long optLong = jSONObject.optLong("ttl");
                if (optLong == 0) {
                    optLong = this.mExpiredTime;
                }
                recordIPInfo(jSONObject2, optLong);
                if (!this.hasRecAndExpired || this.mForceReparse) {
                    try {
                        jSONObject2.put("time", jSONObject.optLong("time"));
                        jSONObject2.put("dns_type", jSONObject.optString("dns_type"));
                    } catch (Exception e) {
                        TTVideoEngineLog.d("DNSParser", e.toString());
                    }
                    notifySuccess(jSONObject2);
                    return;
                }
                return;
            }
            if (this.mParserIndex[this.mIndex] == 0) {
                notifyError(new Error("kTTVideoErrorDomainLocalDNS", -9997, "dns result empty,type:" + this.mParserIndex[this.mIndex]));
            } else {
                notifyError(new Error("kTTVideoErrorDomainHTTPDNS", -9997, "dns result empty,type:" + this.mParserIndex[this.mIndex]));
            }
            TTVideoEngineLog.d("DNSParser", "ips empty");
            return;
        }
        if (this.mIndex == this.mDNSCount - 1) {
            if (!this.hasRecAndExpired || this.mForceReparse) {
                notifyError(error);
                return;
            }
            return;
        }
        if (!this.hasRecAndExpired || this.mForceReparse) {
            notifyRetry(error);
        }
        this.mIndex++;
        start();
    }

    public DNSParser(Context context, String str, TTVNetClient tTVNetClient) {
        super(str, tTVNetClient);
        this.mIndex = 0;
        int[] iArr = {0, 2};
        this.mParserIndex = iArr;
        this.hasRecAndExpired = false;
        this.mForceReparse = false;
        this.mUseDNSCache = false;
        this.mUseServerDNS = false;
        this.mExpiredTime = 120;
        this.mIPFromCache = false;
        this.mIPFromServer = false;
        this.mDnsInfo = null;
        this.mDnsTime = 0L;
        this.mClearTime = 0L;
        this.mContext = context;
        this.mDNSCount = iArr.length;
        int[] dNSType = TTVideoEngine.getDNSType();
        if (dNSType != null && dNSType.length > 0) {
            for (int i = 0; i < dNSType.length; i++) {
                int i2 = dNSType[i];
                if (i2 != 0) {
                    if (i2 != 1) {
                        if (i2 != 2) {
                        }
                    } else {
                        this.mParserIndex[i] = 2;
                    }
                }
                this.mParserIndex[i] = i2;
            }
        } else if (TTVideoEngine.isHttpDnsFirst()) {
            int[] iArr2 = this.mParserIndex;
            iArr2[0] = 2;
            iArr2[1] = 0;
        }
        TTVideoEngineLog.i("DNSParser", "DNSType:" + Arrays.toString(this.mParserIndex));
        this.mIPCache = IPCache.getInstance();
    }
}
