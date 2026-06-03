package com.dragon.read.component.shortvideo.brickservice;

import com.bytedance.covode.number.Covode;
import com.bytedance.news.common.service.manager.IService;
import com.bytedance.news.common.service.manager.ServiceManager;
import com.dragon.read.component.shortvideo.brickservice.BsAlbumConfig;
import com.dragon.read.component.shortvideo.data.saas.video.d;
import com.dragon.read.component.shortvideo.impl.catalog.IAlbumEpisodeListView;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public interface BsAlbumConfig extends IService {
    public static final Companion Companion;

    public static final class a {
        static {
            Covode.recordClassIndex(598976);
        }

        public static boolean a(BsAlbumConfig bsAlbumConfig) {
            return false;
        }

        public static boolean b(BsAlbumConfig bsAlbumConfig) {
            return false;
        }

        public static boolean c(BsAlbumConfig bsAlbumConfig, IAlbumEpisodeListView.Scene scene) {
            Intrinsics.checkNotNullParameter(scene, "scene");
            return false;
        }

        public static boolean d(BsAlbumConfig bsAlbumConfig, IAlbumEpisodeListView.Scene scene) {
            Intrinsics.checkNotNullParameter(scene, "scene");
            return false;
        }

        public static boolean e(BsAlbumConfig bsAlbumConfig) {
            return false;
        }

        public static boolean f(BsAlbumConfig bsAlbumConfig) {
            return false;
        }

        public static boolean g(BsAlbumConfig bsAlbumConfig, d dVar) {
            return false;
        }

        public static boolean h(BsAlbumConfig bsAlbumConfig) {
            return false;
        }

        public static boolean i(BsAlbumConfig bsAlbumConfig) {
            return false;
        }

        public static boolean j(BsAlbumConfig bsAlbumConfig) {
            return false;
        }
    }

    static {
        Covode.recordClassIndex(598974);
        Companion = Companion.a;
    }

    boolean canShowFollow();

    boolean defaultShowAlbumEpisodeCount();

    boolean disableAlbumDialogDragToFull();

    boolean disableAlbumDialogPercentHeight();

    boolean disableAlbumSpaceShrink();

    boolean enableAlbumEpisodeHorizontalIndexList(IAlbumEpisodeListView.Scene scene);

    boolean enableAlbumEpisodeStyleOpt();

    boolean enableAlbumEpisodeTitleBarFollowListScroll(IAlbumEpisodeListView.Scene scene);

    boolean enableAlbumSeriesEndDifferentFeed();

    boolean enableAlbumUnFollowButtonBrandColor();

    boolean enableRelateBook(d dVar);

    boolean enableShowAvatarInEpisodeDialog();

    boolean hasAlbumEpisodeSwitch();

    boolean shouldHideAvatarAndSubscribeForAlbum();

    boolean shouldShowAlbumSubInfo();

    boolean shouldShowAuthorNameForAlbum();

    public static final class Companion {
        static final /* synthetic */ Companion a;
        private static final BsAlbumConfig b;

        private Companion() {
        }

        public final BsAlbumConfig a() {
            return b;
        }

        static {
            Covode.recordClassIndex(598975);
            a = new Companion();
            BsAlbumConfig bsAlbumConfig = (BsAlbumConfig) ServiceManager.getService(BsAlbumConfig.class);
            if (bsAlbumConfig == null) {
                bsAlbumConfig = new BsAlbumConfig() { // from class: com.dragon.read.component.shortvideo.brickservice.BsAlbumConfig$Companion$IMPL$1
                    @Override // com.dragon.read.component.shortvideo.brickservice.BsAlbumConfig
                    public boolean canShowFollow() {
                        return false;
                    }

                    @Override // com.dragon.read.component.shortvideo.brickservice.BsAlbumConfig
                    public boolean defaultShowAlbumEpisodeCount() {
                        return false;
                    }

                    @Override // com.dragon.read.component.shortvideo.brickservice.BsAlbumConfig
                    public boolean disableAlbumDialogPercentHeight() {
                        return false;
                    }

                    @Override // com.dragon.read.component.shortvideo.brickservice.BsAlbumConfig
                    public boolean enableAlbumEpisodeStyleOpt() {
                        return false;
                    }

                    @Override // com.dragon.read.component.shortvideo.brickservice.BsAlbumConfig
                    public boolean enableShowAvatarInEpisodeDialog() {
                        return false;
                    }

                    @Override // com.dragon.read.component.shortvideo.brickservice.BsAlbumConfig
                    public boolean hasAlbumEpisodeSwitch() {
                        return false;
                    }

                    @Override // com.dragon.read.component.shortvideo.brickservice.BsAlbumConfig
                    public boolean disableAlbumDialogDragToFull() {
                        return BsAlbumConfig.a.a(this);
                    }

                    @Override // com.dragon.read.component.shortvideo.brickservice.BsAlbumConfig
                    public boolean disableAlbumSpaceShrink() {
                        return BsAlbumConfig.a.b(this);
                    }

                    @Override // com.dragon.read.component.shortvideo.brickservice.BsAlbumConfig
                    public boolean enableAlbumSeriesEndDifferentFeed() {
                        return BsAlbumConfig.a.e(this);
                    }

                    @Override // com.dragon.read.component.shortvideo.brickservice.BsAlbumConfig
                    public boolean enableAlbumUnFollowButtonBrandColor() {
                        return BsAlbumConfig.a.f(this);
                    }

                    @Override // com.dragon.read.component.shortvideo.brickservice.BsAlbumConfig
                    public boolean shouldHideAvatarAndSubscribeForAlbum() {
                        return BsAlbumConfig.a.h(this);
                    }

                    @Override // com.dragon.read.component.shortvideo.brickservice.BsAlbumConfig
                    public boolean shouldShowAlbumSubInfo() {
                        return BsAlbumConfig.a.i(this);
                    }

                    @Override // com.dragon.read.component.shortvideo.brickservice.BsAlbumConfig
                    public boolean shouldShowAuthorNameForAlbum() {
                        return BsAlbumConfig.a.j(this);
                    }

                    @Override // com.dragon.read.component.shortvideo.brickservice.BsAlbumConfig
                    public boolean enableAlbumEpisodeHorizontalIndexList(IAlbumEpisodeListView.Scene scene) {
                        return BsAlbumConfig.a.c(this, scene);
                    }

                    @Override // com.dragon.read.component.shortvideo.brickservice.BsAlbumConfig
                    public boolean enableAlbumEpisodeTitleBarFollowListScroll(IAlbumEpisodeListView.Scene scene) {
                        return BsAlbumConfig.a.d(this, scene);
                    }

                    @Override // com.dragon.read.component.shortvideo.brickservice.BsAlbumConfig
                    public boolean enableRelateBook(d dVar) {
                        return BsAlbumConfig.a.g(this, dVar);
                    }
                };
            }
            b = bsAlbumConfig;
        }
    }
}
