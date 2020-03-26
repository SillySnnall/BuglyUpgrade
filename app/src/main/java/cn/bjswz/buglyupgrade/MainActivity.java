package cn.bjswz.buglyupgrade;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.silly.sillypermission.SillyPermission;
import com.silly.sillypermission.SillyPermissionCall;

import static com.silly.sillypermission.SillyPermission.PERMISSION_PHONE;
import static com.silly.sillypermission.SillyPermission.PERMISSION_STORAGE;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 申请一个权限
        SillyPermission.INSTANCE.requestPermission(this, new SillyPermissionCall() {
            @Override
            public void call(boolean b) {
                if (b) Toast.makeText(MainActivity.this, "权限申请成功", Toast.LENGTH_SHORT).show();
                else Toast.makeText(MainActivity.this, "权限被拒绝", Toast.LENGTH_SHORT).show();
            }
        },PERMISSION_PHONE,PERMISSION_STORAGE);


    }

    // 必须在Activity中重写 onActivityResult 做回调
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        SillyPermission.INSTANCE.onActivityResultPermission(this,requestCode);
    }
    // 必须在Activity中重写 onRequestPermissionsResult 做回调
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        SillyPermission.INSTANCE.onRequestPermissionsResultPermission(this,requestCode,permissions,grantResults);
    }
}
