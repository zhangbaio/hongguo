package or4;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.LogWrapper;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class r0 extends Migration {
    static {
        Covode.recordClassIndex(611850);
    }

    public r0() {
        super(34, 35);
    }

    public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        LogWrapper.i("数据库发生迁移操作：34-35, path=%s,version=%s,", new Object[]{supportSQLiteDatabase.getPath(), Integer.valueOf(supportSQLiteDatabase.getVersion())});
        supportSQLiteDatabase.execSQL("ALTER TABLE t_book_record ADD COLUMN resource TEXT");
    }
}
