package zm6;

import bytedance.jvm.time.ZoneId;
import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;

@Serializable(with = cn6.k.class)
/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class g extends l {
    public static final a Companion;
    public final o c;

    static {
        Covode.recordClassIndex(659398);
        Companion = new a(null);
    }

    public static final class a {
        static {
            Covode.recordClassIndex(659399);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<g> serializer() {
            return cn6.k.a;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public g(o offset) {
        this(offset, offset.a);
        Intrinsics.checkNotNullParameter(offset, "offset");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(o offset, ZoneId zoneId) {
        super(zoneId);
        Intrinsics.checkNotNullParameter(offset, "offset");
        Intrinsics.checkNotNullParameter(zoneId, "zoneId");
        this.c = offset;
    }
}
