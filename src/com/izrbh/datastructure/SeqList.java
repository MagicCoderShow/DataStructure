package com.izrbh.datastructure;

/**
 * 顺序线性表
 */
public class SeqList{
    Object[] listArray;
    int size; //当前线性表元素个数
    int maxsize;//线性表能容纳的元素的个数
    final int defaultSize = 10;//线性表默认的元素个数

    /**
     * 默认大小初始化
     */
    public SeqList() { //数据初始化
        maxsize = defaultSize;
        size = 0;
        listArray = new Object[defaultSize];
    }

    /**
     * 设置大小初始化
     *
     * @param size 容量大小
     */
    public SeqList(int size) {
        maxsize = size;//最大容量
        this.size = 0;// 当前大小
        listArray = new Object[size];
    }

    /**
     * 插入操作
     *
     * @param i   下标
     * @param obj 数据
     * @throws Exception
     */
    public void insert(int i, Object obj) throws Exception {
        if (size == maxsize) {
            throw new Exception("顺序表已满，无法插入！");
        }
        if (i < 0 || i > size) {
            throw new Exception("参数错误");
        }
        for (int j = size; j > i; j--) {
            //将当前大于插入位置的数据都往后移动一位
            listArray[j] = listArray[j - 1];
        }
        listArray[i] = obj;
        size++;
    }

    /**
     * 删除数据
     *
     * @param i 下标
     * @return
     * @throws Exception
     */
    public Object delete(int i) throws Exception {
        if (isEmpty()) {
            throw new Exception("顺序表为空无法删除!");
        }
        if (i < 0 || i > size) {
            throw new Exception("参数错误");
        }
        //大于当前位的数据都往前移动一位
        for (int j = i + 1; j <= size - 1; j++) {
            listArray[j - 1] = listArray[j];
        }
        size--;
        return listArray[i];
    }

    /**
     * 获取位置数据
     *
     * @param i 下标
     * @return
     * @throws Exception
     */
    public Object getData(int i) throws Exception {
        if (i < 0 || i > size) {
            throw new Exception("参数错误！");
        }
        if (!isEmpty()) {
            throw new Exception("顺序表为空！");
        }
        return listArray[i];
    }


    /**
     * 当前数据量
     *
     * @return
     */
    public int size() {
        return size;  //因为不存在歧义所以可以返回时不需要this
    }


    /**
     * 返回匹配数据下标
     * 只返回第一个满足条件的位置
     *
     * @param obj
     * @return
     */
    public int locate(Object obj) {
        int temp = 0;
        for (int i = 0; i < size; i++) {
            if (listArray[i] == obj) {
                temp = i;
                break;//不跳出则返回最后一个匹配项
            } else {
                temp = -1;
            }
        }
        if (temp == -1) {
            System.out.println("没有搜索到值，结果返回：\"-1\"！");
        }
        return temp;
    }


    /**
     * 判断是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return this.size == 0;
    }

    public static void main(String[] args) throws Exception {
        SeqList list = new SeqList();
        list.insert(0, 2);
        list.insert(1, 5);
        list.insert(2, 6);
        list.insert(3, 1);
        list.insert(4, 6);
        list.delete(1);
        System.out.println(list.locate(6));
        System.out.println(list.isEmpty());
    }
}
