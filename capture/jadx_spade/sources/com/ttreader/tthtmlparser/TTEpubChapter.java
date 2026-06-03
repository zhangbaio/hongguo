package com.ttreader.tthtmlparser;

import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import com.bytedance.covode.number.Covode;
import com.ttreader.tthtmlparser.TTEpubDefinition;
import com.ttreader.tthtmlparser.highlight.HighLightInfo;
import com.ttreader.tthtmlparser.highlight.HighlightRange;
import com.ttreader.tthtmlparser.highlight.HighlightStyle;
import com.ttreader.tthtmlparser.highlight.SelectionStyle;
import com.ttreader.tthtmlparser.parser.HtmlElement;
import com.ttreader.tthtmlparser.position.TTPagePosition;
import com.ttreader.tthtmlparser.position.TTPosition;
import com.ttreader.tttext.IRunDelegate;
import com.ttreader.tttext.JavaDrawerCallback;
import com.ttreader.tttext.TTTextDefinition;
import com.ttreader.tttext.d;
import com.ttreader.tttext.e;
import com.ttreader.tttext.g;
import com.ttreader.tttext.i;
import com.ttreader.tttext.j;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class TTEpubChapter {
    private static final List<WeakReference<TTEpubChapter>> chapters_;
    private final long instance_;
    private final j resource_manager_;

    private native void nativeAddHighlightInfoByRange(long j, byte[] bArr);

    private native void nativeAddHighlightInfos(long j, byte[] bArr);

    private native void nativeAddLink(long j, int i, int i2, int i3, int i4, int i5);

    private native void nativeAddLinkByChapterRange(long j, int i, int i2, int i3, int i4);

    private native int nativeAvailableCompressTypeForCharInLine(long j, int i, int i2, int i3);

    private native int[] nativeChapterExtraDelegates(long j);

    private native float[] nativeCharRectForRange(long j, int i, int i2, int i3);

    private native void nativeCleanSelectText(long j);

    private native void nativeClearHighLightInfo(long j);

    private native int nativeClosestLineForPoint(long j, int i, int i2, int i3);

    private native int nativeClosestPosForPoint(long j, int i, int i2, int i3);

    private native int[] nativeDelegateRangeInPage(long j, int i, int i2);

    private native void nativeDestroyChapter(long j);

    private native boolean nativeDistributePage(long j, float f, int i, boolean z, float f2, float f3);

    private native byte[] nativeDrawPage(long j, int i, boolean z);

    private native byte[] nativeDrawPage(long j, int i, boolean z, float f, long j2, int i2, int i3);

    private native String[] nativeFindClickHighlight(long j, int i, float f, float f2);

    private native int nativeFindPageByID(long j, String str);

    private native boolean nativeFirstParaAcrossPage(long j, int i);

    private native String nativeFootnoteContent(long j, String str, int i);

    private native int[] nativeFootnoteInPage(long j, int i);

    private native int[] nativeFootnoteRange(long j, int i, int i2);

    private native int nativeGetCharacterCountForPositionRange(long j, byte[] bArr, byte[] bArr2);

    private native int nativeGetCharacterOffsetByPagePosition(long j, int i, float f, float f2);

    private native byte[] nativeGetEndPositionByStartPointAndOffset(long j, byte[] bArr, int i);

    private native byte[] nativeGetEndPositionInPage(long j, int i);

    private native byte[] nativeGetFirstSentenceStartPositionInPage(long j, int i, float f, float f2);

    private native byte[] nativeGetHighlightMergeRange(long j, int i, int i2);

    private native float[] nativeGetHighlightPointerRect(long j, int i);

    private native byte[] nativeGetLineRectByPosition(long j, int i, int i2, int i3);

    private native byte[] nativeGetPagePositionByPosition(long j, int i, int i2, int i3);

    private native String nativeGetPageTextBackgroundColor(long j, int i, int i2);

    private native boolean nativeGetPageTextBold(long j, int i, int i2);

    private native String nativeGetPageTextColor(long j, int i, int i2);

    private native byte[] nativeGetParagraphElements(long j, int i);

    private native int nativeGetParagraphIndex(long j, int i);

    private native byte[] nativeGetPositionByCharacterOffset(long j, int i);

    private native byte[] nativeGetPositionByPagePosition(long j, int i, float f, float f2);

    private native byte[] nativeGetPositionForTextByPagePosition(long j, int i, float f, float f2);

    private native int[] nativeGetRangeByPositionRange(long j, byte[] bArr, byte[] bArr2);

    private native byte[] nativeGetSelectInfoByVisiblePagePositionRange(long j, byte[] bArr, byte[] bArr2);

    private native byte[] nativeGetStartPositionInPage(long j, int i);

    private native String nativeGetString(long j);

    private native String nativeGetTextByChapterRange(long j, int i, int i2);

    private native String nativeGetTextByPositionRange(long j, byte[] bArr, byte[] bArr2);

    private native boolean nativeHasPageBackground(long j, int i);

    private native boolean nativeIsLastLineOfParagraph(long j, int i, int i2);

    private native boolean nativeIsPageEndWithBorder(long j, int i);

    private native boolean nativeLastParaAcrossPage(long j, int i);

    private native int nativeLineForPos(long j, int i, int i2);

    private native int nativeLineIndexForPoint(long j, int i, int i2, int i3);

    private native int[] nativeLineRange(long j, int i, int i2, int i3, boolean z);

    private native String nativeLineString(long j, int i, int i2);

    private native int[] nativeLinkInPage(long j, int i);

    private native int[] nativeLinkRange(long j, int i, int i2);

    private native void nativeModifyParagraphTextBoldAndItalic(long j, int i, int i2, int i3, boolean z, boolean z2);

    private native void nativeModifyParagraphTextColor(long j, int i, int i2, int i3, int i4);

    private native void nativeModifyParagraphTextStyle(long j, int i, int i2, int i3, int i4, boolean z, boolean z2);

    private native float nativePageBoundingSize(long j, int i);

    private native int nativePageCount(long j);

    private native int[] nativePageData(long j, int i);

    private native byte[] nativePageEmbeddedDelegates(long j, int i);

    private native byte[] nativePageExtraDelegateInfos(long j, int i);

    private native int[] nativePageExtraDelegates(long j, int i);

    private native float nativePageHeight(long j, int i);

    private native float nativePageLayoutBottom(long j, int i);

    private native float[] nativePageLayoutSize(long j, int i);

    private native float nativePageLayoutedTop(long j, int i);

    private native String[] nativePageLineString(long j, int i, int i2);

    private native float nativePageMarginBottom(long j, int i);

    private native int[] nativePageRange(long j, int i);

    private native int nativePageRowCount(long j, int i);

    private native int[] nativePageRunDelegates(long j, int i);

    private native float[] nativePageSize(long j, int i);

    private native String nativePageText(long j, int i);

    private native int nativeParagraphCount(long j);

    private native int[] nativeParagraphInPage(long j, int i);

    private native int[] nativeParagraphRange(long j, int i);

    private native int[] nativeParagraphRangeInPage(long j, int i, int i2);

    private native String nativeParagraphText(long j, int i);

    private native int[] nativePointRange(long j, int i, int i2, int i3);

    private native int[] nativeRangeForFloatElementsInLine(long j, int i, int i2);

    private native float[] nativeRectForExtraDelegate(long j, int i, int i2);

    private native float[] nativeRectForFloatElementsInLine(long j, int i, int i2);

    private native float[] nativeRectForLine(long j, int i, int i2, int i3);

    private native float[] nativeRectForPos(long j, int i, int i2);

    private native float[] nativeRectForRange(long j, int i, int i2, int i3);

    private native float[] nativeRectForRunDelegate(long j, int i, int i2);

    private native void nativeRemoveAllLink(long j, int i);

    private native void nativeRemoveExtraLink(long j, int i, int i2, int i3);

    private native void nativeRemoveHighlightInfo(long j, byte[] bArr);

    private native void nativeRemoveHighlightInfoByIds(long j, String[] strArr);

    private native void nativeRemoveHighlightInfos(long j);

    private native void nativeRemoveLink(long j, int i, int i2);

    private native int[] nativeSelectTextByPointF(long j, byte[] bArr);

    private native int[] nativeSelectTextByRange(long j, byte[] bArr);

    private native boolean nativeSelectTextOnDown(long j, int i, float f, float f2);

    private native boolean nativeSelectTextOnLongPress(long j, byte[] bArr, byte[] bArr2, int i, int i2, float f, int i3, float f2, int i4, String str);

    private native boolean nativeSelectTextOnUp(long j, int i, float f, float f2);

    private native float[] nativeSelectionRect(long j, int i, int i2, int i3);

    private native void nativeSetPageTextBackgroundColor(long j, int i, int i2, int i3, String str);

    private native void nativeSetPageTextBold(long j, int i, int i2, int i3, boolean z);

    private native void nativeSetPageTextColor(long j, int i, int i2, int i3, String str);

    private native void nativeSetSelectionCallback(long j, SelectCallbackBridge selectCallbackBridge);

    private native int[] nativeUpdateSelectionRangeAtPoint(long j, byte[] bArr);

    private native int nativeselectTextOnMove(long j, int i, float f, float f2);

    public native void nativeCompleteTextSelection(long j);

    public long GetInstance() {
        return this.instance_;
    }

    public j GetResourceManager() {
        return this.resource_manager_;
    }

    public void CleanSelectText() {
        nativeCleanSelectText(this.instance_);
    }

    public void CompleteTextSelection() {
        nativeCompleteTextSelection(this.instance_);
    }

    public String GetString() {
        return nativeGetString(this.instance_);
    }

    public void clearHighLightInfo() {
        nativeClearHighLightInfo(this.instance_);
    }

    public void removeAllHighlight() {
        nativeRemoveHighlightInfos(this.instance_);
    }

    static {
        Covode.recordClassIndex(654726);
        chapters_ = new ArrayList();
    }

    public IRunDelegate[] ChapterExtraDelegates() {
        checkState();
        return ToRunDelegates(nativeChapterExtraDelegates(this.instance_));
    }

    public int PageCount() {
        checkState();
        return nativePageCount(this.instance_);
    }

    public int ParagraphCount() {
        checkState();
        return nativeParagraphCount(this.instance_);
    }

    protected void finalize() throws Throwable {
        RemoveChapter(this);
        super.finalize();
        nativeDestroyChapter(this.instance_);
    }

    private void checkState() {
        if (this.instance_ != 0) {
        } else {
            throw new IllegalStateException("instance_ is null");
        }
    }

    private RectF ToRect(float[] fArr) {
        return ToRect(fArr, 0);
    }

    public boolean IsPageEndWithBorder(int i) {
        return nativeIsPageEndWithBorder(this.instance_, i);
    }

    public void RemoveHighlightInfoByIds(String[] strArr) {
        nativeRemoveHighlightInfoByIds(this.instance_, strArr);
    }

    public void setSelectCallback(SelectCallbackBridge selectCallbackBridge) {
        nativeSetSelectionCallback(this.instance_, selectCallbackBridge);
    }

    private static void AddChapter(TTEpubChapter tTEpubChapter) {
        List<WeakReference<TTEpubChapter>> list = chapters_;
        synchronized (list) {
            list.add(new WeakReference<>(tTEpubChapter));
        }
    }

    private Range ToRange(int[] iArr) {
        return new Range(iArr[0], iArr[1]);
    }

    public void AddHighlightInfoByChapterRange(HighlightRange highlightRange) {
        nativeAddHighlightInfoByRange(this.instance_, highlightRange.convertBytes());
    }

    public int FindPageByID(String str) {
        checkState();
        return nativeFindPageByID(this.instance_, str);
    }

    public String GetTextByChapterRange(Range range) {
        return nativeGetTextByChapterRange(this.instance_, range.start(), range.end());
    }

    public boolean IsFirstParagraphAcrossPage(int i) {
        long j = this.instance_;
        if (j == 0) {
            return false;
        }
        return nativeFirstParaAcrossPage(j, i);
    }

    public boolean IsLastParagraphAcrossPage(int i) {
        long j = this.instance_;
        if (j == 0) {
            return false;
        }
        return nativeLastParaAcrossPage(j, i);
    }

    public float PageBottomMargin(int i) {
        return TTEpubUtils.Dp2Px(nativePageMarginBottom(this.instance_, i));
    }

    public float PageBoundingSize(int i) {
        return TTEpubUtils.Dp2Px(nativePageBoundingSize(this.instance_, i));
    }

    public TTEpubPageData PageData(int i) {
        return new TTEpubPageData(nativePageData(this.instance_, i));
    }

    public float PageHeight(int i) {
        return TTEpubUtils.Dp2Px(nativePageHeight(this.instance_, i));
    }

    public TTTextDefinition.c PageLayoutSize(int i) {
        checkState();
        return ToSize(nativePageLayoutSize(this.instance_, i));
    }

    public float PageLayoutedBottom(int i) {
        return TTEpubUtils.Dp2Px(nativePageLayoutBottom(this.instance_, i));
    }

    public float PageLayoutedTop(int i) {
        return TTEpubUtils.Dp2Px(nativePageLayoutedTop(this.instance_, i));
    }

    public Range PageRange(int i) {
        checkState();
        return ToRange(nativePageRange(this.instance_, i));
    }

    public int PageRowCount(int i) {
        checkState();
        return nativePageRowCount(this.instance_, i);
    }

    public TTTextDefinition.c PageSize(int i) {
        checkState();
        return ToSize(nativePageSize(this.instance_, i));
    }

    public String PageText(int i) {
        checkState();
        return nativePageText(this.instance_, i);
    }

    public int[] ParagraphInPage(int i) {
        checkState();
        return nativeParagraphInPage(this.instance_, i);
    }

    public String ParagraphText(int i) {
        long j = this.instance_;
        if (j == 0) {
            return "";
        }
        return nativeParagraphText(j, i);
    }

    public void RemoveAllLinkInPage(int i) {
        long j = this.instance_;
        if (j == 0) {
            return;
        }
        nativeRemoveAllLink(j, i);
    }

    public Range SelectTextByRange(HighlightRange highlightRange) {
        return ToRange(nativeSelectTextByRange(this.instance_, highlightRange.convertBytes()));
    }

    public void addHighlightInfos(List<HighLightInfo> list) {
        nativeAddHighlightInfos(this.instance_, ProtocolUtils.convertHighLightInfosToByteArray(list));
    }

    public TTPosition getEndPositionInPage(int i) {
        byte[] nativeGetEndPositionInPage = nativeGetEndPositionInPage(this.instance_, i);
        if (nativeGetEndPositionInPage == null) {
            return null;
        }
        return ProtocolUtils.parsePosition(nativeGetEndPositionInPage);
    }

    public int getParagraphIndex(int i) {
        checkState();
        return nativeGetParagraphIndex(this.instance_, i);
    }

    public TTPosition getPositionByCharacterOffset(int i) {
        byte[] nativeGetPositionByCharacterOffset = nativeGetPositionByCharacterOffset(this.instance_, i);
        if (nativeGetPositionByCharacterOffset == null) {
            return null;
        }
        return ProtocolUtils.parsePosition(nativeGetPositionByCharacterOffset);
    }

    public TTPosition getStartPositionInPage(int i) {
        byte[] nativeGetStartPositionInPage = nativeGetStartPositionInPage(this.instance_, i);
        if (nativeGetStartPositionInPage == null) {
            return null;
        }
        return ProtocolUtils.parsePosition(nativeGetStartPositionInPage);
    }

    public boolean hasPageBackground(int i) {
        checkState();
        return nativeHasPageBackground(this.instance_, i);
    }

    public void removeHighlight(HighLightInfo highLightInfo) {
        nativeRemoveHighlightInfo(this.instance_, ProtocolUtils.convertHighLightInfoToByteArray(highLightInfo));
    }

    private IRunDelegate[] ToRunDelegates(int[] iArr) {
        IRunDelegate[] iRunDelegateArr = new IRunDelegate[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            iRunDelegateArr[i] = this.resource_manager_.h(iArr[i]);
        }
        return iRunDelegateArr;
    }

    public Pair<RectF, RectF> GetHighlightPointerRect(int i) {
        float[] nativeGetHighlightPointerRect = nativeGetHighlightPointerRect(this.instance_, i);
        return new Pair<>(ToRect(nativeGetHighlightPointerRect), ToRect(nativeGetHighlightPointerRect, 4));
    }

    public IRunDelegate[] PageAttachments(int i) {
        checkState();
        int[] nativePageRunDelegates = nativePageRunDelegates(this.instance_, i);
        int length = nativePageRunDelegates.length;
        IRunDelegate[] iRunDelegateArr = new IRunDelegate[length];
        for (int i2 = 0; i2 < length; i2++) {
            iRunDelegateArr[i2] = this.resource_manager_.h(nativePageRunDelegates[i2]);
        }
        return iRunDelegateArr;
    }

    public IRunDelegate[] PageExtraAttachments(int i) {
        checkState();
        int[] nativePageExtraDelegates = nativePageExtraDelegates(this.instance_, i);
        int length = nativePageExtraDelegates.length;
        IRunDelegate[] iRunDelegateArr = new IRunDelegate[length];
        for (int i2 = 0; i2 < length; i2++) {
            iRunDelegateArr[i2] = this.resource_manager_.h(nativePageExtraDelegates[i2]);
        }
        return iRunDelegateArr;
    }

    public e[] PageFootnotes(int i) {
        checkState();
        int[] nativeFootnoteInPage = nativeFootnoteInPage(this.instance_, i);
        int length = nativeFootnoteInPage.length;
        e[] eVarArr = new e[length];
        for (int i2 = 0; i2 < length; i2++) {
            eVarArr[i2] = this.resource_manager_.f(nativeFootnoteInPage[i2]);
        }
        return eVarArr;
    }

    public g[] PageLinks(int i) {
        checkState();
        int[] nativeLinkInPage = nativeLinkInPage(this.instance_, i);
        int length = nativeLinkInPage.length;
        g[] gVarArr = new g[length];
        for (int i2 = 0; i2 < length; i2++) {
            gVarArr[i2] = this.resource_manager_.g(nativeLinkInPage[i2]);
        }
        return gVarArr;
    }

    public Range ParagraphRange(int i) {
        long j = this.instance_;
        if (j == 0) {
            return new Range(-1, 0);
        }
        return ToRange(nativeParagraphRange(j, i));
    }

    public TTTextDefinition.c ToSize(float[] fArr) {
        return new TTTextDefinition.c(TTEpubUtils.Dp2Px(fArr[0]), TTEpubUtils.Dp2Px(fArr[1]));
    }

    public int getCharacterOffsetByPagePosition(TTPagePosition tTPagePosition) {
        return nativeGetCharacterOffsetByPagePosition(this.instance_, tTPagePosition.getPageIndex(), tTPagePosition.getX(), tTPagePosition.getY());
    }

    public RectF getLineRectByPosition(TTPosition tTPosition) {
        byte[] nativeGetLineRectByPosition = nativeGetLineRectByPosition(this.instance_, tTPosition.getParagraphId(), tTPosition.getElementIndex(), tTPosition.getOffsetInElement());
        if (nativeGetLineRectByPosition == null) {
            return null;
        }
        return ProtocolUtils.parseRectF(nativeGetLineRectByPosition);
    }

    public TTPagePosition getPagePositionByPosition(TTPosition tTPosition) {
        byte[] nativeGetPagePositionByPosition = nativeGetPagePositionByPosition(this.instance_, tTPosition.getParagraphId(), tTPosition.getElementIndex(), tTPosition.getOffsetInElement());
        if (nativeGetPagePositionByPosition == null) {
            return null;
        }
        return ProtocolUtils.parsePagePosition(nativeGetPagePositionByPosition);
    }

    public List<HtmlElement> getParagraphElement(int i) {
        checkState();
        byte[] nativeGetParagraphElements = nativeGetParagraphElements(this.instance_, i);
        if (nativeGetParagraphElements != null && nativeGetParagraphElements.length != 0) {
            return HtmlElement.readFromBytes(nativeGetParagraphElements);
        }
        return new ArrayList();
    }

    public TTPosition getPositionByPagePosition(TTPagePosition tTPagePosition) {
        byte[] nativeGetPositionByPagePosition = nativeGetPositionByPagePosition(this.instance_, tTPagePosition.getPageIndex(), tTPagePosition.getX(), tTPagePosition.getY());
        if (nativeGetPositionByPagePosition == null) {
            return null;
        }
        return ProtocolUtils.parsePosition(nativeGetPositionByPagePosition);
    }

    public TTPosition getPositionForTextByPagePosition(TTPagePosition tTPagePosition) {
        byte[] nativeGetPositionForTextByPagePosition = nativeGetPositionForTextByPagePosition(this.instance_, tTPagePosition.getPageIndex(), tTPagePosition.getX(), tTPagePosition.getY());
        if (nativeGetPositionForTextByPagePosition == null) {
            return null;
        }
        return ProtocolUtils.parsePosition(nativeGetPositionForTextByPagePosition);
    }

    public static TTEpubChapter FindChapterByInstance(long j) {
        List<WeakReference<TTEpubChapter>> list = chapters_;
        synchronized (list) {
            Iterator<WeakReference<TTEpubChapter>> it2 = list.iterator();
            while (it2.hasNext()) {
                TTEpubChapter tTEpubChapter = it2.next().get();
                if (tTEpubChapter != null && tTEpubChapter.instance_ == j) {
                    return tTEpubChapter;
                }
            }
            return null;
        }
    }

    private static void RemoveChapter(TTEpubChapter tTEpubChapter) {
        List<WeakReference<TTEpubChapter>> list = chapters_;
        synchronized (list) {
            for (int size = list.size() - 1; size >= 0; size--) {
                List<WeakReference<TTEpubChapter>> list2 = chapters_;
                WeakReference<TTEpubChapter> weakReference = list2.get(size);
                if (weakReference.get() == null || tTEpubChapter == weakReference.get()) {
                    list2.remove(size);
                }
            }
        }
    }

    public Pair<Range, String[]> GetHighlightMergeRange(Range range) {
        try {
            com.ttreader.tttext.a aVar = new com.ttreader.tttext.a(new ByteArrayInputStream(nativeGetHighlightMergeRange(this.instance_, range.start(), range.end())));
            Range create = Range.create(aVar.readInt(), aVar.readInt());
            int readInt = aVar.readInt();
            String[] strArr = new String[readInt];
            for (int i = 0; i < readInt; i++) {
                strArr[i] = aVar.a();
            }
            return new Pair<>(create, strArr);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public DelegateLayoutInfo[] PageEmbeddedDelegates(int i) {
        checkState();
        com.ttreader.tttext.a aVar = new com.ttreader.tttext.a(new ByteArrayInputStream(nativePageEmbeddedDelegates(this.instance_, i)));
        try {
            int readInt = aVar.readInt();
            DelegateLayoutInfo[] delegateLayoutInfoArr = new DelegateLayoutInfo[readInt];
            for (int i2 = 0; i2 < readInt; i2++) {
                float readFloat = aVar.readFloat();
                float readFloat2 = aVar.readFloat();
                float readFloat3 = aVar.readFloat();
                float readFloat4 = aVar.readFloat();
                int readInt2 = aVar.readInt();
                TTPosition tTPosition = new TTPosition(0, 0, 0);
                Rect rect = new Rect();
                rect.left = (int) TTEpubUtils.Dp2Px(readFloat);
                rect.top = (int) TTEpubUtils.Dp2Px(readFloat2);
                rect.right = (int) TTEpubUtils.Dp2Px(readFloat3);
                rect.bottom = (int) TTEpubUtils.Dp2Px(readFloat4);
                delegateLayoutInfoArr[i2] = new DelegateLayoutInfo(tTPosition, rect, this.resource_manager_.h(readInt2));
            }
            return delegateLayoutInfoArr;
        } catch (IOException | IllegalArgumentException unused) {
            return null;
        }
    }

    public DelegateLayoutInfo[] PageExtraDelegateInfos(int i) {
        checkState();
        com.ttreader.tttext.a aVar = new com.ttreader.tttext.a(new ByteArrayInputStream(nativePageExtraDelegateInfos(this.instance_, i)));
        try {
            int readInt = aVar.readInt();
            DelegateLayoutInfo[] delegateLayoutInfoArr = new DelegateLayoutInfo[readInt];
            for (int i2 = 0; i2 < readInt; i2++) {
                int readInt2 = aVar.readInt();
                int readInt3 = aVar.readInt();
                int readInt4 = aVar.readInt();
                float readFloat = aVar.readFloat();
                float readFloat2 = aVar.readFloat();
                float readFloat3 = aVar.readFloat();
                float readFloat4 = aVar.readFloat();
                int readInt5 = aVar.readInt();
                TTPosition tTPosition = new TTPosition(readInt2, readInt3, readInt4);
                Rect rect = new Rect();
                rect.left = (int) TTEpubUtils.Dp2Px(readFloat);
                rect.top = (int) TTEpubUtils.Dp2Px(readFloat2);
                rect.right = (int) TTEpubUtils.Dp2Px(readFloat3);
                rect.bottom = (int) TTEpubUtils.Dp2Px(readFloat4);
                delegateLayoutInfoArr[i2] = new DelegateLayoutInfo(tTPosition, rect, this.resource_manager_.h(readInt5));
            }
            return delegateLayoutInfoArr;
        } catch (IOException | IllegalArgumentException unused) {
            return null;
        }
    }

    public void DrawPage(Canvas canvas, int i) {
        DrawPage(canvas, i, false);
    }

    public Range LineRangeInPage(int i, int i2) {
        return LineRangeInPage(i, i2, false);
    }

    public TTEpubChapter(long j, j jVar) {
        this.instance_ = j;
        this.resource_manager_ = jVar;
        AddChapter(this);
    }

    public String FootnoteContentById(String str, int i) {
        checkState();
        return nativeFootnoteContent(this.instance_, str, i);
    }

    public String GetPageTextBackgroundColor(int i, int i2) {
        checkState();
        return nativeGetPageTextBackgroundColor(this.instance_, i, i2);
    }

    public boolean GetPageTextBold(int i, int i2) {
        checkState();
        return nativeGetPageTextBold(this.instance_, i, i2);
    }

    public String GetPageTextColor(int i, int i2) {
        checkState();
        return nativeGetPageTextColor(this.instance_, i, i2);
    }

    public boolean IsLineLastOfParagraph(int i, int i2) {
        checkState();
        return nativeIsLastLineOfParagraph(this.instance_, i, i2);
    }

    public int LineIndexForPosition(int i, int i2) {
        checkState();
        return nativeLineForPos(this.instance_, i, i2);
    }

    public String LineString(int i, int i2) {
        checkState();
        return nativeLineString(this.instance_, i, i2);
    }

    public String[] PageLineString(int i, int i2) {
        checkState();
        return nativePageLineString(this.instance_, i, i2);
    }

    public Range ParagraphRangeInPage(int i, int i2) {
        checkState();
        return ToRange(nativeParagraphRangeInPage(this.instance_, i, i2));
    }

    public RectF RectForPositionInPage(int i, int i2) {
        checkState();
        return ToRect(nativeRectForPos(this.instance_, i, i2));
    }

    public RectF[] SelectionRectForRange(Range range, int i) {
        return SelectionRectForRange(range.location, range.length, i);
    }

    public int getCharacterCountForPositionRange(TTPosition tTPosition, TTPosition tTPosition2) {
        return nativeGetCharacterCountForPositionRange(this.instance_, tTPosition.toBytes(), tTPosition2.toBytes());
    }

    public String getTextByPositionRange(TTPosition tTPosition, TTPosition tTPosition2) {
        return nativeGetTextByPositionRange(this.instance_, tTPosition.toBytes(), tTPosition2.toBytes());
    }

    public void AddLinkByChapterRange(g gVar, Range range) {
        long j = this.instance_;
        if (j == 0) {
            return;
        }
        nativeAddLinkByChapterRange(j, this.resource_manager_.b(gVar), gVar.b().ordinal(), range.location, range.length);
    }

    public Range AttachmentRangeInPage(IRunDelegate iRunDelegate, int i) {
        checkState();
        return ToRange(nativeDelegateRangeInPage(this.instance_, this.resource_manager_.c(iRunDelegate), i));
    }

    public String[] FindClickHighlight(int i, PointF pointF) {
        return nativeFindClickHighlight(this.instance_, i, (int) TTEpubUtils.Px2Dp(pointF.x + 0.5f), (int) TTEpubUtils.Px2Dp(pointF.y + 0.5f));
    }

    public Range FootnoteRangeInPage(e eVar, int i) {
        checkState();
        return ToRange(nativeFootnoteRange(this.instance_, this.resource_manager_.a(eVar), i));
    }

    public Range LinkRangeInPage(g gVar, int i) {
        checkState();
        return ToRange(nativeLinkRange(this.instance_, this.resource_manager_.b(gVar), i));
    }

    public RectF[] RectFloatElementsInLine(int i, int i2) {
        checkState();
        float[] nativeRectForFloatElementsInLine = nativeRectForFloatElementsInLine(this.instance_, i, i2);
        int length = nativeRectForFloatElementsInLine.length / 4;
        RectF[] rectFArr = new RectF[length];
        for (int i3 = 0; i3 < length; i3++) {
            rectFArr[i3] = ToRect(nativeRectForFloatElementsInLine, i3 * 4);
        }
        return rectFArr;
    }

    public RectF RectForAttachment(IRunDelegate iRunDelegate, int i) {
        checkState();
        return ToRect(nativeRectForRunDelegate(this.instance_, this.resource_manager_.c(iRunDelegate), i));
    }

    public RectF RectForExtraAttachment(IRunDelegate iRunDelegate, int i) {
        checkState();
        return ToRect(nativeRectForExtraDelegate(this.instance_, this.resource_manager_.c(iRunDelegate), i));
    }

    public RectF RectForLineInPage(int i, int i2) {
        checkState();
        return ToRect(nativeRectForLine(this.instance_, i, 1, i2));
    }

    public RectF RectForRangeInPage(Range range, int i) {
        checkState();
        return ToRect(nativeRectForRange(this.instance_, range.location, range.length, i));
    }

    public void RemoveLink(g gVar, Range range) {
        long j = this.instance_;
        if (j == 0) {
            return;
        }
        nativeRemoveExtraLink(j, this.resource_manager_.b(gVar), range.location, range.length);
    }

    public void RemoveLinkInPage(g gVar, int i) {
        long j = this.instance_;
        if (j == 0) {
            return;
        }
        nativeRemoveLink(j, this.resource_manager_.b(gVar), i);
    }

    public TTPosition getEndPositionByStartPointAndOffset(TTPosition tTPosition, int i) {
        byte[] nativeGetEndPositionByStartPointAndOffset = nativeGetEndPositionByStartPointAndOffset(this.instance_, tTPosition.toBytes(), i);
        if (nativeGetEndPositionByStartPointAndOffset == null) {
            return null;
        }
        return ProtocolUtils.parsePosition(nativeGetEndPositionByStartPointAndOffset);
    }

    public Range getRangeByPositionRange(TTPosition tTPosition, TTPosition tTPosition2) {
        return ToRange(nativeGetRangeByPositionRange(this.instance_, tTPosition.toBytes(), tTPosition2.toBytes()));
    }

    public SelectionInfo getSelectInfoByVisiblePagePositionRange(TTPagePosition tTPagePosition, TTPagePosition tTPagePosition2) {
        byte[] nativeGetSelectInfoByVisiblePagePositionRange = nativeGetSelectInfoByVisiblePagePositionRange(this.instance_, ProtocolUtils.convertPagePositionToByteArray(tTPagePosition), ProtocolUtils.convertPagePositionToByteArray(tTPagePosition2));
        if (nativeGetSelectInfoByVisiblePagePositionRange == null) {
            return null;
        }
        return ProtocolUtils.parseSelectionInfo(nativeGetSelectInfoByVisiblePagePositionRange);
    }

    private RectF ToRect(float[] fArr, int i) {
        int i2 = i + 1;
        return new RectF(TTEpubUtils.Dp2Px(fArr[i]), TTEpubUtils.Dp2Px(fArr[i2]), TTEpubUtils.Dp2Px(fArr[i] + fArr[i + 2]), TTEpubUtils.Dp2Px(fArr[i2] + fArr[i + 3]));
    }

    public RectF[] CharRectForRangeInPage(Range range, int i) {
        checkState();
        float[] nativeCharRectForRange = nativeCharRectForRange(this.instance_, range.location, range.length, i);
        int length = nativeCharRectForRange.length / 4;
        RectF[] rectFArr = new RectF[length];
        for (int i2 = 0; i2 < length; i2++) {
            rectFArr[i2] = ToRect(nativeCharRectForRange, i2 * 4);
        }
        return rectFArr;
    }

    public int ClosestLineIndexToPoint(Point point, int i) {
        checkState();
        return nativeClosestLineForPoint(this.instance_, (int) TTEpubUtils.Px2Dp(point.x + 0.5f), (int) TTEpubUtils.Px2Dp(point.y + 0.5f), i);
    }

    public int ClosestPositionToPoint(Point point, int i) {
        checkState();
        return nativeClosestPosForPoint(this.instance_, (int) TTEpubUtils.Px2Dp(point.x + 0.5f), (int) TTEpubUtils.Px2Dp(point.y + 0.5f), i);
    }

    public int LineIndexForPoint(Point point, int i) {
        checkState();
        return nativeLineIndexForPoint(this.instance_, (int) TTEpubUtils.Px2Dp(point.x + 0.5f), (int) TTEpubUtils.Px2Dp(point.y + 0.5f), i);
    }

    public Range RangeAtPoint(Point point, int i) {
        checkState();
        int[] nativePointRange = nativePointRange(this.instance_, (int) TTEpubUtils.Px2Dp(point.x + 0.5f), (int) TTEpubUtils.Px2Dp(point.y + 0.5f), i);
        return new Range(nativePointRange[0], nativePointRange[1]);
    }

    public Range[] RangeForFloatElementsInLine(int i, int i2) {
        checkState();
        int[] nativeRangeForFloatElementsInLine = nativeRangeForFloatElementsInLine(this.instance_, i, i2);
        int length = nativeRangeForFloatElementsInLine.length / 2;
        Range[] rangeArr = new Range[length];
        for (int i3 = 0; i3 < length; i3++) {
            int i4 = i3 * 2;
            rangeArr[i3] = new Range(nativeRangeForFloatElementsInLine[i4], nativeRangeForFloatElementsInLine[i4 + 1]);
        }
        return rangeArr;
    }

    public void SetPageTextBackgroundColor(int i, Range range, String str) {
        checkState();
        nativeSetPageTextBackgroundColor(this.instance_, i, range.location, range.length, str);
    }

    public void SetPageTextBold(int i, Range range, boolean z) {
        checkState();
        nativeSetPageTextBold(this.instance_, i, range.location, range.length, z);
    }

    public void SetPageTextColor(int i, Range range, String str) {
        checkState();
        nativeSetPageTextColor(this.instance_, i, range.location, range.length, str);
    }

    public boolean selectTextOnDown(int i, float f, float f2) {
        return nativeSelectTextOnDown(this.instance_, i, f, f2);
    }

    public boolean selectTextOnUp(int i, float f, float f2) {
        return nativeSelectTextOnUp(this.instance_, i, f, f2);
    }

    public void DrawPage(Canvas canvas, int i, boolean z) {
        checkState();
        new i(canvas, this.resource_manager_, null).g(nativeDrawPage(this.instance_, i, z));
    }

    public Range LineRangeInPage(int i, int i2, boolean z) {
        checkState();
        int[] nativeLineRange = nativeLineRange(this.instance_, i, 1, i2, z);
        return new Range(nativeLineRange[0], nativeLineRange[1]);
    }

    public void ModifyParagraphTextColor(int i, int i2, Range range) {
        long j = this.instance_;
        if (j == 0) {
            return;
        }
        nativeModifyParagraphTextColor(j, i, i2, range.location, range.length);
    }

    public TTEpubDefinition.CompressType compressTypeForCharInLine(int i, int i2, int i3) {
        checkState();
        return TTEpubDefinition.CompressType.values()[nativeAvailableCompressTypeForCharInLine(this.instance_, i, i2, i3)];
    }

    public TTPosition getFirstSentenceStartPositionInPage(int i, float f, float f2) {
        byte[] nativeGetFirstSentenceStartPositionInPage = nativeGetFirstSentenceStartPositionInPage(this.instance_, i, f, f2);
        if (nativeGetFirstSentenceStartPositionInPage == null) {
            return null;
        }
        return ProtocolUtils.parsePosition(nativeGetFirstSentenceStartPositionInPage);
    }

    public SelectionMoveResult selectTextOnMove(int i, float f, float f2) {
        return SelectionMoveResult.values()[nativeselectTextOnMove(this.instance_, i, f, f2)];
    }

    public void AddLinkInPage(g gVar, Range range, int i) {
        long j = this.instance_;
        if (j == 0) {
            return;
        }
        nativeAddLink(j, this.resource_manager_.b(gVar), gVar.b().ordinal(), range.location, range.length, i);
    }

    public RectF[] RectForLineInPage(int i, int i2, int i3) {
        checkState();
        float[] nativeRectForLine = nativeRectForLine(this.instance_, i, i2, i3);
        RectF[] rectFArr = new RectF[i2];
        for (int i4 = 0; i4 < i2; i4++) {
            rectFArr[i4] = ToRect(nativeRectForLine, i4 << 2);
        }
        return rectFArr;
    }

    public RectF[] SelectionRectForRange(int i, int i2, int i3) {
        checkState();
        float[] nativeSelectionRect = nativeSelectionRect(this.instance_, i, i2, i3);
        int length = nativeSelectionRect.length / 4;
        RectF[] rectFArr = new RectF[length];
        for (int i4 = 0; i4 < length; i4++) {
            rectFArr[i4] = ToRect(nativeSelectionRect, i4 * 4);
        }
        return rectFArr;
    }

    public void DrawPage(Canvas canvas, int i, d dVar, Range range) {
        DrawPage(canvas, i, false, false, dVar, range);
    }

    public Range[] LineRangeInPage(int i, int i2, int i3, boolean z) {
        checkState();
        int[] nativeLineRange = nativeLineRange(this.instance_, i, i2, i3, z);
        Range[] rangeArr = new Range[i2];
        for (int i4 = 0; i4 < i2; i4++) {
            int i5 = i4 << 1;
            rangeArr[i4] = new Range(nativeLineRange[i5], nativeLineRange[i5 + 1]);
        }
        return rangeArr;
    }

    public void ModifyParagraphTextStyle(int i, Range range, boolean z, boolean z2) {
        long j = this.instance_;
        if (j == 0) {
            return;
        }
        nativeModifyParagraphTextBoldAndItalic(j, i, range.location, range.length, z, z2);
    }

    public Pair<Range, Integer> updateSelectionRangeAtPoint(TTPagePosition tTPagePosition, TTPagePosition tTPagePosition2, TTPagePosition tTPagePosition3, boolean z) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        try {
            tTPagePosition.writeStream(dataOutputStream);
            tTPagePosition2.writeStream(dataOutputStream);
            tTPagePosition3.writeStream(dataOutputStream);
            dataOutputStream.writeBoolean(z);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Range range = new Range(0, 0);
        int[] nativeUpdateSelectionRangeAtPoint = nativeUpdateSelectionRangeAtPoint(this.instance_, byteArrayOutputStream.toByteArray());
        if (nativeUpdateSelectionRangeAtPoint != null && nativeUpdateSelectionRangeAtPoint.length >= 3) {
            return new Pair<>(new Range(nativeUpdateSelectionRangeAtPoint[0], nativeUpdateSelectionRangeAtPoint[1]), Integer.valueOf(nativeUpdateSelectionRangeAtPoint[2]));
        }
        return new Pair<>(range, 0);
    }

    public boolean distributePage(float f, int i, boolean z, float f2, float f3) {
        return nativeDistributePage(this.instance_, f, i, z, f2, f3);
    }

    public void ModifyParagraphTextStyle(int i, Range range, int i2, boolean z, boolean z2) {
        long j = this.instance_;
        if (j == 0) {
            return;
        }
        nativeModifyParagraphTextStyle(j, i, range.location, range.length, i2, z, z2);
    }

    public void DrawPage(Canvas canvas, int i, boolean z, boolean z2, d dVar) {
        DrawPage(canvas, i, z, z2, dVar, null);
    }

    public Range selectTextByPointInVisibleArea(TTPagePosition tTPagePosition, TTPagePosition tTPagePosition2, TTPagePosition tTPagePosition3, int i, SelectionStyle selectionStyle) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        try {
            tTPagePosition.writeStream(dataOutputStream);
            tTPagePosition2.writeStream(dataOutputStream);
            tTPagePosition3.writeStream(dataOutputStream);
            dataOutputStream.writeInt(i);
            dataOutputStream.writeInt(selectionStyle.ordinal());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ToRange(nativeSelectTextByPointF(this.instance_, byteArrayOutputStream.toByteArray()));
    }

    public void DrawPage(Canvas canvas, int i, boolean z, boolean z2, d dVar, Range range) {
        float f;
        int i2;
        int i3;
        checkState();
        JavaDrawerCallback javaDrawerCallback = new JavaDrawerCallback(dVar);
        float Px2Dp = TTEpubUtils.Px2Dp(canvas.getHeight());
        long j = this.instance_;
        if (z2) {
            f = Px2Dp;
        } else {
            f = Float.MAX_VALUE;
        }
        long GetInstance = javaDrawerCallback.GetInstance();
        if (range == null) {
            i2 = 0;
        } else {
            i2 = range.location;
        }
        if (range == null) {
            i3 = 0;
        } else {
            i3 = range.length;
        }
        new i(canvas, this.resource_manager_, javaDrawerCallback).g(nativeDrawPage(j, i, z, f, GetInstance, i2, i3));
    }

    public boolean selectTextOnLongPress(PointF pointF, HighlightStyle highlightStyle, int i, int i2, float f, int i3, float f2, SelectionStyle selectionStyle, String str) {
        return nativeSelectTextOnLongPress(this.instance_, ProtocolUtils.convertPointFToByteArray(pointF), ProtocolUtils.convertHighlightStyleToByteArray(highlightStyle), i, i2, f, i3, f2, selectionStyle.ordinal(), str);
    }
}
