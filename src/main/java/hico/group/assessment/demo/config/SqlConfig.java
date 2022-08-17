package hico.group.assessment.demo.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import hico.group.assessment.demo.utils.Env;

import javax.sql.DataSource;

@Configuration
public class SqlConfig {
    private final Env env = new Env();

    @Bean
    public DataSource datasource() {
        return DataSourceBuilder.create()
                .driverClassName("com.mysql.cj.jdbc.Driver")
                .url(String.format("jdbc:mysql://%s:%s/%s", env.getEnv("DB_HOST"), env.getEnv("DB_PORT"),
                        env.getEnv("DB_DATABASE")))
                .username(env.getEnv("DB_USERNAME"))
                .password(env.getEnv("DB_PASSWORD"))
                .build();
    }

}
