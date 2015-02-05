package net.yibee.scrollimage.image;

import android.app.Activity;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.lidroid.xutils.BitmapUtils;

import net.yibee.scrollimage.R;
import net.yibee.scrollimage.common.ScrollImageEntity;
import net.yibee.scrollimage.utils.Convert;

import java.util.ArrayList;
import java.util.List;

/**
 * 基本功能：图片滚动播放
 * 创建：王杰
 */
@SuppressWarnings("ResourceType")
public class ScrollImageController {
    private Activity activity;
    private BitmapUtils bitmapUtils;

    public ScrollImageController(Activity activity) {
        this.activity = activity;
        bitmapUtils = new BitmapUtils(activity);
    }

    /**
     * 初始化滚动图片布局
     * 如List<Object> objs,objs中可存储title、imageUrl、id、content等，这样可以将id，content等用于点击事件，传递数据到其他Activity
     *
     * @param list       数据
     * @param imgScroll  滚动图片布局
     * @param ovalLayout 圆点布局
     */
    public void initViewPagerImage(List<ScrollImageEntity> list, ImageScroll imgScroll,
                                   LinearLayout ovalLayout) {
        List<View> listViewsImage = new ArrayList<View>(); // 图片组
        ;
        // 显示
        if (list != null && list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                // 新建布局
                RelativeLayout relativeLayout = new RelativeLayout(activity);
                // 新建图片展示
                ImageView imageView = new ImageView(activity);
                // 新建图片标题
                TextView textView = new TextView(activity);
                imageView.setId(1);
                textView.setId(2);
                RelativeLayout.LayoutParams lp1 = new RelativeLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT);
                lp1.addRule(RelativeLayout.ALIGN_PARENT_TOP);
                lp1.addRule(RelativeLayout.CENTER_HORIZONTAL,
                        RelativeLayout.TRUE);
                textView.setTextColor(android.graphics.Color.WHITE);
                textView.setTextSize(13);
                textView.setBackgroundColor(android.graphics.Color.BLACK);
                textView.getBackground().setAlpha(100);
                textView.setGravity(Gravity.CENTER_VERTICAL);
                RelativeLayout.LayoutParams lp2;
                bitmapUtils.display(imageView, list.get(i).getImageUrl());
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                relativeLayout.addView(imageView, lp1);
                textView.setText("   " + list.get(i).getTitle() + "   ");
                if (list.get(i).getTitle() .getBytes().length > 70) {
                    lp2 = new RelativeLayout.LayoutParams(
                            ViewGroup.LayoutParams.MATCH_PARENT,
                            Convert.dip2px(activity, 38));
                    lp2.addRule(RelativeLayout.BELOW, 1);
                    lp2.setMargins(0, Convert.dip2px(activity, -38), 0, 0);
                } else {
                    lp2 = new RelativeLayout.LayoutParams(
                            ViewGroup.LayoutParams.MATCH_PARENT,
                            Convert.dip2px(activity, 28));
                    lp2.addRule(RelativeLayout.BELOW, 1);
                    lp2.setMargins(0, Convert.dip2px(activity, -28), 0, 0);
                }
                relativeLayout.addView(textView, lp2);
                listViewsImage.add(relativeLayout);
                //为测试点击事件，这里传入名字，可根据实际情况设置
                imageView.setOnClickListener(new ImageOnclickListener(list.get(i).getTitle() ));
            }
            imgScroll.start(activity, listViewsImage, 4000, ovalLayout,
                    R.layout.ad_bottom_item, R.id.ad_item_v,
                    R.drawable.dot_focused, R.drawable.dot_normal, true, true);
        }
    }

    /**
     * 滚动图片点击事件，此类构造方法可直接传入对象，取对象中的数据供业务逻辑使用
     */
    class ImageOnclickListener implements View.OnClickListener {
        String name;

        ImageOnclickListener() {
        }

        ImageOnclickListener(String name) {
            this.name = name;
        }

        @Override
        public void onClick(View view) {
            //业务逻辑处理
            Toast.makeText(activity.getApplicationContext(), name, Toast.LENGTH_SHORT).show();
        }
    }
}
