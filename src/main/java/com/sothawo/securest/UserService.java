/**
 * Copyright (c) 2015 sothawo
 *
 * http://www.sothawo.com
 */
package com.sothawo.securest;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Sample service.
 *
 * @author P.J. Meisch (pj.meisch@sothawo.com).
 */
@RestController
@RequestMapping("/service")
public class UserService {

    @RequestMapping(value = "echo/{in}", method = RequestMethod.GET)
    public String echo(@PathVariable(value = "in") final String in, @AuthenticationPrincipal final UserDetails user) {
        return "Hello " + user.getUsername() + ", you said: " + in;
    }

    @RequestMapping(value = "post", method = RequestMethod.POST)
    public void post(@RequestBody final String in, @AuthenticationPrincipal final UserDetails user) {
        System.out.println("User " + user.getUsername() + " posting " + in);
    }

    @RequestMapping(value = "put", method = RequestMethod.PUT)
    public void put(@RequestBody final String in, @AuthenticationPrincipal final UserDetails user) {
        System.out.println("User " + user.getUsername() + " putting " + in);
    }
    @RequestMapping(value = "delete/{in}", method = RequestMethod.DELETE)
    public void delete(@PathVariable(value = "in") final String in, @AuthenticationPrincipal final UserDetails user) {
        System.out.println("User " + user.getUsername() + " deleting " + in);
    }
}
