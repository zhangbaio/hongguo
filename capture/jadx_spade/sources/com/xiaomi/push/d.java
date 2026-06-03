package com.xiaomi.push;

import com.bytedance.covode.number.Covode;
import java.io.IOException;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class d extends IOException {
    static {
        Covode.recordClassIndex(655432);
    }

    static d a() {
        return new d("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either than the input has been truncated or that an embedded message misreported its own length.");
    }

    static d b() {
        return new d("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    static d c() {
        return new d("CodedInputStream encountered a malformed varint.");
    }

    static d d() {
        return new d("Protocol message contained an invalid tag (zero).");
    }

    static d e() {
        return new d("Protocol message end-group tag did not match expected tag.");
    }

    static d f() {
        return new d("Protocol message tag had invalid wire type.");
    }

    static d g() {
        return new d("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }

    static d h() {
        return new d("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
    }

    public d(String str) {
        super(str);
    }
}
