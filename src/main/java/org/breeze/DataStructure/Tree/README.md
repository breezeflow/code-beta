## 红黑树

`红黑树` 是一种不严格的平衡二叉查找树。

红黑树的由来：当对二叉查找树频繁的进行插入和删除操作，会使得数的高度远大于log2(n)，从而导致性能下降，极端情况下可能会
退化成链表。

所以需要对树进行一个调整，这就是 平衡二叉树

常听的平衡二叉树有：`AVL树`、`红黑树`

为什么大家都喜欢使用红黑树而非AVL数？

AVL 树是一种高度平衡的二叉树，所以查找的效率非常高，但是，有利就有弊，AVL 树为了维持这种高度的平衡，就要付出更多的代价。
每次插入、删除都要做调整，就比较复杂、耗时。所以，对于有频繁的插入、删除操作的数据集合，使用 AVL 树的代价就有点高了。
红黑树只是做到了近似平衡，并不是严格的平衡，所以在维护平衡的成本上，要比 AVL 树要低。
所以，红黑树的插入、删除、查找各种操作性能都比较稳定。对于工程应用来说，要面对各种异常情况，为了支撑这种工业级的应用，我们更倾向于这种性能稳定的平衡二叉查找树


### 红黑树的特点

1. 根节点是黑色
2. 叶子节点是黑色的空节点，不存储数据
3. 相邻两节点（上下）不能都是红色。即：红色节点被黑色节点隔开
4. 每个节点到可达的叶子节点的路径上包含相同的黑色节点




