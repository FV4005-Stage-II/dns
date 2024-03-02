package com.example.dns.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.json.JSONObject;

import java.lang.reflect.Field;

@Schema(description = "сущность техника")
@Data
public class DeviceDto {


    @Schema(description = "название техники", example = "Пылесос", required = true)
    private String name;

    @Schema(description = "Страна производителя", example = "Россия", required = true)
    private String manufacturerCountry;

    @Schema(description = "Страна компании", example = "Байкал", required = true)
    private String manufacturerCompany;

    @Schema(description = "Доступность онлайн заказа", example = "true", required = true)
    private boolean onlineOrderAvailable;

    @Schema(description = "Доступность оплаты в рассрочку", example = "true", required = true)
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
