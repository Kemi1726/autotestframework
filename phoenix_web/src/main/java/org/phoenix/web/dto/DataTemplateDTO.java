package org.phoenix.web.dto;

import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by Kemi on 2017/9/23.
 * Description:
 */
public class DataTemplateDTO {
    private int id;
    private String name;
    private String type;
    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @NotBlank(message = "名称不能为空")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotBlank(message = "类型不能为空")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
