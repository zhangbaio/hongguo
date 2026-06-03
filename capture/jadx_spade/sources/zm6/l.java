package zm6;

import bytedance.jvm.time.DateTimeException;
import bytedance.jvm.time.ZoneId;
import bytedance.jvm.time.ZoneOffset;
import cn6.v;
import com.bytedance.covode.number.Covode;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.IllegalTimeZoneException;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;

@Serializable(with = v.class)
/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class l {
    public static final a Companion;
    private static final g b;
    public final ZoneId a;

    public static final class a {
        static {
            Covode.recordClassIndex(659423);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<l> serializer() {
            return v.a;
        }

        public final l a() {
            ZoneId systemDefault = ZoneId.systemDefault();
            Intrinsics.checkNotNullExpressionValue(systemDefault, "systemDefault(...)");
            return d(systemDefault);
        }

        public final Set<String> b() {
            Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
            Intrinsics.checkNotNullExpressionValue(availableZoneIds, "getAvailableZoneIds(...)");
            return availableZoneIds;
        }

        public final l c(String zoneId) {
            Intrinsics.checkNotNullParameter(zoneId, "zoneId");
            try {
                ZoneId of = ZoneId.of(zoneId);
                Intrinsics.checkNotNullExpressionValue(of, "of(...)");
                return d(of);
            } catch (Exception e) {
                if (e instanceof DateTimeException) {
                    throw new IllegalTimeZoneException(e);
                }
                throw e;
            }
        }

        public final l d(ZoneId zoneId) {
            boolean c;
            Intrinsics.checkNotNullParameter(zoneId, "zoneId");
            if (!(zoneId instanceof ZoneOffset)) {
                c = n.c(zoneId);
                if (c) {
                    ZoneOffset normalized = zoneId.normalized();
                    Intrinsics.checkNotNull(normalized, "null cannot be cast to non-null type bytedance.jvm.time.ZoneOffset");
                    return new g(new o(normalized), zoneId);
                }
                return new l(zoneId);
            }
            return new g(new o((ZoneOffset) zoneId));
        }
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public final String a() {
        String id = this.a.getId();
        Intrinsics.checkNotNullExpressionValue(id, "getId(...)");
        return id;
    }

    public String toString() {
        String zoneId = this.a.toString();
        Intrinsics.checkNotNullExpressionValue(zoneId, "toString(...)");
        return zoneId;
    }

    static {
        Covode.recordClassIndex(659422);
        Companion = new a(null);
        ZoneOffset UTC = ZoneOffset.UTC;
        Intrinsics.checkNotNullExpressionValue(UTC, "UTC");
        b = u.a(new o(UTC));
    }

    public l(ZoneId zoneId) {
        Intrinsics.checkNotNullParameter(zoneId, "zoneId");
        this.a = zoneId;
    }

    public boolean equals(Object obj) {
        if (this != obj && (!(obj instanceof l) || !Intrinsics.areEqual(this.a, ((l) obj).a))) {
            return false;
        }
        return true;
    }
}
