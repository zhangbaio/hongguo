package com.dragon.read.component.biz.impl;

import com.bytedance.covode.number.Covode;
import com.dragon.read.NsCommonDepend;
import com.dragon.read.app.App;
import com.dragon.read.component.biz.api.NsBookmallApi;
import com.dragon.read.component.biz.impl.bookshelf.video.type.CollectVideoType;
import com.dragon.read.component.biz.impl.brickservice.brickservice.BsEmptyButtonJumpService;
import com.dragon.read.component.shortvideo.api.ShortSeriesDistributeApi;
import com.dragon.read.pages.record.model.RecordTabType;
import com.dragon.read.rpc.model.BookstoreTabType;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class HGEmptyButtonJumpServiceImpl implements BsEmptyButtonJumpService {
    public static final int $stable = 0;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;

        static {
            Covode.recordClassIndex(588061);
            int[] iArr = new int[CollectVideoType.values().length];
            try {
                iArr[CollectVideoType.InteractiveGame.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CollectVideoType.MovieAndTeleplay.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[CollectVideoType.PugcVideo.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[CollectVideoType.DynamicComic.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[CollectVideoType.AiDynamicComic.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[CollectVideoType.PugcPreview.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[CollectVideoType.PugcHighlight.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[CollectVideoType.OnlySeries.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            a = iArr;
            int[] iArr2 = new int[RecordTabType.values().length];
            try {
                iArr2[RecordTabType.ALL.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr2[RecordTabType.MIX_VIDEO_BOOK.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr2[RecordTabType.ALBUM.ordinal()] = 3;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr2[RecordTabType.ONLY_SERIES.ordinal()] = 4;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr2[RecordTabType.HIGHLIGHT_PUGC.ordinal()] = 5;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr2[RecordTabType.PREVIEW_PUGC.ordinal()] = 6;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr2[RecordTabType.MINI_GAME.ordinal()] = 7;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr2[RecordTabType.DYNAMIC_COMIC.ordinal()] = 8;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr2[RecordTabType.FILMANDTELE.ordinal()] = 9;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                iArr2[RecordTabType.PIC_TEXT.ordinal()] = 10;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                iArr2[RecordTabType.PUGC.ordinal()] = 11;
            } catch (NoSuchFieldError unused19) {
            }
            b = iArr2;
        }
    }

    static {
        Covode.recordClassIndex(588060);
    }

    public int getEmptyButtonJumpTargetTabType(CollectVideoType collectVideoType) {
        boolean z;
        boolean z2;
        Object obj;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        Intrinsics.checkNotNullParameter(collectVideoType, "collectVideoType");
        NsBookmallApi nsBookmallApi = NsBookmallApi.IMPL;
        List p = nsBookmallApi.configService().p();
        Object obj2 = null;
        switch (a.a[collectVideoType.ordinal()]) {
            case 1:
                Iterator it2 = p.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        Object next = it2.next();
                        if (((Number) next).intValue() == BookstoreTabType.video_episode.getValue()) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (z) {
                            obj2 = next;
                        }
                    }
                }
                Integer num = (Integer) obj2;
                if (num != null) {
                    return num.intValue();
                }
                return BookstoreTabType.recommend.getValue();
            case 2:
                Iterator it4 = p.iterator();
                while (true) {
                    if (it4.hasNext()) {
                        Object next2 = it4.next();
                        if (((Number) next2).intValue() == BookstoreTabType.long_video.getValue()) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (z2) {
                            obj2 = next2;
                        }
                    }
                }
                Integer num2 = (Integer) obj2;
                if (num2 != null) {
                    return num2.intValue();
                }
                return BookstoreTabType.video_episode.getValue();
            case 3:
                Iterator it5 = nsBookmallApi.configService().c().iterator();
                while (true) {
                    if (it5.hasNext()) {
                        obj = it5.next();
                        if (((Number) obj).intValue() == BookstoreTabType.pugc_video_feed.getValue()) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        if (z4) {
                        }
                    } else {
                        obj = null;
                    }
                }
                Integer num3 = (Integer) obj;
                if (num3 != null) {
                    return num3.intValue();
                }
                if (ShortSeriesDistributeApi.IMPL.getSeriesMallTopTabStrategyHelper().m()) {
                    return BookstoreTabType.video_feed.getValue();
                }
                Iterator it6 = p.iterator();
                while (true) {
                    if (it6.hasNext()) {
                        Object next3 = it6.next();
                        if (((Number) next3).intValue() == BookstoreTabType.video_episode.getValue()) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (z3) {
                            obj2 = next3;
                        }
                    }
                }
                Integer num4 = (Integer) obj2;
                if (num4 != null) {
                    return num4.intValue();
                }
                return BookstoreTabType.video_feed.getValue();
            case 4:
                Iterator it7 = p.iterator();
                while (true) {
                    if (it7.hasNext()) {
                        Object next4 = it7.next();
                        if (((Number) next4).intValue() == BookstoreTabType.comic_series.getValue()) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                        if (z5) {
                            obj2 = next4;
                        }
                    }
                }
                Integer num5 = (Integer) obj2;
                if (num5 != null) {
                    return num5.intValue();
                }
                return BookstoreTabType.comic_series.getValue();
            case 5:
            case ConstantsAPI.COMMAND_LAUNCH_BY_WX /* 6 */:
            case 7:
            case ConstantsAPI.COMMAND_JUMP_BIZ_WEBVIEW /* 8 */:
                if (ShortSeriesDistributeApi.IMPL.getSeriesMallTopTabStrategyHelper().m()) {
                    return BookstoreTabType.video_feed.getValue();
                }
                Iterator it8 = p.iterator();
                while (true) {
                    if (it8.hasNext()) {
                        Object next5 = it8.next();
                        if (((Number) next5).intValue() == BookstoreTabType.video_episode.getValue()) {
                            z6 = true;
                        } else {
                            z6 = false;
                        }
                        if (z6) {
                            obj2 = next5;
                        }
                    }
                }
                Integer num6 = (Integer) obj2;
                if (num6 != null) {
                    return num6.intValue();
                }
                return BookstoreTabType.video_feed.getValue();
            default:
                Iterator it9 = p.iterator();
                while (true) {
                    if (it9.hasNext()) {
                        Object next6 = it9.next();
                        if (((Number) next6).intValue() == BookstoreTabType.video_episode.getValue()) {
                            z7 = true;
                        } else {
                            z7 = false;
                        }
                        if (z7) {
                            obj2 = next6;
                        }
                    }
                }
                Integer num7 = (Integer) obj2;
                if (num7 != null) {
                    return num7.intValue();
                }
                if (App.context().getResources().getBoolean(2131230803) && NsCommonDepend.IMPL.getSeriesMallTabData() != null) {
                    return BookstoreTabType.video_episode.getValue();
                }
                return BookstoreTabType.recommend.getValue();
        }
    }

    public int getEmptyButtonJumpTargetTabType(RecordTabType recordTabType) {
        boolean z;
        boolean z2;
        Object obj;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        Intrinsics.checkNotNullParameter(recordTabType, "recordTabType");
        NsBookmallApi nsBookmallApi = NsBookmallApi.IMPL;
        List p = nsBookmallApi.configService().p();
        List c = nsBookmallApi.configService().c();
        Object obj2 = null;
        switch (a.b[recordTabType.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case ConstantsAPI.COMMAND_LAUNCH_BY_WX /* 6 */:
            case 7:
                if (ShortSeriesDistributeApi.IMPL.getSeriesMallTopTabStrategyHelper().m()) {
                    return BookstoreTabType.video_feed.getValue();
                }
                Iterator it2 = p.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        Object next = it2.next();
                        if (((Number) next).intValue() == BookstoreTabType.video_episode.getValue()) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (z) {
                            obj2 = next;
                        }
                    }
                }
                Integer num = (Integer) obj2;
                if (num != null) {
                    return num.intValue();
                }
                return BookstoreTabType.video_feed.getValue();
            case ConstantsAPI.COMMAND_JUMP_BIZ_WEBVIEW /* 8 */:
                if (ShortSeriesDistributeApi.IMPL.getSeriesMallTopTabStrategyHelper().m()) {
                    Iterator it4 = p.iterator();
                    while (true) {
                        if (it4.hasNext()) {
                            obj = it4.next();
                            if (((Number) obj).intValue() == BookstoreTabType.comic_series.getValue()) {
                                z4 = true;
                            } else {
                                z4 = false;
                            }
                            if (z4) {
                            }
                        } else {
                            obj = null;
                        }
                    }
                    Integer num2 = (Integer) obj;
                    if (num2 != null) {
                        return num2.intValue();
                    }
                    Iterator it5 = p.iterator();
                    while (true) {
                        if (it5.hasNext()) {
                            Object next2 = it5.next();
                            if (((Number) next2).intValue() == BookstoreTabType.motion_comic_feed.getValue()) {
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            if (z3) {
                                obj2 = next2;
                            }
                        }
                    }
                    Integer num3 = (Integer) obj2;
                    if (num3 != null) {
                        return num3.intValue();
                    }
                    return BookstoreTabType.video_feed.getValue();
                }
                Iterator it6 = p.iterator();
                while (true) {
                    if (it6.hasNext()) {
                        Object next3 = it6.next();
                        if (((Number) next3).intValue() == BookstoreTabType.comic_series.getValue()) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (z2) {
                            obj2 = next3;
                        }
                    }
                }
                Integer num4 = (Integer) obj2;
                if (num4 != null) {
                    return num4.intValue();
                }
                return BookstoreTabType.video_feed.getValue();
            case 9:
                Iterator it7 = p.iterator();
                while (true) {
                    if (it7.hasNext()) {
                        Object next4 = it7.next();
                        if (((Number) next4).intValue() == BookstoreTabType.long_video.getValue()) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                        if (z5) {
                            obj2 = next4;
                        }
                    }
                }
                Integer num5 = (Integer) obj2;
                if (num5 != null) {
                    return num5.intValue();
                }
                return BookstoreTabType.video_episode.getValue();
            case 10:
                Iterator it8 = p.iterator();
                while (true) {
                    if (it8.hasNext()) {
                        Object next5 = it8.next();
                        if (((Number) next5).intValue() == BookstoreTabType.video_series_post.getValue()) {
                            z6 = true;
                        } else {
                            z6 = false;
                        }
                        if (z6) {
                            obj2 = next5;
                        }
                    }
                }
                Integer num6 = (Integer) obj2;
                if (num6 != null) {
                    return num6.intValue();
                }
                return BookstoreTabType.video_episode.getValue();
            case 11:
                Iterator it9 = c.iterator();
                while (true) {
                    if (it9.hasNext()) {
                        Object next6 = it9.next();
                        if (((Number) next6).intValue() == BookstoreTabType.pugc_video_feed.getValue()) {
                            z7 = true;
                        } else {
                            z7 = false;
                        }
                        if (z7) {
                            obj2 = next6;
                        }
                    }
                }
                Integer num7 = (Integer) obj2;
                if (num7 != null) {
                    return num7.intValue();
                }
                return BookstoreTabType.video_feed.getValue();
            default:
                return BookstoreTabType.video_episode.getValue();
        }
    }
}
