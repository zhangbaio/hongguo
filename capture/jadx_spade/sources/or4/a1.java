package or4;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.LogWrapper;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class a1 extends Migration {
    static {
        Covode.recordClassIndex(611859);
    }

    public a1() {
        super(43, 44);
    }

    public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        LogWrapper.i("数据库发生迁移操作：43-44", new Object[0]);
        supportSQLiteDatabase.execSQL("ALTER TABLE t_book ADD COLUMN source TEXT DEFAULT ''");
        supportSQLiteDatabase.execSQL("ALTER TABLE t_book ADD COLUMN isEbook TEXT DEFAULT ''");
        supportSQLiteDatabase.execSQL("ALTER TABLE t_book ADD COLUMN audioThumbUri TEXT DEFAULT ''");
        supportSQLiteDatabase.execSQL("ALTER TABLE t_book ADD COLUMN tags TEXT DEFAULT ''");
        supportSQLiteDatabase.execSQL("ALTER TABLE t_book ADD COLUMN listenCount TEXT DEFAULT '0'");
    }
}
