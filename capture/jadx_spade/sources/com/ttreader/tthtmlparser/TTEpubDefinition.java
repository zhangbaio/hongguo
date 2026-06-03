package com.ttreader.tthtmlparser;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class TTEpubDefinition {
    private static final LinkStyle[] link_ordinal_;
    private static final PageRelayout[] page_relayout_;
    private static final PaintOp[] paint_op_;
    private static final PathType[] path_ordinal_;
    private static final TomatoTextType[] text_type_;

    public static class ResourceAttributes {
        public String className;
        public float fontAscent;
        public float fontDescent;
        public float fontSize;
        public ImageFilter imageFilter;
        public boolean isBackgroundImg;
        public boolean isClickable;
        public boolean isEmoji;
        public boolean isFloatElement;
        public boolean isFootnote;
        public boolean isInline;
        public boolean isNinePatch;
        public float maxHeight;
        public float maxWidth;
        public TomatoObjectFit objectFit;
        public float originHeight;
        public float originWidth;
        public ScaleType scaleType;
        public Color tintColor;
        public VerticalAlign verticalAlign;

        static {
            Covode.recordClassIndex(654738);
        }
    }

    public enum ColorType {
        kArgb,
        kConstArgb,
        kUserDefined;

        static {
            Covode.recordClassIndex(654729);
        }
    }

    public enum CompressType {
        kNone,
        kLeft,
        kRight;

        static {
            Covode.recordClassIndex(654730);
        }
    }

    public enum FontStyle {
        kUndefined,
        kNormal,
        kItalic;

        static {
            Covode.recordClassIndex(654731);
        }
    }

    public enum LinkStyle {
        kNone,
        kUnderline;

        static {
            Covode.recordClassIndex(654734);
        }
    }

    public enum PageRelayout {
        kUndefined,
        kRelayout,
        kSuccess;

        static {
            Covode.recordClassIndex(654735);
        }
    }

    public enum ResourceType {
        kDefault,
        kCss;

        static {
            Covode.recordClassIndex(654739);
        }
    }

    public enum TomatoTextType {
        kUndefined,
        kText,
        kCode;

        static {
            Covode.recordClassIndex(654743);
        }
    }

    static {
        Covode.recordClassIndex(654727);
        link_ordinal_ = LinkStyle.values();
        path_ordinal_ = PathType.values();
        page_relayout_ = PageRelayout.values();
        paint_op_ = PaintOp.values();
        text_type_ = TomatoTextType.values();
    }

    public enum ImageFilter {
        kAuto,
        kReverse,
        kMask,
        kMultiplyMask,
        kMultiplyReverse,
        kSrcIn,
        kOpacity;

        static {
            Covode.recordClassIndex(654733);
        }
    }

    public enum PathType {
        kLines,
        kArc,
        kBezier,
        kMoveTo,
        kMultiPath;

        static {
            Covode.recordClassIndex(654737);
        }
    }

    public enum ScaleType {
        kCenterCrop,
        kBottomCrop,
        kRightCrop,
        kLeftCrop,
        kTopCrop,
        kFitCenter,
        kFitXY;

        static {
            Covode.recordClassIndex(654740);
        }
    }

    public enum ThemeColorType {
        kNormal,
        kLink,
        kBackground,
        kBlock,
        kFootnote,
        kPressedLink;

        static {
            Covode.recordClassIndex(654741);
        }
    }

    public enum TomatoObjectFit {
        kNone,
        kSize,
        kLine,
        kPage,
        kScreen;

        static {
            Covode.recordClassIndex(654742);
        }
    }

    public enum VerticalAlign {
        kBaseLine,
        kSuperScript,
        kSubScript,
        kTop,
        kBottom,
        kMiddle;

        static {
            Covode.recordClassIndex(654744);
        }
    }

    public enum FontWeight {
        kUndefined,
        kThin_100,
        kExtraLight_200,
        kLight_300,
        kNormal_400,
        kMedium_500,
        kSemiBold_600,
        kBold_700,
        kExtraBold_800,
        kBlack_900;

        static {
            Covode.recordClassIndex(654732);
        }
    }

    public enum PaintOp {
        kStartIncremental,
        kStart,
        kEnd,
        kFillStyle,
        kStrokeWidth,
        kColor,
        kTextSize,
        kBold,
        kItalic,
        kFont;

        static {
            Covode.recordClassIndex(654736);
        }
    }

    public static PageRelayout GetPageRelayout(int i) {
        return page_relayout_[i];
    }

    public static PathType GetPathType(int i) {
        return path_ordinal_[i];
    }

    public static LinkStyle GetLinkStyle(int i) {
        if (i >= 0) {
            LinkStyle[] linkStyleArr = link_ordinal_;
            if (i < linkStyleArr.length) {
                return linkStyleArr[i];
            }
        }
        return LinkStyle.kNone;
    }

    public static PaintOp GetPaintOp(int i) {
        if (i >= 0) {
            PaintOp[] paintOpArr = paint_op_;
            if (i < paintOpArr.length) {
                return paintOpArr[i];
            }
        }
        return PaintOp.kEnd;
    }

    public static TomatoTextType GetTomatoTextType(int i) {
        if (i >= 0) {
            TomatoTextType[] tomatoTextTypeArr = text_type_;
            if (i < tomatoTextTypeArr.length) {
                return tomatoTextTypeArr[i];
            }
        }
        return TomatoTextType.kUndefined;
    }

    public static class Color {
        public final ColorType type;
        public final int value;

        static {
            Covode.recordClassIndex(654728);
        }

        public Color(ColorType colorType, int i) {
            this.type = colorType;
            this.value = i;
        }
    }
}
