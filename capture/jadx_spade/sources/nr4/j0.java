package nr4;

import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.covode.number.Covode;
import java.util.Collections;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class j0 implements i0 {
    private final RoomDatabase a;
    private final EntityInsertionAdapter<lr4.j> b;
    private final EntityDeletionOrUpdateAdapter<lr4.j> c;

    static {
        Covode.recordClassIndex(611667);
    }

    public static List<Class<?>> a() {
        return Collections.emptyList();
    }

    public j0(RoomDatabase roomDatabase) {
        this.a = roomDatabase;
        this.b = new a(roomDatabase);
        this.c = new b(roomDatabase);
    }

    class a extends EntityInsertionAdapter<lr4.j> {
        public String createQuery() {
            return "INSERT OR REPLACE INTO `t_bookshelf_panel` (`book_id`,`book_type`,`add_book_time`,`listening_and_reading_time`) VALUES (?,?,?,?)";
        }

        a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, lr4.j jVar) {
            String str = jVar.a;
            if (str == null) {
                supportSQLiteStatement.bindNull(1);
            } else {
                supportSQLiteStatement.bindString(1, str);
            }
            if (kr4.b.a(jVar.b) == null) {
                supportSQLiteStatement.bindNull(2);
            } else {
                supportSQLiteStatement.bindLong(2, r0.intValue());
            }
            supportSQLiteStatement.bindLong(3, jVar.c);
            supportSQLiteStatement.bindLong(4, jVar.d);
        }
    }

    class b extends EntityDeletionOrUpdateAdapter<lr4.j> {
        public String createQuery() {
            return "DELETE FROM `t_bookshelf_panel` WHERE `book_id` = ? AND `book_type` = ?";
        }

        b(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, lr4.j jVar) {
            String str = jVar.a;
            if (str == null) {
                supportSQLiteStatement.bindNull(1);
            } else {
                supportSQLiteStatement.bindString(1, str);
            }
            if (kr4.b.a(jVar.b) == null) {
                supportSQLiteStatement.bindNull(2);
            } else {
                supportSQLiteStatement.bindLong(2, r5.intValue());
            }
        }
    }
}
