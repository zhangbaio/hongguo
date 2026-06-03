package hr4;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.LogHelper;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class f extends Migration {
    public static final a a;
    public static final int b;
    private static final LogHelper c;

    public static final class a {
        static {
            Covode.recordClassIndex(611502);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public f() {
        super(6, 7);
    }

    static {
        Covode.recordClassIndex(611501);
        a = new a(null);
        b = 8;
        c = new LogHelper("AdvertiseDataBase", 4);
    }

    public void migrate(SupportSQLiteDatabase database) {
        Intrinsics.checkNotNullParameter(database, "database");
        c.i("AdvertiseDataBase数据库做迁移工作:6to7", new Object[0]);
        database.execSQL("DROP TABLE IF  EXISTS `TopViewEntity`");
    }
}
