package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import java.io.Serializable;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class ShortStoryReaderParams implements Serializable {
    public static final int $stable;
    public static final a Companion;
    private static final long serialVersionUID = 0;
    private String albumId;
    private String albumTitle;
    private String bookStatus;
    private String coverId;
    private String fromVideoId;
    private int genreType;
    private boolean isForcePgcContainer;
    private boolean listenAudio;
    private boolean openAlbumPanel;
    private String postId;
    private String relatePostSchema;
    private ShortStoryReaderReportArgs reportArgs;
    private Integer sourcePageType;
    private String targetContentId;
    private Integer targetContentType;
    private String targetPosition;
    private boolean targetPositionHighlight;

    public static final class a {
        static {
            Covode.recordClassIndex(612243);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Covode.recordClassIndex(612242);
        Companion = new a(null);
        $stable = 8;
    }

    public final String getAlbumId() {
        return this.albumId;
    }

    public final String getAlbumTitle() {
        return this.albumTitle;
    }

    public final String getBookStatus() {
        return this.bookStatus;
    }

    public final String getCoverId() {
        return this.coverId;
    }

    public final String getFromVideoId() {
        return this.fromVideoId;
    }

    public final int getGenreType() {
        return this.genreType;
    }

    public final boolean getListenAudio() {
        return this.listenAudio;
    }

    public final boolean getOpenAlbumPanel() {
        return this.openAlbumPanel;
    }

    public final String getPostId() {
        return this.postId;
    }

    public final String getRelatePostSchema() {
        return this.relatePostSchema;
    }

    public final ShortStoryReaderReportArgs getReportArgs() {
        return this.reportArgs;
    }

    public final Integer getSourcePageType() {
        return this.sourcePageType;
    }

    public final String getTargetContentId() {
        return this.targetContentId;
    }

    public final Integer getTargetContentType() {
        return this.targetContentType;
    }

    public final String getTargetPosition() {
        return this.targetPosition;
    }

    public final boolean getTargetPositionHighlight() {
        return this.targetPositionHighlight;
    }

    public final boolean isForcePgcContainer() {
        return this.isForcePgcContainer;
    }

    public final void setAlbumId(String str) {
        this.albumId = str;
    }

    public final void setAlbumTitle(String str) {
        this.albumTitle = str;
    }

    public final void setBookStatus(String str) {
        this.bookStatus = str;
    }

    public final void setCoverId(String str) {
        this.coverId = str;
    }

    public final void setForcePgcContainer(boolean z) {
        this.isForcePgcContainer = z;
    }

    public final void setFromVideoId(String str) {
        this.fromVideoId = str;
    }

    public final void setGenreType(int i) {
        this.genreType = i;
    }

    public final void setListenAudio(boolean z) {
        this.listenAudio = z;
    }

    public final void setOpenAlbumPanel(boolean z) {
        this.openAlbumPanel = z;
    }

    public final void setPostId(String str) {
        this.postId = str;
    }

    public final void setRelatePostSchema(String str) {
        this.relatePostSchema = str;
    }

    public final void setReportArgs(ShortStoryReaderReportArgs shortStoryReaderReportArgs) {
        this.reportArgs = shortStoryReaderReportArgs;
    }

    public final void setSourcePageType(Integer num) {
        this.sourcePageType = num;
    }

    public final void setTargetContentId(String str) {
        this.targetContentId = str;
    }

    public final void setTargetContentType(Integer num) {
        this.targetContentType = num;
    }

    public final void setTargetPosition(String str) {
        this.targetPosition = str;
    }

    public final void setTargetPositionHighlight(boolean z) {
        this.targetPositionHighlight = z;
    }

    public ShortStoryReaderParams(String str, int i) {
        this(str, i, null);
    }

    public ShortStoryReaderParams(String str, int i, ShortStoryReaderReportArgs shortStoryReaderReportArgs) {
        this.relatePostSchema = str;
        this.genreType = i;
        this.reportArgs = shortStoryReaderReportArgs;
    }

    public /* synthetic */ ShortStoryReaderParams(String str, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : str, i);
    }
}
