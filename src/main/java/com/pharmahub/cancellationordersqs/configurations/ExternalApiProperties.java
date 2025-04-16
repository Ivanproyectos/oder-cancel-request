package com.pharmahub.cancellationordersqs.configurations;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "endpoints")
public class ExternalApiProperties {

    private final ApiUrl ip6 = new ApiUrl();
    private final ApiUrl sap = new ApiUrl();
    private final ApiUrl irtrack = new ApiUrl();
    private final ApiUrl pmm = new ApiUrl();
    private final ApiUrl otm = new ApiUrl();

    public ApiUrl getIp6() {
        return ip6;
    }

    public ApiUrl getSap() {
        return sap;
    }

    public ApiUrl getIrtrack() {
        return irtrack;
    }

    public ApiUrl getPmm() {
        return pmm;
    }

    public ApiUrl getOtm() {
        return otm;
    }

    public static class ApiUrl {
        private String consulta;
        private String anular;

        public String getConsulta() {
            return consulta;
        }

        public void setConsulta(String consulta) {
            this.consulta = consulta;
        }

        public String getAnular() {
            return anular;
        }

        public void setAnular(String anular) {
            this.anular = anular;
        }
    }
}
