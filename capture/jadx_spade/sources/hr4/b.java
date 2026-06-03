package hr4;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.LogHelper;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class b extends Migration {
    private static final LogHelper a;

    public b() {
        super(2, 3);
    }

    static {
        Covode.recordClassIndex(611496);
        a = new LogHelper("AdvertiseDataBase", 6);
    }

    public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        a.e("AdvertiseDataBase数据库做迁移工作:2to3", new Object[0]);
        supportSQLiteDatabase.execSQL("ALTER TABLE ChapterStrategyInfoEntity ADD COLUMN tipOptimizeFirst TEXT");
        supportSQLiteDatabase.execSQL("ALTER TABLE ChapterStrategyInfoEntity ADD COLUMN tipOptimizeSecond TEXT");
    }
}
