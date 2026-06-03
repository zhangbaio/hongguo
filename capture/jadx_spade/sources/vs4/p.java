package vs4;

import com.bytedance.covode.number.Covode;
import com.dragon.read.rpc.model.ResearchSceneType;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class p {
    public static final p a;
    private static final Map<ResearchSceneType, String> b;
    public static final int c;

    private p() {
    }

    public final Map<ResearchSceneType, String> a() {
        return b;
    }

    static {
        Map<ResearchSceneType, String> mapOf;
        Covode.recordClassIndex(612550);
        a = new p();
        ResearchSceneType researchSceneType = ResearchSceneType.NewBook;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(ResearchSceneType.ChapterEndNovel, "read_reader"), TuplesKt.to(ResearchSceneType.ChapterEndPublish, "read_pubreader"), TuplesKt.to(ResearchSceneType.ReaderAD, "ad_reader"), TuplesKt.to(ResearchSceneType.BookStoreMainFeed, "app_recommendfeed"), TuplesKt.to(ResearchSceneType.VideoSeriesTab, "duanju_duanjufeed"), TuplesKt.to(ResearchSceneType.IdeaCommentList, "community_paragraphcomment"), TuplesKt.to(ResearchSceneType.BookContent, "read_readerbook"), TuplesKt.to(ResearchSceneType.Unlimited, "c2feed_c2feed"), TuplesKt.to(researchSceneType, "quit_reader"), TuplesKt.to(ResearchSceneType.AllGenreNps709, "all_genre_nps_709"), TuplesKt.to(ResearchSceneType.SearchResult, "search_searchresult"), TuplesKt.to(researchSceneType, "quit_reader"), TuplesKt.to(ResearchSceneType.AfterUseAIGenImage, "ai_image_editor_quit"), TuplesKt.to(ResearchSceneType.AfterReadAIComment, "community_paragraphcomment"), TuplesKt.to(ResearchSceneType.BeforeReturnFromReaderToUnlimited, "exit_reader"), TuplesKt.to(ResearchSceneType.AtSpecifiedChapterInReader, "reader_chapter_end"), TuplesKt.to(ResearchSceneType.AfterReturnFromReaderToUnlimited, "unlimited_content"), TuplesKt.to(ResearchSceneType.ReaderChapterEnd, "reader_chapter_end"), TuplesKt.to(ResearchSceneType.ReaderExist, "exit_reader"));
        b = mapOf;
        c = 8;
    }
}
