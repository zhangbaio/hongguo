package com.ttreader.tthtmlparser.dom;

import com.bytedance.covode.number.Covode;
import java.io.Closeable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class TTHtmlParser implements Closeable {
    public static final Companion Companion;
    private final long instance = nativeCreateParser();

    public static final class Companion {
        static {
            Covode.recordClassIndex(654769);
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final native long nativeCreateParser();

    private final native void nativeDestroyParser(long j);

    private final native long nativeGenerateXmlDocument(long j, String str);

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        destroy();
    }

    public final void destroy() {
        nativeDestroyParser(this.instance);
    }

    static {
        Covode.recordClassIndex(654768);
        Companion = new Companion(null);
        System.loadLibrary("TTHtmlParser");
    }

    public final TTHtmlDocument parse(String html) {
        Intrinsics.checkNotNullParameter(html, "html");
        return new TTHtmlDocument(nativeGenerateXmlDocument(this.instance, html));
    }
}
