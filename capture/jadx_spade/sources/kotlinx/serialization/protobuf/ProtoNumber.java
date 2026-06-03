package kotlinx.serialization.protobuf;

import com.bytedance.covode.number.Covode;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.annotation.AnnotationTarget;
import kotlinx.serialization.ExperimentalSerializationApi;

@Target({})
@ExperimentalSerializationApi
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.PROPERTY})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public @interface ProtoNumber {

    public /* synthetic */ class Impl implements ProtoNumber {
        private final /* synthetic */ int number;

        static {
            Covode.recordClassIndex(660110);
        }

        public Impl(int i) {
            this.number = i;
        }

        @Override // kotlinx.serialization.protobuf.ProtoNumber
        public final /* synthetic */ int number() {
            return this.number;
        }
    }

    int number();
}
