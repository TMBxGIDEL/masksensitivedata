# Mask Sensitive Data

## Overview

**Mask Sensitive Data** is a Java library designed to mask sensitive information such as personally identifiable information (PII) and payment card industry (PCI) data in logs. The project is built using **Spring Boot** and **Log4j2**, ensuring seamless integration with Java applications.

## Features

- **Automatic Masking**: Supports masking of sensitive fields in logs.
- **Spring Boot Integration**: Easily integrates with Spring Boot applications.
- **Mask Sensitive Date in logs**
- **_Supports masking of_**:
  - Credit/Debit Card Numbers
  - Social Security Numbers (SSN)
  - Email Addresses
  - Phone Numbers
- **Logging Support**: Works with Log4j2 for structured and secure logging.

## IMPORTANT CONFIGURATION

### Exclude Spring Boot Default Logging (Logback)

```
<exclusions>
    <exclusion>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-logging</artifactId>
    </exclusion>
</exclusions>
```

## Installation

To use the **Mask Sensitive Data** library in your Maven project, add the following dependency to your `pom.xml`:

```xml
<dependency>
    <groupId>io.github.tmbxgidel</groupId>
    <artifactId>mask-sensitive-data</artifactId>
    <version>1.0.0-alpha</version>
</dependency>
```

## Usage

### Masking Sensitive Fields

To enable automatic masking, configure Log4j2 and specify the fields to mask.

## Building & Running

To build the project, use Maven:

```sh
mvn clean install
```

To run tests:

```sh
mvn test
```

## Project Structure

```
src/
├── main/
│ ├── java/
│ │ ├── com/
│ │ │ ├── tmbxgidel/
│ │ │ │ ├── masksensitivedata/
│ │ │ │ │ ├── annotations/
│ │ │ │ │ │ └── MaskSensitive.java
│ │ │ │ │ ├── configuration/
│ │ │ │ │ │ └── MaskSensitiveConfig.java
│ │ │ │ │ ├── enums/
│ │ │ │ │ │ └── MaskType.java
│ │ │ │ │ └── utils/
│ │ │ │ │ ├── MaskSensitiveDataUtils.java
│ │ │ │ │ └── SensitiveDataSerializer.java
│ └── resources/
│ └── log4j2.xml
└── test/
├── java/
│ └── com/
│ └── tmbxgidel/
│ └── masksensitivedata/
│ └── MaskSensitiveDataTest.java
└── resources/
```

## Future Features

The following features are planned for future releases:

- **Enhanced Dynamic Masking**: More advanced runtime configurations for masking rules.
- **Custom Masking Patterns**: Allow users to define complex regex-based masking rules.
- **Integration with External Configurations**: Support for configuring masking rules via external properties files or databases.
- **Improved Performance**: Optimizations for faster and more efficient data masking.
- **Expanded Logging Support**: Compatibility with additional logging frameworks beyond Log4j2.

## Contributing

Contributions are welcome! Feel free to submit a pull request or open an issue in the [GitHub repository](https://github.com/TMBxGIDEL/masksensitivedata).

## License

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an **_"AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,_** either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

Licensed under the **Apache License 2.0**. See the [LICENSE](http://www.apache.org/licenses/LICENSE-2.0) file for details.

## Contact

For any inquiries, please open an issue on GitHub or reach out via [GitHub Discussions](https://github.com/TMBxGIDEL/masksensitivedata/discussions).
