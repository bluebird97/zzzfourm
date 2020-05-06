[TOC]

# zzz forum

a anonymous forum for zzz, no user id, no central database(github private repo issue as database)

# current stage:

next:  run on phone

- fix: 根项目的build.gradle 和 本机的gradle 配置文件，现在我可以下载来自国内阿里和jetpack 的lib 了。
- fix: FragmentComponent injection.
- fix: EditLabelDialog
- fix: LabelManageActivity -> ChooseLabelsDialog and the Fuking labels  -> EditIssueActivity 
- fix: EditIssueActivity
- add: res.layout/menu
- fix: ViewerActivity
- add: SingleFragmentActivity
- fix: most part of: IssueTimelineAdapter
- add: dependency: de.hdodenhof.CircleImageView
- add: CircleBackgroundImageView
- add: IssueTimelineFragment                    
- fix: FragmentPagerModel
- fix: err in BasePresenter
- add: inject part < dagger part < IOC part
- add: ui.activity.base.PagerActivity
- presenter.IssuesActPresenter;
- finish model.filter.IssuesFilter;
- finish Issue.java, User.java, Label.java
- add mvp.modle.Issue and understand Parcelable
- adding mvp, basic


# bug

## login aty failed

```
2020-04-26 22:03:43.793 5530-5530/com.paulkg12.t61 E/AndroidRuntime: FATAL EXCEPTION: main
    Process: com.paulkg12.t61, PID: 5530
    java.lang.RuntimeException: Unable to start activity ComponentInfo{com.paulkg12.t61/com.paulkg12.t61.ui.activity.LoginActivity}: android.view.InflateException: Binary XML file line #16: Binary XML file line #16: Error inflating class android.support.v7.widget.CardView
        at android.app.ActivityThread.performLaunchActivity(ActivityThread.java:3114)
        at android.app.ActivityThread.handleLaunchActivity(ActivityThread.java:3257)
        at android.app.servertransaction.LaunchActivityItem.execute(LaunchActivityItem.java:78)
        at android.app.servertransaction.TransactionExecutor.executeCallbacks(TransactionExecutor.java:108)
        at android.app.servertransaction.TransactionExecutor.execute(TransactionExecutor.java:68)
        at android.app.ActivityThread$H.handleMessage(ActivityThread.java:1948)
        at android.os.Handler.dispatchMessage(Handler.java:106)
        at android.os.Looper.loop(Looper.java:214)
        at android.app.ActivityThread.main(ActivityThread.java:7050)
        at java.lang.reflect.Method.invoke(Native Method)
        at com.android.internal.os.RuntimeInit$MethodAndArgsCaller.run(RuntimeInit.java:494)
        at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:965)
     Caused by: android.view.InflateException: Binary XML file line #16: Binary XML file line #16: Error inflating class android.support.v7.widget.CardView
     Caused by: android.view.InflateException: Binary XML file line #16: Error inflating class android.support.v7.widget.CardView
     Caused by: java.lang.reflect.InvocationTargetException
        at java.lang.reflect.Constructor.newInstance0(Native Method)
        at java.lang.reflect.Constructor.newInstance(Constructor.java:343)
        at android.view.LayoutInflater.createView(LayoutInflater.java:647)
        at android.view.LayoutInflater.createViewFromTag(LayoutInflater.java:790)
        at android.view.LayoutInflater.createViewFromTag(LayoutInflater.java:730)
        at android.view.LayoutInflater.rInflate(LayoutInflater.java:863)
        at android.view.LayoutInflater.rInflateChildren(LayoutInflater.java:824)
        at android.view.LayoutInflater.inflate(LayoutInflater.java:515)
        at android.view.LayoutInflater.inflate(LayoutInflater.java:423)
        at android.view.LayoutInflater.inflate(LayoutInflater.java:374)
        at android.support.v7.app.AppCompatDelegateImplV9.setContentView(AppCompatDelegateImplV9.java:292)
        at android.support.v7.app.AppCompatActivity.setContentView(AppCompatActivity.java:140)
        at com.paulkg12.t61.ui.activity.base.BaseActivity.onCreate(BaseActivity.java:96)
        at android.app.Activity.performCreate(Activity.java:7327)
        at android.app.Activity.performCreate(Activity.java:7318)
        at android.app.Instrumentation.callActivityOnCreate(Instrumentation.java:1271)
        at android.app.ActivityThread.performLaunchActivity(ActivityThread.java:3094)
        at android.app.ActivityThread.handleLaunchActivity(ActivityThread.java:3257)
        at android.app.servertransaction.LaunchActivityItem.execute(LaunchActivityItem.java:78)
        at android.app.servertransaction.TransactionExecutor.executeCallbacks(TransactionExecutor.java:108)
        at android.app.servertransaction.TransactionExecutor.execute(TransactionExecutor.java:68)
        at android.app.ActivityThread$H.handleMessage(ActivityThread.java:1948)
        at android.os.Handler.dispatchMessage(Handler.java:106)
        at android.os.Looper.loop(Looper.java:214)
        at android.app.ActivityThread.main(ActivityThread.java:7050)
        at java.lang.reflect.Method.invoke(Native Method)
        at com.android.internal.os.RuntimeInit$MethodAndArgsCaller.run(RuntimeInit.java:494)
        at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:965)
     Caused by: java.lang.UnsupportedOperationException: Failed to resolve attribute at index 13: TypedValue{t=0x2/d=0x7f040051 a=-1}
        at android.content.res.TypedArray.getDrawableForDensity(TypedArray.java:946)
        at android.content.res.TypedArray.getDrawable(TypedArray.java:930)
        at android.view.View.<init>(View.java:5455)
        at android.view.ViewGroup.<init>(ViewGroup.java:660)
        at android.widget.FrameLayout.<init>(FrameLayout.java:92)
2020-04-26 22:03:43.793 5530-5530/com.paulkg12.t61 E/AndroidRuntime:     at android.widget.FrameLayout.<init>(FrameLayout.java:87)
        at android.widget.FrameLayout.<init>(FrameLayout.java:82)
        at android.support.v7.widget.CardView.<init>(CardView.java:115)
        	... 28 more

---

2020-04-26 21:59:56.796 785-785/? E/AndroidRuntime: FATAL EXCEPTION: main
    Process: com.paulkg12.t61, PID: 785
    java.lang.RuntimeException: Unable to start activity ComponentInfo{com.paulkg12.t61/com.paulkg12.t61.ui.activity.LoginActivity}: android.view.InflateException: Binary XML file line #33: Binary XML file line #33: Error inflating class <unknown>
        at android.app.ActivityThread.performLaunchActivity(ActivityThread.java:3114)
        at android.app.ActivityThread.handleLaunchActivity(ActivityThread.java:3257)
        at android.app.servertransaction.LaunchActivityItem.execute(LaunchActivityItem.java:78)
        at android.app.servertransaction.TransactionExecutor.executeCallbacks(TransactionExecutor.java:108)
        at android.app.servertransaction.TransactionExecutor.execute(TransactionExecutor.java:68)
        at android.app.ActivityThread$H.handleMessage(ActivityThread.java:1948)
        at android.os.Handler.dispatchMessage(Handler.java:106)
        at android.os.Looper.loop(Looper.java:214)
        at android.app.ActivityThread.main(ActivityThread.java:7050)
        at java.lang.reflect.Method.invoke(Native Method)
        at com.android.internal.os.RuntimeInit$MethodAndArgsCaller.run(RuntimeInit.java:494)
        at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:965)
     Caused by: android.view.InflateException: Binary XML file line #33: Binary XML file line #33: Error inflating class <unknown>
     Caused by: android.view.InflateException: Binary XML file line #33: Error inflating class <unknown>
     Caused by: java.lang.reflect.InvocationTargetException
        at java.lang.reflect.Constructor.newInstance0(Native Method)
        at java.lang.reflect.Constructor.newInstance(Constructor.java:343)
        at android.view.LayoutInflater.createView(LayoutInflater.java:647)
        at com.android.internal.policy.PhoneLayoutInflater.onCreateView(PhoneLayoutInflater.java:58)
        at android.view.LayoutInflater.onCreateView(LayoutInflater.java:720)
        at android.view.LayoutInflater.createViewFromTag(LayoutInflater.java:788)
        at android.view.LayoutInflater.createViewFromTag(LayoutInflater.java:730)
        at android.view.LayoutInflater.rInflate(LayoutInflater.java:863)
        at android.view.LayoutInflater.rInflateChildren(LayoutInflater.java:824)
        at android.view.LayoutInflater.rInflate(LayoutInflater.java:866)
        at android.view.LayoutInflater.rInflateChildren(LayoutInflater.java:824)
        at android.view.LayoutInflater.rInflate(LayoutInflater.java:866)
        at android.view.LayoutInflater.rInflateChildren(LayoutInflater.java:824)
        at android.view.LayoutInflater.inflate(LayoutInflater.java:515)
        at android.view.LayoutInflater.inflate(LayoutInflater.java:423)
        at android.view.LayoutInflater.inflate(LayoutInflater.java:374)
        at android.support.v7.app.AppCompatDelegateImplV9.setContentView(AppCompatDelegateImplV9.java:292)
        at android.support.v7.app.AppCompatActivity.setContentView(AppCompatActivity.java:140)
        at com.paulkg12.t61.ui.activity.base.BaseActivity.onCreate(BaseActivity.java:96)
        at android.app.Activity.performCreate(Activity.java:7327)
        at android.app.Activity.performCreate(Activity.java:7318)
        at android.app.Instrumentation.callActivityOnCreate(Instrumentation.java:1271)
        at android.app.ActivityThread.performLaunchActivity(ActivityThread.java:3094)
        at android.app.ActivityThread.handleLaunchActivity(ActivityThread.java:3257)
        at android.app.servertransaction.LaunchActivityItem.execute(LaunchActivityItem.java:78)
        at android.app.servertransaction.TransactionExecutor.executeCallbacks(TransactionExecutor.java:108)
        at android.app.servertransaction.TransactionExecutor.execute(TransactionExecutor.java:68)
        at android.app.ActivityThread$H.handleMessage(ActivityThread.java:1948)
        at android.os.Handler.dispatchMessage(Handler.java:106)
        at android.os.Looper.loop(Looper.java:214)
        at android.app.ActivityThread.main(ActivityThread.java:7050)
        at java.lang.reflect.Method.invoke(Native Method)
        at com.android.internal.os.RuntimeInit$MethodAndArgsCaller.run(RuntimeInit.java:494)
        at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:965)
2020-04-26 21:59:56.797 785-785/? E/AndroidRuntime: Caused by: java.lang.UnsupportedOperationException: Failed to resolve attribute at index 13: TypedValue{t=0x2/d=0x7f040051 a=-1}
        at android.content.res.TypedArray.getDrawableForDensity(TypedArray.java:946)
        at android.content.res.TypedArray.getDrawable(TypedArray.java:930)
        at android.view.View.<init>(View.java:5455)
        at android.view.ViewGroup.<init>(ViewGroup.java:660)
        at android.widget.LinearLayout.<init>(LinearLayout.java:244)
        at android.widget.LinearLayout.<init>(LinearLayout.java:240)
        at android.widget.LinearLayout.<init>(LinearLayout.java:236)
        	... 34 more
---

todo 0426 fix me :

2020-04-26 22:17:15.038 14981-14981/com.paulkg12.t61 E/AndroidRuntime: FATAL EXCEPTION: main
    Process: com.paulkg12.t61, PID: 14981
    java.lang.RuntimeException: Unable to start activity ComponentInfo{com.paulkg12.t61/com.paulkg12.t61.ui.activity.LoginActivity}: android.view.InflateException: Binary XML file line #16: Binary XML file line #16: Error inflating class android.support.v7.widget.CardView
        at android.app.ActivityThread.performLaunchActivity(ActivityThread.java:3114)
        at android.app.ActivityThread.handleLaunchActivity(ActivityThread.java:3257)
        at android.app.servertransaction.LaunchActivityItem.execute(LaunchActivityItem.java:78)
        at android.app.servertransaction.TransactionExecutor.executeCallbacks(TransactionExecutor.java:108)
        at android.app.servertransaction.TransactionExecutor.execute(TransactionExecutor.java:68)
        at android.app.ActivityThread$H.handleMessage(ActivityThread.java:1948)
        at android.os.Handler.dispatchMessage(Handler.java:106)
        at android.os.Looper.loop(Looper.java:214)
        at android.app.ActivityThread.main(ActivityThread.java:7050)
        at java.lang.reflect.Method.invoke(Native Method)
        at com.android.internal.os.RuntimeInit$MethodAndArgsCaller.run(RuntimeInit.java:494)
        at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:965)
     Caused by: android.view.InflateException: Binary XML file line #16: Binary XML file line #16: Error inflating class android.support.v7.widget.CardView
     Caused by: android.view.InflateException: Binary XML file line #16: Error inflating class android.support.v7.widget.CardView
     Caused by: java.lang.reflect.InvocationTargetException
        at java.lang.reflect.Constructor.newInstance0(Native Method)
        at java.lang.reflect.Constructor.newInstance(Constructor.java:343)
        at android.view.LayoutInflater.createView(LayoutInflater.java:647)
        at android.view.LayoutInflater.createViewFromTag(LayoutInflater.java:790)
        at android.view.LayoutInflater.createViewFromTag(LayoutInflater.java:730)
        at android.view.LayoutInflater.rInflate(LayoutInflater.java:863)
        at android.view.LayoutInflater.rInflateChildren(LayoutInflater.java:824)
        at android.view.LayoutInflater.inflate(LayoutInflater.java:515)
        at android.view.LayoutInflater.inflate(LayoutInflater.java:423)
        at android.view.LayoutInflater.inflate(LayoutInflater.java:374)
        at android.support.v7.app.AppCompatDelegateImplV9.setContentView(AppCompatDelegateImplV9.java:292)
        at android.support.v7.app.AppCompatActivity.setContentView(AppCompatActivity.java:140)
        at com.paulkg12.t61.ui.activity.base.BaseActivity.onCreate(BaseActivity.java:96)
        at android.app.Activity.performCreate(Activity.java:7327)
        at android.app.Activity.performCreate(Activity.java:7318)
        at android.app.Instrumentation.callActivityOnCreate(Instrumentation.java:1271)
        at android.app.ActivityThread.performLaunchActivity(ActivityThread.java:3094)
        at android.app.ActivityThread.handleLaunchActivity(ActivityThread.java:3257)
        at android.app.servertransaction.LaunchActivityItem.execute(LaunchActivityItem.java:78)
        at android.app.servertransaction.TransactionExecutor.executeCallbacks(TransactionExecutor.java:108)
        at android.app.servertransaction.TransactionExecutor.execute(TransactionExecutor.java:68)
        at android.app.ActivityThread$H.handleMessage(ActivityThread.java:1948)
        at android.os.Handler.dispatchMessage(Handler.java:106)
        at android.os.Looper.loop(Looper.java:214)
        at android.app.ActivityThread.main(ActivityThread.java:7050)
        at java.lang.reflect.Method.invoke(Native Method)
        at com.android.internal.os.RuntimeInit$MethodAndArgsCaller.run(RuntimeInit.java:494)
        at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:965)
     Caused by: java.lang.UnsupportedOperationException: Failed to resolve attribute at index 2: TypedValue{t=0x2/d=0x7f040051 a=-1}
        at android.content.res.TypedArray.getColorStateList(TypedArray.java:546)
        at android.support.v7.widget.CardView.initialize(CardView.java:220)
        at android.support.v7.widget.CardView.<init>(CardView.java:116)
        at java.lang.reflect.Constructor.newInstance0(Native Method) 
        at java.lang.reflect.Constructor.newInstance(Constructor.java:343) 
        at android.view.LayoutInflater.createView(LayoutInflater.java:647) 
        at android.view.LayoutInflater.createViewFromTag(LayoutInflater.java:790) 
        at android.view.LayoutInflater.createViewFromTag(LayoutInflater.java:730) 
        at android.view.LayoutInflater.rInflate(LayoutInflater.java:863) 
        at android.view.LayoutInflater.rInflateChildren(LayoutInflater.java:824) 
        at android.view.LayoutInflater.inflate(LayoutInflater.java:515) 
        at android.view.LayoutInflater.inflate(LayoutInflater.java:423) 
        at android.view.LayoutInflater.inflate(LayoutInflater.java:374) 
        at android.support.v7.app.AppCompatDelegateImplV9.setContentView(AppCompatDelegateImplV9.java:292) 
        at android.support.v7.app.AppCompatActivity.setContentView(AppCompatActivity.java:140) 
        at com.paulkg12.t61.ui.activity.base.BaseActivity.onCreate(BaseActivity.java:96) 
        at android.app.Activity.performCreate(Activity.java:7327) 
        at android.app.Activity.performCreate(Activity.java:7318) 
        at android.app.Instrumentation.callActivityOnCreate(Instrumentation.java:1271) 
        at android.app.ActivityThread.performLaunchActivity(ActivityThread.java:3094) 
        at android.app.ActivityThread.handleLaunchActivity(ActivityThread.java:3257) 
        at android.app.servertransaction.LaunchActivityItem.execute(LaunchActivityItem.java:78) 
        at android.app.servertransaction.TransactionExecutor.executeCallbacks(TransactionExecutor.java:108) 
        at android.app.servertransaction.TransactionExecutor.execute(TransactionExecutor.java:68) 
        at android.app.ActivityThread$H.handleMessage(ActivityThread.java:1948) 
        at android.os.Handler.dispatchMessage(Handler.java:106) 
        at android.os.Looper.loop(Looper.java:214) 
        at android.app.ActivityThread.main(ActivityThread.java:7050) 
        at java.lang.reflect.Method.invoke(Native Method) 
        at com.android.internal.os.RuntimeInit$MethodAndArgsCaller.run(RuntimeInit.java:494) 
        at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:965) 
```

- 0428

```log

2020-04-28 20:17:47.948 3721-3721/com.paulkg12.t61 E/AndroidRuntime: FATAL EXCEPTION: main
    Process: com.paulkg12.t61, PID: 3721
    java.lang.RuntimeException: Unable to start activity ComponentInfo{com.paulkg12.t61/com.paulkg12.t61.ui.activity.IssuesActivity}: android.view.InflateException: Binary XML file line #18: Binary XML file line #21: Error inflating class android.support.design.widget.TabLayout
        at android.app.ActivityThread.performLaunchActivity(ActivityThread.java:3114)
        at android.app.ActivityThread.handleLaunchActivity(ActivityThread.java:3257)
        at android.app.servertransaction.LaunchActivityItem.execute(LaunchActivityItem.java:78)
        at android.app.servertransaction.TransactionExecutor.executeCallbacks(TransactionExecutor.java:108)
        at android.app.servertransaction.TransactionExecutor.execute(TransactionExecutor.java:68)
        at android.app.ActivityThread$H.handleMessage(ActivityThread.java:1948)
        at android.os.Handler.dispatchMessage(Handler.java:106)
        at android.os.Looper.loop(Looper.java:214)
        at android.app.ActivityThread.main(ActivityThread.java:7050)
        at java.lang.reflect.Method.invoke(Native Method)
        at com.android.internal.os.RuntimeInit$MethodAndArgsCaller.run(RuntimeInit.java:494)
        at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:965)
     Caused by: android.view.InflateException: Binary XML file line #18: Binary XML file line #21: Error inflating class android.support.design.widget.TabLayout
     Caused by: android.view.InflateException: Binary XML file line #21: Error inflating class android.support.design.widget.TabLayout
     Caused by: java.lang.reflect.InvocationTargetException
        at java.lang.reflect.Constructor.newInstance0(Native Method)
        at java.lang.reflect.Constructor.newInstance(Constructor.java:343)
        at android.view.LayoutInflater.createView(LayoutInflater.java:647)
        at android.view.LayoutInflater.createViewFromTag(LayoutInflater.java:790)
        at android.view.LayoutInflater.createViewFromTag(LayoutInflater.java:730)
        at android.view.LayoutInflater.rInflate(LayoutInflater.java:863)
        at android.view.LayoutInflater.rInflateChildren(LayoutInflater.java:824)
        at android.view.LayoutInflater.parseInclude(LayoutInflater.java:995)
        at android.view.LayoutInflater.rInflate(LayoutInflater.java:859)
        at android.view.LayoutInflater.rInflateChildren(LayoutInflater.java:824)
        at android.view.LayoutInflater.rInflate(LayoutInflater.java:866)
        at android.view.LayoutInflater.rInflateChildren(LayoutInflater.java:824)
        at android.view.LayoutInflater.inflate(LayoutInflater.java:515)
        at android.view.LayoutInflater.inflate(LayoutInflater.java:423)
        at android.view.LayoutInflater.inflate(LayoutInflater.java:374)
        at android.support.v7.app.AppCompatDelegateImplV9.setContentView(AppCompatDelegateImplV9.java:292)
        at android.support.v7.app.AppCompatActivity.setContentView(AppCompatActivity.java:140)
        at com.paulkg12.t61.ui.activity.base.BaseActivity.onCreate(BaseActivity.java:96)
        at android.app.Activity.performCreate(Activity.java:7327)
        at android.app.Activity.performCreate(Activity.java:7318)
        at android.app.Instrumentation.callActivityOnCreate(Instrumentation.java:1271)
        at android.app.ActivityThread.performLaunchActivity(ActivityThread.java:3094)
        at android.app.ActivityThread.handleLaunchActivity(ActivityThread.java:3257)
        at android.app.servertransaction.LaunchActivityItem.execute(LaunchActivityItem.java:78)
        at android.app.servertransaction.TransactionExecutor.executeCallbacks(TransactionExecutor.java:108)
        at android.app.servertransaction.TransactionExecutor.execute(TransactionExecutor.java:68)
        at android.app.ActivityThread$H.handleMessage(ActivityThread.java:1948)
        at android.os.Handler.dispatchMessage(Handler.java:106)
        at android.os.Looper.loop(Looper.java:214)
        at android.app.ActivityThread.main(ActivityThread.java:7050)
        at java.lang.reflect.Method.invoke(Native Method)
        at com.android.internal.os.RuntimeInit$MethodAndArgsCaller.run(RuntimeInit.java:494)
        at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:965)
2020-04-28 20:17:47.949 3721-3721/com.paulkg12.t61 E/AndroidRuntime: Caused by: java.lang.UnsupportedOperationException: Failed to resolve attribute at index 13: TypedValue{t=0x2/d=0x7f0401ae a=-1}
        at android.content.res.TypedArray.getColor(TypedArray.java:477)
        at android.support.design.widget.TabLayout.<init>(TabLayout.java:349)
        at android.support.design.widget.TabLayout.<init>(TabLayout.java:291)
        	... 33 more
```

## 自定义的view 填充不到布局文件中

当我启动issueAty ，好几个openhub 的控件放不进入 布局，导致crash。

```

Error inflating class com.thirtydegreesray.openhub.ui.widget.ContextMenuRecyclerView
```

我真是笨蛋：我应该改 

    com.thirtydegreesray.openhub.ui.widget
    
为

    com.paulkg12.t61.ui.widget.ContextMenuRecyclerView
    
## 仍旧有进入 issue comment detail 界面的crash

``` 

 Caused by: android.view.InflateException: Binary XML file line #111: Binary XML file line #111: Error inflating class com.thirtydegreesray.openhub.ui.widget.ZoomAbleFloatingActionButton
     Caused by: android.view.InflateException: Binary XML file line #111: Error inflating class com.thirtydegreesray.openhub.ui.widget.ZoomAbleFloatingActionButton
     Caused by: java.lang.ClassNotFoundException: Didn't find class "com.thirtydegreesray.openhub.ui.widget.ZoomAbleFloatingActionButton" on path: DexPathList[[zip file "/data/app/com.paulkg12.t61-nGLjLK5D7CvH4FGO2s_sRg==/base.apk"],nativeLibraryDirectories=[/data/app/com.paulkg12.t61-nGLjLK5D7CvH4FGO2s_sRg==/lib/arm64, /system/lib64, /system/vendor/lib64]]
```

原来是xml 里面有太多：

``` 
 paul% grep -rn "com.thirtydegreesray.openhub.ui.widget" *
layout/fragment_viewer.xml:11:    <com.thirtydegreesray.openhub.ui.widget.webview.CodeWebView
layout/fragment_markdown_editor.xml:16:        <com.thirtydegreesray.openhub.ui.widget.ToastAbleImageButton
layout/fragment_markdown_editor.xml:26:        <com.thirtydegreesray.openhub.ui.widget.ToastAbleImageButton
layout/fragment_markdown_editor.xml:36:        <com.thirtydegreesray.openhub.ui.widget.ToastAbleImageButton
layout/fragment_markdown_editor.xml:46:        <com.thirtydegreesray.openhub.ui.widget.ToastAbleImageButton
layout/fragment_markdown_editor.xml:56:        <com.thirtydegreesray.openhub.ui.widget.ToastAbleImageButton
layout/fragment_markdown_editor.xml:66:        <com.thirtydegreesray.openhub.ui.widget.ToastAbleImageButton
layout/fragment_markdown_editor.xml:76:        <com.thirtydegreesray.openhub.ui.widget.ToastAbleImageButton
layout/fragment_markdown_editor.xml:86:        <com.thirtydegreesray.openhub.ui.widget.ToastAbleImageButton
layout/fragment_markdown_editor.xml:96:        <com.thirtydegreesray.openhub.ui.widget.ToastAbleImageButton
layout/fragment_markdown_editor.xml:106:        <com.thirtydegreesray.openhub.ui.widget.ToastAbleImageButton
layout/layout_item_notification_repo.xml:40:        <com.thirtydegreesray.openhub.ui.widget.ToastAbleImageButton
layout/activity_edit_issue.xml:49:        <com.thirtydegreesray.openhub.ui.widget.ToastAbleImageButton
layout/activity_release_info.xml:50:                    <com.thirtydegreesray.openhub.ui.widget.webview.CodeWebView
layout/layout_item_event.xml:16:    <com.thirtydegreesray.openhub.ui.widget.CircleBackgroundImageView
layout/fragment_list_with_search.xml:32:            <com.thirtydegreesray.openhub.ui.widget.ContextMenuRecyclerView
layout/activity_single_fragment.xml:20:    <com.thirtydegreesray.openhub.ui.widget.ZoomAbleFloatingActionButton
xml/settings.xml:11:    <com.thirtydegreesray.openhub.ui.widget.colorChooser.ColorChooserPreference

```

## viewer aty 还是有问题

``` 
2020-04-29 22:07:06.825 11472-11472/com.paulkg12.t61 E/AndroidRuntime: FATAL EXCEPTION: main
    Process: com.paulkg12.t61, PID: 11472
    android.content.ActivityNotFoundException: Unable to find explicit activity class {com.paulkg12.t61/com.paulkg12.t61.ui.activity.ViewerActivity}; have you declared this activity in your AndroidManifest.xml?
        at android.app.Instrumentation.checkStartActivityResult(Instrumentation.java:2016)
        at android.app.Instrumentation.execStartActivity(Instrumentation.java:1673)
        at android.app.Activity.startActivityForResult(Activity.java:4689)
        at android.support.v4.app.FragmentActivity.startActivityForResult(FragmentActivity.java:767)
        at android.app.Activity.startActivityForResult(Activity.java:4647)
        at android.support.v4.app.FragmentActivity.startActivityForResult(FragmentActivity.java:754)
        at android.app.Activity.startActivity(Activity.java:5008)
        at android.app.Activity.startActivity(Activity.java:4976)
        at com.paulkg12.t61.ui.activity.ViewerActivity.showMdSource(ViewerActivity.java:43)
        at com.paulkg12.t61.ui.fragment.IssueTimelineFragment.onItemClick(IssueTimelineFragment.java:102)
        at com.paulkg12.t61.ui.adapter.base.BaseAdapter.onItemClick(BaseAdapter.java:130)
        at com.paulkg12.t61.ui.adapter.base.BaseViewHolder.onClick(BaseViewHolder.java:41)
        at android.view.View.performClick(View.java:7352)
        at android.view.View.performClickInternal(View.java:7318)
        at android.view.View.access$3200(View.java:846)
        at android.view.View$PerformClick.run(View.java:27800)
        at android.os.Handler.handleCallback(Handler.java:873)
        at android.os.Handler.dispatchMessage(Handler.java:99)
        at android.os.Looper.loop(Looper.java:214)
        at android.app.ActivityThread.main(ActivityThread.java:7050)
        at java.lang.reflect.Method.invoke(Native Method)
        at com.android.internal.os.RuntimeInit$MethodAndArgsCaller.run(RuntimeInit.java:494)
        at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:965)

```


## 记录一些 url


``` 
D/AppRetrofit: https://api.github.com/repos/anonymity12/privaLearnNote/issues?state=open&sort=created&direction=desc&page=1&uniqueLoginId=bluebird97


D/AppRetrofit: https://api.github.com/authorizations?uniqueLoginId=bluebird97
```


## 下一步的工作

### 优化部分：

1） 优化登陆页面：自动链接总部中。。。
2）fix viewer aty 里面的不可点击 link

### 回味细节代码

1） viewer 部分，其实同上2），一并解决link 问题
2） dagger 总结
3） butter knife
4） markdown的处理
5） 其他使用过程中的，从界面可发掘的知识点
6） retrofit 原理
7） event bus 的 使用情况是什么样？怎么使用的？