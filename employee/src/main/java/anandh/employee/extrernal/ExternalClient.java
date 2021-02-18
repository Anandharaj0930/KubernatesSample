package anandh.employee.extrernal;

import anandh.employee.types.external.IExternalClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Map;

@Component
public class ExternalClient<T> implements IExternalClient<T> {

    @Autowired
    private RestTemplate restTemplate;

    public T getMethod(String uri, T t, Map<String, String> params) {
        return restTemplate.getForObject(uri, (Class<T>) t, params);

    }

    public T postMethod(String uri, T r, T t) {
        HttpEntity<String> request = new HttpEntity(r, buildHeadders());
        return restTemplate.postForObject(uri, request, (Class<T>) t);

    }

    public HttpHeaders buildHeadders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML));
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }


}
