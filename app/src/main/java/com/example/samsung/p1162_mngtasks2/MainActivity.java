package com.example.samsung.p1162_mngtasks2;

import android.app.ActivityManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;

import java.util.List;

import static android.app.ActivityManager.RunningTaskInfo;


public class MainActivity extends AppCompatActivity {

    private List<ActivityManager.RunningTaskInfo> list;
    private ActivityManager activityManager;
    private String message;
    private ListView lvFlags;
    private FlagAdapter adapter;
    private int curFlag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        message = getString(R.string.app_name) + " : " + getLocalClassName();
        setTitle(message);
        activityManager = (ActivityManager) getSystemService(ACTIVITY_SERVICE);

        lvFlags = (ListView) findViewById(R.id.lvFlags);
        adapter = new FlagAdapter(this);
        lvFlags.setAdapter(adapter);
    }

    public void onClickBtn(View view) {

        //noinspection deprecation
        list = activityManager.getRunningTasks(10);
        curFlag = (int)view.getTag();

        switch (view.getId()) {

            case R.id.btnInfo:
                for (RunningTaskInfo taskInfo : list) {
                    if (taskInfo.baseActivity.flattenToShortString().startsWith("com.example.samsung.p116")) {
                        message = "------------------------";
                        Messager.sendTpOnlyLog(message);
                        message = "Count: " + taskInfo.numActivities;
                        Messager.sendTpAllRecipients(getBaseContext(), message);
                        message = "Root: " + taskInfo.baseActivity.flattenToShortString();
                        Messager.sendTpAllRecipients(getBaseContext(), message);
                        message = "Top: " + taskInfo.topActivity.flattenToShortString();
                        Messager.sendTpAllRecipients(getBaseContext(), message);
                    }
                }
                break;
            case R.id.btnStart :
                switch (curFlag) {
                    case 0:
                        startActivity(new Intent("mngtasks1_activity_c")
                                .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                        break;
                    case 1:
                        startActivity(new Intent("mngtasks1_activity_c")
                                .addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP));
                        break;
                    case 2:
                        startActivity(new Intent("mngtasks1_activity_c")
                                .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
                        break;
                    case 3:
                        //noinspection deprecation
                        startActivity(new Intent("mngtasks1_activity_c")
                                .addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET));
                        break;
                    case 4:
                        startActivity(new Intent("mngtasks1_activity_c")
                                .addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY));
                        break;
                    case 5:
                        startActivity(new Intent("mngtasks1_activity_c")
                                .addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT));
                        break;
                    case 6:
                        startActivity(new Intent("mngtasks1_activity_c")
                                .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK));
                        break;
                    case 7:
                        startActivity(new Intent("mngtasks1_activity_c")
                                .addFlags(Intent.FLAG_ACTIVITY_TASK_ON_HOME));
                        break;
                    case 8:
                        startActivity(new Intent("mngtasks1_activity_c")
                                .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                                .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                        break;
                    case 9:
                        startActivity(new Intent("mngtasks1_activity_c")
                                .addFlags(Intent.FLAG_ACTIVITY_TASK_ON_HOME)
                                .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                        break;
                    default:
                        break;
                }
                break;
            default :
                break;
        }
    }
}
