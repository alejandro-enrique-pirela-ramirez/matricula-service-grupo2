package com.example.demo.bean.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;

public record ConfiguracionResponse(
        String sede,
        @JsonProperty("costo-credito") BigDecimal costoCredito,
        @JsonProperty("max-creditos-ciclo") Integer maxCreditosCiclo,
        @JsonProperty("mensaje-bienvenida") String mensajeBienvenida,
        @JsonProperty("limite-cuotas-pago") Integer limiteCuotasPago,
        @JsonProperty("datasource.url") String datasourceUrl) {
}