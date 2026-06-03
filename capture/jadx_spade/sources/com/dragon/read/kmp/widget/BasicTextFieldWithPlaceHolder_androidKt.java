package com.dragon.read.kmp.widget;

import android.view.KeyEvent;
import androidx.compose.foundation.text.w2;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.x2;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.g3;
import com.bytedance.covode.number.Covode;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class BasicTextFieldWithPlaceHolder_androidKt {
    static {
        Covode.recordClassIndex(609629);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit c(String str, Function1 function1, Modifier modifier, int i, androidx.compose.ui.graphics.c0 c0Var, g3 g3Var, int i2, int i3, Composer composer, int i4) {
        b(str, function1, modifier, i, c0Var, g3Var, composer, x2.a(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    public static final class b implements o.b {
        final /* synthetic */ Function1<String, String> a;

        public /* synthetic */ void P(androidx.compose.ui.semantics.x xVar) {
            o.a.a(this, xVar);
        }

        public /* synthetic */ w2 b() {
            return o.a.b(this);
        }

        /* JADX WARN: Multi-variable type inference failed */
        b(Function1<? super String, String> function1) {
            this.a = function1;
        }

        /* JADX WARN: Code restructure failed: missing block: B:6:0x003a, code lost:
        
            if (kotlin.jvm.internal.Intrinsics.areEqual(r0, r1) != false) goto L10;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void a(o.f r8) {
            /*
                r7 = this;
                java.lang.String r0 = "<this>"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
                java.lang.CharSequence r0 = r8.b()
                java.lang.String r0 = r0.toString()
                kotlin.jvm.functions.Function1<java.lang.String, java.lang.String> r1 = r7.a
                java.lang.Object r1 = r1.invoke(r0)
                java.lang.String r1 = (java.lang.String) r1
                boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r0)
                if (r2 != 0) goto L50
                long r2 = r8.e
                int r4 = r8.h()
                r5 = 0
                r8.k(r5, r4, r1)
                int r4 = androidx.compose.ui.text.e3.n(r2)
                r6 = 1
                if (r4 != r6) goto L3d
                java.lang.String r0 = r0.substring(r6)
                java.lang.String r4 = "substring(...)"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r4)
                boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
                if (r0 == 0) goto L3d
                goto L49
            L3d:
                int r0 = androidx.compose.ui.text.e3.n(r2)
                int r1 = r8.h()
                int r5 = kotlin.ranges.RangesKt.coerceIn(r0, r5, r1)
            L49:
                long r0 = androidx.compose.ui.text.f3.a(r5)
                r8.r(r0)
            L50:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.widget.BasicTextFieldWithPlaceHolder_androidKt.b.a(o.f):void");
        }
    }

    static final class a implements Function1<g0.b, Boolean> {
        public static final a a = new a();

        a() {
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(g0.b bVar) {
            return a(bVar.f());
        }

        public final Boolean a(KeyEvent keyEvent) {
            Intrinsics.checkNotNullParameter(keyEvent, "keyEvent");
            return Boolean.valueOf(g0.a.s(g0.d.a(keyEvent), g0.a.a.g()));
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ConstructorVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r12v7 ??, still in use, count: 1, list:
          (r12v7 ?? I:java.lang.Object) from 0x01e2: INVOKE (r14v0 ?? I:androidx.compose.runtime.Composer), (r12v7 ?? I:java.lang.Object) INTERFACE call: androidx.compose.runtime.Composer.updateRememberedValue(java.lang.Object):void (LINE:151519714)
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:162)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:127)
        	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:99)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:98)
        	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:73)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:59)
        	at jadx.core.dex.visitors.ConstructorVisitor.visit(ConstructorVisitor.java:42)
        */
    public static final void b(
    /*  JADX ERROR: JadxRuntimeException in pass: ConstructorVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r12v7 ??, still in use, count: 1, list:
          (r12v7 ?? I:java.lang.Object) from 0x01e2: INVOKE (r14v0 ?? I:androidx.compose.runtime.Composer), (r12v7 ?? I:java.lang.Object) INTERFACE call: androidx.compose.runtime.Composer.updateRememberedValue(java.lang.Object):void (LINE:151519714)
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:162)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:127)
        	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:99)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:98)
        	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:73)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:59)
        */
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r62v0 ??
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:238)
        	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:223)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:168)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
        */
}
