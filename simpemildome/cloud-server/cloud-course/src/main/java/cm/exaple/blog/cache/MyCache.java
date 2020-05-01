package cm.exaple.blog.cache;

import org.springframework.stereotype.Component;

/**
 * 类似缓存效果，用于存储结果
 * 结构与红黑树
 * 对比avl的绝对平衡红黑树则是黑色节点平衡。到达任意节点黑色节点数量都是相同的
 */
@Component
public class MyCache<T extends Comparable<T>> {
    private Entry<T> root;//根节点
    //红颜色
    private static final boolean RED   = false;
    //黑颜色
    private static final boolean BLACK = true;
    //包含颜色的树
    private static class Entry<T extends Comparable<T>>{
        T value;
        Entry<T> left;
        Entry<T> right;
        Entry<T> parent;
        boolean color = BLACK;

        public Entry(T value, Entry<T> parent) {
            this.value = value;
            this.parent = parent;
        }
    }
    //插入数据
    public void insert(T value){
        //取出根节点
        Entry<T> t = root;
        //判断根节点是否为空
        if (root == null) {
            //创建一个节点
            root = new Entry<>(value, null);
            return;
        }

        int chose;//用于判断插入节点的左树还是右树
        Entry<T> parent = null;//value的父节点
        //查找要插入的地点
        do {
            parent = t;
            chose = parent.value.compareTo(value);//判断大小
            if (chose > 0) {
                //value比当前节点要小
                t = parent.left;
            }else {
                t = parent.right;
            }
        }while (t != null);
        //创建叶子
        Entry<T> entry = new Entry<>(value,parent);
        if (chose > 0) {
            parent.left = entry;
        }else {
            parent.right = entry;
        }

    }
    //判断红黑树结构是否已经被破坏
    private void fixAfterInsertion(Entry<T> x){
        //默认插入红色节点
        x.color = RED;
        //循环判断,不能为空，不能是根节点，如果是黑色则无需判断
        while (x != null && x != root && x.color != RED){
            //判断父节点在祖父节点的位置
            if (leftOf(parentOf(parentOf(x))) == parentOf(x)) {
                //判断叔叔节点的颜色，如果是红色父与叔节点变黑祖父节点变红，之后操作在于祖父节点判断
                if (rightOf(parentOf(parentOf(x))).color == RED) {
                    setColor(parentOf(x), BLACK);
                    setColor(rightOf(parentOf(parentOf(x))), BLACK);
                    x = parentOf(parentOf(x));//以祖父节点重新判断
                }else {
                    //如果叔叔节点为空或者是黑色则发生旋转
                    //判断当前节点在父节点的位置，不能是lr或者rl形式，只能是ll或者rr形式
                    if (parentOf(x).right == x) {
                        //右旋转转传承LL形式
                        x = parentOf(x);
                        //右旋转
                        rotateLeft(x);
                    }
                    //旋转后的节点为起始点再次旋转
                    //变色
                    setColor(parentOf(x), BLACK);//要成为根节点
                    setColor(parentOf(parentOf(x)), RED);
                    rotateRight(parentOf(parentOf(x)));

                }
            }else {
                //在右面判断叔叔节点是否为红色如果是红色不需要发生旋转
                Entry<T> y = leftOf(parentOf(parentOf(x)));
                if (y.color == RED) {
                    setColor(parentOf(x), BLACK);
                    setColor(parentOf(parentOf(x)),RED);
                    setColor(y, BLACK);
                    x = parentOf(parentOf(x));
                }else {
                    //如果是黑色或者没有节点则为旋转
                    if (parentOf(x).left == x) {
                        x = parentOf(x);
                        rotateRight(x);
                    }
                    setColor(parentOf(x), BLACK);
                    setColor(parentOf(parentOf(x)),RED);
                    rotateLeft(parentOf(parentOf(x)));
                }

            }
            this.root.color = BLACK;
        }
    }
    public T getObect(T v){
        return get(v).value;
    }
    //中序遍历
    private Entry<T> get(T value){
        //从根节点寻找
        Entry t = root;
        while (t != null) {
            if (t.value.compareTo(value) > 0) {
                t = t.left;
            }else if (t.value.compareTo(value) < 0) {
                t = t.right;
            }else {
                return t;
            }
        }
        return null;
    }
    //左旋抓
    private void rotateLeft(Entry<T> t){
        Entry<T> r = t.right;
        t.right = r.left;
        if (r.left != null){
            r.left.parent = r;
        }
        r.parent = t.parent;
        if (t.parent == null) {
            root = r;
        }else if (t.parent.left == t) {
            t.parent.left = r;
        }else {
            t.parent.right = r;
        }
        t.parent = r;
        r.left = t;
    }
    //右旋转
    private void rotateRight(Entry<T> t){
        Entry<T> l = t.right;
        t.left = l.right;
        if (l.left != null) {
            l.left.parent = t;
        }
        l.parent = t.parent;
        if (t.parent == null) {
            root = l;
        } else if (parentOf(t).left == t) {
            t.parent.left = l;
        }else {
            t.parent.right = l;
        }
        t.parent = l;
        l.right = t;
    }
    //染色
    private void setColor(Entry<T> t,boolean color){
        t.color = color;
    }
    //获取父节点
    private  Entry<T> parentOf(Entry<T> t){
        return (t == null ? null : t.parent);
    }
    //获取左子节点
    private Entry<T> leftOf(Entry<T> t){
        return t == null ? null : t.left;
    }
    //获取右节点
    private Entry<T> rightOf(Entry<T> t){
        return t == null ? null : t.right;
    }


}
