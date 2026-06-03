package or4;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.LogWrapper;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class b0 extends Migration {
    static {
        Covode.recordClassIndex(611834);
    }

    public b0() {
        super(19, 20);
    }

    public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        LogWrapper.i("数据库发生迁移操作：19-20", new Object[0]);
        supportSQLiteDatabase.execSQL("ALTER TABLE t_book ADD COLUMN last_chapter_title TEXT");
        supportSQLiteDatabase.execSQL("ALTER TABLE t_book ADD COLUMN last_chapter_update_time TEXT");
    }
}
