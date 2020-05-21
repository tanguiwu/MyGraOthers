package com.example.mygraothers.utils;

import android.os.Environment;
import android.text.TextUtils;

import java.io.File;

/**
 * Environment .getExternalStorageDirectory()
 *
 * @author shaxiaoning
 */
public class ExternalStorageUtils {
    public final static String DIR_IMAGE = "image";
    public final static String DIR_DOWNLOAD = "download";
    public final static String DIR_AUDIO = "audio";
    public final static String DIR_TMP = "tmp";
    public final static String DIR_CACHE = "cache";
    public final static String DIR_WEBVIEW_CACHE = "webview_cache";
    public final static String DIR_FACE = "face";
    public final static String DIR_ASSETS = "assets";
    public final static String DIR_LOG = "log";


    private static String locationPath = null;

    // private String namespace = null;

    public ExternalStorageUtils(String namespace, String directory) {
        init(namespace, directory);
    }

    private void init(String namespace, String directory) {
        String path = null;
        path = Environment.getExternalStorageDirectory().getAbsolutePath();
        String tmpPath = path + File.separator + namespace;
        if (!TextUtils.isEmpty(directory)) {
            tmpPath += File.separator + directory;
        }

        File file = new File(tmpPath);
        if (!file.exists())
            file.mkdirs();
        locationPath = tmpPath + File.separator;
    }

    /**
     * @return
     */
    public static String envExternalStorageDirectory() {
        return locationPath != null ? locationPath : null;
    }

    /**
     * 获取一个路径，如果不存在则新建
     *
     * @param dir
     * @return
     */
    public static String getDir(String dir) {
        File workDir = new File(envExternalStorageDirectory());

        if (dir.length() == 0) {
            return workDir.getPath() + "/";
        } else {
            File newDir = new File(workDir, dir);
            if (!newDir.exists()) {
                newDir.mkdirs();
            }
            return newDir.getPath() + "/";
        }
    }
}
