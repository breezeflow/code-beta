## 桥接模式

桥接模式的定义是：将抽象和实现解耦，让它们可以独立变化

桥接模式的典型案例：JDBC

```java
//加载及注册JDBC驱动程序
Class.forName("com.mysql.jdbc.Driver");
String url = "jdbc:mysql://localhost:3306/sample_db?user=root&password=your_password";
Connection con = DriverManager.getConnection(url);
Statement stmt = con.createStatement()；
String query = "select * from test";
ResultSet rs=stmt.executeQuery(query);
...
```
假如需要更换oracle数据源。则只需要修改驱动名和链接的url即可。

`Class.forName("xxx.xxx")`的过程
```java
public class Driver extends NonRegisteringDriver implements java.sql.Driver {
  static {
    try {
      java.sql.DriverManager.registerDriver(new Driver());
    } catch (SQLException E) {
      throw new RuntimeException("Can't register driver!");
    }
  }

  /**
   * Construct a new driver and register it with DriverManager
   * @throws SQLException if a database error occurs.
   */
  public Driver() throws SQLException {
    // Required for Class.forName().newInstance()
  }
}
```
Class.forName主要做了两个事：
1. 具体的Driver类
2. 实例化注册到DriverManager中


所谓的抽象，不是抽象类，也不是接口

抽象：JDBC连接数据库的一系列操作本身就是抽象的。是跟具体数据库无关的一套"类库"。

实现：具体到某个特定数据库的一套实现。