import com.alibaba.dubbo.config.*;
import com.example.dubbo.api.DemoService;
import org.apache.dubbo.config.bootstrap.DubboBootstrap;
import org.apache.dubbo.config.utils.ReferenceConfigCache;
import org.apache.dubbo.rpc.service.GenericService;

import java.io.IOException;
import java.util.Arrays;

/**
 * <p><b>Description:</b>
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 17:41 on 2020/3/25
 * @version V0.1
 * @classNmae Consumer
 */
public class Consumer  {
    public static void main(String[] args) {
//        init_consumer();
         if (isClassic(args)) {
            runWithRefer();
        } else {
            runWithBootstrap();
        }
    }

    public static void init_consumer(){
        ApplicationConfig application = new ApplicationConfig();
        application.setName("demoService");

// Registry Info
        RegistryConfig registry = new RegistryConfig();
        registry.setAddress("127.0.0.1:2181");
        registry.setProtocol("zookeeper");
//        registry.setUsername("aaa");
//        registry.setPassword("bbb");

// NOTES: ReferenceConfig holds the connections to registry and providers, please cache it for performance.

// Refer remote service
        ReferenceConfig<DemoService> reference = new ReferenceConfig<DemoService>(); // In case of memory leak, please cache.
        reference.setApplication(application);
        reference.setRegistry(registry);
        //默认为dubbo 非默认需要指定 protocol
        reference.setProtocol("dubbo");
        reference.setInterface(DemoService.class);
        reference.setVersion("1.0.0");
        DemoService service = reference.get();
        String msg=service.sayHello("Jesse Hsu1sssd");
        System.out.println(msg);
    }

    private static boolean isClassic(String[] args) {
        return args.length > 0 && "classic".equalsIgnoreCase(args[0]);
    }

    private static void runWithBootstrap() {
        ReferenceConfig<DemoService> reference = new ReferenceConfig<>();
        reference.setInterface(DemoService.class);
        reference.setGeneric("true");

        DubboBootstrap bootstrap = DubboBootstrap.getInstance();
        bootstrap.application(new ApplicationConfig("demoService"))
                .registry(new RegistryConfig("zookeeper://127.0.0.1:2181"))
                .reference(reference)
                .start();
        DemoService demoService = reference.get();
//        DemoService demoService = ReferenceConfigCache.getCache().get(reference);
        String message = demoService.sayHello("dubbo");
        System.out.println(message);

        // generic invoke
        GenericService genericService = (GenericService) demoService;
        Object genericInvokeResult = genericService.$invoke("sayHello", new String[] { String.class.getName() },
                new Object[] { "dubbo generic invoke" });
        System.out.println(genericInvokeResult);
    }

    private static void runWithRefer() {
        ReferenceConfig<DemoService> reference = new ReferenceConfig<>();
        reference.setApplication(new ApplicationConfig("dubbo-demo-api-consumer"));
        reference.setRegistry(new RegistryConfig("zookeeper://127.0.0.1:2181"));
        reference.setInterface(DemoService.class);
        DemoService service = reference.get();
        String message = service.sayHello("dubbo");
        System.out.println(message);
    }
}
