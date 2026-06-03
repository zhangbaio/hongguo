package com.ss.videoarch.strategy.streamFeature;

import com.bytedance.covode.number.Covode;
import com.ss.videoarch.strategy.utils.JNINamespace;
import java.nio.ByteBuffer;
import org.json.JSONArray;
import org.json.JSONException;

@JNINamespace("jni")
/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class StreamFeature {
    public StreamFeature a = null;

    static {
        Covode.recordClassIndex(653219);
    }

    private static native String nativeConvertAlgoSeiToJsonString(byte[] bArr);

    public static JSONArray a(ByteBuffer byteBuffer) throws JSONException {
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        byte[] bArr = new byte[byteBuffer.remaining()];
        byteBuffer.get(bArr);
        byteBuffer.position(position);
        byteBuffer.limit(limit);
        return new JSONArray(nativeConvertAlgoSeiToJsonString(bArr));
    }
}
