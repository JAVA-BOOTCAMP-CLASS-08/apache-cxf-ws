package ar.com.sicos.config;

import ar.com.sicos.service.interceptors.AppInboundInterceptor;
import ar.com.sicos.service.interceptors.AppOutboundInterceptor;
import ar.com.sicos.service.OperacionesMatematicasImpl;
import jakarta.xml.ws.Endpoint;
import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.ext.logging.LoggingFeature;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletPath;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class CXFConfig {

	@Bean
	public ServletRegistrationBean<CXFServlet>  dispatcherServlet() {
        return new ServletRegistrationBean<>(new CXFServlet(), "/services/*");
    }

    @Bean
    @Primary
    public DispatcherServletPath dispatcherServletPathProvider() {
        return () -> "";
    }

    @Bean
    public LoggingFeature loggingFeature() {

        LoggingFeature loggingFeature = new LoggingFeature();
        loggingFeature.setPrettyLogging(true);

        return loggingFeature;
    }

    @Bean(name=Bus.DEFAULT_BUS_ID)
    public SpringBus springBus(LoggingFeature loggingFeature) {
    	SpringBus cxfBus = new SpringBus();
       	cxfBus.getInInterceptors().add(new AppInboundInterceptor());
    	cxfBus.getOutInterceptors().add(new AppOutboundInterceptor());

        cxfBus.getFeatures().add(loggingFeature);

    	return cxfBus;
    }

    @Bean
    public Endpoint matematicasEndpoint(Bus bus, OperacionesMatematicasImpl operaciones) {
        EndpointImpl endpoint = new EndpointImpl(bus, operaciones);
        endpoint.publish("/operaciones");
        return endpoint;
    }
}
