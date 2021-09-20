package ru.n5g.bank.education

import org.springframework.beans.factory.config.BeanPostProcessor
import org.springframework.stereotype.Component
import java.util.*


@Component
class InjectValueAnnotationBeanPostProcessor : BeanPostProcessor {

  override fun postProcessBeforeInitialization(bean: Any, beanName: String): Any? {
    val fields = bean.javaClass.declaredFields
    for (field in fields) {
      val annotation = field.getAnnotation(InjectValue::class.java)
//      println("${beanName} - ${field.name} - ${annotation != null} - ${Arrays.toString(field.annotations)}")
      annotation?.let {
        field.isAccessible = true
        field.set(bean, "inject true")
      }
    }
    return super.postProcessBeforeInitialization(bean, beanName)
  }
}