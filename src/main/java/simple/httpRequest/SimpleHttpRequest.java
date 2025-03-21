package simple.httpRequest;

import lombok.Builder;
import lombok.Getter;
import simple.constant.HttpMethod;

import java.util.HashMap;

@Builder
@Getter
public class SimpleHttpRequest {
    private final HttpMethod method;
    private final String url;
    private final String protocol;
    private final HashMap<String, String> queryString;
    private final HashMap<String, String> header;
    private final HashMap<String, Object> bodyMap;
}
