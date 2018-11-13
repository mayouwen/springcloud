# springcloud

通过springcloud，搭建了一个简单微服务，服务之间通过freign调用（服务之间也可以通过resttemplate调用，但是freign调用相对方便，不需要ip和端口，只需要从服务中心拿到服务名称调用即可，代码中做了一个简单的两服务之间调用的demo），访问服务通过gateway网关进行访问(也可以使用zuul，但是目前springboot直接成了zull1版本，这个版本的性能相对于gateway网关较低)，服务注册中心使用eureka（服务注册中心可以选择consul，目前eureka2.x已经不再维护，consul功能丰富是一个不错的选择）。服务之间加入熔断机制，防止高并发下某个服务垮掉造成其他服务一直等待导致服务器垮掉。 

服务注册中心:
![image](https://github.com/mayouwen/springcloud/blob/master/images/eureka.PNG)
由于微服务各个服务都是分开部署的，日志也会在各个服务器上产生，这就为出现问题根据日志查找是哪个服务出错带来了不便，因此引入了链路追踪，通过链路追踪为每个服务调动生成一个traceid，同日志一起输出，为了将服务器日志进行收集，采用了ELK日志系统，这个可以自行安装，然后将各个服务器日志通过通过logstash输出，并有elasticsearch收集，最终通过kibana展示出来，这样就方便对日志进行统一管理

zipkin展示服务之间的调用关系
![image](https://github.com/mayouwen/springcloud/blob/master/images/zipkin.PNG)

kibana展示所有服务器日志信息
![image](https://github.com/mayouwen/springcloud/blob/master/images/kibana.PNG)
可能出现的问题：输出的日志中没有traceid，这里建议使用logback组件，同时用@Slf4j注解进行日志输出，也有其他方法，但是相对会比较麻烦
