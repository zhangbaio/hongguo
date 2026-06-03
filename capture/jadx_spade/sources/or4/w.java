package or4;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.LogWrapper;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class w extends Migration {
    static {
        Covode.recordClassIndex(611829);
    }

    public w() {
        super(14, 15);
    }

    public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        LogWrapper.i("数据库发生迁移操作：14-15", new Object[0]);
        supportSQLiteDatabase.execSQL("ALTER TABLE t_book ADD COLUMN recommend_info TEXT");
        supportSQLiteDatabase.execSQL("ALTER TABLE t_book ADD COLUMN recommend_group_id TEXT");
    }
}
