package kotlin.jvm.internal;

import com.bytedance.covode.number.Covode;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public abstract class Lambda<R> implements FunctionBase<R>, Serializable {
    private final int arity;

    static {
        Covode.recordClassIndex(658527);
    }

    @Override // kotlin.jvm.internal.FunctionBase
    public int getArity() {
        return this.arity;
    }

    public String toString() {
        String renderLambdaToString = Reflection.renderLambdaToString((Lambda) this);
        Intrinsics.checkNotNullExpressionValue(renderLambdaToString, "renderLambdaToString(...)");
        return renderLambdaToString;
    }

    public Lambda(int i) {
        this.arity = i;
    }
}
