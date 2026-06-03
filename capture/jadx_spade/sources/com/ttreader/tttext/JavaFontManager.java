package com.ttreader.tttext;

import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import com.bytedance.covode.number.Covode;
import com.ttreader.tttext.TTTextDefinition;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class JavaFontManager {
    static boolean current_fake_bold_;
    static k current_font_;
    static int current_font_id_;
    static float current_font_size_;
    static boolean current_skew_;
    private static final JavaFontManager font_manager_;
    static final Paint.FontMetrics metrics;
    static final Paint paint;
    private final b<k> font_cache_ = new b<>();

    public static JavaFontManager GetInstance() {
        return font_manager_;
    }

    public void clearCache() {
        this.font_cache_.g();
    }

    private static class b<Value> {
        private final Map<Integer, Value> a;
        private final Map<Value, Integer> b;
        private int c;

        static {
            Covode.recordClassIndex(654796);
        }

        public void g() {
            this.b.clear();
            this.a.clear();
        }

        private b() {
            this.a = new ConcurrentHashMap();
            this.b = new ConcurrentHashMap();
            this.c = 1;
        }

        public Value a(int i) {
            return this.a.get(Integer.valueOf(i));
        }

        public int b(Value value) {
            int i;
            if (value == null) {
                return 0;
            }
            Integer num = this.b.get(value);
            if (num != null) {
                return num.intValue();
            }
            synchronized (this) {
                i = this.c;
                this.c = i + 1;
            }
            this.a.put(Integer.valueOf(i), value);
            this.b.put(value, Integer.valueOf(i));
            return i;
        }
    }

    public Map<Integer, k> GetFonts() {
        return new HashMap(((b) this.font_cache_).a);
    }

    static {
        Covode.recordClassIndex(654795);
        font_manager_ = new JavaFontManager();
        paint = new Paint();
        current_font_id_ = 0;
        current_font_ = null;
        current_font_size_ = 0.0f;
        current_fake_bold_ = false;
        current_skew_ = false;
        metrics = new Paint.FontMetrics();
    }

    public int RegisterFont(k kVar) {
        return this.font_cache_.b(kVar);
    }

    public k GetFont(int i) {
        return this.font_cache_.a(i);
    }

    public static float[] MultiGetTextAdvances(byte[] bArr) {
        com.ttreader.tttext.a aVar = new com.ttreader.tttext.a(new ByteArrayInputStream(bArr));
        try {
            String a2 = aVar.a();
            int readInt = aVar.readInt();
            float[] fArr = new float[aVar.readInt()];
            GetInstance();
            int i = 0;
            for (int i2 = 0; i2 < readInt; i2++) {
                int readInt2 = aVar.readInt();
                int readInt3 = aVar.readInt();
                int readInt4 = aVar.readInt();
                float readFloat = aVar.readFloat();
                boolean readBoolean = aVar.readBoolean();
                boolean readBoolean2 = aVar.readBoolean();
                Paint paint2 = paint;
                synchronized (paint2) {
                    ApplyFont(readInt4, s.a(readFloat), readBoolean, readBoolean2);
                    for (float f : GetTextAdvances(paint2, metrics, a2, readInt2, readInt3)) {
                        fArr[i] = f;
                        i++;
                    }
                }
            }
            return fArr;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void UnsafePutFont(int i, k kVar) {
        synchronized (this.font_cache_) {
            ((b) this.font_cache_).a.put(Integer.valueOf(i), kVar);
            ((b) this.font_cache_).b.put(kVar, Integer.valueOf(i));
            b<k> bVar = this.font_cache_;
            ((b) bVar).c = Math.max(i + 1, ((b) bVar).c);
        }
    }

    public static float[] getTextBounds(int i, float f, int i2) {
        float[] fArr;
        Paint paint2 = paint;
        synchronized (paint2) {
            ApplyFont(i, s.a(f), false, false);
            char[] chars = Character.toChars(i2);
            paint2.getTextBounds(chars, 0, chars.length, new Rect());
            fArr = new float[]{s.b(r3.left), s.b(r3.top), s.b(r3.right), s.b(r3.bottom)};
        }
        return fArr;
    }

    private static void ApplyFont(int i, float f, boolean z, boolean z2) {
        TTTextDefinition.FontWeight fontWeight;
        TTTextDefinition.FontStyle fontStyle;
        if (z) {
            fontWeight = TTTextDefinition.FontWeight.kBold_700;
        } else {
            fontWeight = TTTextDefinition.FontWeight.kNormal_400;
        }
        if (z2) {
            fontStyle = TTTextDefinition.FontStyle.kItalic;
        } else {
            fontStyle = TTTextDefinition.FontStyle.kNormal;
        }
        ApplyFont(i, f, fontWeight, fontStyle);
    }

    public static float[] GetFontMetrics(int i, float f, boolean z, boolean z2) {
        float[] fArr = new float[2];
        Paint paint2 = paint;
        synchronized (paint2) {
            ApplyFont(i, s.a(f), z, z2);
            Paint.FontMetrics fontMetrics = metrics;
            paint2.getFontMetrics(fontMetrics);
            fArr[0] = s.b(fontMetrics.ascent);
            fArr[1] = s.b(fontMetrics.descent);
        }
        return fArr;
    }

    public void ApplyFont(Paint paint2, int i, TTTextDefinition.FontWeight fontWeight, TTTextDefinition.FontStyle fontStyle) {
        Typeface typeface;
        k GetFont = GetFont(i);
        boolean z = false;
        if (GetFont != null && (typeface = GetFont.b) != null) {
            paint2.setTypeface(typeface);
            if (GetFont.c.ordinal() < fontWeight.ordinal()) {
                z = true;
            }
            paint2.setFakeBoldText(z);
            TTTextDefinition.FontStyle fontStyle2 = TTTextDefinition.FontStyle.kItalic;
            if (fontStyle == fontStyle2 && GetFont.d != fontStyle2) {
                paint2.setTextSkewX(-0.25f);
                return;
            } else {
                paint2.setTextSkewX(0.0f);
                return;
            }
        }
        paint2.setFakeBoldText(false);
        paint2.setTextSkewX(0.0f);
        if (fontWeight.ordinal() > TTTextDefinition.FontWeight.kNormal_400.ordinal()) {
            paint2.setTypeface(Typeface.DEFAULT_BOLD);
        } else if (fontStyle == TTTextDefinition.FontStyle.kItalic) {
            paint2.setTypeface(Typeface.SANS_SERIF);
        } else {
            paint2.setTypeface(Typeface.DEFAULT);
        }
    }

    private static void ApplyFont(int i, float f, TTTextDefinition.FontWeight fontWeight, TTTextDefinition.FontStyle fontStyle) {
        boolean z;
        k kVar = current_font_;
        if (i != current_font_id_) {
            kVar = GetInstance().GetFont(i);
            if (kVar != null) {
                paint.setTypeface(kVar.b);
            }
            current_font_id_ = i;
            current_font_ = kVar;
        }
        boolean z2 = false;
        if (kVar != null && kVar.b != null) {
            if (kVar.c.ordinal() < fontWeight.ordinal()) {
                z = true;
            } else {
                z = false;
            }
            if (z != current_fake_bold_) {
                paint.setFakeBoldText(z);
                current_fake_bold_ = z;
            }
            TTTextDefinition.FontStyle fontStyle2 = TTTextDefinition.FontStyle.kItalic;
            if (fontStyle == fontStyle2 && kVar.d != fontStyle2) {
                z2 = true;
            }
            if (z2 != current_skew_) {
                if (z2) {
                    paint.setTextSkewX(-0.25f);
                } else {
                    paint.setTextSkewX(0.0f);
                }
                current_skew_ = z2;
            }
        } else {
            if (current_fake_bold_) {
                paint.setFakeBoldText(false);
                current_fake_bold_ = false;
            }
            if (current_skew_) {
                paint.setTextSkewX(0.0f);
                current_skew_ = false;
            }
            if (fontWeight.ordinal() > TTTextDefinition.FontWeight.kNormal_400.ordinal()) {
                paint.setTypeface(Typeface.DEFAULT_BOLD);
            } else if (fontStyle == TTTextDefinition.FontStyle.kItalic) {
                paint.setTypeface(Typeface.SANS_SERIF);
            } else {
                paint.setTypeface(Typeface.DEFAULT);
            }
        }
        if (current_font_size_ != f) {
            paint.setTextSize(f);
            current_font_size_ = f;
        }
    }

    public static float[] GetTextAdvance(String str, int i, float f, boolean z, boolean z2) {
        float[] fArr = new float[str.length()];
        Paint paint2 = paint;
        synchronized (paint2) {
            ApplyFont(i, s.a(f), z, z2);
            paint2.getTextWidths(str, fArr);
        }
        for (int i2 = 0; i2 < str.length(); i2++) {
            fArr[i2] = s.b(fArr[i2]);
        }
        return fArr;
    }

    public static float[] GetTextAdvances(Paint paint2, Paint.FontMetrics fontMetrics, String str, int i, int i2) {
        float[] fArr = new float[i2 + 2];
        paint2.getTextWidths(str, i, i + i2, fArr);
        paint2.getFontMetrics(fontMetrics);
        for (int i3 = 0; i3 < i2; i3++) {
            fArr[i3] = s.b(fArr[i3]);
        }
        fArr[i2] = s.b(fontMetrics.ascent);
        fArr[i2 + 1] = s.b(fontMetrics.descent);
        return fArr;
    }

    public static float[][] MultiGetTextAdvances(String str, int i, int[] iArr, int[] iArr2, int[] iArr3, float[] fArr, boolean[] zArr, boolean[] zArr2) {
        float[][] fArr2 = new float[i][];
        for (int i2 = 0; i2 < i; i2++) {
            Paint paint2 = paint;
            synchronized (paint2) {
                ApplyFont(iArr3[i2], s.a(fArr[i2]), zArr[i2], zArr2[i2]);
                fArr2[i2] = GetTextAdvances(paint2, metrics, str, iArr[i2], iArr2[i2]);
            }
        }
        return fArr2;
    }
}
