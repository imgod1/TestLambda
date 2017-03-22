package com.example.gk.testlambda;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * android studio中使用lambda的步骤为:
 * 1. project的build.gradle 添加 classpath 'me.tatarka:gradle-retrolambda:3.2.5'
 * 2. app的build.gradle 应用插件 apply plugin: 'me.tatarka.retrolambda',
 *    并在该文件的android目录下 添加限制:
 *     compileOptions {
        sourceCompatibility JavaVersion.VERSION_1_8
        targetCompatibility JavaVersion.VERSION_1_8
         }
 * lambda表达式 最大的优点就是使代码更紧凑
 * 面向的是只有一个方法的接口.有两个接口的话就不能使用这个表达式了
 */
public class MainActivity extends AppCompatActivity {
    private Button btn_0;
    private CustomButton btn_1;
    private CustomButton1 btn_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initEvent();
    }

    private void initEvent() {
        btn_0.setOnClickListener(v -> showToast("Button_0"));
        btn_1.setOnCustomerClickListener(v -> showToast("Button_1"));
//        btn_2.setOnCustomerClickListener(v-showToast("ddd"));
        btn_2.setOnCustomerClickListener(new CustomButton1.OnCustomerClickListener() {
            @Override
            public void onClick(View view) {
                showToast("onClick");
            }

            @Override
            public boolean onLongClick(View view) {
                showToast("onLongClick");
                return true;
            }
        });
    }

    private void initView() {
        btn_0 = (Button) findViewById(R.id.btn_0);
        btn_1 = (CustomButton) findViewById(R.id.btn_1);
        btn_2 = (CustomButton1) findViewById(R.id.btn_2);
    }

    /**
     * 显示一个toast
     *
     * @param content toast内容
     */
    public void showToast(String content) {
        Toast.makeText(this, content, Toast.LENGTH_SHORT).show();
    }
}
