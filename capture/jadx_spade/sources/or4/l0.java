package or4;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.LogWrapper;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class l0 extends Migration {
    static {
        Covode.recordClassIndex(611844);
    }

    public l0() {
        super(28, 29);
    }

    public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        LogWrapper.i("数据库发生迁移操作：28-29, path=%s,version=%s,", new Object[]{supportSQLiteDatabase.getPath(), Integer.valueOf(supportSQLiteDatabase.getVersion())});
        supportSQLiteDatabase.execSQL("ALTER TABLE t_ugc_book_list ADD COLUMN book_list_type INTEGER NOT NULL DEFAULT 1");
        supportSQLiteDatabase.execSQL("ALTER TABLE t_ugc_book_list ADD COLUMN user_info TEXT");
    }
}
