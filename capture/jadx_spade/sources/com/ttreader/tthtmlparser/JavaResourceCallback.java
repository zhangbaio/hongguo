package com.ttreader.tthtmlparser;

import android.graphics.Typeface;
import com.bytedance.covode.number.Covode;
import com.ttreader.tthtmlparser.TTEpubDefinition;
import com.ttreader.tthtmlparser.customtag.CustomTagHandler;
import com.ttreader.tthtmlparser.customtag.CustomTagResult;
import com.ttreader.tthtmlparser.customtag.ElementNode;
import com.ttreader.tthtmlparser.dom.TTHtmlDocument;
import com.ttreader.tttext.IRunDelegate;
import com.ttreader.tttext.TTTextDefinition;
import com.ttreader.tttext.e;
import com.ttreader.tttext.g;
import com.ttreader.tttext.h;
import com.ttreader.tttext.j;
import com.ttreader.tttext.k;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class JavaResourceCallback {
    private final IResourceCallback callback_;
    private final CustomTagHandler customTagHandler;
    private final long instance_;
    private j resource_manager_;
    private TTEpubParagraphElement paragraph_element = new TTEpubParagraphElement(this.resource_manager_);
    private Typeface fallback_font = Typeface.DEFAULT;
    private String fallback_font_family = "";

    static {
        Covode.recordClassIndex(654716);
    }

    private native long CreateInstance();

    private native void DestroyInstance(long j);

    public long GetInstance() {
        return this.instance_;
    }

    public void OnParseStart() {
        this.callback_.OnParseStart();
    }

    public void OnParserFinished() {
        this.callback_.OnParserFinished();
    }

    public List<h> fetchInsertRuns() {
        return this.callback_.fetchInsertRunDelegates();
    }

    protected void finalize() throws Throwable {
        super.finalize();
        DestroyInstance(this.instance_);
    }

    public void NotifyHtmlParserEnd(long j) {
        this.callback_.NotifyHtmlParserEnd(new TTHtmlDocument(j));
    }

    public void SetResourceManager(j jVar) {
        this.resource_manager_ = jVar;
        this.paragraph_element = new TTEpubParagraphElement(jVar);
    }

    private TTEpubDefinition.Color ReadColor(com.ttreader.tttext.a aVar) throws IOException {
        return new TTEpubDefinition.Color(TTEpubDefinition.ColorType.values()[aVar.c()], aVar.readInt());
    }

    public byte[] FetchCustomTagReplacement(byte[] bArr) {
        CustomTagResult result = this.customTagHandler.getResult(ElementNode.fromBytes(bArr));
        if (result != null) {
            return result.convertBytes(this.resource_manager_);
        }
        return null;
    }

    public JavaResourceCallback(IResourceCallback iResourceCallback) {
        if (iResourceCallback != null) {
            this.callback_ = iResourceCallback;
            this.instance_ = CreateInstance();
            this.customTagHandler = new CustomTagHandler(iResourceCallback.getLayoutConfig());
            return;
        }
        throw new NullPointerException("resource callback initial with null object");
    }

    public byte[] FetchData(byte[] bArr) {
        com.ttreader.tttext.a aVar = new com.ttreader.tttext.a(new ByteArrayInputStream(bArr));
        try {
            String a = aVar.a();
            String a2 = aVar.a();
            int readInt = aVar.readInt();
            TTEpubDefinition.ResourceType resourceType = TTEpubDefinition.ResourceType.kDefault;
            if (readInt == 1) {
                resourceType = TTEpubDefinition.ResourceType.kCss;
            }
            return this.callback_.FetchResourceData(a, a2, resourceType);
        } catch (IOException e) {
            this.callback_.onCallbackError(e);
            return null;
        }
    }

    public byte[] NotifyParagraphElement(byte[] bArr) {
        this.paragraph_element.reset();
        try {
            this.paragraph_element.ReadFromStream(new com.ttreader.tttext.a(new ByteArrayInputStream(bArr)));
        } catch (IOException e) {
            this.callback_.onCallbackError(e);
        }
        this.callback_.NotifyParagraphElement(this.paragraph_element);
        return this.paragraph_element.toByteArray();
    }

    public void ReportParserErrorMsgs(byte[] bArr) {
        com.ttreader.tttext.a aVar = new com.ttreader.tttext.a(new ByteArrayInputStream(bArr));
        try {
            int readInt = aVar.readInt();
            if (readInt > 0) {
                ArrayList<TTEpubParserErrorMsg> arrayList = new ArrayList<>();
                for (int i = 0; i < readInt; i++) {
                    TTEpubParserErrorMsg tTEpubParserErrorMsg = new TTEpubParserErrorMsg();
                    tTEpubParserErrorMsg.error_id = aVar.readInt();
                    tTEpubParserErrorMsg.error_msg = aVar.a();
                    arrayList.add(tTEpubParserErrorMsg);
                }
                this.callback_.ReportParserErrorMsgs(arrayList);
            }
        } catch (IOException e) {
            this.callback_.onCallbackError(e);
        }
    }

    public int FetchFont(byte[] bArr) {
        com.ttreader.tttext.a aVar = new com.ttreader.tttext.a(new ByteArrayInputStream(bArr));
        try {
            int readInt = aVar.readInt();
            int readInt2 = aVar.readInt();
            TTTextDefinition.FontWeight c = TTTextDefinition.c(readInt);
            TTTextDefinition.FontStyle b = TTTextDefinition.b(readInt2);
            int readInt3 = aVar.readInt();
            TTTextDefinition.a[] aVarArr = new TTTextDefinition.a[readInt3];
            for (int i = 0; i < readInt3; i++) {
                aVarArr[i] = new TTTextDefinition.a(aVar.a(), c, b);
                int readInt4 = aVar.readInt();
                aVarArr[i].d = new String[readInt4];
                for (int i2 = 0; i2 < readInt4; i2++) {
                    aVarArr[i].d[i2] = aVar.a();
                }
            }
            k FetchFont = this.callback_.FetchFont(aVarArr, c, b);
            if (FetchFont == null || FetchFont.b == null) {
                FetchFont = new k(this.fallback_font_family, this.fallback_font);
            }
            return this.resource_manager_.d(FetchFont);
        } catch (IOException e) {
            this.callback_.onCallbackError(e);
            return 0;
        }
    }

    public byte[] FetchFootnote(byte[] bArr) {
        com.ttreader.tttext.a aVar = new com.ttreader.tttext.a(new ByteArrayInputStream(bArr));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        try {
            e FetchFootnoteInfo = this.callback_.FetchFootnoteInfo(aVar.a(), aVar.a());
            dataOutputStream.writeInt(this.resource_manager_.a(FetchFootnoteInfo));
            dataOutputStream.writeInt(FetchFootnoteInfo.b().ordinal());
        } catch (IOException e) {
            this.callback_.onCallbackError(e);
        }
        return byteArrayOutputStream.toByteArray();
    }

    public byte[] FetchLink(byte[] bArr) {
        com.ttreader.tttext.a aVar = new com.ttreader.tttext.a(new ByteArrayInputStream(bArr));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        try {
            g FetchLinkInfo = this.callback_.FetchLinkInfo(aVar.a());
            if (FetchLinkInfo != null) {
                dataOutputStream.writeInt(this.resource_manager_.b(FetchLinkInfo));
                dataOutputStream.writeInt(FetchLinkInfo.b().ordinal());
            } else {
                dataOutputStream.writeInt(-1);
                dataOutputStream.writeInt(-1);
            }
        } catch (IOException e) {
            this.callback_.onCallbackError(e);
        }
        return byteArrayOutputStream.toByteArray();
    }

    public float[] FetchSize(byte[] bArr) {
        com.ttreader.tttext.a aVar = new com.ttreader.tttext.a(new ByteArrayInputStream(bArr));
        float[] fArr = {0.0f, 0.0f};
        try {
            TTTextDefinition.c FetchSize = FetchSize(aVar.a(), aVar.a(), new TTEpubDefinition.ResourceAttributes());
            if (FetchSize != null) {
                fArr[0] = TTEpubUtils.Px2Dp(FetchSize.a);
                fArr[1] = TTEpubUtils.Px2Dp(FetchSize.b);
            }
        } catch (IOException e) {
            this.callback_.onCallbackError(e);
        }
        return fArr;
    }

    public byte[] FetchDelegate(byte[] bArr) {
        int i;
        com.ttreader.tttext.a aVar = new com.ttreader.tttext.a(new ByteArrayInputStream(bArr));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        try {
            int readInt = aVar.readInt();
            for (int i2 = 0; i2 < readInt; i2++) {
                TTEpubDefinition.ResourceAttributes resourceAttributes = new TTEpubDefinition.ResourceAttributes();
                String a = aVar.a();
                String a2 = aVar.a();
                float Dp2Px = TTEpubUtils.Dp2Px(aVar.readFloat());
                float Dp2Px2 = TTEpubUtils.Dp2Px(aVar.readFloat());
                float Dp2Px3 = TTEpubUtils.Dp2Px(aVar.readFloat());
                float Dp2Px4 = TTEpubUtils.Dp2Px(aVar.readFloat());
                resourceAttributes.isFootnote = aVar.readBoolean();
                resourceAttributes.fontSize = TTEpubUtils.Dp2Px(aVar.readFloat());
                resourceAttributes.isClickable = aVar.readBoolean();
                resourceAttributes.isEmoji = aVar.readBoolean();
                resourceAttributes.isInline = aVar.readBoolean();
                resourceAttributes.isFloatElement = aVar.readBoolean();
                resourceAttributes.isNinePatch = aVar.readBoolean();
                resourceAttributes.fontAscent = TTEpubUtils.Dp2Px(aVar.readFloat());
                resourceAttributes.fontDescent = TTEpubUtils.Dp2Px(aVar.readFloat());
                resourceAttributes.isBackgroundImg = aVar.readBoolean();
                resourceAttributes.objectFit = TTEpubDefinition.TomatoObjectFit.values()[aVar.d()];
                resourceAttributes.verticalAlign = TTEpubDefinition.VerticalAlign.values()[aVar.d()];
                resourceAttributes.tintColor = ReadColor(aVar);
                resourceAttributes.imageFilter = TTEpubDefinition.ImageFilter.values()[aVar.d()];
                resourceAttributes.scaleType = TTEpubDefinition.ScaleType.values()[aVar.d()];
                resourceAttributes.maxWidth = Dp2Px3;
                resourceAttributes.maxHeight = Dp2Px4;
                resourceAttributes.originHeight = TTEpubUtils.Dp2Px(aVar.readFloat());
                resourceAttributes.originWidth = TTEpubUtils.Dp2Px(aVar.readFloat());
                resourceAttributes.className = aVar.a();
                IRunDelegate FetchRunDelegate = this.callback_.FetchRunDelegate(a, a2, resourceAttributes, new TTTextDefinition.c(Dp2Px, Dp2Px2));
                if (FetchRunDelegate != null) {
                    i = this.resource_manager_.c(FetchRunDelegate);
                } else {
                    i = 0;
                }
                ProtocolUtils.writeRunDelegate(i, FetchRunDelegate, dataOutputStream);
            }
        } catch (IOException e) {
            this.callback_.onCallbackError(e);
        }
        return byteArrayOutputStream.toByteArray();
    }

    public void SetFallbackFont(String str, Typeface typeface) {
        this.fallback_font = typeface;
        this.fallback_font_family = str;
    }

    private TTTextDefinition.c FetchSize(String str, String str2, TTEpubDefinition.ResourceAttributes resourceAttributes) {
        return this.callback_.FetchImgSize(str, str2, resourceAttributes);
    }
}
