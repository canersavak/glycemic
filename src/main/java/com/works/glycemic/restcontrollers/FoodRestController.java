package com.works.glycemic.restcontrollers;

import com.works.glycemic.models.Food;
import com.works.glycemic.services.FoodService;
import com.works.glycemic.utils.REnum;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("/food")
public class FoodRestController {

    final FoodService foodService;

    public FoodRestController(FoodService foodService) {
        this.foodService = foodService;
    }

    //food save
    @PostMapping("/save")
    public Map<REnum,Object> foodsave(@RequestBody Food food){
        Map<REnum,Object> hm = new LinkedHashMap<>();
        Food f = foodService.foodSave(food);
        if( f == null ) {
            hm.put(REnum.status, false );
            hm.put(REnum.message, "Bu ürün daha önce kayıt edilmiş" );
            hm.put(REnum.result, f);
        }else {
            hm.put(REnum.status, true );
            hm.put(REnum.message, "Ürün kaydı başarılı" );
            hm.put(REnum.result, f);
        }
        return hm;

    }

    //food list
    @GetMapping("/list")
    public Map<REnum,Object> list() {
        Map<REnum, Object> hm = new LinkedHashMap<>();
        hm.put(REnum.status, true );
        hm.put(REnum.message, "Ürün listesi" );
        hm.put(REnum.result, foodService.foodList());
        return hm;
    }

    // user food list
    @GetMapping("/userFoodList")
    public Map<REnum,Object> userFoodList() {
        Map<REnum, Object> hm = new LinkedHashMap<>();
        hm.put(REnum.status, true );
        hm.put(REnum.message, "Ürün listesi" );
        hm.put(REnum.result, foodService.userFoodList());
        return hm;
    }


}