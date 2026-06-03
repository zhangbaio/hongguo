package en6;

import com.bytedance.covode.number.Covode;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.Unit;
import kotlin.g;
import kotlin.jvm.internal.BooleanCompanionObject;
import kotlin.jvm.internal.DoubleCompanionObject;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.l;
import kotlin.m;
import kotlin.o;
import kotlin.p;
import kotlin.reflect.KClass;
import kotlin.time.c;
import kotlin.uuid.Uuid;
import kotlinx.serialization.ExperimentalSerializationApi;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.internal.a0;
import kotlinx.serialization.internal.a1;
import kotlinx.serialization.internal.b0;
import kotlinx.serialization.internal.b3;
import kotlinx.serialization.internal.c0;
import kotlinx.serialization.internal.c1;
import kotlinx.serialization.internal.e3;
import kotlinx.serialization.internal.f;
import kotlinx.serialization.internal.f1;
import kotlinx.serialization.internal.f3;
import kotlinx.serialization.internal.g1;
import kotlinx.serialization.internal.h;
import kotlinx.serialization.internal.h3;
import kotlinx.serialization.internal.i;
import kotlinx.serialization.internal.i1;
import kotlinx.serialization.internal.i3;
import kotlinx.serialization.internal.k;
import kotlinx.serialization.internal.k0;
import kotlinx.serialization.internal.k3;
import kotlinx.serialization.internal.l0;
import kotlinx.serialization.internal.l3;
import kotlinx.serialization.internal.n3;
import kotlinx.serialization.internal.o2;
import kotlinx.serialization.internal.o3;
import kotlinx.serialization.internal.p3;
import kotlinx.serialization.internal.q;
import kotlinx.serialization.internal.q1;
import kotlinx.serialization.internal.q3;
import kotlinx.serialization.internal.r;
import kotlinx.serialization.internal.r1;
import kotlinx.serialization.internal.t2;
import kotlinx.serialization.internal.u0;
import kotlinx.serialization.internal.u2;
import kotlinx.serialization.internal.v0;
import kotlinx.serialization.internal.v2;
import kotlinx.serialization.internal.w1;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class a {
    static {
        Covode.recordClassIndex(659801);
    }

    public static final KSerializer<boolean[]> b() {
        return h.c;
    }

    public static final KSerializer<byte[]> c() {
        return k.c;
    }

    public static final KSerializer<char[]> d() {
        return q.c;
    }

    public static final KSerializer<double[]> e() {
        return a0.c;
    }

    public static final KSerializer<float[]> f() {
        return k0.c;
    }

    public static final KSerializer<int[]> g() {
        return u0.c;
    }

    public static final KSerializer<long[]> i() {
        return f1.c;
    }

    @ExperimentalSerializationApi
    public static final KSerializer l() {
        return q1.a;
    }

    public static final KSerializer<short[]> o() {
        return t2.c;
    }

    @ExperimentalSerializationApi
    public static final KSerializer<kotlin.h> q() {
        return e3.c;
    }

    @ExperimentalSerializationApi
    public static final KSerializer<l> r() {
        return h3.c;
    }

    @ExperimentalSerializationApi
    public static final KSerializer<m> s() {
        return k3.c;
    }

    @ExperimentalSerializationApi
    public static final KSerializer<p> t() {
        return n3.c;
    }

    public static final KSerializer<Boolean> A(BooleanCompanionObject booleanCompanionObject) {
        Intrinsics.checkNotNullParameter(booleanCompanionObject, "<this>");
        return i.a;
    }

    public static final KSerializer<Byte> B(kotlin.jvm.internal.k kVar) {
        Intrinsics.checkNotNullParameter(kVar, "<this>");
        return kotlinx.serialization.internal.l.a;
    }

    public static final KSerializer<Character> C(kotlin.jvm.internal.l lVar) {
        Intrinsics.checkNotNullParameter(lVar, "<this>");
        return r.a;
    }

    public static final KSerializer<Double> D(DoubleCompanionObject doubleCompanionObject) {
        Intrinsics.checkNotNullParameter(doubleCompanionObject, "<this>");
        return b0.a;
    }

    public static final KSerializer<Float> E(FloatCompanionObject floatCompanionObject) {
        Intrinsics.checkNotNullParameter(floatCompanionObject, "<this>");
        return l0.a;
    }

    public static final KSerializer<Integer> F(IntCompanionObject intCompanionObject) {
        Intrinsics.checkNotNullParameter(intCompanionObject, "<this>");
        return v0.a;
    }

    public static final KSerializer<Long> G(LongCompanionObject longCompanionObject) {
        Intrinsics.checkNotNullParameter(longCompanionObject, "<this>");
        return g1.a;
    }

    public static final KSerializer<Short> H(kotlin.jvm.internal.r rVar) {
        Intrinsics.checkNotNullParameter(rVar, "<this>");
        return u2.a;
    }

    public static final KSerializer<String> I(StringCompanionObject stringCompanionObject) {
        Intrinsics.checkNotNullParameter(stringCompanionObject, "<this>");
        return v2.a;
    }

    public static final KSerializer<c> J(c.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        return c0.a;
    }

    public static final KSerializer<Uuid> K(Uuid.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        return q3.a;
    }

    public static final KSerializer<g> v(g.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        return f3.a;
    }

    public static final KSerializer<UInt> w(UInt.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        return i3.a;
    }

    public static final KSerializer<ULong> x(ULong.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        return l3.a;
    }

    public static final KSerializer<o> y(o.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        return o3.a;
    }

    public static final KSerializer<Unit> z(Unit unit) {
        Intrinsics.checkNotNullParameter(unit, "<this>");
        return p3.b;
    }

    public static final <T> KSerializer<List<T>> h(KSerializer<T> elementSerializer) {
        Intrinsics.checkNotNullParameter(elementSerializer, "elementSerializer");
        return new f(elementSerializer);
    }

    public static final <T> KSerializer<Set<T>> n(KSerializer<T> elementSerializer) {
        Intrinsics.checkNotNullParameter(elementSerializer, "elementSerializer");
        return new c1(elementSerializer);
    }

    public static final <T> KSerializer<T> u(KSerializer<T> kSerializer) {
        Intrinsics.checkNotNullParameter(kSerializer, "<this>");
        if (!kSerializer.getDescriptor().isNullable()) {
            return new r1(kSerializer);
        }
        return kSerializer;
    }

    @ExperimentalSerializationApi
    public static final <T, E extends T> KSerializer<E[]> a(KClass<T> kClass, KSerializer<E> elementSerializer) {
        Intrinsics.checkNotNullParameter(kClass, "kClass");
        Intrinsics.checkNotNullParameter(elementSerializer, "elementSerializer");
        return new o2(kClass, elementSerializer);
    }

    public static final <K, V> KSerializer<Map.Entry<K, V>> j(KSerializer<K> keySerializer, KSerializer<V> valueSerializer) {
        Intrinsics.checkNotNullParameter(keySerializer, "keySerializer");
        Intrinsics.checkNotNullParameter(valueSerializer, "valueSerializer");
        return new i1(keySerializer, valueSerializer);
    }

    public static final <K, V> KSerializer<Map<K, V>> k(KSerializer<K> keySerializer, KSerializer<V> valueSerializer) {
        Intrinsics.checkNotNullParameter(keySerializer, "keySerializer");
        Intrinsics.checkNotNullParameter(valueSerializer, "valueSerializer");
        return new a1(keySerializer, valueSerializer);
    }

    public static final <K, V> KSerializer<Pair<K, V>> m(KSerializer<K> keySerializer, KSerializer<V> valueSerializer) {
        Intrinsics.checkNotNullParameter(keySerializer, "keySerializer");
        Intrinsics.checkNotNullParameter(valueSerializer, "valueSerializer");
        return new w1(keySerializer, valueSerializer);
    }

    public static final <A, B, C> KSerializer<Triple<A, B, C>> p(KSerializer<A> aSerializer, KSerializer<B> bSerializer, KSerializer<C> cSerializer) {
        Intrinsics.checkNotNullParameter(aSerializer, "aSerializer");
        Intrinsics.checkNotNullParameter(bSerializer, "bSerializer");
        Intrinsics.checkNotNullParameter(cSerializer, "cSerializer");
        return new b3(aSerializer, bSerializer, cSerializer);
    }
}
