package com.orange.hervedarritchon.issues;

import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * Created by Hervé Darritchon on 20/07/2016.
 */

@org.springframework.boot.autoconfigure.SpringBootApplication
public class SpringBootApplicationIssues {

    public static void main(String[] args) {
        new SpringApplicationBuilder(SpringBootApplicationIssues.class).run(args);
    }

}
