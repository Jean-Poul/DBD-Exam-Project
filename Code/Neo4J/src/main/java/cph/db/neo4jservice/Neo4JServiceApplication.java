package cph.db.neo4jservice;

import org.neo4j.driver.Driver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.neo4j.core.ReactiveDatabaseSelectionProvider;
import org.springframework.data.neo4j.core.transaction.ReactiveNeo4jTransactionManager;

@SpringBootApplication
public class Neo4JServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(Neo4JServiceApplication.class, args);
    }

    @Bean
    public ReactiveNeo4jTransactionManager reactiveTransactionManager(Driver driver,
                                                                      ReactiveDatabaseSelectionProvider databaseNameProvider) {
        return new ReactiveNeo4jTransactionManager(driver, databaseNameProvider);
    }
}
