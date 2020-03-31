package com.example.dubbo.provider;


import com.example.dubbo.api.DemoService;
import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ProtocolConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.ServiceConfig;
import org.apache.dubbo.config.bootstrap.DubboBootstrap;


import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.CountDownLatch;

/**
 * <p><b>Description:</b>
 * TODO
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 17:45 on 2020/3/25
 * @version V0.1
 * @classNmae Provider
 */
public class Provider {
    public static void init_server2() throws IOException {
        // Implementation
        DemoService demoService = new DemoServiceImpl();

// Application Info
        ApplicationConfig application = new ApplicationConfig();
        application.setName("demoService");

       // Registry Info
        RegistryConfig registry = new RegistryConfig();
        registry.setAddress("127.0.0.1:2181");
        registry.setProtocol("zookeeper");
//        registry.setUsername("aaa");
//        registry.setPassword("bbb");

    // Protocol
        ProtocolConfig protocol = new ProtocolConfig();
        protocol.setName("dubbo");
        protocol.setPort(12881);
        protocol.setThreads(200);

// NOTES: ServiceConfig holds the serversocket instance and keeps connections to registry, please cache it for performance.

// Exporting
        ServiceConfig<DemoService> service = new ServiceConfig<DemoService>(); // In case of memory leak, please cache.
        service.setApplication(application);
        service.setRegistry(registry); // Use setRegistries() for multi-registry case
//        service.setProtocols(Arrays.asList(protocolConfigRmi,protocol)); // Use setProtocols() for multi-protocol case
        service.setProtocol(protocol);
        service.setInterface(DemoService.class);
        service.setRef(demoService);
        service.setVersion("1.0.0");

// Local export and register
        service.export();
        System.out.println("demoService started");
    }

    public static void main(String[] args) throws Exception {
        if (isClassic(args)) {
            startWithExport();
        } else {
            startWithBootstrap();
        }
//        init_server2();
    }

    private static boolean isClassic(String[] args) {
        return args.length > 0 && "classic".equalsIgnoreCase(args[0]);
    }

    private static void startWithBootstrap() {
        ServiceConfig<DemoServiceImpl> service = new ServiceConfig<>();
        service.setInterface(DemoService.class);
        service.setRef(new DemoServiceImpl());

        DubboBootstrap bootstrap = DubboBootstrap.getInstance();
        bootstrap.application(new ApplicationConfig("demoService"))
                .registry(new RegistryConfig("zookeeper://127.0.0.1:2181"))
                .service(service)
                .start()
                .await();
        System.out.println("dubbo service started");
    }

    private static void startWithExport() throws InterruptedException {
        ServiceConfig<DemoServiceImpl> service = new ServiceConfig<>();
        service.setInterface(DemoService.class);
        service.setRef(new DemoServiceImpl());
        service.setApplication(new ApplicationConfig("demoService"));
        service.setRegistry(new RegistryConfig("zookeeper://127.0.0.1:2181"));
        service.export();
        new CountDownLatch(1).await();
        System.out.println("dubbo service started");
    }
}
