package com.ttreader.tttext;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class TTTextDefinition {
    private static final FontWeight[] a;
    private static final FontStyle[] b;
    private static final LinkStyle[] c;
    private static final ThemeColorType[] d;
    private static final CanvasOp[] e;
    private static final PathType[] f;
    private static final CharacterVerticalAlign[] g;
    private static final ParagraphHorizontalAlign[] h;
    private static final ParagraphVerticalAlign[] i;
    private static final LayoutResult[] j;
    private static final PaintOp[] k;

    public static class b {
        public int a = 0;
        public int b = 0;

        static {
            Covode.recordClassIndex(654812);
        }
    }

    public enum DecorationType {
        kNone,
        kUnderLine;

        static {
            Covode.recordClassIndex(654806);
        }
    }

    public enum EllipsizeType {
        kNone,
        kEnd;

        static {
            Covode.recordClassIndex(654807);
        }
    }

    public enum FontStyle {
        kUndefined,
        kNormal,
        kItalic;

        static {
            Covode.recordClassIndex(654809);
        }
    }

    public enum InlinePunctuationCompressType {
        kDisable,
        kEnable,
        kConditional;

        static {
            Covode.recordClassIndex(654811);
        }
    }

    public enum LinkStyle {
        kNone,
        kUnderline;

        static {
            Covode.recordClassIndex(654814);
        }
    }

    public enum ParagraphVerticalAlign {
        kTop,
        kCenter,
        kBaseline,
        kBottom;

        static {
            Covode.recordClassIndex(654817);
        }
    }

    public static class a {
        public final String a;
        public final FontWeight b;
        public final FontStyle c;
        public String[] d;

        static {
            Covode.recordClassIndex(654808);
        }

        public String toString() {
            return "FontFace{family='" + this.a + "', weight=" + this.b + '}';
        }

        public a(String str, FontWeight fontWeight, FontStyle fontStyle) {
            this.a = str;
            this.b = fontWeight;
            this.c = fontStyle;
        }
    }

    public enum CharacterVerticalAlign {
        kBaseLine,
        kSuperScript,
        kSubScript,
        kTop,
        kBottom,
        kMiddle;

        static {
            Covode.recordClassIndex(654805);
        }
    }

    public enum LayoutResult {
        kNormal,
        kRelayoutPage,
        kRelayoutLine,
        kBreakPage,
        kBreakColumn,
        kParagraphEnd;

        static {
            Covode.recordClassIndex(654813);
        }
    }

    public enum ParagraphHorizontalAlign {
        kLeft,
        kCenter,
        kRight,
        kJustify,
        kDistributed;

        static {
            Covode.recordClassIndex(654816);
        }
    }

    public enum PathType {
        kLines,
        kArc,
        kBezier,
        kMoveTo,
        kMultiPath;

        static {
            Covode.recordClassIndex(654818);
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
            Covode.recordClassIndex(654820);
        }
    }

    static {
        Covode.recordClassIndex(654803);
        a = FontWeight.values();
        b = FontStyle.values();
        c = LinkStyle.values();
        d = ThemeColorType.values();
        e = CanvasOp.values();
        f = PathType.values();
        g = CharacterVerticalAlign.values();
        h = ParagraphHorizontalAlign.values();
        i = ParagraphVerticalAlign.values();
        j = LayoutResult.values();
        k = PaintOp.values();
    }

    public enum FontWeight {
        kUndefined(0),
        kThin_100(100),
        kExtraLight_200(200),
        kLight_300(300),
        kNormal_400(400),
        kMedium_500(500),
        kSemiBold_600(600),
        kBold_700(700),
        kExtraBold_800(800),
        kBlack_900(900);

        public final int value;

        static {
            Covode.recordClassIndex(654810);
        }

        FontWeight(int i) {
            this.value = i;
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
            Covode.recordClassIndex(654815);
        }
    }

    public enum CanvasOp {
        kStartPaint,
        kEndPaint,
        kSave,
        kRestore,
        kTranslate,
        kScale,
        kRotate,
        kSkew,
        kClipRect,
        kClear,
        kClearRect,
        kFillRect,
        kDrawColor,
        kDrawLine,
        kDrawRect,
        kDrawOval,
        kDrawCircle,
        kDrawArc,
        kDrawPath,
        kDrawArcTo,
        kDrawText,
        kDrawGlyphs,
        kDrawRunDelegate,
        kDrawImage,
        kDrawImageRect,
        kDrawBackgroundDelegate,
        kDrawBlockRegion,
        kDrawHighlight,
        kDrawTextContent;

        static {
            Covode.recordClassIndex(654804);
        }
    }

    public static CanvasOp a(int i2) {
        return e[i2];
    }

    public static LayoutResult d(int i2) {
        return j[i2];
    }

    public static PathType f(int i2) {
        return f[i2];
    }

    public static FontStyle b(int i2) {
        if (i2 >= 0) {
            FontStyle[] fontStyleArr = b;
            if (i2 < fontStyleArr.length) {
                return fontStyleArr[i2];
            }
        }
        return FontStyle.kNormal;
    }

    public static FontWeight c(int i2) {
        if (i2 >= 0) {
            FontWeight[] fontWeightArr = a;
            if (i2 < fontWeightArr.length) {
                return fontWeightArr[i2];
            }
        }
        return FontWeight.kNormal_400;
    }

    public static PaintOp e(int i2) {
        if (i2 >= 0) {
            PaintOp[] paintOpArr = k;
            if (i2 < paintOpArr.length) {
                return paintOpArr[i2];
            }
        }
        return PaintOp.kEnd;
    }

    public static ThemeColorType g(int i2) {
        if (i2 >= 0) {
            ThemeColorType[] themeColorTypeArr = d;
            if (i2 < themeColorTypeArr.length) {
                return themeColorTypeArr[i2];
            }
        }
        return ThemeColorType.kNormal;
    }

    public static class c {
        public float a;
        public float b;

        static {
            Covode.recordClassIndex(654819);
        }

        public c(float f, float f2) {
            this.a = f;
            this.b = f2;
        }
    }
}
