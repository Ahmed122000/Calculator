# Calculator

A simple yet powerful Java-based calculator application designed to perform basic arithmetic operations with a clean and intuitive interface.

## 📋 Table of Contents

- [Features](#features)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Usage](#usage)
- [Project Structure](#project-structure)
- [Building the Project](#building-the-project)
- [Testing](#testing)
- [License](#license)

## ✨ Features

- **Basic Arithmetic Operations**: Addition, subtraction, multiplication, and division
- **User-Friendly Interface**: Simple and intuitive design
- **Java Implementation**: Built with Java 17 for modern language features
- **Unit Testing**: Comprehensive test suite using JUnit 5
- **Maven Build System**: Easy dependency management and project building

## 📦 Prerequisites

Before you begin, ensure you have the following installed on your system:

- **Java Development Kit (JDK)**: Version 17 or higher
  - Download from [oracle.com](https://www.oracle.com/java/technologies/downloads/) or use [OpenJDK](https://openjdk.java.net/)
- **Maven**: Version 3.6.0 or higher
  - Download from [maven.apache.org](https://maven.apache.org/download.cgi)
  - Or use your package manager:
    ```bash
    # macOS (Homebrew)
    brew install maven

    # Ubuntu/Debian
    sudo apt-get install maven

    # Windows (Chocolatey)
    choco install maven
    ```

## 🚀 Installation

1. **Clone the repository**:
   ```bash
   git clone https://github.com/Ahmed122000/Calculator.git
   cd Calculator
   ```

2. **Verify Java and Maven installation**:
   ```bash
   java -version
   mvn -version
   ```

## 💻 Usage

### Running the Application

1. **Build the project**:
   ```bash
   mvn clean package
   ```

2. **Run the calculator**:
   ```bash
   mvn exec:java -Dexec.mainClass="org.example.Calculator"
   ```

   Or execute the JAR file directly:
   ```bash
   java -jar target/tempCalc-1.0-SNAPSHOT.jar
   ```

### Example Usage

```bash
# Follow the on-screen prompts to enter:
# - First number
# - Operation (+, -, *, /)
# - Second number
# - View the result
```

## 📂 Project Structure

```
Calculator/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── org/
│   │           └── example/
│   │               └── Calculator.java          # Main calculator implementation
│   └── test/
│       └── java/
│           └── org/
│               └── example/
│                   └── CalculatorTest.java      # Unit tests
├── pom.xml                                      # Maven configuration
├── LICENSE                                      # MIT License
├── .gitignore                                   # Git ignore rules
└── README.md                                    # This file
```

## 🔨 Building the Project

### Clean Build

```bash
mvn clean install
```

### Skip Tests

```bash
mvn clean package -DskipTests
```

### Build and Run

```bash
mvn clean package
mvn exec:java -Dexec.mainClass="org.example.Calculator"
```

## 🧪 Testing

The project uses **JUnit 5** for unit testing.

### Run all tests:
```bash
mvn test
```

### Run specific test class:
```bash
mvn test -Dtest=CalculatorTest
```

### Run tests with coverage:
```bash
mvn clean test
```

## 🛠️ Technologies & Dependencies

- **Java 17**: Modern Java language features
- **Maven 3.x**: Build automation and dependency management
- **JUnit 5**: Unit testing framework
- **MIT License**: Open source license

## 📝 Configuration

The project is configured with the following settings in `pom.xml`:

- **Java Compiler Source/Target**: Java 17
- **Source Encoding**: UTF-8
- **Test Framework**: JUnit Jupiter 5.10.0
- **Build Plugins**: Maven Surefire Plugin for test execution

## 🤝 Contributing

Contributions are welcome! To contribute:

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 👨‍💻 Author

**Ahmed122000**
- GitHub: [@Ahmed122000](https://github.com/Ahmed122000)

## 📞 Support

If you encounter any issues or have questions:

1. Check the existing [Issues](https://github.com/Ahmed122000/Calculator/issues) on GitHub
2. Create a new issue with a detailed description of the problem
3. Include steps to reproduce and expected/actual behavior

## 🗺️ Roadmap

- [ ] Add more advanced mathematical operations (power, square root, etc.)
- [ ] Implement a graphical user interface (GUI)
- [ ] Add support for complex numbers
- [ ] History tracking for calculations
- [ ] Configuration file for custom settings

---

**Happy Calculating!** 🧮
