package com.example.ownClass;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.WindowManager;

import com.example.broadcastbestpractice.LoginActivity;

/**
 * Created by 渠不与 on 2016/7/28 0028.
 */
public class ForceOfflineReceiver extends BroadcastReceiver {

    public void onReceive(final Context context, Intent intent){
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(context);
        dialogBuilder.setTitle("Warning");
        dialogBuilder.setMessage("You are forced to be offline.Please try to login again.");
        dialogBuilder.setCancelable(false);//将对话框设为不可取消
        dialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {//注册确定按钮
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ActivityCollector.finishall();//销毁所有活动
                Intent intent=new Intent(context, LoginActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);//重新启动LoginActivity
            }
        });

        AlertDialog alertDialog=dialogBuilder.create();
        //设置Alertdialog的类型，保证在广播接收器中可以正常弹出
        alertDialog.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
        alertDialog.show();
    }
}
