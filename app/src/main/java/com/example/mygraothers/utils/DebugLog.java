package com.example.mygraothers.utils;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;

import com.example.mygraothers.base.IOSAlertDialog;

import java.io.IOException;

public class DebugLog {
    private static IOSAlertDialog iosAlertDialog;

    public static void clearLogFiles() {
        String dir = ExternalStorageUtils.getDir(ExternalStorageUtils.DIR_LOG);
        try {
            FileUtils.deleteFolderFile(dir, false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void showIOSAlert(Context context, String title, @NonNull String content, String btLeftInfo, String btRightInfo, View.OnClickListener negListener,
                                    View.OnClickListener posListener) {
        if (iosAlertDialog != null && iosAlertDialog.isShowing()) {
            iosAlertDialog.dismiss();
            iosAlertDialog = null;
        }
        iosAlertDialog = new IOSAlertDialog(context).builder();
        iosAlertDialog.setGone();
        if (!TextUtils.isEmpty(title)) {
            iosAlertDialog.setTitle(title);
        }
        iosAlertDialog.setMsg(content);
        if (negListener != null) {
            iosAlertDialog.setNegativeButton(btLeftInfo, negListener);
        }
        if (posListener != null) {
            iosAlertDialog.setPositiveButton(btRightInfo, posListener);
        }
        if (posListener == null && negListener == null) {
            iosAlertDialog.setPositiveButton("知道了", null);
        }
        iosAlertDialog.show();
    }

}
