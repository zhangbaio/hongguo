package kotlinx.serialization.protobuf;

import com.bytedance.covode.number.Covode;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.annotation.AnnotationTarget;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.ExperimentalSerializationApi;

@Target({})
@ExperimentalSerializationApi
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.PROPERTY})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public @interface ProtoType {

    public /* synthetic */ class Impl implements ProtoType {
        private final /* synthetic */ ProtoIntegerType type;

        static {
            Covode.recordClassIndex(660116);
        }

        public Impl(ProtoIntegerType type) {
            Intrinsics.checkNotNullParameter(type, "type");
            this.type = type;
        }

        @Override // kotlinx.serialization.protobuf.ProtoType
        public final /* synthetic */ ProtoIntegerType type() {
            return this.type;
        }
    }

    ProtoIntegerType type();
}
