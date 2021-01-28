# FloatRatingBar 
### A RatingBar use least code to set rate with float value such as 1.1,1.2,3.4

一种使用最简单的方式实现的星星评分控件，可设置任意0-5之间的小数(float类型)。使用时只需要两张图片：一张选中的星星、一张未选中的星星。

Android原生的RatingBar不支持半颗星星，更别说0.1颗星星，而且星星大小和间距也不能控制，网上也有若干自定义的RatingBar，但最多支持半颗星星，而且实现过程很繁琐。

本控件只需要十几行代码即可实现，不需要重写onDraw函数，高度轻量级、可定制化。效果如下图：

![avatar](https://github.com/devnns/FloatRatingBar/blob/master/ratingbar.png?raw=true)
