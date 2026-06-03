package dn6;

import com.bytedance.covode.number.Covode;
import kotlin.KotlinNothingValueException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.InternalSerializationApi;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.encoding.Encoder;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class f {
    static {
        Covode.recordClassIndex(659781);
    }

    @InternalSerializationApi
    public static final <T> DeserializationStrategy<T> a(kotlinx.serialization.internal.b<T> bVar, kotlinx.serialization.encoding.c decoder, String str) {
        Intrinsics.checkNotNullParameter(bVar, "<this>");
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        DeserializationStrategy<T> e = bVar.e(decoder, str);
        if (e != null) {
            return e;
        }
        kotlinx.serialization.internal.c.a(str, bVar.g());
        throw new KotlinNothingValueException();
    }

    @InternalSerializationApi
    public static final <T> SerializationStrategy<T> b(kotlinx.serialization.internal.b<T> bVar, Encoder encoder, T value) {
        Intrinsics.checkNotNullParameter(bVar, "<this>");
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerializationStrategy<T> f = bVar.f(encoder, value);
        if (f != null) {
            return f;
        }
        kotlinx.serialization.internal.c.b(Reflection.getOrCreateKotlinClass(value.getClass()), bVar.g());
        throw new KotlinNothingValueException();
    }
}
