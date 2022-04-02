package com.edu.nbu.cn;

import com.edu.nbu.cn.datatransfer.DataTransferApplication;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author laoshi . hua
 * @version 1.0 2022/3/31-10:51 AM
 * @since 1.0
 */
@RunWith(SpringRunner.class)
@Import(BeanConfig.class)
@SpringBootTest(classes = DataTransferApplication.class)
public class BaseTest {
}
