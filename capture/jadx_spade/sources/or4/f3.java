package or4;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.LogWrapper;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class f3 extends Migration {
    static {
        Covode.recordClassIndex(611916);
    }

    public f3() {
        super(9, 10);
    }

    public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        LogWrapper.i("数据库发生迁移操作：9-10", new Object[0]);
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS t_cache_table (`cache_key` TEXT NOT NULL, `cache_value` TEXT, `create_time` INTEGER NOT NULL, `update_time` INTEGER NOT NULL, PRIMARY KEY(`cache_key`))");
    }
}
