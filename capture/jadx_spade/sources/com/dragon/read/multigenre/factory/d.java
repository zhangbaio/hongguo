package com.dragon.read.multigenre.factory;

import android.content.Context;
import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.compose.animation.m;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.skin.SkinManager;
import com.dragon.read.multigenre.bean.CoverExtendViewExclusiveZone;
import com.dragon.read.multigenre.bean.CoverExtendViewType;
import com.dragon.read.multigenre.factory.b;
import com.dragon.read.util.UiConfigSetter;
import com.dragon.read.util.kotlin.UIKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class d implements com.dragon.read.multigenre.factory.b<a> {
    public final a a;

    private static final class b extends ls4.a<a> implements at5.a {
        private final TextView b;

        static {
            Covode.recordClassIndex(612410);
        }

        public static final class a extends ViewOutlineProvider {
            a() {
            }

            @Override // android.view.ViewOutlineProvider
            public void getOutline(View view, Outline outline) {
                if (view != null && outline != null) {
                    outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), UIKt.getFloatDp(8));
                }
            }
        }

        public View getInnerView() {
            return this.b;
        }

        public String getContent() {
            return this.b.getText().toString();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Context context) {
            super(context, null, 0, 6, null);
            Intrinsics.checkNotNullParameter(context, "context");
            FrameLayout.inflate(context, 2131037090, this);
            View findViewById = findViewById(2131821071);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
            this.b = (TextView) findViewById;
            setClipToOutline(true);
            setOutlineProvider(new a());
        }

        @Override // ls4.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void setData(a data) {
            int i;
            Integer num;
            Intrinsics.checkNotNullParameter(data, "data");
            this.b.getLayoutParams().width = UIKt.getDp(data.c);
            this.b.getLayoutParams().height = UIKt.getDp(data.d);
            this.b.setTextSize(data.e);
            this.b.setText(String.valueOf(data.b));
            int i2 = data.b;
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        i = 2130839688;
                        if (SkinManager.isNightMode() && (num = data.f) != null) {
                            if (num != null) {
                                i = num.intValue();
                            }
                        } else {
                            Integer num2 = data.g;
                            if (num2 != null) {
                                i = num2.intValue();
                            }
                        }
                    } else {
                        i = 2130839686;
                    }
                } else {
                    i = 2130839689;
                }
            } else {
                i = 2130839687;
            }
            this.b.setBackgroundResource(i);
        }
    }

    static {
        Covode.recordClassIndex(612408);
    }

    @Override // com.dragon.read.multigenre.factory.b
    public /* bridge */ /* synthetic */ a b() {
        return this.a;
    }

    @Override // com.dragon.read.multigenre.factory.a
    public boolean c() {
        return this.a.a;
    }

    @Override // com.dragon.read.multigenre.factory.a
    public UiConfigSetter.e d() {
        return b.a.b(this);
    }

    @Override // com.dragon.read.multigenre.factory.a
    public js4.a a() {
        return new js4.a(CoverExtendViewType.TYPE_VIDEO_RANK, 175.0f, CoverExtendViewExclusiveZone.TOP_LEFT);
    }

    public d(a videoRankData) {
        Intrinsics.checkNotNullParameter(videoRankData, "videoRankData");
        this.a = videoRankData;
    }

    @Override // com.dragon.read.multigenre.factory.a
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ls4.a<a> e(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new b(context);
    }

    public static final class a {
        public final boolean a;
        public final int b;
        public final int c;
        public final int d;
        public final int e;
        public final Integer f;
        public final Integer g;

        static {
            Covode.recordClassIndex(612409);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.a == aVar.a && this.b == aVar.b && this.c == aVar.c && this.d == aVar.d && this.e == aVar.e && Intrinsics.areEqual(this.f, aVar.f) && Intrinsics.areEqual(this.g, aVar.g);
        }

        public int hashCode() {
            int a = ((((((((m.a(this.a) * 31) + this.b) * 31) + this.c) * 31) + this.d) * 31) + this.e) * 31;
            Integer num = this.f;
            int hashCode = (a + (num == null ? 0 : num.hashCode())) * 31;
            Integer num2 = this.g;
            return hashCode + (num2 != null ? num2.hashCode() : 0);
        }

        public String toString() {
            return "VideoRankData(isRankStyle=" + this.a + ", rankIndex=" + this.b + ", widthDp=" + this.c + ", heightDp=" + this.d + ", textSizeSp=" + this.e + ", normalDarkDrawable=" + this.f + ", normalDrawable=" + this.g + ')';
        }

        public a(boolean z, int i, int i2, int i3, int i4, Integer num, Integer num2) {
            this.a = z;
            this.b = i;
            this.c = i2;
            this.d = i3;
            this.e = i4;
            this.f = num;
            this.g = num2;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public /* synthetic */ a(boolean r10, int r11, int r12, int r13, int r14, java.lang.Integer r15, java.lang.Integer r16, int r17, kotlin.jvm.internal.DefaultConstructorMarker r18) {
            /*
                r9 = this;
                r0 = r17 & 4
                if (r0 == 0) goto L9
                r0 = 26
                r4 = 26
                goto La
            L9:
                r4 = r12
            La:
                r0 = r17 & 8
                if (r0 == 0) goto L13
                r0 = 24
                r5 = 24
                goto L14
            L13:
                r5 = r13
            L14:
                r0 = r17 & 16
                if (r0 == 0) goto L1d
                r0 = 14
                r6 = 14
                goto L1e
            L1d:
                r6 = r14
            L1e:
                r0 = r17 & 32
                r1 = 0
                if (r0 == 0) goto L25
                r7 = r1
                goto L26
            L25:
                r7 = r15
            L26:
                r0 = r17 & 64
                if (r0 == 0) goto L2c
                r8 = r1
                goto L2e
            L2c:
                r8 = r16
            L2e:
                r1 = r9
                r2 = r10
                r3 = r11
                r1.<init>(r2, r3, r4, r5, r6, r7, r8)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.multigenre.factory.d.a.<init>(boolean, int, int, int, int, java.lang.Integer, java.lang.Integer, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
        }
    }
}
