# risk
springboot+security oauth + redis + mongodb

一、打成jar 包

  1、在application.yml文件中设置端口号
  server.port = 51000

  2、maven pom 项目中修改打包类型为jar
  <packaging>jar</packaging>

  3、到项目根目录，包含pom的目录执行打包程序
  mvn clean package

  4、在target目录中生成了jar文件，将jar文件拷贝到服务器，执行
  java -jar sim.jar > sim.log &


作者：番茄很忙 日期：2017-08-15