package com.paulkg12.t61.util;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.widget.Toast;

import com.paulkg12.t61.R;
import com.paulkg12.t61.ui.activity.ViewerActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AppOpener {

    public static void launchUrl(@NonNull Context context, @NonNull Uri uri) {
        if (StringUtils.isBlank(uri.toString())) return;
        String url = uri.toString();
        if (GitHubHelper.isImage(url)) {
            ViewerActivity.showImage(context, url);
            return;
        }
        openInBrowser(context, url);
    }
    public static void openInBrowser(@NonNull Context context, @NonNull String url){
        Uri uri = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri).addCategory(Intent.CATEGORY_BROWSABLE);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent = createActivityChooserIntent(context, intent, uri, VIEW_IGNORE_PACKAGE);
        if(intent != null){
            context.startActivity(intent);
        } else {
            Toast.makeText(context, "no browser clients", Toast.LENGTH_SHORT).show();
        }
    }

    private static Intent createActivityChooserIntent(Context context, Intent intent,
                                                      Uri uri, List<String> ignorPackageList) {
        final PackageManager pm = context.getPackageManager();
        final List<ResolveInfo> activities = pm.queryIntentActivities(intent,
                PackageManager.MATCH_DEFAULT_ONLY);
        final ArrayList<Intent> chooserIntents = new ArrayList<>();
        final String ourPackageName = context.getPackageName();

        Collections.sort(activities, new ResolveInfo.DisplayNameComparator(pm));

        for (ResolveInfo resInfo : activities) {
            ActivityInfo info = resInfo.activityInfo;
            if (!info.enabled || !info.exported) {
                continue;
            }
            if (info.packageName.equals(ourPackageName)) {
                continue;
            }
            if (ignorPackageList != null && ignorPackageList.contains(info.packageName)) {
                continue;
            }

            Intent targetIntent = new Intent(intent);
            targetIntent.setPackage(info.packageName);
            targetIntent.setDataAndType(uri, intent.getType());
            chooserIntents.add(targetIntent);
        }

        if (chooserIntents.isEmpty()) {
            return null;
        }

        final Intent lastIntent = chooserIntents.remove(chooserIntents.size() - 1);
        if (chooserIntents.isEmpty()) {
            // there was only one, no need to showImage the chooser
            return lastIntent;
        }

        Intent chooserIntent = Intent.createChooser(lastIntent, null);
        chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS,
                chooserIntents.toArray(new Intent[chooserIntents.size()]));
        return chooserIntent;
    }

    private static final List<String> VIEW_IGNORE_PACKAGE = Arrays.asList(
            "com.gh4a", "com.fastaccess", "com.taobao.taobao"
    );
}
