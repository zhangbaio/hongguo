package hr4;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.LogHelper;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class a extends Migration {
    private static final LogHelper a;

    public a() {
        super(1, 2);
    }

    static {
        Covode.recordClassIndex(611495);
        a = new LogHelper("AdvertiseDataBase", 6);
    }

    public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        a.e("AdvertiseDataBase数据库做迁移工作:1to2", new Object[0]);
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `ChapterPageAdEntity` (`chapterId` TEXT NOT NULL,`chapterPageIndex` INTEGER NOT NULL,`adModel` TEXT,`expiredTime` INTEGER NOT NULL, PRIMARY KEY(`chapterId`, `chapterPageIndex`))");
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `ChapterStrategyInfoEntity` (`chapterId` TEXT NOT NULL,`strategyIndex` INTEGER NOT NULL,`showAd` INTEGER NOT NULL,`hasAtAdReturn` INTEGER NOT NULL,`rangeInfoList` TEXT ,`chapterIndex` INTEGER NOT NULL,`strategyChapterIndex` INTEGER NOT NULL,`expiredTime` INTEGER NOT NULL,`tip` TEXT , PRIMARY KEY(`chapterId`))");
    }
}
