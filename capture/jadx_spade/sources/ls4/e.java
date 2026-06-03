package ls4;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.skin.SkinManager;
import com.dragon.read.base.ui.skin.IViewThemeObserver;
import com.dragon.read.util.UiConfigSetter;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class e extends FrameLayout implements IViewThemeObserver {
    public static final int d;
    private final TextView a;
    private final CardView b;
    private a c;

    static {
        Covode.recordClassIndex(612370);
        d = 8;
    }

    public void notifyUpdateTheme() {
        int i;
        a aVar = this.c;
        if (aVar == null) {
            return;
        }
        if (SkinManager.isNightMode()) {
            i = aVar.c;
        } else {
            i = aVar.b;
        }
        this.b.setCardBackgroundColor(i);
    }

    public static final class b implements UiConfigSetter.e {
        public static final int b;
        public final a a;

        static {
            Covode.recordClassIndex(612372);
            int i = UiConfigSetter.k;
            b = i | i;
        }

        public void b(StringBuilder sb) {
            UiConfigSetter.e.a.a(this, sb);
        }

        public b(a uiConfig) {
            Intrinsics.checkNotNullParameter(uiConfig, "uiConfig");
            this.a = uiConfig;
        }

        public void a(View view) {
            e eVar;
            Intrinsics.checkNotNullParameter(view, "view");
            if (view instanceof e) {
                eVar = (e) view;
            } else {
                eVar = null;
            }
            if (eVar == null) {
                return;
            }
            eVar.setUiConfig(this.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setUiConfig(a aVar) {
        if (!StringsKt__StringsKt.isBlank(aVar.a)) {
            this.a.setText(aVar.a);
        }
        this.c = aVar;
        UiConfigSetter uiConfigSetter = aVar.d;
        if (uiConfigSetter != null) {
            uiConfigSetter.n(new View[]{this.b});
        }
        UiConfigSetter uiConfigSetter2 = aVar.e;
        if (uiConfigSetter2 != null) {
            uiConfigSetter2.n(new View[]{this.a});
        }
        notifyUpdateTheme();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        LayoutInflater.from(context).inflate(2131037242, this);
        View findViewById = findViewById(2131824854);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        this.a = (TextView) findViewById;
        CardView findViewById2 = findViewById(2131835474);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
        this.b = findViewById2;
        a aVar = this.c;
        if (aVar != null) {
            setUiConfig(aVar);
        }
    }

    public /* synthetic */ e(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public static final class a {
        public static final int f;
        public final String a;
        public final int b;
        public final int c;
        public final UiConfigSetter d;
        public final UiConfigSetter e;

        static {
            Covode.recordClassIndex(612371);
            int i = UiConfigSetter.k;
            f = i | i;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return Intrinsics.areEqual(this.a, aVar.a) && this.b == aVar.b && this.c == aVar.c && Intrinsics.areEqual(this.d, aVar.d) && Intrinsics.areEqual(this.e, aVar.e);
        }

        public int hashCode() {
            int hashCode = ((((this.a.hashCode() * 31) + this.b) * 31) + this.c) * 31;
            UiConfigSetter uiConfigSetter = this.d;
            int hashCode2 = (hashCode + (uiConfigSetter == null ? 0 : uiConfigSetter.hashCode())) * 31;
            UiConfigSetter uiConfigSetter2 = this.e;
            return hashCode2 + (uiConfigSetter2 != null ? uiConfigSetter2.hashCode() : 0);
        }

        public String toString() {
            return "UiConfig(text=" + this.a + ", bgLightColor=" + this.b + ", bgNightColor=" + this.c + ", rootViewUiConfigSetter=" + this.d + ", textViewUiConfigSetter=" + this.e + ')';
        }

        public a(String text, int i, int i2, UiConfigSetter uiConfigSetter, UiConfigSetter uiConfigSetter2) {
            Intrinsics.checkNotNullParameter(text, "text");
            this.a = text;
            this.b = i;
            this.c = i2;
            this.d = uiConfigSetter;
            this.e = uiConfigSetter2;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public /* synthetic */ a(java.lang.String r7, int r8, int r9, com.dragon.read.util.UiConfigSetter r10, com.dragon.read.util.UiConfigSetter r11, int r12, kotlin.jvm.internal.DefaultConstructorMarker r13) {
            /*
                r6 = this;
                r13 = r12 & 2
                if (r13 == 0) goto Lb
                r8 = 2131560247(0x7f0d0737, float:1.874586E38)
                int r8 = com.dragon.read.util.kotlin.ResourcesKt.getColor(r8)
            Lb:
                r2 = r8
                r8 = r12 & 4
                if (r8 == 0) goto L1e
                r8 = 2131558478(0x7f0d004e, float:1.8742273E38)
                int r8 = com.dragon.read.util.kotlin.ResourcesKt.getColor(r8)
                r9 = 1061997773(0x3f4ccccd, float:0.8)
                int r9 = com.dragon.read.util.kotlin.UIKt.addAlpha2Color(r8, r9)
            L1e:
                r3 = r9
                r8 = r12 & 8
                r9 = 0
                if (r8 == 0) goto L26
                r4 = r9
                goto L27
            L26:
                r4 = r10
            L27:
                r8 = r12 & 16
                if (r8 == 0) goto L2d
                r5 = r9
                goto L2e
            L2d:
                r5 = r11
            L2e:
                r0 = r6
                r1 = r7
                r0.<init>(r1, r2, r3, r4, r5)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: ls4.e.a.<init>(java.lang.String, int, int, com.dragon.read.util.UiConfigSetter, com.dragon.read.util.UiConfigSetter, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
        }
    }
}
