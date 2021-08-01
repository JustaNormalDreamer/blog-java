/*
 *
 * Copyright (c) 2021 Dipesh Shrestha aka JustaDreamer
 * Github: https://github.com/JustaNormalDreamer
 *
 */

package micronaut.java.hello;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;

@Controller("/api/${api.version:v1}")
@Secured(SecurityRule.IS_ANONYMOUS)
public class HelloController {
    @Get("hello")
    public String hello() {
        return "Hello World!";
    }
}
