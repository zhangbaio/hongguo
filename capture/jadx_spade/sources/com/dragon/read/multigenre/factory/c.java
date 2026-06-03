package com.dragon.read.multigenre.factory;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.compose.animation.m;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.skin.SkinDelegate;
import com.dragon.read.biz.common.GlobalFontService;
import com.dragon.read.multigenre.bean.CoverExtendViewExclusiveZone;
import com.dragon.read.multigenre.factory.b;
import com.dragon.read.util.UiConfigSetter;
import com.dragon.read.util.kotlin.ResourcesKt;
import com.dragon.read.util.kotlin.UIKt;
import com.dragon.read.widget.tag.UpdateTagView;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;
import ns4.f;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class c implements com.dragon.read.multigenre.factory.b<b> {
    public static final a b;
    public static final int c;
    public final b a;

    public static final class a {
        static {
            Covode.recordClassIndex(612404);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private static final class d implements js4.b {
        public static final d a;

        static {
            Covode.recordClassIndex(612407);
            a = new d();
        }

        private d() {
        }
    }

    static {
        Covode.recordClassIndex(612403);
        b = new a(null);
        c = 8;
    }

    /* renamed from: com.dragon.read.multigenre.factory.c$c, reason: collision with other inner class name */
    private static final class C0091c extends ls4.a<b> implements at5.a {
        private final UpdateTagView b;

        static {
            Covode.recordClassIndex(612406);
        }

        public View getInnerView() {
            return this.b;
        }

        public String getContent() {
            return this.b.getContent();
        }

        @Proxy("defaultFromStyle")
        @TargetClass("android.graphics.Typeface")
        public static Typeface a(int i) {
            Typeface regularTypeface;
            GlobalFontService globalFontService = GlobalFontService.IMPL;
            if (globalFontService.isGlobalFontReplace()) {
                if (i == 1) {
                    regularTypeface = globalFontService.getBoldTypeface();
                } else {
                    regularTypeface = globalFontService.getRegularTypeface();
                }
                if (regularTypeface != null) {
                    return regularTypeface;
                }
            }
            return Typeface.defaultFromStyle(i);
        }

        private final Drawable c(int i) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(UIKt.addAlpha2Color(ResourcesKt.getColor(2131558423), 0.4f));
            gradientDrawable.setCornerRadius(UIKt.getDp(i));
            return gradientDrawable;
        }

        @Override // ls4.a
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void setData(b data) {
            boolean z;
            Intrinsics.checkNotNullParameter(data, "data");
            this.b.Y();
            this.b.setText(data.a);
            this.b.setTextSize(data.n);
            xs4.e.m(this.b);
            Integer num = data.o;
            if (num != null) {
                this.b.setTextColor(num.intValue());
            } else {
                SkinDelegate.setTextColor(this.b, 2131558431);
            }
            String str = data.a;
            if (str != null && str.length() != 0) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                if (data.b != null) {
                    this.b.setCompoundDrawables((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                    this.b.setBackground(data.b);
                    this.b.setPadding(0, 0, 0, 0);
                    String str2 = data.p;
                    if (str2 != null) {
                        this.b.setImageContent(str2);
                    }
                } else {
                    this.b.setCompoundDrawables((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                    UpdateTagView updateTagView = this.b;
                    Drawable drawable = data.f;
                    if (drawable == null) {
                        drawable = c(2);
                    }
                    updateTagView.setBackground(drawable);
                    this.b.setPadding(UIKt.getDp(4), UIKt.getDp(2), UIKt.getDp(4), UIKt.getDp(2));
                }
            } else {
                Drawable drawable2 = data.b;
                if (drawable2 != null) {
                    this.b.setCompoundDrawables((Drawable) null, (Drawable) null, drawable2, (Drawable) null);
                    UpdateTagView updateTagView2 = this.b;
                    Drawable drawable3 = data.f;
                    if (drawable3 == null) {
                        drawable3 = c(4);
                    }
                    updateTagView2.setBackground(drawable3);
                    this.b.setPadding(UIKt.getDp(4), 0, 0, 0);
                    String str3 = data.p;
                    if (str3 != null) {
                        this.b.setImageContent(str3);
                    }
                } else {
                    this.b.setCompoundDrawables((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                    if (data.e == 3 && !data.g) {
                        this.b.setBackground(null);
                    } else {
                        UpdateTagView updateTagView3 = this.b;
                        Drawable drawable4 = data.f;
                        if (drawable4 == null) {
                            drawable4 = c(2);
                        }
                        updateTagView3.setBackground(drawable4);
                    }
                    this.b.setPadding(data.i, data.j, data.k, data.l);
                }
            }
            if (data.r) {
                f.w(this.b, 0.0f, 0.0f, 0.0f, 0, 15, null);
            } else {
                f.h(this.b);
            }
            ViewGroup.LayoutParams layoutParams = this.b.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            int i = data.e;
            if (i == 1) {
                layoutParams2.gravity = 8388659;
                this.b.setLayoutParams(layoutParams2);
                UIUtils.updateLayoutMargin(this.b, data.d, data.c, -3, -3);
            } else if (i == 2) {
                layoutParams2.gravity = 8388691;
                this.b.setLayoutParams(layoutParams2);
                UIUtils.updateLayoutMargin(this.b, data.d, -3, -3, data.c);
            } else if (i == 0) {
                layoutParams2.gravity = 8388661;
                this.b.setLayoutParams(layoutParams2);
                UIUtils.updateLayoutMargin(this.b, -3, data.c, data.d, -3);
            } else if (i == 3) {
                layoutParams2.gravity = 8388693;
                this.b.setLayoutParams(layoutParams2);
                UIUtils.updateLayoutMargin(this.b, -3, -3, data.d, data.c);
            }
            if (data.q) {
                UIKt.setFontWeight(this.b, 500);
            } else if (data.m || data.h) {
                this.b.setTypeface(a(1));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0091c(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            Intrinsics.checkNotNullParameter(context, "context");
            UpdateTagView updateTagView = new UpdateTagView(context, (AttributeSet) null);
            this.b = updateTagView;
            updateTagView.setPadding(UIKt.getDp(4), UIKt.getDp(2), UIKt.getDp(4), UIKt.getDp(2));
            updateTagView.setGravity(16);
            SkinDelegate.setTextColor(updateTagView, 2131558431);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 8388661;
            addView((View) updateTagView, (ViewGroup.LayoutParams) layoutParams);
        }

        public /* synthetic */ C0091c(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
        }
    }

    @Override // com.dragon.read.multigenre.factory.b
    public /* bridge */ /* synthetic */ b b() {
        return this.a;
    }

    @Override // com.dragon.read.multigenre.factory.a
    public UiConfigSetter.e d() {
        return b.a.b(this);
    }

    @Override // com.dragon.read.multigenre.factory.a
    public boolean c() {
        boolean z;
        String str = this.a.a;
        if (str != null && str.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (z && this.a.b == null) {
            return false;
        }
        return true;
    }

    @Override // com.dragon.read.multigenre.factory.a
    public js4.a a() {
        CoverExtendViewExclusiveZone coverExtendViewExclusiveZone;
        int i = this.a.e;
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        coverExtendViewExclusiveZone = CoverExtendViewExclusiveZone.TOP_RIGHT;
                    } else {
                        coverExtendViewExclusiveZone = CoverExtendViewExclusiveZone.BOTTOM_RIGHT;
                    }
                } else {
                    coverExtendViewExclusiveZone = CoverExtendViewExclusiveZone.BOTTOM_LEFT;
                }
            } else {
                coverExtendViewExclusiveZone = CoverExtendViewExclusiveZone.TOP_LEFT;
            }
        } else {
            coverExtendViewExclusiveZone = CoverExtendViewExclusiveZone.TOP_RIGHT;
        }
        return new js4.a(d.a, 175.0f, coverExtendViewExclusiveZone);
    }

    public c(b data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.a = data;
    }

    @Override // com.dragon.read.multigenre.factory.a
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ls4.a<b> e(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new C0091c(context, null, 0, 6, null);
    }

    public static final class b {
        public static final int s;
        public final String a;
        public final Drawable b;
        public final int c;
        public final int d;
        public final int e;
        public final Drawable f;
        public final boolean g;
        public final boolean h;
        public final int i;
        public final int j;
        public final int k;
        public final int l;
        public final boolean m;
        public final float n;
        public final Integer o;
        public final String p;
        public final boolean q;
        public final boolean r;

        static {
            Covode.recordClassIndex(612405);
            s = 8;
        }

        public final b a(String str, Drawable drawable, int i, int i2, int i3, Drawable drawable2, boolean z, boolean z2, int i4, int i5, int i6, int i7, boolean z3, float f, Integer num, String str2, boolean z4, boolean z5) {
            return new b(str, drawable, i, i2, i3, drawable2, z, z2, i4, i5, i6, i7, z3, f, num, str2, z4, z5);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return Intrinsics.areEqual(this.a, bVar.a) && Intrinsics.areEqual(this.b, bVar.b) && this.c == bVar.c && this.d == bVar.d && this.e == bVar.e && Intrinsics.areEqual(this.f, bVar.f) && this.g == bVar.g && this.h == bVar.h && this.i == bVar.i && this.j == bVar.j && this.k == bVar.k && this.l == bVar.l && this.m == bVar.m && Float.compare(this.n, bVar.n) == 0 && Intrinsics.areEqual(this.o, bVar.o) && Intrinsics.areEqual(this.p, bVar.p) && this.q == bVar.q && this.r == bVar.r;
        }

        public int hashCode() {
            String str = this.a;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            Drawable drawable = this.b;
            int hashCode2 = (((((((hashCode + (drawable == null ? 0 : drawable.hashCode())) * 31) + this.c) * 31) + this.d) * 31) + this.e) * 31;
            Drawable drawable2 = this.f;
            int hashCode3 = (((((((((((((((((hashCode2 + (drawable2 == null ? 0 : drawable2.hashCode())) * 31) + m.a(this.g)) * 31) + m.a(this.h)) * 31) + this.i) * 31) + this.j) * 31) + this.k) * 31) + this.l) * 31) + m.a(this.m)) * 31) + Float.floatToIntBits(this.n)) * 31;
            Integer num = this.o;
            int hashCode4 = (hashCode3 + (num == null ? 0 : num.hashCode())) * 31;
            String str2 = this.p;
            return ((((hashCode4 + (str2 != null ? str2.hashCode() : 0)) * 31) + m.a(this.q)) * 31) + m.a(this.r);
        }

        public String toString() {
            return "Data(videoContentTypeStr=" + this.a + ", mixTagDrawable=" + this.b + ", topMarginDp=" + this.c + ", rightMarginDp=" + this.d + ", style=" + this.e + ", backgroundDrawable=" + this.f + ", forceUseDrawable=" + this.g + ", needBoldText=" + this.h + ", paddingLeft=" + this.i + ", paddingTop=" + this.j + ", paddingRight=" + this.k + ", paddingBottom=" + this.l + ", bold=" + this.m + ", textSize=" + this.n + ", textColor=" + this.o + ", drawableContent=" + this.p + ", isFontWeightBold=" + this.q + ", shadowEnable=" + this.r + ')';
        }

        public b(String str, Drawable drawable, int i, int i2, int i3, Drawable drawable2, boolean z, boolean z2, int i4, int i5, int i6, int i7, boolean z3, float f, Integer num, String str2, boolean z4, boolean z5) {
            this.a = str;
            this.b = drawable;
            this.c = i;
            this.d = i2;
            this.e = i3;
            this.f = drawable2;
            this.g = z;
            this.h = z2;
            this.i = i4;
            this.j = i5;
            this.k = i6;
            this.l = i7;
            this.m = z3;
            this.n = f;
            this.o = num;
            this.p = str2;
            this.q = z4;
            this.r = z5;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public /* synthetic */ b(java.lang.String r23, android.graphics.drawable.Drawable r24, int r25, int r26, int r27, android.graphics.drawable.Drawable r28, boolean r29, boolean r30, int r31, int r32, int r33, int r34, boolean r35, float r36, java.lang.Integer r37, java.lang.String r38, boolean r39, boolean r40, int r41, kotlin.jvm.internal.DefaultConstructorMarker r42) {
            /*
                r22 = this;
                r0 = r41
                r1 = r0 & 2
                r2 = 0
                if (r1 == 0) goto L9
                r5 = r2
                goto Lb
            L9:
                r5 = r24
            Lb:
                r1 = r0 & 16
                r3 = 0
                if (r1 == 0) goto L12
                r8 = 0
                goto L14
            L12:
                r8 = r27
            L14:
                r1 = r0 & 32
                if (r1 == 0) goto L1a
                r9 = r2
                goto L1c
            L1a:
                r9 = r28
            L1c:
                r1 = r0 & 64
                if (r1 == 0) goto L22
                r10 = 0
                goto L24
            L22:
                r10 = r29
            L24:
                r1 = r0 & 128(0x80, float:1.8E-43)
                if (r1 == 0) goto L2a
                r11 = 0
                goto L2c
            L2a:
                r11 = r30
            L2c:
                r1 = r0 & 256(0x100, float:3.59E-43)
                r4 = 4
                if (r1 == 0) goto L37
                int r1 = com.dragon.read.util.kotlin.UIKt.getDp(r4)
                r12 = r1
                goto L39
            L37:
                r12 = r31
            L39:
                r1 = r0 & 512(0x200, float:7.17E-43)
                r6 = 2
                if (r1 == 0) goto L44
                int r1 = com.dragon.read.util.kotlin.UIKt.getDp(r6)
                r13 = r1
                goto L46
            L44:
                r13 = r32
            L46:
                r1 = r0 & 1024(0x400, float:1.435E-42)
                if (r1 == 0) goto L50
                int r1 = com.dragon.read.util.kotlin.UIKt.getDp(r4)
                r14 = r1
                goto L52
            L50:
                r14 = r33
            L52:
                r1 = r0 & 2048(0x800, float:2.87E-42)
                if (r1 == 0) goto L5c
                int r1 = com.dragon.read.util.kotlin.UIKt.getDp(r6)
                r15 = r1
                goto L5e
            L5c:
                r15 = r34
            L5e:
                r1 = r0 & 4096(0x1000, float:5.74E-42)
                if (r1 == 0) goto L65
                r16 = 0
                goto L67
            L65:
                r16 = r35
            L67:
                r1 = r0 & 8192(0x2000, float:1.148E-41)
                if (r1 == 0) goto L70
                r1 = 1091567616(0x41100000, float:9.0)
                r17 = 1091567616(0x41100000, float:9.0)
                goto L72
            L70:
                r17 = r36
            L72:
                r1 = r0 & 16384(0x4000, float:2.2959E-41)
                if (r1 == 0) goto L79
                r18 = r2
                goto L7b
            L79:
                r18 = r37
            L7b:
                r1 = 32768(0x8000, float:4.5918E-41)
                r1 = r1 & r0
                if (r1 == 0) goto L84
                r19 = r2
                goto L86
            L84:
                r19 = r38
            L86:
                r1 = 65536(0x10000, float:9.1835E-41)
                r1 = r1 & r0
                if (r1 == 0) goto L8e
                r20 = 0
                goto L90
            L8e:
                r20 = r39
            L90:
                r1 = 131072(0x20000, float:1.83671E-40)
                r0 = r0 & r1
                if (r0 == 0) goto L98
                r21 = 0
                goto L9a
            L98:
                r21 = r40
            L9a:
                r3 = r22
                r4 = r23
                r6 = r25
                r7 = r26
                r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.multigenre.factory.c.b.<init>(java.lang.String, android.graphics.drawable.Drawable, int, int, int, android.graphics.drawable.Drawable, boolean, boolean, int, int, int, int, boolean, float, java.lang.Integer, java.lang.String, boolean, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
        }
    }
}
