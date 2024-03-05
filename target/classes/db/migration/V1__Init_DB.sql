


INSERT INTO device (name, manufacturer_company, manufacturer_country, online_order_available, installment_available)
VALUES ('холодильник', 'Apple', 'США', true, false);

INSERT INTO device (name, manufacturer_company, manufacturer_country, online_order_available, installment_available)
VALUES ('смартфон', 'Samsung', 'Южная Корея', true, false);

INSERT INTO device (name, manufacturer_company, manufacturer_country, online_order_available, installment_available)
VALUES ('компьютер', 'Dell', 'США', true, true);


INSERT INTO public.model (name, serial_number, color, size, price, category, available, device_id)
VALUES
    ('Холодильник A', '123456', 'Белый', 'XL', 500.00, 'Домашний', true, 1),
    ('Холодильник B', '789012', 'Серый', 'L', 600.00, 'Домашний', true, 1),
    ('Холодильник C', '345678', 'Черный', 'M', 550.00, 'Домашний', true, 1);

INSERT INTO public.model (name, serial_number, color, size, price, category, available, device_id)
VALUES
    ('Смартфон A', '987654', 'Черный', 'S', 800.00, 'Мобильные устройства', true, 2),
    ('Смартфон B', '654321', 'Белый', 'M', 700.00, 'Мобильные устройства', true, 2),
    ('Смартфон C', '012345', 'Золотой', 'L', 900.00, 'Мобильные устройства', true, 2);

INSERT INTO public.model (name, serial_number, color, size, price, category, available, device_id)
VALUES
    ('Компьютер A', '456789', 'Серый', 'L', 1200.00, 'Настольные компьютеры', true, 3),
    ('Компьютер B', '234567', 'Черный', 'M', 1100.00, 'Настольные компьютеры', true, 3),
    ('Компьютер C', '890123', 'Белый', 'XL', 1300.00, 'Настольные компьютеры', true, 3);



INSERT INTO public.attribute_value (attribute, value, model_id)
VALUES
    ('Количество дверей', '2', 1),
    ('Тип компрессора', 'Напряжный', 1);

INSERT INTO public.attribute_value (attribute, value, model_id)
VALUES
    ('Память', '128 ГБ', 2),
    ('Количество камер', '3', 2);

INSERT INTO public.attribute_value (attribute, value, model_id)
VALUES
    ('Тип процессора', 'Intel Core i7', 1),
    ('Оперативная память', '16 ГБ', 1);