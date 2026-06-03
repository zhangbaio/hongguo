package com.ttnet.org.chromium.net;

import com.bytedance.covode.number.Covode;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import java.net.InetAddress;
import java.util.List;

@JNINamespace("net::android")
/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class DnsStatus {
    private final List<InetAddress> a;
    private final boolean b;
    private final String c;
    private final String d;

    static {
        Covode.recordClassIndex(654450);
    }

    public boolean getPrivateDnsActive() {
        return this.b;
    }

    public String getPrivateDnsServerName() {
        return this.c;
    }

    public String getSearchDomains() {
        return this.d;
    }

    public byte[][] getDnsServers() {
        byte[][] bArr = new byte[this.a.size()][];
        for (int i = 0; i < this.a.size(); i++) {
            bArr[i] = this.a.get(i).getAddress();
        }
        return bArr;
    }

    public DnsStatus(List<InetAddress> list, boolean z, String str, String str2) {
        this.a = list;
        this.b = z;
        this.c = str == null ? "" : str;
        this.d = str2 == null ? "" : str2;
    }
}
