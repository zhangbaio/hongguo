package or4;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.LogWrapper;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class a2 extends Migration {
    static {
        Covode.recordClassIndex(611885);
    }

    public a2() {
        super(69, 70);
    }

    public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        LogWrapper.i("数据库发生迁移操作：68-69", new Object[0]);
        supportSQLiteDatabase.execSQL("ALTER TABLE t_book ADD COLUMN op_tag TEXT");
        supportSQLiteDatabase.execSQL("ALTER TABLE t_video_serial_collection ADD COLUMN series_cnt INTEGER NOT NULL DEFAULT -1");
    }
}
