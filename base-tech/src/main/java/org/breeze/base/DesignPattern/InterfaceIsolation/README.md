## 接口隔离原则

### 1. 将 "接口" 理解为一组API接口集合

例如：
```java
public interface UserService{
    boolean register(String username,String password);
    boolean login(String username,String password);
    UserInfo getById(Long id);
}

public class UserServiceImpl implements UserService{

}
```

如果现在要添加`删除用户` 的功能，但不希望所有模块都可以调用，只有后台管理都可以调用，直接在UserService中
添加可以实现功能，但 从安全的角度考虑，只要实现了UserService都可以调用删除用户的功能。

接口隔离原则：添加一个新的接口来封装这些删除操作。单独提供给调用者。

思想：如果接口中部分功能，只有部分调用者使用，那应该将这部分功能单独抽离出一个接口，与原接口隔离开。不强迫调用者依赖这部分功能。 

### 2. 将 "接口" 理解为 单个API和函数

例如：
```java
@Data
public class Statistics{
    private Long max;
    private Long min;
    private Long average;
    private long sum;
}

class service{
    public Statistics count(Collection<Long> datas){
            Statistics statistics = new Statistics();
            //一些计算逻辑
            return statistics;
    }
}
```

count 函数功能不够单一，包括了所有的属性的计算逻辑。
功能是否单一判断的标准不同，在不同的业务中，体现可能不同
假如count方法的调用者，并不需要计算所有的属性，只需要计算sum，这时候 count 方法的逻辑 拆分出来可能更好，尤其当
需要计算的数据量很大时。

例如：
```java
class service{
 
    //public Statistics count(Collection<Long> datas){...}   

    public Long max(Collection<Long> datas){}
    public Long min(Collection<Long> datas){}
}
           
```

### 3. 将 "接口" 理解为 OOP中的接口

见代码
