package com.tencent.tinker.lib.signature;

import java.io.IOException;
import java.security.DigestException;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
interface DataSource {
    void feedIntoDataDigester(DataDigester dataDigester, long j, int i) throws IOException, DigestException;

    long size();
}
