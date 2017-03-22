package com.example.gk.testlambda;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;

/**
 * 项目名称：TestLambda
 * 类描述：
 * 创建人：gk
 * 创建时间：2017/3/22 17:01
 * 修改人：gk
 * 修改时间：2017/3/22 17:01
 * 修改备注：
 */
public class CustomButton1 extends Button {


    public CustomButton1(Context context) {
        super(context);
    }

    public CustomButton1(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    public interface OnCustomerClickListener {
        void onClick(View view);
        boolean onLongClick(View view);
    }

    OnCustomerClickListener onCustomerClickListener;

    public void setOnCustomerClickListener(OnCustomerClickListener onCustomerClickListener) {
        this.onCustomerClickListener = onCustomerClickListener;
        setOnClickListener(v -> onCustomerClickListener.onClick(v));
        setOnLongClickListener(v -> onCustomerClickListener.onLongClick(v));
    }
}
