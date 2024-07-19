CREATE TABLE IF NOT EXISTS employee (
    id INT PRIMARY KEY,
    name VARCHAR(255),
    email VARCHAR(255),
    phone INT,
    matricule INT,
    department VARCHAR(255)
    );

INSERT INTO employee (id, name, email, phone, matricule, department)
SELECT 1, 'admin', 'rabii.benkhlifa@esprit.tn', 58362749, 12304, 'RH'
    WHERE NOT EXISTS (SELECT 1 FROM employee WHERE id = 1);