package cn.murphy.nacosproviderexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@SpringBootApplication
@EnableDiscoveryClient
public class NacosProviderExampleApplication {



	public static void main(String[] args) {
		SpringApplication.run(NacosProviderExampleApplication.class, args);
	}

	@RestController
	class EchoController {
		@RequestMapping(value = "/echo/{string}", method = RequestMethod.GET)
		public String echo(@PathVariable String string) {
			return "Hello Nacos Discovery " + string;
		}


		@Autowired
		private DiscoveryClient discoveryClient;

		@GetMapping("/getServiceList")
		public List<ServiceInstance> getServiceList() {
			List<ServiceInstance> serviceInstanceList = discoveryClient.getInstances("service-provider");
			return serviceInstanceList;
		}
	}


}
