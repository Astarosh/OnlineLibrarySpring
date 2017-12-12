/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

/**
 *
 * @author Ast
 */
@Component
public class CustomHealthIndicator implements HealthIndicator{

    @Override
    public Health health() {
        return Health.down().withDetail("Error Message", "There is no connection to the service").build();
    }
    
}
