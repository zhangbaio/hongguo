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
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import java.util.Collections;
import java.util.List;
import readersaas.com.dragon.read.saas.rpc.model.GenreTypeEnum;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class f2 implements e2 {
    private final RoomDatabase a;
    private final EntityInsertionAdapter<lr4.n0> b;

    static {
        Covode.recordClassIndex(611718);
    }

    public static List<Class<?>> d() {
        return Collections.emptyList();
    }

    static /* synthetic */ class b {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[GenreTypeEnum.values().length];
            a = iArr;
            try {
                iArr[GenreTypeEnum.NOVEL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[GenreTypeEnum.AUDIOBOOK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[GenreTypeEnum.AUDIO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[GenreTypeEnum.COMIC_GENRE_TYPE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[GenreTypeEnum.OTHER_GENRE_TYPE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[GenreTypeEnum.VIDEO_GENRE_TYPE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[GenreTypeEnum.MAGAZINE_GENRE_TYPE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[GenreTypeEnum.PUBLISH_GENRE_TYPE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[GenreTypeEnum.CONTE_GENRE_TYPE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[GenreTypeEnum.STORY_GENRE_TYPE.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[GenreTypeEnum.DIALOGUE_GENRE_TYPE.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                a[GenreTypeEnum.DOUYIN_VIDEO.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                a[GenreTypeEnum.PRODUCT_GENRE_TYPE.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                a[GenreTypeEnum.NOVEL_STORY_GENRE_TYPE.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                a[GenreTypeEnum.CP_SHORT_PLAY_GENRE_TYPE.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                a[GenreTypeEnum.ANCIENTBOOK_GENRE_TYPE.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                a[GenreTypeEnum.UNCOPYRIGHTED_PUBLISH_GENRE_TYPE.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                a[GenreTypeEnum.STORY_ALBUM_GENRE_TYPE.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
        }
    }

    public f2(RoomDatabase roomDatabase) {
        this.a = roomDatabase;
        this.b = new a(roomDatabase);
    }

    @Override // nr4.e2
    public void insert(lr4.n0 n0Var) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.b.insert(n0Var);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(GenreTypeEnum genreTypeEnum) {
        if (genreTypeEnum == null) {
            return null;
        }
        switch (b.a[genreTypeEnum.ordinal()]) {
            case 1:
                return "NOVEL";
            case 2:
                return "AUDIOBOOK";
            case 3:
                return "AUDIO";
            case 4:
                return "COMIC_GENRE_TYPE";
            case 5:
                return "OTHER_GENRE_TYPE";
            case ConstantsAPI.COMMAND_LAUNCH_BY_WX /* 6 */:
                return "VIDEO_GENRE_TYPE";
            case 7:
                return "MAGAZINE_GENRE_TYPE";
            case ConstantsAPI.COMMAND_JUMP_BIZ_WEBVIEW /* 8 */:
                return "PUBLISH_GENRE_TYPE";
            case 9:
                return "CONTE_GENRE_TYPE";
            case 10:
                return "STORY_GENRE_TYPE";
            case 11:
                return "DIALOGUE_GENRE_TYPE";
            case ConstantsAPI.COMMAND_OPEN_WEBVIEW /* 12 */:
                return "DOUYIN_VIDEO";
            case ConstantsAPI.COMMAND_OPEN_BUSI_LUCKY_MONEY /* 13 */:
                return "PRODUCT_GENRE_TYPE";
            case 14:
                return "NOVEL_STORY_GENRE_TYPE";
            case 15:
                return "CP_SHORT_PLAY_GENRE_TYPE";
            case 16:
                return "ANCIENTBOOK_GENRE_TYPE";
            case ConstantsAPI.COMMAND_HANDLE_SCAN_RESULT /* 17 */:
                return "UNCOPYRIGHTED_PUBLISH_GENRE_TYPE";
            case 18:
                return "STORY_ALBUM_GENRE_TYPE";
            default:
                throw new IllegalArgumentException("Can't convert enum to string, unknown enum value: " + genreTypeEnum);
        }
    }

    private GenreTypeEnum b(String str) {
        if (str == null) {
            return null;
        }
        switch (str) {
            case "ANCIENTBOOK_GENRE_TYPE":
                return GenreTypeEnum.ANCIENTBOOK_GENRE_TYPE;
            case "AUDIOBOOK":
                return GenreTypeEnum.AUDIOBOOK;
            case "PRODUCT_GENRE_TYPE":
                return GenreTypeEnum.PRODUCT_GENRE_TYPE;
            case "COMIC_GENRE_TYPE":
                return GenreTypeEnum.COMIC_GENRE_TYPE;
            case "DIALOGUE_GENRE_TYPE":
                return GenreTypeEnum.DIALOGUE_GENRE_TYPE;
            case "NOVEL_STORY_GENRE_TYPE":
                return GenreTypeEnum.NOVEL_STORY_GENRE_TYPE;
            case "CONTE_GENRE_TYPE":
                return GenreTypeEnum.CONTE_GENRE_TYPE;
            case "PUBLISH_GENRE_TYPE":
                return GenreTypeEnum.PUBLISH_GENRE_TYPE;
            case "AUDIO":
                return GenreTypeEnum.AUDIO;
            case "NOVEL":
                return GenreTypeEnum.NOVEL;
            case "DOUYIN_VIDEO":
                return GenreTypeEnum.DOUYIN_VIDEO;
            case "VIDEO_GENRE_TYPE":
                return GenreTypeEnum.VIDEO_GENRE_TYPE;
            case "STORY_ALBUM_GENRE_TYPE":
                return GenreTypeEnum.STORY_ALBUM_GENRE_TYPE;
            case "UNCOPYRIGHTED_PUBLISH_GENRE_TYPE":
                return GenreTypeEnum.UNCOPYRIGHTED_PUBLISH_GENRE_TYPE;
            case "MAGAZINE_GENRE_TYPE":
                return GenreTypeEnum.MAGAZINE_GENRE_TYPE;
            case "CP_SHORT_PLAY_GENRE_TYPE":
                return GenreTypeEnum.CP_SHORT_PLAY_GENRE_TYPE;
            case "OTHER_GENRE_TYPE":
                return GenreTypeEnum.OTHER_GENRE_TYPE;
            case "STORY_GENRE_TYPE":
                return GenreTypeEnum.STORY_GENRE_TYPE;
            default:
                throw new IllegalArgumentException("Can't convert value to enum, unknown value: " + str);
        }
    }

    @Override // nr4.e2
    public lr4.n0 query(String str) {
        RoomSQLiteQuery roomSQLiteQuery;
        lr4.n0 n0Var;
        String string;
        String string2;
        String string3;
        String string4;
        String string5;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM reader_book_progress WHERE book_id = ?", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.a, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "book_id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "chapter_id");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "chapter_index");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "chapter_title");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "page_index");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "pager_progress_rate");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "paragraph_id");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "line_in_paragraph_offset");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "start_container_id");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "start_element_index");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "start_element_offset");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "total_chapter_count_progress_rate");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "ms_timestamp");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "genre_type");
                try {
                    int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "chapter_recent_read_progress_rate");
                    int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "chapter_show_read_progress_rate");
                    int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "book_page_progress");
                    int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "update_state");
                    if (query.moveToFirst()) {
                        lr4.n0 n0Var2 = new lr4.n0();
                        if (query.isNull(columnIndexOrThrow)) {
                            string = null;
                        } else {
                            string = query.getString(columnIndexOrThrow);
                        }
                        n0Var2.c(string);
                        if (query.isNull(columnIndexOrThrow2)) {
                            string2 = null;
                        } else {
                            string2 = query.getString(columnIndexOrThrow2);
                        }
                        n0Var2.d(string2);
                        ((h45.n) n0Var2).c = query.getInt(columnIndexOrThrow3);
                        if (query.isNull(columnIndexOrThrow4)) {
                            string3 = null;
                        } else {
                            string3 = query.getString(columnIndexOrThrow4);
                        }
                        n0Var2.g(string3);
                        ((h45.n) n0Var2).e = query.getInt(columnIndexOrThrow5);
                        ((h45.n) n0Var2).f = query.getFloat(columnIndexOrThrow6);
                        ((h45.n) n0Var2).g = query.getInt(columnIndexOrThrow7);
                        ((h45.n) n0Var2).h = query.getInt(columnIndexOrThrow8);
                        ((h45.n) n0Var2).i = query.getInt(columnIndexOrThrow9);
                        ((h45.n) n0Var2).j = query.getInt(columnIndexOrThrow10);
                        ((h45.n) n0Var2).k = query.getInt(columnIndexOrThrow11);
                        ((h45.n) n0Var2).l = query.getFloat(columnIndexOrThrow12);
                        ((h45.n) n0Var2).m = query.getLong(columnIndexOrThrow13);
                        try {
                            n0Var2.h(b(query.getString(columnIndexOrThrow14)));
                            if (query.isNull(columnIndexOrThrow15)) {
                                string4 = null;
                            } else {
                                string4 = query.getString(columnIndexOrThrow15);
                            }
                            n0Var2.e(string4);
                            if (query.isNull(columnIndexOrThrow16)) {
                                string5 = null;
                            } else {
                                string5 = query.getString(columnIndexOrThrow16);
                            }
                            n0Var2.f(string5);
                            ((h45.n) n0Var2).q = query.getDouble(columnIndexOrThrow17);
                            ((h45.n) n0Var2).r = query.getInt(columnIndexOrThrow18);
                            n0Var = n0Var2;
                        } catch (Throwable th) {
                            th = th;
                            query.close();
                            roomSQLiteQuery.release();
                            throw th;
                        }
                    } else {
                        n0Var = null;
                    }
                    query.close();
                    roomSQLiteQuery.release();
                    return n0Var;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                query.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            roomSQLiteQuery = acquire;
        }
    }

    class a extends EntityInsertionAdapter<lr4.n0> {
        public String createQuery() {
            return "INSERT OR REPLACE INTO `reader_book_progress` (`book_id`,`chapter_id`,`chapter_index`,`chapter_title`,`page_index`,`pager_progress_rate`,`paragraph_id`,`line_in_paragraph_offset`,`start_container_id`,`start_element_index`,`start_element_offset`,`total_chapter_count_progress_rate`,`ms_timestamp`,`genre_type`,`chapter_recent_read_progress_rate`,`chapter_show_read_progress_rate`,`book_page_progress`,`update_state`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }

        a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, lr4.n0 n0Var) {
            String str = ((h45.n) n0Var).a;
            if (str == null) {
                supportSQLiteStatement.bindNull(1);
            } else {
                supportSQLiteStatement.bindString(1, str);
            }
            String str2 = ((h45.n) n0Var).b;
            if (str2 == null) {
                supportSQLiteStatement.bindNull(2);
            } else {
                supportSQLiteStatement.bindString(2, str2);
            }
            supportSQLiteStatement.bindLong(3, ((h45.n) n0Var).c);
            String str3 = ((h45.n) n0Var).d;
            if (str3 == null) {
                supportSQLiteStatement.bindNull(4);
            } else {
                supportSQLiteStatement.bindString(4, str3);
            }
            supportSQLiteStatement.bindLong(5, ((h45.n) n0Var).e);
            supportSQLiteStatement.bindDouble(6, ((h45.n) n0Var).f);
            supportSQLiteStatement.bindLong(7, ((h45.n) n0Var).g);
            supportSQLiteStatement.bindLong(8, ((h45.n) n0Var).h);
            supportSQLiteStatement.bindLong(9, ((h45.n) n0Var).i);
            supportSQLiteStatement.bindLong(10, ((h45.n) n0Var).j);
            supportSQLiteStatement.bindLong(11, ((h45.n) n0Var).k);
            supportSQLiteStatement.bindDouble(12, ((h45.n) n0Var).l);
            supportSQLiteStatement.bindLong(13, ((h45.n) n0Var).m);
            GenreTypeEnum genreTypeEnum = ((h45.n) n0Var).n;
            if (genreTypeEnum == null) {
                supportSQLiteStatement.bindNull(14);
            } else {
                supportSQLiteStatement.bindString(14, f2.this.a(genreTypeEnum));
            }
            String str4 = ((h45.n) n0Var).o;
            if (str4 == null) {
                supportSQLiteStatement.bindNull(15);
            } else {
                supportSQLiteStatement.bindString(15, str4);
            }
            String str5 = ((h45.n) n0Var).p;
            if (str5 == null) {
                supportSQLiteStatement.bindNull(16);
            } else {
                supportSQLiteStatement.bindString(16, str5);
            }
            supportSQLiteStatement.bindDouble(17, ((h45.n) n0Var).q);
            supportSQLiteStatement.bindLong(18, ((h45.n) n0Var).r);
        }
    }
}
