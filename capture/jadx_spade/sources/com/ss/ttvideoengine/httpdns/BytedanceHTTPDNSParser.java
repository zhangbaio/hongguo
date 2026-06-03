package com.ss.ttvideoengine.httpdns;

import com.bytedance.covode.number.Covode;
import com.ss.mediakit.net.AVMDLCustomHTTPDNSParser;
import com.ss.mediakit.net.AVMDLCustomHTTPDNSParserResult;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class BytedanceHTTPDNSParser implements AVMDLCustomHTTPDNSParser {
    private final ByteDanceHttpDnsDepend mByteDanceHttpDnsDepend;

    static {
        Covode.recordClassIndex(652452);
    }

    public int start() {
        throw new UnsupportedOperationException("tob only");
    }

    public AVMDLCustomHTTPDNSParserResult parseHost(String str) {
        throw new UnsupportedOperationException("tob only");
    }

    public BytedanceHTTPDNSParser(ByteDanceHttpDnsDepend byteDanceHttpDnsDepend) {
        TTVideoEngineLog.d("BytedanceHTTPDNSParser", "new parser " + byteDanceHttpDnsDepend);
        this.mByteDanceHttpDnsDepend = byteDanceHttpDnsDepend;
    }
}
