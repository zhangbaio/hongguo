package com.ss.ttvideoengine.download;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.ss.android.ugc.bytex.taskmonitor.proxy.HandlerDelegate;
import com.ss.ttvideoengine.DataLoaderHelper;
import com.ss.ttvideoengine.FeatureManager;
import com.ss.ttvideoengine.Resolution;
import com.ss.ttvideoengine.database.KVDBManager;
import com.ss.ttvideoengine.download.DownloadTask;
import com.ss.ttvideoengine.model.VideoModel;
import com.ss.ttvideoengine.utils.Error;
import com.ss.ttvideoengine.utils.TTHelper;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class Downloader {
    private static final Downloader ourInstance;
    private ArrayList<DownloadTask> allTasks;
    private ArrayList<Long> indexArray;
    private long limitFreeDiskSize;
    private long maxDownloadOperationCount;
    private long maxTaskId;
    private boolean readAllTask;
    private ArrayList<DownloadTask> runingTasks;
    private ArrayList<DownloadTask> waitingTasks;
    private IDownloaderListener listener = null;
    private ArrayList<DownloadTask> temLoadedTasks = null;
    private boolean loadData = false;
    private Handler mHandler = null;
    private Context mContext = null;
    private KVDBManager dbObject = null;
    private TaskThread taskThread = new TaskThread();
    private long mPerfGetCacheInfo = 0;
    private volatile boolean mEnableVidTaskSuspendReleaseSlot = false;

    public static Downloader getInstance() {
        return ourInstance;
    }

    public long getLimitFreeDiskSize() {
        return this.limitFreeDiskSize;
    }

    public IDownloaderListener getListener() {
        return this.listener;
    }

    public long getMaxDownloadOperationCount() {
        return this.maxDownloadOperationCount;
    }

    public boolean isEnableVidTaskSuspendReleaseSlot() {
        return this.mEnableVidTaskSuspendReleaseSlot;
    }

    static {
        Covode.recordClassIndex(652430);
        ourInstance = new Downloader();
    }

    private void initHandle() {
        if (this.mHandler != null) {
            return;
        }
        this.mHandler = new HandlerDelegate(TTHelper.getLooper()) { // from class: com.ss.ttvideoengine.download.Downloader.1
            /* JADX WARN: Multi-variable type inference failed */
            public void handleMessage(Message message) {
                boolean z;
                long j;
                long j2;
                Downloader downloader;
                try {
                    super/*android.os.Handler*/.handleMessage(message);
                    int i = message.what;
                    if (i == 1) {
                        Object obj = message.obj;
                        if (obj instanceof ArrayList) {
                            ArrayList arrayList = (ArrayList) obj;
                            DownloadTask taskForKey = Downloader.this.taskForKey((String) arrayList.get(0));
                            if (taskForKey != null) {
                                Error error = (Error) arrayList.get(1);
                                if (!taskForKey._shouldRetry(error)) {
                                    taskForKey.setState(5);
                                }
                                taskForKey.receiveError(error);
                                ArrayList<String> arrayList2 = taskForKey.mediaKeys;
                                if (arrayList2 != null && arrayList2.size() > 0) {
                                    for (int i2 = 0; i2 < taskForKey.mediaKeys.size(); i2++) {
                                        DataLoaderHelper.getDataLoader().suspendedDownload(taskForKey.mediaKeys.get(i2));
                                    }
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    if (i != 2) {
                        if (i == 0) {
                            try {
                                String[] split = ((String) message.obj).split(",");
                                if (split.length < 4) {
                                    return;
                                }
                                long parseLong = Long.parseLong(split[0]);
                                long parseLong2 = Long.parseLong(split[1]);
                                TTVideoEngineLog.i("TTVideoEngine.Downloader", "[downloader] download progress, bytesReceived = " + parseLong + " expectedToReceive = " + parseLong2);
                                if (parseLong2 <= 0) {
                                    return;
                                }
                                String str = split[2];
                                String str2 = split[3];
                                DownloadTask taskForKey2 = this.taskForKey(str);
                                if (taskForKey2 == null) {
                                    TTVideoEngineLog.e("TTVideoEngine.Downloader", "[downloader] exect fail. key = " + str + ", task is null");
                                    DataLoaderHelper.getDataLoader().suspendedDownload(str);
                                    return;
                                }
                                if (taskForKey2.getState() != 3 && taskForKey2.getState() != 5) {
                                    taskForKey2.bytesReceivedMap.put(str, Long.valueOf(parseLong));
                                    taskForKey2.bytesExpectedToReceiveMap.put(str, Long.valueOf(parseLong2));
                                    ArrayList<String> arrayList3 = taskForKey2.mediaKeys;
                                    if (arrayList3 != null && arrayList3.size() > 0) {
                                        Iterator<String> it2 = taskForKey2.mediaKeys.iterator();
                                        j = 0;
                                        j2 = 0;
                                        z = true;
                                        while (it2.hasNext()) {
                                            String next = it2.next();
                                            if (!taskForKey2.bytesReceivedMap.containsKey(next)) {
                                                z = false;
                                            } else {
                                                j2 += taskForKey2.bytesReceivedMap.get(next).longValue();
                                                j += taskForKey2.bytesExpectedToReceiveMap.get(next).longValue();
                                            }
                                        }
                                    } else {
                                        z = false;
                                        j = 0;
                                        j2 = 0;
                                    }
                                    taskForKey2.bytesReceived = j2;
                                    taskForKey2.bytesExpectedToReceive = j;
                                    if (!taskForKey2.mFirstResumeCallback && (downloader = this) != null && downloader.listener != null) {
                                        this.listener.downloaderDidResume(this, taskForKey2, taskForKey2.bytesReceived, taskForKey2.bytesExpectedToReceive);
                                        taskForKey2.mFirstResumeCallback = true;
                                    }
                                    if (z) {
                                        long j3 = taskForKey2.bytesReceived;
                                        if (j3 > 0 && j3 == taskForKey2.bytesExpectedToReceive) {
                                            taskForKey2.availableLocalFilePath = str2;
                                            taskForKey2.downloadEnd();
                                            return;
                                        }
                                    }
                                    long currentTimeMillis = System.currentTimeMillis();
                                    long j4 = currentTimeMillis - taskForKey2.updateTs;
                                    if (j4 > 1000) {
                                        long freeSize = TTHelper.getFreeSize(Downloader.this.mContext);
                                        TTVideoEngineLog.i("TTVideoEngine.Downloader", "[downloader] get free size, size = " + freeSize);
                                        if (freeSize <= Downloader.this.getLimitFreeDiskSize()) {
                                            taskForKey2.receiveError(new Error("kTTVideoErrorDomainDownload", -9947, 0, "available size is less than " + Downloader.this.getLimitFreeDiskSize() + " Byte"));
                                            if (taskForKey2.mediaKeys != null) {
                                                for (int i3 = 0; i3 < taskForKey2.mediaKeys.size(); i3++) {
                                                    DataLoaderHelper.getDataLoader().suspendedDownload(taskForKey2.mediaKeys.get(i3));
                                                }
                                                return;
                                            }
                                            return;
                                        }
                                    }
                                    if (taskForKey2.updateTs < 1 || j4 >= 1000) {
                                        TTVideoEngineLog.i("TTVideoEngine.Downloader", "[downloader] notify listener. key = " + str);
                                        Downloader downloader2 = this;
                                        if (downloader2 != null && downloader2.listener != null && taskForKey2.getState() != 3) {
                                            this.listener.downloaderWriteData(this, taskForKey2, taskForKey2.bytesReceived - taskForKey2.updateBytesReceived, j4);
                                            this.listener.downloaderProgress(this, taskForKey2, taskForKey2.bytesReceived, taskForKey2.bytesExpectedToReceive);
                                        }
                                        taskForKey2.updateTs = currentTimeMillis;
                                        taskForKey2.updateBytesReceived = taskForKey2.bytesReceived;
                                        return;
                                    }
                                    return;
                                }
                                TTVideoEngineLog.i("TTVideoEngine.Downloader", "[downloader] task should suspend. key = " + str + ", state = " + taskForKey2.getState());
                                DataLoaderHelper.getDataLoader().suspendedDownload(str);
                                Downloader.this.tryNextWaitingTask(taskForKey2);
                                return;
                            } catch (Throwable th) {
                                TTVideoEngineLog.d(th);
                                return;
                            }
                        }
                        if (i != 5) {
                            if (i == 4 && this.listener != null) {
                                ArrayList arrayList4 = new ArrayList(this.temLoadedTasks);
                                if (arrayList4.size() > 0) {
                                    this.maxTaskId = ((DownloadTask) arrayList4.get(arrayList4.size() - 1)).taskIdentifier;
                                }
                                Iterator it4 = arrayList4.iterator();
                                while (it4.hasNext()) {
                                    this.indexArray.add(Long.valueOf(((DownloadTask) it4.next()).taskIdentifier));
                                }
                                this.allTasks.clear();
                                this.allTasks.addAll(arrayList4);
                                this.readAllTask = true;
                                this.loadData = false;
                                TTVideoEngineLog.d("TTVideoEngine.Downloader", "[downloader] did load alltask. size = " + arrayList4.size());
                                this.listener.downloaderDidLoadAllTask(this, arrayList4, null);
                                return;
                            }
                            return;
                        }
                        this.loadData = false;
                        TTVideoEngineLog.e("TTVideoEngine.Downloader", "[downloader] create KV db fail");
                        if (this.listener != null) {
                            this.listener.downloaderDidLoadAllTask(this, null, new Error("kTTVideoErrorDomainDownload", -9943, 0, "create kv db fail"));
                            return;
                        }
                        return;
                    }
                    DownloadTask taskForKey3 = Downloader.this.taskForKey((String) message.obj);
                    if (taskForKey3 != null) {
                        if (taskForKey3.getState() != 5 && taskForKey3.getState() != 3) {
                            taskForKey3.setState(3);
                        }
                        TTVideoEngineLog.d("TTVideoEngine.Downloader", "[downloader] task did suspended " + taskForKey3.toString());
                        Downloader.this.tryNextWaitingTask(taskForKey3);
                    }
                } catch (Throwable th2) {
                    TTVideoEngineLog.d(th2);
                }
            }
        };
    }

    public void invalidateAndCancelAllTasks() {
        ArrayList<DownloadTask> arrayList = this.allTasks;
        if (arrayList == null) {
            return;
        }
        Iterator<DownloadTask> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            DownloadTask next = it2.next();
            if (next != null) {
                next.invalidateAndCancel();
            }
        }
    }

    public void suspendAllTasks() {
        ArrayList<DownloadTask> arrayList = this.allTasks;
        if (arrayList == null) {
            return;
        }
        Iterator<DownloadTask> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            DownloadTask next = it2.next();
            if (next != null) {
                next.suspend();
            }
        }
    }

    private static class TaskThread {
        private Handler mHandler;
        private HandlerThread mHandlerThread;

        static {
            Covode.recordClassIndex(652432);
        }

        public TaskThread() {
            try {
                HandlerThread handlerThread = new HandlerThread("vcloud.engine.download.tasks");
                this.mHandlerThread = handlerThread;
                handlerThread.start();
                this.mHandler = new HandlerDelegate(this.mHandlerThread.getLooper()) { // from class: com.ss.ttvideoengine.download.Downloader.TaskThread.1
                    public void handleMessage(Message message) {
                        SaveInfos saveInfos;
                        try {
                            Object obj = message.obj;
                            if (!(obj instanceof ArrayList)) {
                                TTVideoEngineLog.d("TTVideoEngine.Downloader", "[downloader] obj should instance of ArrayList");
                                return;
                            }
                            ArrayList arrayList = (ArrayList) obj;
                            Downloader downloader = (Downloader) arrayList.get(0);
                            int i = message.what;
                            if (i != 10) {
                                if (i != 11 || arrayList.size() != 2 || (saveInfos = (SaveInfos) arrayList.get(1)) == null) {
                                    return;
                                }
                                downloader.writeTask(saveInfos.task, saveInfos.alltasks);
                                return;
                            }
                            downloader.dbObject = new KVDBManager(downloader.mContext, "TTVideoEngine_download_database_v01");
                            if (!downloader.dbObject.isCreateDBSuccess()) {
                                if (downloader.mHandler != null) {
                                    downloader.mHandler.sendMessage(Message.obtain(downloader.mHandler, 5));
                                }
                            } else {
                                TTVideoEngineLog.d("TTVideoEngine.Downloader", "[downloader] open db success");
                                downloader.temLoadedTasks = downloader._loadAllTasks();
                                if (downloader.mHandler != null) {
                                    downloader.mHandler.sendMessage(Message.obtain(downloader.mHandler, 4));
                                }
                            }
                        } catch (Throwable th) {
                            TTVideoEngineLog.d(th);
                        }
                    }
                };
            } catch (Throwable th) {
                TTVideoEngineLog.d(th);
                this.mHandlerThread = null;
                this.mHandler = null;
            }
        }

        public void postMessage(ArrayList<Object> arrayList, int i) {
            if (this.mHandler != null && this.mHandlerThread != null) {
                Message obtain = Message.obtain();
                obtain.what = i;
                obtain.obj = arrayList;
                this.mHandler.sendMessage(obtain);
            }
        }
    }

    public void resumeAllTasks() {
        ArrayList<DownloadTask> arrayList = this.allTasks;
        if (arrayList == null) {
            return;
        }
        Iterator<DownloadTask> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            DownloadTask next = it2.next();
            if (next != null && (next.getState() == 3 || next.getState() == 0)) {
                next.resume();
            }
        }
    }

    private Downloader() {
        this.maxDownloadOperationCount = 0L;
        this.limitFreeDiskSize = 1073741824L;
        this.maxTaskId = 0L;
        this.allTasks = null;
        this.waitingTasks = null;
        this.runingTasks = null;
        this.indexArray = null;
        this.readAllTask = false;
        this.maxTaskId = -1L;
        this.allTasks = new ArrayList<>();
        this.indexArray = new ArrayList<>();
        this.waitingTasks = new ArrayList<>();
        this.runingTasks = new ArrayList<>();
        this.maxDownloadOperationCount = 1L;
        this.limitFreeDiskSize = 1073741824L;
        this.readAllTask = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x004e, code lost:
    
        if (r7.size() <= r5.size()) goto L21;
     */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0161 A[Catch: all -> 0x01c8, TryCatch #5 {all -> 0x01c8, blocks: (B:38:0x0155, B:40:0x0161, B:42:0x0169, B:45:0x0170, B:46:0x0175, B:48:0x017b, B:49:0x017f, B:50:0x0182, B:52:0x0186, B:54:0x018a, B:55:0x018d, B:57:0x0194, B:58:0x0197, B:60:0x019e, B:62:0x01a6), top: B:37:0x0155 }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0194 A[Catch: all -> 0x01c8, TryCatch #5 {all -> 0x01c8, blocks: (B:38:0x0155, B:40:0x0161, B:42:0x0169, B:45:0x0170, B:46:0x0175, B:48:0x017b, B:49:0x017f, B:50:0x0182, B:52:0x0186, B:54:0x018a, B:55:0x018d, B:57:0x0194, B:58:0x0197, B:60:0x019e, B:62:0x01a6), top: B:37:0x0155 }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x019e A[Catch: all -> 0x01c8, TryCatch #5 {all -> 0x01c8, blocks: (B:38:0x0155, B:40:0x0161, B:42:0x0169, B:45:0x0170, B:46:0x0175, B:48:0x017b, B:49:0x017f, B:50:0x0182, B:52:0x0186, B:54:0x018a, B:55:0x018d, B:57:0x0194, B:58:0x0197, B:60:0x019e, B:62:0x01a6), top: B:37:0x0155 }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01b7 A[Catch: all -> 0x01c6, TRY_LEAVE, TryCatch #4 {all -> 0x01c6, blocks: (B:65:0x01ab, B:66:0x01b0, B:68:0x01b7), top: B:64:0x01ab }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.util.ArrayList<com.ss.ttvideoengine.download.DownloadTask> _loadAllTasks() {
        /*
            Method dump skipped, instructions count: 489
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.ttvideoengine.download.Downloader._loadAllTasks():java.util.ArrayList");
    }

    public void setLimitFreeDiskSize(long j) {
        this.limitFreeDiskSize = j;
    }

    public void setListener(IDownloaderListener iDownloaderListener) {
        this.listener = iDownloaderListener;
    }

    public void setMaxDownloadOperationCount(long j) {
        this.maxDownloadOperationCount = j;
    }

    private class SaveInfos {
        ArrayList<DownloadTask> alltasks;
        DownloadTask task;

        static {
            Covode.recordClassIndex(652431);
        }

        private SaveInfos() {
            this.task = null;
            this.alltasks = null;
        }
    }

    public void downloadDidSuspened(String str) {
        Handler handler;
        if (!TextUtils.isEmpty(str) && (handler = this.mHandler) != null) {
            handler.sendMessage(Message.obtain(handler, 2, str));
        }
    }

    public void progress(String str) {
        Handler handler;
        if (!TextUtils.isEmpty(str) && (handler = this.mHandler) != null) {
            handler.sendMessage(Message.obtain(handler, 0, str));
        }
    }

    public void setEnableVidTaskSuspendReleaseSlot(boolean z) {
        TTVideoEngineLog.d("TTVideoEngine.Downloader", "[downloader] set enable vid task suspend release slot:" + z);
        this.mEnableVidTaskSuspendReleaseSlot = z;
    }

    private String indexToString(ArrayList<Long> arrayList) {
        if (arrayList != null) {
            StringBuilder sb = new StringBuilder(arrayList.size());
            for (int i = 0; i < arrayList.size(); i++) {
                sb.append(arrayList.get(i));
                if (i < arrayList.size() - 1) {
                    sb.append(",");
                }
            }
            return sb.toString();
        }
        return null;
    }

    private void saveTaskInfo(DownloadTask downloadTask) {
        SaveInfos saveInfos = new SaveInfos();
        saveInfos.task = downloadTask;
        saveInfos.alltasks = new ArrayList<>(this.allTasks);
        ArrayList<Object> arrayList = new ArrayList<>();
        arrayList.add(this);
        arrayList.add(saveInfos);
        this.taskThread.postMessage(arrayList, 11);
    }

    private ArrayList<String> stringToStringArray(String str) {
        ArrayList<String> arrayList = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            String[] split = str.split(",");
            if (split == null || split.length <= 0) {
                return null;
            }
            ArrayList<String> arrayList2 = new ArrayList<>();
            try {
                for (String str2 : split) {
                    if (!TextUtils.isEmpty(str2)) {
                        arrayList2.add(str2);
                    }
                }
                return arrayList2;
            } catch (Throwable th) {
                th = th;
                arrayList = arrayList2;
                TTVideoEngineLog.d(th);
                return arrayList;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    void cancel(DownloadTask downloadTask) {
        this.allTasks.remove(downloadTask);
        this.indexArray.remove(Long.valueOf(downloadTask.taskIdentifier));
        this.waitingTasks.remove(downloadTask);
        downloadTask.receiveError(new Error("kTTVideoErrorDomainDownload", -9995, 0, "task info: " + downloadTask.toString()));
    }

    boolean suspended(DownloadTask downloadTask) {
        if (this.waitingTasks.contains(downloadTask)) {
            this.waitingTasks.remove(downloadTask);
            TTVideoEngineLog.d("TTVideoEngine.Downloader", "[downloader] task is waiting. key =" + downloadTask.toString());
            downloadTask.setState(3);
            return true;
        }
        return true;
    }

    private DownloadTask addTask(DownloadTask downloadTask) {
        DownloadTask downloadTask2;
        Throwable th;
        downloadTask.setDownloader(this);
        try {
            if (this.readAllTask) {
                if (this.allTasks.contains(downloadTask)) {
                    downloadTask2 = this.allTasks.get(this.allTasks.indexOf(downloadTask));
                    try {
                        downloadTask2.setDownloader(this);
                        return downloadTask2;
                    } catch (Throwable th2) {
                        th = th2;
                        try {
                            TTVideoEngineLog.d(th);
                        } catch (Throwable unused) {
                        }
                        return downloadTask2;
                    }
                }
                long j = this.maxTaskId + 1;
                this.maxTaskId = j;
                downloadTask.taskIdentifier = j;
                if (this.indexArray.contains(Long.valueOf(j))) {
                    TTVideoEngineLog.e("TTVideoEngine.Downloader", "[downloader] add task fail. taskIdentifier = " + this.maxTaskId);
                    downloadTask = null;
                } else {
                    this.indexArray.add(Long.valueOf(this.maxTaskId));
                    this.allTasks.add(downloadTask);
                }
                saveTaskInfo(downloadTask);
                return downloadTask;
            }
            TTVideoEngineLog.e("TTVideoEngine.Downloader", "[downloader] should load all tasks first.");
            return null;
        } catch (Throwable th3) {
            downloadTask2 = downloadTask;
            th = th3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadTask taskForKey(String str) {
        DownloadTask downloadTask = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Iterator it2 = new ArrayList(this.allTasks).iterator();
        while (it2.hasNext()) {
            DownloadTask downloadTask2 = (DownloadTask) it2.next();
            ArrayList<String> arrayList = downloadTask2.mediaKeys;
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<String> it4 = downloadTask2.mediaKeys.iterator();
                while (true) {
                    if (!it4.hasNext()) {
                        break;
                    }
                    if (str.equals(it4.next())) {
                        downloadTask = downloadTask2;
                        break;
                    }
                }
            }
            if (downloadTask != null) {
                break;
            }
        }
        return downloadTask;
    }

    private void writeIndexesToDisk(ArrayList<DownloadTask> arrayList) {
        ArrayList<Long> arrayList2 = new ArrayList<>();
        Iterator<DownloadTask> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            DownloadTask next = it2.next();
            if (!arrayList2.contains(Long.valueOf(next.taskIdentifier))) {
                arrayList2.add(Long.valueOf(next.taskIdentifier));
            }
        }
        Collections.sort(arrayList2);
        String indexToString = indexToString(arrayList2);
        this.dbObject.save("index", indexToString);
        SharedPreferences.Editor edit = this.mContext.getSharedPreferences("TTVideoEngine_download_index_v01", 0).edit();
        edit.putString("index", indexToString);
        edit.commit();
    }

    public void loadAllTasks(Context context) {
        if (context == null) {
            TTVideoEngineLog.e("TTVideoEngine.Downloader", "[downloader] context == null");
            IDownloaderListener iDownloaderListener = this.listener;
            if (iDownloaderListener != null) {
                iDownloaderListener.downloaderDidLoadAllTask(this, null, new Error("kTTVideoErrorDomainDownload", -9999, 0, "context is null"));
                return;
            }
            return;
        }
        if (!DataLoaderHelper.getDataLoader().isRunning()) {
            TTVideoEngineLog.e("TTVideoEngine.Downloader", "[downloader] need start dataloader first.");
            IDownloaderListener iDownloaderListener2 = this.listener;
            if (iDownloaderListener2 != null) {
                iDownloaderListener2.downloaderDidLoadAllTask(this, null, new Error("kTTVideoErrorDomainDownload", -9946, 0, "need start medialoader"));
                return;
            }
            return;
        }
        if (this.readAllTask) {
            if (this.listener != null) {
                this.listener.downloaderDidLoadAllTask(this, new ArrayList(this.allTasks), null);
                return;
            }
            return;
        }
        if (!this.loadData) {
            this.loadData = true;
            this.mContext = context;
            initHandle();
            ArrayList<Object> arrayList = new ArrayList<>();
            arrayList.add(this);
            this.taskThread.postMessage(arrayList, 10);
        }
    }

    void resume(DownloadTask downloadTask) {
        IDownloaderListener iDownloaderListener;
        if (!FeatureManager.hasPermission()) {
            return;
        }
        if (!this.runingTasks.contains(downloadTask)) {
            this.runingTasks.add(downloadTask);
        }
        if (this.waitingTasks.contains(downloadTask)) {
            TTVideoEngineLog.i("TTVideoEngine.Downloader", "[downloader] resume task. is waiting,  task = " + downloadTask.toString());
            this.waitingTasks.remove(downloadTask);
        }
        long j = downloadTask.bytesReceived;
        if (j >= 1) {
            long j2 = downloadTask.bytesExpectedToReceive;
            if (j2 >= 1 && (iDownloaderListener = this.listener) != null) {
                iDownloaderListener.downloaderDidResume(this, downloadTask, j, j2);
            }
        }
    }

    void tryNextWaitingTask(DownloadTask downloadTask) {
        if (this.runingTasks.contains(downloadTask)) {
            this.runingTasks.remove(downloadTask);
        }
        if (this.runingTasks.size() >= this.maxDownloadOperationCount) {
            TTVideoEngineLog.d("TTVideoEngine.Downloader", "[downloader] running task count is " + this.runingTasks.size() + " max count is " + this.maxDownloadOperationCount);
            return;
        }
        if (this.waitingTasks.size() < 1) {
            TTVideoEngineLog.d("TTVideoEngine.Downloader", "[downloader] waiting task is empty");
            return;
        }
        DownloadTask downloadTask2 = this.waitingTasks.get(0);
        this.waitingTasks.remove(downloadTask2);
        downloadTask2.resume();
        TTVideoEngineLog.d("TTVideoEngine.Downloader", "[downloader] auto resume waiting task: " + downloadTask2.toString());
    }

    boolean shouldResume(DownloadTask downloadTask) {
        if (this.runingTasks.size() >= this.maxDownloadOperationCount && (!this.runingTasks.contains(downloadTask) || (downloadTask.getState() != 3 && downloadTask.getState() != 5))) {
            downloadTask.setState(1);
            if (!this.waitingTasks.contains(downloadTask)) {
                this.waitingTasks.add(downloadTask);
            }
            TTVideoEngineLog.d("TTVideoEngine.Downloader", "[downloader] task is waiting, task info " + downloadTask.toString());
            return false;
        }
        long freeSize = TTHelper.getFreeSize(this.mContext);
        TTVideoEngineLog.i("TTVideoEngine.Downloader", "[downloader] get free size, size = " + freeSize + ", limite = " + getLimitFreeDiskSize());
        if (freeSize > getLimitFreeDiskSize()) {
            return true;
        }
        downloadTask.receiveError(new Error("kTTVideoErrorDomainDownload", -9947, 0, "available size is less than 1073741824 M"));
        return false;
    }

    public void setOption(int i, long j) {
        if (i == 1) {
            this.mPerfGetCacheInfo = j;
        }
    }

    public DownloadVidTask vidTask(VideoModel videoModel, Resolution resolution) {
        if (!FeatureManager.hasPermission()) {
            return null;
        }
        DownloadVidTask taskItem = DownloadVidTask.taskItem(videoModel, resolution);
        if (taskItem != null && (taskItem = (DownloadVidTask) addTask(taskItem)) != null) {
            taskItem.mContext = this.mContext;
            taskItem.setVideoModel(videoModel);
        }
        return taskItem;
    }

    public void downloadFail(String str, Error error) {
        if (!TextUtils.isEmpty(str) && error != null && this.mHandler != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            arrayList.add(error);
            Handler handler = this.mHandler;
            handler.sendMessage(Message.obtain(handler, 1, arrayList));
        }
    }

    void completeError(DownloadTask downloadTask, Error error) {
        if (downloadTask.finished && !downloadTask.canceled) {
            TTVideoEngineLog.d("TTVideoEngine.Downloader", "[downloader] task did finished, info = " + downloadTask.toString());
            return;
        }
        if (error != null) {
            TTVideoEngineLog.d("TTVideoEngine.Downloader", "[downloader] error info " + error.toString());
        }
        downloadTask.finished = true;
        saveTaskInfo(downloadTask);
        IDownloaderListener iDownloaderListener = this.listener;
        if (iDownloaderListener != null) {
            iDownloaderListener.downloaderDidComplete(this, downloadTask, error);
        }
        TTVideoEngineLog.d("TTVideoEngine.Downloader", "[downloader] task complete, task info = " + downloadTask.toString());
        tryNextWaitingTask(downloadTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void writeTask(DownloadTask downloadTask, ArrayList<DownloadTask> arrayList) {
        writeIndexesToDisk(arrayList);
        String jSONObject = downloadTask.jsonObject().toString();
        String valueOf = String.valueOf(downloadTask.taskIdentifier);
        TTVideoEngineLog.i("TTVideoEngine.Downloader", "[downloader] write task. key " + valueOf + " value: " + jSONObject);
        if (arrayList.contains(downloadTask)) {
            if (!this.dbObject.save(valueOf, jSONObject)) {
                TTVideoEngineLog.e("TTVideoEngine.Downloader", "[downloader] save task fail, videoid = " + downloadTask.videoId + " taskIdentifier = " + downloadTask.taskIdentifier);
                downloadTask.receiveError(new Error("kTTVideoErrorDomainDownload", -9949, -1, jSONObject));
                return;
            }
            return;
        }
        if (!this.dbObject.remove(valueOf)) {
            TTVideoEngineLog.e("TTVideoEngine.Downloader", "[downloader] remove task fail, videoid = " + downloadTask.videoId + " taskIdentifier = " + downloadTask.taskIdentifier);
            downloadTask.receiveError(new Error("kTTVideoErrorDomainDownload", -9949, -1, jSONObject));
        }
    }

    public DownloadVidTask vidTask(String str, Resolution resolution, String str2) {
        return vidTask(str, resolution, null, false, false, str2);
    }

    public DownloadURLTask urlTask(String[] strArr, String str, String str2) {
        if (!FeatureManager.hasPermission()) {
            return null;
        }
        if (strArr != null && strArr.length >= 1 && !TextUtils.isEmpty(str)) {
            ArrayList<String> arrayList = new ArrayList<>();
            for (String str3 : strArr) {
                arrayList.add(str3);
            }
            DownloadURLTask taskItem = DownloadURLTask.taskItem(str, arrayList, str2);
            if (taskItem != null && (taskItem = (DownloadURLTask) addTask(taskItem)) != null) {
                taskItem.updateUrls(arrayList);
            }
            return taskItem;
        }
        TTVideoEngineLog.e("TTVideoEngine.Downloader", "[downloader] urls or key is invalid.");
        return null;
    }

    public DownloadURLTask urlTask(String[] strArr, String str, String str2, DownloadTask.EncryptVersion encryptVersion) {
        if (!FeatureManager.hasPermission()) {
            return null;
        }
        if (strArr != null && strArr.length >= 1 && !TextUtils.isEmpty(str)) {
            ArrayList<String> arrayList = new ArrayList<>();
            Collections.addAll(arrayList, strArr);
            DownloadURLTask taskItem = DownloadURLTask.taskItem(str, arrayList, str2, encryptVersion);
            if (taskItem != null && (taskItem = (DownloadURLTask) addTask(taskItem)) != null) {
                taskItem.updateUrls(arrayList);
            }
            return taskItem;
        }
        TTVideoEngineLog.e("TTVideoEngine.Downloader", "[downloader] urls or key is invalid.");
        return null;
    }

    public DownloadVidTask vidTask(String str, Resolution resolution, String str2, boolean z, boolean z2) {
        return vidTask(str, resolution, str2, z, z2, null);
    }

    public DownloadVidTask vidTask(String str, Resolution resolution, boolean z, boolean z2, boolean z3) {
        String str2;
        if (!FeatureManager.hasPermission()) {
            return null;
        }
        if (z) {
            str2 = "bytevc1";
        } else {
            str2 = "h264";
        }
        return vidTask(str, resolution, str2, z2, z3);
    }

    public DownloadVidTask vidTask(String str, Resolution resolution, String str2, boolean z, boolean z2, String str3) {
        if (!FeatureManager.hasPermission()) {
            return null;
        }
        DownloadVidTask taskItem = DownloadVidTask.taskItem(str, resolution, str2, z, z2, str3);
        if (taskItem != null && (taskItem = (DownloadVidTask) addTask(taskItem)) != null) {
            taskItem.mContext = this.mContext;
        }
        return taskItem;
    }
}
