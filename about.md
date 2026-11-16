# About Billing Management System

## Project Overview
The **Billing Management System (BMS)** is a desktop point-of-sale and retail administration tool designed with Java Swing and MySQL. It aims to simplify in-store transactions, customer records, inventory tracking, and invoice printing for retail stores.

---

## Architectural Highlights

### 1. User Interface Layer (`gui`)
- Built using Java Swing with NetBeans forms and FlatLaf theme support (`FlatMacLightLaf`).
- Includes collapsible toolbar navigation in the home view.
- Real-time cart calculations and tabular data presentation via `JTable`.

### 2. Database Connectivity Layer (`database`)
- Manages single-instance JDBC connections to MySQL.
- Securely reads configurations via `db.properties` or environment variables (`DB_URL`, `DB_USER`, `DB_PASSWORD`), preventing hardcoded credentials in source control.

### 3. Reporting & Document Export Layer (`reports`)
- Uses iText PDF library to generate printable invoices with buyer information, itemized breakdowns, totals, and timestamps.
- Integrates Apache PDFBox for direct hardware printing.
- Custom logging via `MyLogger` to monitor operations and catch runtime errors.

---

## Key Modules

- **Authentication:** Restricts application access to authorized staff members.
- **Customer / Buyer Records:** Supports registration, phone number lookups, detail updates, and record removal.
- **Product Catalog:** Handles inventory registration, unit pricing, descriptions, and active status toggling.
- **POS & Billing Desk:** Real-time billing counter with automated product fetching, customer matching, line-item subtotaling, paid change calculation, and receipt generation.

---

## Author
- Developed by **Thilanka Kalhara**
- Repository: [Billing-Management-System](https://github.com/Thilankalhara/Billing-Management-System)
