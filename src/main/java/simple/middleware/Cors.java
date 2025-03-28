package simple.middleware;

import simple.config.ApplicationConfig;
import simple.constant.ApplicationSetting;
import simple.constant.ServerSettingChecker;

import java.util.HashMap;
import java.util.Map;

import static simple.constant.ApplicationSetting.CORS;

public class Cors implements Middleware{

    private static volatile Cors INSTANCE;
    private final Map<Integer, String> corsMap;

    private Cors() {
        this.corsMap = new HashMap<>();
    }

    /**
     * lazy Loading, Double-Checked Locking
     */
    public static Cors getInstance() {
        if (INSTANCE == null) {
            synchronized (Cors.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Cors();
                }
            }
        }
        return INSTANCE;
    }

    public void registerCorsValue(ApplicationSetting applicationSetting, String option){
        if(ServerSettingChecker.isServerEnabled(applicationSetting)){
            corsMap.put(applicationSetting.getBit(), option);
        } else {
            System.err.println("cors 관련 오류 발생");
        }
    }

    public String getCors(){
        return corsMap.get(CORS.getBit());
    }

    @Override
    public void run() {
        System.out.println("Cors 미들웨어 실행..");
    }
}
