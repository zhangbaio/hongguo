package nr4;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.covode.number.Covode;
import com.dragon.read.local.db.entity.AddShelfDialogControlModel;
import java.util.Collections;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class l4 implements j4 {
    private final RoomDatabase a;
    private final EntityInsertionAdapter<AddShelfDialogControlModel> b;

    static {
        Covode.recordClassIndex(611785);
    }

    public static List<Class<?>> c() {
        return Collections.emptyList();
    }

    public l4(RoomDatabase roomDatabase) {
        this.a = roomDatabase;
        this.b = new a(roomDatabase);
    }

    @Override // nr4.j4
    public void a(AddShelfDialogControlModel addShelfDialogControlModel) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.b.insert(addShelfDialogControlModel);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // nr4.j4
    public AddShelfDialogControlModel b(String str) {
        String string;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM shelf_control_model WHERE bookId = ?", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.a.assertNotSuspendingTransaction();
        AddShelfDialogControlModel addShelfDialogControlModel = null;
        String string2 = null;
        Cursor query = DBUtil.query(this.a, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "bookId");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "date_time");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "today_show_count");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "last_read_count");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "read_count");
            if (query.moveToFirst()) {
                AddShelfDialogControlModel addShelfDialogControlModel2 = new AddShelfDialogControlModel();
                if (query.isNull(columnIndexOrThrow)) {
                    string = null;
                } else {
                    string = query.getString(columnIndexOrThrow);
                }
                addShelfDialogControlModel2.setBookId(string);
                if (!query.isNull(columnIndexOrThrow2)) {
                    string2 = query.getString(columnIndexOrThrow2);
                }
                addShelfDialogControlModel2.setDateTime(string2);
                addShelfDialogControlModel2.setTodayShowCount(query.getInt(columnIndexOrThrow3));
                addShelfDialogControlModel2.setLastReadCount(query.getInt(columnIndexOrThrow4));
                addShelfDialogControlModel2.setReadCount(query.getInt(columnIndexOrThrow5));
                addShelfDialogControlModel = addShelfDialogControlModel2;
            }
            return addShelfDialogControlModel;
        } finally {
            query.close();
            acquire.release();
        }
    }

    class a extends EntityInsertionAdapter<AddShelfDialogControlModel> {
        public String createQuery() {
            return "INSERT OR REPLACE INTO `shelf_control_model` (`bookId`,`date_time`,`today_show_count`,`last_read_count`,`read_count`) VALUES (?,?,?,?,?)";
        }

        a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, AddShelfDialogControlModel addShelfDialogControlModel) {
            if (addShelfDialogControlModel.getBookId() == null) {
                supportSQLiteStatement.bindNull(1);
            } else {
                supportSQLiteStatement.bindString(1, addShelfDialogControlModel.getBookId());
            }
            if (addShelfDialogControlModel.getDateTime() == null) {
                supportSQLiteStatement.bindNull(2);
            } else {
                supportSQLiteStatement.bindString(2, addShelfDialogControlModel.getDateTime());
            }
            supportSQLiteStatement.bindLong(3, addShelfDialogControlModel.getTodayShowCount());
            supportSQLiteStatement.bindLong(4, addShelfDialogControlModel.getLastReadCount());
            supportSQLiteStatement.bindLong(5, addShelfDialogControlModel.getReadCount());
        }
    }
}
