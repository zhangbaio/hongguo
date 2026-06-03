package or4;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class c0 extends Migration {
    public static final int a;

    static {
        Covode.recordClassIndex(611835);
        a = 8;
    }

    public c0() {
        super(1, 2);
    }

    public void migrate(SupportSQLiteDatabase database) {
        Intrinsics.checkNotNullParameter(database, "database");
        database.execSQL("CREATE TABLE IF NOT EXISTS reader_book_progress ( book_id TEXT NOT NULL, chapter_id TEXT NOT NULL, chapter_index INTEGER NOT NULL, chapter_title TEXT NOT NULL, page_index INTEGER NOT NULL, pager_progress_rate REAL NOT NULL, paragraph_id INTEGER NOT NULL,line_in_paragraph_offset INTEGER NOT NULL, start_container_id INTEGER NOT NULL, start_element_index INTEGER NOT NULL, start_element_offset INTEGER NOT NULL, total_chapter_count_progress_rate REAL NOT NULL, ms_timestamp INTEGER NOT NULL, genre_type TEXT NOT NULL, chapter_recent_read_progress_rate TEXT NOT NULL, chapter_show_read_progress_rate TEXT NOT NULL, book_page_progress REAL NOT NULL, update_state INTEGER NOT NULL,PRIMARY KEY(book_id))");
        database.execSQL("CREATE TABLE IF NOT EXISTS reader_chapter_progress ( book_id TEXT NOT NULL, chapter_id TEXT NOT NULL, chapter_index INTEGER NOT NULL, chapter_title TEXT NOT NULL, page_index INTEGER NOT NULL, pager_progress_rate REAL NOT NULL, paragraph_id INTEGER NOT NULL, line_in_paragraph_offset INTEGER NOT NULL, start_container_id INTEGER NOT NULL, start_element_index INTEGER NOT NULL, start_element_offset INTEGER NOT NULL, total_chapter_count_progress_rate REAL NOT NULL, ms_timestamp INTEGER NOT NULL, genre_type TEXT NOT NULL, chapter_recent_read_progress_rate TEXT NOT NULL, chapter_show_read_progress_rate TEXT NOT NULL, book_page_progress REAL NOT NULL, update_state INTEGER NOT NULL,PRIMARY KEY(book_id, chapter_id))");
    }
}
