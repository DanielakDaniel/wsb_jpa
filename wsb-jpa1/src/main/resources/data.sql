insert into address (id, address_line1, address_line2, city, postal_code)
            values (901, 'xx', 'yy', 'city', '60-400');
insert into address (id, address_line1, address_line2, city, postal_code)
            values (902, 'xxx', 'yyy', 'city', '60-400');
insert into patient (id, first_name, last_name, telephone_number, email, patient_number, date_of_birth)
            values (1, 'Di', 'Di', '987654321', 'didi@pacjent.pl', '13', '2001-01-01');
insert into doctor (id, first_name, last_name, telephone_number, email, doctor_number, specialization)
            values (11, 'Da', 'Da', '123456789', 'dada@pacjent.pl', '7', 'GP');
insert into visit (id, description, time, doctor_id, patient_id)
            values (1, 'Wizyta kontrolna', '2025-06-16 08:30:00', 11, 1);
insert into visit (id, description, time, doctor_id, patient_id)
            values (2, 'Wizyta kontrolna', '2025-06-16 10:00:00', 11, 1);
insert into medical_treatment (id, description, type, visit_id)
            values (1, 'Wizyta kontrolna', 'USG', 1);
insert into patient_to_address (patient_id, address_id)
            values (1, 901);
insert into doctor_to_address (doctor_id, address_id)
            values (11, 902);