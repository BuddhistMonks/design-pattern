package com.study.design.demo2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 卖东西，计算价格
@Service
public class SaleService {

//    @Autowired
//    SVIPCalculateService svipCalculateService;
//
//    @Autowired
//    VIPCalculateService vipCalculateService;
//
//    @Autowired
//    NormalCalculateService normalCalculateService;
//
//    /**
//     * 计费
//     *
//     * @param userType 用户类型
//     * @param fee      商品价格
//     */
//    public double sale(String userType, double fee) {
//        if ("vip".equals(userType)) {
//            // TODO 完整算法，肯定不止这一行 省略很多行代码
//            return vipCalculateService.calculate(fee);
//        } else if ("normal".equals(userType)) {
//            return normalCalculateService.calculate(fee);
//        } else if ("svip".equals(userType)) {
//            return svipCalculateService.calculate(fee);
//        } // else if ---- ssvip
//        return fee;
//    }

    // @Autowired map --- key 是spring中bean的名称，而不是用户类型


    HashMap<String, CalculateService> serviceHashMap = new HashMap<>();

    @Autowired // 利用spring的注入高级功能 --
    public SaleService(List<CalculateService> calculateServices) {
        // 用一个map存起来
        for (CalculateService calculateService : calculateServices) {
            // key -- 用户类型  value --- 打折计算器对象
            serviceHashMap.put(calculateService.userType(), calculateService);
        }
    }

    /**
     * 计费
     *
     * @param userType 用户类型
     * @param fee      商品价格
     */
    public double sale(String userType, double fee) {
        CalculateService calculateService = serviceHashMap.get(userType);
        if(calculateService == null) {
            return fee;
        }
        return calculateService.calculate(fee);
    }
}
