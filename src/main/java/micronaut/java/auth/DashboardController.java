/*
 *
 * Copyright (c) 2021 Dipesh Shrestha aka JustaDreamer
 * Github: https://github.com/JustaNormalDreamer
 *
 */

package micronaut.java.auth;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;

import javax.annotation.security.PermitAll;

@Controller("dashboard")
@Secured(SecurityRule.IS_AUTHENTICATED)
//@PermitAll
public class DashboardController {

    @Get
    @Produces(MediaType.TEXT_PLAIN)
    public String index() {
        return "Welcome! This is the dashboard.";
    }
}
