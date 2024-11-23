1、spring默认支持的scope只有两种：
singleton -单例，每次从spring容器获取到的bean都是同一个对象,
prototype -多例，每次从spring容器获取到的bean都是不同的对象，
spring web又对spring进行了扩展，增加了两种：
requestScope - 同一次请求从spring容器中获取到的bean都是同一个对象，
sessionScope - 同一个会话从spring容器中获取到的bean都是同一个对象.