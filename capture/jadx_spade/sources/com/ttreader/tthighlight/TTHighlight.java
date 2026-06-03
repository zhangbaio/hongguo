package com.ttreader.tthighlight;

import com.bytedance.covode.number.Covode;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class TTHighlight {

    public static class HighlightToken {
        public String[] type_stack_;
        public String value_;

        static {
            Covode.recordClassIndex(654707);
        }
    }

    static native void Initial();

    static native byte[] nativeHighlightAsTokens(byte[] bArr);

    static native void nativeLoadLanguage(byte[] bArr);

    static {
        Covode.recordClassIndex(654706);
        System.loadLibrary("TTHighlight");
        Initial();
    }

    public static void LoadLanguage(byte[] bArr) {
        nativeLoadLanguage(bArr);
    }

    public static HighlightToken[] HighlightAsTokens(String str) {
        return HighlightAsTokens(str, null);
    }

    static void WriteString(DataOutputStream dataOutputStream, String str) throws IOException {
        byte[] bytes = str.getBytes();
        dataOutputStream.writeInt(bytes.length);
        dataOutputStream.write(bytes);
    }

    public static HighlightToken[] HighlightAsTokens(String str, String[] strArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        HighlightToken[] highlightTokenArr = null;
        try {
            WriteString(dataOutputStream, str);
            if (strArr != null) {
                dataOutputStream.writeInt(strArr.length);
                for (String str2 : strArr) {
                    WriteString(dataOutputStream, str2);
                }
            } else {
                dataOutputStream.writeInt(0);
            }
            CBufferInputStream cBufferInputStream = new CBufferInputStream(new ByteArrayInputStream(nativeHighlightAsTokens(byteArrayOutputStream.toByteArray())));
            int readInt = cBufferInputStream.readInt();
            highlightTokenArr = new HighlightToken[readInt];
            for (int i = 0; i < readInt; i++) {
                highlightTokenArr[i] = new HighlightToken();
                int readInt2 = cBufferInputStream.readInt();
                highlightTokenArr[i].type_stack_ = new String[readInt2];
                for (int i2 = 0; i2 < readInt2; i2++) {
                    highlightTokenArr[i].type_stack_[i2] = cBufferInputStream.ReadCString();
                }
                highlightTokenArr[i].value_ = cBufferInputStream.ReadCString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return highlightTokenArr;
    }
}
