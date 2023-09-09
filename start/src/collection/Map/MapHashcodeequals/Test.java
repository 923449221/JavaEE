package collection.Map.MapHashcodeequals;

import java.util.HashSet;
import java.util.Objects;

/**
 * @author li
 * @create 2022--07
 * @description   重写hashcode和equeals才会测验此方法，不然会调用object的，会返回不变的随机数，这是就插入时乱序了
 *                把hashcode理解为一个地址
 *
 *                treeMap是通过key遍历，也使用自然排序和定制排序
 */


class Test{
    public  class User {
        String name;
        int id;


        public User(String name, int id) {
            this.name = name;
            this.id = id;
        }
        public String getName() {
            return name;
        }


        public void setName(String name) {
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", id=" + id +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            User user = (User) o;
            return id == user.id &&
                    Objects.equals(name, user.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, id);
        }
    }

    public static void main(String[] args) {
        HashSet set =new HashSet<>();
        Test.User u1 = new Test().new User("AA",10);   //如果求方便，可以在类上直接加static，此时直接用new A.B进行创建
        Test.User u2 = new Test().new User("BB",11);
        set.add(u1);
        set.add(u2);
        System.out.println(set);
        u1.name = "CC";
        set.remove(u1); //此时remove也是根据hashcode一步步检查，但是是根据的CC，所以删错了地方,效果等于没删除
        System.out.println(set);
        set.add(new Test().new User("CC",10)); //会插入，虽然u1的属性和他一样，但hashcode不同
        System.out.println(set);
        set.add(new Test().new User("AA",10));//虽然内容不一样，u1已经改了，地址一样，equals不一样
                                                           // 然后以链表的形式插入

    }
}
