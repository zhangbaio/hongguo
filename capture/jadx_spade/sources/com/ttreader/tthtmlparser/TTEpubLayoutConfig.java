package com.ttreader.tthtmlparser;

import android.graphics.Typeface;
import com.bytedance.covode.number.Covode;
import com.ttreader.tthtmlparser.customtag.CustomTagConfig;
import com.ttreader.tttext.TTTextDefinition;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class TTEpubLayoutConfig {
    public CustomTagConfig customTagConfig;
    public boolean enableEmojiRegex;
    public float height;
    public Typeface textFont;
    public String textFontFamily;
    public float textFontSize;
    public float titleFontSize;
    public float width;
    public float suggestedMinimumHeight = 0.0f;
    public float dpi = 160.0f;
    public float titleLineSpace = 0.0f;
    public float lineSpace = 0.0f;
    public float paragraphSpace = 0.0f;
    public int textColor = -16777216;
    public String defaultCss = "";
    public String preferCss = "";
    public Alignment textAlignment = Alignment.kJustify;
    public float titleBeforeOffset = 0.0f;
    public float titleAfterOffset = 0.0f;
    public boolean autoFirstLineIndent = false;
    public String chapterID = "";
    public boolean enableHyphenate = false;
    public boolean continuousLayout = true;
    public float line_height_scale_ = 1.4f;
    public boolean line_height_round_to_even = false;
    public boolean line_gap_split_ = true;
    public boolean punctuation_compress_ = false;
    public boolean compress_full_width_punctuation_only = false;
    public TTTextDefinition.InlinePunctuationCompressType inline_punctuation_compress_ = TTTextDefinition.InlinePunctuationCompressType.kDisable;
    public float punctuation_compress_rate_ = 0.5f;
    public boolean line_break_simplify_ = true;
    public int line_break_limit_ = 4;
    public int pageCountLimit = 0;
    public boolean css_line_height_ = false;
    public boolean clearImageIndent = false;
    public float font_px_to_em_scale = 23.0f;
    public float font_size_limit_em = 1.5f;
    public float screenWidth = 0.0f;
    public float screenHeight = 0.0f;
    public float insetTop = 0.0f;
    public float insetBottom = 0.0f;
    public float insetLeft = 0.0f;
    public float insetRight = 0.0f;
    public boolean hideFanqieTypeImageNode = false;
    public boolean constraintImageSize = false;
    public boolean darkTheme = false;
    public int spacingMode = -1;
    public boolean enableInterruptOpt = false;
    public boolean breakPageBetweenParagraphs = false;
    public boolean enableInlineImageOpt = false;
    public float inlineImageAspectRatioLowerLimit = 0.5f;
    public float inlineImageAspectRatioUpperLimit = 2.0f;
    public float inlineImageResizeScale = 1.5f;
    public float imageDynamicScaleMinFactor = 0.0f;
    public float imageDynamicScaleAvailableSpaceThreshold = 0.0f;
    public boolean imageDynamicScaleMultipleEnabled = false;
    public int maxLineCount = 0;
    public TTTextDefinition.EllipsizeType ellipsizeType = TTTextDefinition.EllipsizeType.kNone;
    public String chineseConvertDictPath = "";
    public boolean isSingleImageCommentsIncludeInLayout = true;

    static {
        Covode.recordClassIndex(654745);
    }

    public enum Alignment {
        kLeft,
        kCenter,
        kRight,
        kJustify,
        kDistribute;

        static {
            Covode.recordClassIndex(654746);
        }
    }

    public String toString() {
        return "TTEpubLayoutConfig{punctuation_compress_=" + this.punctuation_compress_ + ", compress_full_width_only=" + this.compress_full_width_punctuation_only + ", inline_punctuation_compress_=" + this.inline_punctuation_compress_ + ", punctuation_compress_rate_=" + this.punctuation_compress_rate_ + ", spacingMode=" + this.spacingMode + '}';
    }
}
