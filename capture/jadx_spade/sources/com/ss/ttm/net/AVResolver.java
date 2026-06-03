package com.ss.ttm.net;

import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.ss.ttm.player.AVThreadPool;
import java.net.InetAddress;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Pattern;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class AVResolver {
    public static int HOST_MAX_CACHE_TIME;
    private static final Hashtable<String, HostInfo> mCacheHosts;
    private HostInfo mHostInfo;
    private String mHostName;
    private String[] mIPStr;
    private boolean mRet = false;
    private Thread mThread = null;
    private String mError = null;

    static class HostInfo {
        public String ip;
        public long time;

        static {
            Covode.recordClassIndex(652061);
        }

        HostInfo() {
        }
    }

    public void freeAddress() {
        if (this.mThread != null) {
            try {
                this.mThread.interrupt();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    static {
        Covode.recordClassIndex(652060);
        HOST_MAX_CACHE_TIME = 600000;
        mCacheHosts = new Hashtable<>();
    }

    public int isSuccess() {
        if (!this.mRet) {
            return 0;
        }
        String[] strArr = this.mIPStr;
        if (strArr != null && strArr[0] != null) {
            return 1;
        }
        return -1;
    }

    static class ParserHost implements Runnable {
        String mHostName;
        AVResolver mResolver;

        static {
            Covode.recordClassIndex(652062);
        }

        @Override // java.lang.Runnable
        public void run() {
            InetAddress inetAddress;
            String str = null;
            try {
                inetAddress = InetAddress.getByName(this.mHostName);
                try {
                    str = inetAddress.getHostAddress();
                } catch (Throwable th) {
                    th = th;
                    th.printStackTrace();
                    this.mResolver.mError = th.getMessage();
                    this.mResolver.mRet = true;
                    if (inetAddress == null) {
                    } else {
                        return;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                inetAddress = null;
            }
            this.mResolver.mRet = true;
            if (inetAddress == null && str != null) {
                this.mResolver.mIPStr = new String[1];
                this.mResolver.mIPStr[0] = str;
                HostInfo hostInfo = new HostInfo();
                hostInfo.time = System.currentTimeMillis();
                hostInfo.ip = str;
                AVResolver.putHostInfo(this.mHostName, hostInfo);
                hostInfo.time = System.currentTimeMillis();
            }
        }

        public ParserHost(AVResolver aVResolver, String str) {
            this.mResolver = aVResolver;
            this.mHostName = str;
        }
    }

    public String getAddress() {
        String[] strArr;
        if (this.mRet && (strArr = this.mIPStr) != null && strArr[0] != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("getAddress return ip:");
            sb.append(this.mIPStr[0]);
            return this.mIPStr[0];
        }
        return "parser host name: " + this.mHostName + " error.err msg:" + this.mError;
    }

    public static final boolean isIP(String str) {
        if (str.length() >= 7 && str.length() <= 15) {
            try {
                return Pattern.compile("([1-9]|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3}").matcher(str).find();
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        if (str.charAt(0) != '[' || str.charAt(str.length() - 1) != ']') {
            return false;
        }
        return true;
    }

    public void getAddressInfo(String str) {
        this.mHostName = str;
        if (TextUtils.isEmpty(str)) {
            this.mRet = true;
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("getAddressInfo start.hostname:");
        sb.append(str);
        if (isIP(this.mHostName)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("getAddressInfo is ip.ip:");
            sb2.append(str);
            this.mIPStr = new String[]{this.mHostName};
            this.mRet = true;
            return;
        }
        Hashtable<String, HostInfo> hashtable = mCacheHosts;
        HostInfo hostInfo = hashtable.get(str);
        this.mHostInfo = hostInfo;
        if (hostInfo != null) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("getAddressInfo first find in cache.hostname:");
            sb3.append(str);
            if (this.mHostInfo.ip != null) {
                long currentTimeMillis = System.currentTimeMillis();
                HostInfo hostInfo2 = this.mHostInfo;
                if (currentTimeMillis - hostInfo2.time < HOST_MAX_CACHE_TIME) {
                    this.mIPStr = new String[]{hostInfo2.ip};
                    this.mRet = true;
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("getAddressInfo hit cached:ip:");
                    sb4.append(this.mHostInfo.ip);
                    sb4.append(",time:");
                    sb4.append(this.mHostInfo.time);
                    return;
                }
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("getAddressInfo cache is to long.hostname:");
            sb5.append(str);
            hashtable.remove(str);
            this.mHostInfo = null;
        }
        try {
            AVThreadPool.addTask(new ParserHost(this, this.mHostName));
        } catch (Exception e) {
            this.mRet = true;
            this.mError = e.getMessage();
        }
    }

    static synchronized void putHostInfo(String str, HostInfo hostInfo) {
        String str2;
        synchronized (AVResolver.class) {
            long currentTimeMillis = System.currentTimeMillis();
            try {
                Hashtable<String, HostInfo> hashtable = mCacheHosts;
                HostInfo hostInfo2 = null;
                String str3 = null;
                if (hashtable.size() > 128) {
                    Iterator<Map.Entry<String, HostInfo>> it2 = hashtable.entrySet().iterator();
                    HostInfo hostInfo3 = null;
                    while (it2.hasNext()) {
                        HostInfo value = it2.next().getValue();
                        str3 = it2.next().getKey();
                        if (value != null) {
                            long j = value.time;
                            if (j < currentTimeMillis) {
                                hostInfo3 = value;
                                currentTimeMillis = j;
                            }
                        }
                    }
                    str2 = str3;
                    hostInfo2 = hostInfo3;
                } else {
                    str2 = null;
                }
                if (hostInfo2 != null && str2 != null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("putHostInfo remove host cache");
                    sb.append(hostInfo2.ip);
                    mCacheHosts.remove(str2);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            mCacheHosts.put(str, hostInfo);
        }
    }
}
