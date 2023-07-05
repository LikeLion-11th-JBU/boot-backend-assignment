package seungil.dev.gateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RoutingConfig {
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder){
        return builder.routes()
                .route("community-shop", predicate ->
                    predicate
                            .path("/shop/**")
                            .filters(filter -> filter)
                            .uri("http://localhost:8081"))
                .build();
    }
}
