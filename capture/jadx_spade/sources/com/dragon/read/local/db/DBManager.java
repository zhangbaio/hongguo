package com.dragon.read.local.db;

import android.util.Log;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.bytedance.covode.number.Covode;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.dragon.read.base.util.JSONUtils;
import com.dragon.read.base.util.ListUtils;
import com.dragon.read.base.util.LogWrapper;
import com.dragon.read.local.db.entity.Book;
import com.dragon.read.local.db.interfaces.IIMParticipantDao;
import com.dragon.read.local.db.pojo.BookModel;
import com.dragon.read.pages.bookshelf.model.BookType;
import com.google.gson.reflect.TypeToken;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import lr4.d1;
import nr4.a0;
import nr4.a4;
import nr4.b1;
import nr4.b3;
import nr4.b5;
import nr4.c0;
import nr4.c1;
import nr4.c3;
import nr4.c5;
import nr4.d0;
import nr4.d4;
import nr4.e1;
import nr4.e5;
import nr4.f0;
import nr4.f1;
import nr4.g0;
import nr4.g4;
import nr4.g5;
import nr4.h1;
import nr4.i0;
import nr4.i1;
import nr4.j4;
import nr4.k0;
import nr4.k1;
import nr4.k4;
import nr4.l0;
import nr4.l1;
import nr4.m4;
import nr4.n1;
import nr4.n4;
import nr4.o3;
import nr4.p1;
import nr4.p3;
import nr4.p4;
import nr4.q;
import nr4.q1;
import nr4.q4;
import nr4.r;
import nr4.r3;
import nr4.s1;
import nr4.s3;
import nr4.s4;
import nr4.t;
import nr4.t1;
import nr4.t4;
import nr4.u;
import nr4.v0;
import nr4.v1;
import nr4.v4;
import nr4.w;
import nr4.w0;
import nr4.w1;
import nr4.w4;
import nr4.x;
import nr4.x3;
import nr4.y0;
import nr4.y1;
import nr4.y2;
import nr4.y3;
import nr4.y4;
import nr4.z;
import nr4.z0;
import nr4.z1;
import nr4.z2;
import nr4.z4;
import or4.a1;
import or4.a2;
import or4.a3;
import or4.b0;
import or4.b2;
import or4.c2;
import or4.d2;
import or4.d3;
import or4.e0;
import or4.e2;
import or4.e3;
import or4.f2;
import or4.f3;
import or4.g1;
import or4.g2;
import or4.h0;
import or4.h2;
import or4.i2;
import or4.j0;
import or4.j1;
import or4.j2;
import or4.k2;
import or4.l2;
import or4.m0;
import or4.m1;
import or4.m2;
import or4.n0;
import or4.n2;
import or4.o0;
import or4.o1;
import or4.o2;
import or4.p0;
import or4.p2;
import or4.q0;
import or4.q2;
import or4.r0;
import or4.r1;
import or4.r2;
import or4.s;
import or4.s0;
import or4.s2;
import or4.t0;
import or4.t2;
import or4.u0;
import or4.u1;
import or4.u2;
import or4.v;
import or4.v2;
import or4.w2;
import or4.x0;
import or4.x1;
import or4.x2;
import or4.y;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public abstract class DBManager extends AbsRoomDatabase {
    static {
        Covode.recordClassIndex(611518);
    }

    abstract nr4.a audioBookshelfGuideDao();

    abstract nr4.d audioDlResultDao();

    abstract nr4.g audioDlStatusDao();

    abstract nr4.k bookChapterProgressDao();

    abstract x3 bookCommentSearchRecordDao();

    abstract nr4.n bookContentDao();

    abstract q bookDao();

    abstract f0 bookMarkDao();

    public abstract d4 bookShelfSearchRecordDao();

    abstract t booklistDao();

    abstract c0 bookmarkCacheDao();

    abstract i0 bookshelfPanelDao();

    abstract k0 cacheDao();

    abstract y0 comicReadProgressRecordDao();

    abstract v0 comicRecordDao();

    public abstract a4 commonSearchRecordDao();

    abstract b1 dialogueProgressDao();

    abstract e1 dialogueRecordDao();

    abstract h1 downloadBookDao();

    abstract k1 forumSessionDataDao();

    abstract IIMParticipantDao imParticipantDao();

    abstract p1 interactiveRecordDao();

    abstract s1 localBookBookmarkDao();

    abstract g localBookUnderlineDao();

    abstract v1 localBookshelfDao();

    abstract y1 noteBookDataDao();

    abstract w progressDao();

    abstract y2 readingRecordDao();

    abstract b3 readingTimeDao();

    abstract z recordDao();

    abstract o3 relativeBookDao();

    abstract r3 relativePDFEpubDao();

    abstract j4 shelfControlModelDao();

    abstract m4 taskCommentPublishRecordDao();

    public abstract g4 topicSearchRecordDao();

    abstract p4 ugcBookListDao();

    abstract s4 ugcVideoListDataDao();

    abstract j underlineLocalDao();

    abstract m underlineRemoteDao();

    abstract v4 userInfoDao();

    abstract e5 videoLikeDao();

    abstract y4 videoRecordDao();

    abstract b5 videoSeriesProgressDao();

    class b extends TypeToken<Set<String>> {
        b() {
        }
    }

    static void a() {
        obtainManager("").clearAllTables();
    }

    public static nr4.k obtainBookChapterProgressDao() {
        return new nr4.l(obtainManager("0").bookChapterProgressDao());
    }

    public static s1 obtainLocalBookBookmarkDao() {
        return new t1(obtainManager("0").localBookBookmarkDao());
    }

    public static g obtainLocalBookUnderlineDao() {
        return new h(obtainManager("0").localBookUnderlineDao());
    }

    public static v1 obtainLocalBookshelfDao() {
        return new w1(obtainManager("0").localBookshelfDao());
    }

    public static b3 obtainReadingTimeDao() {
        return new c3(obtainManager("0").readingTimeDao());
    }

    public static j4 obtainShelfControlDao() {
        return new k4(obtainManager("0").shelfControlModelDao());
    }

    public static v4 obtainUserInfo() {
        return new w4(obtainManager("0").userInfoDao());
    }

    class a extends RoomDatabase.Callback {
        a() {
        }

        public void onCreate(SupportSQLiteDatabase supportSQLiteDatabase) {
            super.onCreate(supportSQLiteDatabase);
            LogWrapper.info("数据库-DBManager", "database create. path=%s", new Object[]{a(supportSQLiteDatabase.getPath())});
        }

        public void onOpen(SupportSQLiteDatabase supportSQLiteDatabase) {
            super.onOpen(supportSQLiteDatabase);
            LogWrapper.info("数据库-DBManager", "database open. path=%s", new Object[]{a(supportSQLiteDatabase.getPath())});
        }

        private String a(String str) {
            long j;
            try {
                j = new PolarisFileWrapper(str).length();
            } catch (Exception e) {
                LogWrapper.info("数据库-DBManager", "获取大小异常 path=%s,e=%s", new Object[]{str, e});
                j = -1;
            }
            return str + "[" + j + "]";
        }

        public void onDestructiveMigration(SupportSQLiteDatabase supportSQLiteDatabase) {
            super.onDestructiveMigration(supportSQLiteDatabase);
            LogWrapper.warn("数据库-DBManager", "recreate all tables. path=%s, error=%s", new Object[]{a(supportSQLiteDatabase.getPath()), Log.getStackTraceString(new Exception("destructive migration"))});
        }
    }

    public static nr4.a obtainAudioBookshelfGuideDao(String str) {
        return new nr4.b(obtainManager(str).audioBookshelfGuideDao());
    }

    public static nr4.d obtainAudioDlResultDao(String str) {
        return new nr4.e(obtainManager(str).audioDlResultDao());
    }

    public static nr4.g obtainAudioDlStatusDao(String str) {
        return new nr4.h(obtainManager(str).audioDlStatusDao());
    }

    public static x3 obtainBookCommentSearchDao(String str) {
        return new y3(obtainManager(str).bookCommentSearchRecordDao());
    }

    public static nr4.n obtainBookContentDao(String str) {
        return new nr4.o(obtainManager(str).bookContentDao());
    }

    public static t obtainBookGroupDao(String str) {
        return new u(obtainManager(str).booklistDao());
    }

    public static c0 obtainBookMarkCacheDao(String str) {
        return new d0(obtainManager(str).bookmarkCacheDao());
    }

    public static f0 obtainBookMarkDao(String str) {
        return new g0(obtainManager(str).bookMarkDao());
    }

    public static k0 obtainCacheDao(String str) {
        return new l0(obtainManager(str).cacheDao());
    }

    public static v0 obtainComicDataDao(String str) {
        return new w0(obtainManager(str).comicRecordDao());
    }

    public static y0 obtainComicReadProgressRecordDao(String str) {
        return new z0(obtainManager(str).comicReadProgressRecordDao());
    }

    public static b1 obtainDialogueProgressDao(String str) {
        return new c1(obtainManager(str).dialogueProgressDao());
    }

    public static e1 obtainDialogueRecordDao(String str) {
        return new f1(obtainManager(str).dialogueRecordDao());
    }

    public static h1 obtainDownloadBook(String str) {
        return new i1(obtainManager(str).downloadBookDao());
    }

    public static k1 obtainForumSessionDao(String str) {
        return new l1(obtainManager(str).forumSessionDataDao());
    }

    public static IIMParticipantDao obtainIMParticipantDao(String str) {
        return new n1(obtainManager(str).imParticipantDao());
    }

    public static p1 obtainInteractiveRecordDao(String str) {
        return new q1(obtainManager(str).interactiveRecordDao());
    }

    public static synchronized DBManager obtainManager(String str) {
        DBManager dBManager;
        synchronized (DBManager.class) {
            dBManager = (DBManager) AbsRoomDatabase.obtainRoomDatabase(DBManager.class, str);
        }
        return dBManager;
    }

    public static y1 obtainNoteBookDataDao(String str) {
        return new z1(obtainManager(str).noteBookDataDao());
    }

    public static w obtainProgress(String str) {
        return new x(obtainManager(str).progressDao());
    }

    public static w obtainProgressDao(String str) {
        return new x(obtainManager(str).progressDao());
    }

    public static y2 obtainReadingRecordDao(String str) {
        return new z2(obtainManager(str).readingRecordDao());
    }

    public static z obtainRecordDao(String str) {
        return new a0(obtainManager(str).recordDao());
    }

    public static o3 obtainRelativeBookDao(String str) {
        return new p3(obtainManager(str).relativeBookDao());
    }

    public static r3 obtainRelativePDFEpubDao(String str) {
        return new s3(obtainManager("0").relativePDFEpubDao());
    }

    public static m4 obtainTaskCommentPublishRecordDao(String str) {
        return new n4(obtainManager(str).taskCommentPublishRecordDao());
    }

    public static p4 obtainUgcBookListDao(String str) {
        return new q4(obtainManager(str).ugcBookListDao());
    }

    public static s4 obtainUgcVideoListDao(String str) {
        return new t4(obtainManager(str).ugcVideoListDataDao());
    }

    public static j obtainUnderlineCacheDao(String str) {
        return new k(obtainManager(str).underlineLocalDao());
    }

    public static m obtainUnderlineDao(String str) {
        return new n(obtainManager(str).underlineRemoteDao());
    }

    public static e5 obtainVideoLikeDao(String str) {
        return new g5(obtainManager(str).videoLikeDao());
    }

    public static y4 obtainVideoRecordDao(String str) {
        return new z4(obtainManager(str).videoRecordDao());
    }

    public static b5 obtainVideoSeriesDao(String str) {
        return new c5(obtainManager(str).videoSeriesProgressDao());
    }

    public static List<d1> queryAllRelativeBook(String str) {
        return obtainRelativeBookDao(str).c();
    }

    public static List<String> queryBookshelfBookIdDesc(String str) {
        List<String> i = obtainDao(str).i();
        if (i == null) {
            return Collections.emptyList();
        }
        return i;
    }

    public static List<lr4.q> queryBookshelvesDesc(String str) {
        List<lr4.q> c = obtainDao(str).c();
        if (c == null) {
            return Collections.emptyList();
        }
        return c;
    }

    public static List<lr4.z0> queryRealBookStatusInShelf(String str) {
        List<lr4.z0> queryRealBookStatusInShelf = obtainDao(str).queryRealBookStatusInShelf();
        if (queryRealBookStatusInShelf == null) {
            return Collections.emptyList();
        }
        return queryRealBookStatusInShelf;
    }

    public static synchronized q obtainDao(String str) {
        r rVar;
        synchronized (DBManager.class) {
            rVar = new r(obtainManager(str).bookDao());
        }
        return rVar;
    }

    @Override // com.dragon.read.local.db.AbsRoomDatabase
    protected String getDatabaseName(String str) {
        return "reading_db_" + str;
    }

    @Override // com.dragon.read.local.db.AbsRoomDatabase
    protected <T extends AbsRoomDatabase> void onConfig(RoomDatabase.Builder<T> builder) {
        super.onConfig(builder);
        builder.addCallback(new a());
        builder.addMigrations(new Migration[]{new f3(), new or4.k(), new or4.t(), new or4.u(), new v(), new or4.w(), new or4.x(), new y(), new or4.z(), new or4.a0(), new b0(), new or4.d0(), new e0(), new or4.f0(), new or4.g0(), new h0(), new or4.i0(), new j0(), new or4.k0(), new or4.l0(), new m0(), new n0(), new o0(), new p0(), new q0(), new r0(), new s0(), new t0(), new u0(), new or4.v0(), new or4.w0(), new x0(), new or4.y0(), new or4.z0(), new a1(), new or4.b1(), new or4.c1(), new or4.d1(), new or4.e1(), new or4.f1(), new g1(), new or4.h1(), new or4.i1(), new j1(), new or4.k1(), new or4.l1(), new m1(), new or4.n1(), new o1(), new or4.p1(), new or4.q1(), new r1(), new or4.s1(), new or4.t1(), new u1(), new or4.v1(), new or4.w1(), new x1(), new or4.y1(), new or4.z1(), new a2(), new b2(), new c2(), new d2(), new e2(), new f2(), new g2(), new h2(), new i2(), new j2(), new k2(), new l2(), new m2(), new n2(), new o2(), new p2(), new q2(), new r2(), new s2(), new t2(), new u2(), new v2(), new w2(), new x2(), new or4.y2(), new or4.z2(), new a3(), new or4.b3(), new or4.c3(), new d3(), new e3(), new or4.a(), new or4.b(), new or4.c(), new or4.d(), new or4.e(), new or4.f(), new or4.g(), new or4.h(), new or4.i(), new or4.j(), new or4.l(), new or4.m(), new or4.n(), new or4.o(), new or4.p(), new or4.q(), new or4.r(), new s()});
    }

    public static int delete(String str, Book... bookArr) {
        return obtainDao(str).h(bookArr);
    }

    public static Long[] insertOrReplaceBookRecords(String str, lr4.i... iVarArr) {
        return obtainRecordDao(str).g(iVarArr);
    }

    public static Long[] insertOrReplaceBooks(String str, Book... bookArr) {
        return obtainDao(str).k(bookArr);
    }

    public static Long[] insertOrReplaceBookshelves(String str, lr4.q... qVarArr) {
        return obtainDao(str).d(qVarArr);
    }

    public static void insertReadingRecord(String str, lr4.x0 x0Var) {
        obtainReadingRecordDao(str).a(x0Var);
    }

    public static Long[] insertRelativeBook(String str, d1... d1VarArr) {
        return obtainRelativeBookDao(str).h(d1VarArr);
    }

    public static Book queryBook(String str, String str2) {
        return obtainDao(str).v(str2);
    }

    public static lr4.i queryBookRecord(String str, BookModel bookModel) {
        return obtainRecordDao(str).c(bookModel.bookId, bookModel.bookType);
    }

    public static List<lr4.k> queryBookUpdateModel(String str, List<String> list) {
        List<lr4.k> g = obtainDao(str).g(list);
        if (g == null) {
            return Collections.emptyList();
        }
        return g;
    }

    public static List<Book> queryBooks(String str, String... strArr) {
        List<Book> l = obtainDao(str).l(strArr);
        if (l == null) {
            return Collections.emptyList();
        }
        return l;
    }

    public static List<lr4.q> queryBookshelfBatch(String str, List<String> list) {
        return obtainDao(str).b(list);
    }

    public static List<pr4.b> queryMuchRelativeAudioBookId(String str, List<String> list) {
        return obtainRelativeBookDao(str).g(list);
    }

    public static List<pr4.c> queryMuchRelativeNovelBookId(String str, List<String> list) {
        return obtainRelativeBookDao(str).d(list);
    }

    public static lr4.x0 queryReadingRecord(String str, String str2) {
        return obtainReadingRecordDao(str).b(str2);
    }

    public static List<d1> queryRelativeBookById(String str, List<String> list) {
        return obtainRelativeBookDao(str).e(list);
    }

    public static lr4.q querySingleBookshelf(String str, BookModel bookModel) {
        return obtainDao(str).a(bookModel.bookId, bookModel.bookType);
    }

    public static void saveBook(String str, Book book) {
        if (book != null) {
            obtainDao(str).k(book);
        }
    }

    public static int deleteBookshelf(String str, lr4.q... qVarArr) {
        if (qVarArr != null && qVarArr.length != 0) {
            return obtainDao(str).j(qVarArr);
        }
        return 0;
    }

    public static List<lr4.z0> queryRealBookStatusInShelf(String str, List<String> list) {
        if (ListUtils.isEmpty(list)) {
            return Collections.emptyList();
        }
        List<lr4.z0> e = obtainDao(str).e(list);
        if (e == null) {
            return Collections.emptyList();
        }
        return e;
    }

    public static String queryRelativeNovelBookId(String str, String str2, BookType bookType) {
        return obtainRelativeBookDao(str).b(str2, bookType);
    }

    public static Set<String> queryRelativeAudioBookId(String str, String str2, BookType bookType) {
        return (Set) JSONUtils.fromJson(obtainRelativeBookDao(str).f(str2, bookType), new b().getType());
    }
}
