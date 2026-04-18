-- Hospital Management System - Sample Data
-- Aligned with the actual entity model (Patient, Doctor, Appointment, Prescription, PrescriptionDetail)

-- =====================
-- PATIENTS TABLE
-- =====================
INSERT INTO patients (id, full_name, email, dob, phone, gender, address, insurance_number, created_at) VALUES
(1, 'John Smith', 'john.smith@email.com', '1975-03-15', '555-2001', true, '123 Main St, Springfield, IL 12345', 'INS-001-2024', NOW()),
(2, 'Maria Garcia', 'maria.garcia@email.com', '1982-07-22', '555-2002', false, '456 Oak Ave, Springfield, IL 12346', 'INS-002-2024', NOW()),
(3, 'Robert Johnson', 'robert.johnson@email.com', '1960-11-08', '555-2003', true, '789 Pine Rd, Springfield, IL 12347', 'INS-003-2024', NOW()),
(4, 'Susan Williams', 'susan.williams@email.com', '1990-05-14', '555-2004', false, '321 Elm St, Springfield, IL 12348', 'INS-004-2024', NOW()),
(5, 'James Brown', 'james.brown@email.com', '1978-09-30', '555-2005', true, '654 Maple Dr, Springfield, IL 12349', 'INS-005-2024', NOW()),
(6, 'Patricia Davis', 'patricia.davis@email.com', '1985-01-25', '555-2006', false, '987 Cedar Ln, Springfield, IL 12350', 'INS-006-2024', NOW()),
(7, 'Michael Martinez', 'michael.martinez@email.com', '1992-06-12', '555-2007', true, '147 Birch St, Springfield, IL 12351', 'INS-007-2024', NOW()),
(8, 'Linda Taylor', 'linda.taylor@email.com', '1965-12-03', '555-2008', false, '258 Spruce Ave, Springfield, IL 12352', 'INS-008-2024', NOW()),
(9, 'William Anderson', 'william.anderson@email.com', '1988-04-18', '555-2009', true, '369 Walnut Rd, Springfield, IL 12353', 'INS-009-2024', NOW()),
(10, 'Jennifer Thomas', 'jennifer.thomas@email.com', '1995-08-27', '555-2010', false, '741 Ash Dr, Springfield, IL 12354', 'INS-010-2024', NOW()),
(11, 'Charles Jackson', 'charles.jackson@email.com', '1970-02-14', '555-2011', true, '852 Oak St, Springfield, IL 12355', 'INS-011-2024', NOW()),
(12, 'Dorothy White', 'dorothy.white@email.com', '1980-10-21', '555-2012', false, '963 Pine Ave, Springfield, IL 12356', 'INS-012-2024', NOW()),
(13, 'David Harris', 'david.harris@email.com', '1987-07-09', '555-2013', true, '135 Elm Rd, Springfield, IL 12357', 'INS-013-2024', NOW()),
(14, 'Nancy Martin', 'nancy.martin@email.com', '1993-03-05', '555-2014', false, '246 Maple St, Springfield, IL 12358', 'INS-014-2024', NOW()),
(15, 'Joseph Clark', 'joseph.clark@email.com', '1962-11-19', '555-2015', true, '357 Cedar Dr, Springfield, IL 12359', 'INS-015-2024', NOW());

-- =====================
-- DOCTORS TABLE
-- =====================
INSERT INTO doctors (id, full_name, email, dob, phone, years_of_experience, status, created_at, updated_at) VALUES
(1, 'Dr. James Anderson', 'james.anderson@hospital.com', '1968-03-15', '555-1001', 15, 'ACTIVE', NOW(), NOW()),
(2, 'Dr. Sarah Mitchell', 'sarah.mitchell@hospital.com', '1975-07-22', '555-1002', 12, 'ACTIVE', NOW(), NOW()),
(3, 'Dr. Michael Chen', 'michael.chen@hospital.com', '1978-11-08', '555-1003', 10, 'ACTIVE', NOW(), NOW()),
(4, 'Dr. Emily Rodriguez', 'emily.rodriguez@hospital.com', '1982-05-14', '555-1004', 8, 'ACTIVE', NOW(), NOW()),
(5, 'Dr. David Thompson', 'david.thompson@hospital.com', '1965-09-30', '555-1005', 14, 'ACTIVE', NOW(), NOW()),
(6, 'Dr. Lisa Kumar', 'lisa.kumar@hospital.com', '1973-01-25', '555-1006', 11, 'ACTIVE', NOW(), NOW()),
(7, 'Dr. Robert Williams', 'robert.williams@hospital.com', '1962-12-03', '555-1007', 16, 'ACTIVE', NOW(), NOW()),
(8, 'Dr. Patricia Brown', 'patricia.brown@hospital.com', '1970-04-18', '555-1008', 13, 'INACTIVE', NOW(), NOW()),
(9, 'Dr. Christopher Garcia', 'christopher.garcia@hospital.com', '1980-07-09', '555-1009', 9, 'ACTIVE', NOW(), NOW()),
(10, 'Dr. Jessica Lee', 'jessica.lee@hospital.com', '1985-03-05', '555-1010', 7, 'SUSPENDED', NOW(), NOW());

-- =====================
-- APPOINTMENTS TABLE
-- =====================
INSERT INTO appointments (id, doctor_id, patient_id, appointment_time, status, reason, created_at) VALUES
(1, 1, 1, '2024-01-15 09:00:00', 'COMPLETED', 'Chest pain evaluation', NOW()),
(2, 3, 2, '2024-01-15 10:30:00', 'COMPLETED', 'Routine checkup', NOW()),
(3, 1, 3, '2024-01-16 14:00:00', 'COMPLETED', 'Follow-up cardiology visit', NOW()),
(4, 4, 4, '2024-01-17 08:00:00', 'COMPLETED', 'Asthma management review', NOW()),
(5, 7, 5, '2024-01-17 11:00:00', 'SCHEDULED', 'Pre-operative consultation', NOW()),
(6, 2, 6, '2024-01-18 15:30:00', 'COMPLETED', 'Migraine treatment', NOW()),
(7, 5, 7, '2024-01-19 09:30:00', 'SCHEDULED', 'Orthopedic consultation', NOW()),
(8, 5, 8, '2024-01-19 13:00:00', 'SCHEDULED', 'Arthritis follow-up', NOW()),
(9, 1, 9, '2024-01-20 10:00:00', 'COMPLETED', 'Blood pressure check', NOW()),
(10, 2, 10, '2024-01-20 14:30:00', 'COMPLETED', 'Anxiety management', NOW()),
(11, 1, 11, '2024-01-22 09:00:00', 'COMPLETED', 'Cholesterol management', NOW()),
(12, 2, 12, '2024-01-22 11:00:00', 'SCHEDULED', 'Thyroid function test', NOW()),
(13, 3, 13, '2024-01-23 08:30:00', 'SCHEDULED', 'Annual physical examination', NOW()),
(14, 4, 14, '2024-01-23 16:00:00', 'CANCELLED', 'Asthma review (rescheduled)', NOW()),
(15, 7, 15, '2024-01-24 10:00:00', 'SCHEDULED', 'Pre-op assessment', NOW());

-- =====================
-- PRESCRIPTIONS TABLE
-- =====================
INSERT INTO prescriptions (id, appointment_id, diagnosis, notes, created_at) VALUES
(1, 1, 'Hypertension', 'Patient advised to reduce salt intake and monitor BP regularly', NOW()),
(2, 2, 'Type 2 Diabetes', 'Blood work ordered, needs diet consultation', NOW()),
(3, 3, 'Coronary Artery Disease', 'Stable angina, schedule stress test in 6 months', NOW()),
(4, 4, 'Acute Asthma Attack', 'Trigger identified as pollen exposure, preventive measures recommended', NOW()),
(5, 5, 'Acute Appendicitis', 'Surgery scheduled for February 1st, patient fasting required', NOW()),
(6, 6, 'Migraine Disorder', 'Preventive therapy and pain management plan discussed', NOW()),
(7, 7, 'Knee Osteoarthritis', 'Physical therapy 3x/week for 8 weeks recommended', NOW()),
(8, 8, 'Chronic Arthritis', 'Continue current pain management, PT follow-up', NOW()),
(9, 9, 'Essential Hypertension', 'BP control good, continue current antihypertensive medication', NOW()),
(10, 10, 'Anxiety Disorder', 'Therapy referral given, consider cognitive behavioral therapy', NOW()),
(11, 11, 'Hyperlipidemia', 'Elevated cholesterol, dietary management and statin therapy', NOW()),
(12, 12, 'Thyroid Dysfunction', 'Lab work pending, recheck TSH levels', NOW()),
(13, 13, 'Annual Physical', 'Vaccination update pending, all vitals normal', NOW()),
(14, 15, 'Herniated Disc L4-L5', 'MRI confirms herniation, surgery scheduled for March 15th', NOW());

-- =====================
-- PRESCRIPTION_DETAILS TABLE
-- =====================
INSERT INTO prescription_details (id, prescription_id, medicine_name, dosage, frequency) VALUES
-- Prescription 1: Hypertension
(1, 1, 'Lisinopril', '10mg', 'Once daily in morning'),
(2, 1, 'Amlodipine', '5mg', 'Once daily at night'),

-- Prescription 2: Type 2 Diabetes
(3, 2, 'Metformin', '500mg', 'Twice daily with meals'),
(4, 2, 'Glipizide', '5mg', 'Once daily before breakfast'),

-- Prescription 3: Coronary Artery Disease
(5, 3, 'Atorvastatin', '20mg', 'Once daily at night'),
(6, 3, 'Aspirin', '81mg', 'Once daily'),
(7, 3, 'Nitroglycerin', 'sublingual spray', 'As needed for chest pain'),

-- Prescription 4: Asthma
(8, 4, 'Albuterol', 'inhaler', 'As needed for acute symptoms'),
(9, 4, 'Fluticasone', 'inhaler 110mcg', 'Twice daily for maintenance'),

-- Prescription 5: Appendicitis
(10, 5, 'Cefotaxime', '1g IV', 'Every 8 hours pre-op'),

-- Prescription 6: Migraine
(11, 6, 'Sumatriptan', '100mg', 'As needed for migraine (max 2 per week)'),
(12, 6, 'Topiramate', '50mg', 'Once daily for prevention'),

-- Prescription 7: Knee Arthritis
(13, 7, 'Ibuprofen', '400mg', 'Three times daily with food'),
(14, 7, 'Glucosamine Sulfate', '500mg', 'Three times daily'),

-- Prescription 8: Chronic Arthritis
(15, 8, 'Naproxen', '500mg', 'Twice daily with food'),
(16, 8, 'Celecoxib', '200mg', 'Once daily'),

-- Prescription 9: Hypertension
(17, 9, 'Amlodipine', '5mg', 'Once daily'),

-- Prescription 10: Anxiety
(18, 10, 'Sertraline', '50mg', 'Once daily'),
(19, 10, 'Lorazepam', '0.5mg', 'Twice daily as needed'),

-- Prescription 11: Hyperlipidemia
(20, 11, 'Atorvastatin', '10mg', 'Once daily at night'),
(21, 11, 'Ezetimibe', '10mg', 'Once daily'),

-- Prescription 12: Thyroid
(22, 12, 'Levothyroxine', '75mcg', 'Once daily in morning on empty stomach'),

-- Prescription 13: Annual Physical
(23, 13, 'Multivitamin', '1 tablet', 'Once daily with breakfast'),

-- Prescription 14: Herniated Disc
(24, 14, 'Naproxen', '500mg', 'Twice daily with food'),
(25, 14, 'Muscle Relaxant (Cyclobenzaprine)', '5mg', 'Three times daily');

-- =====================
-- VERIFICATION QUERIES
-- =====================

-- Show summary of data
SELECT 'PATIENTS' as category, COUNT(*) as count FROM patients
UNION ALL
SELECT 'DOCTORS' as category, COUNT(*) as count FROM doctors
UNION ALL
SELECT 'APPOINTMENTS' as category, COUNT(*) as count FROM appointments
UNION ALL
SELECT 'PRESCRIPTIONS' as category, COUNT(*) as count FROM prescriptions
UNION ALL
SELECT 'PRESCRIPTION_DETAILS' as category, COUNT(*) as count FROM prescription_details;

-- Show appointments with doctor and patient names
SELECT 
    a.id,
    d.full_name as doctor_name,
    p.full_name as patient_name,
    a.appointment_time,
    a.status,
    a.reason
FROM appointments a
JOIN doctors d ON a.doctor_id = d.id
JOIN patients p ON a.patient_id = p.id
ORDER BY a.appointment_time DESC;

-- Show prescriptions with medication details
SELECT 
    p.id as prescription_id,
    a.reason as appointment_reason,
    p.diagnosis,
    pd.medicine_name,
    pd.dosage,
    pd.frequency
FROM prescriptions p
JOIN appointments a ON p.appointment_id = a.id
JOIN prescription_details pd ON p.id = pd.prescription_id
ORDER BY p.id, pd.id;
