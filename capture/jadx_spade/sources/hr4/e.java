package hr4;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.LogHelper;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class e extends Migration {
    public static final a a;
    public static final int b;
    private static final LogHelper c;

    public static final class a {
        static {
            Covode.recordClassIndex(611500);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public e() {
        super(5, 6);
    }

    static {
        Covode.recordClassIndex(611499);
        a = new a(null);
        b = 8;
        c = new LogHelper("AdvertiseDataBase", 4);
    }

    public void migrate(SupportSQLiteDatabase database) {
        Intrinsics.checkNotNullParameter(database, "database");
        c.i("AdvertiseDataBase数据库做迁移工作:5to6", new Object[0]);
        database.execSQL("ALTER TABLE t_ad_download ADD COLUMN source TEXT");
        database.execSQL("ALTER TABLE t_ad_download ADD COLUMN unified_game_id TEXT");
        database.execSQL("ALTER TABLE t_ad_download ADD COLUMN download_info TEXT");
    }
}
