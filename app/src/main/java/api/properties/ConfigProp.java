package api.properties;

import org.aeonbits.owner.Config;

@Config.Sources(
        "file:./src/main/resources/config.properties")

public interface ConfigProp extends Config {

    @Config.Key("url.base")
    String url();

    String username();

    String password();

}
