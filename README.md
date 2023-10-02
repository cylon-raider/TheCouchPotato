# TheCouchPotato.com

![Logo](src/main/resources/static/images/couchpotato.png)

## Overview

TheCouchPotato.com is an e-commerce platform meticulously crafted to be a comprehensive solution for consumers in search of products that amplify their comfort and relaxation. The platform is committed to delivering a seamless, user-friendly interface, fortified transactions, and a diverse array of comfort products, all while championing sustainable and ethically sourced products. This endeavor is designed with a responsive framework ensuring compatibility across a multitude of devices, offering users an efficient and secure shopping experience. While the recommendation engine is reserved for future enhancement, the core functionalities promise robust performance, ensuring satisfaction and reliability for all users.

## Table of Contents

- [Features](#features)
- [Technology Stack](#technology-stack)
- [Installation](#installation)
- [How to Run](#how-to-run)
- [Screenshots](#screenshots)
- [API Documentation](#api-documentation)
- [License](#license)

## Features

- **User Registration and Authentication**
- **Product Browsing**
- **Shopping Cart Management**
- **Category Management**

## Technology Stack

- **Frontend**: Spring Boot Thymleaf templates
- **Backend**: Spring Boot
- **Database**: MySQL
- **Version Control**: Git
- **API Documentation**: Javadoc
- **Deployment**: MAMP (local development), Cloud-based server (future implementation)

## Installation

Before starting the installation, ensure you have MAMP or any other local server environment installed on your machine.

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/cylon-raider/TheCouchPotato.git
   cd TheCouchPotato
   ```

## How to Run

Ensure your MAMP or other local server environment is running before proceeding.

### Start the Application Server

You can use Maven to run the application from the command line. This command will compile the code, package it into a JAR file, and run the JAR file.

```bash
mvn clean install
mvn spring-boot:run
```

### Access the Application

Open your web browser and navigate to [http://localhost:8080](http://localhost:8080).

## Screenshots

![Homepage Screenshot](<PLACEHOLDER FOR HOMEPAGE SCREENSHOT>)
![Product Page Screenshot](<PLACEHOLDER FOR PRODUCT PAGE SCREENSHOT>)

## API Documentation

The API is thoroughly documented using Javadocs. You can view the API documentation by following the steps below:

### Online Documentation

[View API Documentation](documents/Javadoc)

### Generating Javadocs Locally

1. Ensure you are in the project directory.
2. Run the following command to generate Javadocs:

```bash
mvn javadoc:javadoc
```

After running the above command, the generated Javadocs can be found in the `target/site/apidocs/` directory. Open the `index.html` file in a web browser to view the documentation.


## License

Copyright (c) 2023 Chris Markel
Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the “Software”), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED “AS IS”, WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

   
