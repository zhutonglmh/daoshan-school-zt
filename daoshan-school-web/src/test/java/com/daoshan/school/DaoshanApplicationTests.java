package com.daoshan.school;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DaoshanApplicationTests {

	public static final Logger LOG = LoggerFactory.getLogger(DaoshanApplicationTests.class);

	@Test
	public void contextLoads() {

		try {
//			String str = null;
//			str.toCharArray();
           //AliSmsUntils.sms("15689438669","2222");

            //EmailSend.send_mail("shandongsunzhi@126.com","000099");
			return;
		}catch (NoClassDefFoundError e){
			System.out.println(e);
			LOG.error("测试出现类未发现异常日志 ,errMsg = {}, stack info = {}",e.getMessage(),e.toString());
		}catch (StringIndexOutOfBoundsException e){
			System.out.println(e);
			LOG.error("测试出现角标越界异常日志 ,errMsg = {}, stack info = {}",e.getMessage(),e.toString());
		}catch (NullPointerException e){
			System.out.println(e);
			LOG.error("测试出现空指针异常日志 ,errMsg = {}, stack info = {}",e.getMessage(),e.toString());
		}catch (Exception e){
			System.out.println(e);
			LOG.error("测试出现异常日志 ,errMsg = {}, stack info = {}",e.getMessage(),e.toString());
		}
		finally {

		}
	}



}
