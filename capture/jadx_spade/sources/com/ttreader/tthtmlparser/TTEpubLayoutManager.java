package com.ttreader.tthtmlparser;

import com.bytedance.covode.number.Covode;
import com.ttreader.tthtmlparser.customtag.CustomTagConfig;
import com.ttreader.tthtmlparser.customtag.ICustomTagBehavior;
import com.ttreader.tttext.b;
import com.ttreader.tttext.h;
import com.ttreader.tttext.j;
import com.ttreader.tttext.k;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class TTEpubLayoutManager {
    private final Config config_;
    private final long instance_;
    private final JavaLayoutCallback layout_callback_;
    private final JavaResourceCallback resource_callback_;

    private native void nativeCancelParse(long j);

    private native long nativeCreateManager(long j);

    private native void nativeDestroyManager(long j);

    private native boolean nativeDistributePage(long j, long j2, float f, int i, boolean z, float f2, float f3);

    private static native void nativeInitialCache();

    private native boolean nativeIsStop(long j);

    private native void nativeNotifyParagraph(long j, long j2, long j3);

    private native void nativeParserAndLayoutHtml(long j, byte[] bArr, int i, float f, long j2, byte[] bArr2);

    private native void nativeRelayout(long j, long j2, long j3, float f, float f2, float f3, int i);

    private native void nativeResetCallbackCache(long j);

    public static class Config {
        private final long instance_ = nativeCreateConfig();

        static {
            Covode.recordClassIndex(654748);
        }

        private native long nativeCreateConfig();

        private native void nativeDestroyConfig(long j);

        private native void nativeSetLayoutCallback(long j, long j2);

        private native void nativeSetResourceCallback(long j, long j2);

        private native void nativeUpdateConfig(long j, byte[] bArr);

        public long GetInstance() {
            return this.instance_;
        }

        protected void finalize() throws Throwable {
            super.finalize();
            nativeDestroyConfig(this.instance_);
        }

        public void SetLayoutCallback(JavaLayoutCallback javaLayoutCallback) {
            nativeSetLayoutCallback(this.instance_, javaLayoutCallback.GetInstance());
        }

        public void SetResourceCallback(JavaResourceCallback javaResourceCallback) {
            nativeSetResourceCallback(this.instance_, javaResourceCallback.GetInstance());
        }

        public void UpdateConfig(TTEpubLayoutConfig tTEpubLayoutConfig, j jVar) {
            nativeUpdateConfig(this.instance_, ConvertParserInput(tTEpubLayoutConfig, jVar));
        }

        private void writeCustomTag(b bVar, TTEpubLayoutConfig tTEpubLayoutConfig) throws IOException {
            CustomTagConfig customTagConfig = tTEpubLayoutConfig.customTagConfig;
            if (customTagConfig != null && customTagConfig.getBehaviorList() != null) {
                bVar.writeInt(tTEpubLayoutConfig.customTagConfig.getBehaviorList().size());
                for (ICustomTagBehavior iCustomTagBehavior : tTEpubLayoutConfig.customTagConfig.getBehaviorList()) {
                    bVar.writeInt(iCustomTagBehavior.getMatchType().ordinal());
                    bVar.a(iCustomTagBehavior.getTag());
                }
            } else {
                bVar.writeInt(0);
            }
            CustomTagConfig customTagConfig2 = tTEpubLayoutConfig.customTagConfig;
            if (customTagConfig2 != null && customTagConfig2.getMappingConfig() != null) {
                bVar.writeInt(tTEpubLayoutConfig.customTagConfig.getMappingConfig().size());
                for (Map.Entry<String, String> entry : tTEpubLayoutConfig.customTagConfig.getMappingConfig().entrySet()) {
                    String key = entry.getKey();
                    String value = entry.getValue();
                    bVar.a(key);
                    bVar.a(value);
                }
                return;
            }
            bVar.writeInt(0);
        }

        private byte[] ConvertParserInput(TTEpubLayoutConfig tTEpubLayoutConfig, j jVar) {
            int i;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            b bVar = new b(byteArrayOutputStream);
            try {
                k kVar = new k(tTEpubLayoutConfig.textFontFamily, tTEpubLayoutConfig.textFont);
                bVar.writeFloat(TTEpubUtils.Px2Dp(tTEpubLayoutConfig.width));
                bVar.writeFloat(TTEpubUtils.Px2Dp(tTEpubLayoutConfig.height));
                bVar.writeFloat(72.0f);
                bVar.writeInt(jVar.d(kVar));
                bVar.writeFloat(TTEpubUtils.Px2Dp(tTEpubLayoutConfig.textFontSize));
                bVar.writeInt(jVar.d(kVar));
                bVar.writeFloat(TTEpubUtils.Px2Dp(tTEpubLayoutConfig.titleFontSize));
                bVar.writeFloat(TTEpubUtils.Px2Dp(tTEpubLayoutConfig.lineSpace));
                bVar.writeFloat(TTEpubUtils.Px2Dp(tTEpubLayoutConfig.paragraphSpace));
                bVar.writeFloat(TTEpubUtils.Px2Dp(tTEpubLayoutConfig.titleLineSpace));
                bVar.writeInt(tTEpubLayoutConfig.textColor);
                bVar.writeInt(tTEpubLayoutConfig.textAlignment.ordinal());
                bVar.writeFloat(TTEpubUtils.Px2Dp(tTEpubLayoutConfig.titleBeforeOffset));
                bVar.writeFloat(TTEpubUtils.Px2Dp(tTEpubLayoutConfig.titleAfterOffset));
                if (tTEpubLayoutConfig.autoFirstLineIndent) {
                    i = 1;
                } else {
                    i = 0;
                }
                bVar.writeInt(i);
                bVar.a(tTEpubLayoutConfig.chapterID);
                bVar.a(tTEpubLayoutConfig.defaultCss);
                bVar.a(tTEpubLayoutConfig.preferCss);
                bVar.writeBoolean(tTEpubLayoutConfig.enableHyphenate);
                bVar.writeBoolean(tTEpubLayoutConfig.continuousLayout);
                bVar.writeFloat(tTEpubLayoutConfig.line_height_scale_);
                bVar.writeBoolean(tTEpubLayoutConfig.line_height_round_to_even);
                bVar.writeBoolean(tTEpubLayoutConfig.line_gap_split_);
                bVar.writeBoolean(tTEpubLayoutConfig.punctuation_compress_);
                bVar.writeBoolean(tTEpubLayoutConfig.compress_full_width_punctuation_only);
                bVar.writeByte(tTEpubLayoutConfig.inline_punctuation_compress_.ordinal());
                bVar.writeFloat(tTEpubLayoutConfig.punctuation_compress_rate_);
                bVar.writeBoolean(tTEpubLayoutConfig.line_break_simplify_);
                bVar.writeInt(tTEpubLayoutConfig.line_break_limit_);
                bVar.writeBoolean(tTEpubLayoutConfig.css_line_height_);
                bVar.writeBoolean(tTEpubLayoutConfig.clearImageIndent);
                bVar.writeFloat(tTEpubLayoutConfig.font_px_to_em_scale);
                bVar.writeFloat(tTEpubLayoutConfig.font_size_limit_em);
                bVar.writeFloat(TTEpubUtils.Px2Dp(tTEpubLayoutConfig.screenWidth));
                bVar.writeFloat(TTEpubUtils.Px2Dp(tTEpubLayoutConfig.screenHeight));
                bVar.writeFloat(TTEpubUtils.Px2Dp(tTEpubLayoutConfig.insetTop));
                bVar.writeFloat(TTEpubUtils.Px2Dp(tTEpubLayoutConfig.insetLeft));
                bVar.writeFloat(TTEpubUtils.Px2Dp(tTEpubLayoutConfig.insetRight));
                bVar.writeFloat(TTEpubUtils.Px2Dp(tTEpubLayoutConfig.insetBottom));
                bVar.writeBoolean(tTEpubLayoutConfig.hideFanqieTypeImageNode);
                bVar.writeBoolean(tTEpubLayoutConfig.constraintImageSize);
                bVar.writeBoolean(tTEpubLayoutConfig.darkTheme);
                bVar.writeInt(tTEpubLayoutConfig.spacingMode);
                bVar.writeBoolean(tTEpubLayoutConfig.enableInlineImageOpt);
                bVar.writeFloat(tTEpubLayoutConfig.inlineImageAspectRatioLowerLimit);
                bVar.writeFloat(tTEpubLayoutConfig.inlineImageAspectRatioUpperLimit);
                bVar.writeFloat(tTEpubLayoutConfig.inlineImageResizeScale);
                bVar.writeFloat(tTEpubLayoutConfig.imageDynamicScaleMinFactor);
                bVar.writeFloat(tTEpubLayoutConfig.imageDynamicScaleAvailableSpaceThreshold);
                bVar.writeBoolean(tTEpubLayoutConfig.imageDynamicScaleMultipleEnabled);
                writeCustomTag(bVar, tTEpubLayoutConfig);
                bVar.writeBoolean(tTEpubLayoutConfig.enableEmojiRegex);
                bVar.writeInt(tTEpubLayoutConfig.maxLineCount);
                bVar.writeByte(tTEpubLayoutConfig.ellipsizeType.ordinal());
                bVar.writeInt(tTEpubLayoutConfig.pageCountLimit);
                bVar.writeFloat(TTEpubUtils.Px2Dp(tTEpubLayoutConfig.suggestedMinimumHeight));
                bVar.writeBoolean(tTEpubLayoutConfig.breakPageBetweenParagraphs);
                bVar.a(tTEpubLayoutConfig.chineseConvertDictPath);
                bVar.writeBoolean(tTEpubLayoutConfig.isSingleImageCommentsIncludeInLayout);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return byteArrayOutputStream.toByteArray();
        }
    }

    public void cancelParse() {
        nativeCancelParse(this.instance_);
    }

    public boolean isStop() {
        return nativeIsStop(this.instance_);
    }

    protected void finalize() throws Throwable {
        super.finalize();
        nativeDestroyManager(this.instance_);
    }

    static {
        Covode.recordClassIndex(654747);
        System.loadLibrary("TTHtmlParser");
        System.loadLibrary("tttext");
        nativeInitialCache();
    }

    public void NotifyAllParagraphs(TTEpubChapter tTEpubChapter) {
        this.resource_callback_.SetResourceManager(tTEpubChapter.GetResourceManager());
        nativeNotifyParagraph(this.instance_, tTEpubChapter.GetInstance(), this.config_.GetInstance());
    }

    public TTEpubLayoutManager(IResourceCallback iResourceCallback, ILayoutCallback iLayoutCallback) {
        JavaResourceCallback javaResourceCallback = new JavaResourceCallback(iResourceCallback);
        this.resource_callback_ = javaResourceCallback;
        JavaLayoutCallback javaLayoutCallback = new JavaLayoutCallback(iLayoutCallback);
        this.layout_callback_ = javaLayoutCallback;
        javaLayoutCallback.SetResourceCallback(javaResourceCallback.GetInstance());
        Config config = new Config();
        this.config_ = config;
        config.SetResourceCallback(javaResourceCallback);
        config.SetLayoutCallback(javaLayoutCallback);
        this.instance_ = nativeCreateManager(config.GetInstance());
    }

    public TTEpubChapter layoutHtml(String str, TTEpubLayoutConfig tTEpubLayoutConfig, float f) throws Exception {
        return layoutByCallback(str, ContentType.HTML, tTEpubLayoutConfig, f, null);
    }

    public TTEpubChapter layoutHtml(String str, TTEpubLayoutConfig tTEpubLayoutConfig, float f, PlaceHolder placeHolder) throws Exception {
        return layoutByCallback(str, ContentType.HTML, tTEpubLayoutConfig, f, placeHolder);
    }

    public TTEpubChapter layout(String str, ContentType contentType, TTEpubLayoutConfig tTEpubLayoutConfig, float f, List<h> list) throws Exception {
        byte[] bArr;
        nativeResetCallbackCache(this.resource_callback_.GetInstance());
        TTEpubUtils.SetDpi(tTEpubLayoutConfig.dpi);
        j jVar = new j();
        this.resource_callback_.SetResourceManager(jVar);
        this.layout_callback_.SetManager(jVar);
        this.resource_callback_.SetFallbackFont(tTEpubLayoutConfig.textFontFamily, tTEpubLayoutConfig.textFont);
        this.config_.UpdateConfig(tTEpubLayoutConfig, jVar);
        this.resource_callback_.OnParseStart();
        if (list != null) {
            for (h hVar : list) {
                if (hVar != null) {
                    hVar.h = jVar.c(hVar);
                }
            }
            bArr = ProtocolUtils.convertRunDelegatesToByteArray(list);
        } else {
            bArr = null;
        }
        nativeParserAndLayoutHtml(this.instance_, str.getBytes(), contentType.ordinal(), TTEpubUtils.Px2Dp(f), this.config_.GetInstance(), bArr);
        if (tTEpubLayoutConfig.enableInterruptOpt && isStop()) {
            throw new LayoutInterruptException("排版被中断");
        }
        this.resource_callback_.OnParserFinished();
        this.layout_callback_.OnLayoutFinished();
        return this.layout_callback_.result_chapter_;
    }

    public TTEpubChapter layoutByCallback(String str, ContentType contentType, TTEpubLayoutConfig tTEpubLayoutConfig, float f, PlaceHolder placeHolder) throws Exception {
        List<h> fetchInsertRuns;
        nativeResetCallbackCache(this.resource_callback_.GetInstance());
        TTEpubUtils.SetDpi(tTEpubLayoutConfig.dpi);
        j jVar = new j();
        this.resource_callback_.SetResourceManager(jVar);
        this.layout_callback_.SetManager(jVar);
        this.resource_callback_.SetFallbackFont(tTEpubLayoutConfig.textFontFamily, tTEpubLayoutConfig.textFont);
        this.config_.UpdateConfig(tTEpubLayoutConfig, jVar);
        this.resource_callback_.OnParseStart();
        if (placeHolder != null) {
            fetchInsertRuns = new ArrayList<>();
            h hVar = new h(-1);
            hVar.g = placeHolder.getWidth();
            hVar.f = placeHolder.getHeight();
            fetchInsertRuns.add(hVar);
        } else {
            fetchInsertRuns = this.resource_callback_.fetchInsertRuns();
        }
        if (fetchInsertRuns != null) {
            for (h hVar2 : fetchInsertRuns) {
                if (hVar2 != null) {
                    hVar2.h = jVar.c(hVar2);
                }
            }
        }
        nativeParserAndLayoutHtml(this.instance_, str.getBytes(), contentType.ordinal(), TTEpubUtils.Px2Dp(f), this.config_.GetInstance(), ProtocolUtils.convertRunDelegatesToByteArray(fetchInsertRuns));
        if (tTEpubLayoutConfig.enableInterruptOpt && isStop()) {
            throw new LayoutInterruptException("排版被中断");
        }
        this.resource_callback_.OnParserFinished();
        this.layout_callback_.OnLayoutFinished();
        return this.layout_callback_.result_chapter_;
    }

    public boolean distributePage(TTEpubChapter tTEpubChapter, float f, int i, boolean z, float f2, float f3) {
        return nativeDistributePage(this.instance_, tTEpubChapter.GetInstance(), TTEpubUtils.Px2Dp(f), i, z, f2, f3);
    }

    public void relayoutChapter(TTEpubChapter tTEpubChapter, TTEpubLayoutConfig tTEpubLayoutConfig, float f, float f2, float f3, int i) throws Exception {
        this.resource_callback_.SetResourceManager(tTEpubChapter.GetResourceManager());
        this.layout_callback_.SetManager(tTEpubChapter.GetResourceManager());
        this.resource_callback_.SetFallbackFont(tTEpubLayoutConfig.textFontFamily, tTEpubLayoutConfig.textFont);
        this.config_.UpdateConfig(tTEpubLayoutConfig, tTEpubChapter.GetResourceManager());
        this.layout_callback_.OnRelayout();
        nativeRelayout(this.instance_, tTEpubChapter.GetInstance(), this.config_.GetInstance(), TTEpubUtils.Px2Dp(f), TTEpubUtils.Px2Dp(f2), TTEpubUtils.Px2Dp(f3), i);
        if (tTEpubLayoutConfig.enableInterruptOpt && isStop()) {
            throw new LayoutInterruptException("重排版被中断");
        }
        this.layout_callback_.OnRelayoutFinished();
    }
}
