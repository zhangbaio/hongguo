package or4;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.LogWrapper;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class o1 extends Migration {
    static {
        Covode.recordClassIndex(611873);
    }

    public o1() {
        super(57, 58);
    }

    public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        LogWrapper.i("数据库发生迁移操作：57-58", new Object[0]);
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS t_im_participant (`conversation_id` TEXT NOT NULL, `user_id` TEXT NOT NULL, `name` TEXT, `avatar_uri` TEXT, `role` INTERGER, `description` TEXT, `update_time` INTEGER NOT NULL DEFAULT 0, `create_time` INTEGER NOT NULL DEFAULT 0, PRIMARY KEY(`conversation_id`, `user_id`))");
    }
}
