package anandh.employee.types.external;

import java.util.Map;

public interface IExternalClient<T> {
    T getMethod(String uri, T t, Map<String, String> params);
    T postMethod(String uri,T request, T t);
}
