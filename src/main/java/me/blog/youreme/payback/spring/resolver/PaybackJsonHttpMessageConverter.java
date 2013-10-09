package me.blog.youreme.payback.spring.resolver;

import org.springframework.http.HttpOutputMessage;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;

import java.io.IOException;

/**
 * User: youreme
 * Date: 13. 10. 6.
 * Time: 오후 3:56
 *
 * result에 result code 와 result message를 넣어줌
 */
public class PaybackJsonHttpMessageConverter extends MappingJacksonHttpMessageConverter {
   @Override
    protected void writeInternal(Object obj, HttpOutputMessage httpOutputMessage) throws IOException, HttpMessageNotWritableException {
        super.writeInternal(new PaybackResultJsonContainer(obj), httpOutputMessage);
   }
}
