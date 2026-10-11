package com.example.demo.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.dto.ConfiguracionResponse;

@RestController
@RefreshScope
@RequestMapping("/api/v1/matriculas")
public class ConfiguracionController {

    @Value("${edusmart.sede}")
    private String sede;

    @Value("${edusmart.costo-credito}")
    private BigDecimal costoCredito;

    @Value("${edusmart.max-creditos-ciclo}")
    private Integer maxCreditosCiclo;

    @Value("${edusmart.mensaje-bienvenida}")
    private String mensajeBienvenida;

    @Value("${edusmart.limite-cuotas-pago}")
    private Integer limiteCuotasPago;

    @Value("${spring.datasource.url}")
    private String datasourceUrl;

    @GetMapping("/configuracion")
    public ConfiguracionResponse configuracion() {
        return new ConfiguracionResponse(sede, costoCredito, maxCreditosCiclo, mensajeBienvenida, limiteCuotasPago, datasourceUrl);
    }
}