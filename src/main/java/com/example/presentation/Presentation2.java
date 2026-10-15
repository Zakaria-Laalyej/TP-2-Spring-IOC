package com.example.presentation;

import com.example.metier.IMetier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.example.dao", "com.example.metier"})
public class Presentation2 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        context.getEnvironment().setActiveProfiles("dev");  // 1. activer le profil
        context.register(Presentation2.class);              // 2. enregistrer la config
        context.refresh();                                  // 3. démarrer le contexte

        IMetier metier = context.getBean(IMetier.class);
        System.out.println("Résultat = " + metier.calcul());

        context.close();
    }
}