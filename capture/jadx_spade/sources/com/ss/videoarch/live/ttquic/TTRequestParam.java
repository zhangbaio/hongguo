package com.ss.videoarch.live.ttquic;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
class TTRequestParam {
    public String url = "";
    public int httpVersion = 2;
    public int lowProtocol = 2;
    public int quicVersion = 43;
    public int cryptoProtocol = 1;
    public int enableCertVerify = 1;
    public int httpCacheMaxAgeSec = 600;
    public int openTimeoutMs = 5000;
    public int readTimeoutMs = 5000;
    public int preloadMode = 10;
    public int cmafEnableFastOpen = 1;
    public int cmafSkipInitSection = 1;
    public int cmafStartSegOffset = 1;
    public int cmafPreloadNum = 1;
    public int cmafPreloadParallel = 0;
    public int cmafPreloadMPDUpdateMs = 2000;
    public int cmafPreloadMPDExpMs = 5000;
    public String quicSCFGAddr = "";
    public String host = "";
    public String ipaddr = "";
    public String format = "";
    public String protocol = "";
    public int cacheMode = 1;
    public int cacheFrameCount = 100;
    public int cacheDuration = 2000;
    public int cacheGopCount = 1;
    public int cacheSize = 800000;
    public int minCacheDuration = 500;
    public int optCancelTask = 0;
    public String quicParams = "";
    public String httpxParams = "";

    static {
        Covode.recordClassIndex(652894);
    }

    TTRequestParam() {
    }

    public String toString() {
        return "TTRequestParam{url='" + this.url + "', httpVersion=" + this.httpVersion + ", lowProtocol=" + this.lowProtocol + ", quicVersion=" + this.quicVersion + ", cryptoProtocol=" + this.cryptoProtocol + ", enableCertVerify=" + this.enableCertVerify + ", httpCacheMaxAgeSec=" + this.httpCacheMaxAgeSec + ", openTimeoutMs=" + this.openTimeoutMs + ", readTimeoutMs=" + this.readTimeoutMs + ", preloadMode=" + this.preloadMode + ", cmafEnableFastOpen=" + this.cmafEnableFastOpen + ", cmafSkipInitSection=" + this.cmafSkipInitSection + ", cmafStartSegOffset=" + this.cmafStartSegOffset + ", cmafPreloadNum=" + this.cmafPreloadNum + ", cmafPreloadParallel=" + this.cmafPreloadParallel + ", cmafPreloadMPDInterval=" + this.cmafPreloadMPDUpdateMs + ", cmafPreloadMPDExpTime=" + this.cmafPreloadMPDExpMs + ", quicSCFGAddr='" + this.quicSCFGAddr + "', host='" + this.host + "', ipaddr='" + this.ipaddr + "', format='" + this.format + "', protocol='" + this.protocol + "', cacheMode=" + this.cacheMode + ", cacheFrameCount=" + this.cacheFrameCount + ", cacheDuration=" + this.cacheDuration + ", minCacheDuration=" + this.minCacheDuration + ", optCancelTask=" + this.optCancelTask + '}';
    }
}
