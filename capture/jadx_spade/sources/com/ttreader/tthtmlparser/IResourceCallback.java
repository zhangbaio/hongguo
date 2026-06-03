package com.ttreader.tthtmlparser;

import android.graphics.Typeface;
import com.ttreader.tthtmlparser.TTEpubDefinition;
import com.ttreader.tthtmlparser.dom.TTHtmlDocument;
import com.ttreader.tttext.IRunDelegate;
import com.ttreader.tttext.TTTextDefinition;
import com.ttreader.tttext.e;
import com.ttreader.tttext.g;
import com.ttreader.tttext.h;
import com.ttreader.tttext.k;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public interface IResourceCallback {
    k FetchFont(TTTextDefinition.a[] aVarArr, TTTextDefinition.FontWeight fontWeight, TTTextDefinition.FontStyle fontStyle);

    e FetchFootnoteInfo(String str, String str2);

    TTTextDefinition.c FetchImgSize(String str, String str2, TTEpubDefinition.ResourceAttributes resourceAttributes);

    g FetchLinkInfo(String str);

    byte[] FetchResourceData(String str, String str2, TTEpubDefinition.ResourceType resourceType);

    IRunDelegate FetchRunDelegate(String str, String str2, TTEpubDefinition.ResourceAttributes resourceAttributes, TTTextDefinition.c cVar);

    void NotifyHtmlParserEnd(TTHtmlDocument tTHtmlDocument);

    void NotifyParagraphElement(TTEpubParagraphElement tTEpubParagraphElement);

    void OnParseStart();

    void OnParserFinished();

    void ReportParserErrorMsgs(ArrayList<TTEpubParserErrorMsg> arrayList);

    List<h> fetchInsertRunDelegates();

    TTEpubLayoutConfig getLayoutConfig();

    void onCallbackError(Exception exc);

    /* renamed from: com.ttreader.tthtmlparser.IResourceCallback$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static e $default$FetchFootnoteInfo(IResourceCallback iResourceCallback, String str, String str2) {
            return null;
        }

        public static TTTextDefinition.c $default$FetchImgSize(IResourceCallback iResourceCallback, String str, String str2, TTEpubDefinition.ResourceAttributes resourceAttributes) {
            return null;
        }

        public static g $default$FetchLinkInfo(IResourceCallback iResourceCallback, String str) {
            return null;
        }

        public static byte[] $default$FetchResourceData(IResourceCallback iResourceCallback, String str, String str2, TTEpubDefinition.ResourceType resourceType) {
            return null;
        }

        public static void $default$NotifyHtmlParserEnd(IResourceCallback iResourceCallback, TTHtmlDocument tTHtmlDocument) {
        }

        public static void $default$NotifyParagraphElement(IResourceCallback iResourceCallback, TTEpubParagraphElement tTEpubParagraphElement) {
        }

        public static void $default$OnParseStart(IResourceCallback iResourceCallback) {
        }

        public static void $default$OnParserFinished(IResourceCallback iResourceCallback) {
        }

        public static void $default$ReportParserErrorMsgs(IResourceCallback iResourceCallback, ArrayList arrayList) {
        }

        public static void $default$onCallbackError(IResourceCallback iResourceCallback, Exception exc) {
        }

        public static k $default$FetchFont(IResourceCallback iResourceCallback, TTTextDefinition.a[] aVarArr, TTTextDefinition.FontWeight fontWeight, TTTextDefinition.FontStyle fontStyle) {
            return new k(Typeface.DEFAULT);
        }
    }
}
