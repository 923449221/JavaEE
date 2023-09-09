package FaceToObject.GenericsTest;

/**
 * @author li
 * @create 2022--07
 * @description
 */
public class User extends Dao<User> {          //可以灵活修改泛型值，来实现不同类的功能
}


/*
public class User extends Dao {         子类不声明，那么相当于不使用泛型，相当于Dao<Object>
}
*/



/*
public class User<E> extends Dao<E> {         // 如果继承的泛型类不确定那么子类也要用e一起规范（必须）也就意味着声明时要确定类型
}*/



/*
public class User<E,F> extends Dao<E,String> {         //父类泛型可以部分确定，子类可以额外设置泛型
}*/













/*
a=a-b
b=a+b     a
a=  b-a
*/



/*a=a^b;
b=a^b;   a                                         //逗人玩
a=a^b*/





































