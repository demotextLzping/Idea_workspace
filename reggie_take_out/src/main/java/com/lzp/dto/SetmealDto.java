package com.lzp.dto;

import com.lzp.entity.Setmeal;
import com.lzp.entity.SetmealDish;
import lombok.Data;
import java.util.List;

@Data
public class SetmealDto extends Setmeal {

    private List<SetmealDish> setmealDishes;

    private String categoryName;
}
