package sm4;

import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.reader.ui.menu.model.ReaderCatalogType;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class e extends sm4.a {
    public static final a e;
    public static final int f;
    public final ReaderCatalogType d;

    static {
        Covode.recordClassIndex(608609);
        e = new a(null);
        f = 8;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static final class a {
        static {
            Covode.recordClassIndex(608610);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final e a() {
            return new e(ReaderCatalogType.CATALOG);
        }

        public final e b() {
            return new e(ReaderCatalogType.COMMENT);
        }

        public final e c() {
            return new e(ReaderCatalogType.DETAIL);
        }

        public final e d() {
            return new e(ReaderCatalogType.NOTE);
        }

        public final e e() {
            return new e(ReaderCatalogType.SEARCH);
        }
    }

    public e(ReaderCatalogType readerCatalogType) {
        this.d = readerCatalogType;
    }

    public /* synthetic */ e(ReaderCatalogType readerCatalogType, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : readerCatalogType);
    }
}
