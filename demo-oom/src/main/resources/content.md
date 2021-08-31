oom顽疾
1、GC Worker Other阶段耗时过长，主要是因为大量晋升对象的copy
现象：应用启动后，频繁youngGc
晋升对象大小计算公式：
（后一次gc后的堆内存 - 后一次gc后的yong内存）-（前一次gc后的堆内存 - 前一次gc后的young内存）
survivor空间不够时，会租借老年代空间，此时，会出现大量对象的copy；
2、YGC时间优化
关键字：concurrent mode failure 、promotion failed、card 数组
card 数组，通过card marking算法标记（dirty），利用空间换时间的方法，快速查到老年代中对新生代对象有引用的对象即dirty对象

信息：
 Root阶段：从各种类型root对象出发标记存活对象
 older-gen scanning :扫描老年代到新生代的引用以及拷贝eden区和from区中的存活对象至to；为了解决老年代中对象引用新生代中对象，无法在YGC被标记的问题。
 GC Worker Other ：将需要晋升的对象从新生代拷贝到老年代
主要原因：应用中的对象违背了GC中的分代假设，即，
 