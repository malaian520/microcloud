package cn.enjoy.service;

import cn.enjoy.feign.FeignClientConfig;
import cn.enjoy.service.fallback.IZUUlClientServiceallbackFactory;
import cn.enjoy.vo.Product;
import cn.enjoy.vo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author mla
 * @description
 * @prjectName microcloud
 * @className IZUUlClientService
 * @date 2020/3/2  21:22
 */
@FeignClient(name = "MICROCLOUD-ZUUL-GATEWAY",configuration = FeignClientConfig.class,
        fallbackFactory = IZUUlClientServiceallbackFactory.class)
public interface IZUUlClientService {
    @RequestMapping("/enjoy-api/product-proxy/prodcut/get/{id}")
    Product getProduct(@PathVariable("id") Long id);

    @RequestMapping("/enjoy-api/product-proxy/prodcut/list")
    List<Product> listProduct();

    @RequestMapping("/enjoy-api/product-proxy/prodcut/add")
    boolean addPorduct(Product product);

    @RequestMapping("/enjoy-api/users-proxy/users/get/{name}")
    User getUsers(@PathVariable("name") String name);
}
