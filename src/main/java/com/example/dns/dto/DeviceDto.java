package com.example.dns.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.json.JSONObject;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.lang.reflect.Field;

@Schema(description = "сущность техника")
@Data
public class DeviceDto {


    @Schema(description = "название техники", example = "Пылесос", required = true)
    @NotBlank(message = "name не должно быть пустым полем")
    private String name;

    @Schema(description = "Страна производителя", example = "Россия", required = true)
    @NotBlank(message = "manufacturerCountry не должно быть пустым полем")
    private String manufacturerCountry;

    @Schema(description = "Страна компании", example = "Байкал", required = true)
    @NotBlank(message = "manufacturerCompany не должно быть пустым полем")
    private String manufacturerCompany;

    @Schema(description = "Доступность онлайн заказа", example = "true", required = true)
    @NotNull(message = "onlineOrderAvailable не должно быть пустым полем")
    private boolean onlineOrderAvailable;

    @Schema(description = "Доступность оплаты в рассрочку", example = "true", required = true)
    @NotNull(message = "installmentAvailable не должно быть пустым полем")
    private boolean installmentAvailable;


    public static String toJson() throws Exception {
        Field[] fields = DeviceDto.class.getDeclaredFields();
        JSONObject jo = new JSONObject();

        for (Field field : fields) {
            if (java.lang.reflect.Modifier.isStatic(field.getModifiers())) {
                continue;
            }
            jo.put(field.getName(),
                    field.getType().toString().substring(field.getType().toString().lastIndexOf('.') + 1));
        }
        return jo.toString();
//        String staticFolderPath = new ClassPathResource("com/example/dns").getFile().getPath();
//        String filePath = staticFolderPath + "/example.json";
//        try (FileWriter fileWriter = new FileWriter(filePath)) {
//            fileWriter.write(jo.toString());
//        } catch (IOException e) {
//            e.printStackTrace();
//            throw new IOException("Error writing JSON to file", e);
//        }
    }
}
