package or4;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.LogWrapper;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class z1 extends Migration {
    static {
        Covode.recordClassIndex(611884);
    }

    public z1() {
        super(68, 69);
    }

    public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        LogWrapper.i("数据库发生迁移操作：68-69", new Object[0]);
        supportSQLiteDatabase.execSQL("ALTER TABLE t_im_participant ADD COLUMN is_robot INTEGER NOT NULL DEFAULT 0");
    }
}
