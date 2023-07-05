二分查找底层基于数组的随机访问特点，所以只能用在数组中。

如果数据存储在链表中，该如何使用二分查找算法的思想实现高效查询？

实际上，对链表稍加改造就可以支持类似 "二分" 的查找算法。这种结构就称之为 `跳表`

### 跳表的特点：
1. 动态数据结构  2. 高效查询、插入、删除


### 跳表结构的演进过程：

1. 单纯的链表如果要访问一个节点需要遍历，时间复杂度为O(n)

2. 借鉴数组，每隔两个节点添加一个索引，查询数据的时候，先遍历索引，然后再遍历指针就会减少总遍历次数
    
    <img src="https://gitee.com/chcloudcode/images/raw/master/Algo&DataStructure/skip-list/skipList01.jpg" width="600px" height="300px"/>

3. 加了一级索引后，遍历节点个数减少了，效率也就增加了，但不是特别明显，假如再添加一层索引

    <img src="https://gitee.com/chcloudcode/images/raw/master/Algo&DataStructure/skip-list/skipList02.jpg" width="600px" height="300px"/>

4. 如果数据量很大，为了增加查询效率，则需要添加多层索引

    <img src="https://gitee.com/chcloudcode/images/raw/master/Algo&DataStructure/skip-list/skipList03.jpg" width="600px" height="300px"/>
    
上述这种 `链表+多级索引` 的结构就是`跳表`

你可能会问，如果添加多级索引 是不是会很浪费空间，实际上在实际开发过程中，节点存储的是数据量很大的对象，而索引只存储对象的单个或几个属性，相对而言，可以忽略不计。

动态插入、删除操作的时间复杂度为：`O(logn)`


### 跳表索引的动态更新

随着插入和删除的次数增多，会导致某一个索引区间内的节点很多，而其他的很少，这种情况跳表性能下降可能退化成链表。

<img src="https://gitee.com/chcloudcode/images/raw/master/Algo&DataStructure/skip-list/skipList04.jpg" width="600px" height="300px"/>

所以，会有一个`随机函数` 来 动态生成索引，保持跳表性能不下降。
