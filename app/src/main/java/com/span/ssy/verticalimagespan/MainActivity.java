package com.span.ssy.verticalimagespan;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.widget.TextView;

import com.span.ssy.verticalimagespan.view.VerticalImageSpan;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = ((TextView) findViewById(R.id.tv));
        String str="测试图片在行中间#safd#fdgfhfgh555是不是在#正#中间啊啊啊啊啊啊啊#啊啊#啊啊啊啊啊啊啊啊啊#啊啊#啊啊啊啊";
        Pattern p = Pattern.compile("#[^@#]+?#", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(str);
        SpannableString spannableString=new SpannableString(str);
        while (m.find()) {
            int start = m.start(0);
            int end = m.end(0);
            String group = m.group();
            Drawable drawable = getResources().getDrawable(R.mipmap.note_product_cart);
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            VerticalImageSpan imageSpan=new VerticalImageSpan(drawable);
            spannableString.setSpan(imageSpan, start, end, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);

        }

        tv.setText(spannableString);
    }
}
