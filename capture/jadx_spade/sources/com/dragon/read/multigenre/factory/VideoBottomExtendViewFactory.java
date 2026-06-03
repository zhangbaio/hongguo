package com.dragon.read.multigenre.factory;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.skin.SkinDelegate;
import com.dragon.read.biz.common.GlobalFontService;
import com.dragon.read.multigenre.bean.CoverExtendViewExclusiveZone;
import com.dragon.read.multigenre.factory.b;
import com.dragon.read.rpc.model.RecTypeStyle;
import com.dragon.read.util.UiConfigSetter;
import com.dragon.read.util.kotlin.UIKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;
import ns4.f;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class VideoBottomExtendViewFactory implements com.dragon.read.multigenre.factory.b<BottomData> {
    public static final int b;
    public final BottomData a;

    public static final class b implements js4.b {
        public static final b a;

        static {
            Covode.recordClassIndex(612402);
            a = new b();
        }

        private b() {
        }
    }

    static {
        Covode.recordClassIndex(612397);
        b = 8;
    }

    private static final class a extends ls4.a<BottomData> implements at5.a {
        private final ImageView b;
        private final TextView c;
        private final View d;

        static {
            Covode.recordClassIndex(612401);
        }

        public View getInnerView() {
            return this.c;
        }

        public String getContent() {
            return this.c.getText().toString();
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

        private final void c(BottomData bottomData) {
            this.b.setVisibility(0);
            SkinDelegate.setImageDrawable(this.b, bottomData.a);
            this.c.setText(bottomData.h);
        }

        private final void e(BottomData bottomData) {
            this.b.setVisibility(8);
            this.c.setText(String.valueOf(bottomData.g));
        }

        private final void d(BottomData bottomData) {
            if (!bottomData.p) {
                this.b.setVisibility(8);
            } else {
                this.b.setVisibility(0);
                SkinDelegate.setImageDrawable(this.b, bottomData.a);
            }
            this.c.setText(bottomData.f);
        }

        private final void i(BottomData bottomData) {
            Drawable background = this.d.getBackground();
            if (background instanceof GradientDrawable) {
                float f = bottomData.n;
                if (f >= 0.0f) {
                    ((GradientDrawable) background).setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, f, f, f, f});
                }
            }
        }

        private final void f(BottomData bottomData) {
            int i;
            this.b.setVisibility(8);
            this.c.setIncludeFontPadding(true);
            this.c.setText(bottomData.i);
            int i2 = bottomData.q;
            if (i2 == RecTypeStyle.Following.getValue()) {
                i = 2130847420;
            } else if (i2 == RecTypeStyle.Popularity.getValue()) {
                i = 2130847416;
            } else if (i2 == RecTypeStyle.HotResing.getValue()) {
                i = 2130847417;
            } else if (i2 == RecTypeStyle.HotSearch.getValue()) {
                i = 2130847418;
            } else {
                i = 0;
            }
            if (i != 0) {
                this.b.setVisibility(0);
                SkinDelegate.setImageDrawable(this.b, i);
                this.c.setIncludeFontPadding(false);
            }
        }

        private final void g(BottomData bottomData) {
            setVisibility(0);
            Drawable drawable = bottomData.j;
            if (drawable != null) {
                this.d.setBackground(drawable);
            }
            if (bottomData.y) {
                UIKt.visible(this.d);
            } else {
                UIKt.invisible(this.d);
            }
            UiConfigSetter.h hVar = bottomData.k;
            if (hVar != null) {
                UiConfigSetter.j.c().a0(hVar).n(new View[]{this.c});
            }
            UiConfigSetter.h hVar2 = bottomData.l;
            if (hVar2 != null) {
                UiConfigSetter.j.c().a0(hVar2).n(new View[]{this.b});
            }
            Float f = bottomData.r;
            if (f != null) {
                this.c.setTextSize(f.floatValue());
            }
            Integer num = bottomData.w;
            if (num != null) {
                this.c.setMaxLines(num.intValue());
            }
            TextUtils.TruncateAt truncateAt = bottomData.x;
            if (truncateAt != null) {
                this.c.setEllipsize(truncateAt);
            }
            i(bottomData);
            j(bottomData);
        }

        @Override // ls4.a
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public void setData(BottomData data) {
            Intrinsics.checkNotNullParameter(data, "data");
            if (data.m) {
                this.c.setTypeface(a(1));
                if (data.o == BottomData.Scene.FANQIE_BOOK_MALL_DOUBLE_COL_SCENE) {
                    f.t(this.c, 1.0f, 0.0f, 0.0f, 2131561683);
                } else {
                    f.u(this.c, 0.0f, 0.0f, 0.0f, 0, 15, null);
                }
            }
            if (data.b) {
                g(data);
                f(data);
                return;
            }
            if (data.c) {
                g(data);
                d(data);
            } else if (data.d) {
                g(data);
                e(data);
            } else if (data.e) {
                g(data);
                c(data);
            } else {
                setVisibility(8);
            }
        }

        private final void j(BottomData bottomData) {
            if (bottomData.v == BottomData.HorizontalGravity.LEFT) {
                if (bottomData.p) {
                    UiConfigSetter.a aVar = UiConfigSetter.j;
                    UiConfigSetter c = aVar.c();
                    UiConfigSetter.ConstraintType constraintType = UiConfigSetter.ConstraintType.START_TO_START;
                    UiConfigSetter.ConstraintType constraintType2 = UiConfigSetter.ConstraintType.END_TO_END;
                    UiConfigSetter.ConstraintType constraintType3 = UiConfigSetter.ConstraintType.TOP_TO_TOP;
                    UiConfigSetter.ConstraintType constraintType4 = UiConfigSetter.ConstraintType.BOTTOM_TO_BOTTOM;
                    c.Z(new UiConfigSetter.b[]{new UiConfigSetter.b(constraintType, 0), new UiConfigSetter.b(constraintType2, -1), new UiConfigSetter.b(constraintType3, -1), new UiConfigSetter.b(constraintType4, 0)}).n(new View[]{this.b});
                    aVar.c().Z(new UiConfigSetter.b[]{new UiConfigSetter.b(constraintType, -1), new UiConfigSetter.b(UiConfigSetter.ConstraintType.START_TO_END, this.b.getId()), new UiConfigSetter.b(constraintType2, -1), new UiConfigSetter.b(constraintType3, this.b.getId()), new UiConfigSetter.b(constraintType4, this.b.getId())}).n(new View[]{this.c});
                    return;
                }
                UiConfigSetter.j.c().Z(new UiConfigSetter.b[]{new UiConfigSetter.b(UiConfigSetter.ConstraintType.START_TO_START, 0), new UiConfigSetter.b(UiConfigSetter.ConstraintType.END_TO_END, -1), new UiConfigSetter.b(UiConfigSetter.ConstraintType.TOP_TO_TOP, -1), new UiConfigSetter.b(UiConfigSetter.ConstraintType.BOTTOM_TO_BOTTOM, 0)}).n(new View[]{this.c});
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Context context, BottomData data) {
            super(context, null, 0, 6, null);
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(data, "data");
            if (data.u) {
                FrameLayout.inflate(context, 2131036978, this);
            } else if (data.t) {
                FrameLayout.inflate(context, 2131036962, this);
            } else {
                FrameLayout.inflate(context, 2131037071, this);
            }
            View findViewById = findViewById(2131830486);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
            this.b = (ImageView) findViewById;
            View findViewById2 = findViewById(2131827515);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
            this.c = (TextView) findViewById2;
            View findViewById3 = findViewById(2131820886);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
            this.d = findViewById3;
            xs4.e.m(this);
        }
    }

    @Override // com.dragon.read.multigenre.factory.b
    public /* bridge */ /* synthetic */ BottomData b() {
        return this.a;
    }

    @Override // com.dragon.read.multigenre.factory.a
    public UiConfigSetter.e d() {
        return b.a.b(this);
    }

    public static final class BottomData {
        public static final int z;
        public final int a;
        public final boolean b;
        public final boolean c;
        public final boolean d;
        public final boolean e;
        public final String f;
        public final long g;
        public final String h;
        public final String i;
        public final Drawable j;
        public final UiConfigSetter.h k;
        public final UiConfigSetter.h l;
        public final boolean m;
        public final float n;
        public final Scene o;
        public final boolean p;
        public final int q;
        public final Float r;
        public final Boolean s;
        public final boolean t;
        public final boolean u;
        public final HorizontalGravity v;
        public final Integer w;
        public final TextUtils.TruncateAt x;
        public final boolean y;

        static {
            Covode.recordClassIndex(612398);
            z = 8;
        }

        public BottomData() {
            this(0, false, false, false, false, null, 0L, null, null, null, null, null, false, 0.0f, null, false, 0, null, null, false, false, null, null, null, false, 33554431, null);
        }

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
        public static final class HorizontalGravity {
            private static final /* synthetic */ EnumEntries $ENTRIES;
            private static final /* synthetic */ HorizontalGravity[] $VALUES;
            public static final HorizontalGravity LEFT;
            public static final HorizontalGravity RIGHT;

            private static final /* synthetic */ HorizontalGravity[] $values() {
                return new HorizontalGravity[]{LEFT, RIGHT};
            }

            public static EnumEntries<HorizontalGravity> getEntries() {
                return $ENTRIES;
            }

            public static HorizontalGravity[] values() {
                return (HorizontalGravity[]) $VALUES.clone();
            }

            static {
                Covode.recordClassIndex(612399);
                LEFT = new HorizontalGravity("LEFT", 0);
                RIGHT = new HorizontalGravity("RIGHT", 1);
                HorizontalGravity[] $values = $values();
                $VALUES = $values;
                $ENTRIES = EnumEntriesKt.enumEntries($values);
            }

            public static HorizontalGravity valueOf(String str) {
                return (HorizontalGravity) Enum.valueOf(HorizontalGravity.class, str);
            }

            private HorizontalGravity(String str, int i) {
            }
        }

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
        public static final class Scene {
            private static final /* synthetic */ EnumEntries $ENTRIES;
            private static final /* synthetic */ Scene[] $VALUES;
            public static final Scene DEFAULT;
            public static final Scene FANQIE_BOOK_MALL_DOUBLE_COL_SCENE;

            private static final /* synthetic */ Scene[] $values() {
                return new Scene[]{DEFAULT, FANQIE_BOOK_MALL_DOUBLE_COL_SCENE};
            }

            public static EnumEntries<Scene> getEntries() {
                return $ENTRIES;
            }

            public static Scene[] values() {
                return (Scene[]) $VALUES.clone();
            }

            static {
                Covode.recordClassIndex(612400);
                DEFAULT = new Scene("DEFAULT", 0);
                FANQIE_BOOK_MALL_DOUBLE_COL_SCENE = new Scene("FANQIE_BOOK_MALL_DOUBLE_COL_SCENE", 1);
                Scene[] $values = $values();
                $VALUES = $values;
                $ENTRIES = EnumEntriesKt.enumEntries($values);
            }

            public static Scene valueOf(String str) {
                return (Scene) Enum.valueOf(Scene.class, str);
            }

            private Scene(String str, int i) {
            }
        }

        public BottomData(int i, boolean z2, boolean z3, boolean z4, boolean z5, String playCount, long j, String diggoCount, String showTextDirect, Drawable drawable, UiConfigSetter.h hVar, UiConfigSetter.h hVar2, boolean z6, float f, Scene scene, boolean z7, int i2, Float f2, Boolean bool, boolean z8, boolean z9, HorizontalGravity horizontalGravity, Integer num, TextUtils.TruncateAt truncateAt, boolean z10) {
            Intrinsics.checkNotNullParameter(playCount, "playCount");
            Intrinsics.checkNotNullParameter(diggoCount, "diggoCount");
            Intrinsics.checkNotNullParameter(showTextDirect, "showTextDirect");
            Intrinsics.checkNotNullParameter(scene, "scene");
            Intrinsics.checkNotNullParameter(horizontalGravity, "horizontalGravity");
            this.a = i;
            this.b = z2;
            this.c = z3;
            this.d = z4;
            this.e = z5;
            this.f = playCount;
            this.g = j;
            this.h = diggoCount;
            this.i = showTextDirect;
            this.j = drawable;
            this.k = hVar;
            this.l = hVar2;
            this.m = z6;
            this.n = f;
            this.o = scene;
            this.p = z7;
            this.q = i2;
            this.r = f2;
            this.s = bool;
            this.t = z8;
            this.u = z9;
            this.v = horizontalGravity;
            this.w = num;
            this.x = truncateAt;
            this.y = z10;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public /* synthetic */ BottomData(int r28, boolean r29, boolean r30, boolean r31, boolean r32, java.lang.String r33, long r34, java.lang.String r36, java.lang.String r37, android.graphics.drawable.Drawable r38, com.dragon.read.util.UiConfigSetter.h r39, com.dragon.read.util.UiConfigSetter.h r40, boolean r41, float r42, com.dragon.read.multigenre.factory.VideoBottomExtendViewFactory.BottomData.Scene r43, boolean r44, int r45, java.lang.Float r46, java.lang.Boolean r47, boolean r48, boolean r49, com.dragon.read.multigenre.factory.VideoBottomExtendViewFactory.BottomData.HorizontalGravity r50, java.lang.Integer r51, android.text.TextUtils.TruncateAt r52, boolean r53, int r54, kotlin.jvm.internal.DefaultConstructorMarker r55) {
            /*
                Method dump skipped, instructions count: 297
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.multigenre.factory.VideoBottomExtendViewFactory.BottomData.<init>(int, boolean, boolean, boolean, boolean, java.lang.String, long, java.lang.String, java.lang.String, android.graphics.drawable.Drawable, com.dragon.read.util.UiConfigSetter$h, com.dragon.read.util.UiConfigSetter$h, boolean, float, com.dragon.read.multigenre.factory.VideoBottomExtendViewFactory$BottomData$Scene, boolean, int, java.lang.Float, java.lang.Boolean, boolean, boolean, com.dragon.read.multigenre.factory.VideoBottomExtendViewFactory$BottomData$HorizontalGravity, java.lang.Integer, android.text.TextUtils$TruncateAt, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
        }
    }

    @Override // com.dragon.read.multigenre.factory.a
    public js4.a a() {
        return new js4.a(b.a, 150.1f, CoverExtendViewExclusiveZone.BOTTOM);
    }

    @Override // com.dragon.read.multigenre.factory.a
    public boolean c() {
        Boolean bool = this.a.s;
        if (bool != null) {
            return bool.booleanValue();
        }
        return true;
    }

    public VideoBottomExtendViewFactory(BottomData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.a = data;
    }

    @Override // com.dragon.read.multigenre.factory.a
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ls4.a<BottomData> e(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new a(context, this.a);
    }
}
