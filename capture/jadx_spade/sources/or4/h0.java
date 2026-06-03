package or4;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.LogWrapper;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class h0 extends Migration {
    static {
        Covode.recordClassIndex(611840);
    }

    public h0() {
        super(24, 25);
    }

    public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        LogWrapper.i("数据库发生迁移操作：24-25", new Object[0]);
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS t_user_info (`uid` TEXT NOT NULL, `nick_name` TEXT NOT NULL, `avatar_url` TEXT NOT NULL, PRIMARY KEY(`uid`))");
    }
}
