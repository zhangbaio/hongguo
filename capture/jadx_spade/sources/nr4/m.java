package nr4;

import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.covode.number.Covode;
import java.util.Collections;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class m implements k {
    private final RoomDatabase a;
    private final EntityInsertionAdapter<lr4.e> b;

    static {
        Covode.recordClassIndex(611643);
    }

    public static List<Class<?>> a() {
        return Collections.emptyList();
    }

    public m(RoomDatabase roomDatabase) {
        this.a = roomDatabase;
        this.b = new a(roomDatabase);
    }

    class a extends EntityInsertionAdapter<lr4.e> {
        public String createQuery() {
            return "INSERT OR REPLACE INTO `t_book_chapter_progress` (`book_id`,`chapter_id`,`para_id`,`para_offset`,`start_container_id`,`start_element_index`,`start_element_offset`) VALUES (?,?,?,?,?,?,?)";
        }

        a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, lr4.e eVar) {
            String str = eVar.a;
            if (str == null) {
                supportSQLiteStatement.bindNull(1);
            } else {
                supportSQLiteStatement.bindString(1, str);
            }
            String str2 = eVar.b;
            if (str2 == null) {
                supportSQLiteStatement.bindNull(2);
            } else {
                supportSQLiteStatement.bindString(2, str2);
            }
            supportSQLiteStatement.bindLong(3, eVar.c);
            supportSQLiteStatement.bindLong(4, eVar.d);
            supportSQLiteStatement.bindLong(5, eVar.e);
            supportSQLiteStatement.bindLong(6, eVar.f);
            supportSQLiteStatement.bindLong(7, eVar.g);
        }
    }
}
