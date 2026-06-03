package hr4;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.LogHelper;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class d extends Migration {
    private static final LogHelper a;

    public d() {
        super(4, 5);
    }

    static {
        Covode.recordClassIndex(611498);
        a = new LogHelper("AdvertiseDataBase", 4);
    }

    public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        a.i("AdvertiseDataBase数据库做迁移工作:4to5", new Object[0]);
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `TextLinkAdEntity` (`chapterId` TEXT NOT NULL,`word` TEXT NOT NULL,`wordIndex` INTEGER NOT NULL,`expiredTime` INTEGER NOT NULL,`textLinkAdInfo` TEXT, PRIMARY KEY(`chapterId`, `word`, `wordIndex`))");
    }
}
