insert into address (id, address_line1, address_line2, city, postal_code)
            values (901, 'xx', 'yy', 'city', '60-400');
insert into address (id, address_line1, address_line2, city, postal_code)
            values (902, 'xxx', 'yyy', 'city', '60-400');
insert into patient (id, first_name, last_name, telephone_number, email, patient_number, date_of_birth)
            values (100, 'Di', 'Di', '987654321', 'didi@pacjent.pl', '13', '2001-01-01');
insert into doctor (id, first_name, last_name, telephone_number, email, doctor_number, specialization)
            values (111, 'Da', 'Da', '123456789', 'dada@pacjent.pl', '7', 'GP');
insert into visit (id, description, time, doctor_id, patient_id)
            values (100, 'Wizyta kontrolna', '2025-06-16 08:30:00', 111, 100);
insert into visit (id, description, time, doctor_id, patient_id)
            values (101, 'Wizyta kontrolna', '2025-06-16 10:00:00', 111, 100);
insert into medical_treatment (id, description, type, visit_id)
            values (100, 'Wizyta kontrolna', 'USG', 100);
insert into patient_to_address (patient_id, address_id)
            values (100, 901);
insert into doctor_to_address (doctor_id, address_id)
            values (111, 902);