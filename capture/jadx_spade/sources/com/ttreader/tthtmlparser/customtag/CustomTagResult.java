package com.ttreader.tthtmlparser.customtag;

import com.bytedance.covode.number.Covode;
import com.ttreader.tthtmlparser.TTEpubUtils;
import com.ttreader.tttext.IRunDelegate;
import com.ttreader.tttext.b;
import com.ttreader.tttext.j;
import java.io.ByteArrayOutputStream;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class CustomTagResult {
    private final String bizHtml;
    private final IRunDelegate delegate;

    static {
        Covode.recordClassIndex(654758);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CustomTagResult() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ CustomTagResult copy$default(CustomTagResult customTagResult, IRunDelegate iRunDelegate, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            iRunDelegate = customTagResult.delegate;
        }
        if ((i & 2) != 0) {
            str = customTagResult.bizHtml;
        }
        return customTagResult.copy(iRunDelegate, str);
    }

    public final IRunDelegate component1() {
        return this.delegate;
    }

    public final String component2() {
        return this.bizHtml;
    }

    public final CustomTagResult copy(IRunDelegate iRunDelegate, String bizHtml) {
        Intrinsics.checkNotNullParameter(bizHtml, "bizHtml");
        return new CustomTagResult(iRunDelegate, bizHtml);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CustomTagResult)) {
            return false;
        }
        CustomTagResult customTagResult = (CustomTagResult) obj;
        return Intrinsics.areEqual(this.delegate, customTagResult.delegate) && Intrinsics.areEqual(this.bizHtml, customTagResult.bizHtml);
    }

    public int hashCode() {
        IRunDelegate iRunDelegate = this.delegate;
        return ((iRunDelegate == null ? 0 : iRunDelegate.hashCode()) * 31) + this.bizHtml.hashCode();
    }

    public String toString() {
        return "CustomTagResult(delegate=" + this.delegate + ", bizHtml=" + this.bizHtml + ')';
    }

    public final String getBizHtml() {
        return this.bizHtml;
    }

    public final IRunDelegate getDelegate() {
        return this.delegate;
    }

    public final byte[] convertBytes(j resourceManager) {
        Intrinsics.checkNotNullParameter(resourceManager, "resourceManager");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        b bVar = new b(byteArrayOutputStream);
        if (this.delegate == null) {
            bVar.writeBoolean(false);
            bVar.a(this.bizHtml);
        } else {
            bVar.writeBoolean(true);
            bVar.writeInt(resourceManager.c(this.delegate));
            bVar.writeFloat(TTEpubUtils.Px2Dp(this.delegate.GetAscent()));
            bVar.writeFloat(TTEpubUtils.Px2Dp(this.delegate.GetDescent()));
            bVar.writeFloat(TTEpubUtils.Px2Dp(this.delegate.GetAdvance()));
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(...)");
        return byteArray;
    }

    public CustomTagResult(IRunDelegate iRunDelegate, String bizHtml) {
        Intrinsics.checkNotNullParameter(bizHtml, "bizHtml");
        this.delegate = iRunDelegate;
        this.bizHtml = bizHtml;
    }

    public /* synthetic */ CustomTagResult(IRunDelegate iRunDelegate, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : iRunDelegate, (i & 2) != 0 ? "" : str);
    }
}
