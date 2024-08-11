package app.config;

import app.model.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "app")
public class AppConfig {
    @Bean
    public AnimalsCage animalsCage(@Qualifier("dog") Animal animal, Timer timer) {
        AnimalsCage animalsCage = new AnimalsCage();
        animalsCage.setAnimal(animal);
        animalsCage.setTimer(timer);
        return animalsCage;
    }

    @Bean
    public Timer timer() {
        return new Timer();
    }

    @Bean
    @Qualifier("dog")
    public Animal dog() {
        return new Dog();
    }

    @Bean
    @Qualifier("cat")
    public Animal cat() {
        return new Cat();
    }
}
