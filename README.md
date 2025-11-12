# Google Form Automation using Java, Selenium & TestNG

This project automates the process of filling and submitting a Google Form using **Java**, **Selenium WebDriver**, and **TestNG**.  
The script interacts with multiple form components such as text inputs, textareas, checkboxes, radio buttons, date & time pickers, and finally submits the form.  
The project follows a **clean wrapper-based design** to keep the code maintainable and readable.

---

## 🚀 Features

- Automates full Google Form submission.
- Uses **wrapper utility methods** for reusability.
- Handles dynamic elements using **explicit waits**.
- Interacts with:
  - Text input fields
  - Textarea fields
  - Checkbox & multi-select options
  - Radio button selections
  - Date and time input controls
- Uses **TestNG** for structured test execution and reporting.
- Build managed using **Gradle**.

---

## 🛠️ Tech Stack

| Tool / Library | Purpose |
|----------------|---------|
| Java (JDK 11+) | Programming Language |
| Selenium WebDriver | Browser Automation |
| TestNG | Test Execution & Reporting |
| Gradle | Dependency & Build Management |
| ChromeDriver | Controls the Chrome Browser |

---

## 📁 Project Structure
```
src
 └── test
     ├── java
     │   └── demo
     │       ├── TestCases.java
     │       └── wrappers
     │           └── Wrappers.java
     └── resources
         └── testng.xml
```
---

## ▶️ How to Run the Tests

### **1. Clone the repository**
```
git clone https://github.com/nabarun02/GOOGLE_FORM_AUTOMATION.git
cd GOOGLE_FORM_AUTOMATION
```

### **2. Run tests using Gradle**
```
./gradlew test # Mac / Linux
gradlew.bat test # Windows
```

### **3. View Test Report**
```
After execution, open:
build/reports/tests/test/index.html
```
---

## 🧩 Key Automation Concepts Used

- **WebDriverWait & ExpectedConditions** to handle dynamic UI behavior
- **XPath based locators** for precise element identification
- **Reusable Wrappers** to avoid code duplication
- **Timestamp-based input** to ensure uniqueness in submissions

---

## ✨ Example Output
```
After submission, the script prints the success message returned by the form:
Message after form submission: Thanks for your response, Automation Wizard!
```
---

## 🤝 Contributing

Feel free to fork this project and enhance the wrapper methods / add more test scenarios.

---

## 📜 License

This project is for educational & automation practice purposes.

