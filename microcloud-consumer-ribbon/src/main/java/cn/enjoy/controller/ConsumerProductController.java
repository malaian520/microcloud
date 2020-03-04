package cn.enjoy.controller;

import cn.enjoy.vo.Product;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/consumer")
public class ConsumerProductController {
    /*public static final String PRODUCT_GET_URL = "http://MICROCLOUD-PROVIDER-PRODUCT/prodcut/get/";
    public static final String PRODUCT_LIST_URL="http://MICROCLOUD-PROVIDER-PRODUCT/prodcut/list/";
    public static final String PRODUCT_ADD_URL = "http://MICROCLOUD-PROVIDER-PRODUCT/prodcut/add/";
    @Resource
    private RestTemplate restTemplate;

    @Resource
    private HttpHeaders httpHeaders;

    @RequestMapping("/product/get")
    public Object getProduct(long id) {
        Product product = restTemplate.exchange(PRODUCT_GET_URL + id, HttpMethod.GET,new HttpEntity<Object>(httpHeaders), Product.class).getBody();
        return  product;
    }

    @RequestMapping("/product/list")
    public  Object listProduct() {
        List<Product> list = restTemplate.exchange(PRODUCT_LIST_URL,HttpMethod.GET,
                new HttpEntity<Object>(httpHeaders), List.class).getBody();
        return  list;
    }

    @RequestMapping("/product/add")
    public Object addPorduct(Product product) {
        Boolean result = restTemplate.exchange(PRODUCT_ADD_URL, HttpMethod.POST,
                new HttpEntity<Object>(product,httpHeaders), Boolean.class).getBody();
        return  result;
    }*/
    //此属性字段与yml文件的保持一直以及启动类即可否则负载均衡也不起作用
    public static final String PRODUCT_TOPIC = "MICROCLOUD-PROVIDER-PRODUCT";
    @Resource
    private RestTemplate restTemplate;

    @Resource
    private HttpHeaders httpHeaders;

    @Resource
    private LoadBalancerClient loadBalancerClient;


    @RequestMapping("/product/list")
    public  Object listProduct() {
        ServiceInstance serviceInstance = this.loadBalancerClient.choose(PRODUCT_TOPIC) ;
        System.out.println(
                "【*** ServiceInstance ***】host = " + serviceInstance.getHost()
                        + "、port = " + serviceInstance.getPort()
                        + "、serviceId = " + serviceInstance.getServiceId());

        URI uri = URI.create(String.format("http://%s:%s/prodcut/list/" ,
                serviceInstance.getHost(), serviceInstance.getPort()));

        List<Product> list = restTemplate.exchange(uri,HttpMethod.GET,new HttpEntity<Object>(httpHeaders), List.class).getBody();
        return  list;
    }
}