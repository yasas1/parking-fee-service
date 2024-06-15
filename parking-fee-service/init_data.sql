INSERT INTO public.parking_city(name)
VALUES ('Colombo'),
       ('Kandy');

INSERT INTO public.public_holiday(date, year)
VALUES ('2024-04-15', 2024),
       ('2024-05-23', 2024),
       ('2024-05-24', 2024),
       ('2024-06-21', 2024);

INSERT INTO public.weekdays_parking_fee_rule(city, start_time, end_time, amount)
VALUES (1, '00:00', '06:00', 0.00),
       (1, '06:00', '10:00', 100.00),
       (1, '10:00', '12:00', 80.00),
       (1, '12:00', '14:00', 100.00),
       (1, '14:00', '17:00', 50.00),
       (1, '17:00', '22:00', 120.00),
       (1, '22:00', '24:00', 0.00);


INSERT INTO public.parked_data(city, vehicle_number, date, start_time, end_time)
VALUES (1, 'wp-123-456', '2024-05-01', '07:15', '17:10'),
       (1, 'wp-123-456', '2024-05-02', '06:45', '17:30'),
       (1, 'wp-123-456', '2024-05-03', '07:30', '12:30'),
       (1, 'wp-123-456', '2024-05-03', '13:45', '18:30'),
       (1, 'wp-123-456', '2024-05-04', '10:00', '20:10'),
       (1, 'wp-123-456', '2024-05-23', '10:00', '20:10');

INSERT INTO public.vehicle_monthly_subscription(vehicle_number)
VALUES ('wp-177-356'),
       ('wp-481-311'),
       ('wp-692-588');