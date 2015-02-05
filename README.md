## AutoScrollImage基于ViewPage的android图片滚动的实现，支持自动滚动播放和手动滚动。<h2>
使用了xUtils开源库加载图片文件，可针对自己喜好更换加载图片的方式。
### 使用方法 <h3>
首先将文件拷贝到自己的项目中。
### Activity中使用 <h3>
--
1.将布局文件添加到Activity的布局文件中<include layout="@layout/ad_scroll_image"/>
2. 在Activity中引用 
   ```java
    ImageScroll myPager; // 图片容器
    LinearLayout ovalLayout; // 圆点容器
    private ScrollImageController scrollImageView;
    private List<ScrollImageEntity> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initScrollView();
        initScrollData();
    }

    /**
     * 初始化滚动图片布局
     */
    private void initScrollView() {
        myPager = (ImageScroll) findViewById(R.id.myvp);
        ovalLayout = (LinearLayout) findViewById(R.id.vb);
    }

    /**
     * 初始化滚动图片数据数据
     */
    private void initScrollData() {
        scrollImageView = new ScrollImageController(this);
        list = new ArrayList<ScrollImageEntity>();
        //测试数据
        ScrollImageEntity scrollImageEntity1 = new ScrollImageEntity();
        scrollImageEntity1.setTitle("指引你的瑜伽资深大师的指引你的瑜伽资");
        scrollImageEntity1.setImageUrl("http://www.jianyumei.com.cn/ueditor/net/upload/2015-01-15/e9af161b-133d-4017-989a-624e6771e158.jpg");
        ScrollImageEntity scrollImageEntity2 = new ScrollImageEntity();
        scrollImageEntity2.setTitle("瑜伽练习时手臂力量不足 教你如何应对");
        scrollImageEntity2.setImageUrl("http://www.jianyumei.com.cn/ueditor/net/upload/2015-01-14/e2477c05-361c-4568-a4ca-fce27b65e104.jpg");
        ScrollImageEntity scrollImageEntity3 = new ScrollImageEntity();
        scrollImageEntity3.setTitle("瑜伽搭配哑铃 5式动作轻松瘦");
        scrollImageEntity3.setImageUrl("http://www.jianyumei.com.cn/ueditor/net/upload/2015-01-14/f5343005-30e9-4734-8560-c695ac862e3e.jpg");
        ScrollImageEntity scrollImageEntity4 = new ScrollImageEntity();
        scrollImageEntity4.setTitle("指引你的瑜伽 资深大师的18个瑜伽建议");
        scrollImageEntity4.setImageUrl("http://www.jianyumei.com.cn/ueditor/net/upload/2015-01-09/e74d4d39-e6bb-4673-bcbc-6afd002609cb.jpg");
        list.add(scrollImageEntity1);
        list.add(scrollImageEntity2);
        list.add(scrollImageEntity3);
        list.add(scrollImageEntity4);
        //启用图片滚动
        scrollImageView.initViewPagerImage(list, myPager, ovalLayout);
    }
```
### Fragment中使用 <h3>
--
1.引入布局文件<include layout="@layout/ad_scroll_image"/>
2.Fragment中引用
```java
 ImageScroll myPager; // 图片容器
    LinearLayout ovalLayout; // 圆点容器
    private ScrollImageController scrollImageView;
    private List<ScrollImageEntity> list;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_article, container, false);
        initView(view);
        initEvent();
        initScrollView(view);
        initScrollData();
        return view;
    }
    /**
     * 初始化滚动图片布局
     */
    private void initScrollView(View view) {
        myPager = (ImageScroll)view.findViewById(R.id.myvp);
        ovalLayout = (LinearLayout) view.findViewById(R.id.vb);
    }

    /**
     * 初始化滚动图片数据数据
     */
    private void initScrollData() {
        scrollImageView = new ScrollImageController(getActivity());
        list = new ArrayList<ScrollImageEntity>();
        ScrollImageEntity scrollImageEntity1 = new ScrollImageEntity();
        scrollImageEntity1.setTitle("指引你的瑜伽资深大师的指引你的瑜伽资");
        scrollImageEntity1.setImageUrl("http://www.jianyumei.com.cn/ueditor/net/upload/2015-01-15/e9af161b-133d-4017-989a-624e6771e158.jpg");
        ScrollImageEntity scrollImageEntity2 = new ScrollImageEntity();
        scrollImageEntity2.setTitle("瑜伽练习时手臂力量不足 教你如何应对");
        scrollImageEntity2.setImageUrl("http://www.jianyumei.com.cn/ueditor/net/upload/2015-01-14/e2477c05-361c-4568-a4ca-fce27b65e104.jpg");
        ScrollImageEntity scrollImageEntity3 = new ScrollImageEntity();
        scrollImageEntity3.setTitle("瑜伽搭配哑铃 5式动作轻松瘦");
        scrollImageEntity3.setImageUrl("http://www.jianyumei.com.cn/ueditor/net/upload/2015-01-14/f5343005-30e9-4734-8560-c695ac862e3e.jpg");
        ScrollImageEntity scrollImageEntity4 = new ScrollImageEntity();
        scrollImageEntity4.setTitle("指引你的瑜伽 资深大师的18个瑜伽建议");
        scrollImageEntity4.setImageUrl("http://www.jianyumei.com.cn/ueditor/net/upload/2015-01-09/e74d4d39-e6bb-4673-bcbc-6afd002609cb.jpg");
        list.add(scrollImageEntity1);
        list.add(scrollImageEntity2);
        list.add(scrollImageEntity3);
        list.add(scrollImageEntity4);
        scrollImageView.initViewPagerImage(list, myPager, ovalLayout);
    }
```
### ListView中使用 <h3>
 将布局文件添加到ListView的头部即可
```java
ListView.addHeaderView(_ListView.inflate(getActivity(),R.layout.ad_scroll_image,null));
```
### 关于作者： <h3>
Email：wjie@yibee.net 
