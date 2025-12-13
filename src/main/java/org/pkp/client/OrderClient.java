package org.pkp.client;

import org.pkp.config.OrderServiceProperties;
import org.pkp.dto.OrdersDto;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class OrderClient {

    private final RestTemplate restTemplate;
    private final OrderServiceProperties properties;

    public OrderClient(RestTemplate restTemplate,
                       OrderServiceProperties properties) {
        this.restTemplate = restTemplate;
        this.properties = properties;
    }

    public List<OrdersDto> getOrdersByCustomer(String customerId) {

        String url = properties.getUrl()+"/custId?customerID="+ customerId;
        ResponseEntity<List<OrdersDto>> response =
                restTemplate.exchange(
                        url,
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<List<OrdersDto>>() {}
                );

        return response.getBody();
    }
}

