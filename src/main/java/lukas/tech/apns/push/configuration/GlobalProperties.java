package lukas.tech.apns.push.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;

/**
 * Created by lukas on 31.08.17.
 */
@Component
@PropertySource("classpath:configuration.properties")
@ConfigurationProperties(prefix="cert")
public class GlobalProperties {

    @NotNull
    private String path;
    @NotNull
    private String password;
    @NotNull
    private String topic;
    @NotNull
    private boolean useProductionHost;

    public GlobalProperties(){ super(); }

    public GlobalProperties(String path, String password, String topic, boolean useProductionHost) {
        this.path = path;
        this.password = password;
        this.topic = topic;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public boolean isUseProductionHost() {
        return useProductionHost;
    }

    public void setUseProductionHost(boolean useProductionHost) {
        this.useProductionHost = useProductionHost;
    }
}
