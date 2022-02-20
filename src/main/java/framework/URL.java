package framework;

import java.io.Serializable;

/**
 * @ClassName URL
 * @Author xuwen_chen
 * @Date 2021/1/3 0:20
 * @Version 1.0
 */
public class URL implements Serializable {
    private static final long serialVersionUID = -7409704250266255236L;
    private String hostname;
    private Integer port;

    public URL() {
    }

    public URL(String hostname, Integer port) {
        this.hostname = hostname;
        this.port = port;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }
}
