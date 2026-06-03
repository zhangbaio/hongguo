package hr4;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.LogHelper;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class c extends Migration {
    private static final LogHelper a;

    public c() {
        super(3, 4);
    }

    static {
        Covode.recordClassIndex(611497);
        a = new LogHelper("AdvertiseDataBase", 6);
    }

    public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        a.e("AdvertiseDataBase数据库做迁移工作:3to4", new Object[0]);
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `TopViewEntity` (`id` INTEGER NOT NULL,`adModel` TEXT, PRIMARY KEY(`id`))");
    }
}
