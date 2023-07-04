package dev.anderson.praticandoddd;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@DataJpaTest
@ExtendWith(MySQLCleanUpExtension.class)
public @interface MySQLGatewayTest {
}
