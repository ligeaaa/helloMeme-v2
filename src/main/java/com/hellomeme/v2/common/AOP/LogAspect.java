package com.hellomeme.v2.common.AOP;

import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {

   //TODO 打印接口调用日志的具体逻辑实现
   /**
    * 日志打印
    */
   private Logger logger = LoggerFactory.getLogger(this.getClass());

   /**
    * 使用Pointcut给这个方法定义切点，即UserService中全部方法均为切点。<br>
    * 这里在这个log方法上面定义切点，然后就只需在下面的Before、After等等注解中填写这个切点方法"log()"即可设置好各个通知的切入位置。
    * 其中：
    * <ul>
    *     <li>execution：代表方法被执行时触发</li>
    *     <li>*：代表任意返回值的方法</li>
    *     <li>com.example.springbootaop.service.impl.UserServiceImpl：这个类的全限定名</li>
    *     <li>(..)：表示任意的参数</li>
    * </ul>
    */
   @Pointcut("@annotation(com.hellomeme.v2.common.Annotation.LogExecution)")
   public void log() {

   }

   /**
    * 前置通知：在被代理方法之前调用
    */
   @Before("log()")
   public void doBefore() {
      logger.warn("调用方法之前：");
      logger.warn("接收到请求！");
   }

   /**
    * 后置通知：在被代理方法之后调用
    */
   @After("log()")
   public void doAfter() {
      logger.warn("调用方法之后：");
      logger.warn("打印请求内容完成！");
   }

   /**
    * 返回通知：被代理方法正常返回之后调用
    */
   @AfterReturning("log()")
   public void doReturning() {
      logger.warn("方法正常返回之后：");
      logger.warn("完成返回内容！");
   }

   /**
    * 异常通知：被代理方法抛出异常时调用
    */
   @AfterThrowing("log()")
   public void doThrowing() {
      logger.error("方法抛出异常！");
   }

}