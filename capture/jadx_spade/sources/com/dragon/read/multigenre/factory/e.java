package com.dragon.read.multigenre.factory;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.covode.number.Covode;
import com.dragon.read.multigenre.bean.CoverExtendViewExclusiveZone;
import com.dragon.read.multigenre.factory.b;
import com.dragon.read.util.UiConfigSetter;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class e implements com.dragon.read.multigenre.factory.b<b> {
    public static final int b;
    public final b a;

    public static final class a implements js4.b {
        public static final a a;

        static {
            Covode.recordClassIndex(612412);
            a = new a();
        }

        private a() {
        }
    }

    static {
        Covode.recordClassIndex(612411);
        b = 8;
    }

    private static final class c extends ls4.a<b> implements at5.a {
        private final TextView b;
        private final View c;

        static {
            Covode.recordClassIndex(612414);
        }

        public View getInnerView() {
            return this.b;
        }

        public String getContent() {
            return this.b.getText().toString();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Context context) {
            super(context, null, 0, 6, null);
            Intrinsics.checkNotNullParameter(context, "context");
            FrameLayout.inflate(context, 2131037082, this);
            View findViewById = findViewById(2131827515);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
            this.b = (TextView) findViewById;
            View findViewById2 = findViewById(2131820886);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
            this.c = findViewById2;
        }

        @Override // ls4.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void setData(b data) {
            Intrinsics.checkNotNullParameter(data, "data");
            Drawable drawable = data.c;
            if (drawable != null) {
                this.c.setBackground(drawable);
            }
            this.b.setText(data.a);
            UiConfigSetter.h hVar = data.b;
            if (hVar != null) {
                UiConfigSetter.j.c().a0(hVar).n(new View[]{this.b});
            }
        }
    }

    @Override // com.dragon.read.multigenre.factory.b
    public /* bridge */ /* synthetic */ b b() {
        return this.a;
    }

    @Override // com.dragon.read.multigenre.factory.a
    public boolean c() {
        return b.a.a(this);
    }

    @Override // com.dragon.read.multigenre.factory.a
    public UiConfigSetter.e d() {
        return b.a.b(this);
    }

    @Override // com.dragon.read.multigenre.factory.a
    public js4.a a() {
        return new js4.a(a.a, 175.0f, CoverExtendViewExclusiveZone.TOP_RIGHT);
    }

    public e(b topData) {
        Intrinsics.checkNotNullParameter(topData, "topData");
        this.a = topData;
    }

    @Override // com.dragon.read.multigenre.factory.a
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ls4.a<b> e(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new c(context);
    }

    public static final class b {
        public static final int d;
        public String a;
        public final UiConfigSetter.h b;
        public Drawable c;

        static {
            Covode.recordClassIndex(612413);
            d = 8;
        }

        public b() {
            this(null, null, null, 7, null);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return Intrinsics.areEqual(this.a, bVar.a) && Intrinsics.areEqual(this.b, bVar.b) && Intrinsics.areEqual(this.c, bVar.c);
        }

        public int hashCode() {
            int hashCode = this.a.hashCode() * 31;
            UiConfigSetter.h hVar = this.b;
            int hashCode2 = (hashCode + (hVar == null ? 0 : hVar.hashCode())) * 31;
            Drawable drawable = this.c;
            return hashCode2 + (drawable != null ? drawable.hashCode() : 0);
        }

        public String toString() {
            return "TopData(text=" + this.a + ", tvMargins=" + this.b + ", bgDrawable=" + this.c + ')';
        }

        public b(String text, UiConfigSetter.h hVar, Drawable drawable) {
            Intrinsics.checkNotNullParameter(text, "text");
            this.a = text;
            this.b = hVar;
            this.c = drawable;
        }

        public /* synthetic */ b(String str, UiConfigSetter.h hVar, Drawable drawable, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? null : hVar, (i & 4) != 0 ? null : drawable);
        }
    }
}
