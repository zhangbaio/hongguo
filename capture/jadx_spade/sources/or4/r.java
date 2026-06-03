package or4;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.LogWrapper;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class r extends Migration {
    public static final int a;

    static {
        Covode.recordClassIndex(611824);
        a = 8;
    }

    public r() {
        super(116, 117);
    }

    public void migrate(SupportSQLiteDatabase database) {
        Intrinsics.checkNotNullParameter(database, "database");
        LogWrapper.info("Migration116To117", "数据库发生迁移操作：116-117，path=" + database.getPath() + ", version=" + database.getVersion(), new Object[0]);
        database.execSQL("CREATE TABLE IF NOT EXISTS t_relative_pdf_epub (`pdf_book_id` TEXT NOT NULL DEFAULT '',`epub_book_id` TEXT NOT NULL DEFAULT '', PRIMARY KEY(`pdf_book_id`,`epub_book_id`))");
    }
}
