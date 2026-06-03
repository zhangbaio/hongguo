package com.tencent.tinker.lib.signature;

import java.nio.ByteBuffer;
import java.security.DigestException;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
interface DataDigester {
    void consume(ByteBuffer byteBuffer) throws DigestException;
}
