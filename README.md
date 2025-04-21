# 🧪 REST Assured API Testing Framework

This repository provides a comprehensive API testing framework using **REST Assured**. It is designed to validate the functionality, security, and reliability of RESTful APIs — including endpoints secured with JWT tokens.

---

## 📌 Overview

This test suite covers:

- 🔐 **JWT Token Authentication**: Automated login and dynamic token injection
- 🔍 **Endpoint Testing**: Validates response status codes, bodies, and headers
- 🚫 **Negative Testing**: Handles invalid inputs and authentication failures
- 🧹 **Clean Architecture**: Organized, scalable, and readable test structure
- 🔁 **Reusable Methods**: Utility classes for common operations like token extraction

---

## 🧰 Technologies Used

| Tool           | Purpose                             |
|----------------|-------------------------------------|
| Java (11+)     | Primary programming language        |
| REST Assured   | HTTP client library for testing APIs|
| TestNG / JUnit | Test framework                      |
| Maven / Gradle | Dependency management & build       |
| JSON           | API request/response format         |

---

## 🚀 Getting Started

### ✅ Prerequisites

- Java JDK 11 or higher
- Maven or Gradle installed
- IDE (e.g., IntelliJ, Eclipse)

### 📦 Installation

Clone the repository:

```bash
git clone https://github.com/yourusername/rest-assured-jwt-tests.git
cd rest-assured-jwt-tests
