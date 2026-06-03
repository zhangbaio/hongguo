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
public @interface ProtoOneOf {

    public /* synthetic */ class Impl implements ProtoOneOf {
        static {
            Covode.recordClassIndex(660112);
        }
    }
}
