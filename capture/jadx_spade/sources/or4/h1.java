package or4;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.LogWrapper;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class h1 extends Migration {
    static {
        Covode.recordClassIndex(611866);
    }

    public h1() {
        super(50, 51);
    }

    public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        LogWrapper.i("数据库发生迁移操作：50-51", new Object[0]);
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `t_comic_read_progress_record` (`comic_id` TEXT NOT NULL,`chapter_id` TEXT NOT NULL,PRIMARY KEY(`comic_id`, `chapter_id`))");
    }
}
