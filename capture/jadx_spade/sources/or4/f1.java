package or4;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.LogWrapper;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class f1 extends Migration {
    static {
        Covode.recordClassIndex(611864);
    }

    public f1() {
        super(48, 49);
    }

    public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        LogWrapper.i("数据库发生迁移操作：48-49", new Object[0]);
        supportSQLiteDatabase.execSQL("ALTER TABLE t_ugc_book_list ADD COLUMN author_name TEXT");
        supportSQLiteDatabase.execSQL("ALTER TABLE t_ugc_book_list ADD COLUMN author_abstract TEXT");
        supportSQLiteDatabase.execSQL("ALTER TABLE t_ugc_book_list ADD COLUMN author_pic_url TEXT");
        supportSQLiteDatabase.execSQL("ALTER TABLE t_ugc_book_list ADD COLUMN author_id INTEGER NOT NULL DEFAULT 0");
    }
}
