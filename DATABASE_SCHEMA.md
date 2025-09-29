# Leave Management Database Schema

# Employee Table

| Column     | Type        | Constraints                 |
|------------|-------------|-----------------------------|
| id         | BIGINT      | Primary Key, Auto-Increment |
| name       | VARCHAR(255)| NOT NULL                    |
| email      | VARCHAR(255)| UNIQUE, NOT NULL            |
| department | VARCHAR(255)| NOT NULL                    |

# LeaveRequest Table

| Column      | Type        | Constraints                  |
|-------------|-------------|------------------------------|
| id          | BIGINT      | Primary Key, Auto-Increment  |
| employee_id | BIGINT      | Foreign Key → Employee(id)   |
| start_date  | DATE        | NOT NULL                     |
| end_date    | DATE        | NOT NULL                     |
| reason      | VARCHAR(255)| NULL                         |
| status      | VARCHAR(20) | Default = PENDING(PENDING, APPROVED, REJECTED)   |
