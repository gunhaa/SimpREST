package simple.server;


import simple.constant.ApplicationSetting;
import simple.response.ResponseHandler;

import java.io.IOException;

public interface Server {

    void run(int port) throws IOException;

    void use(ApplicationSetting applicationSetting, boolean bool);

    void get(String URL, ResponseHandler responseSuccessHandler);

    void post();
}
